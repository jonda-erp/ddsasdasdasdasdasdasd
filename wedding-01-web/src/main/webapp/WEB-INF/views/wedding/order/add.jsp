<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>婚庆企业管理平台</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/css/default.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/css/wedding.css" />
    <script type="text/javascript" src="${ctx}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${ctx}/static/easyui/application/order/order.js"></script>
    <script type="text/javascript" src="${ctx}/static/easyui/application/common.js"></script>
    <script type="text/javascript">
        var url = "${ctx}/order/doAdd";
    </script>
</head>
<body>
    <form id="ff" method="post">
        <div>
            <label for="brideName">新娘姓名:</label>
            <input class="easyui-validatebox" type="text" id="brideName" name="brideName" data-options="required:true" />
        </div>
        <div>
            <label for="brideTelephone">新娘电话:</label>
            <input class="easyui-validatebox" type="text" id="brideTelephone" name="brideTelephone" data-options="validType:'email'" />
        </div>
        <div>
            <label for="bridegroomName">新郎姓名:</label>
            <input class="easyui-validatebox" type="text" id="bridegroomName" name="bridegroomName" data-options="validType:'email'" />
        </div>
        <div>
            <label for="bridegroomTelephone">新郎电话:</label>
            <input class="easyui-validatebox" type="text" id="bridegroomTelephone" name="bridegroomTelephone" data-options="validType:'email'" />
        </div>
        <div>
            <label for="sDate">婚庆日期:</label>
            <input class="easyui-validatebox" type="text" id="sDate" name="sDate" data-options="validType:'email'" />
        </div>
        <div>
            <label for="remark">备注:</label>
            <input class="easyui-validatebox" type="text" id="remark" name="remark" data-options="validType:'email'" />
        </div>
        <div>
            <label for="contractNo">合同编号:</label>
            <input class="easyui-validatebox" type="text" id="contractNo" name="contract.contractNo" data-options="validType:'email'" />
        </div>
        <div>
            <label for="content">备注:</label>
            <input class="easyui-validatebox" type="text" id="content" name="contract.content" data-options="validType:'email'" />
        </div>
    </form>
</body>