package com.mycompany.legalhelpwithjava;

public class ConsultantService {
    private String lawyerName;
    private double price;
    private int duration;
    private String description;

    public ConsultantService(String lawyerName, double price, int duration, String description) {
        this.lawyerName = lawyerName;
        this.price = price;
        this.duration = duration;
        this.description = description;
    }

    
    
    public String getLawyerName() {
        return lawyerName;
    }

    public double getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
    
    public void displayService(){
        System.out.println("Nama Pengacara: " + lawyerName);
        System.out.println("Harga: Rp" + price);
        System.out.println("Duration: " + duration + "Menit");
        System.out.println("Description: " + description);
    }
}
