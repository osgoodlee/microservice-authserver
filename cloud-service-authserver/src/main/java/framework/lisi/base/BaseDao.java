package framework.lisi.base;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
//import com.github.miemiedev.mybatis.paginator.domain.PageList;
public interface BaseDao<T> {

//	int deleteByPrimaryKey(Object id);
//
//	int insert(T record);
//
//	int insertSelective(T record);
//
//	T selectByPrimaryKey(Object id);
//
//	int updateByPrimaryKeySelective(T record);
//
//	int updateByPrimaryKey(T record);
//
//	List<T> findList();
//
//	/**
//	 * 根据实体条件，获取记录总数
//	 * 
//	 * @param entity
//	 * @return
//	 */
//	Long countListByEntity(T entity);
//
//	/**
//	 * 根据实体条件，获取全部记录，不分页
//	 * 
//	 * @param entity
//	 * @return
//	 */
//	List<T> findListByEntity(T entity);

	/**
	 * 根据实体条件，获取全部记录，不分页
	 * 
	 * @param entity
	 * @return
	 */
//	PageList<T> findPageListByEntity(T entity, PageBounds pageBounds);
}
