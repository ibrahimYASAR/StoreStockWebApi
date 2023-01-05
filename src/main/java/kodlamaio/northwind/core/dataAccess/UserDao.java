package kodlamaio.northwind.core.dataAccess;

import kodlamaio.northwind.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//dao, repository, dto, data access katmanı
@Repository
public interface UserDao extends JpaRepository<User,Integer>{
    User findByEmail(String email);
}
