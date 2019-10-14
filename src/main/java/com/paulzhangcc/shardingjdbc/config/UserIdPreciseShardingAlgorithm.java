package com.paulzhangcc.shardingjdbc.config;


import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

public class UserIdPreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> userIdShardingValue) {
        for (String tableName : availableTargetNames) {
            if (tableName.endsWith(Math.abs(userIdShardingValue.getValue().hashCode()) % 2 + "")) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }
}

