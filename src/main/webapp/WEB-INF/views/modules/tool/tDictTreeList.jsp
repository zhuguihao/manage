<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>树形数据字典管理</title>
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
		<li class="active"><a href="${ctx}/tool/tDictTree/">树形数据字典列表</a></li>
		<shiro:hasPermission name="tool:tDictTree:edit"><li><a href="${ctx}/tool/tDictTree/form">树形数据字典添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tDictTree" action="${ctx}/tool/tDictTree/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>主键</th>
				<th>描述</th>
				<th>父级主键</th>
				<th>修改时间</th> 
				<shiro:hasPermission name="tool:tDictTree:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tDictTree">
			<tr>
				<td>
					${tDictTree.code}
				</td>
				<td>
					${tDictTree.value}
				</td>
				<td>
					${tDictTree.parent.id}
				</td>
				<td>
					<fmt:formatDate value="${tDictTree.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="tool:tDictTree:edit"><td>
    				<a href="${ctx}/tool/tDictTree/form?id=${tDictTree.id}">修改</a>
					<a href="${ctx}/tool/tDictTree/delete?id=${tDictTree.id}" onclick="return confirmx('确认要删除该树形数据字典吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>