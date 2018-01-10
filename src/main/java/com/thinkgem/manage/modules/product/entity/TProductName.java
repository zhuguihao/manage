package com.thinkgem.manage.modules.product.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.manage.common.persistence.DataEntity;

/**
 * 产品配置-系列及产品名称Entity
 * @author zgh
 * @version 2018-01-09
 */
public class TProductName extends DataEntity<TProductName> {
	
	private static final long serialVersionUID = 1L;
	private TProductSeries tSeriesId;		// 产品系列ID 父类
	private String proCode;		// 产品名称编码
	private String proName;		// 产品名称
	private String sort;		// 排序
	
	public TProductName() {
		super();
	}

	public TProductName(String id){
		super(id);
	}

	public TProductName(TProductSeries tSeriesId){
		this.tSeriesId = tSeriesId;
	}

	@Length(min=0, max=32, message="产品系列ID长度必须介于 0 和 32 之间")
	public TProductSeries getTSeriesId() {
		return tSeriesId;
	}

	public void setTSeriesId(TProductSeries tSeriesId) {
		this.tSeriesId = tSeriesId;
	}
	
	@Length(min=0, max=200, message="产品名称编码长度必须介于 0 和 200 之间")
	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	
	@Length(min=0, max=500, message="产品名称长度必须介于 0 和 500 之间")
	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}