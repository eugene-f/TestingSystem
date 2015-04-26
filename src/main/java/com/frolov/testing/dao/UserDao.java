package com.frolov.testing.dao;

import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;

public interface UserDao extends Dao<BaseUser> {

    @Override
    Iterable<BaseUser> getAll() throws DaoException;

    @Override
    BaseUser insert(BaseUser entity) throws DaoException;

    @Override
    BaseUser findById(Long id) throws DaoException;

    @Override
    BaseUser update(BaseUser entity) throws DaoException;

    @Override
    boolean deleteById(Long id) throws DaoException;

    BaseUser findByEmail(String email) throws DaoException;

    BaseUser findByFirstName(String firstName) throws DaoException;

    BaseUser findByLastName(String lastName) throws DaoException;

    BaseUser findByFullName(String fullName) throws DaoException;

    Iterable<Tutor> getTutors() throws DaoException;

    Iterable<Student> getStudents() throws DaoException;

}
