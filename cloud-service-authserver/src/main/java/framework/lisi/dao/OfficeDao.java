/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package framework.lisi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import framework.lisi.base.BaseDao;
import framework.lisi.base.MyBatisDao;
import framework.lisi.entity.Office;


/**
 * 机构DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface OfficeDao extends BaseDao<Office> {
	public Office findOfficeById(String id);
	
	public List<Office> findListByType(String type);
	
	public Map<String,Object> findMaxNo(Office office);
	public Map<String,Object> findMaxSort(Office office);
	public List<Office> findMaxSortByPid(@Param("id")String id);
	/**
	 * 
	 * @param id 机构id
	 * @return map 根绝id查询联系人，电话
	 */
	public Map<String,Object> findMasterById(@Param("id")String id);
	
	public List<Office> findOfficeTree();
	
}
