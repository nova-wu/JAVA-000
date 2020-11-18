package com.github.novawu.springsample.jdbc.handler;

import java.sql.ResultSet;

public interface ResultHandler<T> {

    T handler(ResultSet set) throws Exception;
}
