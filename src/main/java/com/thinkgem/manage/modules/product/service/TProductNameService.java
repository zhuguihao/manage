package com.thinkgem.manage.modules.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.manage.common.persistence.Page;
import com.thinkgem.manage.common.service.CrudService;
import com.thinkgem.manage.modules.product.entity.TProductName;
import com.thinkgem.manage.modules.product.dao.TProductNameDao;

/**
 * 产品配置-产品名称Service
 * @author zgh
 * @version 2018-01-09
 */
@Service
@Transactional(readOnly = true)
public class TProductNameService extends CrudService<TProductNameDao, TProductName> {

	public TProductName get(String id) {
		return super.get(id);
	}
	
	public List<TProductName> findList(TProductName tProductName) {
		return super.findList(tProductName);
	}
	
	public Page<TProductName> findPage(Page<TProductName> page, TProductName tProductName) {
		return super.findPage(page, tProductName);
	}
	
	@Transactional(readOnly = false)
	public void save(TProductName tProductName) {
		super.save(tProductName);
	}
	
	@Transactional(readOnly = false)
	public void delete(TProductName tProductName) {
		super.delete(tProductName);
	}
	
}