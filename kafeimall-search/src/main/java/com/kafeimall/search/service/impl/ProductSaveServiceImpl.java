package com.kafeimall.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.kafeimall.search.config.ElasticSearchConfig;
import com.kafeimall.search.constant.EsConstant;
import com.kafeimall.search.model.SkuEsModel;
import com.kafeimall.search.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zzg
 * @date: 2022/12/4
 * @Description: zzg
 */
@Service
@Slf4j
public class ProductSaveServiceImpl implements ProductSaveService {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Override
    public boolean productStatusUp(List<SkuEsModel> skuEsModelList) throws IOException {

        //保存到es中
        //1、给es建立索引。product，建立好映射关系

        //2、给es中保存这些数据
        //BulkRequest bulkRequest, RequestOptions options
        BulkRequest bulkRequest = new BulkRequest();

        for (SkuEsModel esModel : skuEsModelList) {
            //1、构造保存请求
            IndexRequest indexRequest = new IndexRequest(EsConstant.PRODUCT_INDEX);
            indexRequest.id(esModel.getSkuId().toString());
            String s = JSON.toJSONString(esModel);
            indexRequest.source(s, XContentType.JSON);
            bulkRequest.add(indexRequest);
        }


        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, ElasticSearchConfig.COMMON_OPTIONS);

        //TODO 如果批量错误
        boolean b = bulk.hasFailures();
        List<String> collect = Arrays.stream(bulk.getItems()).map(item -> {
            return item.getId();
        }).collect(Collectors.toList());

        log.info("商品上架完成:{}，返回数据:{}", collect,bulk.toString());
        return b;
    }
}
