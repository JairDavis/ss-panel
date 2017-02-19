package com.sp.service;

import com.sp.model.User;

/**
 * Created by biezhi on 2017/2/19.
 */
public interface UserService {

    User getUserById(Integer uid);

    void update(User user);

    User byEmail(String email);

    int getIpRegCount(String ip);

    int getLastPort();

    void save(User user);
}
