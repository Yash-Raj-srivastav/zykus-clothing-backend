package design.zykus.zykus.clothing.DAO;

import design.zykus.zykus.clothing.Entity.WebAppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<WebAppUser, Integer> {

}