package sort.algorithm;

public class CountSort {

	public static void main(String[] args) {
		int data[] = { 1, 54, 6, 3, 78, 34, 12, 45, 56, 100 };
        int[] tmp = new int[101];
        int[] des = new int[data.length]; 
        for (int i = 0; i < data.length; i++) {
            tmp[data[i]] += 1;
        }
        for (int j = 1; j < 101; j++) {
            tmp[j] += tmp[j - 1];
        }
        for (int k = data.length - 1; k >= 0; k--) {
            des[tmp[data[k]] - 1] = data[k];
            tmp[data[k]] -= 1;
        }
        for(int i : des){
        	System.out.println(i);
        }
	}
}
