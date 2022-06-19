<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<!-- 页面头部 -->--%>
<%--<jsp:include page="header.jsp"></jsp:include>--%>
<%--<!-- 页面头部 /-->--%>

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
<!--about-->
<div class="about">
    <section class="title" style="height: 0px">
        <div>
            <h2>关于宝四</h2>
        </div>
    </section>
    <div class="ab-area clearfix">
        <img src="${pageContext.request.contextPath}/static/images/ab.jpg" alt=""/>
        <div class="clearfix">
            <div class="ab-con">
                <a href="${pageContext.request.contextPath}/about/findAbout.do"><h3>我们为全球客户提供专业管道加工服务！</h3></a>
                <p>
                    上海宝四机械工程有限公司成立于2010年，公司主要从事天然气、石油、电力等行业管道加工设备的生产、销售、租赁以及管道抢维修工程服务。若您需要宝四人为您提供管道解决方案，请将具体工况信息告诉我们，我们秉承您的技术要求和多年经验为您提供最优方案！
                </p>
                <a href="${pageContext.request.contextPath}/case_pre/toCase.do"><h3>专业的管道加工设备制造厂商！</h3></a>
            </div>
            <div class="ab-btn">
                <a href="${pageContext.request.contextPath}/about/findAbout.do">查看更多</a>
                <a href="${pageContext.request.contextPath}/contact/findContact.do">联系我们</a>
            </div>
        </div>
    </div>
</div>
<br/>
<div class="bussiness0">
    <section class="title" style="height: 0px">
        <div>
            <h2>公司业务</h2>
        </div>
    </section>
    <div class="ab-advantage">
        <ul class="clearfix">
            <li>
                <a href="${pageContext.request.contextPath}/business-pre/findRent.do"><img src="${pageContext.request.contextPath}/static/images/ad1.png" alt=""/>
                    <h3>设备租赁</h3></a>
                <p>管道施工所需的设备租赁</p>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/business-pre/findSale.do"><img src="${pageContext.request.contextPath}/static/images/ad2.png" alt=""/>
                    <h3>设备销售</h3></a>
                <p>管道施工过程中需要的安全作业销售</p>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/business-pre/findEngineeringService.do"><img src="${pageContext.request.contextPath}/static/images/ad3.png" alt=""/>
                    <h3>工程服务</h3></a>
                <p>动火连头管道预制技术与焊接安装服务</p>
            </li>
            <li>
                <a target="_blank"><img src="${pageContext.request.contextPath}/static/images/ad4.png" alt=""/>
                    <h3>船艇业务</h3></a>
                <p>船艇常用配件与船艇保养业务</p>
            </li>
        </ul>
        <br/><br/>
    </div>
</div>
<!--pro-li-->
<div class="pro-li">
    <section class="title" style="height: 0px">
        <div>
            <h2>产品展示</h2>
        </div>
        <a class="more" href="${pageContext.request.contextPath}/product-pre/toProduct.do">查看更多</a>
    </section>
    <div class="clearfix">
        <div class="proli-left">
            <a href="${pageContext.request.contextPath}/product-pre/toProduct.do">
                <div class="proli-title">
                    <h3>低间隙分瓣式切割坡口机</h3>
                </div>
                <br/>
                <img style="height: 300px;width: 450px" src="${pageContext.request.contextPath}/static/images/pro.jpg"  alt=""/>
            </a>
        </div>
        <div class="proli-right clearfix">
            <div>
                <a href="${pageContext.request.contextPath}/product-pre/toProduct.do?index=1">
                    <div class="proli-title">
                        <h3>内涨式坡口机</h3>
                    </div>
                    <br/>
                    <img style="height: 300px;width: 450px" src="${pageContext.request.contextPath}/static/images/pro/pr1.jpg"  alt=""/>
                </a>
            </div>
            <div>
                <a href="${pageContext.request.contextPath}/product-pre/toProduct.do?index=2" style="height: 384px">
                    <div class="proli-title">
                        <h3>外卡自动坡口机</h3>
                    </div>
                    <br/>
                    <img style="height: 300px;width: 450px" src="${pageContext.request.contextPath}/static/images/pro/pr2.jpg"  alt=""/>
                </a>
            </div>
        </div>
    </div>
</div>
<!--news-->
<div class="news">
    <section class="title" style="height: 0px">
        <div>
            <h2>新闻动态</h2>
        </div>
    </section>
    <div class="news-class clearfix">
        <div class="news-cp">
            <div class="clearfix">
                <a href="${pageContext.request.contextPath}/news-pre/findCorNews.do" style="color: rgba(21, 129, 175, 1)"><h3>公司新闻</h3>
                    <img src="${pageContext.request.contextPath}/static/images/pic1.png" alt=""/></a>
                <ul>
                    <c:forEach items="${CorNewsList}" var="news" begin="0" end="1">
                        <li>
                            <a href="${pageContext.request.contextPath}/news-pre/toCorNewsDetails.do?id=${news.id}">
                                <span>${news.releaseDateStr}</span>
                                <h4>${news.title}</h4>
                                <p>${news.keywords}</p>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
                <a class="more" href="${pageContext.request.contextPath}/news-pre/findCorNews.do">查看更多</a>
            </div>
        </div>
        <div class="news-hy">
            <div class="clearfix">
                <a href="${pageContext.request.contextPath}/news-pre/findIndNews.do" style="color: rgba(21, 129, 175, 1)"><h3>行业资讯</h3>
                    <img src="${pageContext.request.contextPath}/static/images/pic2.png" alt=""/></a>
                <ul>
                    <c:forEach items="${IndNewsList}" var="news" begin="0" end="1">
                        <li>
                            <a href="${pageContext.request.contextPath}/news-pre/toIndNewsDetails.do?id=${news.id}">
                                <span>${news.releaseDateStr}</span>
                                <h4>${news.title}</h4>
                                <p>${news.keywords}</p>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
                <a class="more" href="${pageContext.request.contextPath}/news-pre/findIndNews.do">查看更多</a>
            </div>
        </div>
    </div>
</div>
<!--partner-->
<div class="partner">
    <section class="title" style="height: 0px">
        <div>
            <h2>信任见证</h2>
        </div>
    </section>
    <ul class="clearfix">
        <li><a href="http://www.cnpc.com.cn" target="_blank"><img src="${pageContext.request.contextPath}/static/images/partner/part1.jpg" alt=""/></a>
        </li>
        <li><a href="http://www.sinopec.com/listco/" target="_blank"><img src="${pageContext.request.contextPath}/static/images/partner/part2.jpg"
                                                                          alt=""/></a>
        </li>
        <li><a href="http://www.shenhuachina.com/" target="_blank"><img src="${pageContext.request.contextPath}/static/images/partner/part3.jpg"
                                                                        alt=""/></a></li>
        <li><a href="http://www.shanghai-electric.com/Pages/Index.aspx" target="_blank"><img
                src="${pageContext.request.contextPath}/static/images/partner/part4.jpg" alt=""/></a></li>
        <li><a href="https://www.cnooc.com.cn/" target="_blank"><img src="${pageContext.request.contextPath}/static/images/partner/par1.jpg"
                                                                     alt=""/></a>
        </li>
    </ul>
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
