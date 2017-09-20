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
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function auctionSubmit(){
		//获取竟拍值，判断是否为空，
		var val=$("#sale").val();
		if(val.length>0){
			//判断是否大于当前最高竞拍价
			//获取最高竞拍价格
			/* $.ajax({
				url:"saveAuctionRecord.do",
				type:"post",
				data:{"id":id,"price":val},
				success:function(result){
					$("#mess").text(result);
					location.reload(true);
				}
			}); */
			var startPrice=$("#startPrice").text();
			if(parseFloat(val)<parseFloat(startPrice)){
				$("#mess").text("不能低于起拍价");
				return false;
			}
			$("#frm").submit();
		}
		else{
			$("#mess").text("不能为空");
			//alert("不能为空");
		}
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
  <div class="items sg-font lf">
      <ul class="rows">
        <li>名称：</li>
        <li class="borderno">${auction.auctionName}</li>
      </ul>
      <ul class="rows">
        <li>描述：</li>
        <li class="borderno">${auction.auctionDesc}</li>
      </ul>
      <ul class="rows">
        <li>开始时间：</li>
        <li class="borderno">${auction.auctionStartTime}</li>
      </ul>
      <ul class="rows">
        <li>结束时间：</li>
        <li class="borderno">${auction.auctionEndTime}</li>
      </ul>
      <ul class="rows border-no">
        <li>起拍价：</li>
        <li id="startPrice" class="borderno">${auction.auctionStartPrice}</li>
      </ul>
  </div>
  <div class="rg borders"><img src="${pageContext.request.contextPath}/images/${auction.auctionPic}" width="270" height="185" alt="" /></div>
  <div class="cl"></div>
  <form id="frm" action="saveAuctionRecord.do" method="post">
  <input type="hidden" name="id" value="${auction.auctionId}"/>
  <div class="top10 salebd">
       <p>
       <label for="sale">出价：</label>
       <input type="text" name="price" class="inputwd" id="sale" value=""/>
       <input name="" type="button" onclick="auctionSubmit()" value="竞 拍" class="spbg buttombg f14  sale-buttom" />
       </p>
       <p class="f14 red" id="mess">${mess}</p>
  </div>
  </form>
  <div class="top10">
    <input name="" type="submit" value="刷 新" class="spbg buttombg f14" />
    <input name="" type="submit" value="返回列表" class="spbg buttombg f14" />
  </div>
  <div class="offer">
    <h3>出价记录</h3>
    <div class="items sg-font" id="recordDiv">
      <ul class="rows even strong">
        <li>竞拍时间</li>
        <li>竞拍价格</li>
        <li class="borderno">竞拍人</li>
      </ul>
      <c:forEach items="${record}" var="records" varStatus="stuts">
      <c:if test="${stuts.index%2==0}">
      <ul class="rows">
      </c:if>
      <c:if test="${stuts.index%2==1}">
       <ul class="rows even">
      </c:if>
        <li>
        <fmt:formatDate value="${records.auctionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
        </li>
        <li>${records.auctionPrice}</li>
        <li class="borderno">${records.auctionUser.userName}</li>
      </ul>
	</c:forEach>
  </div>
  </div>
<!-- main end-->
</div>
</body>
</html>
