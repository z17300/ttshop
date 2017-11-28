package com.dhc.ttshop.common.dto;

public class Page {
    //当前页
    private int page;
    //每页显示的size
    private int rows;
    //偏移量
//    符合javabean规范
    //private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return (page-1)*rows;//得到索引号起始位置
    }

}
