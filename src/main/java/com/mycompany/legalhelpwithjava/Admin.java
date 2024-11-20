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

    public Admin(String idUser, String passUser, String emailUser) {
        super(idUser, passUser, emailUser);
        this.users = new ArrayList<>();
        this.transaksi = new ArrayList<>();
        this.lawyers = new ArrayList<>();
        this.articles = new ArrayList<>();
    }
    
    public void addUser(User user) {
        users.add(user);
    }
    
    public void manageUser(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        
       do{
            System.out.println("\n ===Mengelola User=== ");
            System.out.println("1. Menambahkan User ");
            System.out.println("2. Menghapus User");
            System.out.println("3. Melihat User");
            System.out.println("4. Exit");
            System.out.print("Masukkan Pilihan Anda: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice){
                case 1:
                    System.out.print("Masukkan Nama Pengguna: ");
                    String user = scanner.nextLine();
        
                    System.out.print("Masukkan Password: ");
                    String pass = scanner.nextLine();

                    System.out.print("Masukkan email: ");
                    String email = scanner.nextLine();

                    User newUser = new User(user, email, pass) {
                        @Override
                        public void register(String idUser, String emailUser, String password) {
                            System.out.println("Registering User "+ idUser); 
                        }
                    };
                    newUser.register(idUser, emailUser, pass);
                    users.add(newUser);

                    System.out.println("Penambahan Pengguna Berhasil!");
                    break;
                    
                    
                case 2:
                    System.out.print("Masukkan Nama Pengguna yang akan dihapus: ");
                    String userId = scanner.nextLine();
                    removeUser(userId);
                    break;
                
                case 3:
                    if (users.isEmpty()) {
                        System.out.println("Pengguna Tidak Tersedia");
                    } else {
                        System.out.println("=== List Pengguna ===");
                        for (User us : users) {
                            System.out.println(us);
                        }   
                    }
                    break;
                    
                case 4:
                    System.out.println("Keluar Dari Manajemen Pengguna");
                    break;
                    
                default:
                    System.out.println("Pilihan Tidak Valid. Silahkan Coba Lagi");
            }
        }
        while (choice != 4);
        
    } 
    
    public void removeUser(String userId) {
        boolean userFound = false;

        // Menghapus pengguna berdasarkan ID
        for (User us : users) {
            if (us.idUser.equals(userId)) {
                users.remove(us);
                System.out.println("Pengguna dengan Nama " + userId + " telah dihapus.");
                userFound = true;
                break;
            }
        }

        if (!userFound) {
            System.out.println("Pengguna dengan Nama " + userId + " tidak ditemukan.");
        }
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
                        for (int i = 0 ; i<lawyers.size(); i++){
                            System.out.println((i+1) + ". " + lawyers.get(i).getLawyerName());
                        }
                        System.out.print("Masukkan nomor pengacara yang dihapus: ");
                        int lawyerIndex = scanner.nextInt() - 1;
                        
                        if (lawyerIndex >=0 && lawyerIndex < lawyers.size()){
                            System.out.println("Hapus Pengacara: " + lawyers.remove(lawyerIndex).getLawyerName());
                        }else {
                            System.out.println("Pilihan Tidak Valid");
                        }
                    }
                    break;
                
                case 3:
                    displaylawyer();
                    break;
                    
                case 4:
                    System.out.println("Keluar Dari Manajemen Pengacara");
                    break;
                    
                default:
                    System.out.println("Pilihan Tidak Valid. Silahkan Coba Lagi");
            }
        }
        while (choice != 4);
    }
    
    public void manageArticle(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do{
            System.out.println("\n ===Mengelola Article=== ");
            System.out.println("1. Menambahkan Article ");
            System.out.println("2. Menghapus Article");
            System.out.println("3. Melihat Article");
            System.out.println("4. Exit");
            System.out.print("Masukkan Pilihan Anda: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice){
                case 1:
                    addArticle();
                    break;
                case 2:
                    if(articles.isEmpty()){
                        System.out.println("Tidak Ada Pengacara yang di Hapus");
                    }else {
                        System.out.println("Pilih Pengacara untuk Dihapus");
                        for (int i = 0 ; i<articles.size(); i++){
                            System.out.println((i+1) + ". " + articles.get(i).getTitleArticle());
                        }
                        System.out.print("Masukkan nomor pengacara yang dihapus: ");
                        int articleIndex = scanner.nextInt() - 1;
                        
                        if (articleIndex >=0 && articleIndex < articles.size()){
                            System.out.println("Hapus Pengacara: " + articles.remove(articleIndex).getTitleArticle());
                        }else {
                            System.out.println("Pilihan Tidak Valid");
                        }
                    }
                    break;
                
                case 3:
                    diplayArticles();
                    break;
                    
                case 4:
                    System.out.println("Keluar Dari Manajemen Artikel");
                    break;
                    
                default:
                    System.out.println("Pilihan Tidak Valid. Silahkan Coba Lagi");
            }
        }
        while (choice != 4);
    }

    @Override
    public void register(String idUser, String emailUser, String password) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    

    
}