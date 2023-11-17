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
    CasinoAccount account = new CasinoAccount("john", "meloveulongtime", 1000);

    @Test
    public void testCreateAccount(){
        Object actual = manager.createAccount("john", "meloveulongtime");
        Object expected = account;

        Assert.assertEquals(actual, expected);

    }
    @Test
    public void testCreateAccount2(){
        Object actual = manager.createAccount("meloveulongtime", "john");
        Object expected = account;

        Assert.assertNotEquals(actual, expected);

    }
    @Test
    public void testRegisterAccount(){

        Object actual = casinoAccountList.add(account);
        Object expected = casinoAccountList.contains(account);
        //didn't make a get method sorry, not sorry
        Assert.assertEquals(expected, actual);

    }
}
