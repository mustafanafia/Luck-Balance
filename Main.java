import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY contests
     */

    public static int luckBalance(int k, List<List<Integer>> contests) {
        // Write your code here

        Collections.sort(contests, new Comparator<  List<Integer>  >() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return -1 * o1.get(0).compareTo(o2.get(0));
            }
        });



        int luck_balance = 0;


        for(int i=0; i< contests.size(); i++){

            int luck = contests.get(i).get(0);
            int importance = contests.get(i).get(1);

            if(importance == 1 && k > 0 ){
                k--;
                luck_balance += luck;
            }

            else if (importance == 1 && k==0){
                luck_balance -=luck;
            }

            if(importance == 0){
                luck_balance += luck;
            }
        }

        return luck_balance;



    }

}



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> contests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] contestsRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> contestsRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowTempItems[j]);
                contestsRowItems.add(contestsItem);
            }

            contests.add(contestsRowItems);
        }

        int result = Result.luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
