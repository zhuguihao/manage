package com.thinkgem.manage.modules.product.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.manage.common.persistence.DataEntity;

/**
 * 产品配置-系列Entity
 * @author zgh
 * @version 2018-01-09
 */
public class TProductSeries extends DataEntity<TProductSeries> {
	
	private static final long serialVersionUID = 1L;
	private String seriesCode;		// 系列编码
	private String series;		// 系列
	private String sort;		// 排序
	
	public TProductSeries() {
		super();
	}

	public TProductSeries(String id){
		super(id);
	}

	@Length(min=0, max=200, message="系列编码长度必须介于 0 和 200 之间")
	public String getSeriesCode() {
		return seriesCode;
	}

	public void setSeriesCode(String seriesCode) {
		this.seriesCode = seriesCode;
	}
	
	@Length(min=0, max=200, message="系列长度必须介于 0 和 200 之间")
	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}