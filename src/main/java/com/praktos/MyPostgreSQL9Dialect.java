package com.praktos;

import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;

public class MyPostgreSQL9Dialect extends PostgreSQL9Dialect {
    public MyPostgreSQL9Dialect(){
        super();
        registerFunction("search", new StandardSQLFunction("search"));
    }
}
