<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>产品配置-系列管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/product/tProductSeries/">产品配置-系列列表</a></li>
		<shiro:hasPermission name="product:tProductSeries:edit"><li><a href="${ctx}/product/tProductSeries/form">产品配置-系列添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="TProductSeries" action="${ctx}/product/tProductSeries/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>系列编码：</label>
				<form:input path="seriesCode" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>系列：</label>
				<form:input path="series" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>系列编码</th>
				<th>系列</th>
				<th>排序</th>
				<th>修改时间</th>
				<shiro:hasPermission name="product:tProductSeries:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tProductSeries">
			<tr>
				<td><a href="${ctx}/product/tProductSeries/form?id=${tProductSeries.id}">
					${tProductSeries.seriesCode}
				</a></td>
				<td>
					${tProductSeries.series}
				</td>
				<td>
					${tProductSeries.sort}
				</td>
				<td>
					<fmt:formatDate value="${tProductSeries.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="product:tProductSeries:edit"><td>
    				<a href="${ctx}/product/tProductSeries/form?id=${tProductSeries.id}">修改</a>
					<a href="${ctx}/product/tProductSeries/delete?id=${tProductSeries.id}" onclick="return confirmx('确认要删除该产品配置-系列吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>