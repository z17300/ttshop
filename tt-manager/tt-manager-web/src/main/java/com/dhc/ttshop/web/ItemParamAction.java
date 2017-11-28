package com.dhc.ttshop.web;

import com.dhc.ttshop.common.dto.Page;
import com.dhc.ttshop.common.dto.Result;
import com.dhc.ttshop.pojo.po.TbItemParam;
import com.dhc.ttshop.pojo.vo.TbItemParamCustom;
import com.dhc.ttshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemParamAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ItemParamService itemParamService;
    @ResponseBody
    @RequestMapping(value = "/itemParam/{cid}",method = RequestMethod.POST)
    public int saveItemParam(@PathVariable("cid")Long cid,@RequestParam("paramData")String paramData){
        int i=0;
        try{
            i=itemParamService.saveItemParam(cid,paramData);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
         return i;
     }
    @ResponseBody
    @RequestMapping(value = "/itemParam/{cid}",method = RequestMethod.GET)
    public TbItemParam getByCid(@PathVariable("cid")Long cid){
        TbItemParam tbItemParam=null;
        try{

            tbItemParam=itemParamService.getByCid(cid);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return tbItemParam;
    }
    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustom> listItemParams(Page page){
        Result<TbItemParamCustom> rs = null;
        try {
            rs = itemParamService.listItemParams(page);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return rs;
    }
}
