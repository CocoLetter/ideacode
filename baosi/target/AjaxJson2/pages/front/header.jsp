<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>上海宝四机械工程有限公司</title>
    <meta charset="utf-8"/>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta name="viewport" content="width=100%, user-scalable=no">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/banner-j.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.min.css"/>
</head>

<body>


<!--nav-->
<div class="nav">
    <ul class="clearfix1">
        <li>
            <div class="logo"><a href="${pageContext.request.contextPath}/index/findAll.do"><img
                    src="${pageContext.request.contextPath}/static/images/logo.png" alt="logo"/></a></div>
        </li>
        <li>
            <p class="logotitle">上 海 宝 四 机 械 工 程 有 限 公 司</p>
            <p class="english">BaoSi PiPing Master CO.,Ltd.</p>
        </li>
    </ul>
    <ul class="clearfix">
        <li class="menu">
            <a href="${pageContext.request.contextPath}/index/findAll.do">首页</a>
        </li>
        <li class="menu">
            <a href="${pageContext.request.contextPath}/about/findAbout.do">关于宝四</a>
            <ul class="dropdown">
                <li>
                    <a href="${pageContext.request.contextPath}/about/findAbout.do">公司简介</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/about/findCulture.do">企业文化</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/about/findManage.do">管理团队</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/about/findHonor.do">荣誉资质</a>
                </li>
            </ul>
        </li>
        <li class="menu">
            <a href="${pageContext.request.contextPath}/product-pre/findAll.do?id=3">产品中心</a>
            <ul class="dropdown" style="width: 240px" id="showProduct">
<%--                <li>--%>
<%--                    <a href="/pages/products.jsp" style="text-align: left">低间隙分瓣式切割坡口机</a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/pages/products1.jsp" style="text-align: left">内涨式坡口机</a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/pages/products2.jsp" style="text-align: left">外卡自动坡口机</a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/pages/products3.jsp" style="text-align: left">冷切割机</a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/pages/products4.jsp" style="text-align: left">绞接式管割刀</a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/pages/products5.jsp" style="text-align: left">液压扳手</a>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <a href="/pages/products6.jsp" style="text-align: left">配件与耗材</a>--%>
<%--                </li>--%>
            </ul>
        </li>
        <li class="menu">
            <a href="/pages/engineeringservice.jsp">公司业务</a>
            <ul class="dropdown">
                <li>
                    <a href="/pages/engineeringservice.jsp">工程服务</a>
                </li>
                <li>
                    <a href="/pages/sale.jsp">设备销售</a>
                </li>
                <li>
                    <a href="/pages/http://www.cnsunbird.com/" target="_blank">船艇业务</a>
                </li>
                <li>
                    <a href="/pages/rent.jsp">设备租赁</a>
                </li>
            </ul>
        </li>
        <li class="menu">
            <a href="${pageContext.request.contextPath}/case_pre/toCase.do">业绩案例</a>
        </li>
        <li class="menu">
            <a href="${pageContext.request.contextPath}/news-pre/findCorNews.do">新闻动态</a>
            <ul class="dropdown">
                <li>
                    <a href="${pageContext.request.contextPath}/news-pre/findCorNews.do">公司新闻</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/news-pre/findIndNews.do">行业资讯</a>
                </li>
            </ul>
        </li>
        <li class="menu">
            <a href="${pageContext.request.contextPath}/contact/findContact.do">联系我们</a>
        </li>
        <li class="language"><a href="${pageContext.request.contextPath}/index/findAll.do?lang=1"><em class="fa fa-globe" aria-hidden="true"></em> English</a></li>
    </ul>
</div>
<!--banner-->
<script src="${pageContext.request.contextPath}/jquery/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/script/docs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/layer/layer.js"></script>
<script type="text/javascript">
    //页面加载获取一个一部请求获取产品的种类,然后渲染到页面
    $(function () {
       getProductsList();
    });

    function getProductsList() {
        $.ajax({
            type: "GET",
            url: "/product-pre/getProductList.do",  //传入后台地址
            dataType: "json",
            success: function (result) {                  //请求成功返回的信息
                if (result.success) {
                    var productList = result.productList;
                    var content = '';
                    //tbody 主体内容
                    $.each(productList, function (i, product) {
                       content += '<li>' +
                           ' <a href="/pages/products.jsp?" style="text-align: left">'+ product.productName+'</a>' +
                           '     </li>';
                    });
                    $("#showProduct").html(content);
                }else{
                    layer.msg("产品为空或内部错误");
                }
            },
            error: function () {
                alert("请求错误");
            }
        });
    }
</script>

</body>


