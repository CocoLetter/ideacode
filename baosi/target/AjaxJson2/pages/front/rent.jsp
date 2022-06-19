<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 页面头部 -->

<head>
    <title>设备租赁</title>
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
            <a href="${pageContext.request.contextPath}/product-pre/toProduct.do">产品中心</a>
            <ul class="dropdown" style="width: 240px" id="showProduct">

            </ul>
        </li>
        <li class="menu">
            <a href="${pageContext.request.contextPath}/business-pre/findEngineeringService.do">公司业务</a>
            <ul class="dropdown">
                <li>
                    <a href="${pageContext.request.contextPath}/business-pre/findEngineeringService.do">工程服务</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/business-pre/findSale.do">设备销售</a>
                </li>
                <li>
                    <a target="_blank">船艇业务</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/business-pre/findRent.do">设备租赁</a>
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

<!-- 页面头部 /-->

<div id="wrapper">
    <div class="fullwidthbanner-container">
        <div class="fullwidthbanner">
            <ul>
                <c:forEach items="${imageSlideList}" var="image">
                    <li data-transition="3dcurtain-horizontal" data-slotamount="30" data-masterspeed="1000"
                        data-link="#">
                        <img src="${pageContext.request.contextPath}/${image.url}" alt=""/>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<div class="pro-re clearfix">
    <div class="pg-nav">
        <div>
            <h3>公司业务</h3>
        </div>
        <ul>
            <li><a href="${pageContext.request.contextPath}/business-pre/findEngineeringService.do">工程服务</a></li>
            <li><a href="${pageContext.request.contextPath}/business-pre/findSale.do">设备销售</a></li>
            <li><a>船艇业务</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/business-pre/findRent.do">设备租赁</a></li>
        </ul>
    </div>
    <div class="pg-area">
        <div class="pg-topbar">
            <h3>当前位置：<a href="${pageContext.request.contextPath}/index/findAll.do">网站首页</a>&nbsp;/&nbsp;设备租赁</h3>
        </div>
        <div class="bussiness"><br/>
            <p>宝四为广大建设与施工单位提供管道施工所需的设备租赁业务。租赁机器主要为：管道切割（冷切割与热切割）设备、管道封堵设备、法兰加工设备、管道除应力设备、发电机组、液压扳手。</p>
        </div><br/>
        <div class="bussiness1">
            <ul class="clearfix">
                <li>
                    <a href="${pageContext.request.contextPath}/business-pre/findRent1.do"><img src="${pageContext.request.contextPath}/static/images/pro/pr3.jpg" alt="" />
                        <h3>设备租赁-冷切割机</h3></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/business-pre/findRent2.do"><img src="${pageContext.request.contextPath}/static/images/pro/pr5.jpg" alt="" />
                        <h3>设备租赁-发电机组</h3></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/business-pre/findRent3.do"><img src="${pageContext.request.contextPath}/static/images/pro/pr6-1.jpg" alt="" />
                        <h3>设备租赁-液压扳手</h3></a>
                </li>
            </ul>
        </div>
    </div>
</div>


<div class="space"></div>
<!-- 页面尾部 -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- 页面尾部 /-->


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
                    $.each(productList, function (i, product) {
                        content += '<li>' +
                            ' <a href="/product-pre/findById.do?id='+product.id +'" style="text-align: left">'+ product.productName+'</a>' +
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