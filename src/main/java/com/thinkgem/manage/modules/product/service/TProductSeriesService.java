package com.thinkgem.manage.modules.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.manage.common.persistence.Page;
import com.thinkgem.manage.common.service.CrudService;
import com.thinkgem.manage.modules.product.entity.TProductSeries;
import com.thinkgem.manage.modules.product.dao.TProductSeriesDao;

/**
 * 产品配置-系列Service
 * @author zgh
 * @version 2018-01-09
 */
@Service
@Transactional(readOnly = true)
public class TProductSeriesService extends CrudService<TProductSeriesDao, TProductSeries> {

	public TProductSeries get(String id) {
		return super.get(id);
	}
	
	public List<TProductSeries> findList(TProductSeries tProductSeries) {
		return super.findList(tProductSeries);
	}
	
	public Page<TProductSeries> findPage(Page<TProductSeries> page, TProductSeries tProductSeries) {
		return super.findPage(page, tProductSeries);
	}
	
	@Transactional(readOnly = false)
	public void save(TProductSeries tProductSeries) {
		super.save(tProductSeries);
	}
	
	@Transactional(readOnly = false)
	public void delete(TProductSeries tProductSeries) {
		super.delete(tProductSeries);
	}
	
}