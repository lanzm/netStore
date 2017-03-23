(function(){
	
	$.fn.GridPanel = {
		//一些默认配置
		defaultConfig:{
			option:{
				allbook:'',
				del_book:'',
				updatebook:{
					update_button:'',
					url:'',
					url_promotions:'',
				},
				addbook:{
					url:'',
					addbook_button:'',
					form:''
				},
				// 以下为 书籍分类 传的值
				delAll:'',
				del:'',
				updateclassify:{
					url:''
				},
				addclassify:{
					url:'',
					classify_id:'',
					table_id:'',
					sure:''
				}
			}
		},
		//所有方法都在里面
		method:{
			
			manager:function(config){
				//把客户端传递过来的参数覆盖掉默认的配置  true为深度迭代
				$.extend(true,$.fn.GridPanel.defaultConfig,config);
				
				/**
				 *  修改 是否促销 事件
				 */
				$("#promotions").live('change',function(){
					// 设置标识符
					var flag = false;
					// 选择的是什么
					if($(this).val() == "是"){
						flag = true;
					}
					else if($(this).val() == "否"){
						flag = false;
					}else{
						flag = null;
					}
					// 取 该行的id值
					var id = $(this).parent().parent().children().eq(0).children().eq(1).attr("value");
					// 往后台送数据
					$.post($.fn.GridPanel.defaultConfig.option.updatebook.url_promotions,{
						flag:flag,
						bookid:id
					},function(){
						
					});
				});
				
				/**
				 * 搜索点击事件
				 * 搜索字段为空时 ， 刷新本页
				 */
				$("#seach").click(function(){
					// 当 输入框中值为空时
					if($("#vague").attr("value") == ""){
						// 刷新页面
						$("#seach").attr("href","listBook.action");
						return true;
					}else{
						return true;
					}
				});
				
	// ============================================================================== //
				/**
				 * 全选事件
				 */
				$("#" + $.fn.GridPanel.defaultConfig.option.allbook).click(function(){
					if($("#" + $.fn.GridPanel.defaultConfig.option.allbook).is(":checked")){
						// 遍历表格中checkbox
						$("#table-2 tr td input[type = 'checkbox']").each(function(){
							// 置成勾选状态
							$(this).attr("checked","checked");
						});
					}else{
						// 遍历表格中checkbox
						$("#table-2 tr td input[type = 'checkbox']").each(function(){
							// 置成不勾选状态
							$(this).attr("checked","");
						});
					}
				});
				
				/**
				 * 删除所选 事件
				 */
				// 删除所选 按钮事件
				$("#" + $.fn.GridPanel.defaultConfig.option.del_book).click(function(){
					// 遍历表格中checkbox
					$("#table-2 tr td input[type = 'checkbox']").each(function(){
						// 当选中时
						if($(this).is(":checked")){
							// 删除
							$.post("removeBook/"+ $(this).parent().children().eq(1).attr("value") +".action",null,function(){
								// 刷新页面
								history.go(0);
							});
						}
					});
				});
			
				/**
				 * 修改 书籍事件
				 * 
				 */
				$("#" + $.fn.GridPanel.defaultConfig.option.updatebook.update_button).click(function(){
					// 标识符
					var flag = 0;
					$("#table-2 tr td input[type = 'checkbox']").each(function(){
						// 当选中多个时
						if($("#table-2 tr td input[type = 'checkbox']:checked").length > 1){
							flag = 1;
						}
						// 当没有选时
						if($("#table-2 tr td input[type = 'checkbox']:checked").length < 1){
							flag = 2;
						}
					});
					// 判断
					if(flag == 1){
						alert("不要选择多个书籍");
						return false;
					}else if(flag == 2){
						alert("请选择一个书籍进行修改");
						return false;
					// 条件符合时
					}else{
						// 取出 选中id
						var bid = $("#table-2 tr td input[type = 'checkbox']:checked").parent().children().eq(1).attr("value");
						// 填充到 路径中
						$("#" + $.fn.GridPanel.defaultConfig.option.updatebook.update_button).attr("href","updateBook_bf/" + bid + ".action");
						// 通过
						return true;
					}
					
				});
				/**
				 * 添加 书籍事件
				 * 在 addbook页面下
				 */
				$("#" + $.fn.GridPanel.defaultConfig.option.addbook.addbook_button).click(function(){
				
					// 判断输入id值是否合法   数字 ： ^[1-9]\d*$
					var reg = /^(\d*\.)?\d+$/;
					
					if($("#bookname").val() == ""){
						alert("请输入书籍名称");
					}else if($("#author").val() == ""){
						alert("请输入书籍作者");
					}else if($("#classifyn").val() == "--请选择书籍分类--"){
						alert("请选择书籍分类");
					}else if($("#photo").val() == ""){
						alert("请选择书籍图片");
					}else if($("#price").val() == ""){
						alert("请输入书籍价格");
					}else if(!reg.test($("#price").val())){
						alert("请输入合法的价格");
					}else{
						// ok
						return true;
					}
					return false;
					
				});
    // ==================================================================================== //
	//            以下为 书籍分类 表格方法 
	// ==================================================================================== //
				/**
				 * 全选事件
				 */
				$("#" + $.fn.GridPanel.defaultConfig.option.delAll).click(function(){
					
					if($("#" + $.fn.GridPanel.defaultConfig.option.delAll).is(":checked")){
						// 遍历表格中checkbox
						$("#table-1 tr td input[type = 'checkbox']").each(function(){
							// 置成勾选状态
							$(this).attr("checked","checked");
						});
					}else{
						// 遍历表格中checkbox
						$("#table-1 tr td input[type = 'checkbox']").each(function(){
							// 置成不勾选状态
							$(this).attr("checked","");
						});
					}
				});
					
				/**
				 * 删除所选 事件
				 */
				// 删除所选 按钮事件
				$("#" + $.fn.GridPanel.defaultConfig.option.del).click(function(){
					// 遍历表格中checkbox
					$("#table-1 tr td input[type = 'checkbox']").each(function(){
						// 当选中时
						if($(this).is(":checked")){
							// 删除
							$.post("removeClassify/"+ $(this).parent().next().html() +".action",null,function(){
							});
						}
					});
				});
				/**
				 * 修改 事件
				 * td:not(:has(a)) td中不含a标签
				 */
				$("#" + $.fn.GridPanel.defaultConfig.option.addclassify.table_id).delegate('td:not(:has(a))','click',function(){
					//排除 新增的input框
					if($(this).children().attr("value") == ""){
					
					//  排除 checkbox	
					}else if($(this).children().attr("value") == "on"){
					
					// 当 选中 名称和描述时 
					}else{
						//防止第二次点击生成 第二个input
						if($(this).children().attr("type") == "text"){
							
							//鼠标失去焦点事件
							$(this).children().blur(function(){
								// 判断输入是否合法
								if($(this).val() != "" || $(this).val() != "null"){
									//定义一个标志
									var flog = true;
									//定义一个数组，接收 表格中的值
									var j = new Array(5);
									// 输入的值
									var a = $(this).val();
									// 父节点 td
									var $td = $(this).parent();
									// 循环遍历表格的一行
									for(var i = 1; i < 4 ; i ++){
										//当 遇到 输入框时  this为input标签， 父亲的父亲就是tr
										if($(this).parent().parent().children().eq(i).children().is("input")){
											//把输入框的值取出，放入数组中
											j[i] = $(this).parent().parent().children().eq(i).children().attr("value");
										}else{
											// 否则 不是输入框，则没有修改值，把值直接取出放入数组
											j[i] = $(this).parent().parent().children().eq(i).html();
										}
									}
									//解决编号相同时的问题，
									if($(this).parent().parent().children().eq(1).children().is("input")){
										// 把所有的编号遍历出来
										for(var b = 1; b < $("#table-1 tr").length; b ++){
											// 和 输入的值相对比 如果相等就置为 false
											if(j[1] == $("#table-1 tr").eq(b).children().eq(1).html()){
												flog = false;
												//break;
											}
										}
									}
									// 判断输入id值是否合法   数字 ： ^[1-9]\d*$
									var reg = /^[1-9]\d*$/;
									if(reg.test(j[1])){
										//判断 编号是否重复
										if(flog){
											//向后台送修改数据
											$.post($.fn.GridPanel.defaultConfig.option.updateclassify.url,{
												cid:j[1],
												classifyname:j[2],
												description:j[3]
											},function(){
												//如果修改了 id值 相对应的 删除标签也要修改
												$td.parent().children().eq(4).children().attr("href","removeClassify/" + j[1] +".action");
												//在回调函数中 把 输入的值插入父节点
												$td.html(a);
												//删除 input标签
												$td.children().remove();
												
											});
										}else{
											alert("编号不能相同，请重新输入！！");
										}
										
									//否则 输入的id不合法
									}else{
										alert("请输入合法的编号！(数字0~9)");
									}
									
								}
							});
						}else{
							//设置input标签
							var input = $("<input type=\"text\"/>");
							//把原始值传到input中
							input.attr("value",$(this).text());
							//聚焦，光标
							input.focus();
							//将原始的数据置空
							$(this).html("");
							//拼接 input标签
							input.appendTo($(this));
						}
					}
						
					
					
				});
				 /**
				  * 点击 添加分类 按钮事件
				  */
				 $("#" + $.fn.GridPanel.defaultConfig.option.addclassify.classify_id).click(function(){
					
					//在原始表格下面添加一行，用以添加分类
					 var tr = $("<tr align=\"center\"></tr>");
					 var td1 = $("<td>" + "<input type = \"checkbox\"/>" + "</td>");
					 td1.appendTo(tr);
					 //  parseInt把String类型转换为int类型。
					 //  $("#table-1 tr:last td:nth-child(2)").text()  取子元素下面的值
					 var td2 = $("<td>" + (parseInt($("#table-1 tr:last td:nth-child(2)").text()) + 1) + "</td>");
					 td2.appendTo(tr);
					 var td3 = $("<td>" + "<input id=\"classifyname\"/></th>" + "</td>");
					 td3.appendTo(tr);
					 var td4 = $("<td>" + "<input id=\"description\"/></th>" + "</td>");
					 td4.appendTo(tr);
					 var td5 = $("<td>" + "<a id = \"del\" href = \"javascript:volid(0);\">删除</a>" + "</td>");
					 td5.appendTo(tr);
					 //将新增加的一行添加到 table上
					 $("#" + $.fn.GridPanel.defaultConfig.option.addclassify.table_id).append(tr);
					 //设置按键无效
					 $("#" + $.fn.GridPanel.defaultConfig.option.addclassify.classify_id).attr("disabled",true);
					 //定义变量，接收输入的值
					 var js_classifyname;
					 var js_description;
					 var length;
					 //当鼠标失去焦点时
					 $("#" + $.fn.GridPanel.defaultConfig.option.addclassify.table_id).delegate('input','blur',function(){
						 //判断 是否有输入值
						 if($("#classifyname").val() == ""  || $("#classifyname").val() == null ){
							 
						 }
						 else if($("#description").val() == ""  || $("#description").val() == null ){
							 
						 }else{
							 //把输入的值取出
							 js_classifyname = $("#classifyname").val();
							 js_description = $("#description").val();
							 //取表格长度
							 length = parseInt($("#table-1 tr:last td:nth-child(2)").text());
							 //将输入的值插入父类标签
							 $("#classifyname").parent().append(js_classifyname);
							 $("#description").parent().append(js_description);
							 //删除input标签
							 $("#classifyname").remove();
							 $("#description").remove();
							 //删除链接 href设置
							 $("#del").attr("href","removeClassify/" + length +".action");
							 //要把删除按键的id去掉
							 $("#del").removeAttr("id");
							 //最后往后台存数据
							 $.post($.fn.GridPanel.defaultConfig.option.addclassify.url,{
								 classifyname:js_classifyname,
								 description:js_description,
								 cid:length
							 },function(data){
								 //还原按键设置
								 length = 0;
								 $("#" + $.fn.GridPanel.defaultConfig.option.addclassify.classify_id).attr("disabled",false);
							 });
						 }
					 });
				});
			},
		}
	}
	
	
})($);