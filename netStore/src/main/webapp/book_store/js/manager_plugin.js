(function(){
	
	$.fn.GridPanel = {
		//一些默认配置
		defaultConfig:{
			
			register:{
				url:'',
			}

		},
		//所有方法都在里面
		method:{
			
			bookstore:function(config){
				//把客户端传递过来的参数覆盖掉默认的配置  true为深度迭代
				$.extend(true,$.fn.GridPanel.defaultConfig,config);
				
				
				/**
				 * 全部评论的点赞，异步不刷新
				 */
				$(".list2").delegate('font', 'click',function(){
					
					if($(this).html() == "点赞"){
						var num = parseInt($(this).parent().next().html());
						$(this).parent().next().html(num+1);
						$.post("praise.action",{
							cid:$(this).parent().next().attr("id"),
							praise:$(this).parent().next().html()
						},function(){
							
						});
						return false;
					}
					
					
				});
				/**
				 * 全部评论下 点击 回复按钮 的滑入滑出效果
				 */
				$(".list2").delegate('#replyall','click',function(){
					
					$(this).parent().find("form").slideToggle("slow");
					return false;
				});
				/**
				 * 点击全部评论滑入滑出效果
				 */
				$("#comment_all").click(function(){
					
					$(".list2").slideToggle("slow");
					return false;
					
				});
				/**
				 * 精彩评论的点赞，异步不刷新
				 */
				$(".list1").delegate('a', 'click',function(){
					
					if($(this).html() == "点赞"){
						var num = parseInt($(this).next().html());
						$(this).next().html(num+1);
						$.post("praise.action",{
							cid:$(this).next().attr("id"),
							praise:$(this).next().html()
						},function(){
							
						});
						return false;
					}
					
					
				});
				
				/**
				 *  精彩评论中，回复点击时判断用户是否已经登陆
				 */
				$(".list1").delegate('#comment_sub', 'click', function(){
					if($.cookie('username') == "null"){
						alert("请登录账号后评论");
						return false;
					}
					
				});
				/**
				 * 回复的滑入滑出效果
				 */
				$(".list1").delegate('#reply','click',function(){
					
					$(this).parent().find("form").slideToggle("slow");
					return false;
				});
				/**
				 * 精彩评论的滑入滑出效果
				 */
				$("#comment_many").click(function(){
					$(".list1").slideToggle("slow");
					return false;
				});
				/**
				 *  评论输入框的滑入滑出效果
				 */
				$("#comment_me").click(function(){
					$(".comment_input").slideToggle("slow");
					return false;
				});
				
				/**
				 *  点击退出， 清空用户名cookie
				 */
				$("#menu").delegate('#quit','click',function(){
					
					$.cookie('username',null);
					return true;
					
				});
				
				/**
				 * 个人页面 个人信息滑出
				 */
				$("#personal").click(function(){
					
					$(".usersmsg").slideToggle("slow");
					return false;
					
				});
				/**
				 * 个人页面 未支付滑出
				 */
				$("#orders").click(function(){
					
					$(".orders_table").slideToggle("slow");
					return false;
				});
				/**
				 * 个人页面 全部订单 滑出
				 */
				$("#orderAll").click(function(){
					$(".orderAll_table").slideToggle("slow");
					return false;
				});
				
				/**
				 *  结账 按钮
				 */
				$("#pay_check").click(function(){
					
					if($.cookie('itemsnum') != null){
						return true;
					}
					// 如果购物车没有东西
					alert("购物车里面还没有东西，快去购物呦~~");
					return false;
				});
				
				
				/**
				 * 把存在cookie中的购物车信息取出
				 */
				// 当 购物数量不为空时
				if($.cookie('itemsnum') != null){
					$("#num").text($.cookie('itemsnum'));
				}else{
					$("#num").text("0");
				}
				// 当 金额不为空时
				if($.cookie('money') != null){
					$("#money").text($.cookie('money'));
				}else{
					$("#money").text("0");
				}
				// 购物车的总数量
				if($.cookie('totalnum') != null){
					$("#totalnum").text($.cookie('totalnum') + " 本");
				}else{
					$("#totalnum").text("0 本")
				}
				// 购物车总金额
				if($.cookie('totalmoney') != null){
					$("#totalmoney").text($.cookie('totalmoney') + "￥");
				}else{
					$("#totalmoney").text("0 ￥");
				}
				/**
				 * 取出 用户名的 cookie
				 */
				if($.cookie('username') != "null"){
					// 如果不为空 ， 把标题置为 用户名
					$("#myaccount").text($.cookie('username'));
					// 并且链接改为 购物车
					$("#myaccount").attr("href","personal.action");
					// 添加退出按钮
					$("#myaccount").parent().after("<li><a id='quit' href='javascript:void(0)' onclick='location.reload()'>退出</a></li>");
					
				}else{
					// 如果为空则还原
					$("#myaccount").text("我的账号");
					$("#myaccount").attr("href","myaccount_bf.action");
				}
				
				
				// 标识符
				var flag = false;
				/**
				 *  匹配用户名
				 */
				$("#username").blur(function(){
					var a = 0;
					// 用户名由3-10位的字母下划线和数字组成,
					var reg_name = /^[a-zA-z][a-zA-Z0-9_]{2,9}$/; 
					$.post($.fn.GridPanel.defaultConfig.register.url,null,function(data){
						// 遍历 返回值
						$.each(data , function(i , item){
							$.each(item , function(key , value){
								
								// 取出 名字
								if(key == "username"){
									// 对比
									if(value == $("#username").val()){
										a = 1;
									}
								}
							})
						});
					});
					if($("#username").val() == ""){
						$("#name").attr("color","red");
						$("#name").text("用户名不能为空");
						flag = false;
					}else if(a == 1){
						$("#name").attr("color","red");
						$("#name").text("该用户名已被占用");
					}else if(!reg_name.test($("#username").val())){
					
						$("#name").attr("color","red");
						$("#name").text("用户名由字母开头的3-10位的字母数字组成,且字母开头");
						flag = false;
					}else{
						$("#name").attr("color","green");
						$("#name").text("该用户名可以使用");
						flag = true;
					}
				});
				
				/**
				 *  匹配 密码
				 */
				$("#password").blur(function(){

					// 密码含有数字字母，长度在6-10之间
					var reg_password = /^[a-zA-Z0-9]{6,10}$/; 
					if($("#password").val() == ""){
						$("#passwordmsg").attr("color","red");
						$("#passwordmsg").text("密码不能为空");
						flag = false;
					}else if(!reg_password.test($("#password").val())){
						$("#passwordmsg").attr("color","red");
						$("#passwordmsg").text("密码含有数字字母，长度在6-10之间");
						flag = false;
					}else{
						$("#passwordmsg").attr("color","green");
						$("#passwordmsg").text("密码可以使用");
						flag = true;
					}

				});
				
				/**
				 * 匹配 邮箱
				 */
				$("#email").blur(function(){
					// 邮箱格式
					var reg_email = /^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
					
					if($("#email").val() == ""){
						$("#emailmsg").attr("color","red");
						$("#emailmsg").text("邮箱不能为空");
						flag = false;
					}else if(!reg_email.test($("#email").val())){
						$("#emailmsg").attr("color","red");
						$("#emailmsg").text("请输入正确的邮箱格式");
						flag = false;
					}else{
						$("#emailmsg").attr("color","green");
						$("#emailmsg").text("邮箱可以使用");
						flag = true;
					}
					
				});
				/**
				 * 匹配 手机号码
				 */
				$("#phone").blur(function(){
					
					var reg_phone = /^1[0-9]{10}$/;
					
					if($("#phone").val() == ""){
						$("#phonemsg").attr("color","red");
						$("#phonemsg").text("手机号码不能为空");
						flag = false;
					}else if(!reg_phone.test($("#phone").val())){
						$("#phonemsg").attr("color","red");
						$("#phonemsg").text("请输入正确的手机号码格式");
						flag = false;
					}else{
						$("#phonemsg").attr("color","green");
						$("#phonemsg").text("手机可以使用");
						flag = true;
					}
					
				});
				/**
				 * 匹配 地址 
				 */
				$("#address").blur(function(){
					if($("#address").val() == ""){
						$("#addressmsg").attr("color","red");
						$("#addressmsg").text("寄件地址不能为空");
						flag = false;
					}else{
						$("#addressmsg").text("");
						flag = true;
					}
				});
				/**
				 *  注册
				 */
				$("#submit").click(function(){
					if($("#agree").is(":checked") && flag == true){
						return true;
					}
					if(!$("#agree").is(":checked")){
						alert("同意本店协议");
						return false;
					}
					if(flag == false){
						alert("表格输入有误");
						return false;
					}
					
				});

			}
		}
	}
})($);