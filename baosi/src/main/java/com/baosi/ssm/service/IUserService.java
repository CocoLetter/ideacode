package com.baosi.ssm.service;

import com.baosi.ssm.domain.Role;
import com.baosi.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String id);

    void addRoleToUser(String userId, String[] roleId);

    void delUser(int id);
}
