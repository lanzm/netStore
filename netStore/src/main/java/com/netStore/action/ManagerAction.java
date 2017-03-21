package com.netStore.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netStore.pojo.Manager;
import com.netStore.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerAction {
	//自动注入 
	@Autowired
	public ManagerService ManagerService;

	// 登陆
	@RequestMapping("/managerlogin")
	public String managerlogin(Model model,HttpSession httpSession,String managername,String password){
		
		List<Manager> lists = ManagerService.list_Manager();
		for (Manager manager : lists) {
			if(manager.getManagername().equals(managername) && manager.getPassword().equals(password)){
				httpSession.setAttribute("managername", managername);
				return "index";
			}
		}
		return "login";
	}
	// 退出
	@RequestMapping("/managerlogout")
	public String managerlogout(HttpSession httpSession){
		httpSession.invalidate();
		return "redirect:managerlogin.action";
	}

}
