package com.enigmacamp.loan_app_api.constant;

public class UserLevel {
    public static final String ADMIN = "hasRole('ADMIN')";
    public static final String STAFF = "hasRole('STAFF')";
    public static final String ADMIN_AND_STAFF = "hasAnyRole('STAFF', 'ADMIN')";
    public static final String CUSTOMER = "hasRole('CUSTOMER')";
}
