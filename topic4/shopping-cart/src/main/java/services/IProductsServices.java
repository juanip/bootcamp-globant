package services;

import java.util.List;

import entities.Product;

public interface IProductsServices {

	public abstract List<Product> getProducts();

	public abstract Product getProduct(long id);

	public abstract Product addProduct(Product product);

}