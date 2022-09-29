/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uklpaket1;

import java.util.ArrayList;

/**
 *
 * @author MOKLET-2
 */
public class DaftarBuku {

    private ArrayList<String> nama = new ArrayList<String>();
    private ArrayList<Integer> stok = new ArrayList<Integer>();
    private ArrayList<Integer> harga = new ArrayList<Integer>();

    public DaftarBuku() {
        //Tambah buku
        //0
        this.nama.add("Bumii");
        this.stok.add(10);
        this.harga.add(8000);

        //1
        this.nama.add("Bulan");
        this.stok.add(11);
        this.harga.add(15000);

        //2
        this.nama.add("Comet");
        this.stok.add(12);
        this.harga.add(10000);
    }

    public void listBuku() {
        System.out.println("Buku tersedia : ");
        System.out.println("ID\t|Nama Buku\t|Stok\t|Harga");
        for (int i = 0; i < this.nama.size(); i++) {
            System.out.println(i + "\t|" + this.nama.get(i) + "\t\t|"
                    + this.stok.get(i) + "\t|"
                    + this.harga.get(i));
        }
        System.out.println("");
    }

    public void pinjam(int id, int banyak) {
        int sisaStok = this.stok.get(id);
        sisaStok -= banyak;

        this.stok.set(id, sisaStok);
    }

    public void kembali(int id, int banyak) {
        int sisaStok = this.stok.get(id);
        sisaStok += banyak;

        this.stok.set(id, sisaStok);
    }

    public int getStok(int id) {
        return this.stok.get(id);
    }

    public String getNama(int id) {
        return this.nama.get(id);
    }
}
