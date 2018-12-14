package ml.repository;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ml.checkout.Category;



@RepositoryRestResource(collectionResourceRel = "category", path = "category",exported=true)
public interface CategoryRestRepository extends PagingAndSortingRepository<Category, Long> {	
	

	List<Category> findByCategoryName(@Param("categoryName") String categoryName);
	
	
}


// This is the payload with postman
/*{"categoryName": "New Category",
"categoryDescription":"Description of new category",
"products":	[{"sku":"1", "name":"Laptop Super","unitPrice":1800,"isOnOffer":true,"quantityOnOffer":23,"offerPrice":454.0},
{"sku":"2", "name":"Phone 8","unitPrice":800,"isOnOffer":true,"quantityOnOffer":23,"offerPrice":454.0},
{"sku":"3", "name":"Super teaser","unitPrice":200,"isOnOffer":true,"quantityOnOffer":23,"offerPrice":454.0},
{"sku":"4", "name":"Phon 10","unitPrice":290,"isOnOffer":true,"quantityOnOffer":23,"offerPrice":454.0}]}*/