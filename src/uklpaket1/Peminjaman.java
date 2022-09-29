/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uklpaket1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MOKLET-2
 */
public class Peminjaman {

    private ArrayList<Integer> idSiswa = new ArrayList<Integer>();
    private ArrayList<Integer> idBuku = new ArrayList<Integer>();
    private ArrayList<Integer> banyak = new ArrayList<Integer>();

    Scanner input = new Scanner(System.in);

    //list pinjaman
    public void peminjamanSiswa(Siswa siswa, Buku buku) {
        System.out.println("Berikut adalah daftar pinjaman buku");
        System.out.println("Nama Siswa\t|Nama Buku\t|Banyak");
        for (int i = 0; i < this.idSiswa.size(); i++) {
            System.out.println(siswa.getNama(this.idSiswa.get(i)) + "\t\t|"+ buku.getNama(this.idBuku.get(i)) + "\t\t|"+ this.banyak.get(i));
        }
        System.out.println("");
    }

    //tambah peminjaman
    public void peminjamanSiswa(int idSiswa, int idBuku, int banyak) {
        this.idSiswa.add(idSiswa);
        this.idBuku.add(idBuku);
        this.banyak.add(banyak);
    }

    public int getIdBuku(int idSiswa) {
        return this.idBuku.get(idSiswa);
    }

    public int getBanyak(int idSiswa) {
        return this.banyak.get(idSiswa);
    }

    public void hapusPeminjaman(int idSiswa) {
        this.banyak.remove(idSiswa);
        this.idBuku.remove(idSiswa);
        this.idSiswa.remove(idSiswa);
    }

    //--------------------------------------------------------------------
    public int pilihSiswa(Siswa siswa) {
        System.out.print("Input ID siswa : ");
        int idSiswa = input.nextInt();
        if (idSiswa >= siswa.getJmlSiswa()) {
            System.out.println("Siswa tidak terdaftar\n");
            System.exit(0);
        }
        return idSiswa;
    }

    public int pilihMenu() {
        System.out.println("\nPilih Menu");
        System.out.println(" 1. List Buku");
        System.out.println(" 2. Peminjaman");
        System.out.println(" 3. Pengembalian");
        System.out.println(" 4. Data Peminjaman");
        System.out.println(" 5. Status Siswa");
        System.out.println("99. Keluar");
        System.out.print("Menu Yang Dipilih : ");
        return input.nextInt();
    }

    public void prosesPeminjaman(int idSiswa, Siswa siswa, Buku buku) {
        if (!siswa.getStatus(idSiswa)) {
            System.out.println("Siswa sedang meminjam buku, tidak dapat meminjam lagi\n");
            return;
        }

        buku.listBuku();
        System.out.print("Input ID buku\t: ");
        int idBuku = input.nextInt();
        System.out.print("Banyak buku\t: ");
        int banyak = input.nextInt();

        if (buku.getStok(idBuku) < banyak) {
            System.out.println("Sisa stok buku tidak mencukupi\n");
            return;
        }

        peminjamanSiswa(idSiswa, idBuku, banyak);
        buku.pinjam(idBuku, banyak);
        siswa.updateStatus(idSiswa, false);
        System.out.println("Berhasil melakukan peminjaman buku\n");
    }

    public void prosesPengembalian(int idSiswa, Siswa siswa, Buku buku) {
        int idBuku = getIdBuku(idSiswa);
        banyak.add(getBanyak(idSiswa));

        hapusPeminjaman(idSiswa);
        buku.kembali(idBuku, banyak.size());
        siswa.updateStatus(idSiswa, true);

        System.out.println("Berhasil melakukan pengembalian buku\n");
    }

    public void statusSiswa(Siswa siswa) {
        System.out.println("Status Siswa");
        System.out.println("ID\t|Nama Siswa\t|Alamat\t\t|Telp\t|Status");
        for (int i = 0; i < siswa.getJmlSiswa(); i++) {
            System.out.println(i + "\t|" + siswa.getNama(i) + "\t\t|" + siswa.getAlamat(i) + "\t|" + siswa.getTelp(i) + "\t|" + siswa.getStatus(i));
        }
    }
}
