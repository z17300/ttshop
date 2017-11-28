<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="paramListToolbar">
    <div>
        <button type="button" onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button type="button" onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button type="button" onclick="del()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
    </div>
</div>
<table id="dgParamList"></table>

<script>
    $(function(){

        //列表
        $('#dgParamList').datagrid({
            title: '商品规格模板列表',
            url:'itemParams',
            fit: true,
            rownumbers: true,
            pagination: true,
            method:'get',
            pageSize:20,
            toolbar: '#paramListToolbar',
            columns:[[
                {field:'ck', checkbox: true},
                {field:'id',title:'ID', sortable: true},
                {field:'itemCatName',title:'商品类目'},
                {field:'paramData',title:'规格(只显示分组名称)', formatter:function(value,row,index){
                    //js中把字符串转换为对象（反序列化）
                    //js中把对象转换字符串（序列化）
                    var json = JSON.parse(value);
                    var array = [];
                    $.each(json,function(i,e){
                        array.push(e.group);
                    });
                    return array.join(",");
                }},
                {field:'created',title:'创建日期', formatter:function(value,row,index){
                    return moment(value).format('YYYY年MM月DD日,hh:mm:ss');
                }},
                {field:'updated',title:'更新日期', formatter:function(value,row,index){
                    return moment(value).format('YYYY年MM月DD日,hh:mm:ss');
                }}
            ]]

        });
    });
    function add(){
        ttshop.addTabs('新增规格参数', 'item-param-add');
    }
    function edit(){

    }
    function del(){

    }
</script>