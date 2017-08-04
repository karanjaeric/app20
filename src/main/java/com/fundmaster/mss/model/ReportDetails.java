package com.fundmaster.mss.model;

import java.io.Serializable;

/**
 * Created by tony on 8/4/17.
 */
public class ReportDetails extends GenericModel<ReportDetails> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String database_url;
    private String database_user;
    private String database_password;
    private String reportsUser;
    private String reportsPassword;
    private String alternativeUrl;
    private String orientation;
    private String clientAlias;

    public ReportDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getDatabase_url() {
        return database_url;
    }

    public void setDatabase_url(String database_url) {
        this.database_url = database_url;
    }

    public String getDatabase_user() {
        return database_user;
    }

    public void setDatabase_user(String database_user) {
        this.database_user = database_user;
    }

    public String getDatabase_password() {
        return database_password;
    }

    public void setDatabase_password(String database_password) {
        this.database_password = database_password;
    }

    public String getReportsUser() {
        return reportsUser;
    }

    public void setReportsUser(String reportsUser) {
        this.reportsUser = reportsUser;
    }

    public String getReportsPassword() {
        return reportsPassword;
    }

    public void setReportsPassword(String reportsPassword) {
        this.reportsPassword = reportsPassword;
    }

    public String getAlternativeUrl() {
        return alternativeUrl;
    }

    public void setAlternativeUrl(String alternativeUrl) {
        this.alternativeUrl = alternativeUrl;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getClientAlias() {
        return clientAlias;
    }

    public void setClientAlias(String clientAlias) {
        this.clientAlias = clientAlias;
    }

    public ReportDetails(String database_url, String database_user, String database_password,
                         String reportsUser, String reportsPassword, String alternativeUrl,
                         String orientation, String clientAlias) {
        super();
        this.database_url = database_url;
        this.database_user = database_user;
        this.database_password = database_password;
        this.reportsUser = reportsUser;
        this.reportsPassword = reportsPassword;
        this.alternativeUrl = alternativeUrl;
        this.orientation = orientation;
        this.clientAlias = clientAlias;
    }
}
