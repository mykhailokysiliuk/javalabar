package lab0;

public class Variant9 {

    /*Given a three-digit number. Using a single integer division operation,
    output the first digit of the given number (hundreds).*/
    public static int integerNumbersTask(int a) {
        if (a < 100 || a > 999) {
            throw new IllegalArgumentException("99 < a < 1000");
        }
        return a/100;
    }

    /*Two integers are given: A ,  B . Check the truth of the statement: "At least one of the numbers  A and  B is odd."*/
    public boolean booleanTask(int a, int b) {
        return ((a % 2 != 0) || (b % 2 != 0));
    }

    /*Given two variables of real type:  A ,  B . Redistribute the values of these variables so that
    A has the smallest of the values, and  B has the  larger one.
    Output new values of variables  A and  B .*/
    public double[] ifTask(double a, double b) {
        double []arr = new double[2];
        double k;
        if(a>b){
            k = a;
            a = b;
            b = k;
        }
        arr[0] = a;
        arr[1] = b;
        return arr;
    }
    /*Given two integers,  D (day) and  M (month), specifying the correct date for a non-leap year.
    Print the  D and  M values for the date following the specified one.*/

    public int[] switchTask(int d, int m) {
        if ((d < 1 || d > 31)||(m < 1 || m > 12)) {
            throw new IllegalArgumentException("date is not correct");
        }
        int []arr = new int[2];
        String result = "";
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (d==31) d=0;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (d==30) d=0;
                break;
            case 2:
                if (d==28) d=0;
                break;
        }

        if (d==0)
            if (m==12) m=1;
            else m++;

        d++;
        arr[0] = d;
        arr[1] = m;

        return arr;
    }

    /*Two integers  A and  B are given ( A  <  B ). Find the sum of squares of all integers from  A to  B inclusive.*/
    public float forTask(int a, int b) {
        int sum = 0;
        if(a > b){
            throw new IllegalArgumentException("you should enter a < b");
        }
        for(int i = a; i <= b;i++){
            sum += i*i;
        }
        return sum;
    }

    /*An integer  N (> 1) is given. Find the smallest integer  K that satisfies the inequality 3 K  >  N .*/

    public int whileTask(int n) {
        if(n <= 1){
            throw new IllegalArgumentException("n > 1");
        }
        int k = 0;
        while(Math.pow(3, k)<n){
            k++;
        }
        return k;
    }
    /*An integer array of size  N is given .
    Output all even numbers contained in this array in descending order of their indices,
    as well as their number  K .*/

    public int[] arrayTask(int[] array, int n) {
        if(n <= 0){
            throw new IllegalArgumentException("n > 0");
        }
        int k = 0, m = 0;
        for(int i = 0; i < n ; i++){
            if (array[i] % 2 == 0) {
                k++;
            }
        }
        int[] arr = new int[k+1];
        for(int i = n-1; i >= 0; i--){
            if (array[i] % 2 == 0) {
                arr[m] = array[i];
                m++;
            }
        }
        arr[m] = k;
        return arr;
    }

    /*Given a matrix of size  M  ґ  N . Output its elements located in lines with even numbers (2, 4, ...).
    Display elements line by line, do not use a conditional operator.*/
    public static int[][]  twoDimensionArrayTask(int[][] array, int n, int m) {
        int l = 0;
        if (n % 2 == 0) {
            l = n/2-1;
        }
        else l = n/2;
        int k = 0;
        int[][] matrix = new int[l][n];
        for(int i = 2; i < n; i = i + 2){
            for(int j = 0; j < m; j++){
                matrix[k][j] = array[i][j];

            }
            k++;
        }

        return matrix;
    }

    public static void main(String... strings) {

        System.out.println("Done!!!");
    }
}