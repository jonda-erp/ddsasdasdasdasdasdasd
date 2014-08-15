<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
    .pageFormContent {margin: 0px; padding: 0px;}
    .pageContent {padding: 0px;}
</style>

<div class="pageContent">
    <form action="${ctx}/order/doAdd" method="post" class="pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="40">
            <div class="panel">
                <h1>基本信息</h1>
                <div class="panelContent">
                    <dl>
                        <dt>新娘姓名：</dt><dd><input name="brideName" type="text"></dd>
                    </dl>
                    <dl>
                        <dt>新娘电话：</dt><dd><input name="brideTelephone" type="text"/></dd>
                    </dl>
                    <dl>
                        <dt>新郎姓名：</dt><dd><input name="bridegroomName" type="text"/></dd>
                    </dl>
                    <dl>
                        <dt>新郎电话：</dt><dd><input name="bridegroomTelephone" type="text"/></dd>
                    </dl>
                    <dl>
                        <dt>婚庆日期：</dt>
                        <dd>
                            <input name="sDate" class="date" readonly="readonly" class="required" type="text">
                            <a href="javascript:void(0)" class="inputDateButton">选择</a>
                        </dd>
                    </dl>
                    <dl>
                        <dt>备注：</dt><dd><input name="remark" type="text" size="50"/></dd>
                    </dl>
                </div>
            </div>
            <div class="panel">
                <h1>合同信息</h1>
                <div class="panelContent">
                    <dl class="nowrap">
                        <dt>合同编号：</dt>
                        <dd>
                            <input type="text" name="contract.contractNo" size="30" class="required"/>
                        </dd>
                    </dl>
                    <dl class="nowrap">
                        <dt>合同内容：</dt>
                        <dd>
                            <textarea class="editor" name="contract.content" rows="16" cols="104" tools="mini"></textarea>
                        </dd>
                    </dl>
                </div>
            </div>
        </div>
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
            </ul>
        </div>
    </form>
</div>