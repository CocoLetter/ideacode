<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>产品预览</title>
</head>
<body>
<%--接收从后端传过来的一个参数--%>
<input type="hidden" id="id" value="${id}">
<div id="productName" align="center"></div>
<br>
产品价格：
<div id="productPrice"></div>
<br>
产品介绍：
<div id="productDesc"></div>
<br>
产品特点：
<div id="productChar"></div>
<br>

<script src="../jquery/jquery-3.3.1.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../script/docs.min.js"></script>
<script type="text/javascript" src="../jquery/layer/layer.js"></script>
<script type="text/javascript">
    $(function () {
        //接受id参数
        var id = $("#id").val();
        //发出一个异步请求，根据id查询这条新闻数据，显示在编辑页面上
        var loadingindex = -1;
        $.ajax({
            url: "/product/view.do",
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
                var productName = result.productData.productName;
                var productPrice = result.productData.productPrice;
                var productDesc = result.productData.productDesc;
                var productChar = result.productData.productChar;
                $("#productName").html('<h2>' + productName + '</h2>');
                $("#productPrice").html(productPrice);
                $("#productDesc").html(productDesc);
                $("#productChar").html(productChar);

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
