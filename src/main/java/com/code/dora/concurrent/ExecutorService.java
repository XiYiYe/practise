package com.code.dora.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@Service
@Slf4j
public class ExecutorService <V> {

    @Async(value = "taskExecutor")
    public void async(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception ex) {
            log.warn("线程池异常,", ex);
        }
    }

    @Async(value = "taskExecutor")
    public Future<V> async(Callable<V> callable) {
        try {
            return new AsyncResult<>(callable.call());
        } catch (Exception ex) {
            log.warn("线程池异常,", ex);
            throw new RuntimeException(ex.getMessage());
        }
    }


}
