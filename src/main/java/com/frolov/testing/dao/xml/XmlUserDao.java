package com.frolov.testing.dao.xml;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.UserDao;
import com.frolov.testing.entity.user.BaseUser;

public class XmlUserDao extends XmlBaseDao<BaseUser> implements UserDao {

    @Override
    public BaseUser insert(BaseUser entity) throws DaoException {
        return null;
    }

    @Override
    public BaseUser findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public Iterable<BaseUser> getAll() throws DaoException {
        return null;
    }

    @Override
    public BaseUser update(BaseUser entity) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        return false;
    }

    @Override
    public BaseUser findByEmail(String email) throws DaoException {
        return null;
    }

}
