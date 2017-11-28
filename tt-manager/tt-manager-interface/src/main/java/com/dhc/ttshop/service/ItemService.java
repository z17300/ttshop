package com.dhc.ttshop.service;

import com.dhc.ttshop.common.dto.Order;
import com.dhc.ttshop.common.dto.Page;
import com.dhc.ttshop.common.dto.Result;
import com.dhc.ttshop.pojo.po.TbItem;
import com.dhc.ttshop.pojo.vo.TbItemCustom;
import com.dhc.ttshop.pojo.vo.TbItemQuery;

import java.util.List;

public interface ItemService {
    TbItem ttget(Long itemId);
    //不带分页的查询所有
    List<TbItem> listitem();
    //带分页的寻找所有
    Result<TbItemCustom>listitem(Page page, Order order, TbItemQuery query);

    int itemsBatch(List<Long> ids,byte id);

    int saveItem(TbItem tbItem, String content,String paramData);
}
