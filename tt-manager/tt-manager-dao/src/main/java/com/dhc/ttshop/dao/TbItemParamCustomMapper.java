package com.dhc.ttshop.dao;

import com.dhc.ttshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map;

public interface TbItemParamCustomMapper {
    long countItemParams(Map<String, Object> map);

    List<TbItemParamCustom> listItemParamsByPage(Map<String, Object> map);
}
