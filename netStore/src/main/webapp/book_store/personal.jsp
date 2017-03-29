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
<title>个人中心</title>
<link rel="stylesheet" type="text/css" href="book_store/style.css" />
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
            <div class="title"><span class="title_icon"><img src="book_store/images/bullet1.gif" alt="" title="" /></span>个人信息</div>
        	<div class="feat_prod_box_details">
            
               	<div class="contact_form">
	        	<strong><a id="personal" style="text-decoration: none;" href="">个人信息</a></strong>
	        	<!--  以下为个人信息隐藏  -->
                <div class="form_subtitle">我的账号</div>
                	<div class="usersmsg">
	                    <div class="form_row">
	                    <label class="contact"><strong>用户名:</strong></label>
	                    &nbsp; &nbsp;<strong>${users.username}</strong>
	                    </div>  
	
	                    <div class="form_row">
	                    <label class="contact"><strong>邮箱:</strong></label>
	                    &nbsp; &nbsp;<strong>${users.email}</strong>
	                    </div>
	
	
	                    <div class="form_row">
	                    <label class="contact"><strong>手机号码:</strong></label>
	                    &nbsp; &nbsp;<strong>${users.phone}</strong>
	                    </div>
	                    
	                    <div class="form_row">
	                    <label class="contact"><strong>公司:</strong></label>
	                    &nbsp; &nbsp;<strong>${users.company}</strong>
	                    </div>
	
	
	                    <div class="form_row">
		                    <label class="contact"><strong>地址:</strong></label>
		                   &nbsp; &nbsp;<strong>${users.address}</strong>
	                    </div>
						
						 <div class="form_row">
		                    <a href="personal_update.action" class="contact" >修改</a>                
		                </div>  
						
                	</div>        
                	<!--  以下为未支付订单隐藏  -->  
                     <br /><br />
		        	<strong><a id="orders" href="" style="text-decoration: none;">未支付订单</a></strong>
		        		       	<div class="orders_table">
					        		<c:if test="${empty orders}">
						        		 <div class="form_row">
					                    	<strong>您没有未支付的订单哦，快去购物吧！</strong>
					                     </div>
									</c:if>
									<!-- 判断 是否有 未支付订单 -->
									<c:if test="${!empty orders}">
							            <table class="cart_table" style="table-layout:fixed;">
							           	<tr class="cart_title">
							           		<td width="20"><input type="checkbox"/></td>
							               	<td width="90">书籍图片</td>
							               	<td width="100">书籍名称</td>
							                <td width="80">单计</td>
							                <td width="50">状态</td>
							               </tr>
							              <c:forEach items="${orders}" var="orders">
							              
							              	<tr>
							              		<td><input type="checkbox"/> </td>
							            		<td><span class="red">订单号：</span></td>
							            		<td><span class="red">${orders.oid}</span></td>
							            	</tr>
							                <c:forEach items="${orders.orderitem}" var="o">
								            	<tr>
								            		<td></td>
								                	<td><img src="/image/${o.book.filename}" alt="" title="" border="0" class="cart_thumb" /></a></td>
								                	<td >${o.book.bookname}</td>
								                    <td>${o.book.price}￥ x ${o.num} = <br/><br/> ${o.money}￥</td>
								                    <td>
								                    	<c:if test="${orders.status == '0'}">未付款</c:if>
								                    	<c:if test="${orders.status == '1'}">已付款</c:if>
								                    </td>
								                </tr>          
							                </c:forEach>
							            
							
							                <tr>
								                <td colspan="3" class="cart_total"><span class="red">商品总数:</span></td>
								                <td >${orders.totalnum}</td>                
							                </tr>  
							                
							                <tr>
								                <td colspan="3" class="cart_total"><span class="red">总计:</span></td>
								                <td >${orders.totalmoney}</td>                
							                </tr>                  
							            	
							            	<tr>
							            		<td></td>
							            		<td>操作：</td>
							            		<td>
								            		<c:if test="${orders.status == '0'}">
								            			<a href="personal_orders/${orders.oid}.action">去完成付款</a>
								            		</c:if>
							            			<c:if test="${orders.status == '1'}">
							            				已付款
							            			</c:if>
							            		</td>
							            		<td><a href="personal_del/${orders.oid}.action">删除订单</a></td>
							            	</tr>
							            	<tr>
							            		<td><hr /></td>
							            		<td></td>
							            		<td></td>
							            		<td></td>
							            		<td><hr /></td>
							            	</tr>
							              </c:forEach>
							           </table>
									</c:if>
						          </div>
					<!--  以下为代发货订单  -->
            		<br /><br />
            		<strong><a id="delivery" href="" style="text-decoration: none;">待发货订单</a></strong>
            		<!--  以下为待收货订单  -->
            		<br /><br />
            		<strong><a id="take_delivery" href="" style="text-decoration: none;">待收货订单</a></strong>
		        	<!--  以下为全部订单隐藏  -->  
		        	<br /><br />
		        	<strong><a id="orderAll" href="" style="text-decoration: none;">全部订单</a></strong>
		        		<div class="orderAll_table">
		        		<!-- 判断订单是否为空 -->
		        			<c:if test="${empty ordersAll}">
				        		 <div class="form_row">
			                    	<strong>您还没有订单哦，快去购物吧！</strong>
			                     </div>
							</c:if>
							<!-- 不为空 -->
							<c:if test="${!empty ordersAll}">
				        		 <table class="cart_table" style="table-layout:fixed;">
							           	<tr class="cart_title">
							           		<td width="20"><input type="checkbox"/></td>
							               	<td width="90">书籍图片</td>
							               	<td width="100">书籍名称</td>
							                <td width="80">单计</td>
							                <td width="50">状态</td>
							               </tr>
							              <c:forEach items="${ordersAll}" var="orderAll">
							              
							              	<tr>
							              		<td><input type="checkbox"/> </td>
							            		<td><span class="red">订单号：</span></td>
							            		<td><span class="red">${orderAll.oid}</span></td>
							            	</tr>
							                <c:forEach items="${orderAll.orderitem}" var="oa">
								            	<tr>
								            		<td></td>
								                	<td><img src="/image/${oa.book.filename}" alt="" title="" border="0" class="cart_thumb" /></a></td>
								                	<td >${oa.book.bookname}</td>
								                    <td>${oa.book.price}￥ x ${oa.num} = <br/><br/> ${oa.money}￥</td>
								                    <td>
								                    	<c:if test="${orderAll.status == '0'}">未付款</c:if>
								                    	<c:if test="${orderAll.status == '1'}">已付款</c:if>
								                    </td>
								                </tr>          
							                </c:forEach>
							            
							
							                <tr>
								                <td colspan="3" class="cart_total"><span class="red">商品总数:</span></td>
								                <td >${orderAll.totalnum}</td>                
							                </tr>  
							                
							                <tr>
								                <td colspan="3" class="cart_total"><span class="red">总计:</span></td>
								                <td >${orderAll.totalmoney}</td>                
							                </tr>                  
							            	
							            	<tr>
							            		<td></td>
							            		<td>操作：</td>
							            		<td>
								            		<c:if test="${orderAll.status == '0'}">
								            			<a href="personal_orders/${orderAll.oid}.action">去完成付款</a>
								            		</c:if>
							            			<c:if test="${orderAll.status == '1'}">
							            				已付款
							            			</c:if>
							            		</td>
							            		<td><a href="personal_del/${orderAll.oid}.action">删除订单</a></td>
							            	</tr>
							            	<tr>
							            		<td><hr /></td>
							            		<td></td>
							            		<td></td>
							            		<td></td>
							            		<td><hr /></td>
							            	</tr>
							              </c:forEach>
							           </table>
							</c:if>
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
                		<li><a href="#">${c.classifyname}</a></li>
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