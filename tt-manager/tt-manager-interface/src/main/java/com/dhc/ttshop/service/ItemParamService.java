package com.dhc.ttshop.service;

import com.dhc.ttshop.common.dto.Page;
import com.dhc.ttshop.common.dto.Result;
import com.dhc.ttshop.pojo.po.TbItemParam;
import com.dhc.ttshop.pojo.vo.TbItemParamCustom;

public interface ItemParamService {
    int saveItemParam(Long cid, String paramData);

    TbItemParam getByCid(Long cid);

    Result<TbItemParamCustom> listItemParams(Page page);
}
