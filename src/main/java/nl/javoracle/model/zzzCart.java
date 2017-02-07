package nl.javoracle.model;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class zzzCart {
	
	@Id
	@GeneratedValue
	private Long cartId;
	
	private int shoppingCartSize;
	
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public int getShoppingCartSize() {
		return shoppingCartSize;
	}

	public void setShoppingCartSize(int shoppingCartSize) {
		this.shoppingCartSize = shoppingCartSize;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	@Temporal(TemporalType.DATE)
	private Date create;
	
}
