<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 页面头部 -->
<head>
    <title>Company News</title>
    <meta charset="utf-8"/>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta name="viewport" content="width=100%, user-scalable=no">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static_en/css/banner-j.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static_en/css/main.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static_en/font-awesome/css/font-awesome.min.css"/>
</head>

<body>
<!--nav-->
<div class="nav">
    <ul class="clearfix1">
        <li>
            <div class="logo"><a href="${pageContext.request.contextPath}/index/findAll.do?lang=1"><img
                    src="${pageContext.request.contextPath}/static/images/logo.png" alt="logo"/></a></div>
        </li>
        <li>
            <p class="logotitle">上 海 宝 四 机 械 工 程 有 限 公 司</p>
            <p class="english">BaoSi PiPing Master CO.,Ltd.</p>
        </li>
    </ul>
    <ul class="clearfix">
        <li class="menu">
            <a href="${pageContext.request.contextPath}/index/findAll.do?lang=1">Home</a>
        </li>
        <li class="menu">
            <a href="${pageContext.request.contextPath}/about/findAbout.do?lang=1">About Us</a>
            <ul class="dropdown">
                <li>
                    <a href="${pageContext.request.contextPath}/about/findAbout.do?lang=1">Company Brief</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/about/findCulture.do?lang=1">Enterprise Culture</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/about/findManage.do?lang=1">Manage Group</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/about/findHonor.do?lang=1">Honor & Certification</a>
                </li>
            </ul>
        </li>
        <li class="menu">
            <a href="${pageContext.request.contextPath}/product-pre/toProduct.do?lang=1">Products</a>
            <ul class="dropdown" style="width: 240px" id="showProduct">

            </ul>
        </li>
        <li class="menu">
            <a href="${pageContext.request.contextPath}/business-pre/findEngineeringService.do?lang=1">Business</a>
            <ul class="dropdown">
                <li>
                    <a href="${pageContext.request.contextPath}/business-pre/findEngineeringService.do?lang=1">Engineering Service</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/business-pre/findSale.do?lang=1">Equipment Sales</a>
                </li>
                <li>
                    <a target="_blank">Shipping Business</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/business-pre/findRent.do?lang=1">Equipment Leasing</a>
                </li>
            </ul>
        </li>
        <li class="menu">
            <a href="${pageContext.request.contextPath}/case_pre/toCase.do?lang=1">Applications</a>
        </li>
        <li class="menu">
            <a href="${pageContext.request.contextPath}/news-pre/findCorNews.do?lang=1">News</a>
            <ul class="dropdown">
                <li>
                    <a href="${pageContext.request.contextPath}/news-pre/findCorNews.do?lang=1">Company News</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/news-pre/findIndNews.do?lang=1">Industry Information</a>
                </li>
            </ul>
        </li>
        <li class="menu">
            <a href="${pageContext.request.contextPath}/contact/findContact.do?lang=1">Contact Us</a>
        </li>
        <li class="language"><a href="${pageContext.request.contextPath}/index/findAll.do"><em class="fa fa-globe" aria-hidden="true"></em> 中文</a></li>
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
            <h3>News</h3>
        </div>
        <ul>
            <li class="active"><a href="${pageContext.request.contextPath}/news-pre/findCorNews.do?lang=1">Company News</a></li>
            <li class><a href="${pageContext.request.contextPath}/news-pre/findIndNews.do?lang=1">Industry News</a></li>
        </ul>
    </div>
    <div class="pg-area">
        <div class="pg-topbar">
            <h3>Current News:<a href="${pageContext.request.contextPath}/index/findAll.do?lang=1">Home</a>&nbsp;/&nbsp;Company News</h3>
        </div>
        <div class="nepg-con">
            <div class="news-detail">
                <h1>${news.title}</h1>
                <pre><span>Publish Time：${news.releaseDateStr}      Tag：${news.newsTypeStr}</span></pre>
                <div class="nedetail-con">
                    <p class="content">${news.newsContent}</p>
                    <br>
                    <p>Prev:<a href="${pageContext.request.contextPath}/news-pre/toCorNewsDetails.do?lang=1&id=${newsBack.id}"
                              style="color:rgba(21, 129, 175, 1)">${newsBack.title}</a></p>
                    <p>Next:<a href="${pageContext.request.contextPath}/news-pre/toCorNewsDetails.do?lang=1&id=${newsFor.id}"
                              style="color:rgba(21, 129, 175, 1)">${newsFor.title}</a></p>
                </div>
                <a class="more" href="${pageContext.request.contextPath}/news-pre/findCorNews.do?lang=1">Back to list</a>
            </div>
        </div>
    </div>
</div>

<div class="space"></div>

<!-- 页面尾部 -->
<jsp:include page="footer_en.jsp"></jsp:include>
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
            url: "/product-pre/getProductList.do?lang=1",  //传入后台地址
            dataType: "json",
            success: function (result) {                  //请求成功返回的信息
                if (result.success) {
                    var productList = result.productList;
                    var content = '';
                    $.each(productList, function (i, product) {
                        content += '<li>' +
                            ' <a href="/product-pre/findById.do?lang=1&id='+product.id +'" style="text-align: left">'+ product.productName+'</a>' +
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
