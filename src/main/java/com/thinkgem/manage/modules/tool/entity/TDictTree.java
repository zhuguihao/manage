package com.thinkgem.manage.modules.tool.entity;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;

import com.thinkgem.manage.common.persistence.DataEntity;

/**
 * 树形数据字典Entity
 * @author gh
 * @version 2018-01-06
 */
public class TDictTree extends DataEntity<TDictTree> {
	
	private static final long serialVersionUID = 1L;
	private String code;		// 编码
	private String value;		// 值
	private TDictTree parent;		// 父级ID
	
	public TDictTree() {
		super();
	}

	public TDictTree(String id){
		super(id);
	}

	@Length(min=0, max=20, message="编码长度必须介于 0 和 20 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=200, message="值长度必须介于 0 和 200 之间")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@JsonBackReference
	public TDictTree getParent() {
		return parent;
	}

	public void setParent(TDictTree parent) {
		this.parent = parent;
	}
	
}