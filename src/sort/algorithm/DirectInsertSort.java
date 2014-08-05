package sort.algorithm;
/**
 * 比较逻辑:i控制排序范围，j控制插入位置
 * 当i-1的值比i大,则i的值替换为i-1的值,
 * 当i-2的值比i-1大,则i-1的值替换为i-2的值
 * 于是，用j=i-1表示插入位置，循环条件是j>=0(到达最后一个了)或者j(i-1)的值比j+1(i)的值要小,则循环终止(排序按小到大)
 * 循环终止后，最后一次替换的位置为循环结束后的j,如最后是3的位置值比i的值小，循环终止，则j=3,不进行替换，则原来的i的值就存放在3+1=4.因为4之前已经放到5了.
 */
public class DirectInsertSort {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int data[] = { 2, 6, 10, 3, 9, 80, 1, 16, 27, 20 };
        int temp, j;
        for (int i = 1; i < data.length; i++) {
            temp = data[i];
            j = i - 1;
            // 每次比较都是对于已经有序的
            // 每次都跟前一个作比较，如果比较结果是data[i-1]比data[i]要小，那么就不用比了，data[j+1]实际上也还是data[i]而已
            // 如果比较结果是data[i-1]比data[i]要大，那么就两个位置替换，temp的值去到data[j]即data[i-1]，然后循环继续
            // 如果继续循环比较的结果是data[i-2]比data[i-1](temp)要小，那么就不用比了，在data[i]这个级别已经排好序了
            
            while (j >= 0 && data[j] > temp) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;//这一步的操作，不管是在循环里面，还是循环外面，都没有影响，因为比较用的是temp值
            				   //现在的做法不过是，比较结果符合的时候，data[j-1]的值复制了一份到data[j]了，但是data[j-1]的值没有被更新为data[j]的值
            				   //这个不影响，因为下一次判断的已经是data[j-2]的值了，如果比较结果符合，那么data[j-1]的值也会被覆盖为data[j-2]的值
            				   //所以，这一步放到循环外边做，也没有问题，只不过是等循环到最后一个不符合条件的，那么就把最后一个符合条件的值更新为temp好了。
        }
        // 输出排序好的数据
        for (int k = 0; k < data.length; k++) {
            System.out.print(data[k] + "  ");
        }
    }
}