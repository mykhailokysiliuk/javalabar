package lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Variant9Test {

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 321, 3 }, {981, 9}, {295, 2}};
    }
    @Test(dataProvider = "integerProvider")
    public void integerTest(int p1, int p2) {
        assertEquals(new Variant9().integerNumbersTask(p1), p2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeIntegerTest() {
        new Variant9().integerNumbersTask(  1000);
    }

    //////////////////////////
    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, boolean p3) {
        assertEquals(new Variant9().booleanTask(p1, p2), p3);
    }
    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 5, 7, true }, { 4, 5, true }, {2, 4,  false } ,{16,30,  false } };
    }

    ////////////////////
    @Test(dataProvider = "ifProvider")
    public void ifTest(double p1, double p2, double[] p3) {
        assertEquals(new Variant9().ifTask(p1, p2), p3);
    }
    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 5.1, 7.3, new double[] { 5.1, 7.3}}, {7.3, 5.1, new double[] { 5.1, 7.3}} };
    }


    ///////////////////////
    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, int p2, int[] p3) {
        assertEquals(new Variant9().switchTask(p1, p2), p3);
    }
    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] {{ 28, 2, new int[] { 1, 3}}, {7, 5, new int[] { 8, 5}}  };
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeSwitchTest() {
        new Variant9().switchTask(  32, 13);
    }

    /////////////////////////
    @Test(dataProvider = "forProvider")
    public void forTest(int p1, int p2, int p3) {
        assertEquals(new Variant9().forTask(p1, p2), p3);
    }
    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] {{4, 6, 77}, {3, 9, 280}};
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeForTest() {
        new Variant9().forTask( 7, 2);
    }

    ////////////////////////////////
    @Test(dataProvider = "whileProvider")
    public void whileTest(int p1, int p3) {
        assertEquals(new Variant9().whileTask(p1), p3);
    }
    @DataProvider
    public Object[][] whileProvider() {
        Object[][] objects = {{30, 4}, {20, 3}};
        return objects;
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeWhileTest() {
        new Variant9().whileTask( 1);
    }

    ///////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int[] array, int n, int[] arr) {
        assertEquals(new Variant9().arrayTask(array, n), arr);
    }
    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { new int[] { 1, 2, 4, 9, 8}, 5, new int[] { 8, 4, 2, 3}},
                { new int[] { 3, 8 , 9, 6, 4, 5, 10, 7, 3, 2, 1, 12}, 12, new int[] { 12, 2, 10, 4, 6, 8, 6}}};
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeArrayTest() {
        new Variant9().arrayTask( new int[] { 1, 3, 9, 27, 81}, 0);
    }

    ///////////////////////////////////
    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int n, int m, int[][] output) {
        assertEquals(new Variant9().twoDimensionArrayTask(input, n, m), output);
    }
    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {{1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 6},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 7}};

        int[][] output = {{1, 2, 3, 4, 6},
                {1, 2, 3, 4, 7}};

        int[][] input1 = {{1, 1, 1, 1, 1},
                {7, 7, 7, 7, 7},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}};

        int[][] output1 = {{3, 3, 3, 3, 3},
                {5, 5, 5, 5, 5}};


        return new Object[][] { {input, 5, 5, output}, {input1, 5, 5, output1}};

    }


}