package com.example.mybatisdemo.mapper.custom;

import com.example.mybatisdemo.model.custom.CustomRecord;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CustomMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<CustomRecord>, CommonUpdateMapper {
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "CustomResult", value = {
            @Result(column = "yearly", property = "yearly", jdbcType = JdbcType.INTEGER),
            @Result(column = "className", property = "className", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sex", property = "sex", jdbcType = JdbcType.INTEGER),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "customerId", property = "customer_id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "grade", property = "grade", jdbcType = JdbcType.VARCHAR)
    })
    List<CustomRecord> selectMany(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("CustomResult")
    Optional<CustomRecord> selectOne(SelectStatementProvider selectStatement);
}
