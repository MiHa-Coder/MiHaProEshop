package sk.mihapro.eshop.users.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

/**
 * Entity roles class overrides getAuthority() method from GrantedAuthority. 
 * getAuthority() returns role that is saved in database table roles
 * @author haska
 *
 */

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private Long id;

	@Column(name = "role", unique = true)
	private String role;
	
	/*
	 * One To One Bidirectional Relationship
	 */
	@OneToOne(mappedBy = "authorities")
	private User user; //parrent
	
	public Role() {
	}

	@Override
	@Transient
	public String getAuthority() {
		return this.role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
