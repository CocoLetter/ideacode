<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 页面头部 -->

<head>
    <title>设备销售</title>
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
        <li class="language"><a href="${pageContext.request.contextPath}/index/findAll.do?lang=1"><em
                class="fa fa-globe" aria-hidden="true"></em> English</a></li>
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
            <li class="active"><a href="${pageContext.request.contextPath}/business-pre/findSale.do">设备销售</a></li>
            <li><a>船艇业务</a></li>
            <li><a href="${pageContext.request.contextPath}/business-pre/findRent.do">设备租赁</a></li>
        </ul>
    </div>

    <div class="pg-area">
        <div class="pg-topbar">
            <h3>当前位置：<a href="${pageContext.request.contextPath}/index/findAll.do">网站首页</a>&nbsp;/&nbsp;设备销售</h3>
        </div>
        <div class="bussiness"><br/>
            <p>宝四提供动火连头管道预制技术服务与焊接安装服务。</p>
            <p>
                十年来，宝四为“西气东输一线工程”、“西气东输二线工程”、“西气东输三线工程”、“中贵线天然气管道工程”、“轮南-吐鲁番支干线管道工程”、“涩宁兰输气管道工程”、“陕京二线输气管道工程”、“陕京三线输气管道工程”等国内重特大能源管道项目提供大型动火连头设备一千二百多台次，处理焊口六百多道。公司现有冷切割设备120台，加工范围DN50--DN1500；热切割设备18台，加工范围DN200-DN1800；各类进口焊机22台；持证焊工8名。</p>
        </div>
        <br/>
        <div class="bussiness"><br/>
            <p>宝四为广大建设与施工单位提供管道施工所需的全新设备销售业务。销售设备主要为：管道切割（冷切割与热切割）设备、焊接设备、法兰加工设备、管道除应力设备、发电机组、液压扳手等。</p>
        </div>
        <br/>
        <div class="bussiness1">
            <ul class="clearfix">
                <li>
                    <a href="${pageContext.request.contextPath}/product-pre/toProduct.do"><img src="${pageContext.request.contextPath}/static/images/pro/pr8.jpg" alt=""/>
                        <h3>设备销售-低间隙分瓣式切割坡口机</h3></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/product-pre/toProduct.do"><img src="${pageContext.request.contextPath}/static/images/pro/pr1.jpg" alt=""/>
                        <h3>设备销售-内涨式坡口机</h3></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/product-pre/toProduct.do"><img src="${pageContext.request.contextPath}/static/images/pro/pr2.jpg" alt=""/>
                        <h3>设备销售-外卡自动坡口机</h3></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/product-pre/toProduct.do"><img src="${pageContext.request.contextPath}/static/images/pro/pr4.jpg" alt=""/>
                        <h3>设备销售-绞接式管割刀</h3></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/product-pre/toProduct.do"><img src="${pageContext.request.contextPath}/static/images/pro/pr6.jpg" alt=""/>
                        <h3>设备销售-液压扳手</h3></a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/product-pre/toProduct.do"><img src="${pageContext.request.contextPath}/static/images/pro/pr7.jpg" alt=""/>
                        <h3>设备销售-配件与耗材</h3></a>
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
                            ' <a href="/product-pre/findById.do?id=' + product.id + '" style="text-align: left">' + product.productName + '</a>' +
                            '     </li>';
                    });
                    $("#showProduct").html(content);
                } else {
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