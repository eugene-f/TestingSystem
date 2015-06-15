package com.frolov.testing.dao.interfaces;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.Dao;
import com.frolov.testing.entity.test.Configuration;

public interface ConfigurationDao extends Dao<Configuration> {

    @Override
    Iterable<Configuration> getAll() throws DaoException;

    @Override
    Configuration insert(Configuration entity) throws DaoException;

    @Override
    Configuration findById(Long id) throws DaoException;

    @Override
    Configuration update(Configuration entity) throws DaoException;

    @Override
    boolean deleteById(Long id) throws DaoException;

    Configuration findByTestId(Long id) throws DaoException;

}
