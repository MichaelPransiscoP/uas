/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author CoffeeShop
 */
public class Store {
    private int id;
    private int idDetailTransaction;
    private String cabang;
    private String deskripsi;
    private double income;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDetailTransaction() {
        return idDetailTransaction;
    }

    public void setIdDetailTransaction(int idDetailTransaction) {
        this.id = idDetailTransaction;
    }

    public String getCabang() {
        return cabang;
    }

    public void setCabang(String cabang) {
        this.cabang = cabang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
    
    
}
