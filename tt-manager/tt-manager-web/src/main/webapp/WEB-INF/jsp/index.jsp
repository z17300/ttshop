<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <!-- 导入easyui的样式表 -->
    <%--基于action动态样式--%>
    <link rel="stylesheet" href="js/jquery-easyui-1.5/themes/bootstrap/easyui.css">
    <link rel="stylesheet" href="js/jquery-easyui-1.5/themes/icon.css">
    <link rel="stylesheet" href="css/common.css">
</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height:70px;padding-left:10px;">
    <h2>天天小商城后台管理系统</h2>
</div>
<div data-options="region:'south'" style="padding:5px;background:#eee;">
    系统版本：V2.0
</div>
<div data-options="region:'west'" style="width:200px;">
    <div id="menu" class="easyui-accordion">
        <div title="商品管理" data-options="selected:true,iconCls:'icon-tip'" style="padding:10px 0;">
            <ul class="easyui-tree">
                <li data-options="attributes:{'href':'item-add'}">新增商品</li>
                <li data-options="attributes:{'href':'item-list'}">查询商品</li>
                <li data-options="attributes:{'href':'item-param-add'}">新增规格参数</li>
                <li data-options="attributes:{'href':'item-param-list'}">查询规格参数</li>
            </ul>
        </div>
        <div title="网站内容管理" data-options="iconCls:'icon-tip'" style="padding:10px 0;">
            <ul class="easyui-tree">
                <li data-options="attributes:{'href':'content-category'}">内容分类管理</li>
                <li data-options="attributes:{'href':'content'}">内容管理</li>
            </ul>
        </div>
        <div title="索引库管理" data-options="iconCls:'icon-tip'" style="padding:10px 0;">
            <ul class="easyui-tree">
                <li data-options="attributes:{'href':'index-item'}">solr索引库维护</li>
            </ul>
        </div>
    </div>
</div>
<div data-options="region:'center'" style="background:#eee;">
    <div id="tab" class="easyui-tabs" data-options="fit:true">
        <div title="欢迎页面" style="padding:20px;">千锋欢迎你</div>
    </div>
</div>
<!-- jquery -->
<script src="js/jquery-easyui-1.5/jquery.min.js"></script>
<!-- jquery easyui -->
<script src="js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
<script src="js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
<%--引入日期处理库--%>
<script src="js/moment/moment-with-locales.js"></script>
<script src="js/common.js"></script>
<script src="js/ueditor/ueditor.config.js"></script>
<script src="js/ueditor/ueditor.all.js"></script>
<script>
    moment.locale('zh-cn');
</script>


<!-- 自定义脚本 -->
<%--<script src="js/common.js"></script>--%>
<!-- 自定义js -->
<script>
    ttshop.registerMenuEvent();
//    $(function () {
//        var $tree= $('#menu .easyui-tree');//得到当前nodetree对象
//        $tree.tree({
//
//
//            onClick:function(node){
//                //判断当前是否有标签页如果有则创建没有则选择node对象中的选择文本
//                if($('#tab').tabs('exists',node.text)){
//                    $('#tab').tabs('select',node.text)
//                }else{
//                    //新增选项卡
//                    $('#tab').tabs('add',{
//                        title:node.text,//拿到标题名
//                        href:node.attributes.href,//调用其中的href方法
//                        closable:true
//                    });
//
//                }
//
//
//            }//一种传统的写法noded代表当前节点中的对象的信息
//        });
//
//
//
//    });
</script>
</body>
</html>>