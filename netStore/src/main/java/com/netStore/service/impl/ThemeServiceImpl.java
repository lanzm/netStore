package com.netStore.service.impl;

import java.io.Serializable;
import java.util.List;

import com.netStore.dao.ThemeDao;
import com.netStore.pojo.Theme;
import com.netStore.service.ThemeService;

public class ThemeServiceImpl implements ThemeService{
	
	
	public ThemeDao ThemeDao;
	

	public ThemeDao getThemeDao() {
		return ThemeDao;
	}

	public void setThemeDao(ThemeDao themeDao) {
		ThemeDao = themeDao;
	}

	@Override
	public void save_Theme(Theme theme) {

		this.ThemeDao.save(theme);
		
	}

	@Override
	public void remove_Theme(Serializable id) {

		this.ThemeDao.remove(id);
		
	}

	@Override
	public void update_Theme(Theme theme) {

		this.ThemeDao.update(theme);
		
	}

	@Override
	public Theme get_ThemeById(Serializable id) {
		
		return (Theme) this.ThemeDao.getById(id);
	}

	@Override
	public List<Theme> list_Theme() {
		
		return this.ThemeDao.list();
	}


}
