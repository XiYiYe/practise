package com.code.dora.bean;

import com.code.dora.constant.ResultCodeEnum;
import com.code.dora.constant.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * @author by Dora
 * @date 2022/1/24 11:32
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PageResult<T> extends Result<List<T>> {

    private Integer total;

    private Integer pageSize = Query.DEFAULT_PAGE_SIZE;

    private Integer totalPage;

    private Integer currentPage;

    public PageResult() {
        super();
    }

    public static <T> PageResult<T> getFailureResult() {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageSize(0);
        pageResult.setCurrentPage(0);
        pageResult.setTotal(0);
        pageResult.setCode(ResultCodeEnum.FAIL.getCode());
        pageResult.setMessage(ResultCodeEnum.FAIL.getMessage());
        pageResult.setData(Collections.emptyList());
        return pageResult;
    }

    public static <T> PageResult<T> getFailureResult(ResultCode resultCode) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageSize(0);
        pageResult.setCurrentPage(0);
        pageResult.setTotal(0);
        pageResult.setCode(resultCode.getCode());
        pageResult.setMessage(resultCode.getMessage());
        pageResult.setData(Collections.emptyList());
        return pageResult;
    }


    public static <T> PageResult<T> getSuccessResult(List<T> data) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageSize(0);
        pageResult.setCurrentPage(0);
        pageResult.setTotal(0);
        pageResult.setCode(ResultCodeEnum.SUCCESS.getCode());
        pageResult.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        pageResult.setData(data);
        return pageResult;
    }

    public static <T> PageResult<T> getSuccessResult(List<T> data, Integer total, Integer currentPage, Integer pageSize) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageSize(pageSize);
        pageResult.setCurrentPage(currentPage);
        pageResult.setTotal(total);
        pageResult.setCode(ResultCodeEnum.SUCCESS.getCode());
        pageResult.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        pageResult.setData(data);
        return pageResult;
    }
}
