<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 页面头部 -->

<head>
    <title>产品中心</title>
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
<%--ｈｅａｄ结束--%>

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
            <h3>产品中心</h3>
        </div>
        <ul>
            <c:forEach items="${productList}" var="product">
                <c:if test="${product.id == pro.id}">
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/product-pre/findById.do?id=${pro.id}">${pro.productName}</a>
                    </li>
                </c:if>
                <c:if test="${product.id != pro.id}">
                    <li>
                        <a href="${pageContext.request.contextPath}/product-pre/findById.do?id=${product.id}">${product.productName}</a>
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </div>
    <div class="pg-area">
        <div class="pg-topbar">
            <h3>当前位置：<a href="${pageContext.request.contextPath}/index/findAll.do">网站首页</a>&nbsp;/&nbsp;产品中心</h3>
        </div>
        <div class="pro-detail">
            <h1>${pro.productName}</h1><br/><br/>
            <img id="prodImg" style="height: 450px;width: 600px" src=${pageContext.request.contextPath}/${pro.url} alt=""/>
            <div class="prodetail-con">
                <p><span>产品名称：</span>${pro.productName}</p>
                <p><span>型　　号：</span>详见页面底部选型参数表</p>
                <p><span>产品价格：</span>${pro.productPrice}</p>
                <p><span>产品介绍:</span></p>
                <p>${pro.productDesc}</p>
                <p><span>产品特点：</span>${pro.productChar}</p>
                <p>如有疑问，<a href="${pageContext.request.contextPath}/contact/findContact.do">联系我们</a></p>
                <img id ="#"  src=${pageContext.request.contextPath}/${pro.prodParamUrl} alt=""/>
            </div>
            <br>
            <ul class="pagination">
                <c:if test="${proFor == null}">
                    <li><a href="${pageContext.request.contextPath}/product-pre/findById.do?id=${pro.id}"> << </a>
                    </li>
                </c:if>
                <c:if test="${proFor != null}">
                    <li><a href="${pageContext.request.contextPath}/product-pre/findById.do?id=${proFor.id}"> << </a>
                    </li>
                </c:if>
                <c:if test="${proBack == null}">
                    <li><a href="${pageContext.request.contextPath}/product-pre/findById.do?id=${pro.id}"> >&gt; </a>
                    </li>
                </c:if>
                <c:if test="${proBack != null}">
                    <li>
                        <a href="${pageContext.request.contextPath}/product-pre/findById.do?id=${proBack.id}"> >&gt; </a>
                    </li>
                </c:if>
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
