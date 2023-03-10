package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.core.utulities.results.DataResult;
import kodlamaio.northwind.entites.concretes.Product;
import kodlamaio.northwind.entites.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {

   // List<Product> getAllByUnitPrice
    Product getByProductName(String productName);
    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
    List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory_CategoryId(String productName,int categoryId);

    @Query("Select new kodlamaio.northwind.entites.dtos.ProductWithCategoryDto" +
            "(p.id,p.productName,c.categoryName) " +
            "From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();

    //select p.product_id,p.product_name, c.category_name,p.unit_price from products p inner join categories c on p.category_id =c.category_id
}
