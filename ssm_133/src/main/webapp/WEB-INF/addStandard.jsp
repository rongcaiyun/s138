<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("input[name=stdNum]").blur(function(){
			var val=$(this).val();
			if(val.length>0){
				$.ajax({
					url:"validateNum.do",
					type:"POST",
					data:{"stdNum":val},
					dataType:"json",
					success:function(result){
						if(result.msg=="ok"){
							$("input[name=stdNum]").next().html(result.msg).css("color","green");
						}
						else{
							$("input[name=stdNum]").next().html(result.msg).css("color","red");
						}
					},
					error:function(result){
						alert(result+"出错了");
					}
				});
			}
		});
	})
</script>
</head>
<body>
<div>
<h2><c:if test="${sd==null}">增加</c:if><c:if test="${sd!=null}">修改</c:if>标准信息</h2>

<form <c:if test="${sd==null}"> action="save.do" </c:if>
<c:if test="${sd!=null}"> action="modify.do" </c:if>
 method="post" enctype="multipart/form-data">
	<table>
	<tr>
		<td>*标准号：</td>
		<td><input name="stdNum" type="text" value="${sd.stdNum}"/><span></span>
		</td>
	</tr>
	<tr>
		<td>*中文名称：</td>
		<td><input name="zhname" type="text" value="${sd.zhname}"/>
		</td>
	</tr>
	<tr>
		<td>*版本：</td>
		<td><input name="version" type="text" value="${sd.version}"/>
		</td>
	</tr>
	
	<tr>
		<td>*关键字/词：</td>
		<td><input name="keys" type="text"  value="${sd.keys}"/>
		</td>
	</tr>
	<tr>
		<td>*发布日期（yyyy-MM-dd）：</td>
		<td><input name="releaseDate" type="text" value="${sd.releaseDate}"/>
		</td>
	</tr>
	<tr>
		<td>*实施日期（yyyy-MM-dd：</td>
		<td><input name="implDate" type="text" value="${sd.implDate}"/>
		</td>
	</tr>
	<tr>
		<td>*附件：</td>
		<td><input name="file" type="file" value="${sd.packagePath}"/>
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="保存"/>
		&nbsp;
		<input type="button" value="取消">
		</td>
	</tr>	
	</table>
	</form>
</div>
</body>
</html>