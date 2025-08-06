package blog.com.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * このエンティティクラスは、usersというテーブルを表しています。テーブルのカラムは、以下の通りです。
 * user_id: プライマリーキーとして使用される、ユーザーIDを表すLong型のカラム。
 * user_name: ユーザー名を表す、文字列型のカラム。nullを許容しません。
 * email: メールアドレスを表す、文字列型のカラム。nullを許容しません。
 * password: パスワードを表す、文字列型のカラム。nullを許容しません。
 * register_date: 登録日時を表す、日時型のカラム。nullを許容します。
 * JPAを使用することで、このエンティティクラスはデータベースとのマッピングを簡単に行うことができます。
 * このエンティティクラスのインスタンスをデータベースに保存することができます。
 * さらに、JPAを使用することで、データベースからエンティティクラスのインスタンスを取得することもできます。
 */

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "register_date", nullable = false)
    private LocalDateTime registerDate;

    // --- デフォルトコンストラクタ ---
    public UserEntity() {}

    // --- フルコンストラクタ ---
    public UserEntity(Long userId, String userName, String email, String password, LocalDateTime registerDate) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registerDate = registerDate;
    }

    // --- コンストラクタ（IDなし） ---
    public UserEntity(String userName, String email, String password, LocalDateTime registerDate) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registerDate = registerDate;
    }

    // --- ゲッター & セッター ---
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    // --- toString ---
    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}

