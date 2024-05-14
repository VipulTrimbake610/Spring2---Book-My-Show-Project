package com.acciojob.BookMyShow.Project.Repository;

import com.acciojob.BookMyShow.Project.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {
}
