package com.lkc;

import com.lkc.Repository.EsRepository;
import com.lkc.model.OrderDetailEntity;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ConsumerFeignApplicationTests {

    @Resource
    private EsRepository esRepository;

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void all(){
        Iterable<OrderDetailEntity> all = esRepository.findAll();
        for (OrderDetailEntity al:
                all) {
            System.out.println(al);
        }
    }

    @Test
    public void  add (){
        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setId(1);
        entity.setOrder_id(1);
        entity.setUser_id(1);
        entity.setSku_id(1);
        entity.setSku_name("耐克休闲鞋");
        entity.setOrder_price(355.99);
        entity.setSku_num(1);
        entity.setCreate_time("2020-06-07");
        entity.setOrderstatus(1);
        entity.setMiaosu("sdadsa");
        entity.setImgpath("1");
        entity.setShifukuan(5564.99);
        entity.setShangPinType(1);
        esRepository.save(entity);
    }


    @Test
    public  void listee(){
        // 获取ES操作的客户端
        Client client = elasticsearchTemplate.getClient();
        // 定义查询对象，指定索引名称和类型名称，也可以定义query查询
        SearchRequestBuilder searchRequestBuilder = client
                .prepareSearch("1908_order_index")
                .setTypes("1908_order_type")
                .setQuery(QueryBuilders.matchQuery("sku_name", "耐克休闲"));


        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("sku_name");
        searchRequestBuilder.highlighter(highlightBuilder);
        // 获取查询返回的对象
        SearchResponse searchResponse = searchRequestBuilder.get();
        // 通过SearchResponse对象获取命中的结果集
        SearchHits hits = searchResponse.getHits();
        // 命中的结果集获取iterator迭代器
        Iterator<SearchHit> iterator = hits.iterator();
        List<OrderDetailEntity> lieList = new ArrayList<>();
        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            Map<String, Object> sourceAsMap = next.getSourceAsMap();
            OrderDetailEntity lieBiao = new OrderDetailEntity();
            lieBiao.setId(Integer.valueOf(sourceAsMap.get("id").toString()));
            lieBiao.setOrder_id(Integer.valueOf(sourceAsMap.get("order_id").toString()));
            lieBiao.setUser_id(Integer.valueOf(sourceAsMap.get("user_id").toString()));
            lieBiao.setSku_id(Integer.valueOf(sourceAsMap.get("sku_id").toString()));


            Map<String, HighlightField> highlightFields = next.getHighlightFields();
            HighlightField field = highlightFields.get("sku_name");


            lieBiao.setSku_name(field.getFragments()[0].toString());

            //lieBiao.setOrder_price(Double.valueOf(sourceAsMap.get("order_price").toString()));
            lieBiao.setSku_num(Integer.valueOf(sourceAsMap.get("sku_num").toString()));
            lieBiao.setCreate_time(sourceAsMap.get("create_time").toString());
            lieBiao.setOrderstatus(Integer.valueOf(sourceAsMap.get("orderstatus").toString()));
            lieBiao.setMiaosu(sourceAsMap.get("miaosu").toString());
            lieBiao.setImgpath(sourceAsMap.get("imgpath").toString());
          //  lieBiao.setShifukuan(Double.valueOf(sourceAsMap.get("shifukuan").toString()));
            lieBiao.setShangPinType(Integer.valueOf(sourceAsMap.get("shangPinType").toString()));
            lieList.add(lieBiao);
        }
        System.out.println(lieList);
    }

    @Test
    void contextLoads() {
    }

}
