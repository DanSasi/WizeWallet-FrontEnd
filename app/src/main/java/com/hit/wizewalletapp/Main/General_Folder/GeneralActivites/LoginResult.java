package com.hit.wizewalletapp.Main.General_Folder.GeneralActivites;

//for the Retrofit interface
public class LoginResult {

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