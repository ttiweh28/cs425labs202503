package shoppingcart;

import products.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {
	private final List<CartLine> cartLines = new ArrayList<>();

	public void addProduct(Product product) {
		if (product == null) return;

		for (CartLine cartLine : cartLines) {
			if (cartLine.getProduct().getProductNumber().equals(product.getProductNumber())) {
				cartLine.increaseQuantity();
				return;
			}
		}
		cartLines.add(new CartLine(product, 1));
	}

	public void removeProduct(Product product) {
		if (product == null) return;

		Iterator<CartLine> iterator = cartLines.iterator();
		while (iterator.hasNext()) {
			CartLine cartLine = iterator.next();
			if (cartLine.getProduct().getProductNumber().equals(product.getProductNumber())) {
				if (cartLine.getQuantity() > 1) {
					cartLine.decreaseQuantity();
				} else {
					iterator.remove();
				}
				return;
			}
		}
	}

	public void printCart() {
		System.out.println("Shopping Cart Contents:");
		if (cartLines.isEmpty()) {
			System.out.println("Cart is empty.");
			return;
		}

		for (CartLine cartLine : cartLines) {
			Product product = cartLine.getProduct();
			System.out.printf("%d x %s (%s) - $%.2f%n",
					cartLine.getQuantity(),
					product.getDescription(),
					product.getProductNumber(),
					product.getPrice());
		}

		System.out.printf("Total Price: $%.2f%n", calculateTotalPrice());
	}

	public double calculateTotalPrice() {
		return cartLines.stream()
				.mapToDouble(cartLine -> cartLine.getProduct().getPrice() * cartLine.getQuantity())
				.sum();
	}
}
