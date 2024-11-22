package com.thalesmonteiro.user_service.user_service.repository;

import com.thalesmonteiro.user_service.user_service.model.Username;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Username, Long> {

}
