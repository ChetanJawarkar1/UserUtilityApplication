package com.cj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cj.dto.User;


@Repository
public interface UserDaoInterface extends JpaRepository<User, Long>  {

}
