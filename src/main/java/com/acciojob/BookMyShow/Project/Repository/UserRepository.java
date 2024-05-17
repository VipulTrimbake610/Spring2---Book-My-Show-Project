package com.acciojob.BookMyShow.Project.Repository;

import com.acciojob.BookMyShow.Project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
