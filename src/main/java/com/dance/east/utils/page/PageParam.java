package com.dance.east.utils.page;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PageParam {
    //datatable 的分页参数
    private Integer start ;
    private Integer length ;

    //easyui datagrid 的分页参数
    private Integer page;
    private Integer rows;



    private Map<String,Object> params = new HashMap<>();

    public void setParam(String paramName,String paramValue){
        params.put(paramName,paramValue);
    }

    public Integer getStartPage(){
        return start == null ? (page-1)*rows : start;
    }

    public Integer getRowLength(){
        return length == null ? rows : length;
    }
}
