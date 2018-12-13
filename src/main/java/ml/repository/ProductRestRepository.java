package ml.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ml.checkout.Product;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRestRepository extends PagingAndSortingRepository<Product, Long> {
	
	List<Product> findBySku(@Param("sku") String sku);
	List<Product> findByName(@Param("name") String name);
	List<Product> findByOfferPrice(@Param("offerPrice") double offerPrice);
	@Query(value = "SELECT * FROM PRODUCTS order by UNIT_PRICE ASC", nativeQuery = true)
	List<Product> orderproducts();
	@Query(value = "SELECT * FROM PRODUCTS where unit_price < 20", nativeQuery = true)
	List<Product> findproducts();	
	
}


