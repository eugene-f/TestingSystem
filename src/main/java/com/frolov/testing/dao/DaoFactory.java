package com.frolov.testing.dao;

import com.frolov.testing.dao.xml.XmlDaoFactory;

import java.util.EnumMap;

public abstract class DaoFactory {

    private static DaoFactory instance;

    static EnumMap<Type, DaoFactory> factories = new EnumMap<Type, DaoFactory>(Type.class);

    static {
        factories.put(Type.Jdbc, JdbcDaoFactory.getInstance());
        factories.put(Type.Xml, XmlDaoFactory.getInstance());
    }

    public static DaoFactory getInstance(Type type) {
/*        switch (type) {
            case Jdbc: return JdbcDaoFactory.getInstance();
            case Xml: return XmlDaoFactory.getInstance();
        }
        return instance;*/
        return factories.get(type);
    }

    private enum Type {
        Jdbc, Xml
    }

    public abstract  <T extends JdbcBaseDao> T create(Class<T> aClass);

}
