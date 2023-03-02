package com.vladwave.projectfortopacademy;

public enum UsersRole {
    ADMIN("ADMIN"),DEFAULT("DEFAULT");
    String name;

    UsersRole(String name) {
        this.name = name;
    }
    static UsersRole getRoleFromString(String s) throws ClassNotFoundException {
        if(s.equals("ADMIN")){
            return ADMIN;
        } else if(s.equals("DEFAULT")){
            return DEFAULT;
        } else {
            throw new ClassNotFoundException("This position is not found");
        }
    }
}
