/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.laptopEkran;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Connector;

/**
 *
 * @author Casper
 */
public class laptopEkranDAO {

    private Connector connector;
    private Connection connection;

    public List<laptopEkran> findAll() {
        List<laptopEkran> ekran_liste = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_ekran ");
            while (rs.next()) {
                laptopEkran tmp = new laptopEkran();
                tmp.setEkran_id(rs.getLong("ekran_id"));
                tmp.setEkran_boyutu(rs.getDouble("ekran_boyutu"));
                tmp.setEkran_cozunurlugu(rs.getString("ekran_cozunurlugu"));
                tmp.setEkran_yenileme(rs.getInt("ekran_yenileme"));
                ekran_liste.add(tmp);
            }

            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "EkranDAo");
        }
        return ekran_liste;
    }

    public laptopEkran find(Long id) {
        laptopEkran ekran = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from laptop_ekran where ekran_id=" + id);
            rs.next();
            ekran = new laptopEkran();
            ekran.setEkran_id(rs.getLong("ekran_id"));
            ekran.setEkran_boyutu(rs.getDouble("ekran_boyutu"));
            ekran.setEkran_cozunurlugu(rs.getString("ekran_cozunurlugu"));
            ekran.setEkran_yenileme(rs.getInt("ekran_yenileme"));
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "EkranDAo");
        }

        return ekran;

    }

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();

        }
        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().Connect();
        }
        return connection;
    }

}