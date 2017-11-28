package com.dhc.ttshop.common.dto;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String sort;
    private String order;
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<String> getOrderParams() {
        String[] sorts=this.sort.split(",");//根据当前逗号进行分割
        String[] orders=this.order.split(",");
        List<String>list=new ArrayList<String>();
        for (int i=0;i<sorts.length;i++){
            String temp = sorts[i] +" "+orders[i];//id asc;title desc
            list.add(temp);//[id asc;title desc]
        }
        return list;
    }
}
