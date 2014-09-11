<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
    var url; //提交数据的路径
    var formId; //当天要提交的Form的编号
    var dialogId; //对话框的编号

    var successCallback = function (result) {
        //result为请求处理后的返回值
        var result = eval('(' + result + ')');
        if (result.success) {
            $.messager.show({
                title: 'Success',
                msg: result.msg
            });
            $(dialogId).dialog('close');
            $('#dg').datagrid('reload');
        } else {
            $.messager.show({
                title: 'Error',
                msg: result.msg
            });
        }
    }

    $(function () {
//        //预加载编辑框
//        $("#editDepartmentInfo").dialog({
//            "title": "编辑科室信息",
//            width: 500,
//            height: 450,
//            href: 'EditDepartment.aspx'
//        });
//        $("#editDepartmentInfo").dialog('open').dialog('close');
//
//        $('#dg').datagrid({
//
//            onDblClickRow: function (rowIndex, rowData) {
//                $('#editDepartmentInfo').dialog('open');
//                $("#textDepartmentName").val(rowData.Name);
//                $("#textDepartmentDes").val(rowData.Introduce);
//                $("#hoistal").combobox('setValue', rowData.HosptialID);
//
//                //      $('#edit').form('clear');
//                url = 'ashx/DepartmentsManagerService.ashx?action=edit&id=' + rowData.ID;
//                formId = "#edit";
//                dialogId = "#editDepartmentInfo";
//            }
//        });

    });
    //编辑科室部分
    function editDepartmentInfo() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $('#editDepartmentInfo').dialog('open');
            $("#textDepartmentName").val(row.Name);
            $("#textDepartmentDes").val(row.Introduce);
            $("#hoistal").combobox('setValue', row.HosptialID);
            //   $('#edit').form('clear');

            url = 'ashx/DepartmentsManagerService.ashx?action=edit&id=' + row.ID;
            formId = "#edit";
            dialogId = "#editDepartmentInfo";

        }
        else {
            $.messager.alert("提示", "您没有选中任何行！");
        }
    }

    //添加科室部分
    function addDepartmentInfo() {
        $("#addDepartmentInfo").dialog({
            "title": "新建科室信息",
            width: 500,
            height: 450,
            href: 'AddDepartment.aspx'
        });
        $('#addDepartmentInfo').dialog('open');
        $('#add').form('clear');

        url = 'ashx/DepartmentsManagerService.ashx?action=add';
        formId = "#add";
        dialogId = "#addDepartmentInfo";
    }
    function saveInfo() {

        $(formId).form('submit', {
            url: url,
            onSubmit: function () {
                alert(formId);
                return $(this).form('validate');
            },
            success: successCallback
        });
    }

    //  删除代码部分
    function deleteAdminUser() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $.messager.confirm('删除提示', '确定要删除' + row.Name + '吗', function (r) {
                if (r) {
                    $.post('ashx/DepartmentsManagerService.ashx', { id: row.ID, action: 'delete' }, function (data, status) {

                        if (data == "ok") {
                            $('#dg').datagrid('reload');
                        } else {
                            $.messager.show({
                                title: 'Error',
                                msg: '删除该科室失败!'
                            });
                        }
                    });
                }
            });
        }
    }

    //多条件查询方法
    function tsearch() {
        var hoistalName = $("#hoistalName").combobox("getValue");
        var depName = $("#depName").val();
        alert(depName);
        $('#dg').datagrid('options').pageNumber = 1;
        $('#dg').datagrid('getPager').pagination({pageNumber: 1});
        $('#dg').datagrid('options').url = 'ashx/DepartmentsManagerService.ashx?action=search&hospName='+hoistalName+'&depName='+depName;
        $('#dg').datagrid("reload");
    }

</script>

<div region="center" fit="true">
    <div class="easyui-panel" title="查询条件">
        <div class="searchitem">
            <label>姓名：</label>
            <input type="text" id="name" class="easyui-validatebox" />
        </div>
        <div class="searchitem">
            <label>电话：</label>
            <input type="text" id="telephone" class="easyui-validatebox" />
        </div>
        <div class="searchitem" style="width:350px;">
            <label>婚庆日期：</label>
            <input type="text" id="ssDate" class="easyui-validatebox" style="width:80px;"/> 至
            <input type="text" id="seDate" class="easyui-validatebox" style="width:80px;"/>
        </div>
        <div class="searchitem">
            <label>订单状态：</label>
            <select class="combox" name="status">
                <option value="">全部</option>
                <c:forEach var="item" items="${orderStatusEnum}">
                    <c:choose>
                        <c:when test="${item.code == param.status}">
                            <option value="${item.code}" selected="selected">${item.message}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${item.code}">${item.message}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="searchitem">
            <a href="#" class="easyui-linkbutton" onclick="tsearch()">查询</a>
        </div>
    </div>
    <table class="easyui-datagrid" title="客户订单管理"
           data-options="url:'${ctx}/order/query',fitColumns:true,singleSelect:true"
           toolbar='#toolbar' pagination="true" idField="orderId">
        <thead>
        <tr>
            <th data-options="field:'orderId',width:100">Code</th>
            <th data-options="field:'contractId',width:100">Name</th>
            <th data-options="field:'brideName',width:100">Price</th>
            <th data-options="field:'brideTelephone',width:100">Price</th>
            <th data-options="field:'bridegroomName',width:100">Price</th>
            <th data-options="field:'bridegroomTelephone',width:100">Price</th>
            <th data-options="field:'weddingDate',width:100">Price</th>
            <th data-options="field:'status',width:100">Price</th>
            <th data-options="field:'remark',width:100">Price</th>
        </tr>
        </thead>
    </table>

    <div id="toolbar" style="padding:5px;height:auto">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addDepartmentInfo()">创建订单</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editDepartmentInfo()">修改订单</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="deleteAdminUser()">查看详情</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="deleteAdminUser()">修改合同</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="deleteAdminUser()">发票管理</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="deleteAdminUser()">管理人员需求</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="deleteAdminUser()">管理道具需求</a>
    </div>

    <div id="addDepartmentInfo" class="easyui-dialog" closed="true" buttons="#addDepartmentInfo-buttons" style="padding:10px 20px"></div>
    <div id="addDepartmentInfo-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveInfo()">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#addDepartmentInfo').dialog('close')">关闭</a>
    </div>

    <div id="editDepartmentInfo" class="easyui-dialog" closed="true" buttons="#editDepartmentInfo-buttons" style="padding:10px 20px">
    </div>
    <div id="editDepartmentInfo-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveInfo()">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#editDepartmentInfo').dialog('close')">关闭</a>
    </div>
</div>