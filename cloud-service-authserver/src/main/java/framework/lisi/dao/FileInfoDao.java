/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package framework.lisi.dao;

import java.util.List;

import framework.lisi.base.BaseDao;
import framework.lisi.base.MyBatisDao;
import framework.lisi.entity.FileInfo;


/**
 * 机构DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface FileInfoDao extends BaseDao<FileInfo> {
	
	public int delete(String id);
	
	public List<FileInfo> findFile(String businessId, String businessKey);
	
	public void updateTmp(String id, String sessionId);
	
}
