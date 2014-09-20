<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table id="stageList" class="easyui-datagrid" data-options="url:'${ctx}/stock/ajax/query?contractNo=${contractNo}',method:'get',singleSelect:true,fit:true,fitColumns:true">
    <thead>
    <tr>
        <th data-options="field:'contractId'" width="100">道具名称</th>
        <th data-options="field:'[product][productType]'" width="100">型号</th>
        <th data-options="field:'product[description]'">备注</th>
        <th data-options="field:'productCount'" width="50">需求数量</th>
        <th data-options="field:'productCount'" width="50">出库数量</th>
    </tr>
    </thead>
</table>