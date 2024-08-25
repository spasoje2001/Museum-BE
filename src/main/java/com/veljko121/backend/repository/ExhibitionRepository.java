package com.veljko121.backend.repository;

import com.veljko121.backend.model.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Integer> {
    List<Exhibition> findByExhibitionProposalOrganizerId(Integer organizerId);
}
