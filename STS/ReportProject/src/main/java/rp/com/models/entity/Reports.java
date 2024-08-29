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

//このクラスがデータベースのテーブルに対応することを示します
@Entity
//自動的にゲッターやセッターなどを作ってくれる便利なアノテーションです
@Data
//引数なしのコンストラクタを自動で作ります
@NoArgsConstructor
//全てのフィールドを引数に持つコンストラクタを自動で作ります
@AllArgsConstructor
//@NonNullとついているフィールドを引数に持つコンストラクタを自動で作ります
@RequiredArgsConstructor
//このクラスが対応するテーブルの名前を指定します
@Table(name = "reports")
public class Reports {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reportId;
	@NonNull
	private String reportTitle;
	private String reportFileName;
	@NonNull
	private String contentsOfReport;
	private LocalDateTime createdAt;
	@NonNull
	private Long adminId;
	@NonNull
	private Long userId;
	private int deleteFlg = 0;
	private int receiptFlg = 0;

	public Reports(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
