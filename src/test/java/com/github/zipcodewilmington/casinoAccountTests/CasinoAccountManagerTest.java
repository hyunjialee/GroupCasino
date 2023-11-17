package com.github.zipcodewilmington.casinoAccountTests;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CasinoAccountManagerTest {

    CasinoAccountManager manager = new CasinoAccountManager();

    List<CasinoAccount> casinoAccountList;
    CasinoAccount account = new CasinoAccount("john", "pass", 1000);

    @Test
    public void testCreateAccount(){
        Object actual = manager.createAccount("john", "pass");
        Object expected = account;

        Assert.assertNotNull(actual);

    }
    @Test
    public void testCreateAccount2(){
        Object actual = manager.createAccount("pass", "john");
        Object expected = account;

        Assert.assertNotEquals(actual, expected);

    }
    @Test
    public void testRegisterAccount(){

        Object actual = manager.createAccount("pass", "john");
        Object expected = account;
        Assert.assertNotEquals(actual, expected);
    }
}
