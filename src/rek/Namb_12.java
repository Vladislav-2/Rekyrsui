package rek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Namb_12 {
    public static void namb_12 () throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] params1 = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(params1[0]);
        int m = Integer.parseInt(params1[1]);
        int[][] A = new int[n][m];
        int o = 0;
        if (o < n)	{
            o++;
            rek(bufferedReader, m, o, A);
        }
        for (int i=1; i<n; i++)	{
            A[i][0]+=A[i-1][0];
        }
        for (int i=1; i<m; i++)	{
            A[0][i]+=A[0][i-1];
        }
        for (int i=1; i<n; i++)	{
            for (int j=1; j<m; j++) {
                A[i][j]+=Math.min(A[i-1][j],A[i][j-1]);
            }
        }
        System.out.println(A[n-1][m-1]);
    }

    public static void rek(BufferedReader bufferedReader, int m, int i, int[][] A) throws  Exception{
        String[] params2 = bufferedReader.readLine().split(" ");
        int j = 0;
        if (j < m)	{
            j++;
            rek_2(A,i,j,params2);
        }
        rek(bufferedReader, m, i, A);
    }

    public static void rek_2(int[][] A, int i, int j, String[] params2){
        A[i][j] = Integer.parseInt(params2[j]);
        rek_2(A,i,j,params2);
    }
}
