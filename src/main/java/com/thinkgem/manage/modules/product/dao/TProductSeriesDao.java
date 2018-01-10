package com.thinkgem.manage.modules.product.dao;

import com.thinkgem.manage.common.persistence.CrudDao;
import com.thinkgem.manage.common.persistence.annotation.MyBatisDao;
import com.thinkgem.manage.modules.product.entity.TProductSeries;

/**
 * 产品配置-系列DAO接口
 * @author zgh
 * @version 2018-01-09
 */
@MyBatisDao
public interface TProductSeriesDao extends CrudDao<TProductSeries> {
	
}