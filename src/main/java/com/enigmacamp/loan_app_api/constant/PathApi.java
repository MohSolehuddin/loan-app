package com.enigmacamp.loan_app_api.constant;

public class PathApi {
    public static final String AUTH = "/api/v1/auth";
    public static final String SIGN_UP = "/signup";
    public static final String SIGN_IN = "/signin";
    public static final String USER = "/api/v1/users";
    public static final String CUSTOMER = "/api/v1/customers";
    public static final String TRANSACTION = "/api/v1/transactions";
    public static final String IMPLEMENT_TYPE = "/api/v1/instalment-types";
    public static final String LOAN_TYPE = "/api/v1/loan-types";

    public static final String PAY = "/{trxId}/pay";
    public static final String APPROVE = "/{adminId}/approve";
    public static final String PATH_VAR_ID = "/{id}";
}