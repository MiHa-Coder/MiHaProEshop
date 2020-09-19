package sk.mihapro.eshop.users.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity for delivery addresses saves street addresses o the users
 * @author haska
 *
 */

@Entity
@Table(name = "delivery_addresses")
public class DeliveryAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, updatable = false)
	private Long id;

	@Column(name = "street_name", nullable = false)
	private String streetName;

	@Column(name = "post_code", nullable = false)
	private String postCode;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "country", nullable = false)
	private String country;

	/*
	 * One To One Bidirectional Relationship
	 */
	@OneToOne(mappedBy = "deliveryAddress")
	private UserProfile userProfile; // parrent
	
	public DeliveryAddress() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
