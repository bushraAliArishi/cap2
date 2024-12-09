package com.example.medicalherbs.Repository;

import com.example.medicalherbs.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);
    User findUserById(Integer id);

    @Query("SELECT u FROM User u WHERE u.role = ?1")
    List<User> findByRole(String role);
}
