<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="pageContent">
	
	<form method="post" action="${ctx}/rbac/permission/doModify" class="pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
        <input type="hidden" name="id" value="${data.id}">
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label>资源编码：</label>
				<input type="text" name="code" value="${data.code}" size="30" alt="输入资源编码" class="required"/>
			</div>
            <div class="unit">
                <label>资源操作：</label>
                <input type="text" name="operation" value="${data.operation}" size="30" alt="输入对该资源的操作编码" class="required"/>
            </div>
            <div class="unit">
                <label>资源路径：</label>
                <input type="text" name="url" value="${data.url}" size="30" alt="输入该资源路径URL" class="required"/>
            </div>
            <div class="unit">
                <label>权限名称：</label>
                <input type="text" name="name" value="${data.name}" size="30" class="required"/>
            </div>
            <div class="unit">
                <label>权限描述：</label>
                <input type="text" name="description" value="${data.description}" size="30"/>
            </div>
            <div class="unit">
                <label>优先级：</label>
                <input type="text" name="ranks" value="${data.ranks}" size="30" class="required"/>
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

