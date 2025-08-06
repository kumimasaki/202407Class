package ec.com.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @Column(nullable = false)
    private String adminName;

    @Column(nullable = false, unique = true)
    private String adminEmail;

    @Column(nullable = false)
    private String password;

	/**
	 * @param adminName
	 * @param adminEmail
	 * @param password
	 */
	public Admin(String adminName, String adminEmail, String password) {
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.password = password;
	}
    
    

}