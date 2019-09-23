package com.busyzero.demo.hystrix.vo;

public class UserContext {
    public static String CORRELATION_ID = "correlation_id";
    public static String USER_ID = "user_id";
    public static String AUTH_TOKEN = "auth_token";
    public static String ORG_ID = "org_id";


    private String correlationId;
    private String userId;
    private String authToken;
    private String orgId;

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
