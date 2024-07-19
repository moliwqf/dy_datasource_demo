package com.moli.dynamic.datasource.context;

/**
 * @author moli
 * @time 2024-07-19 21:44:18
 * @description 动态数据源设置
 */
public class DynamicDatasourceHolder {

    private static final ThreadLocal<String> DATA_SOURCE = new ThreadLocal<>();

    public static String getDatasource() {
        return DATA_SOURCE.get();
    }

    public static void setDataSource(String dataSource) {
        DATA_SOURCE.set(dataSource);
    }

    public static void removeDatasource() {
        DATA_SOURCE.remove();
    }
}
