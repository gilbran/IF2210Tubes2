/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigimu;

import java.util.Scanner;

/**
 *
 * @author andi
 */
public class MainText {
    public static void main(String [] args) throws Exception{
        System.out.println("Masukkan Mode");
        System.out.println("1. Resepsionis");
        System.out.println("2. Dokter");
        System.out.println("3. Kasir");
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        if(mode==1) {
            doresepsionis();
        }
        else if(mode==3) {
            dokasir();
        }
    }
    
    public static void doresepsionis() throws Exception {
        Resepsionis resepsionis = new Resepsionis();
        System.out.println("WELCOME TO RESEPSIONIS MODE");
        System.out.println("1. Cek pasien id");
        System.out.println("2. Daftar pasien baru");
        System.out.println("3. Assign pasien");
        
        int mode = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            mode = scanner.nextInt();
        } while (mode<1 || mode>3);
        if(mode==1) {
            System.out.println("Masukkan ID pasien");
            Scanner scanner = new Scanner(System.in);
            mode = scanner.nextInt();
            System.out.println(resepsionis.checkdaftar(new Pasien(mode)));
        }
        else if(mode==2) {
            System.out.println("Masukkan ID pasien");
            Scanner scanner = new Scanner(System.in);
            int idpasien = scanner.nextInt();
            System.out.println("Masukkan noktp pasien");
            String noktp = scanner.next();
            System.out.println("Masukkan nama pasien");
            String nama = scanner.next();
            System.out.println("Masukkan alamat pasien");
            String alamat = scanner.next();
            System.out.println("Masukkan notelp pasien");
            String notelp = scanner.next();
            System.out.println("Masukkan tempatlahir pasien");
            String tempatlahir = scanner.next();
            System.out.println("Masukkan tanggallahir YY pasien");
            int YY = scanner.nextInt();
            System.out.println("Masukkan tanggallahir MM pasien");
            int MM = scanner.nextInt();
            System.out.println("Masukkan tanggallahir DD pasien");
            int DD = scanner.nextInt();
            System.out.println("Masukkan namabapak pasien");
            String namabapak = scanner.next();
            System.out.println("Masukkan namaibu pasien");
            String namaibu = scanner.next();
            System.out.println("Masukkan alamatdarurat pasien");
            String alamatdarurat = scanner.next();
            System.out.println("Masukkan notelpdarurat pasien");
            String notelpdarurat = scanner.next();
            Pasien P = new Pasien();
            P.setidpasien(idpasien);
            P.setnoktp(noktp);
            P.setnama(nama);
            P.setalamat(alamat);
            P.setnotelp(notelp);
            P.settempatlahir(tempatlahir);
            P.settanggallahirn(new java.sql.Date(YY, MM, DD));
            P.setnamabapak(namabapak);;
            P.setnamaibu(namaibu);
            P.setalamatdarurat(alamatdarurat);
            P.setnotelpdarurat(notelpdarurat);
            resepsionis.daftar(P);
        }
        else {
            System.out.println("Assign Pasien");
            System.out.println("Masukkan ID Pasien");
            Scanner scanner = new Scanner(System.in);
            int idpasien = scanner.nextInt();
            System.out.println("Masukkan ID Ruangan");
            int idruangan = scanner.nextInt();
            resepsionis.assignpasien(new Pasien(idpasien), idruangan);
        }
    }
    
    public static void dokasir() throws Exception {
        System.out.println("WELCOME TO KASIR MODE");
        System.out.println("Masukkan ID yang akan membayar");
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        Kasir kasir = new Kasir();
        kasir.bayar(mode);
    }
    
//    public static void doruangan() {
//        System.out.pri
//    }
}
