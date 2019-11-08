package com.paulzhangcc.shardingjdbc.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.NoneShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

/**
 * @author paul
 * @description
 * @date 2019/11/7
 */
public class DataSourceUtil {

    public enum Databases {
        ds0, ds1
    }

    public static DataSource dataSource() throws SQLException {
        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        DruidDataSource dataSource1 = new DruidDataSource();
        dataSource1.setUrl("jdbc:mysql://123.56.0.93:3306/ds0?useUnicode=true&characterEncoding=utf-8&useSSL=false&useAffectedRows=true&allowMultiQueries=true");
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUsername("root");
        dataSource1.setPassword("paul6329170!@#");
        // 配置第一个数据源
        dataSourceMap.put(Databases.ds0.name(), dataSource1);

        // 配置第二个数据源
        DruidDataSource dataSource2 = new DruidDataSource();
        dataSource2.setUrl("jdbc:mysql://123.56.0.93:3306/ds1?useUnicode=true&characterEncoding=utf-8&useSSL=false&useAffectedRows=true&allowMultiQueries=true");
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setUsername("root");
        dataSource2.setPassword("paul6329170!@#");
        dataSourceMap.put(Databases.ds1.name(), dataSource2);

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        //对于没有配置TableRule的表使用ds0库
        shardingRuleConfig.setDefaultDataSourceName(Databases.ds0.name());
        //对于t_user没有分库和分表可以使用setDefaultDataSourceName或者getUserTableRuleConfiguration
        //shardingRuleConfig.getTableRuleConfigs().add(getUserTableRuleConfiguration());
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        shardingRuleConfig.getTableRuleConfigs().add(getOrderItemTableRuleConfiguration());
        shardingRuleConfig.getTableRuleConfigs().add(getUserLoginLogTableRuleConfiguration());
        //加入绑定表，防止出现笛卡尔积
        shardingRuleConfig.getBindingTableGroups().add("t_order, t_order_item");
        //对于t_config使用需要数据同步
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

    /**
     * t_order 分库分表
     *
     * @return
     */
    private static TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("t_order", "ds${0..1}.t_order${0..1}");
        result.setKeyGeneratorConfig(getKeyGeneratorConfiguration());
        return result;
    }


    /**
     * t_user 单库单表
     *
     * @return
     */
    private static TableRuleConfiguration getUserTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("t_user", "ds0.t_user");
        result.setDatabaseShardingStrategyConfig(new NoneShardingStrategyConfiguration());
        result.setTableShardingStrategyConfig(new NoneShardingStrategyConfiguration());
        return result;
    }

    /**
     * t_order 分库分表
     *
     * @return
     */
    private static TableRuleConfiguration getOrderItemTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("t_order_item", "ds${0..1}.t_order_item${0..1}");
        return result;
    }


    /**
     * t_user_login_log 单库ds0分多表
     *
     * @return
     */
    private static TableRuleConfiguration getUserLoginLogTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("t_user_login_log", "ds0.t_user_login_log_0,ds0.t_user_login_log_1");
        result.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", new SingleShardingDatabaseAlgorithm()));
        result.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", new PreciseModuloShardingTableAlgorithm()));
        return result;
    }

    public static final class PreciseModuloShardingTableAlgorithm implements PreciseShardingAlgorithm<String> {

        @Override
        public String doSharding(final Collection<String> tableNames, final PreciseShardingValue<String> shardingValue) {
            for (String each : tableNames) {
                if (each.endsWith(getLast1Char(shardingValue.getValue()) % 2 + "")) {
                    return each;
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    public static final class SingleShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<String> {

        @Override
        public String doSharding(final Collection<String> databaseNames, final PreciseShardingValue<String> shardingValue) {
            if (databaseNames.size() == 1) {
                return new ArrayList<String>(databaseNames).get(0);
            }
            throw new UnsupportedOperationException();
        }
    }


    public static final class PreciseModuloShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<String> {

        @Override
        public String doSharding(final Collection<String> databaseNames, final PreciseShardingValue<String> shardingValue) {
            for (String each : databaseNames) {
                if (each.endsWith(getLast1Char(shardingValue.getValue()) % 2 + "")) {
                    return each;
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    public static int getLast1Char(String s) {
        String substring = s.substring(s.length() - 1, s.length());
        return Integer.parseInt(substring);
    }

}