package com.thinkgem.manage.modules.tool.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.manage.common.persistence.Page;
import com.thinkgem.manage.common.service.CrudService;
import com.thinkgem.manage.modules.tool.entity.TDictTree;
import com.thinkgem.manage.modules.tool.dao.TDictTreeDao;

/**
 * 树形数据字典Service
 * @author gh
 * @version 2018-01-06
 */
@Service
@Transactional(readOnly = true)
public class TDictTreeService extends CrudService<TDictTreeDao, TDictTree> {

	public TDictTree get(String id) {
		return super.get(id);
	}
	
	public List<TDictTree> findList(TDictTree tDictTree) {
		return super.findList(tDictTree);
	}
	
	public Page<TDictTree> findPage(Page<TDictTree> page, TDictTree tDictTree) {
		return super.findPage(page, tDictTree);
	}
	
	@Transactional(readOnly = false)
	public void save(TDictTree tDictTree) {
		super.save(tDictTree);
	}
	
	@Transactional(readOnly = false)
	public void delete(TDictTree tDictTree) {
		super.delete(tDictTree);
	}
	
}