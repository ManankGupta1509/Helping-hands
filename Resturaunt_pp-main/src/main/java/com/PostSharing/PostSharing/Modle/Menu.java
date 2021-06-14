package com.PostSharing.PostSharing.Modle;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Menu {


    //    Menu m
//    Item name
//    Price
//

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String iteamName;
    private Double price;

    @ManyToOne(fetch=FetchType.LAZY)
    private Restraunt restraunt;


    public Menu() {
    }

    public Menu(long id) {
        this.id = id;
    }

    public Menu(long id, String iteamName, Double price,Long res_id) {
        this.id = id;
        this.iteamName = iteamName;
        this.price = price;
        this.restraunt=new Restraunt(res_id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIteamName() {
        return iteamName;
    }

    public void setIteamName(String iteamName) {
        this.iteamName = iteamName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getRestraunt() {
        return restraunt.getId();
    }

    public void setRestraunt(Long restraunt) {
        this.restraunt = new Restraunt(restraunt);
    }
}
