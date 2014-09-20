<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<head>
    <script type="text/javascript" src='${ctx}/static/easyui/outlook2.js'> </script>
    <script type="text/javascript" src="${ctx}/static/easyui/application/index.js"></script>
    <jsp:include page="common/menus.jsp"/>
</head>

<body class="easyui-layout" style="overflow-y: hidden"  scroll="no" fit="true">
    <noscript>
        <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
            <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
        </div>
    </noscript>
    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
            background: url(${ctx}/static/easyui/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
            line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head">
            欢迎 <shiro:principal/>
            <a href="#" id="editpass">修改密码</a>
            <a href="#" id="loginOut">安全退出</a>
        </span>
        <span style="padding-left:10px; font-size: 16px; ">
            <img src="${ctx}/static/easyui/images/blocks.gif" width="20" height="20" align="absmiddle" /> 婚庆管理平台
        </span>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">By 疯狂秀才(QQ:1055818239) jQuery.Easy-UI QQ讨论群： 112044258、32994605、36534121、56271061</div>
    </div>

    <div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
        <div id="nav" class="easyui-accordion" fit="true" border="false">
            <!--  导航内容 -->
        </div>
    </div>

    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
            <div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; " >
                <h1 style="font-size:24px;">欢迎使用婚庆管理平台</h1>
            </div>
        </div>
    </div>

    <!--修改密码窗口-->
    <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
         maximizable="false" icon="icon-save"  style="width:400px;height:200px;padding: 5px;background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="Password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="txtRePass" type="Password" class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >确定</a>
                <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>

    <div id="mm" class="easyui-menu" style="width:150px;">
        <div id="mm-tabupdate">刷新</div>
        <div class="menu-sep"></div>
        <div id="mm-tabclose">关闭</div>
        <div id="mm-tabcloseall">全部关闭</div>
        <div id="mm-tabcloseother">除此之外全部关闭</div>
        <div class="menu-sep"></div>
        <div id="mm-tabcloseright">当前页右侧全部关闭</div>
        <div id="mm-tabcloseleft">当前页左侧全部关闭</div>
        <div class="menu-sep"></div>
        <div id="mm-exit">退出</div>
    </div>


</body>
</html>