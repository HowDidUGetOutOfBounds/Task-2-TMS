package Lesson4;

/*
Есть два отсортированных массива. Нужно объединить их в 1,
который также будет отсортированный. Пузырек и другие алгоритмы
сортировки сложности O(n^2) использовать нельзя
 */

public class ArrayMerge {
    public static void main(String[] args) {

        //it can be any sized arrays
        int a[] = {1, 6, 9, 25, 88};
        int b[] = {4, 7, 15, 24};

        int res[] = sortedArrayMerge(a, b);

        //put breakpoint here to check result array
        System.out.println("Finish");

    }

    private static int[] sortedArrayMerge(int a[], int b[]) {
        int result[] = new int[a.length +b.length];
        int i =0; int j = 0; int k = 0;
        while(i<a.length && j <b.length) {
            if(a[i]<b[j]) {
                result[k++] = a[i];
                i++;
            } else {
                result[k++] = b[j];
                j++;
            }
        }

        while((i < a.length || j < b.length) && k < result.length)
        {
            if(i < a.length)
            {
                result[k++]= a[i];
                i++;
            }
            else
            {
                result[k++] = b[j];
                j++;
            }
        }

        return result;
    }
}
