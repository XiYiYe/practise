package com.code.dora.util;

import com.code.dora.bean.PageQuery;
import com.code.dora.bean.PageResult;
import com.code.dora.constant.ResultCodeEnum;
import com.code.dora.exception.CustomizedException;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * @author by Dora
 * @date 2022/1/24 11:31
 */
public class Pages {


    public static <T> PageResult<T> empty() {
        return PageResult.getSuccessResult(Collections.emptyList());
    }

    /**
     * 单页查询
     *
     * @param query         查询入参
     * @param totalFunction 查询记录数量
     * @param dataFunction  查询数据list
     * @param <T>           入参对象
     * @param <V>           出参对象
     * @return 分页结果
     */
    public static <T extends PageQuery, V> PageResult<V> of(T query, Function<T, Integer> totalFunction, Function<T,
            List<V>> dataFunction) {
        if (query == null) {
            return PageResult.getFailureResult(ResultCodeEnum.ILLEGAL_PARAM);
        }
        Integer count = totalFunction.apply(query);
        List<V> list = count > 0 ? dataFunction.apply(query) : Collections.emptyList();
        return PageResult.getSuccessResult(list, count, query.getCurrentPage(), query.getPageSize());
    }

    /**
     * @param query        查询入参
     * @param total        记录数量
     * @param dataFunction 查询数据list
     * @param <T>          入参对象
     * @param <V>          出参对象
     * @return 分页结果
     */
    public static <T extends PageQuery, V> PageResult<V> of(T query, Integer total, Function<T, List<V>> dataFunction) {
        if (query == null) {
            return PageResult.getFailureResult(ResultCodeEnum.ILLEGAL_PARAM);
        }
        List<V> list = total > 0 ? dataFunction.apply(query) : Collections.emptyList();
        return PageResult.getSuccessResult(list, total, query.getCurrentPage(), query.getPageSize());
    }

    /**
     * 单页查询
     *
     * @param query           查询入参
     * @param totalFunction   查询记录数量
     * @param dataFunction    查询数据list
     * @param convertFunction 出参转换函数
     * @param <T>             入参对象
     * @param <V>             数据库出参对象
     * @param <R>             转换后对象
     * @return 分页结果
     */
    public static <T extends PageQuery, V, R> PageResult<R> of(T query, Function<T, Integer> totalFunction,
                                                               Function<T, List<V>> dataFunction, Function<List<V>,
            List<R>> convertFunction) {
        if (query == null) {
            return PageResult.getFailureResult(ResultCodeEnum.ILLEGAL_PARAM);
        }
        Integer count = totalFunction.apply(query);
        List<V> list = count > 0 ? dataFunction.apply(query) : Collections.emptyList();
        List<R> convertList = convertFunction.apply(list);
        return PageResult.getSuccessResult(convertList, count, query.getCurrentPage(), query.getPageSize());
    }

    /**
     * 查询全部页
     *
     * @param query         入参
     * @param totalFunction 查询总页数
     * @param dataFunction  查询记录
     * @param <T>           入参对象
     * @param <V>           出参对象
     * @return 结果
     */
    public static <T extends PageQuery, V> List<V> queryAll(T query, Function<T, Integer> totalFunction, Function<T,
            List<V>> dataFunction) {
        List<V> dataList = new ArrayList<>();
        PageResult<V> pageResult = of(query, totalFunction, dataFunction);
        while (true) {
            if (pageResult == null || !pageResult.isSuccess()) {
                throw new CustomizedException(ResultCodeEnum.FAIL);
            }
            List<V> data = pageResult.getData();
            if (!CollectionUtils.isEmpty(data)) {
                dataList.addAll(data);
            }
            if (CollectionUtils.isEmpty(data) || data.size() < query.getPageSize()) {
                break;
            }
            query.setCurrentPage(query.getCurrentPage() + 1);
            pageResult = of(query, pageResult.getTotal() - data.size(), dataFunction);
        }
        return dataList;
    }


}
