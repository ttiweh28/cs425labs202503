package shoppingcart;

import products.Product;

public class CartLine {
	private int quantity;
	private Product product;

	public CartLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void increaseQuantity() {
		this.quantity++;
	}

	public void decreaseQuantity() {
		this.quantity--;
	}
}
