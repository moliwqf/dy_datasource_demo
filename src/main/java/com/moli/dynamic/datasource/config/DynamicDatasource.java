package com.moli.dynamic.datasource.config;


import com.moli.dynamic.datasource.context.DynamicDatasourceHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author moli
 * @time 2024-07-19 21:42:03
 * @description 手动实现动态数据源
 */
public class DynamicDatasource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDatasourceHolder.getDatasource();
    }
}
