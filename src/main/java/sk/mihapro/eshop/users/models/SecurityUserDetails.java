package sk.mihapro.eshop.users.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import sk.mihapro.eshop.users.entities.User;
/**
 * todo: refactor hardcoded methods
 * 
 * User details needed for security api
 * @see UserDetails
 * @author haska
 *
 */
public class SecurityUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private boolean enabled;
	private List<GrantedAuthority> authorities;

	public SecurityUserDetails() {
	}

	/*
	 * Setting variables with user values from database
	 */
	public SecurityUserDetails(User user) {
		this.username = user.getEmail();
		System.out.println(this.username);

		this.password = user.getPassword();
		System.out.println(this.password);

		this.enabled = user.isEnabled();
		System.out.println(this.enabled);

		/*
		 * todo: refactor
		 */
		this.authorities = Arrays.stream(user.getAuthorities().getAuthority().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		System.out.println(this.authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
