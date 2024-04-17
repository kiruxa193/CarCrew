package ru.carcrew.boot.version_20.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.carcrew.boot.version_20.models.User;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
}
