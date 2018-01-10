package com.thinkgem.manage.modules.tool.dao;

import com.thinkgem.manage.common.persistence.CrudDao;
import com.thinkgem.manage.common.persistence.annotation.MyBatisDao;
import com.thinkgem.manage.modules.tool.entity.TDictTree;

/**
 * 树形数据字典DAO接口
 * @author gh
 * @version 2018-01-06
 */
@MyBatisDao
public interface TDictTreeDao extends CrudDao<TDictTree> {
	
}