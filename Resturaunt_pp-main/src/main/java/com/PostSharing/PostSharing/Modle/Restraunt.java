package com.PostSharing.PostSharing.Modle;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restraunt {


    //    Restraunt details m
//            Address
//    Rest name
//    Food license
//    Contact number
//    Contact email
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String tagline;
    private String address;
    private String foodlicense;
    private Long contact_numb;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy="restraunt")
    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Restraunt() {
    }

    public Restraunt(Long id) {
        this.id = id;
    }

    public Restraunt(String name, String tagline, String address, String foodlicense, Long contact_numb, String email) {
        this.name = name;
        this.tagline = tagline;
        this.address = address;
        this.foodlicense = foodlicense;
        this.contact_numb = contact_numb;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFoodlicense() {
        return foodlicense;
    }

    public void setFoodlicense(String foodlicense) {
        this.foodlicense = foodlicense;
    }

    public Long getContact_numb() {
        return contact_numb;
    }

    public void setContact_numb(Long contact_numb) {
        this.contact_numb = contact_numb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
}
