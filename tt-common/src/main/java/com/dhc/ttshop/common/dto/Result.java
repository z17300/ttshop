package com.dhc.ttshop.common.dto;

import java.util.List;

public class Result<T>{
    private Long total;//当前符合条件的记录总数
    private List<T>rows;//更具索引号和page

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
