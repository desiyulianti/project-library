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
public class Siswa implements user {

    private ArrayList<String> nama = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telp = new ArrayList<String>();
    private ArrayList<Boolean> status = new ArrayList<Boolean>();

    public Siswa() {
        //Tambah Siswa
        //0
        this.nama.add("Aldo");
        this.alamat.add("Kepanjen");
        this.telp.add("081");
        this.status.add(true);

        //1
        this.nama.add("Bagus");
        this.alamat.add("Sawojajar");
        this.telp.add("083");
        this.status.add(true);
        
        //2
        this.nama.add("Marisa");
        this.alamat.add("Belimbing");
        this.telp.add("086");
        this.status.add(true);
        
        //3
        this.nama.add("Kanaya");
        this.alamat.add("Kepanjen");
        this.telp.add("089");
        this.status.add(true);
    }

    public void listSiswa() {
        System.out.println("Siswa terdaftar : ");
        System.out.println("ID\t|Nama Siswa\t|Alamat\t\t|Telp\t|Status");
        for (int i = 0; i < this.nama.size(); i++) {
            System.out.println(i + "\t|" + this.nama.get(i) + "\t\t|" + this.alamat.get(i) + "\t|" + this.telp.get(i) + "\t|" + this.status.get(i));
        }
        System.out.println("");
    }

    public int getJmlSiswa() {
        return this.nama.size();
    }

    public void updateStatus(int idSiswa, boolean status) {
        this.status.set(idSiswa, status);
    }

    //Setter
    @Override
    public void setNama(String nama) {
        this.nama.add(nama);
    }

    @Override
    public void setAlamat(String alamat) {
        this.nama.add(alamat);
    }

    @Override
    public void setTelp(String telp) {
        this.telp.add(telp);
    }

    public void setStatus(Boolean status) {
        this.status.add(status);
    }

    //Getter
    @Override
    public String getNama(int id) {
        return this.nama.get(id);
    }

    @Override
    public String getAlamat(int id) {
        return this.alamat.get(id);
    }

    @Override
    public String getTelp(int id) {
        return this.telp.get(id);
    }

    public boolean getStatus(int id) {
        return this.status.get(id);
    }
}
