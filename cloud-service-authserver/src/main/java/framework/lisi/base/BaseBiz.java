package framework.lisi.base;

import java.util.List;

//import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
//import com.github.miemiedev.mybatis.paginator.domain.PageList;


public interface BaseBiz<T> {
	
	/**
	 * 通过id获取实体
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	T getEntityById(Object id) throws Exception;

	/**
	 * 更新实体
	 * 
	 * @param course
	 * @throws Exception
	 */
	int updateEntity(T instance) throws Exception;

	/**
	 * 增加实体
	 */
	int addEntity(T instance) throws Exception;

	/**
	 * 删除实体
	 */
	int deleteEntity(Object id) throws Exception;

	/**
	 * 获取全部记录
	 * 
	 * @return
	 */
	List<T> findList() throws Exception;

	/**
	 * 根据实体条件，获取记录总数
	 * 
	 * @param entity
	 * @return
	 */
	Long countListByEntity(T entity) throws Exception;

	/**
	 * 根据实体条件，获取全部记录，不分页
	 * 
	 * @param entity
	 * @return
	 */
	List<T> findListByEntity(T entity) throws Exception;

	/**
	 * 根据实体条件，获取全部记录，不分页
	 * 
	 * @param entity
	 * @return
	 */
//	PageList<T> findPageListByEntity(T entity, PageBounds pageBounds) throws Exception;
	
}
