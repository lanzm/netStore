package com.netStore.service;

import java.io.Serializable;
import java.util.List;

import com.netStore.pojo.ThemeItem;

public interface ThemeItemService {
	
	void save_ThemeItem(ThemeItem themeItem);
	void remove_ThemeItem(Serializable id);
	void update_ThemeItem(ThemeItem themeItem);
	ThemeItem get_ThemeItemById(Serializable id);
	List<ThemeItem> list_ThemeItem();

}
