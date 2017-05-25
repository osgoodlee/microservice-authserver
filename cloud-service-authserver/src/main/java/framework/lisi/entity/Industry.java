/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package framework.lisi.entity;

import org.hibernate.validator.constraints.Length;


/**
 * 区域Entity
 * @author ThinkGem
 * @version 2013-05-15
 */
public class Industry extends TreeEntity<Industry> {

	private static final long serialVersionUID = 1L;
	private String code; 	// 区域编码
	private String sCode;//内编码,用于树生成
	
	
	public Industry(){
		super();
		this.sort = 30;
	}

	public Industry(String id){
		super(id);
	}
	public Industry getParent() {
		return parent;
	}

	public void setParent(Industry parent) {
		this.parent = parent;
	}

	@Length(min=0, max=100)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}
	
}