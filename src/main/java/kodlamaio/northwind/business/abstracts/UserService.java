package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utulities.results.DataResult;
import kodlamaio.northwind.core.utulities.results.Result;

import java.util.List;
//servis katmanın soyut tarafı

public interface UserService {

    DataResult<List<User>>  getAll();
    Result add(User user);
    DataResult<User> findByEmail(String email);

}
