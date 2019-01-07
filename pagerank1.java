import java.util.Arrays;
import java.util.Scanner;

public class pagerank1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int[][] b = new int[a][a];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                b[i][j] = input.nextInt();
            }
        }
        pagerank(b);
    }
    public static void pagerank(int[][] a){
        double[] v = new double[a.length];
        double[] rank = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1){
                    count++;
                }
            }
            if (count != 0){
                v[i] =(double)((1/(double)a.length)/(double)count);
            }
            else
                v[i] = 0;

        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j][i] == 1){
                        rank[i] = v[j] + rank[i];
                }
            }
        }
        Arrays.sort(rank);
        for (int i = 0; i <rank.length ; i++) {
            System.out.println(rank.length - i + " rank is of " + rank[i]);
        }
    }
}
