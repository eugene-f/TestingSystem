package com.frolov.testing.dao;

import com.frolov.testing.dao.jdbc.JdbcDaoFactory;
import com.frolov.testing.dao.xml.XmlDaoFactory;

import java.util.EnumMap;

public abstract class DaoFactory {

    private static EnumMap<Type, DaoFactory> factories = new EnumMap<>(Type.class);

    static {
        factories.put(Type.Jdbc, JdbcDaoFactory.getInstance());
        factories.put(Type.Xml, XmlDaoFactory.getInstance());
    }

    public static DaoFactory getInstance(Type type) {
        return factories.get(type);
    }

    public abstract <T extends /*JdbcBaseDao*/ Dao> T create(Class<T> daoClass);

    public enum Type {
        Jdbc, Xml
    }

}
