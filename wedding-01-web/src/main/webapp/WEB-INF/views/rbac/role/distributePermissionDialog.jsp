<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="pageContent">
    <form action="${ctx}/rbac/role/distributePermission" method="post" class="pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
    <input type="hidden" name="roleId" value="${roleId}"/>
    <div id="w_list_print">
        <table id="data_table" class="list" width="98%" targetType="navTab" asc="asc" desc="desc" layoutH="36">
            <thead>
                <tr>
                    <th width="22"><input type="checkbox" group="permissionIds" class="checkboxCtrl" <c:if test="${checkAll}">checked="checked"</c:if>></th>
                    <th width="90">资源</th>
                    <th width="90">操作</th>
                    <th width="90">资源路径</th>
                    <th width="90">优先级</th>
                    <th width="120">权限名称</th>
                    <th>权限描述</th>
                    <th width="120">创建人</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${data}">
                    <tr target="sid_permission" rel="${item.id}">
                        <td><input name="permissionIds" value="${item.id}" type="checkbox" <c:if test="${fn:contains(hasPermissionIds,item.id)}">checked="checked"</c:if>></td>
                        <td>${item.code}</td>
                        <td>${item.operation}</td>
                        <td>${item.url}</td>
                        <td>${item.ranks}</td>
                        <td>${item.name}</td>
                        <td>${item.description}</td>
                        <td>${item.creator}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="formBar">
        <ul>
            <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
            <li>
                <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
            </li>
        </ul>
    </div>
    </form>
</div>
