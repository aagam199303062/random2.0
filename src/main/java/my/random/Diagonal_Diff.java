import java.io.*;
import java.util.Scanner;
class Solution
{
    public static void main(String args[])
    {
        int sum1=0;
        int cop;
        int sum=0;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        cop=n-1;
        int [][] arr=new int[n][n];
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                arr[i][j]=sc.nextInt();

            }
        }
for(int i=0;i<n;++i,--cop)
       {
         sum+=arr[i][i];
         sum1+=arr[i][cop];
   }
System.out.println(Math.abs(sum1-sum)); }}
