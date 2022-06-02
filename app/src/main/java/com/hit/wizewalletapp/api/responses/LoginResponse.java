package com.hit.wizewalletapp.api.responses;

//for the Retrofit interface
public class LoginResponse {

    private String email;

    private String password;
    
    private String accessToken;

    private String name;



    private String img_url;
    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
