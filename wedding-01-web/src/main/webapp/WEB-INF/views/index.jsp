<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>婚庆企业管理平台</title>

    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/css/default.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/themes/icon.css" />
    <script type="text/javascript" src="${ctx}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src='${ctx}/static/easyui/outlook2.js'> </script>
    <script type="text/javascript" src="${ctx}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
    <style type="text/css">
        body
        {
            font-size:12px;
        }

        .ftitle
        {
            font-size:14px;
            font-weight:bold;
            color:#666;
            padding:5px 0;
            margin-bottom:20px;
            border-bottom:1px solid #ccc;
        }

        .fitem
        {
            margin-bottom:15px;
        }

        .fitem label
        {
            display:inline-block;
            width:90px;
            text-align:right;
            vertical-align:top;
            margin-top:2px;
        }
        .fitem input
        {
            width:150px;
            height:auto;
        }
        .fitem select
        {
            width:150px;
            height:auto;
        }
        .fitem  textarea
        {
            width:300px;
            height:200px;
        }

        .searchitem
        {
            float:left;
            margin-left:30px;
            vertical-align:middle;
            width:220px;
            height:auto;
            margin-top:15px;
        }

        . searchitem  select
        {
            width:150px;
            height:auto;
        }

        .searchitem input
        {
            width:150px;
            height:auto;
        }

        .error
        {
            color:Red;
            font-size:10px;
            margin-left:5px;
        }

    </style>
    <script type="text/javascript">
        var _menus = {"menus":[
            {"menuid":"1","icon":"icon-sys","menuname":"订单管理",
                "menus":[
                    {"menuid":"12","menuname":"订单管理","icon":"icon-add","url":"${ctx}/order/query"},
                    {"menuid":"13","menuname":"用户管理","icon":"icon-users","url":"a.html"},
                    {"menuid":"14","menuname":"角色管理","icon":"icon-role","url":"http://www.baidu.com"},
                    {"menuid":"15","menuname":"权限设置","icon":"icon-set","url":"demo.html"},
                    {"menuid":"16","menuname":"系统日志","icon":"icon-log","url":"demo1.html"}
                ]
            },
            {"menuid":"8","icon":"icon-sys","menuname":"员工管理",
                "menus":[{"menuid":"21","menuname":"员工列表","icon":"icon-nav","url":"demo.html"},
                    {"menuid":"22","menuname":"视频监控","icon":"icon-nav","url":"demo1.html"}
                ]
            },
            {"menuid":"56","icon":"icon-sys","menuname":"部门管理",
                "menus":[{"menuid":"31","menuname":"添加部门","icon":"icon-nav","url":"demo1.html"},
                    {"menuid":"32","menuname":"部门列表","icon":"icon-nav","url":"demo2.html"}
                ]
            },
            {"menuid":"28","icon":"icon-sys","menuname":"财务管理",
                "menus":[{"menuid":"41","menuname":"收支分类","icon":"icon-nav","url":"demo.html"},
                    {"menuid":"42","menuname":"报表统计","icon":"icon-nav","url":"demo1.html"},
                    {"menuid":"43","menuname":"添加支出","icon":"icon-nav","url":"demo2.html"}
                ]
            },
            {"menuid":"39","icon":"icon-sys","menuname":"商城管理",
                "menus":[{"menuid":"51","menuname":"商品分类","icon":"icon-nav","url":"demo.html"},
                    {"menuid":"52","menuname":"商品列表","icon":"icon-nav","url":"demo1.html"},
                    {"menuid":"53","menuname":"商品订单","icon":"icon-nav","url":"demo2.html"}
                ]
            }
        ]};
        //设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }



        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(msg) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            })

        }

        $(function() {

            openPwd();

            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

            $('#btnCancel').click(function(){closePwd();})

            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

                    if (r) {
                        location.href = '/ajax/loginout.ashx';
                    }
                });
            })
        });



    </script>

</head>
<body class="easyui-layout" style="overflow-y: hidden"  scroll="no" fit="true">
<noscript>
    <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
        <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
    </div>
</noscript>
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;background: url(${ctx}/static/easyui/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
    <span style="float:right; padding-right:20px;" class="head">欢迎 XXXX <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a></span>
    <span style="padding-left:10px; font-size: 16px; "><img src="${ctx}/static/easyui/images/blocks.gif" width="20" height="20" align="absmiddle" /> 婚庆管理平台</span>
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
     maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
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
            <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                确定</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
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