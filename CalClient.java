/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulatorrmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;

/**
 *
 * @author ASUS
 */
public class CalClient {
    int a,b;
    String tanya;
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    
    public void menu () throws IOException, NotBoundException{
        Fungsi f = (Fungsi) Naming.lookup("rmi://localhost:1099/data");//pemanggilan port yang sudah dibuat di sisi server
        System.out.println(">>>KALKULATOR RMI<<<");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Pembagian");
        System.out.println("4. Perkalian");
        System.err.println("Pilih aksi :");
        System.out.println("-------------------------");
        int pilih = Integer.parseInt(br.readLine());
        switch (pilih) {
            case 1:
                System.out.println("Masukan angka pertama\t");
                a=Integer.parseInt(br.readLine());
                System.out.println("Masukan angka kedua\t");
                b=Integer.parseInt(br.readLine());
                System.out.println("Hasilnya adalah :"+f.tambah(a, b));
                new CalClient().keluar(); 
                break;
            case 2:
                System.out.println("Masukan angka pertama\t");
                a=Integer.parseInt(br.readLine());
                System.out.println("Masukan angka kedua\t");
                b=Integer.parseInt(br.readLine());
                System.out.println("Hasilnya adalah :"+f.kurang(a, b));
                new CalClient().keluar();
                 break;
            case 3:
                System.out.println("Masukan angka pertama\t");
                a=Integer.parseInt(br.readLine());
                System.out.println("Masukan angka kedua\t");
                b=Integer.parseInt(br.readLine());
                System.out.println("Hasilnya adalah :"+f.bagi(a, b));
                new CalClient().keluar();
                 break;
            case 4:
                System.out.println("Masukan angka pertama\t");
                a=Integer.parseInt(br.readLine());
                System.out.println("Masukan angka kedua\t");
                b=Integer.parseInt(br.readLine());
                System.out.println("Hasilnya adalah :"+f.kali(a, b));
                new CalClient().keluar();                 
                break;
        }
        if (pilih>4) {
            System.out.println("Tidak ada pilihan");
            menu();
            
        }
        
    }

    private void keluar() throws IOException, NotBoundException {
        System.out.println("Apakah anda ingin melakukan operasi lagi ? y/n");
        tanya=br.readLine();
        if (tanya.equals("y")){
            new CalClient().menu();
        }else if (tanya.equals("n")){
            System.exit(0);
        }
    
    }
    public static void main(String[] args) throws IOException, NotBoundException {
        CalClient c = new CalClient();
        c.menu();
    }
    
}

