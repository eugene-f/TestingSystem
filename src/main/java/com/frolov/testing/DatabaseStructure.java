package com.frolov.testing;

public abstract class DatabaseStructure {

    public class ANSWERS {
        public static final String TABLE = "ANSWERS";
        public static final String ID = "ID";
        public static final String QUESTION_ID = "QUESTION_ID";
        public static final String CONTENT = "CONTENT";
        public static final String CORRECT = "CORRECT";
        public static final String DELETED = "DELETED";
    }

    public class CONFIGURATION {
        public static final String TABLE = "CONFIGURATION";
        public static final String ID = "ID";
        public static final String MINUTES_TO_PASS = "MINUTES_TO_PASS";
        public static final String QUESTION_COUNT_TO_VIEW = "QUESTION_COUNT_TO_VIEW";
        public static final String SHUFFLE_QUESTION = "SHUFFLE_QUESTION";
        public static final String SHUFFLE_ANSWER = "SHUFFLE_ANSWER";
        public static final String SHOW_CORRECT = "SHOW_CORRECT";
        public static final String TAKE_AGAIN = "TAKE_AGAIN";
        public static final String DELETED = "DELETED";
    }

    public class DISCIPLINES {
        public static final String TABLE = "DISCIPLINES";
        public static final String ID = "ID";
        public static final String NAME = "NAME";
        public static final String DELETED = "DELETED";
    }

    public class QUESTIONS {
        public static final String TABLE = "QUESTIONS";
        public static final String ID = "ID";
        public static final String TEST_ID = "TEST_ID";
        public static final String CONTENT = "CONTENT";
        public static final String CORRECT_ANSWER_ID = "CORRECT_ANSWER_ID";
        public static final String DELETED = "DELETED";
    }

    public class SESSIONS {
        public static final String TABLE = "SESSIONS";
        public static final String ID = "ID";
        public static final String TEST_ID = "TEST_ID";
        public static final String STUDENT_ID = "STUDENT_ID";
        public static final String START_DATE = "START_DATE";
        public static final String RESULT = "RESULT";
        public static final String FINISHED = "FINISHED";
        public static final String DELETED = "DELETED";
    }

    public class TESTS {
        public static final String TABLE = "TESTS";
        public static final String ID = "ID";
        public static final String AUTHOR_ID = "AUTHOR_ID";
        public static final String NAME = "NAME";
        public static final String DISCIPLINE_ID = "DISCIPLINE_ID";
        public static final String CONFIGURATION_ID = "CONFIGURATION_ID";
        public static final String PUBLICATED = "PUBLICATED";
        public static final String DELETED = "DELETED";
    }

    public class USERS {
        public static final String ID = "ID";
        public static final String TYPE_ID = "TYPE_ID";
        public static final String ROLE = "ROLE";
        public static final String FIRST_NAME = "FIRST_NAME";
        public static final String LAST_NAME = "LAST_NAME";
        public static final String EMAIL = "EMAIL";
        public static final String PASSWORD_HASH = "PASSWORD_HASH";
        public static final String DELETED = "DELETED";
    }

    public class TYPE {
        public static final String ID = "ID";
        public static final String NAME = "NAME";
    }

    public class TUTORS {
    }

    public class STUDENTS {
    }

    public class ADMINS {
    }

    public class DEPARTMENTS {
    }

    public class FACULTIES {
    }

    public class GROUPS {
    }

    public class SESSION_ANSWERS {
        public static final String ID = "ID";
        public static final String SESSION_ID = "SESSION_ID";
        public static final String QUESTIONS_ID = "QUESTIONS_ID";
        public static final String ANSWERS_ID = "ANSWERS_ID";
        public static final String DELETED = "DELETED";
    }

// // // // // // // // // // // // // // // // // // // // // // // // // // // // // //

    public class CLASS {
        public static final String STRING1 = "STRING1";
        public static final String STRING2 = "STRING2";
        public static final String STRING3 = "STRING3";
    }

}
