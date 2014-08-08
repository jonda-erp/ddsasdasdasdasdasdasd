<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="${ctx}/rbac/department/manage/add?departmentId={sid_department}" target="navTab" warn="请选择一个需要添加子部门的部门"><span>添加</span></a></li>
            <li><a class="delete" href="${ctx}/rbac/department/manage/add?departmentId={sid_department}" target="ajaxTodo" title="确定要删除吗？" warn="请选择一个部门"><span>删除</span></a></li>
            <li><a class="edit" href="${ctx}/rbac/department/manage/add?departmentId={sid_department}" target="navTab" warn="请选择一个部门"><span>修改</span></a></li>
        </ul>
    </div>
    <div id="w_list_print">
        <table id="tree_data_table" class="list" width="98%" targetType="navTab" asc="asc" desc="desc" layoutH="116">
            <thead>
                <tr>
                    <th width="120">部门名称</th>
                    <th width="90">部门编号</th>
                    <th width="90">上级部门编号</th>
                    <th>部门描述</th>
                    <th width="120">创建人</th>
                    <th width="140">创建时间</th>
                    <th width="120">最后修改人</th>
                    <th width="140">最后修改时间</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${data}">
                    <tr target="sid_department" rel="${item.id}">
                        <td>${item.name}</td>
                        <td>${item.id}</td>
                        <td>${item.parent.id}</td>
                        <td>${item.description}</td>
                        <td>${item.creator}</td>
                        <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${item.modifier}</td>
                        <td><fmt:formatDate value="${item.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script type="text/javascript">
            $.treetable.defaults={
                id_col:1,//ID td列 {从0开始}
                parent_col:2,//父ID td列
                handle_col:0,//加上操作展开操作的 td列
                open_img:"${ctx}/static/treeTable/images/minus.gif",
                close_img:"${ctx}/static/treeTable/images/plus.gif"
            }

            //只能应用于tbody
            $("#tree_data_table tbody").treetable();

            //隐藏数据列
            $("#tree_data_table tbody tr").find("td:eq(1)").hide();
            $("#tree_data_table tbody tr").find("td:eq(2)").hide();
            $("#tree_data_table tr:eq(0)").find("th:eq(1)").hide();
            $("#tree_data_table tr:eq(0)").find("th:eq(2)").hide();
        </script>
    </div>

</div>
