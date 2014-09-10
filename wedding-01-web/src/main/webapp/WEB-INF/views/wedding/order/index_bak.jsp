<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<form id="pagerForm" method="post" action="${ctx}/order/query">
    <input type="hidden" name="pageNo" value="${page.pageNo}" />
    <input type="hidden" name="pageSize" value="${page.pageSize}" />
    <input type="hidden" name="orderField" value="${param.orderField}" />
    <input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctx}/order/query" method="post">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        姓名：<input type="text" name="brideName" value="${param.brideName}"/>
                    </td>
                    <td>
                        电话：<input type="text" name="brideTelephone" value="${param.brideTelephone}"/>
                    </td>
                    <td>
                        订单状态：
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
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        婚庆日期：
                        <div>
                            <input name="ssDate" class="date" value="${ssDate}" readonly="readonly" class="required" type="text">
                            <a href="javascript:void(0)" class="inputDateButton">选择</a>
                            -
                            <input name="seDate" class="date" value="${seDate}" readonly="readonly" class="required" type="text">
                            <a href="javascript:void(0)" class="inputDateButton">选择</a>
                        </div>
                    </td>
                </tr>
            </table>
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
            <li><a class="add" href="${ctx}/order/add" target="dialog" width="980" height="578" rel="order_add_dialog"><span>创建订单</span></a></li>
            <li><a class="edit" href="${ctx}/rbac/user/modify?id={sid_user}" target="dialog" width="480" rel="order_modify_dialog" warn="请选择一条记录"><span>修改订单</span></a></li>
            <li><a class="edit" href="${ctx}/rbac/user/modify?id={sid_user}" target="dialog" width="480" rel="order_modify_dialog" warn="请选择一条记录"><span>查看详情</span></a></li>
            <li class="line">line</li>
            <li><a class="edit" href="${ctx}/rbac/user/distributeDialog?userId={sid_user}" target="dialog" targetType="order_distribute_dialog" warn="请选择一条记录"><span>修改合同</span></a></li>
            <li><a class="edit" href="${ctx}/rbac/user/distributeDialog?userId={sid_user}" target="dialog" targetType="order_distribute_dialog" warn="请选择一条记录"><span>发票管理</span></a></li>
            <li class="line">line</li>
            <li><a class="edit" href="${ctx}/rbac/user/distributeDialog?userId={sid_user}" target="dialog" targetType="order_distribute_dialog" warn="请选择一条记录"><span>管理人员需求</span></a></li>
            <li><a class="edit" href="${ctx}/rbac/user/distributeDialog?userId={sid_user}" target="dialog" targetType="order_distribute_dialog" warn="请选择一条记录"><span>管理道具需求</span></a></li>
        </ul>
    </div>

    <div id="w_list_print">
        <table class="list" width="98%" targetType="navTab" asc="asc" desc="desc" layoutH="116">
            <thead>
            <tr>
                <th width="140" orderField="brideName" class="asc">订单号</th>
                <th width="140" orderField="brideName">合同号</th>
                <th width="80" orderField="brideName" class="asc">新娘姓名</th>
                <th width="100" orderField="brideTelephone" class="desc">新娘电话</th>
                <th width="80" orderField="bridegroomName" >新郎姓名</th>
                <th width="100" orderField="bridegroomName" >新郎电话</th>
                <th width="100" orderField="bridegroomName" >婚庆日期</th>
                <th width="60">订单状态</th>
                <th>备注</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${page.data}">
                <tr target="sid_user" rel="${item.orderId}">
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
