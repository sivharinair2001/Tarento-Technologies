public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {24, 4, 67, -2, 67, 3, 100, 90, 87};

        System.out.println("Original array:");
        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.println();

        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i ; j++) {
                if (arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Sorted array:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
