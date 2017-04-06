package com.netStore.service;

import java.io.Serializable;
import java.util.List;

import com.netStore.pojo.Theme;

public interface ThemeService {
	
	void save_Theme(Theme theme);
	void remove_Theme(Serializable id);
	void update_Theme(Theme theme);
	Theme get_ThemeById(Serializable id);
	List<Theme> list_Theme();

}
