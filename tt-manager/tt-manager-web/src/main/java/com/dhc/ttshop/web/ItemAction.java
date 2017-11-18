package com.dhc.ttshop.web;


import com.dhc.ttshop.pojo.po.TbItem;
import com.dhc.ttshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemAction {
    @Autowired
    private ItemService itemService;
    @ResponseBody
    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
    public TbItem TT(@PathVariable("itemId")Long itemId){
        TbItem TbItem=itemService.ttget(itemId);
        System.out.println(TbItem);
        return TbItem;
    }
}
