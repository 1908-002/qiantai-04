package com.lkc.Repository;

import com.lkc.model.OrderDetailEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsRepository  extends ElasticsearchRepository<OrderDetailEntity,Integer> {
}
