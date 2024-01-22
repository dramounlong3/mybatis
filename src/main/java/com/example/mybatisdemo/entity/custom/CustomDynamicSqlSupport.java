package com.example.mybatisdemo.entity.custom;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public class CustomDynamicSqlSupport {
    public static final CustomDynamicSqlSupport.Custom custom = new CustomDynamicSqlSupport.Custom();
    public static final SqlColumn<Integer> yearly = custom.yearly;
    public static final SqlColumn<String> className = custom.className;
    public static final SqlColumn<Integer> sex = custom.sex;
    public static final SqlColumn<String> name = custom.name;
    public static final SqlColumn<String> customerId = custom.customerId;
    public static final SqlColumn<String> grade = custom.grade;

    public static final class Custom extends SqlTable {
        public final SqlColumn<Integer> yearly = column("yearly", JDBCType.INTEGER);
        public final SqlColumn<String> className = column("className", JDBCType.VARCHAR);
        public final SqlColumn<Integer> sex = column("sex", JDBCType.INTEGER);
        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);
        public final SqlColumn<String> customerId = column("customer_id", JDBCType.VARCHAR);
        public final SqlColumn<String> grade = column("grade", JDBCType.VARCHAR);

        public Custom() {
            super("ACPB47M");
        } //table name
    }
}
