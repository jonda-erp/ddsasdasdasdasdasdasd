<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
    .addForm td {
        padding:0px; height:35px; line-height:35px; text-overflow:ellipsis; overflow:hidden;
    }
    .addForm .label{
        vertical-align: top;
    }
</style>
<div class="easyui-layout" fit="true">
    <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
        <form id="invoiceAddForm" method="post" action="${ctx}/invoice/ajax/doAdd">
            <input type="hidden" name="order.orderNo" value="${orderNo}">
            <table class="addForm">
                <tr>
                    <td class="label">新娘姓名:</td>
                    <td>
                        <input class="easyui-textbox" value="${order.brideName}" readonly="readonly"/>
                    </td>
                    <td class="label">新娘电话:</td>
                    <td>
                        <input class="easyui-textbox" value="${order.brideTelephone}" readonly="readonly"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">新郎姓名:</td>
                    <td>
                        <input class="easyui-textbox" value="${order.bridegroomName}" readonly="readonly"/>
                    </td>
                    <td class="label">新郎电话:</td>
                    <td>
                        <input class="easyui-textbox" value="${order.bridegroomTelephone}" readonly="readonly"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">婚庆日期:</td>
                    <td colspan="3">
                        <input class="easyui-textbox" value='<fmt:formatDate value="${order.weddingDate}" pattern="yyyy-MM-dd"/>' readonly="readonly"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">订单备注:</td>
                    <td colspan="3">
                        <input class="easyui-textbox" value="${order.remark}"  readonly="readonly"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">类型:</td>
                    <td colspan="3">
                        <select name="fundType" class="" data-options="prompt:'选择资金类型',required:true,missingMessage:'请选择资金类型'">
                            <c:forEach var="item" items="${types}">
                                <option value="${item.code}">${item.message}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="label">金额:</td>
                    <td colspan="3">
                        <input class="easyui-textbox" name="amount" data-options="prompt:'请输开票金额',required:true,missingMessage:'请输入开票金额'"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">摘要:</td>
                    <td colspan="3">
                        <input class="easyui-textbox" name="remark" data-options="prompt:'请输入摘要'"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>