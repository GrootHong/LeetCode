package exercies0000;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Num  = sc.nextInt();
        int[][] pResult = new int[Num][Num];
        long start = System.currentTimeMillis();
        new Main().GetResult(Num,pResult);
        long end = System.currentTimeMillis();
        for(int i=0;i<Num;i++){
            for(int j=0;j<Num-i;j++){
                System.out.print(pResult[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("花费的时间为："+(end-start));
    }

    public void GetResult(int Num,int[][] pResult){
        if(Num<=0){
            return;
        }
        pResult[0][0] = 1;
        for(int i=1;i<Num;i++){
            pResult[i][0] = pResult[i-1][0]+i;
        }
        for(int j=1;j<Num;j++){
            for(int i=0;i<Num-j;i++){
                pResult[i][j] = pResult[i+1][j-1]+1;
            }
        }
    }
}
