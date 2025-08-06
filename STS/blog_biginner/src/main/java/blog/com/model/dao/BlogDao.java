package blog.com.model.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.com.model.entity.BlogEntity;
import jakarta.transaction.Transactional;

public interface BlogDao extends JpaRepository<BlogEntity, Long> {

	List<BlogEntity> findByUserId(Long userId);
	
	List<BlogEntity> findByUserIdAndBlogTitle(Long userId, String blogTitle);
	
	BlogEntity save(BlogEntity blogEntity);

	BlogEntity findByBlogTitleAndRegisterDate(String blogTitle,LocalDate registerDate);

	BlogEntity findByBlogId(Long blogId);

	@Transactional
    List<BlogEntity> deleteByBlogId(Long blogId);
}
