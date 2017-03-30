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
<title>书籍详情</title>
<link rel="stylesheet" type="text/css" href="book_store/style.css" />
	<link rel="stylesheet" href="book_store/lightbox.css" type="text/css" media="screen" />
<!-- 	
	<script src="book_store/js/prototype.js" type="text/javascript"></script>
	<script src="book_store/js/scriptaculous.js?load=effects" type="text/javascript"></script>
	<script src="book_store/js/lightbox.js" type="text/javascript"></script>
    <script type="text/javascript" src="book_store/js/java.js"></script>
   -->  
    <script type="text/javascript" src="book_store/js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="book_store/js/jquery-cookie.js"></script>
	<script type="text/javascript" src="book_store/js/manager_plugin.js"></script>
	<script type="text/javascript" src="book_store/js/manager.js"></script> 
    
</head>
<body>
<div id="wrap">

       <div class="header">
       		<div class="logo"><a href="welcome.action"><img src="book_store/images/logo.gif" alt="" title="" border="0" /></a></div>            
        <div id="menu">
            <ul>                                                                       
            <li class="selected"><a href="welcome.action">首页</a></li>
          <!--    <li><a href="about.html">关于我们</a></li> -->
            <li><a href="category.action">书城</a></li>
            <li><a href="specials.action">特价书</a></li>
            <li><a id="myaccount" href="myaccount_bf.action"></a></li>
            <li><a id="register" href="register_bf.action">注册</a></li>
          <!-- <li><a href="details.html">prices</a></li>   -->
            <li><a href="contact_bf.action">联系我们</a></li>
            </ul>
        </div>     
            
            
       </div> 
       
       
       <div class="center_content">
       	<div class="left_content">
        	<div class="crumb_nav">
            <a href="welcome.action">首页</a> &gt;&gt; ${book.bookname}
            </div>
            <div class="title"><span class="title_icon"><img src="book_store/images/bullet1.gif" alt="" title="" /></span>${book.bookname}</div>
        
        	<div class="feat_prod_box_details">
            
            	<div class="prod_img"><a href="details/${book.bid}.action"><img src="/image/${book.filename}" alt="" title="" border="0" /></a>
                <br /><br />
               <!--  <a href="images/big_pic.jpg" rel="lightbox"><img src="book_store/images/zoom.gif" alt="" title="" border="0" /></a>  -->
                </div>
                
                <div class="prod_det_box">
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">书籍简介</div>
                    <p class="details">
	                  ${book.description }
                    </p>
                     <div class="price"><strong>作者:</strong> <span class="red">${book.author}</span></div>
                    <div class="price"><strong>价格:</strong> <span class="red">${book.price} ￥</span></div>
                    <!-- 
                    <div class="price"><strong>COLORS:</strong> 
                    <span class="colors"><img src="images/color1.gif" alt="" title="" border="0" /></span>
                    <span class="colors"><img src="images/color2.gif" alt="" title="" border="0" /></span>
                    <span class="colors"><img src="images/color3.gif" alt="" title="" border="0" /></span></div> 
                    -->
                    <a href="addcart/${book.bid}.action" class="more"><img src="book_store/images/order_now.gif" alt="" title="" border="0" /></a>
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>	
            
              
            <div id="demo" class="demolayout">

                <ul id="demo-nav" class="demolayout">
                <li><a id="comment" class="active" href="#tab1">More details</a></li>
            <!--    <li><a class="" href="#tab2">Related books</a></li>  --> 
                </ul>
    
            <div class="tabs-container">
            
                    <div class="tab" id="tab1">
                    	<br />
                    	<div class="more_details">
                    		<div class="">
                    			<font size="4" color="#7D7D7D">
		                    	<strong>
		                    	&nbsp;&nbsp;读友评论
		                    	</strong>
                    			</font>
                    			<font color="#7D7D7D">
		                    	&nbsp;（已有 <font>${fn:length(comments)}</font> 评论）
                    			</font>
                    		</div>
                    	</div>
                    	<br />
                    	<br />
                    	<div class="more_details">
                    		<font color="#7D7D7D">
	                    		&nbsp;&nbsp;<a id="comment_me" href="" style="text-decoration: none;"><font color="#7D7D7D"> 评论书籍 ( ${book.bookname} ) </font> </a>
                    		</font>
                    	</div>
                    	<br />
                    		<form class="comment_input" action="comment.action" method="post">
			                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <textarea rows="5" cols="30" name="comments" ></textarea>
			                    &nbsp;&nbsp;<input type="submit" value="发表评论"/>
                    		</form>
                    	<br />
                    	<div class="more_details">
                    		<font color="#7D7D7D">
	                    		&nbsp;&nbsp;<a id="comment_many" href="" style="text-decoration: none;"><font color="#7D7D7D">精彩评论</font> </a>
                    		</font>
                    	</div>
                    	<br />
                    	
                    	
                    	<ul class="list">
                    		<c:forEach items="${comments}" var="c">
	                    		<li >
		                    		<a><font color="#7D7D7D"> ${c.users.username}</font></a> ：${c.content}
		                    		<br /><br />  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${c.time}
		                    		&nbsp;&nbsp;&nbsp;&nbsp; <a href="">点赞 ( ${c.praise} )</a>
		                    		&nbsp;&nbsp;<a id="reply" href="" style="text-decoration: none;">回复</a>
		                    		<form action="reply.action" method="post" style="display: none;">
		                    			<br />
		                    			<input type="hidden" name="cid" value="${c.cid}"/>
		                    			<input type="hidden" name="uid" value="${c.users.uid}"/>
					                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <textarea rows="5" cols="30" name="reply" placeholder="@ ${c.users.username}"></textarea>
					                    &nbsp;&nbsp;<input type="submit" value="回复"/>
		                    		</form>
		                    		<br />
		                    		<div class="box_bottom"></div>
	                    		</li>
                    		</c:forEach>
                    	</ul>
                    	
                    	<!-- 
                                        <p class="more_details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.
                                        </p>
                            <ul class="list">
                            <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                            <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                            <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                            <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>                                          
                            </ul>
                                         <p class="more_details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.
                                        </p>   
                          -->                        
                    </div>	
                    
                            <div style="display: none;" class="tab" id="tab2">
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>
                    
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>                    
                    
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb3.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>    

                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>
                    
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>                    
                    
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb3.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>  


                   
                    <div class="clear"></div>
                            </div>	
            
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
<!-- 
<script type="text/javascript">

var tabber1 = new Yetii({
id: 'demo'
});

</script>
 -->
</html>