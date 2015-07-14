package com.frolov.testing.dao.jdbc;

import com.frolov.testing.entity.BaseEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface JdbcMapper<T extends BaseEntity> {

    PreparedStatement mapToStatement(T entity, PreparedStatement statement);

    T mapToEntity(ResultSet set);

    default List<T> mapToEntityList(ResultSet set) throws SQLException {

        List<T> list = new ArrayList<>();

//        while (set.next()) { // fixme: double set iteration
////            set.previous();
//            list.add(mapToEntity(set));
//        }

        T entity = null;
        entity = mapToEntity(set);
        if (entity == null) {
            return null;
        } else {
            while (entity != null) {
                list.add(entity);
                entity = mapToEntity(set);
            }
            return list;
        }

    }

}
