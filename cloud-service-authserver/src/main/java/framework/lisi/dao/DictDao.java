/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package framework.lisi.dao;

import java.util.List;

import framework.lisi.base.BaseDao;
import framework.lisi.base.MyBatisDao;
import framework.lisi.entity.Dict;


/**
 * 字典DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface DictDao extends BaseDao<Dict> {

	public List<String> findTypeList(Dict dict);
	
}
