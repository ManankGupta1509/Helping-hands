package com.PostSharing.PostSharing.Modle;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

//    Signup m to sirf
//
//    Username
//            Password
//    Confirm password
//    Email address
//    Mobile number bs
//


    @Id
    private String userid;
    private String username;
    private String password;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private Long mobile;

    private String role;

    public User() {
    }

    public User(String userid) {
        this.userid = userid;
    }

    public User(String userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public User(String userid, String username, String password, String email, Long mobile) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }


    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
