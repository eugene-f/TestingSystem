package com.frolov.testing.dao.xml;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.TestDao;
import com.frolov.testing.entity.test.Test;

public class XmlTestDao extends XmlBaseDao<Test> implements TestDao {

    @Override
    public Test insert(Test entity) throws DaoException {
        return null;
    }

    @Override
    public Test findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public Iterable<Test> getAll() throws DaoException {
        return null;
    }

    @Override
    public Test update(Test entity) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        return false;
    }

    @Override
    public Iterable<Test> fintByName(String name) throws DaoException {
        return null;
    }

    @Override
    public Iterable<Test> fintByAuthorId(Long id) throws DaoException {
        return null;
    }

}
