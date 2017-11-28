package com.dhc.ttshop.service;

import com.dhc.ttshop.common.dto.TreeNode;

import java.util.List;

public interface ItemCatService {
    List<TreeNode> listItemCatsForTree(Long parentId);
}
