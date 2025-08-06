package blog.com.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * このエンティティクラスは、blogsというテーブルを表しています。テーブルのカラムは、以下の通りです。
 * JPAを使用することで、このエンティティクラスはデータベースとのマッピングを簡単に行うことができます。
 * このエンティティクラスのインスタンスをデータベースに保存することができます。
 * さらに、JPAを使用することで、データベースからエンティティクラスのインスタンスを取得することもできます。
 */

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "blogs")
public class BlogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "blog_id")
    private Long blogId;

    @Column(name = "blog_title", nullable = false)
    private String blogTitle;

    @Column(name = "register_date", nullable = false)
    private LocalDate registerDate;

    @Column(name = "blog_image", nullable = false)
    private String blogImage;

    @Column(name = "blog_detail", nullable = false)
    private String blogDetail;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "view_count")
    private Long viewCount;

    // --- デフォルトコンストラクタ ---
    public BlogEntity() {}

    // --- 引数ありコンストラクタ ---
    public BlogEntity(String blogTitle, LocalDate registerDate, String blogImage,
                      String blogDetail, String category, Long userId, Long viewCount) {
        this.blogTitle = blogTitle;
        this.registerDate = registerDate;
        this.blogImage = blogImage;
        this.blogDetail = blogDetail;
        this.category = category;
        this.userId = userId;
        this.viewCount = viewCount;
    }

    // --- ゲッター & セッター ---
    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public String getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
    }

    public String getBlogDetail() {
        return blogDetail;
    }

    public void setBlogDetail(String blogDetail) {
        this.blogDetail = blogDetail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    // --- toString ---
    @Override
    public String toString() {
        return "BlogEntity{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", registerDate=" + registerDate +
                ", blogImage='" + blogImage + '\'' +
                ", blogDetail='" + blogDetail + '\'' +
                ", category='" + category + '\'' +
                ", userId=" + userId +
                ", viewCount=" + viewCount +
                '}';
    }
}

