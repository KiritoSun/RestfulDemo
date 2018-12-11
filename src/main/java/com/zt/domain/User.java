package com.zt.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
**  数据库实体类：user
 */
public class User implements Serializable {
    private String u_id;
    private String u_password;
    private String u_name;
    private String u_sex;
    private String u_phone;

    public User(){}

    public User(String u_id, String u_password, String u_name, String u_sex, String u_phone) {
        this.u_id = u_id;
        this.u_password = u_password;
        this.u_name = u_name;
        this.u_sex = u_sex;
        this.u_phone = u_phone;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_sex() {
        return u_sex;
    }

    public void setU_sex(String u_sex) {
        this.u_sex = u_sex;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id='" + u_id + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_name='" + u_name + '\'' +
                ", u_sex='" + u_sex + '\'' +
                ", u_phone='" + u_phone + '\'' +
                '}';
    }
}
