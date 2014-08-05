package sort.algorithm;
//折半插入排序
/**
 * 算法逻辑:
 * low-最小边界
 * height-最大边界
 * mid-中间
 * 如第i个，则以i-1为最大边界
 * low默认都是0开始
 * while循环比较:每次循环计算mid=(low+height)/2,然后判断i的值是否比mid的值要小,是则更新最大边界，否则更新最小边界
 * 当low=height时,表明插入位置找到了，则循环把low+1后的值全部后移
 *
 */
public class HalfInsertSort {
    public static void main(String[] args) {
        int data[] = { 2, 6, 10, 3, 9, 80, 1, 16, 27, 20 };
        // 存放临时要插入的元素数据
        int temp;
        int low, mid, high;
        for (int i = 1; i < data.length; i++) {
            temp = data[i];
            // 在待插入排序的序号之前进行折半插入
            low = 0;
            high = i - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (temp < data[mid])
                    high = mid - 1;
                else
                    // low=high的时候也就是找到了要插入的位置，
                    // 此时进入循环中，将low加1，则就是要插入的位置了
                    low = mid + 1;
            }
            // 找到了要插入的位置，从该位置一直到插入数据的位置之间数据向后移动
            for (int j = i; j >= low + 1; j--)
                data[j] = data[j - 1];
            // low已经代表了要插入的位置了
            data[low] = temp;
        }
        for (int k = 0; k < data.length; k++) {
            System.out.print(data[k] + "  ");
        }
    }
}