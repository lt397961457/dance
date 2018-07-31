package com.dance.east.utils.page;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
//    private int draw;
    private int count;
    private int currentPage;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
}
