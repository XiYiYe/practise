package com.code.dora.bean;

import lombok.Data;

/**
 * @author by Dora
 * @date 2022/1/24 10:30
 */
@Data
public class PageQuery implements Query {

    private Integer currentPage = 1;

    private Integer pageSize = currentPage;

    private Integer totalPage;

    private String orderBy;

    private Integer getStart() {
        if (currentPage <= 0) {
            return 0;
        } else {
            return (currentPage - 1) * pageSize;
        }
    }
}
