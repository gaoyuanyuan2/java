package com.study.java.io.serialize.parent;

import java.io.Serializable;


public class User extends SuperUser{


    @Override
    public String toString() {
        return "User{} " + super.toString();
    }
}
