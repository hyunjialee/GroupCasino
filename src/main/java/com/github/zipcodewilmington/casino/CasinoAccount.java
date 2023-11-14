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

    public CasinoAccount (String name, String password) {
        this.name = name;
        this.password = password;
        this.balance = 1000;
    }
    public String getName() {
        return name;
    }
    public String setName() {
        return this.name;
    }
    public String getPassword(){
        return password;
    }
    public String setPassword(){
        return this.password;
    }
    public int getBalance(){
        return balance;
    }
    public int setBalance(){
        return this.balance;
    }
    public String toString(){
        return "Account Name: " + name;
    }
}
