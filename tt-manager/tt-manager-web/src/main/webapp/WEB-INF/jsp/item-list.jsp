<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--放入容器--%>
<table id="dg"></table>
<%--放入工具栏--%>
<div id="itemListToolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox" >
            <option value="0">全部</option>
            <option value="1">上架</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>

<%--放入参数--%>
<script>
    function searchForm() {
        $('#dg').datagrid('load',{
//            携带的数据一个是输入框中的字符串
            title:$('#title').val(),
            status:$('#status').combobox('getValue')//该status中返回的是选项box中的值
        });
    }
    function add() {
        ttshop.addTabs('新增商品', 'item-add');
    }
    function edit() {
        console.log('edit');
    }
    function remove() {
        //            console.log('remove');
        //取到用户选中的集合
        var rows=$('#dg').datagrid('getSelections');//得到所有被选中的行形成数组
        if(rows.length==0) {
            $.messager.alert('没有选中任何数组', '请至少选中一个选项', 'warning');
            return;
        }else{
            $.messager.confirm('确认','您确定要删除当前数据吗',function (r) {
                if(r){ //r代表当前确认和不确认的布尔值
                    var ids=[];
                    for(var i=0;i<rows.length;i++){
                        ids.push(rows[i].id);
                    }
                    //发出ajax请求
                    $.get(
                        'items/batch?id=3',
                        {'ids[]':ids},
                        function (data) {
                            if(data>0){
                                $('#dg').datagrid('reload');
                            }

                        }

                    );
                }

            });
        }
    }
    function down() {
        var rows=$('#dg').datagrid('getSelections');//得到所有被选中的行形成数组
        if(rows.length==0) {
            $.messager.alert('没有选中任何数组', '请至少选中一个选项', 'warning');
            return;
        }else{
            $.messager.confirm('确认','您确定要下架当前数据吗',function (r) {
                if(r){ //r代表当前确认和不确认的布尔值
                    var ids=[];
                    for(var i=0;i<rows.length;i++){
                        ids.push(rows[i].id);
                    }
                    //发出ajax请求
                    $.get(
                        'items/batch?id=2',
                        {'ids[]':ids},
                        function (data) {
                            if(data>0){
                                $('#dg').datagrid('reload');
                            }

                        }

                    );
                }

            });
        }
    }
    function up() {
        var rows=$('#dg').datagrid('getSelections');//得到所有被选中的行形成数组
        if(rows.length==0) {
            $.messager.alert('没有选中任何数组', '请至少选中一个选项', 'warning');
            return;
        }else{
            $.messager.confirm('确认','您确定要上架当前数据吗',function (r) {
                if(r){ //r代表当前确认和不确认的布尔值
                    var ids=[];
                    for(var i=0;i<rows.length;i++){
                        ids.push(rows[i].id);
                    }
                    //发出ajax请求
                    $.get(
                        'items/batch?id=1',
                        {'ids[]':ids},
                        function (data) {
                            if(data>0){
                                $('#dg').datagrid('reload');
                            }

                        }

                    );
                }

            });
        }
    }


    $('#dg').datagrid({
        //显示行号
        rownumbers: true,
        //允许多列排序
        multiSort:true,
        //添加工具栏
        toolbar: '#itemListToolbar',
        //请求服务器数据来
        url:'items',
        //每页显示条数
        pageSize:20,
        pageList:[20,50,100],
        //请求方式指定
        method:'get',
        //是否要显示分页栏
        pagination: true,
        fit: true,
        //当前列属性
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'编号',sortable:true},
            {field:'title',title:'标题',sortable:true},
            {field:'sellPoint',title:'评价',width:100,align:'right'},
            {field:'catName',title:'商品类别名称',width:100,align:'right'},
            {field:'statusName',title:'商品状态',width:100,align:'right'},
            {field:'created',title:'创建时间',formatter:function (value,rows,index) {
                return moment(value).format('L');
            }},
            {field:'updated',title:'更新时间',formatter:function (value,rows,index) {
              return moment(value).format('L');
            }}
        ]]
    });

</script>