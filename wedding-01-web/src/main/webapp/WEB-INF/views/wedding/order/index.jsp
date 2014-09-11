<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="${ctx}/static/easyui/application/order.js"></script>
<script type="text/javascript">

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
        <div class="searchitem">
            <label>婚庆日期：</label>
            <input type="text" id="ssDate" class="easyui-datebox" style="width:100px;"/> 至
            <input type="text" id="seDate" class="easyui-datebox" style="width:100px;"/>
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
            <a href="javascript:FindData()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
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
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addDepartmentInfo('${ctx}/order/add')">创建订单</a>
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

    <div id="editDepartmentInfo" class="easyui-dialog" closed="true" buttons="#editDepartmentInfo-buttons" style="padding:10px 20px"></div>
    <div id="editDepartmentInfo-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveInfo()">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#editDepartmentInfo').dialog('close')">关闭</a>
    </div>
</div>