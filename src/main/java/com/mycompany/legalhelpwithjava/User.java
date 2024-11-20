package com.mycompany.legalhelpwithjava;

public abstract class User {
    public String idUser;
    public String passUser;
    public String emailUser;

    public User(String idUser, String passUser, String emailUser) {
        this.idUser = idUser;
        this.passUser = passUser;
        this.emailUser = emailUser;
    }
    
    public boolean login(String idUser, String password){
        return this.idUser.equals(idUser) && this.passUser.equals(password);
    }
    
    public void logout(){
        System.out.println("User: " + idUser + " Loggout ");
    }
    
    public abstract void register (String idUser, String emailUser, String password); 
    
}