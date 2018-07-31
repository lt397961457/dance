package com.dance.east.utils.page;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PageParam {
    private Integer length = 100;
    private Integer start = 1;
    private Map<String,Object> params = new HashMap<>();

    public void setParam(String paramName,String paramValue){
        params.put(paramName,paramValue);
    }
}
