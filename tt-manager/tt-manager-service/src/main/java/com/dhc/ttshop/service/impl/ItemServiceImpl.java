package com.dhc.ttshop.service.impl;

import com.dhc.ttshop.dao.TbItemMapper;
import com.dhc.ttshop.pojo.po.TbItem;
import com.dhc.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private TbItemMapper tbItemDao;
    @Override
    public TbItem ttget(Long itemId) {
        TbItem TbItem=tbItemDao.selectByPrimaryKey(itemId);
        return TbItem;
    }
}
