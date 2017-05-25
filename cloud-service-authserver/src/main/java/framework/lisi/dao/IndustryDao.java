/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package framework.lisi.dao;

import java.util.List;

import framework.lisi.base.BaseDao;
import framework.lisi.base.MyBatisDao;
import framework.lisi.entity.Industry;


/**
 * 区域DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface IndustryDao extends BaseDao<Industry> {
	/**
	 * 根据区域代码获取下级区域列表
	 * @param code
	 * @return
	 */
	public List<Industry> findListByPCode(String code);
}
