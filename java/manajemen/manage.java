/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package manajemen;

import data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class manage implements CRUD {
    private static ArrayList<Tempat> daftarTempat = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        manage manajemen = new manage();
        boolean keluar = false;

        while (!keluar) {
            System.out.println("\n--- Manajemen Tempat ---");
            System.out.println("1. Tambah Tempat");
            System.out.println("2. Lihat Semua Tempat");
            System.out.println("3. Update Tempat");
            System.out.println("4. Hapus Tempat");
            System.out.println("5. Total Coffee Shop Terdaftar");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = input.nextInt();
            input.nextLine(); // Mengatasi masalah input newline

            switch (pilihan) {
                case 1 -> manajemen.tambah();
                case 2 -> manajemen.lihat();
                case 3 -> manajemen.update();
                case 4 -> manajemen.hapus();
                case 5 -> System.out.println("Total Coffee Shop: " + CoffeeShop.getTotalCoffeeShop());
                case 6 -> {
                    keluar = true;
                    System.out.println("Keluar dari program.");
                }
                default -> System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    @Override
    public void tambah() {
        System.out.print("Masukkan jenis tempat (1. Coffee Shop / 2. Cafe): ");
        int jenis = input.nextInt();
        input.nextLine(); // Mengatasi masalah newline

        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Alamat: ");
        String alamat = input.nextLine();

        if (jenis == 1) {
            System.out.print("Masukkan Jenis Kopi Favorit: ");
            String kopi = input.nextLine();
            daftarTempat.add(new CoffeeShop(nama, alamat, kopi));
            System.out.println("Coffee Shop berhasil ditambahkan!");
        } else if (jenis == 2) {
            System.out.print("Masukkan Menu Andalan: ");
            String menu = input.nextLine();
            daftarTempat.add(new Cafe(nama, alamat, menu));
            System.out.println("Cafe berhasil ditambahkan!");
        } else {
            System.out.println("Jenis tempat tidak valid.");
        }
    }

    @Override
    public void lihat() {
        if (daftarTempat.isEmpty()) {
            System.out.println("Belum ada tempat yang terdaftar.");
        } else {
            System.out.println("\n--- Daftar Tempat ---");
            for (Tempat tempat : daftarTempat) {
                System.out.println(tempat.info());
            }
        }
    }

    @Override
    public void update() {
        lihat();
        System.out.print("Masukkan indeks tempat yang ingin di-update: ");
        int index = input.nextInt();
        input.nextLine(); // Mengatasi masalah newline

        if (index >= 0 && index < daftarTempat.size()) {
            Tempat tempat = daftarTempat.get(index);
            System.out.print("Masukkan Nama Baru: ");
            tempat.setNama(input.nextLine());
            System.out.print("Masukkan Alamat Baru: ");
            tempat.setAlamat(input.nextLine());

            if (tempat instanceof CoffeeShop coffeeShop) {
                System.out.print("Masukkan Jenis Kopi Favorit Baru: ");
                coffeeShop.setJenisKopiFavorit(input.nextLine());
            } else if (tempat instanceof Cafe cafe) {
                System.out.print("Masukkan Menu Andalan Baru: ");
                cafe.setMenuAndalan(input.nextLine());
            }
            System.out.println("Data berhasil di-update!");
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }

    @Override
    public void hapus() {
        lihat();
        System.out.print("Masukkan indeks tempat yang ingin dihapus: ");
        int index = input.nextInt();
        input.nextLine(); // Mengatasi masalah newline

        if (index >= 0 && index < daftarTempat.size()) {
            daftarTempat.remove(index);
            System.out.println("Tempat berhasil dihapus!");
        } else {
            System.out.println("Indeks tidak valid.");
        }
    }
}
