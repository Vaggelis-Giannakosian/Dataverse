package com.dataverse.demo.repository;

import com.dataverse.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {




    User findUserByUserEmailIsAndAndUserPasswordIs(String email, String password);
    User findUserByUserEmail(String email);
    User findUserByUserId(Long id);

}
