<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>新闻预览</title>
</head>
<body>
<%--接收从后端传过来的一个参数--%>
<input type="hidden" id="id" value="${id}">
<div id="title" align="center">
</div>
<br>
语言：
<div id="languages"></div>
<br>
新闻简介：
<div id="keywords"></div>
<br>
标签：
<div id="newsType"></div>
<br>
<div id="content">

</div>
<script src="../jquery/jquery-3.3.1.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../script/docs.min.js"></script>
<script type="text/javascript" src="../jquery/layer/layer.js"></script>
<script type="text/javascript">
    $(function () {
        //接受id参数
        var id = $("#id").val();
        var loadingindex = -1;
        //发出一个异步请求，根据id查询这条新闻数据，显示在编辑页面上
        $.ajax({
            url: "/news/view.do",
            type: "post",
            data: {"id": id},
            dataType: "json",
            beforeSend: function () {
                loadingindex = layer.load(2, {time: 10 * 1000});
                return true;
            },
            success: function (result) {
                layer.close(loadingindex);
                //获取各个信息
                var title = result.newsData.title;
                var languages = result.newsData.languagesStr;
                var newsType = result.newsData.newsTypeStr;
                var keywords = result.newsData.keywords;
                var content = result.newsData.newsContent;
                $("#title").html('<h2>' + title + '</h2>');
                $("#languages").html(languages);
                $("#keywords").html(keywords);
                $("#newsType").html(newsType);
                $("#content").html(content);

                layer.msg("成功加载新闻数据！", {time: 1000, icon: 1, shift: 6});
            },
            error: function () {
                layer.msg("加载失败", {time: 1000, icon: 2, shift: 3});
            }
        });

    });
</script>
</body>
</html>
