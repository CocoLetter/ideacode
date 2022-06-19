<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/logo.png"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<security:authentication property="principal.username"></security:authentication>
				</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/user/findAll.do"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/role/findAll.do"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a></li>

				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting4"><a
						href="${pageContext.request.contextPath}/product/findAll.do?page=1&size=5">
							<i class="fa fa-circle-o"></i> 产品管理
					</a></li>
					<li id="system-setting1"><a
						href="${pageContext.request.contextPath}/news/findAll.do?page=1&size=5"> <i
							class="fa fa-circle-o"></i> 新闻管理
					</a></li>
					<li id="system-setting2"><a
							href="${pageContext.request.contextPath}/image/findAll.do?page=1&size=5"> <i
							class="fa fa-circle-o"></i> 轮播图片管理
					</a></li>
					<li id="system-setting3"><a
							href="${pageContext.request.contextPath}/honor/findAll.do?page=1&size=5"> <i
							class="fa fa-circle-o"></i> 荣誉资质图片管理
					</a></li>
				</ul>
			</li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>