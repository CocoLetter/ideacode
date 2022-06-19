<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 页面头部 -->

<!-- 页面头部 -->
<head>
    <title>Equipment leasing</title>
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
            <h3>Equipment Leasing</h3>
        </div>
        <ul>
            <li><a href="${pageContext.request.contextPath}/business-pre/findRent1.do?lang=1">Cold Cutting Machine</a></li>
            <li><a href="${pageContext.request.contextPath}/business-pre/findRent2.do?lang=1">Generator Set</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/business-pre/findRent3.do?lang=1">Hydraulic Wrench</a></li>
        </ul>
    </div>
    <div class="pg-area">
        <div class="pg-topbar">
            <h3>Current Locations ：<a href="${pageContext.request.contextPath}/index/findAll.do?lang=1">Home</a>&nbsp;/&nbsp;Equipment Leasing</h3>
        </div>
        <div class="pro-detail">
            <h1>Hydraulic Wrench</h1><br/>
            <img id="yeyabanshou_en" style="width: 600px;height: 450px" src="${pageContext.request.contextPath}/static/images/pro/pr6-1.jpg" alt="" />
            <div class="prodetail-con">
                <p><span>Product Name：</span>Hydraulic Wrench</p>
                <p><span>Model：</span>Details in <i style="color: #0F6996">selection parameter table</i></p>
                <p><span>租赁价格：</span>面议</p>
                <p><span>产品特点：</span></p>
                <p><span>Price：</span>Discuss personally</p>
                <p><span>Product Characteristics：</span></p>
                <p>1.Flat body, equal thickness design makes the shape smaller.</p>
                <p>2.High strength material fuselage, light weight, high torque weight ratio.</p>
                <p>3.The output accuracy is ± 3%, accurate and efficient.</p>
                <p>4.Compact fillet radius, easy to operate in narrow space.</p>
                <p>5.Turn 27 ° per stroke, fast speed.</p>
                <p>6.Special surface anti-corrosion treatment, suitable for use in harsh environment.</p>
                <p>If in doubt,<a href="${pageContext.request.contextPath}/contact/findContact.do?lang=1">Contact Us</a></p><br>
                <img id ="yybsParamTable_en" style="height:auto " src="${pageContext.request.contextPath}/static_en/images/pro/yeyabanshou.png" alt=""/>
            </div>
            <a class="more" href="${pageContext.request.contextPath}/business-pre/findRent.do?lang=1">Back to list</a>
        </div>

    </div>
</div>


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