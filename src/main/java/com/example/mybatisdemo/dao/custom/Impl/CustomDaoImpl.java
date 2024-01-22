package com.example.mybatisdemo.dao.custom.Impl;

import com.example.mybatisdemo.dao.custom.CustomDao;
import com.example.mybatisdemo.mapper.custom.CustomMapper;
import com.example.mybatisdemo.model.custom.CustomRecord;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.mybatisdemo.entity.custom.CustomDynamicSqlSupport.*;
import static com.example.mybatisdemo.entity.demo.PersonDynamicSqlSupport.person;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@Repository
public class CustomDaoImpl implements CustomDao {

    @Autowired
    CustomMapper customMapper;

    @Override
    public List<CustomRecord> getCustom() {
        SelectStatementProvider selectStatement = select(yearly, className, sex, name, customerId, grade)
                .from(custom)
                .build().render(RenderingStrategies.MYBATIS3);
        return customMapper.selectMany(selectStatement);
    }

}
