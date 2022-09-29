/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uklpaket1;

import java.util.Scanner;

/**
 *
 * @author MOKLET-2
 */
public class UKLPaket1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        
        Siswa siswa = new Siswa();
        Petugas petugas = new Petugas();
        Buku buku = new Buku();
        Peminjaman peminjaman = new Peminjaman();
        
        System.out.println("SELAMAT DATANG DI PERPUSTAKAAN TELKOM\n");
        
        petugas.listPetugas();
        siswa.listSiswa();
        
        int idSiswa = peminjaman.pilihSiswa(siswa);
        
        Boolean ulang = true;
        while(ulang){
            int menu = peminjaman.pilihMenu();
            switch (menu) {
                case 1 : buku.listBuku();
                break;
                case 2 : peminjaman.prosesPeminjaman(idSiswa, siswa, buku);
                break;
                case 3 : peminjaman.prosesPengembalian(idSiswa, siswa, buku);
                break;
                case 4 : peminjaman.peminjamanSiswa(siswa, buku);
                break;
                case 5 : peminjaman.statusSiswa(siswa);
                break;
                case 99 : ulang = false;
                break;
                default : {
                    System.out.println("Menu yang dipilih tidak tersedia\n");
                }
            }
        }
        
        in.close();
        
    }
    
    
}
    
    

