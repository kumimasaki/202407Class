package ec.com.models.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import ec.com.models.entity.Admin;
import jakarta.transaction.Transactional;

@SpringBootTest
@Sql(
    {
        "classpath:/ec/com/sql/delete.sql",
        "classpath:/ec/com/sql/insert.sql"
    }
)
@Transactional
public class AdminDaoTest {
	@Autowired
	private AdminDao adminDao;
	
	@Test
	public void test() {
		Admin admin = adminDao.findByAdminEmail("202407@test");
		assertEquals("202407@test", admin.getAdminEmail());
	}
}
