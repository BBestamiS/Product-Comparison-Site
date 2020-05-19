/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.laptopEkranDAO;
import entity.laptopEkran;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Casper
 */
@Named
@SessionScoped
public class laptopEkranController implements Serializable{
     private List<laptopEkran> laptopEkranList;
    private laptopEkranDAO laptopEkrandao;
    private laptopEkran laptopEkran;

    
    public List<laptopEkran> getlaptopEkranList() {
        this.laptopEkranList=this.getlaptopEkrandao().findAll();
        return laptopEkranList;
    }

    public void setlaptopEkranList(List<laptopEkran> laptopEkranList) {
        this.laptopEkranList = laptopEkranList;
    }

    public laptopEkranDAO getlaptopEkrandao() {
        if (this.laptopEkrandao==null) {
            this.laptopEkrandao=new laptopEkranDAO();
        }
        return laptopEkrandao;
    }

    public void setlaptopEkrandao(laptopEkranDAO laptopEkrandao) {
        this.laptopEkrandao = laptopEkrandao;
    }

    public laptopEkran getlaptopEkran() {
        if (this.laptopEkran==null) {
            this.laptopEkran=new laptopEkran();
        }
        return laptopEkran;
    }

    public void setlaptopEkran(laptopEkran laptopEkran) {
        this.laptopEkran = laptopEkran;
    }
}