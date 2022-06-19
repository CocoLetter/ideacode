//$(function(){
//	$(".prore-nav li").mouseenter(function(){
//		var i = $(this).index();
//		$(".prore-nav li").removeClass("active");
//		$(".prore-nav li").eq(i).addClass("active");
//	})
//})
// 监听事件
 window.addEventListener('scroll', function(){
 	let t = $('body, jsp').scrollTop();   // 目前监听的是整个body的滚动条距离
 	if(t>0){
		$('.nav').addClass('nav-active')
	}else{
		$('.nav').removeClass('nav-active')
	}
 })
$(function(){
	var winHeight = $(window).height();
	var bodHeight = $("body").height();
	if(bodHeight<winHeight){
		var temp = winHeight - bodHeight;
		$(".space").css("height",temp);
	}
});

$(function(){
	$(".hover-li li").mouseenter(function(){
		var i = $(this).index();
		$(".hover-li li").removeClass("active");
		$(".hover-li li").eq(i).addClass("active");
		$(".ch-li>div").css("display","none");
		$(".ch-li>div").eq(i).css("display","block");
	})
});

$(".map iframe").load(function(){
	$(".map span").css("display","none");
})
