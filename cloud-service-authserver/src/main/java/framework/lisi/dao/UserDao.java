/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package framework.lisi.dao;

import java.util.List;
import java.util.Map;

import framework.lisi.base.BaseDao;
import framework.lisi.base.MyBatisDao;
import framework.lisi.entity.Office;
import framework.lisi.entity.User;

/**
 * 用户DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
public interface UserDao extends BaseDao<User> {
	
	/**
	 * 根据登录名称查询用户
	 * @param loginName
	 * @return
	 */
	public User getByLoginName(User user);

	/**
	 * 通过OfficeId获取用户列表，仅返回用户id和name（树查询用户时用）
	 * @param user
	 * @return
	 */
	public List<User> findUserByOfficeId(User user);
	
	/**
	 * 查询全部用户数目
	 * @return
	 */
	public long findAllCount(User user);
	
	/**
	 * 更新用户密码
	 * @param user
	 * @return
	 */
	public int updatePasswordById(User user);
	
	/**
	 * 更新登录信息，如：登录IP、登录时间
	 * @param user
	 * @return
	 */
	public int updateLoginInfo(User user);

	/**
	 * 删除用户角色关联数据
	 * @param user
	 * @return
	 */
	public int deleteUserRole(User user);
	
	/**
	 * 插入用户角色关联数据
	 * @param user
	 * @return
	 */
	public int insertUserRole(User user);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public int updateUserInfo(User user);
	
	/**
	 * 根据角色enname查找用户列表
	 * @param roleId
	 * @return
	 */
	public List<User> findUserByRoleEnname(String enname);
	
	/**
	 * 根据激活码查找用户
	 * @param code 用户激活码
	 */
	public List<User> findUserByCode(String code);
	
	
	
	public User getUserById(User user);

	/**
	 * 省用户，获取全部用户；市用户，获取市下面的用户；监测点用户，获取监测点下面的用户
	 * @param office
	 * @return
	 */
	public List<User> findTypeUser(Office office);
	
	public Map<String,Object> forgetPassword(User user);
	
	public void updatePwdByLoginNameAndEmail(User user);

	List<User> findAll();
}
