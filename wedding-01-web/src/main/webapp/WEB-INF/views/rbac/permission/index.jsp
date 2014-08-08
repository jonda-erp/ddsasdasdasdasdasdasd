<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="${ctx}/rbac/permission/add" target="dialog" width="480"><span>添加</span></a></li>
            <li><a class="delete" href="${ctx}/rbac/permission/delete?id={sid_permission}" target="ajaxTodo" title="确定要删除吗？" warn="请选择一条记录"><span>删除</span></a></li>
            <li><a class="edit" href="${ctx}/rbac/permission/modify?id={sid_permission}" target="dialog" warn="请选择一条记录" width="480"><span>修改</span></a></li>
        </ul>
    </div>

    <div id="w_list_print">
        <table id="data_table" class="list" width="98%" targetType="navTab" asc="asc" desc="desc" layoutH="116">
            <thead>
                <tr>
                    <th width="90">资源</th>
                    <th width="90">操作</th>
                    <th width="90">资源路径</th>
                    <th width="90">优先级</th>
                    <th width="120">权限名称</th>
                    <th>权限描述</th>
                    <th width="120">创建人</th>
                    <th width="140">创建时间</th>
                    <th width="120">最后修改人</th>
                    <th width="140">最后修改时间</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${data}">
                    <tr target="sid_permission" rel="${item.id}">
                        <td>${item.code}</td>
                        <td>${item.operation}</td>
                        <td>${item.url}</td>
                        <td>${item.ranks}</td>
                        <td>${item.name}</td>
                        <td>${item.description}</td>
                        <td>${item.creator}</td>
                        <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${item.modifier}</td>
                        <td><fmt:formatDate value="${item.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>
