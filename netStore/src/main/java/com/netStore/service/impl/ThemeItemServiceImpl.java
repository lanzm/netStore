package com.netStore.service.impl;

import java.io.Serializable;
import java.util.List;

import com.netStore.dao.ThemeItemDao;
import com.netStore.pojo.ThemeItem;
import com.netStore.service.ThemeItemService;

public class ThemeItemServiceImpl implements ThemeItemService{
	
	
	public ThemeItemDao ThemeItemDao;

	
	
	public ThemeItemDao getThemeItemDao() {
		return ThemeItemDao;
	}

	public void setThemeItemDao(ThemeItemDao themeItemDao) {
		ThemeItemDao = themeItemDao;
	}

	@Override
	public void save_ThemeItem(ThemeItem themeItem) {
		
		this.ThemeItemDao.save(themeItem);
		
	}

	@Override
	public void remove_ThemeItem(Serializable id) {


		this.ThemeItemDao.remove(id);
		
	}

	@Override
	public void update_ThemeItem(ThemeItem themeItem) {


		this.ThemeItemDao.update(themeItem);
		
	}

	@Override
	public ThemeItem get_ThemeItemById(Serializable id) {
		
		return (ThemeItem) this.ThemeItemDao.getById(id);
	}

	@Override
	public List<ThemeItem> list_ThemeItem() {
		
		return this.ThemeItemDao.list();
	}
	


}
