package com.liugl.alltest.cach.acache;

import java.io.Serializable;

/**
 * WonderTech
 * Created by YangLiu on 2017/12/24.
 */

public class AcacheBean implements Serializable {

    private static final long serialVersionUID = 7762063479104981167L;

    private String userName;
    private String pwd;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
