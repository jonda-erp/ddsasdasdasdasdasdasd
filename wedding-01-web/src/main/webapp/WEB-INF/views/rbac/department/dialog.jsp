<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="pageContent">
    <div id="w_list_print">
        <table id="data_table" class="list" width="98%" layoutH="12">
            <thead>
                <tr>
                    <th width="160">部门名称</th>
                    <th width="90">部门编号</th>
                    <th width="90">上级部门编号</th>
                    <th>部门描述</th>
                    <th width="120">创建人</th>
                    <th width="40">选择</th>
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
                            <td><a class="btnSelect" href="javascript:$.bringBack({id:'${item.id}', name:'${item.name}', parentId:'${item.parent.id}'})" title="查找带回">选择</a></td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
    $.treetable.defaults={
        id_col:1,//ID td列 {从0开始}
        parent_col:2,//父ID td列
        handle_col:0,//加上操作展开操作的 td列
        open_img:"${ctx}/static/treeTable/images/minus.gif",
        close_img:"${ctx}/static/treeTable/images/plus.gif"
    }

    //只能应用于tbody
    $("#data_table tbody").treetable();

    //隐藏数据列
    $("#data_table tbody tr").find("td:eq(1)").hide();
    $("#data_table tbody tr").find("td:eq(2)").hide();
    $("#data_table thead tr").find("th:eq(1)").hide();
    $("#data_table thead tr").find("th:eq(2)").hide();
</script>
