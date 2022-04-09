package com.mark.springbootmarkopensource.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class Query extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    // 当前页码
    private int pageNum = 1;

    // 每页条数
    private int limit = 10;

    public Query(Map<String, Object> params) {
        this.putAll(params);

        // 分页参数
        if (params.get("pageNum") != null) {
            this.pageNum = Integer.parseInt(params.get("pageNum").toString());
        }

        if (params.get("limit") != null) {
            this.limit = Integer.parseInt(params.get("limit").toString());
        }

        this.put("offset", (pageNum - 1) * limit);
        this.put("pageNum", pageNum);
        this.put("limit", limit);

        // 防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String sidx = (String) params.get("sidx");
        String order = (String) params.get("order");
        if (StringUtils.isNotBlank(sidx)) {
            this.put("sidx", SQLFilter.sqlInject(sidx));
        }
        if (StringUtils.isNotBlank(order)) {
            this.put("order", SQLFilter.sqlInject(order));
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
