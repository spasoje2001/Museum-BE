package com.veljko121.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.veljko121.backend.model.Curator;
public interface CuratorRepository extends JpaRepository<Curator, Integer> {}
