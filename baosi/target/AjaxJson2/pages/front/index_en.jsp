<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 页面头部 -->
<head>
    <title>BaoSi PiPing Master CO.,Ltd.</title>
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
<!--about-->
<div class="about">
    <section class="title" style="height: 0px">
        <div>
            <h2>About Us</h2>
        </div>
    </section>
    <div class="ab-area clearfix">
        <img src="${pageContext.request.contextPath}/static/images/ab.jpg" alt=""/>
        <div class="clearfix">
            <div class="ab-con">
                <a href="${pageContext.request.contextPath}/about/findAbout.do?lang=1">
                    <h3 style="margin-top: 0px">We Provide Professional Pipe Processing Services for Global Customers!</h3>
                </a>
                <p style="margin-top: 5px">
                    Shanghai Baoshi Mechanical Engineering Co., Ltd. was founded in 2010. The company is mainly engaged in the production, sales, leasing and pipeline repair engineering services of pipeline processing equipment in natural gas, oil, power and other industries. If you need Baosi people to provide you with a pipeline solution, please tell us the specific working condition information. We will provide you with the best solution according to your technical requirements and years of experience!
                </p>
            </div>
            <div class="ab-btn">
                <a href="${pageContext.request.contextPath}/about/findAbout.do?lang=1">Learn More</a>
                <a href="${pageContext.request.contextPath}/contact/findContact.do?lang=1">Contact Us</a>
            </div>
        </div>
    </div>
</div>
<br/>
<div class="bussiness0">
    <section class="title" style="height: 0px">
        <div>
            <h2>Company Bossiness</h2>
        </div>
    </section>
    <div class="ab-advantage">
        <ul class="clearfix">
            <li>
                <a href="${pageContext.request.contextPath}/business-pre/findRent.do?lang=1"><img src="${pageContext.request.contextPath}/static/images/ad1.png" alt=""/>
                    <h3>Equipment Leasing</h3></a>
                <p>Equipment leasing for pipeline construction</p>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/business-pre/findSale.do?lang=1"><img src="${pageContext.request.contextPath}/static/images/ad2.png" alt=""/>
                    <h3>Equipment Sales</h3></a>
                <p>Sales of safe operation required in pipeline construction</p>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/business-pre/findEngineeringService.do?lang=1"><img src="${pageContext.request.contextPath}/static/images/ad3.png" alt=""/>
                    <h3>Engineering Services</h3></a>
                <p>Prefabrication Technology and welding installation service of hot work connecting pipe</p>
            </li>
            <li>
                <a target="_blank"><img src="${pageContext.request.contextPath}/static/images/ad4.png" alt=""/>
                    <h3>Shipping Business</h3></a>
                <p>Common spare parts and boat maintenance</p>
            </li>
        </ul>
        <br/><br/>
    </div>
</div>
<!--pro-li-->
<div class="pro-li">
    <section class="title" style="height: 0px">
        <div>
            <h2>Products</h2>
        </div>
        <a class="more" href="${pageContext.request.contextPath}/product-pre/toProduct.do?lang=1">Learn More</a>
    </section>
    <div class="clearfix">
        <div class="proli-left">
            <a href="${pageContext.request.contextPath}/product-pre/toProduct.do?lang=1">
                <div class="proli-title">
                    <h3>Low Clearance Split Groove Cutting Machine</h3>
                </div>
                <br/>
                <img src="${pageContext.request.contextPath}/static/images/pro.jpg" height="300" width="500" alt=""/>
            </a>
        </div>
        <div class="proli-right clearfix">
            <div>
                <a href="${pageContext.request.contextPath}/product-pre/toProduct.do?lang=1&index=1">
                    <div class="proli-title">
                        <h3>Internal Expansion Beveling Machine</h3>
                    </div>
                    <br/>
                    <img src="${pageContext.request.contextPath}/static/images/pro/pr1.jpg" width="450" height="300" alt=""/>
                </a>
            </div>
            <div>
                <a href="${pageContext.request.contextPath}/product-pre/toProduct.do?lang=1&index=2" style="height: 384px">
                    <div class="proli-title">
                        <h3>External Card Automatic Beveling Machine</h3>
                    </div>
                    <br/>
                    <img src="${pageContext.request.contextPath}/static/images/pro/pr2.jpg" width="450" height="300" alt=""/>
                </a>
            </div>
        </div>
    </div>
</div>
<!--news-->
<div class="news">
    <section class="title" style="height: 0px">
        <div>
            <h2>News</h2>
        </div>
    </section>
    <div class="news-class">
        <div class="news-cp">
            <div class="clearfix">
                <a href="${pageContext.request.contextPath}/news-pre/findCorNews.do?lang=1" style="color: rgba(21, 129, 175, 1)"><h3>Company News</h3>
                    <img src="${pageContext.request.contextPath}/static/images/pic1.png" alt=""/></a>
                <ul>
                    <c:forEach items="${CorNewsList}" var="news" begin="0" end="1">
                        <li>
                            <a href="${pageContext.request.contextPath}/news-pre/toCorNewsDetails.do?lang=1&id=${news.id}">
                                <span>${news.releaseDateStr}</span>
                                <h4 style="font-size: 20px">${news.title}</h4>
                                <p style="padding-bottom: 0px;font-size: 18px">${news.keywords}</p>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
                <a class="more" href="${pageContext.request.contextPath}/news-pre/findCorNews.do?lang=1">Learn More</a>
            </div>
        </div>
        <div class="news-hy">
            <div class="clearfix">
                <a href="${pageContext.request.contextPath}/news-pre/findIndNews.do?lang=1" style="color: rgba(21, 129, 175, 1)"><h3>Industry News</h3>
                    <img src="${pageContext.request.contextPath}/static/images/pic2.png" alt=""/></a>
                <ul>
                    <c:forEach items="${IndNewsList}" var="news" begin="0" end="1">
                        <li>
                            <a href="${pageContext.request.contextPath}/news-pre/toIndNewsDetails.do?lang=1&id=${news.id}">
                                <span>${news.releaseDateStr}</span>
                                <h4 style="font-size: 20px">${news.title}</h4>
                                <p style="padding-bottom: 0px;font-size: 18px">${news.keywords}</p>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
                <a class="more" href="${pageContext.request.contextPath}/news-pre/findIndNews.do?lang=1">Learn More</a>
            </div>
        </div>
    </div>
</div>
<!--partner-->
<div class="partner">
    <section class="title" style="height: 10px">
        <div>
            <h2>Partners</h2>
        </div>
    </section>
    <ul class="clearfix">
        <li  style="margin-top:60px"><a href="http://www.cnpc.com.cn" target="_blank"><img src="${pageContext.request.contextPath}/static/images/partner/part1.jpg" alt=""/></a>
        </li>
        <li  style="margin-top:60px"><a href="http://www.sinopec.com/listco/" target="_blank"><img src="${pageContext.request.contextPath}/static/images/partner/part2.jpg"
                                                                          alt=""/></a>
        </li>
        <li  style="margin-top:60px"><a href="http://www.shenhuachina.com/" target="_blank"><img src="${pageContext.request.contextPath}/static/images/partner/part3.jpg"
                                                                        alt=""/></a></li>
        <li  style="margin-top:60px"><a href="http://www.shanghai-electric.com/Pages/Index.aspx" target="_blank"><img
                src="${pageContext.request.contextPath}/static/images/partner/part4.jpg" alt=""/></a></li>
        <li  style="margin-top:60px"><a href="https://www.cnooc.com.cn/" target="_blank"><img src="${pageContext.request.contextPath}/static/images/partner/par1.jpg"
                                                                     alt=""/></a>
        </li>
    </ul>
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
