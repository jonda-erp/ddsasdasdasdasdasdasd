<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="pageContent">
	
	<form method="post" action="${ctx}/rbac/user/doAdd" class="pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label>登录帐号：</label>
				<input type="text" name="loginName" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>密码：</label>
				<input type="password" name="password" size="30" class="required"/>
			</div>
            <div class="unit">
                <label>重复密码：</label>
                <input type="password" name="repPassword" size="30" class="required"/>
            </div>
            <div class="unit">
                <label>所在部门：</label>
                <input name="department.id" postField="departmentId" type="hidden"/>
                <input name="department.name" postField="departmentName" type="text" readonly="readonly" class="required"/>
                <a class="btnLook" href="${ctx}/rbac/department/dialog" lookupGroup="department">查找带回</a>
            </div>
            <div class="unit">
                <label>姓名：</label>
                <input type="text" name="name" size="30" class="required"/>
            </div>
            <div class="unit">
                <label>描述：</label>
                <input type="text" name="remark" size="30"/>
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

