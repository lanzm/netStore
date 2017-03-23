(function(){
	
	$.fn.GridPanel = {
		//一些默认配置
		defaultConfig:{
			

		},
		//所有方法都在里面
		method:{
			
			bookstore:function(config){
				//把客户端传递过来的参数覆盖掉默认的配置  true为深度迭代
				$.extend(true,$.fn.GridPanel.defaultConfig,config);
				
				$("#" + $.fn.GridPanel.defaultConfig.category.page_id).click(function(){
					
					$.post("pageBook/2.action",null,function(){
						
					});
				});
				
			}
			
	
			
			
			
		}
	}
})($);