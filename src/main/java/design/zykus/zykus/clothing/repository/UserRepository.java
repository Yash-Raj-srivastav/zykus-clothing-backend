package design.zykus.zykus.clothing.repository;

import design.zykus.zykus.clothing.utils.Role;
import design.zykus.zykus.clothing.entities.WebAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<WebAppUser, Integer> {

    Optional<WebAppUser> findByEmail(String userEmail);

    WebAppUser findByRole(Role role);
}