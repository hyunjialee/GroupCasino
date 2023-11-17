package com.github.zipcodewilmington.casinoAccountTests;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class CasinoAccountTest {
    CasinoAccount account = new CasinoAccount("bob", "builder",2000);

    @Test
    public void testGetName() {
        String expected = "bob";
        String actual = account.getName();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetName2() {
        String expected = "the";
        String actual = account.getName();

        Assert.assertNotEquals(expected, actual);

    }

    @Test
    public void testSetName() {
        String expected = "the";
        account.setName("the");
        String actual = account.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPassword() {
        String expected = "builder";
        String actual = account.getPassword();

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetPassword2() {
        String expected = "yeshecan";
        String actual = account.getPassword();

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void testSetPassword() {
        String expected = "canhebuildit";
        account.setPassword("canhebuildit");
        String actual = account.getPassword();

        Assert.assertEquals(expected, actual );
    }

    @Test
    public void testGetBalance() {
        int expected = 2000;
        int actual = account.getBalance();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSetBalance() {
        int expected = 500;
        account.setBalance(500);
        int actual = account.getBalance();

        Assert.assertEquals(expected, actual);

    }
}