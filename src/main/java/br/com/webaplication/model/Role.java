package br.com.webaplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	@Override
	public String getAuthority() {
		return this.roleName;
	}

}
