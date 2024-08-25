package com.veljko121.backend.repository;


import com.veljko121.backend.model.ExhibitionProposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExhibitionProposalRepository extends JpaRepository<ExhibitionProposal, Integer> {
    @Query("SELECT ep FROM ExhibitionProposal ep WHERE ep.organizer.id = :organizerId AND ep.id NOT IN (SELECT e.exhibitionProposal.id FROM Exhibition e)")
    List<ExhibitionProposal> findUnlinkedProposalsByOrganizerId(@Param("organizerId") Integer organizerId);
}
