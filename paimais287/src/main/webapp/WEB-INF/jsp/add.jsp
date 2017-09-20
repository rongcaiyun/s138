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
	function getPath(file){
		if (file.files && file.files[0]) {
			var reader = new FileReader();
			reader.onload = function(evt) {
				$("#img").attr("src", evt.target.result);
				//prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';  
			}
			reader.readAsDataURL(file.files[0]);
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
  <form action="addAuction.do" method="post" enctype="multipart/form-data">
      <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
          <dl>
            <dd >
              <label>名称：</label>
              <input name="auctionName" type="text" class="inputh lf" value="" />
              <div class="xzkbg spbg lf"></div>
            </dd>
            <dd>
              <label>起拍价：</label>
              <input name="auctionStartPrice" type="text" class="inputh lf" value="" />
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>底价：</label>
              <input name="auctionUpSet" type="text" class="inputh lf" value="" />
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>开始时间：</label>
              <input name="auctionStartTime" type="text" class="inputh lf" value="" />
              <div class="lf red laba">格式：2010-05-05 12:30:00</div>
            </dd>
            <dd>
              <label>结束时间：</label>
              <input name="auctionEndTime" type="text" class="inputh lf" value="" />
              <div class="lf red laba">格式：2010-05-06 16:30:00</div>
            </dd>
            <dd class="dds">
              <label>拍卖品图片：</label>
               <div class="lf salebd"><a href="#"><img id="img" src="images/ad20.jpg" width="100" height="100" /></a></div>
              <input id="myfiles" name="myfiles" type="file" class="offset10 lf" onchange="getPath(this)" />
             
            </dd>
             <dd class="dds">
              <label>描述：</label>
              <textarea name="auctionDesc" cols="" rows="" class="textarea"></textarea>
            </dd>
            <dd class="hegas">
                <input name="" type="submit" value="保 存" class="spbg buttombg buttombgs buttomb f14 lf" />
                <input name="" type="reset" value="取 消" class="spbg buttombg buttombgs buttomb f14 lf" />
            </dd>
          </dl>
    </div>
    </form>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
 
</div>
</body>
</html>
