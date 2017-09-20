<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function hrefForm(pn){
		document.getElementById("pn").value=pn;
		//提交表单
		document.getElementById("frm").submit();
	}
</script>
</head>

<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="#" title="注销">注销</a></div>
  </div>
  <form action="auctionList.do" method="post" id="frm" enctype="multipart/form-data">
  <div class="forms"><input type="hidden" name="pageNo" id="pn"/>
    <label for="name">名称</label>
        <input name="auctionName" type="text" class="nwinput" id="name" value="${param.auctionName}"/>
        <label for="names">描述</label>
        <input name="auctionDesc" value="${param.auctionDesc}" type="text" id="names" class="nwinput"/>
        <label for="time">开始时间</label>
        <input name="auctionStartTime" value="${param.auctionStartTime}" type="text" id="time" class="nwinput"/>
        <label for="end-time">结束时间</label>
        <input name="auctionEndTime" value="${param.auctionEndTime}" type="text" id="end-time" class="nwinput" />
        <label for="price">起拍价</label>
    <input name="auctionStartPrice" value="${param.auctionStartPrice}" type="text" id="price" class="nwinput" />
    <input name="" type="submit"  value="查询" class="spbg buttombg f14  sale-buttom"/>
  </div>
  </form>
  <div class="items">
      <ul class="rows even strong">
        <li>名称</li>
        <li class="list-wd">描述</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="borderno">操作</li>
      </ul>
      <c:forEach items="${pu.list}" var="auction" varStatus="stuts">
      <c:if test="${stuts.index%2==0}">
      <ul class="rows">
      </c:if>
      <c:if test="${stuts.index%2==1}">
       <ul class="rows even">
      </c:if>
        <li><a href="国书" title="">${auction.auctionName}</a></li>
        <li class="list-wd">${auction.auctionDesc}</li>
        <li>${fn:substring(auction.auctionStartTime,0,19)}</li>
        <li>${fn:substring(auction.auctionEndTime,0,19)}</li>
        <li>${auction.auctionStartPrice}</li>
        <li class="borderno red"><a href="auction.do?id=${auction.auctionId}">竞拍</a></li>
      </ul>
     </c:forEach>
    <div class="page">
        <a href="javascript:void(0)" onclick="hrefForm(1)" title="">首页</a>
        <c:if test="${pageNo>1}">
        <a href="javascript:void(0)" onclick="hrefForm(${pageNo-1})" title="">上一页</a>
        </c:if>
        <span class="red">前5页</span>
        <c:forEach begin="1" end="${pu.count}" step="1" var="i">
        <a href="javascript:void(0)" onclick="hrefForm(${i})" title="">${i}</a> 
        </c:forEach>
        <c:if test="${pageNo<pu.count}">
        <a href="javascript:void(0)" onclick="hrefForm(${pageNo+1})" title="">下一页</a>
       	</c:if>
        <a href="javascript:void(0)" onclick="hrefForm(${pu.count})" title="">尾页</a> 
      </div>
  </div>
<!-- main end-->
</div>
</body>
</html>
