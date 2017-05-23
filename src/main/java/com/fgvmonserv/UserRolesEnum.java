package com.fgvmonserv;


public enum UserRolesEnum {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");


    private final String role;

    UserRolesEnum(String role) {
        this.role=role;
    }

    public String getRole() {
        return role;
    }
}
