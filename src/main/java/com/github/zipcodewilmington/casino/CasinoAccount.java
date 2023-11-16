package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    private String name;
    private String password;
    private int balance;

    public CasinoAccount (String name, String password, int balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getBalance(){
        return balance;
    }
    public void setBalance(int newBalance){
        this.balance = newBalance;
    }
    public String toString(){
        return "Account Name: " + name;
    }
}

