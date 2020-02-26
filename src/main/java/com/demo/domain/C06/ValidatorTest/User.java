package com.demo.domain.C06.ValidatorTest;

import java.io.Serializable;

public class User implements Serializable {

    private String my_loginname;
    private String my_password;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getMy_loginname() {
        return my_loginname;
    }

    public void setMy_loginname(String my_loginname) {
        this.my_loginname = my_loginname;
    }

    public String getMy_password() {
        return my_password;
    }

    public void setMy_password(String my_password) {
        this.my_password = my_password;
    }

    @Override
    public String toString() {
        return "User [loginname=" + my_loginname + ", password=" + my_password + "]";
    }
}
