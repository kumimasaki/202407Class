package rp.com.models.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// このクラスがデータベースのテーブルに対応することを示します
@Entity
// 自動的にゲッターやセッターなどを作ってくれる便利なアノテーションです
@Data
// 引数なしのコンストラクタを自動で作ります
@NoArgsConstructor
// 全てのフィールドを引数に持つコンストラクタを自動で作ります
@AllArgsConstructor
// @NonNullとついているフィールドを引数に持つコンストラクタを自動で作ります
@RequiredArgsConstructor
// このクラスが対応するテーブルの名前を指定します
@Table(name = "admin")
public class Admin {

    // これは主キーという特別なIDです
    @Id
    // IDを自動で増やしていく設定です
    @GeneratedValue(strategy = GenerationType.AUTO)
    // テーブルのカラム（列）を指定します
    @Column(name = "admin_id")
    private Long adminId;

    // このフィールドは必ず値が必要です
    @NonNull
    // 名前という列を作り、必ず値が入るようにします
    @Column(name = "admin_name")
    private String adminName;

    // このフィールドは必ず値が必要です
    @NonNull
    // メールアドレスという列を作り、必ず値が入るようにします
    @Column(name = "admin_email")
    private String adminEmail;

    // このフィールドは必ず値が必要です
    @NonNull
    // パスワードという列を作り、必ず値が入るようにします
    @Column(name = "admin_password")
    private String adminPassword;

    // このフィールドは必ず値が必要です
    @NonNull
    // アイコンという列を作り、必ず値が入るようにします
    @Column(name = "admin_icon")
    private String adminIcon;

    // 作成日時という列を作ります。更新はできません
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // アイコンパスを動的に生成するメソッド
    public String getAdminIconPath() {
        return "/uploads/" + adminIcon;
    }
    
    // コンストラクタを追加します
    public Admin(String adminName, String adminEmail, String adminPassword, String adminIcon, String confirmPassword, LocalDateTime createdAt) {
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminIcon = adminIcon;
        this.createdAt = createdAt;
    }
}
