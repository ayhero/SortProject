package sort.algorithm;
public class ShellSort {
    public static void main(String[] args) {
        int a[] = { 1, 54, 6, 3, 78, 34, 12, 45, 56, 100 };
        double d1 = a.length;
        int temp = 0;
        while (true)
        {
            //利用这个在将组内倍数减小
            //这里依次为5,3,2,1
            d1 = Math.ceil(d1 / 2);
            //d为增量每个分组之间索引的增量
            int d = (int) d1;
            //每个分组内部排序
            for (int x = 0; x < d; x++)
            {
                //组内利用直接插入排序
                for (int i = x + d; i < a.length; i += d) {
                    int j = i - d;
                    temp = a[i];
                    for (; j >= 0 && temp < a[j]; j -= d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
                                                                                                                                     
            if (d == 1)
                break;
        }
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]+"  ");
    }
}