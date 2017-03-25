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
				 * 取出用户名的cookie
				 */
				if($.cookie('username') != null){
					// 如果不为空 ， 把标题置为 用户名
					$("#myaccount").text($.cookie('username'));
					// 并且链接改为 购物车
					$("#myaccount").attr("href","cart.action");
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
						$("#name").text("用户名由字母开头的3-10位的字母数字组成");
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