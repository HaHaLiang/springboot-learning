package com.example.repository;
import com.example.entity.TitlesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**

 */

@Repository
public interface TitlesDao extends JpaRepository<TitlesEntity, Long> {

}