package com.mycompany.legalhelpwithjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends User{
    public String idAdmin;
    public String passAdmin;
    public List<User> users;
    public List<String> transaksi;
    public List<ConsultantService> lawyers;
    public List<Article> articles;

    public Admin(String idAdmin, String passAdmin, List<User> users, String idUser, String passUser, String emailUser) {
        super(idUser, passUser, emailUser);
        this.idAdmin = idAdmin;
        this.passAdmin = passAdmin;
        this.users = new ArrayList<>();
        this.transaksi = new ArrayList<>();
        this.lawyers = new ArrayList<>();
        this.articles = new ArrayList<>();
    }

    
    
    public void manageUser(){
        User newUser = new User("user123", "password123", "user123@gmail.com"){
            @Override
            public void register(String idUser, String emailUser, String password){
                System.out.println("Registering User "+ idUser);
            }
        };
        addUser(newUser);
        
        System.out.println("List of users:");
        for (User user : users) {
            System.out.println(user.idUser + " - " + user.emailUser);
        }
        
        removeUser("user123");
        
        System.out.println("List of users after removal:");
        for (User user : users) {
            System.out.println(user.idUser + " - " + user.emailUser);
        }
    }    
    
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.idUser);
    }
        
    public void removeUser(String userId) {
        users.removeIf(user -> user.idUser.equals(userId));
        System.out.println("User with ID " + userId + " removed.");
    }
    
    public void monitorTransaction(){
        System.out.println("Monitoring transaksi");
        
        if(transaksi.isEmpty()){
            System.out.println("Tidak Ada Transaksi");
        }else{
            for (String tr : transaksi){
                System.out.println(tr);
                System.out.println("--------------");
            }
        }
    }
    
    public void addTranscation(String detailTransaksi){
        transaksi.add(detailTransaksi);
        System.out.println("Menambahkan Transaksi: " + detailTransaksi);
    }
    
    public void addLawyer(){
       Scanner scanner = new Scanner(System.in);
       
        System.out.print("Masukkan Nama Pengacara: ");
        String lawyer = scanner.nextLine();
        
        System.out.print("Masukkan Harga: Rp ");
        double price = scanner.nextDouble();
        
        System.out.print("Masukkan Durasi(dalam menit): ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Masukkan Deskripsi: ");
        String description = scanner.nextLine();
        
        ConsultantService newService = new ConsultantService(lawyer, price, duration, description);
        lawyers.add(newService);
        
        System.out.println("Layanan Konsultasi berhasil Ditambahkan!");
        
    }
    
    public void displaylawyer(){
        if(lawyers.isEmpty()){
            System.out.println("Tidak Ada Pengacara Tersedia");
        }else{
            System.out.println("List Pengacara: ");
            for(ConsultantService l : lawyers){
                l.displayService();
                System.out.println("----------------");
            }
        }
    }
    
    public Article addArticle(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan Judul Artikel: ");
        String titleArticle = scanner.nextLine();
        
        System.out.print("Masukkan Konten Artikel: ");
        String content = scanner.nextLine();
        
        System.out.print("Masukkan Pasal: ");
        String pasal = scanner.nextLine();
        
        Article newArticle = new Article(titleArticle, content, pasal);
        articles.add(newArticle);
        
        System.out.println("Artikel Berhasil Ditambahkan!");
        return newArticle;
    }
    
    public void diplayArticles(){
        if(articles.isEmpty()){
            System.out.println("Artikel Tidak Ada ");
        }else{
            System.out.println("List Artikel: ");
            for(Article ar : articles){
                ar.displayArticle();
                System.out.println("---------------");
            }
        }
    }
    
    public void manageLawyer(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do{
            System.out.println("\n ===Mengelola Pengacara=== ");
            System.out.println("1. Menambahkan Pengacara ");
            System.out.println("2. Menghapus Pengacara");
            System.out.println("3. Melihat Pengacara");
            System.out.println("4. Exit");
            System.out.print("Masukkan Pilihan Anda: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice){
                case 1:
                    addLawyer();
                    break;
                case 2:
                    if(lawyers.isEmpty()){
                        System.out.println("Tidak Ada Pengacara yang di Hapus");
                    }else {
                        System.out.println("Pilih Pengacara untuk Dihapus");
                    }
            }
        }
    }

    @Override
    public void register(String idUser, String emailUser, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}