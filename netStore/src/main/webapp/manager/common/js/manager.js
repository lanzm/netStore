$().ready(function(){
	
	$.fn.GridPanel.method.manager({
		option:{
			allbook:'allbook',
			del_book:'del_book',
			updatebook:{
				update_button:'update',
				url:'updateBook.action',
				url_promotions:'updateBookPmt.action'
			},
			addbook:{
				url:'addBook_bf.action',
				addbook_button:'add',
				form:'addbook'
			},
			//------------------
			delAll:'all',
			del:'del_checked',
			updateclassify:{
				url:'updateClassify.action'
			},
			addclassify:{
				url:'addClassify.action',
				classify_id:'addclassify',
				table_id:'table-1',
				sure:'sure'
			}
			
		}
		
	});
	
});