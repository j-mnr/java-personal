package com.circuitcommerce.project2.repository;

import java.util.List;

import com.circuitcommerce.project2.dto.ProductShortDto;
import com.circuitcommerce.project2.model.Product;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  public Product findByProductId(Long productId);

  public static final String FIND_BY_BRAND = "SELECT new com.circuitcommerce.project2.dto.ProductShortDto(p.productId,p.abbreviatedTitle, p.brand, p.price, p.modelNumber) FROM Product p WHERE p.brand = ?1";

  @Query(value = FIND_BY_BRAND)
  public List<ProductShortDto> findByBrand(String brand);

  public static final String FIND_BY_PRICE = "SELECT new com.circuitcommerce.project2.dto.ProductShortDto(p.productId,p.abbreviatedTitle, p.brand, p.price, p.modelNumber) FROM Product p WHERE p.price = ?1";

  @Query(value = FIND_BY_PRICE)
  public List<ProductShortDto> findByPrice(double price);

  public static final String FIND_BY_PRICE_BETWEEN = "SELECT new com.circuitcommerce.project2.dto.ProductShortDto(p.productId,p.abbreviatedTitle, p.brand, p.price, p.modelNumber) FROM Product p WHERE p.price > ?1 OR p.price < ?2";

  @Query(value = FIND_BY_PRICE)
  public List<ProductShortDto> findByPriceBetween(double low, double high);

  public static final String FIND_BY_PRICE_LESS_THAN = "SELECT new com.circuitcommerce.project2.dto.ProductShortDto(p.productId,p.abbreviatedTitle, p.brand, p.price, p.modelNumber) FROM Product p WHERE p.price < ?1";

  @Query(value = FIND_BY_PRICE_LESS_THAN)
  public List<ProductShortDto> findByPriceLessThan(double price);

  public static final String FIND_BY_PRICE_LESS_THAN_EQUAL = "SELECT new com.circuitcommerce.project2.dto.ProductShortDto(p.productId,p.abbreviatedTitle, p.brand, p.price, p.modelNumber) FROM Product p WHERE p.price < ?1 OR p.price = ?1";

  @Query(value = FIND_BY_PRICE_LESS_THAN_EQUAL)
  public List<ProductShortDto> findByPriceLessThanEqual(double price);

  public static final String FIND_BY_PRICE_GREATER_THAN = "SELECT new com.circuitcommerce.project2.dto.ProductShortDto(p.productId,p.abbreviatedTitle, p.brand, p.price, p.modelNumber) FROM Product p WHERE p.price > ?1";

  @Query(value = FIND_BY_PRICE_GREATER_THAN)
  public List<ProductShortDto> findByPriceGreaterThan(double price);

  public static final String FIND_BY_PRICE_GREATER_THAN_EQUAL = "SELECT new com.circuitcommerce.project2.dto.ProductShortDto(p.productId,p.abbreviatedTitle, p.brand, p.price, p.modelNumber) FROM Product p WHERE p.price > ?1 OR p.price = ?1";

  @Query(value = FIND_BY_PRICE_GREATER_THAN_EQUAL)
  public List<ProductShortDto> findByPriceGreaterThanEqual(double price);

  public static final String FIND_PRODUCTS = "SELECT new com.circuitcommerce.project2.dto.ProductShortDto(p.productId,p.abbreviatedTitle, p.brand, p.price, p.modelNumber) FROM Product p";

  @Query(value = FIND_PRODUCTS)
  public List<ProductShortDto> productsSmall();

}
