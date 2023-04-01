package com.softserve.edu;

import javafx.scene.layout.Priority;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest {
    private static App app;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("@BeforeClass setUpBeforeClass()");
        app = new App();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("@AfterClass tearDownAfterClass()");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("\t@Before setUp()");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\t@After tearDown()");
    }

    @Test
    public void testCorrectEmail() {
        System.out.println("\t\t@Test testCorrectEmail");
        boolean actual;
        boolean expected;

        actual = app.checkEmail("a1.bd.c1@gmail.com");
        expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIncorrectEmail() {
        System.out.println("\t\t@Test testIncorrectEmail()");
        boolean actual;
        boolean expected;
        //
        actual = app.checkEmail("@gmail");
        expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEmailStartWithLetter() {
        System.out.println("\t\t@Test testEmailStartWithLetter()");
        boolean actual;
        boolean expected;
        //
        actual = app.checkEmail("1user.name@gmail.com");
        expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEmailAtLeastTwoDomainLevels() {
        System.out.println("\t\t@Test testEmailAtLeastTwoDomainLevels()");
        boolean actual;
        boolean expected;
        //
        actual = app.checkEmail("user.name@gmail");
        expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEmailTopLevelSomainAtLeastTwoLettersLong() {
        System.out.println("\t\t@Test testEmailTopLevelSomainAtLeastTwoLettersLong()");
        boolean actual;
        boolean expected;
        //
        actual = app.checkEmail("user.name@gmail.a");
        expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEmptyString() {
        System.out.println("\t\t@Test testEmptyString()");
        boolean actual;
        boolean expected;
        //
        actual = app.checkEmail("");
        expected = false;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNull() {
        System.out.println("\t\t@Test testNull()");
        boolean actual;
        boolean expected;
        //
        actual = app.checkEmail(null);
        expected = false;
        Assert.assertEquals(expected, actual);
    }
}
