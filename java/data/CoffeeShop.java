/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

public final class CoffeeShop extends Tempat {
    private String jenisKopiFavorit;
    private static int totalCoffeeShop = 0;

    public CoffeeShop(String nama, String alamat, String jenisKopiFavorit) {
        super(nama, alamat);
        this.jenisKopiFavorit = jenisKopiFavorit;
        totalCoffeeShop++;
    }

    public String getJenisKopiFavorit() {
        return jenisKopiFavorit;
    }

    public void setJenisKopiFavorit(String jenisKopiFavorit) {
        this.jenisKopiFavorit = jenisKopiFavorit;
    }

    public static int getTotalCoffeeShop() {
        return totalCoffeeShop;
    }

    @Override
    public String info() {
        return "Nama: " + getNama() + ", Alamat: " + getAlamat() + 
               ", Kopi Favorit: " + jenisKopiFavorit;
    }
}
