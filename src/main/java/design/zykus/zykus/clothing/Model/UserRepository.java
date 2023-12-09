package design.zykus.zykus.clothing.Model;

import design.zykus.zykus.clothing.Entity.WebAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<WebAppUser, Integer> {

}