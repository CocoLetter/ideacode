package com.baosi.ssm.service;

import com.baosi.ssm.domain.Permission;
import com.baosi.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll() throws Exception;

    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOtherP(String roleId);

    void addPermissionToRole(String roleId, String[] permissionId);
}
