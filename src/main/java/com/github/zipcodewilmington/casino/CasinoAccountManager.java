package com.github.zipcodewilmington.casino;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    private List<CasinoAccount> casinoAccountList;

    public CasinoAccountManager(){
        this.casinoAccountList = new ArrayList<>();
        readFile();
    }
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        for (CasinoAccount account : casinoAccountList){
            if (account.getName().equals(accountName) && account.getPassword().equals(accountPassword)) {
                return account;
            }
        } return null;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword) {
        CasinoAccount newAccount = new CasinoAccount(accountName, accountPassword, 1000);
        if(this.casinoAccountList.contains(newAccount)) {
            return null;
        }
        return newAccount;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
        this.casinoAccountList.add(casinoAccount);
    }

    private void readFile() {
        try {
            String input;
            String[] elements;
            String name;
            String password;
            int balance;
            casinoAccountList = new ArrayList<>();

            // reading file
            Scanner scanner = new Scanner(new File("accounts.txt"));

            while (scanner.hasNext()) {
                // parsing file
                input = scanner.nextLine();
                elements = input.split(",");
                name = elements[0];
                password = elements[1];
                balance = Integer.parseInt(elements[2]);

                // creating account from file info
                CasinoAccount account = new CasinoAccount(name, password, balance);

                // saving account into account manager's accounts.
                casinoAccountList.add(account);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void saveToFile(){
        try {
            PrintWriter fileOut = new PrintWriter("accounts.txt");
            for(CasinoAccount a : casinoAccountList){
                fileOut.println(a.getName() + "," + a.getPassword() + "," + a.getBalance());
            }

            fileOut.close();

        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }

    }
}

