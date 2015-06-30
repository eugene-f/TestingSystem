package com.frolov.testing.dao;

import com.frolov.testing.dao.jdbc.JdbcDaoFactory;
import com.frolov.testing.dao.xml.XmlDaoFactory;

import java.util.EnumMap;

public abstract class DaoFactory {

    private static final EnumMap<Type, DaoFactory> FACTORIES = new EnumMap<>(Type.class);

    public enum Type {
        Jdbc, Xml
    }

    static {
        FACTORIES.put(Type.Jdbc, JdbcDaoFactory.getInstance());
        FACTORIES.put(Type.Xml, XmlDaoFactory.getInstance());
    }

    public static DaoFactory getInstance(Type type) {
        return FACTORIES.get(type);
    }

    public abstract <T extends Dao> T create(Class<T> daoClass);

}
