package com.example.core_v1.utils;

public class dbutils {

    //Table users details. ( name and fields).

    public static final String TABLE_USERS="users";
    public static final String FIELD_ID="user_id";
    public static final String FIELD_NAME="name";
    public static final String FIELD_PASSWORD="password";

    public static final String CREATE_TABLE_USERS="CREATE TABLE "+TABLE_USERS+" ("+FIELD_ID+" INTEGER, "+FIELD_NAME+" TEXT, "+FIELD_PASSWORD+" TEXT)";
}


