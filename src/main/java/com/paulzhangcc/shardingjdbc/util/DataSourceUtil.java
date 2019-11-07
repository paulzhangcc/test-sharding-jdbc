package com.paulzhangcc.shardingjdbc.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author paul
 * @description
 * @date 2019/11/7
 */
public class DataSourceUtil {
    public static DataSource dataSource() throws SQLException {
        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        DruidDataSource dataSource1 = new DruidDataSource();
        dataSource1.setUrl("jdbc:mysql://123.56.0.93:3306/ds0?useUnicode=true&characterEncoding=utf-8&useSSL=false&useAffectedRows=true&allowMultiQueries=true");
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUsername("root");
        dataSource1.setPassword("paul6329170!@#");
        // 配置第一个数据源
        dataSourceMap.put("ds0", dataSource1);

        // 配置第二个数据源
        DruidDataSource dataSource2 = new DruidDataSource();
        dataSource2.setUrl("jdbc:mysql://123.56.0.93:3306/ds1?useUnicode=true&characterEncoding=utf-8&useSSL=false&useAffectedRows=true&allowMultiQueries=true");
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setUsername("root");
        dataSource2.setPassword("paul6329170!@#");
        dataSourceMap.put("ds1", dataSource2);

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.setDefaultDataSourceName("ds0");
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        shardingRuleConfig.getTableRuleConfigs().add(getOrderItemTableRuleConfiguration());
        shardingRuleConfig.getBindingTableGroups().add("t_order, t_order_item");
        shardingRuleConfig.getBroadcastTables().add("t_config");
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", new PreciseModuloShardingDatabaseAlgorithm()));
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("order_id", new PreciseModuloShardingTableAlgorithm()));

        Properties properties = new Properties();
        properties.put("sql.show", "true");
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, properties);
    }

    private static KeyGeneratorConfiguration getKeyGeneratorConfiguration() {
        KeyGeneratorConfiguration result = new KeyGeneratorConfiguration("SNOWFLAKE", "order_id");
        return result;
    }

    private static TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("t_order", "ds${0..1}.t_order${0..1}");
        result.setKeyGeneratorConfig(getKeyGeneratorConfiguration());
        return result;
    }

    private static TableRuleConfiguration getOrderItemTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("t_order_item", "ds${0..1}.t_order_item${0..1}");
        return result;
    }

    public static final class PreciseModuloShardingTableAlgorithm implements PreciseShardingAlgorithm<Long> {

        @Override
        public String doSharding(final Collection<String> tableNames, final PreciseShardingValue<Long> shardingValue) {
            for (String each : tableNames) {
                if (each.endsWith(shardingValue.getValue() % 2 + "")) {
                    return each;
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    public static final class PreciseModuloShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<Integer> {

        @Override
        public String doSharding(final Collection<String> databaseNames, final PreciseShardingValue<Integer> shardingValue) {
            for (String each : databaseNames) {
                if (each.endsWith(shardingValue.getValue() % 2 + "")) {
                    return each;
                }
            }
            throw new UnsupportedOperationException();
        }
    }

}