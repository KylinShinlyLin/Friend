package com.zsl.dto;

import java.io.Serializable;

/**
 * Created by 蛮夷麟爷 on 2017-08-02.
 */
public class VailEmailPackage implements Serializable {

    private String username;

    private String email;

    private String VailToken;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVailToken() {
        return VailToken;
    }

    public void setVailToken(String vailToken) {
        VailToken = vailToken;
    }
}
