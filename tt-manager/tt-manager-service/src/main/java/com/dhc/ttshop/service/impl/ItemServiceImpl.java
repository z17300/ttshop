package com.dhc.ttshop.service.impl;

import com.dhc.ttshop.common.dto.Order;
import com.dhc.ttshop.common.dto.Page;
import com.dhc.ttshop.common.dto.Result;
import com.dhc.ttshop.common.util.IDUtils;
import com.dhc.ttshop.dao.TbItemCustomMapper;
import com.dhc.ttshop.dao.TbItemDescMapper;
import com.dhc.ttshop.dao.TbItemMapper;
import com.dhc.ttshop.dao.TbItemParamItemMapper;
import com.dhc.ttshop.pojo.po.*;
import com.dhc.ttshop.pojo.vo.TbItemCustom;
import com.dhc.ttshop.pojo.vo.TbItemQuery;
import com.dhc.ttshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private TbItemMapper tbItemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;
    @Autowired
    private TbItemDescMapper itemDescDao;
    @Autowired
    private TbItemParamItemMapper itemParamItemDao;
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public TbItem ttget(Long itemId) {
        TbItem TbItem=tbItemDao.selectByPrimaryKey(itemId);
        return TbItem;
    }

    @Override
    public List<TbItem> listitem() {
        List<TbItem>Tbitemlist=null;
        try{
            Tbitemlist=tbItemDao.selectByExample(null);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();//实现报错收集
        }
        return Tbitemlist;
    }

    @Override
    public Result<TbItemCustom> listitem(Page page, Order order, TbItemQuery query) {
        Result<TbItemCustom>result=null;
        try{
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("page",page);
            map.put("order",order);
            map.put("query",query);
            //1 先查总记录数 int--Long
            long total = itemCustomDao.countItems(map);
            //2 查询指定页码的记录集合
            List<TbItemCustom> list = itemCustomDao.listItems(map);
            //3 存放result中
            result = new Result<TbItemCustom>();
            result.setTotal(total);
            result.setRows(list);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();//实现报错收集
        }
        return result;
    }

    @Override
    public int itemsBatch(List<Long> ids,byte id) {
        int i=0;
        try{
            TbItem tbItem=new TbItem();
            tbItem.setStatus((byte)id);//设置需要更改的类的属性是3即删除态
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria=example.createCriteria();
            criteria.andIdIn(ids);//查询需要更改的行
            i=tbItemDao.updateByExampleSelective(tbItem,example);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();//实现报错收集
        }
        return i;
    }
    @Transactional
    @Override
    public int saveItem(TbItem tbItem, String content,String paramData) {
        int i=0;

        try{
            long itemId = IDUtils.getItemId();
            tbItem.setId(itemId);
            tbItem.setStatus((byte)1);
            tbItem.setCreated(new Date());
            tbItem.setUpdated(new Date());
            i = tbItemDao.insert(tbItem);
            //再存tb_item_desc
            TbItemDesc tbItemDesc = new TbItemDesc();
            tbItemDesc.setItemId(itemId);
            tbItemDesc.setItemDesc(content);
            tbItemDesc.setCreated(new Date());
            tbItemDesc.setUpdated(new Date());
            i += itemDescDao.insert(tbItemDesc);
            //存入详情列表
            TbItemParamItem itemParamItem=new TbItemParamItem();
            itemParamItem.setItemId(itemId);
            itemParamItem.setParamData(paramData);
            itemParamItem.setCreated(new Date());
            itemParamItem.setUpdated(new Date());
            System.out.println(itemParamItem.getId());
            i+=itemParamItemDao.insert(itemParamItem);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();//实现报错收集
        }
        return i;
    }
}
