package com.defi.tp_vente.service;

import com.defi.tp_vente.model.User;


public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
