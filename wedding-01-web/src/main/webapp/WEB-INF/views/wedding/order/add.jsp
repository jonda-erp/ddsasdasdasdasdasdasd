<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pageContent">
    <div class="tabs">
        <div class="tabsHeader">
            <div class="tabsHeaderContent">
                <ul>
                    <li><a href="javascript:;"><span>订单信息</span></a></li>
                    <li><a href="javascript:;"><span>合同信息</span></a></li>
                </ul>
            </div>
        </div>
        <form action="#" method="post" class="pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
            <div class="tabsContent">
                <div class="pageFormContent" layoutH="97">
                    <div class="panel">
                        <h1>基本信息</h1>
                        <div class="panelContent">
                            <dl>
                                <dt>新娘姓名：</dt><dd><input name="name" class="required" alt="请输入名称" type="text"></dd>
                            </dl>
                            <dl>
                                <dt>新娘电话：</dt><dd><input name="sex"/></dd>
                            </dl>
                            <dl>
                                <dt>新郎姓名：</dt><dd><input name="age"/></dd>
                            </dl>
                            <dl>
                                <dt>新郎电话：</dt><dd><input name="phone" /></dd>
                            </dl>
                            <dl>
                                <dt>婚庆日期：</dt>
                                <dd>
                                    <input name="birthday" class="date" readonly="readonly" type="text">
                                    <a href="javascript:void(0)" class="inputDateButton">选择</a>
                                </dd>
                            </dl>
                        </div>
                    </div>
                    <div class="panel">
                        <h1>人员需求</h1>
                        <div class="panelContent">
                            <c:forEach var="item" items="${user_type}">
                                <dl>
                                    <dt>${item.message}：</dt><dd><input name="${item.code}"/></dd>
                                </dl>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="panel">
                        <h1>道具需求</h1>
                        <div class="panelContent">
                            <c:forEach var="item" items="${product_type}">
                                <dl>
                                    <dt>${item.message}：</dt><dd><input name="${item.code}"/></dd>
                                </dl>
                            </c:forEach>
                        </div>
                    </div>
                </div>


                <div class="pageFormContent" layoutH="88">
                    <dl class="nowrap">
                        <dt>合同编号：</dt>
                        <dd>
                            <input type="text" name="loginName" size="30" class="required"/>
                        </dd>
                    </dl>
                    <dl class="nowrap">
                        <dt>合同内容：</dt>
                        <dd>
                            <textarea class="editor" name="note" rows="20" cols="95" tools="mini"></textarea>
                        </dd>
                    </dl>
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
</div>