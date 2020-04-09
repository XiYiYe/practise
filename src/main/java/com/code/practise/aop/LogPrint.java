package com.code.practise.aop;

import com.code.practise.bean.LogBO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AOP打印请求的入参，出参，接口swagger描述以及请求执行时间
 */
@Slf4j
@Aspect
@Component
public class LogPrint {

    @Pointcut("execution(* com.code.practise.*.controller..*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogBO logBO = new LogBO();
        logBO.setClassName(joinPoint.getTarget().getClass().getName());
        logBO.setMethod(method.getName());
        if (method.isAnnotationPresent(ApiOperation.class)) {
            ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
            logBO.setDescription(apiOperation.value());
        }
        logBO.setParameter(getParameter(method, joinPoint.getArgs()));
        log.info("[enter:{}]", logBO);
        try {
            Object result = joinPoint.proceed();
            logBO.setResult(result);
            return result;
        } finally {
            logBO.setSpendTime(System.currentTimeMillis() - beginTime);
            log.info("[result:{}]", logBO);
        }

    }


    /**
     * 获取入参
     */
    private Object getParameter(Method method, Object[] args) {
        List<Object> argList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        int length = parameters.length;
        for (int i = 0; i < length; i++) {
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            if (requestParam != null) {
                Map<String, Object> map = new HashMap<>(8);
                String key = parameters[i].getName();
                if (StringUtils.isNotBlank(requestParam.value())) {
                    key = requestParam.value();
                }
                map.put(key, args[i]);
                argList.add(map);
            }
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (requestBody != null) {
                argList.add(args[i]);
            }
            if (requestBody == null && requestParam == null) {
                argList.add(args[i]);
            }
        }
        if (CollectionUtils.isEmpty(argList)) {
            return null;
        } else if (argList.size() == 1) {
            return argList.get(0);
        } else {
            return argList;
        }
    }

}
