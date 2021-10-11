package solution.baekjoon;


import java.io.*;
import java.util.*;
//�����佺�׳׽��� ü
//���� ��ﳪ�µ� ������ ���ȳ��� �˻��غ�
//���������!!!
public class s2_1929 {

    public static void main(String []args) throws Exception{
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(in.readLine(), " ");
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       boolean num[] = new boolean[M+1];
       StringBuilder sb = new StringBuilder();
       num[1] = true;
       for(int i=1; (i*i)<=M; i++){
           if(!num[i]){
               for(int j=2; i*j<=M; j++){
                   num[i*j] = true;
               }
           }
       }
       
       for(int i=N; i<=M; i++) {
    	   if(!num[i])sb.append(i).append("\n");
       }
       System.out.println(sb.toString());
    }
}
