<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>婚庆企业管理平台 - <sitemesh:write property='title' /></title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/css/default.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/easyui/css/wedding.css" />
    <script type="text/javascript" src="${ctx}/static/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${ctx}/static/easyui/application/common.js"></script>
    <sitemesh:write property='head' />
</head>

<body style= '<sitemesh:write property="body.style"/>'
      class = '<sitemesh:write property="body.class" />'
      fit = '<sitemesh:write property="body.fit" />'
      scroll = '<sitemesh:write property="body.scroll" />'>

    <sitemesh:write property='body' />

</body>