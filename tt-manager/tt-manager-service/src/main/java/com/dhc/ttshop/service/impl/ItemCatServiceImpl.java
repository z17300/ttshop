package com.dhc.ttshop.service.impl;

import com.dhc.ttshop.common.dto.TreeNode;
import com.dhc.ttshop.dao.TbItemCatMapper;
import com.dhc.ttshop.pojo.po.TbItemCat;
import com.dhc.ttshop.pojo.po.TbItemCatExample;
import com.dhc.ttshop.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemCatServiceImpl implements ItemCatService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemCatMapper itemCatDao;

    @Override
    public List<TreeNode> listItemCatsForTree(Long parentId) {
        List<TreeNode>nodeList=null;
        try{
            TbItemCatExample example=new TbItemCatExample();
            TbItemCatExample.Criteria criteria=example.createCriteria();
            criteria.andParentIdEqualTo(parentId);//根据选中的节点查询出所有父节点其中的节点名称来源于当前查询的表
            List<TbItemCat>itemCatList=itemCatDao.selectByExample(example);//查询出所有父节点
            nodeList = new ArrayList<TreeNode>();
            for(TbItemCat itemCat : itemCatList){
                TreeNode treeNode=new TreeNode();
                treeNode.setId(itemCat.getId());
                treeNode.setText(itemCat.getName());
                treeNode.setState(itemCat.getIsParent()?"closed":"open");//todo
                nodeList.add(treeNode);
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();//实现报错收集
        }
        return nodeList;
    }
}
