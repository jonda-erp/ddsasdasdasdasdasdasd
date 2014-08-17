<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>婚庆企业管理平台123</title>

    <link href="${ctx}/static/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="${ctx}/static/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="${ctx}/static/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
    <link href="${ctx}/static/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
    <!--[if IE]>
    <link href="${ctx}/static/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
    <![endif]-->

    <!--[if lte IE 9]>
    <script src="${ctx}/static/dwz/js/speedup.js" type="text/javascript"></script>
    <![endif]-->

    <script src="${ctx}/static/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
    <script src="${ctx}/static/dwz/js/jquery.cookie.js" type="text/javascript"></script>
    <script src="${ctx}/static/dwz/js/jquery.validate.js" type="text/javascript"></script>
    <script src="${ctx}/static/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
    <script src="${ctx}/static/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
    <script src="${ctx}/static/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

    <!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
    <script type="text/javascript" src="${ctx}/static/chart/raphael.js"></script>
    <script type="text/javascript" src="${ctx}/static/chart/g.raphael.js"></script>
    <script type="text/javascript" src="${ctx}/static/chart/g.bar.js"></script>
    <script type="text/javascript" src="${ctx}/static/chart/g.line.js"></script>
    <script type="text/javascript" src="${ctx}/static/chart/g.pie.js"></script>
    <script type="text/javascript" src="${ctx}/static/chart/g.dot.js"></script>

    <!-- 可以用dwz.min.js替换前面全部dwz.*.js (注意：替换是下面dwz.regional.zh.js还需要引入)-->
    <script src="${ctx}/static/dwz/js/dwz.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

    <script type="text/javascript" src="${ctx}/static/treeTable/jquery.treetable.js"></script>

    <script type="text/javascript">
        $(function(){
            DWZ.init("${ctx}/static/dwz/dwz.frag.xml", {
                loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.jsp",	// 跳到登录页面
                statusCode:{ok:200, error:300, timeout:301}, //【可选】
                pageInfo:{pageNum:"pageNo", numPerPage:"pageSize", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
                keys: {statusCode:"statusCode", message:"message"}, //【可选】
                ui:{hideMode:'offsets'}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
                debug:false,	// 调试模式 【true|false】
                callback:function(){
                    initEnv();
                    $("#themeList").theme({themeBase:"${ctx}/static/dwz/themes"}); // themeBase 相对于index页面的主题base路径
                }
            });

            // 设置当前系统时间
            setCurrentTime();
        });
        var t = new Date("${currentTime}");
        function setCurrentTime(){
            t = t.getTime() + 1000;
            t =new Date(t);
            document.getElementById("currentTime").innerHTML = "当前系统时间:" + t.formatDate("yyyy-MM-dd HH:mm:ss");
            // 1秒执行一次
            window.setTimeout(setCurrentTime, 1000);
        }
    </script>
</head>

<body scroll="no">
<div id="layout">
<div id="header">
    <div class="headerNav">
        <a class="logo" href="${ctx}/">标志</a>
        <ul class="nav">
            <li><a href="${ctx}/">首页</a></li>
            <li><a href="${ctx}/rbac/logout">退出</a></li>
        </ul>
        <ul class="themeList" id="themeList">
            <li theme="default"><div class="selected">蓝色</div></li>
            <li theme="green"><div>绿色</div></li>
            <!--<li theme="red"><div>红色</div></li>-->
            <li theme="purple"><div>紫色</div></li>
            <li theme="silver"><div>银色</div></li>
            <li theme="azure"><div>天蓝</div></li>
        </ul>
    </div>

    <!-- navMenu -->

</div>

<div id="leftside">
    <div id="sidebar_s">
        <div class="collapse">
            <div class="toggleCollapse"><div></div></div>
        </div>
    </div>
    <div id="sidebar">
        <div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

        <div class="accordion" fillSpace="sidebar">
            <jsp:include page="common/menus.jsp"/>
        </div>
    </div>
</div>
<div id="container">
    <div id="navTab" class="tabsPage">
        <div class="tabsPageHeader">
            <div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
                <ul class="navTab-tab">
                    <li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">首页</span></span></a></li>
                </ul>
            </div>
            <div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
            <div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
            <div class="tabsMore">more</div>
        </div>
        <ul class="tabsMoreList">
            <li><a href="javascript:;">首页</a></li>
        </ul>
        <div class="navTab-panel tabsPageContent layoutBox">
            <div class="page unitBox">
                <div class="accountInfo">
                    <p><span>下午好!<shiro:principal/></span></p>
                    <p id="currentTime"></p>
                </div>
                <div class="pageFormContent" layoutH="80" style="margin-right:230px">

                </div>

                <%--<div style="width:230px;position: absolute;top:60px;right:0" layoutH="80">--%>
                    <%--<iframe width="100%" height="430" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?width=0&height=430&fansRow=2&ptype=1&skin=1&isTitle=0&noborder=1&isWeibo=1&isFans=0&uid=1739071261&verifier=c683dfe7"></iframe>--%>
                <%--</div>--%>
            </div>

        </div>
    </div>
</div>

</div>

<div id="footer">Copyright &copy; 2010 <a href="demo_page2.html" target="dialog">DWZ团队</a> 京ICP备05019125号-10</div>


</body>
</html>