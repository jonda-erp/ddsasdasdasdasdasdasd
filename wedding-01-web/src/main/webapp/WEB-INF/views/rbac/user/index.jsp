<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form id="pagerForm" method="post" action="${ctx}/rbac/user/index">
    <input type="hidden" name="pageNo" value="${page.pageNo}" />
    <input type="hidden" name="pageSize" value="${page.pageSize}" />
    <input type="hidden" name="orderField" value="${param.orderField}" />
    <input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctx}/rbac/user/index" method="post">
        <div class="searchBar">
            <ul class="searchContent">
                <li>
                    <label>登录帐号：</label>
                    <input type="text" name="loginName" value="${param.loginName}" alt="输入登录帐号"/>
                </li>
                <li>
                    <label>姓名：</label>
                    <input type="text" name="name" value="${param.name}" alt="输入姓名"/>
                </li>
                <li>
                    <label>部门：</label>
                    <input name="department.id" postField="departmentId" value="${param.departmentId}" type="hidden"/>
                    <input name="department.name" postField="departmentName" type="text" value="${departmentName}" readonly="readonly"/>
                    <a class="btnLook" href="${ctx}/rbac/department/dialog" lookupGroup="department">查找带回</a>
                </li>
            </ul>

            <div class="subBar">
                <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
                </ul>
            </div>
        </div>
    </form>
</div>

<div class="pageContent">
<div class="panelBar">
    <ul class="toolBar">
        <li><a class="add" href="${ctx}/rbac/user/add" target="dialog" width="480" rel="user_add_dialog"><span>添加</span></a></li>
        <li><a class="delete" href="${ctx}/rbac/user/delete?id={sid_user}" target="ajaxTodo" title="确定要删除吗？" warn="请选择一个用户"><span>删除</span></a></li>
        <li><a class="edit" href="${ctx}/rbac/user/modify?id={sid_user}" target="dialog" width="480" rel="user_modify_dialog" warn="请选择一条记录"><span>修改</span></a></li>
        <li class="line">line</li>
        <li><a class="icon" href="${ctx}/rbac/user/distributeDialog?userId={sid_user}" target="dialog" targetType="user_distribute_dialog" warn="请选择一条记录"><span>分配角色</span></a></li>
        <li class="line">line</li>
        <li><a class="edit" href="${ctx}/rbac/user/modifyPassword?id={sid_user}" target="dialog" width="480" rel="user_modify_password_dialog" warn="请选择一条记录"><span>重置登录密码</span></a></li>
    </ul>
</div>

<div id="w_list_print">
<table class="list" width="98%" targetType="navTab" asc="asc" desc="desc" layoutH="116">
<thead>
<tr>
    <th width="120" orderField="loginName" class="asc">登录帐号</th>
    <th width="120" orderField="name" class="desc">姓名</th>
    <th width="120" orderField="departmentName" >所属部门</th>
    <th>备注</th>
    <th width="120">创建人</th>
    <th width="140">创建时间</th>
    <th width="120">最后修改人</th>
    <th width="140">最后修改时间</th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${page.data}">
    <tr target="sid_user" rel="${item.id}">
        <td>${item.loginName}</td>
        <td>${item.name}</td>
        <td>${item.department.name}</td>
        <td>${item.remark}</td>
        <td>${item.creator}</td>
        <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td>${item.modifier}</td>
        <td><fmt:formatDate value="${item.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    </tr>
</c:forEach>
</tbody>
</table>
</div>

<div class="panelBar" >
    <div class="pages">
        <span>显示</span>
        <select name="numPerPage" onchange="navTabPageBreak({pageSize:${page.pageSize}})">
            <option value="20">20</option>
            <option value="50">50</option>
            <option value="100">100</option>
            <option value="200">200</option>
        </select>
        <span>条，共${page.totalCount}条</span>
    </div>

    <div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.pageSize}" pageNumShown="10" currentPage="${page.pageNo}"/>

</div>

</div>
