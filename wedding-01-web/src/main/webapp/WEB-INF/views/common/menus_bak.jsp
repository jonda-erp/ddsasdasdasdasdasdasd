<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="accordionHeader">
    <h2><span>Folder</span>业务管理</h2>
</div>
<div class="accordionContent">
    <ul class="tree treeFolder">
        <li><a>订单管理</a>
            <ul>
                <li><a href="${ctx}/order/query" target="navTab" rel="navTab_wedding_order">订单管理</a></li>
            </ul>
        </li>
        <li><a>客户管理</a>
            <ul>
                <li><a href="w_panel.html" target="navTab" rel="w_panel">会员创建</a></li>
                <li><a href="w_tabs.html" target="navTab" rel="w_tabs">会员查询</a></li>
                <li><a href="w_tabs.html" target="navTab" rel="w_tabs1">客户回访</a></li>
            </ul>
        </li>

        <li><a>日常管理</a>
            <ul>
                <li><a href="w_validation.html" target="navTab" rel="w_validation">道具管理</a></li>
                <li><a href="w_button.html" target="navTab" rel="w_button">人员派工</a></li>
                <li><a href="w_textInput.html" target="navTab" rel="w_textInput">收支管理</a></li>
                <li><a href="w_combox.html" target="navTab" rel="w_combox">流失管理</a></li>
            </ul>
        </li>
    </ul>
</div>
<div class="accordionHeader">
    <h2><span>Folder</span>库存管理</h2>
</div>
<div class="accordionContent">
    <ul class="tree treeFolder">
        <li><a href="${ctx}/stock/businessOut" target="navTab" rel="stock_purchase">业务出库</a></li>
        <li><a href="${ctx}/stock/otherOut" target="navTab" rel="stock_purchase">其他出库</a></li>
        <li><a href="${ctx}/stock/outOrder" target="navTab" rel="stock_purchase">出库订单</a></li>
        <li><a href="${ctx}/stock/apply" target="navTab" rel="stock_purchase">采购申请</a></li>
        <li><a href="demo_page1.html" target="navTab" rel="demo_page2">调拨管理</a></li>
        <li><a href="demo_page4.html" target="navTab" rel="demo_page4">销售出库</a></li>
        <li><a href="demo_page5.html" target="navTab" rel="demo_page5">库存查询</a></li>
    </ul>
</div>
<div class="accordionHeader">
    <h2><span>Folder</span>报表中心</h2>
</div>
<div class="accordionContent">
    <ul class="tree treeFolder">
        <li><a href="newPage1.html" target="navTab" rel="dlg_page">订单统计</a></li>
        <li><a href="newPage1.html" target="navTab" rel="dlg_page2">收支统计</a></li>
        <li><a href="newPage1.html" target="navTab" rel="dlg_page3">派工报表</a></li>
        <li><a href="newPage1.html" target="navTab" rel="dlg_page4">利润统计</a></li>
        <li><a href="newPage1.html" target="navTab" rel="dlg_page5">库存统计</a></li>
    </ul>
</div>
<div class="accordionHeader">
    <h2><span>Folder</span>系统设置</h2>
</div>
<div class="accordionContent">
    <ul class="tree treeFolder">
        <li><a>系统用户管理</a>
            <ul>
                <li><a href="${ctx}/rbac/user/index" target="navTab" rel="navTab_rbac_user">系统用户设置</a></li>
                <li><a href="${ctx}/rbac/role/index" target="navTab" rel="navTab_rbac_role">用户角色设置</a></li>
                <li><a href="${ctx}/rbac/permission/index" target="navTab" rel="navTab_rbac_permission">系统权限设置</a></li>
            </ul>
        </li>
        <li><a>员工设置</a>
            <ul>
                <li><a href="newPage1.html" target="navTab" rel="dlg_page3">员工管理</a></li>
                <li><a href="${ctx}/rbac/department/index" target="navTab" rel="dlg_page6">部门设置</a></li>

            </ul>
        </li>
        <li><a>企业设置</a>
            <ul>
                <li><a href="newPage1.html" target="navTab" rel="dlg_page4">道具设置</a></li>
                <li><a href="newPage1.html" target="navTab" rel="dlg_page5">产品设置</a></li>
            </ul>
        </li>
    </ul>
</div>