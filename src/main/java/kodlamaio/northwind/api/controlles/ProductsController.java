package kodlamaio.northwind.api.controlles;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utulities.results.DataResult;
import kodlamaio.northwind.core.utulities.results.Result;
import kodlamaio.northwind.entites.concretes.Product;
import kodlamaio.northwind.entites.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
//hangi adreste yayınlayacağı==| /api/product adresine istek geldiğinde bu istegi
  //--ProductsController karşılayacak
public class ProductsController {

    private ProductService productService;
    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")//path - yol
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")

    public DataResult<Product> getByProductNameAndCategoryId
            (@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }
    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }
    @GetMapping("/getAllByPage")//2
    DataResult<List<Product>>  getAll(int pageNo,int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }
    @GetMapping("/getAllDesc")//3
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }
}
