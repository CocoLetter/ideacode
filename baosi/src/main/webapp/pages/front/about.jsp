<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 页面头部 -->

<head>
    <title>关于宝四</title>
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
            <h3>关于宝四</h3>
        </div>
        <ul>
            <li class="active"><a href=${pageContext.request.contextPath}/about/findAbout.do>公司简介</a></li>
            <li><a href=${pageContext.request.contextPath}/about/findCulture.do>企业文化</a></li>
            <li><a href=${pageContext.request.contextPath}/about/findManage.do>管理团队</a></li>
            <li><a href=${pageContext.request.contextPath}/about/findHonor.do>荣誉资质</a></li>
        </ul>
    </div>
    <div class="pg-area">
        <div class="pg-topbar">
            <h3>当前位置：<a href="${pageContext.request.contextPath}/index/findAll.do">网站首页</a>&nbsp;/&nbsp;关于宝四</h3>
        </div>
        <div class="abpg-con">
            <p>
                上海宝四机械工程有限公司成立于2010年，是一家专业生产管道加工设备的制造商。公司主要从事天然气、石油、电力等行业管道加工设备的生产、销售、租赁以及管道抢维修工程服务。自成立以来，宝四一直致力于为中石油、中石化、中海油、中国核工业及其建设单位提供优质产品与专业服务，且公司产品与服务在多个国家重点项目建设中广泛使用，获得使用方的一致认可与好评。公司凭借一流的产品服务质量与商业信誉，于2012年顺利通过ISO9001质量管理体系认证、ISO14001环境管理体系认证与OHSAS18001职业健康安全管理体系认证。
            </p>
            <p>
                上海宝四机械工程有限公司的产品现已广泛应用于国内外天然气、石油、化工、船舶、铁路、电力（火电、核电、风电、水电）、航天、钢铁、生物制药、军工以及民用建筑等行业。依靠雄厚的科研实力，公司顺利完成国内某重点设计院关于“新型管道冷切割坡口设备课题”项目，该技术赶超国际先进水平，并获得国家专利保护，其受到同行的称赞和用户的青睐，是享誉行业的知名产品。
            </p>
            <p>
                公司秉承“顾客至上，合作共赢”的经营理念，坚持“开放包容，锐意进取”的发展宗旨，为国内外客户在安全、节能、环保、提升工程竞争力等方面提供优质产品和专业服务。为构建安全运行的能源管网环境，宝四努力奋进，脚踏实地，精雕细琢，迈步向前。
            </p>
            <p>
                胸怀天下，志存高远，宝四真挚欢迎各界朋友莅临参观、指导和业务洽谈！
            </p>
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