package com.veljko121.backend.repository;

import com.veljko121.backend.model.ExhibitionSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ExhibitionSearchRepository extends ElasticsearchRepository<ExhibitionSearch, String> {
}
