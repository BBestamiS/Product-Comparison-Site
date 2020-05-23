/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DataAccess.laptopDepolamaBellekDAO;
import entity.laptopDepolamaBellek;
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
public class laptopDepolamaBellekController implements Serializable {

    private List<laptopDepolamaBellek> laptopDepolamaBellekList;
    private laptopDepolamaBellekDAO laptopDepolamaBellekDAO;
    private laptopDepolamaBellek laptopDepolamaBellek;

    public void update() {
        this.getLaptopDepolamaBellekDAO().edit(this.laptopDepolamaBellek);
    }

    public void delete(laptopDepolamaBellek laptopDepolamaBellek) {
        this.getLaptopDepolamaBellekDAO().remove(laptopDepolamaBellek);
        this.laptopDepolamaBellek = null;
    }

    public void temizle() {
        this.laptopDepolamaBellek = null;

    }

    public void updateForm(laptopDepolamaBellek bag) {
        this.laptopDepolamaBellek = bag;
    }

    public void create() {
        this.getLaptopDepolamaBellekDAO().insert(this.laptopDepolamaBellek);
        temizle();
    }

    public List<laptopDepolamaBellek> getLaptopDepolamaBellekList() {
        this.laptopDepolamaBellekList = this.getLaptopDepolamaBellekDAO().findAll();
        return laptopDepolamaBellekList;
    }

    public void setLaptopDepolamaBellekList(List<laptopDepolamaBellek> laptopDepolamaBellekList) {
        this.laptopDepolamaBellekList = laptopDepolamaBellekList;
    }

    public laptopDepolamaBellekDAO getLaptopDepolamaBellekDAO() {
        if(this.laptopDepolamaBellekDAO == null){
            this.laptopDepolamaBellekDAO = new laptopDepolamaBellekDAO();
        }
        return laptopDepolamaBellekDAO;
    }

    public void setLaptopDepolamaBellekDAO(laptopDepolamaBellekDAO laptopDepolamaBellekDAO) {
        this.laptopDepolamaBellekDAO = laptopDepolamaBellekDAO;
    }

    public laptopDepolamaBellek getLaptopDepolamaBellek() {
        if(this.laptopDepolamaBellek == null){
            this.laptopDepolamaBellek = new laptopDepolamaBellek();
        }
        return laptopDepolamaBellek;
    }

    public void setLaptopDepolamaBellek(laptopDepolamaBellek laptopDepolamaBellek) {
        this.laptopDepolamaBellek = laptopDepolamaBellek;
    }

    

}
