package com.dhc.ttshop.web;

import com.dhc.ttshop.common.dto.TreeNode;
import com.dhc.ttshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class ItemCatAction {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
  @Autowired
  private ItemCatService IitemCatService;
  @ResponseBody
  @RequestMapping(value = "itemCats",method = RequestMethod.GET)
  public List<TreeNode> listItemCatsForTree(@RequestParam("parentId")Long parentId){
      List<TreeNode>nodeList=null;
      try{
          nodeList=IitemCatService.listItemCatsForTree(parentId);
      }catch (Exception e){
          logger.error(e.getMessage(),e);
          e.printStackTrace();//实现报错收集
      }
      return nodeList;
  }

}
