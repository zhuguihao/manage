package com.thinkgem.manage.modules.product.dao;

import com.thinkgem.manage.common.persistence.CrudDao;
import com.thinkgem.manage.common.persistence.annotation.MyBatisDao;
import com.thinkgem.manage.modules.product.entity.TProductName;

/**
 * 产品配置-系列及产品名称DAO接口
 * @author zgh
 * @version 2018-01-09
 */
@MyBatisDao
public interface TProductNameDao extends CrudDao<TProductName> {
	
}