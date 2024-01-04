package com.example.preexam;

import android.provider.BaseColumns;

public class MeubleContract{
    public static final String DB_NAME = "com.example.preexam";
    public static final int DB_VERSION = 2;
    public static class MeubleEntry implements BaseColumns {
        public static final String TABLE_NAME = "meuble";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGE = "image";
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " TEXT," +
                        COLUMN_PRICE + " TEXT," +
                        COLUMN_DESCRIPTION + " TEXT," +
                        COLUMN_IMAGE + " BLOB)";
        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

    }
    public static class CategoryEntry implements BaseColumns{
        public static final String TABLE_NAME = "category";
        public static final String COLUMN_NAME = "name";
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME + " TEXT)";
        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
