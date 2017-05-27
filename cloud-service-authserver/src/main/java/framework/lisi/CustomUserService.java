package framework.lisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import framework.lisi.dao.UserDao;
import framework.lisi.entity.User;

/**
 * @author lisi
 * @since 2017年5月4日
 */
public class CustomUserService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

//	 @Override
//	 public UserDetails loadUserByUsername(String s) throws
//	 UsernameNotFoundException {
//	 User entity = new User();
//	 entity.setLoginName(s);
//	 entity.setUsername(entity.getLoginName());
//	 entity.setPassword("$2a$10$0qHkyYbIvVJ3y.Ru2mWGEONue.2StA5UzAsczLIet6Ec6f0k6GjMW");
//	 entity.setEmail("shannonlee");
//	 entity.setName("test");
//	 return new org.springframework.security.core.userdetails.User(
//	 entity.getUsername(), entity.getPassword(),
//	 true,//是否可用
//	 true,//是否过期
//	 true,//证书不过期为true
//	 true,//账户未锁定为true
//	 entity.getAuthorities());
//	 }

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User entity = new User();
		entity.setLoginName(s);
		User user = userDao.getByLoginName(entity);
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		System.out.println("username:" + user.getLoginName() + ";password:" + user.getPassword());
		user.setUsername(user.getLoginName());
		// return user;
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, // 是否可用
				true, // 是否过期
				true, // 证书不过期为true
				true, // 账户未锁定为true
				user.getAuthorities());
	}
}