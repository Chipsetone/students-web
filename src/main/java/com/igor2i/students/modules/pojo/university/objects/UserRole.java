package com.igor2i.students.modules.pojo.university.objects;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Семакин Виктор
 */
public class UserRole implements GrantedAuthority {
    private int id;
    private int userId;
    private String roleName;

    public UserRole(int id, int userId, String roleName) {
        this.id = id;
        this.userId = userId;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
