<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="pageContent">
	
	<form method="post" action="${ctx}/rbac/user/doModifyPassword" class="pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<input type="hidden" name="id" value="${data.id}"/>
        <div class="pageFormContent" layoutH="58">
            <div class="unit">
                <label>登录帐号：</label>
                <input type="text" name="loginName" value="${data.loginName}" size="30" readonly="readonly"/>
            </div>
            <div class="unit">
                <label>密码：</label>
                <input type="password" name="password" size="30" class="required"/>
            </div>
            <div class="unit">
                <label>重复密码：</label>
                <input type="password" name="repPassword" size="30" class="required"/>
            </div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>

