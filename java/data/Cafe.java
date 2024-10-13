/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author ACER
 */

public final class Cafe extends Tempat {
    private String menuAndalan;

    public Cafe(String nama, String alamat, String menuAndalan) {
        super(nama, alamat);
        this.menuAndalan = menuAndalan;
    }

    public String getMenuAndalan() {
        return menuAndalan;
    }

    public void setMenuAndalan(String menuAndalan) {
        this.menuAndalan = menuAndalan;
    }

    @Override
    public String info() {
        return "Nama: " + getNama() + ", Alamat: " + getAlamat() + 
               ", Menu Andalan: " + menuAndalan;
    }
}
