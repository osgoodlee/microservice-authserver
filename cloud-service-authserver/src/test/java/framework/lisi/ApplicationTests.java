package framework.lisi;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import framework.lisi.dao.UserDao;
import framework.lisi.entity.User;


/** 
* @author lisi
* @since 2017年5月2日 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AuthServerApplication.class)
public class ApplicationTests {
	@Autowired
	private UserDao userDao;
	
	@Test
	@Rollback
	public void findByName() throws Exception {
		List<User> uList = userDao.findAll();
		uList.parallelStream().forEach(p->{
			System.out.println(p.getName());
		});
//		System.out.println(uList.size());
		Assert.assertTrue(uList.size()>0);
	}
}