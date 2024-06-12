package com.ozguryazilim.telve.boot.ymgkchaos.repository;
import com.ozguryazilim.telve.boot.ymgkchaos.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Integer> {

    List<Projects> findAll();
    Optional <Projects> findById(int id);
}
