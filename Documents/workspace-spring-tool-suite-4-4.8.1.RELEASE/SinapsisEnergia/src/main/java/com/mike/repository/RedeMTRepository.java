package com.mike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mike.entity.RedeMT;

@Repository
public interface RedeMTRepository extends JpaRepository<RedeMT, Long> {

}
