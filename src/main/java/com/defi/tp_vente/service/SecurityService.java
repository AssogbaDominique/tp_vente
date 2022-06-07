package com.defi.tp_vente.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);

    boolean isAuthenticated();
    void autoLogin(String username, String password);
}