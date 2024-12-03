package com.zaid.basepackage.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zaid.basepackage.request.UserRequest;
@Repository
public interface UserRepo extends JpaRepository<UserRequest, Integer	> {

}
