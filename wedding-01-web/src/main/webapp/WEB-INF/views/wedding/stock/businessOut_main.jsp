<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<form id="pagerForm" method="post" action="${ctx}/stock/busiOut">
    <input type="hidden" name="pageNo" value="${page.pageNo}" />
    <input type="hidden" name="pageSize" value="${page.pageSize}" />
    <input type="hidden" name="orderField" value="${param.orderField}" />
    <input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctx}/stock/busiOut" method="post">
        <div class="searchBar">
            <div class="pageFormContent">
                <p>
                    <label>新娘姓名：</label>
                    <input  type="text" name="brideName" size="30" value="" />
                </p>
                <p>
                    <label>新娘电话：</label>
                    <input type="text" class="phone" name="brideTelephone" size="30" value=""/>
                </p>
                <p>
                    <label>新郎姓名：</label>
                    <input type="text" name="bridegroomName" size="30" value=""/>
                </p>
                <p>
                    <label>新郎电话：</label>
                    <input type="text" name="bridegroomTelephone" size="30" value=""/>
                </p>
                <p>
                    <label>订单号：</label>
                    <input type="text" name="orderId" size="30" value=""/>
                </p>
                <p>
                    <label>合同号：</label>
                    <input type="text" name="contractId" size="30" value=""/>
                </p>
                <p>
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
                </p>
                <p>&nbsp;</p>
                <p>
                    <label>婚庆日期：</label>
                    <input name="ssDate" class="date" value="${ssDate}" readonly="readonly" size="30" class="required" type="text">
                    <a href="javascript:void(0)" class="inputDateButton">选择</a>
                </p>
                <p>
                    <label>-</label>
                    <input name="seDate" class="date" value="${seDate}" readonly="readonly" size="30" class="required" type="text">
                    <a href="javascript:void(0)" class="inputDateButton">选择</a>
                </p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
            </div>
            <div class="divider"></div>
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
            <li><a class="add" href="${ctx}/stock/busiOutByContract?id=C000120140826212725" target="dialog" width="980" height="578" rel="busi_out_dialog"><span>订单合同出库</span></a></li>
            <li><a class="edit" href="${ctx}/rbac/user/modify?id={v_contract_id}" target="dialog" width="480" rel="order_modify_dialog" warn="请选择一条记录"><span>订单额外出库</span></a></li>
            <li><a class="edit" href="${ctx}/rbac/user/modify?id={v_contract_id}" target="dialog" width="480" rel="order_modify_dialog" warn="请选择一条记录"><span>查看出库详情</span></a></li>
            <li class="line">line</li>
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
                <th width="80">创建人</th>
                <th width="130">创建时间</th>
                <th width="80">最后修改人</th>
                <th width="130">最后修改时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${page.data}">
                <tr target="v_contract_id" rel="${item.contractId}">
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
