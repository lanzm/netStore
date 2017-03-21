package com.netStore.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.netStore.pojo.Classify;
import com.netStore.service.ClassifyService;

@Controller
@RequestMapping("/manager")
public class ClassifyAction {
	//自动注入 
	@Autowired
	public ClassifyService ClassifyService;

	/**
	 * 查询分类
	 * @return 
	 */
	@RequestMapping("/listClassify")
	public String listClassify(Model model){
		
		List<Classify> lists = ClassifyService.list_Classify();
		model.addAttribute("lists", lists);
		
		return "classify";
		
	}
	/**
	 * 删除分类
	 * @param id
	 * @return 重定向方法
	 */
	@RequestMapping("/removeClassify/{id}")
	public String removeClassify(@PathVariable long id){
		
		ClassifyService.remove_Classify(id);
		//System.out.println("删除" + id);
		
		return "redirect:/manager/listClassify.action";
		
	}
	
	/**
	 * 添加分类
	 * @param cid 
	 * @param classifyname
	 * @param description
	 * @return 返回查询页面
	 */
	@RequestMapping("/addClassify")
	public  String addClassify(String cid,String classifyname,String description){
		
		System.out.println(cid);
		System.out.println(classifyname);
		
		//把string类型的cid转成long类型
		long id = Long.parseLong(cid);
		//新增一个classify
		Classify classify = new Classify();
		classify.setCid(id);
		classify.setClassifyname(classifyname);
		classify.setDescription(description);
		//存入
		ClassifyService.save_Classify(classify);
		
		return "redirect:/manager/listClassify.action";
	}
	/**
	 * 修改分类
	 * @param cid
	 * @param classifyname
	 * @param description
	 * @return 重定向到展示页面
	 */
	@RequestMapping("/updateClassify")
	public  String updateClassify(String cid,String classifyname,String description){
		
		System.out.println(cid + " ===" + classifyname + "=======" + description);
		
		//把string类型的cid转成long类型
		long id = Long.parseLong(cid);
		//新增一个classify
		Classify classify = new Classify();
		classify.setCid(id);
		classify.setClassifyname(classifyname);
		classify.setDescription(description);
		ClassifyService.update_Classify(classify);
		
		return "redirect:/manager/listClassify.action";
	}
	
	


}
