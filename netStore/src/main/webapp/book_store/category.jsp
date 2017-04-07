<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>书城</title>
<link rel="stylesheet" type="text/css" href="book_store/style.css" />

<script type="text/javascript" src="book_store/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="book_store/js/jquery-cookie.js"></script>
<script type="text/javascript" src="book_store/js/manager_plugin.js"></script>
<script type="text/javascript" src="book_store/js/manager.js"></script> 

<script type="text/javascript" src="book_store/js/lazyload.js"></script>
</head>
<body>
<div id="wrap">

       <div class="header">
       		<div class="logo"><a href="welcome.action"><img src="book_store/images/logo.gif" alt="" title="" border="0" /></a></div>            
        <div id="menu">
            <ul>                                                                       
            <li class="selected"><a href="welcome.action">首页</a></li>
            <li><a href="category.action">书城</a></li>
            <li><a href="specials.action">特价书</a></li>
             <li><a id="myaccount" href="myaccount_bf.action"></a></li>
            <li><a id="register" href="register_bf.action">注册</a></li>
         	 <li><a href="theme.action">图书集</a></li>
            <li><a href="contact_bf.action">联系我们</a></li>
            </ul>
        </div>     
            
            
       </div> 
       
       
       <div class="center_content">
       	<div class="left_content">
        	<div class="crumb_nav">
            <a href="welcome.action">首页</a> &gt;&gt; 书城
            </div>
            <div class="title"><span class="title_icon"><img src="book_store/images/bullet1.gif" alt="" title="" /></span>书籍</div>
           
           <div class="new_products">
           			<c:forEach items="${books}" var="b" varStatus="i">
	                    <div class="new_prod_box">
	                    	<div >
	                        	<a class="li" href="details/${b.bid}.action" title="${b.bookname}" style="">
	                        		${b.bookname}
	                        	</a>
	                    	</div>
	                        <div class="new_prod_bg">
		                        <c:if test="${b.promotions == true}"><!-- 判断是否促销 -->
		                        	 <span class="new_icon"><img src="book_store/images/promo_icon.gif" alt="" title="" /></span>
		                        </c:if>
		                        <a href="details/${b.bid}.action"><img id="lazyimage" src="book_store/images/loading.gif" alt="" title="" class="thumb" border="0" data-echo = "/image/${b.filename}"/></a>
	                        </div>           
	                    </div>
           			</c:forEach>
<!--  分页 -->
	            <div id="page"  class="pagination">
		            <a <c:if test="${page.thisPage == 1}">class="disabled"</c:if> <c:if test="${page.thisPage != 1}">href="pageBook/1.action"</c:if>  ><<</a>
		            
		            <c:forEach begin="1" end="${page.totalPage}" var="p">
		            	<a href="pageBook/${p}.action" <c:if test="${page.thisPage == p}">class="current"</c:if> >${p}</a>
		            </c:forEach>
		            
		            <a <c:if test="${page.thisPage == page.totalPage}">class="disabled"</c:if> <c:if test="${page.thisPage != page.totalPage}">href="pageBook/${page.totalPage}.action"</c:if> >>></a>
	            </div>  
            
            </div> 
          
            
        <div class="clear"></div>
        </div><!--end of left content-->
        
     <div class="right_content">
     <!-- 
        	<div class="languages_box">
            <span class="red">Languages:</span>
            <a href="#" class="selected"><img src="book_store/images/gb.gif" alt="" title="" border="0" /></a>
            <a href="#"><img src="book_store/images/fr.gif" alt="" title="" border="0" /></a>
            <a href="#"><img src="book_store/images/de.gif" alt="" title="" border="0" /></a>
            </div>
                <div class="currency">
                <span class="red">货币: </span>
                <a href="#">GBP</a>
                <a href="#">EUR</a>
                <a href="#" class="selected">USD</a>
                </div>
              -->   
                
             <div class="cart">
                  <div class="title"><span class="title_icon"><img src="book_store/images/cart.gif" alt="" title="" /></span>购物车</div>
                  <div class="home_cart_content">
                   <font id="num"></font> x 商品 | <span class="red">总金额: <font id="money"></font>￥</span>
                  </div>
                  <a href="cart.action" class="view_cart">查看购物车</a>
              
              </div>
                       
            	
        
        
             <div class="title"><span class="title_icon"><img src="book_store/images/bullet3.gif" alt="" title="" /></span>关于书店</div> 
             <div class="about">
             <p>
             <img src="book_store/images/about.gif" alt="" title="" class="right" />
            	书是人类进步的阶梯 让我们在无穷的书店里探索无穷的真理好书不贵！
            	<br />谁说便宜没好书！！
             </p>
             
             </div>
             
             <div class="right_box">
             
             	<div class="title"><span class="title_icon"><img src="book_store/images/bullet4.gif" alt="" title="" /></span>促销</div> 
                    <div class="new_prod_box">
                        <a href="details/${bookPromotions1.bid}.action">${bookPromotions1.bookname}</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="book_store/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="details/${bookPromotions1.bid}.action"><img src="/image/${bookPromotions1.filename}" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>
                    
                    <div class="new_prod_box">
                        <a href="details/${bookPromotions2.bid}.action">${bookPromotions2.bookname}</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="book_store/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="details/${bookPromotions2.bid}.action"><img src="/image/${bookPromotions2.filename}" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>                    
                    
                    <div class="new_prod_box">
                        <a href="details/${bookPromotions3.bid}.action">${bookPromotions3.bookname}</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="book_store/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="details/${bookPromotions3.bid}.action"><img src="/image/${bookPromotions3.filename}" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>              
             
             </div>
             
             <div class="right_box">
             
             	<div class="title"><span class="title_icon"><img src="book_store/images/bullet5.gif" alt="" title="" /></span>分类</div> 
                
                <ul class="list">
                	<c:forEach items="${classifies}" var="c">
                		<li><a href="classify/${c.cid}.action">${c.classifyname}</a></li>
                	</c:forEach>
                </ul>
             
             <!--  
             <div class="title"><span class="title_icon"><img src="images/bullet6.gif" alt="" title="" /></span>Partners</div> 
                
                <ul class="list">
                <li><a href="#">accesories</a></li>
                <li><a href="#">books gifts</a></li>
                <li><a href="#">specials</a></li>
                <li><a href="#">hollidays gifts</a></li>
                <li><a href="#">accesories</a></li>
                <li><a href="#">books gifts</a></li>
                <li><a href="#">specials</a></li>
                <li><a href="#">hollidays gifts</a></li>
                <li><a href="#">accesories</a></li>                              
                </ul>      
             
              -->  
             </div>         
        
        </div><!--end of right content-->
        
        
       
       
       <div class="clear"></div>
       </div><!--end of center content-->
       
              
       <div class="footer">
       	<div class="left_footer"><img id="aaaaa" src="" alt="" title="" data-echo = "book_store/images/footer_logo.gif"/><br /></div>
        <div class="right_footer">
        <a href="welcome.action">首页</a>
        <a href="#">关于我们</a>
        <a href="#">services</a>
        <a href="#">privacy policy</a>
        <a href="#">contact us</a>
       
        </div>
        
       
       </div>
    

</div>
<script>
	Echo.init({
	    offset: 0,//离可视区域多少像素的图片可以被加载
	　　 throttle: 500 //图片延时多少毫秒加载
	}); 
</script>

</body>
</html>