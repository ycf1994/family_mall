package com.family.mall.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResultVO<T> implements Serializable {
    private List<T> resultList;
    private Integer total;
    private Integer pageIndex;
    private Integer pageSize;
    private Boolean hasMore;
}
