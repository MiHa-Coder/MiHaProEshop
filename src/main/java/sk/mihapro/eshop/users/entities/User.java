package sk.mihapro.eshop.users.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Entity user class, contains users basic details that are stored in database table users.
 * Variable  id is primary key in table. Variable email is unique - there can not be two 
 * identical emails.
 * @author haska
 *
 */
@Entity
@Table(name = "users",
uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private Long id;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
//	@ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
//	@JoinTable(name = "users_roles",
//			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(name= "role_id", referencedColumnName = "id"))
//	List<GrantedAuthority> authorities;

	
	/*
	 * One To One Bidirectional Relationship
	 */
	@OneToOne
	@JoinColumn(name = "user_profile_id", referencedColumnName = "id")
	private UserProfile userProfile; //child
	
	public User() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
}
