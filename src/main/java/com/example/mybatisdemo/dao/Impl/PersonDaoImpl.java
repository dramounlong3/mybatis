package com.example.mybatisdemo.dao.Impl;

import com.example.mybatisdemo.dao.PersonDao;
import com.example.mybatisdemo.mapper.PersonMapper;
import com.example.mybatisdemo.model.PersonRecord;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.mybatisdemo.entity.PersonDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    PersonMapper personMapper;

    @Override
    public List<PersonRecord> getPerson() {
        SelectStatementProvider selectStatement = select(id.as("A_ID"), firstName, lastName, birthDate, employed, occupation, addressId)
                .from(person)
                .build().render(RenderingStrategies.MYBATIS3);

        return personMapper.selectMany(selectStatement);
    }

}
