<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 页面头部 -->

<head>
    <title>Engineering Service</title>
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
            <h3>Business</h3>
        </div>
        <ul>
            <li class="active"><a href="${pageContext.request.contextPath}/business-pre/findEngineeringService.do?lang=1">Engineering Service</a></li>
            <li><a href=${pageContext.request.contextPath}/business-pre/findSale.do?lang=1>Equipment Sale</a></li>
            <li><a>Shipping Business</a></li>
            <li><a href=${pageContext.request.contextPath}/business-pre/findRent.do?lang=1>Equipment Leasing</a></li>
        </ul>
    </div>
    <div class="pg-area">
        <div class="pg-topbar">
            <h3>Current Locations ：<a href="${pageContext.request.contextPath}/index/findAll.do?lang=1">Home</a>&nbsp;/&nbsp;Engineering Service</h3>
        </div>
        <div class="bussiness"><br/>
            <p>Baosi provides technical services for prefabrication and welding installation of hot work connecting pipes.</p>
            <p>In the past ten years, Baosi has been one of the major and extra large energy pipeline projects in China, including "the first line project of West East Gas Transmission", "the second line project of West East Gas Transmission", "the third line project of West East Gas Transmission", "Zhonggui natural gas pipeline project", "Lunnan Turpan branch pipeline project", "Sebei ninglan gas pipeline project", "Shaanxi Beijing second line gas pipeline project", "Shaanxi Beijing third line gas pipeline project" The project provides more than 1200 large-scale hot work connecting equipment and more than 600 welding junctions. The company has 120 cold cutting equipment, with processing range of dn50-dn1500; 18 hot cutting equipment, with processing range of dn200-dn1800; 22 imported welding machines; 8 welders with certificates.</p>
        </div><br/>
        <div class="bussiness2">
            <ul class="clearfix">
                <li>
                    <img src="${pageContext.request.contextPath}/static_en/images/engineeringservice/0.jpg" alt="" />
                    <h3>West-to-East Natural Gas Transportation Project: Line One</h3>
                </li>
                <li>
                    <img src="${pageContext.request.contextPath}/static_en/images/engineeringservice/1.jpg" alt="" />
                    <h3>West-to-East Natural Gas Transportation Project: Line Two</h3>
                </li>
                <li>
                    <img src="${pageContext.request.contextPath}/static_en/images/engineeringservice/2.jpg" alt="" />
                    <h3>West-to-East Natural Gas Transportation Project: Line Three</h3>
                </li>
                <li>
                    <img src="${pageContext.request.contextPath}/static_en/images/engineeringservice/3.jpg" alt="" />
                    <h3>Zhonggui Gas Pipeline Project</h3>
                </li>
                <li>
                    <img src="${pageContext.request.contextPath}/static_en/images/engineeringservice/4.jpg" alt="" />
                    <h3>Lunnan Turpan Branch Pipeline Project</h3>
                </li>
                <li>
                    <img src="${pageContext.request.contextPath}/static_en/images/engineeringservice/5.jpg" alt="" />
                    <h3>Sebei Ninglan Gas Transmission Pipeline Project</h3>
                </li>
            </ul>
        </div>
        <a class="more" download="cases.pdf" href="${pageContext.request.contextPath}/static/file/cases.pdf">More Cases</a>
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