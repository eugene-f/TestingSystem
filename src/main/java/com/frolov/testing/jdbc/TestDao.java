package com.frolov.testing.jdbc;

public class TestDao /*extends BaseDao<Test>*/ {

    private static final String TABLE_NAME = "TESTS";

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (ID, AUTHOR_ID, COMPLETED_SESSIONS_IDS, DISCIPLINE_ID, MINUTES_TO_PASS, NAME, PUBLICATED, QUESTIONS_IDS) VALUES (NULL, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE ID = ?";

}
