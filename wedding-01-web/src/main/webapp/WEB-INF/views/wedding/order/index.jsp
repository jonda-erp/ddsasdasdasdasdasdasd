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

<div region="center" title="科室信息管理" >
    <div class="easyui-panel" title="查询条件">
        <div class="searchitem">
            <label>医院名：</label>
            <select id="hoistalName" name="selectHosptial">
                <option value=""></option>
                <option value="1">测试医院1</option>
            </select>
        </div>
        <div class="searchitem">
            <label>科室名：</label>
            <input type="text" id="depName" class="easyui-validatebox" />
        </div>
        <div class="searchitem">
            <label>科室名：</label>
            <input type="text" id="depName1" class="easyui-validatebox" />
        </div>
        <div class="searchitem" style="width:350px;">
            <label>婚庆日期：</label>
            <input type="text" id="depName2" class="easyui-validatebox" style="width:80px;"/> 至
            <input type="text" id="depName3" class="easyui-validatebox" style="width:80px;"/>
        </div>
        <div class="searchitem">
            <label>科室名：</label>
            <input type="text" id="depName4" class="easyui-validatebox" />
        </div>
        <div class="searchitem">
            <a href="#" class="easyui-linkbutton" onclick="tsearch()" >查询</a>
        </div>
    </div>

    <table id="dg2" title="科室信息管理" class="easyui-datagrid"
           toolbar="#toolbar" pagination="true"
           rownumbers="true" fitColumns="true" singleSelect="true"   idField='ID'
           pageSize="20" data-options="pageNumber:${page.pageNo},pageSize:${page.pageSize},">
        <thead>
            <tr>
                <th field="Name" width="10">订单号</th>
                <th field="Name" width="10">合同号</th>
                <th field="Name" width="10">新娘姓名</th>
                <th field="Name" width="10">新娘电话</th>
                <th field="Name" width="10">新郎姓名</th>
                <th field="Name" width="10">新郎电话</th>
                <th field="Name" width="10">婚庆日期</th>
                <th field="Name" width="10">订单状态</th>
                <th field="Name" width="10">备注</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${page.data}">
            <tr>
                <td>${item.orderId}</td>
                <td>${item.contractId}</td>
                <td>${item.brideName}</td>
                <td>${item.brideTelephone}</td>
                <td>${item.bridegroomName}</td>
                <td>${item.bridegroomTelephone}</td>
                <td><fmt:formatDate value="${item.weddingDate}" pattern="yyyy-MM-dd"/></td>
                <td>${item.status}</td>
                <td>
                    <c:choose>
                        <c:when test="${item.remark != null and item.remark.length() > 15}">
                            ${fn:substring(item.remark, 0, 15)}...
                        </c:when>
                        <c:otherwise>
                            ${item.remark}
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>

    <div id="toolbar" style="padding:5px;height:auto">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addDepartmentInfo()">添加科室</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editDepartmentInfo()">编辑科室</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteAdminUser()">删除科室</a>
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