package com.dhc.ttshop.web;


import com.dhc.ttshop.common.dto.Order;
import com.dhc.ttshop.common.dto.Page;
import com.dhc.ttshop.common.dto.Result;
import com.dhc.ttshop.pojo.po.TbItem;
import com.dhc.ttshop.pojo.vo.TbItemCustom;
import com.dhc.ttshop.pojo.vo.TbItemQuery;
import com.dhc.ttshop.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ItemAction {
    @Autowired
    private ItemService itemService;

    //日志文件
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @ResponseBody
    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    public TbItem TT(@PathVariable("itemId")Long itemId){
        TbItem TbItem=itemService.ttget(itemId);
        System.out.println(TbItem);
        return TbItem;
    }
    @ResponseBody
    @RequestMapping(value = "/items",method = RequestMethod.GET)
    public Result<TbItemCustom> listItems(Page page, Order order,TbItemQuery query,HttpServletRequest request){
//        System.out.print(query.getStatus()+""+query.getTitle());
        Result<TbItemCustom>result=null;
        try{
            String str = request.getParameter("title");
            if (StringUtils.isNotBlank(str)) {
                String title = new String(str.getBytes("ISO-8859-1"), "UTF-8");
                query.setTitle(title);
            }
                result=itemService.listitem(page,order,query);//当前页面传输
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();//实现报错收集
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "items/batch",method = RequestMethod.GET)
    public int itmesBatch(@RequestParam("ids[]")List<Long>ids,byte id){

        int i=0;

        try{
            i=itemService.itemsBatch(ids,id);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();//实现报错收集
        }
        return i;
    }
    @ResponseBody
    @RequestMapping(value = "item",method = RequestMethod.POST)
    public int saveItem(TbItem tbItem,String content,String paramData){
        int i=0;

        try{
            i=itemService.saveItem(tbItem,content,paramData);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();//实现报错收集
        }
        return i;
    }
}
