package com.frolov.testing.dao.xml;

import com.frolov.testing.dao.interfaces.Dao;
import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.DaoFactory;

public class XmlDaoFactory extends DaoFactory {

    private static final XmlDaoFactory instance = new XmlDaoFactory();

    private XmlDaoFactory() {
    }

    public static XmlDaoFactory getInstance() {
        return instance;
    }

    public <T extends XmlBaseDao> T createXmlDao(Class<T> daoClass) {
        T dao;
        try {
            dao = daoClass.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
        } catch (Exception e) {
            throw new DaoException("���������� ������� DAO ��� ������", e);
        }
        return dao;
    }

    @Override
    public <T extends /*JdbcBaseDao*/ Dao> T create(Class<T> daoClass) {
        return null;
    }

//    @Override
//    public <T extends Dao> T create(Class<T> daoClass) {
//        return null;
//    }

}
