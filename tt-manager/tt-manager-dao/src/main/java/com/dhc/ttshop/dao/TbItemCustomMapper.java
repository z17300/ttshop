package com.dhc.ttshop.dao;

import com.dhc.ttshop.common.dto.Order;
import com.dhc.ttshop.common.dto.Page;
import com.dhc.ttshop.pojo.po.TbItem;
import com.dhc.ttshop.pojo.vo.TbItemCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbItemCustomMapper {
    long countItems(Map<String,Object>map);

    List<TbItemCustom> listItems(Map<String,Object>map);
}
