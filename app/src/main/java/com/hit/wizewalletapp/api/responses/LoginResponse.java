package com.hit.wizewalletapp.api.responses;

//for the Retrofit interface
public class LoginResponse {

    private String email;

    private String password;
    
    private String accessToken;

    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
