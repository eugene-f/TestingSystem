package com.frolov.testing.dao;

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
            throw new DaoException("Невозможно создать DAO для класса", e);
        }
        return dao;
    }

    @Override
    public <T extends JdbcBaseDao> T create(Class<T> daoClass) {
        return null;
    }

}
