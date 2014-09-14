<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <form id="ff" method="post" action="${ctx}/order/doAdd">
            <table class="addForm">
                <tr>
                    <td class="label">新娘姓名:</td>
                    <td>
                        <input class="easyui-textbox" name="brideName" data-options="prompt:'请输入新娘姓名',required:true"/>
                    </td>
                    <td class="label">新娘电话:</td>
                    <td>
                        <input class="easyui-textbox" name="brideTelephone" data-options="prompt:'请输入新娘电话',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">新郎姓名:</td>
                    <td>
                        <input class="easyui-textbox" name="bridegroomName" data-options="prompt:'请输入新郎姓名',required:true"/>
                    </td>
                    <td class="label">新郎电话:</td>
                    <td>
                        <input class="easyui-textbox" name="bridegroomTelephone" data-options="prompt:'请输入新郎电话',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">婚庆日期:</td>
                    <td colspan="3">
                        <input class="easyui-datebox" name="sDate" data-options="prompt:'请选择婚庆日期',required:true" />
                    </td>
                </tr>
                <tr>
                    <td class="label">备注:</td>
                    <td colspan="3">
                        <input class="easyui-textbox" name="remark" style="width:350px;"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">合同编号:</td>
                    <td colspan="3">
                        <input class="easyui-textbox" name="contract.contractNo" style="width:350px;"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">合同内容:</td>
                    <td colspan="3">
                        <input class="easyui-textbox" data-options="multiline:true" style="width:350px;height:150px">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>