import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static String counterGame(long n) {
        // Write your code here
            int chance = 0;
            chance = recursion(n, chance);
        
            //Below commented approach is non recursive way.
            // while(true){
            //     long tempN = n;
            //     if(isPowerOfTwo(n)){
            //         n = n/2;
            //     }else{
            //         for(long i=n-1;i>=2;i--){
            //             if(isPowerOfTwo(i)){
            //                 n = n - i;
            //                 break;
            //             }
            //         }
            //     }
            //     if(n == 1){
            //         break;
            //     }
            //     chance = (chance == 0) ? 1 : 0;
            //     if (tempN == n){
            //         break;
            //     }
            // }

            return (chance == 0) ? "Louise" : "Richard";
        }

        public static int recursion(long n, int chance){
            if(n==1){
                return (chance == 0) ? 1 : 0;
            }


            if(isPowerOfTwo(n)){
                chance = (chance == 0) ? 1 : 0;
                return recursion(n/2, chance);
            }else if(n>1){
                long powerOf2JustBeforeN = findPowerOf2JustBeforeN(n);
                chance = (chance == 0) ? 1 : 0;
                return recursion(n-powerOf2JustBeforeN, chance);
            }else{
                return chance = (chance == 0) ? 1 : 0;
            }
        }
        
        public static boolean isPowerOfTwo(long n){
            
            double log2 = (Math.log(n) / Math.log(2));
            long longOfLog2 = (long) log2;
            return (log2 == longOfLog2);
            
            //Below are two ways to check if a number is power of two or not.
            // return (n & (n-1)) == 0;
            // while(n%2==0){
            //     n=n/2;
            // }
            // if(n==1){
            //     return true;
            // }else{
            //     return false;
            // }
        }

        public static long findPowerOf2JustBeforeN(long n){
            String binaryStrOfNum = Long.toBinaryString(n);
            return (long) Math.pow(2,(binaryStrOfNum.length()-1));
        }

}

class Solution {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // int t = Integer.parseInt(bufferedReader.readLine().trim());

        // IntStream.range(0, t).forEach(tItr -> {
        //     try {
        //         long n = Long.parseLong(bufferedReader.readLine().trim());

                //String result = Result.counterGame(n);
                String result = Result.counterGame(1560834904l);
                System.out.println(result);
                // double log2 = (Math.log(1560834903l) / Math.log(2));
                // long longOfLog2 = (long) log2;
                // System.out.println((Math.pow(2,(Math.log(1560834903l) / Math.log(2)))) == (double)1560834903l);
                // System.out.println(log2 == longOfLog2);

        //         bufferedWriter.write(result);
        //         bufferedWriter.newLine();
        //     } catch (IOException ex) {
        //         throw new RuntimeException(ex);
        //     }
        // });

        // bufferedReader.close();
        // bufferedWriter.close();
    }
}
