package com.baosi.ssm.service.impl;

import com.baosi.ssm.dao.IRoleDao;
import com.baosi.ssm.domain.Permission;
import com.baosi.ssm.domain.Role;
import com.baosi.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class RoleServiceImpl implements IRoleService {

    @Autowired(required = false)
    private IRoleDao roleDao;

    @Override
    public void addPermissionToRole(String roleId, String[] permissionId) {
        for (String p : permissionId) {
            roleDao.addPermissionToRole(roleId,p);
        }
    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherP(String roleId) {
        return roleDao.findOtherP(roleId);
    }

    @Override
    public List<Role> findAll() throws Exception{
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
