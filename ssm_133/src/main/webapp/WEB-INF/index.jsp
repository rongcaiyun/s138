<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function submitForm(pn){
	document.getElementById("pageNo").value=pn;
	document.forms[0].submit();
}
function del(){
	var ck=document.getElementsByName("ck");
	var str="";
	for(var i=0;i<ck.length;i++){
		if(ck[i].checked){
			str+=ck[i].value+",";
		}
	}
	location.href="del.do?str="+str;
}
</script>
</head>
<body>
<form action="list.do" method="post">
<input type="hidden" name="pageNo" id="pageNo" value="1"/>
<input type="text" 	name="std_num" value="${param.std_num}"/>
<input type="submit" value="提交检索"/>
</form>
<input type="button" onclick="location.href='add.do'" value="新增标准"/>
<input type="button" onclick="del()" value="删除标准"/>
<table>
	<tr>
		<td><input type="checkbox" name="ck"/></td>
		<td>标准号</td>
		<td>中文名称</td>
		<td>版本</td>
		<td>发布日期</td>
		<td>实施日期</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list}" var="s" varStatus="st">
	<c:if test="${st.index%2==0}">
	<tr bgcolor="gray">
	</c:if>
	<c:if test="${st.index%2==1}">
	<tr>
	</c:if>
	<td><input type="checkbox" name="ck" value="${s.id}"/></td>
		<td>${s.stdNum}</td>
		<td>${s.zhname}</td>
		<td>${s.version}</td>
		
		<td><fmt:formatDate value="${s.releaseDate}" pattern="yyyy-MM-dd"/></td>
		<td><fmt:formatDate value="${s.implDate}" pattern="yyyy-MM-dd"/></td>
		<td><a href="">下载</a><a href="update.do?stdNum=${s.stdNum}">修改</a></td>	
	</tr>
	</c:forEach>
</table>
<a href="javascript:submitForm(1);">首页</a>|
<c:if test="${param.pageNo>1}">
<a href="javascript:submitForm(${param.pageNo-1});">上一页</a>
</c:if>
<c:if test="${param.pageNo<pages}">
|
<a href="javascript:submitForm(${param.pageNo+1});">下一页</a>
</c:if>
|<a href="javascript:submitForm(${pages});">末页</a> 第1页/共2页
</body>
</html>