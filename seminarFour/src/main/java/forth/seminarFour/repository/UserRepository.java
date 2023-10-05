package forth.seminarFour.repository;

import forth.seminarFour.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByUserEmail(String userEmail);
    boolean existsByUserEmailAndUserPassword(String userEmail, String userPassword);
}
