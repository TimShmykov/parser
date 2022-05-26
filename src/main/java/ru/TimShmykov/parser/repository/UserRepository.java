package ru.TimShmykov.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.TimShmykov.parser.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // boolean existByUsername(String username);
    List<User> getUserById(Long id);

    Optional<User> findByUsername(String username);

}
