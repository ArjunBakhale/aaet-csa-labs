public class semiSort {
    public static void swapij(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static double[] semisort(double[] arr) {

    }

    public static void main(String[] args) {
        double[] arr = {5, 3, 8, 9, 1, 4, 2, 7, 6};
        double[] sorted = semisort(arr);
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
        }
        System.out.println();
    }

}
