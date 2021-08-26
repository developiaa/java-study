import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        //2차원 배열 선언
        int[][] arr;
        arr = new int[2][5];

        int[][] arr2 = new int[3][5];

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(Arrays.toString(arr2[i]));
        }

        // 구구단 예제
        int[][] arr3 = new int[8][9];

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 9; j++) {
                arr3[i - 2][j - 1] = i * j;
            }
        }

        for (int i = 0; i < arr3.length; i++) {
            System.out.print((i + 2) + "단 " + Arrays.toString(arr3[i]));
            System.out.println();
        }


    }

}
