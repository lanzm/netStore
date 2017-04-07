<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改用户信息</title>
<link rel="stylesheet" type="text/css" href="book_store/style.css" />
<script type="text/javascript" src="book_store/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="book_store/js/jquery-cookie.js"></script>
<script type="text/javascript" src="book_store/js/manager_plugin.js"></script>
<script type="text/javascript" src="book_store/js/manager.js"></script> 
</head>
<body>
<div id="wrap">

       <div class="header">
       		<div class="logo"><a href="index.html"><img src="book_store/images/logo.gif" alt="" title="" border="0" /></a></div>            
        <div id="menu">
            <ul>                                                                       
            <li class="selected"><a href="welcome.action">首页</a></li>
          <!--    <li><a href="about.html">关于我们</a></li> -->
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
            <div class="title"><span class="title_icon"><img src="book_store/images/bullet1.gif" alt="" title="" /></span>注册</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
            	欢迎来到本小店，修改用户时请注意规则
             </p>
            
              	<div class="contact_form">
                <div class="form_subtitle">修改账号</div>
                 <form name="register" action="personal_af.action" method="post">    
                 	<input name="uid" type="hidden" value="${users.uid}"/>      
                    <div class="form_row">
	                    <label class="contact"><strong>* 用户名:</strong></label><font id="name"></font>
	                    <input id="username" name="username" type="text" class="contact_input" value="${users.username}"/>
                    </div>  

                    <div class="form_row">
	                    <label class="contact"><strong>* 密码:</strong></label><font id="passwordmsg"></font>
	                    <input id="password" name="password" type="text" class="contact_input" placeholder="请输入密码,以字母开头，长度在6-18之间"/>
                    </div> 

                    <div class="form_row">
	                    <label class="contact"><strong>* 邮箱:</strong></label><font id="emailmsg"></font>
	                    <input id="email" name="email" type="text" class="contact_input" value="${users.email}"/>
                    </div>


                    <div class="form_row">
	                    <label class="contact"><strong>* 手机号码:</strong></label><font id="phonemsg"></font>
	                    <input id="phone" name="phone" type="text" class="contact_input" value="${users.phone}"/>
                    </div>
                    
                    <div class="form_row">
	                    <label class="contact"><strong>公司:</strong></label>
	                    <input name="company" type="text" class="contact_input" value="${users.company}"/>
                    </div>
                    
                    <div class="form_row">
	                    <label class="contact"><strong>* 地址:</strong></label><font id="addressmsg"></font>
	                    <input id="address" name="address" type="text" class="contact_input" value="${users.address}"/>
                    </div>                    
	
                    <div class="form_row">
                        <div class="terms">
                        <input id="agree" type="checkbox" name="terms" />
                    		    我同意	 <a href="#">本网站协议</a>  </div>
                    </div> 
                    
                    <div class="form_row">
                    	<input id="submit" type="submit" class="register" value="修改" />
                    </div>   
                  </form>     
                </div>  
            
          </div>	
        <div class="clear"></div>
        </div><!--end of left content-->
        
        <div class="right_content">
        <!-- 
                	<div class="languages_box">
            <span class="red">Languages:</span>
            <a href="#"><img src="images/gb.gif" alt="" title="" border="0" /></a>
            <a href="#"><img src="images/fr.gif" alt="" title="" border="0" /></a>
            <a href="#"><img src="images/de.gif" alt="" title="" border="0" /></a>
            </div>
                <div class="currency">
                <span class="red">Currency: </span>
                <a href="#">GBP</a>
                <a href="#">EUR</a>
                <a href="#"><strong>USD</strong></a>
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
       	<div class="left_footer"><img src="book_store/images/footer_logo.gif" alt="" title="" /><br /></div>
        <div class="right_footer">
        <a href="welcome.action">首页</a>
        <a href="#">关于我们</a>
        <a href="#">services</a>
        <a href="#">privacy policy</a>
        <a href="#">contact us</a>
       
        </div>
        
       
       </div>
    

</div>
</body>
</html>