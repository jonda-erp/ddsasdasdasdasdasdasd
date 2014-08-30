<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
    .pageFormContent {margin: 0px; padding: 0px;}
    .pageContent {padding: 0px;}
</style>

<div class="pageContent">
    <form action="${ctx}/order/doAdd" method="post" class="pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent">
            <div class="panel">
                <h1>道具出库</h1>
                <div class="panelContent">
                    <div id="w_list_print">
                        <table class="list" width="100%" targetType="navTab" asc="asc" desc="desc" layoutH="130">
                            <thead>
                                <tr>
                                    <th>道具名称</th>
                                    <th>型号</th>
                                    <th>备注</th>
                                    <th>需求数量</th>
                                    <th>出库数量</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${page.data}">
                                <tr>
                                    <td>${item.product_count}</td>
                                    <td>${item.product_count}</td>
                                    <td>${item.product_count}</td>
                                    <td>${item.product_count}</td>
                                    <td>${item.product_count}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                </div>
            </div>
        </div>
        </div>
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">出库</button></div></div></li>
                <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
            </ul>
        </div>
    </form>
</div>