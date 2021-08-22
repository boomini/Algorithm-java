package solution.programmers;

import java.util.Arrays;

class Solution2 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int N = lost.length;
        int M = reserve.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int cnt = n-N;
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(lost[i]==reserve[j]) {
        			
        			reserve[j]=-1;
        			lost[i] = -1;
        			cnt++;
        			break;
        		}
        	}
        }
        for(int i=0; i<N; i++) {
        	int lostSt = lost[i];
        	if(lostSt==-1) continue;
        	for(int j=0; j<M; j++) {  		
        		int resSt = reserve[j];
        		if(resSt == -1)continue; // �̹� ������ ü�����̸�
        		if(lostSt-1==resSt) {
        			//�� ����ȣ�� ü������ ������ ���� ��
        			reserve[j]=-1;
        			cnt++;
        			break;
        		}
        		if(lostSt==resSt) {
        			//���� ������ ���� ��,
        			reserve[j]=-1;
        			cnt++;
        			break;
        		}
        		if(lostSt+1==resSt) {
        			reserve[j]=-1;
        			cnt++;
        			break;
        		}
        		//�� ������ȣ�� ������ ���� ��
        	}
        }
        return cnt;
    }
}
public class level1_42862 {

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		System.out.println(sol.solution(5,new int[] {2,4},new int[] {3,1}));
		//System.out.println(sol.solution(5,new int[] {2,4},new int[] {3}));
		//System.out.println(sol.solution(3,new int[] {3},new int[] {1}));
	}
	
}
