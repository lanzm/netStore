package com.netStore.service;

import java.io.Serializable;
import java.util.List;

import com.netStore.pojo.Classify;
import com.netStore.pojo.Manager;

public interface ClassifyService {
	
	void save_Classify(Classify classify);
	void remove_Classify(Serializable id);
	void update_Classify(Classify classify);
	Classify get_ClassifyById(Serializable id);
	List<Classify> list_Classify();
	Classify get_ClassifyByName(String classifyname);

}
