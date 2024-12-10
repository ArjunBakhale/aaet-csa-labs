public class BasicArrays {

    // Returns the maximum value in the given array
    public static double findMax(double[] a) {
        double result = a[0];
        for(int i = 0; i < a.length; i++) {
            if(a[i] > result) {
                result = a[i];
            }
        }
        return result;
    }

    // Returns the minimum value in the given array
    public static double findMin(double[] a) {
        double result = a[0];
        for(int i = 0; i < a.length; i++) {
            if(a[i] < result) {
                result = a[i];
            }
        }
        return result;
    }

    // Returns the index of the maximum value in the given array
    public static int argMax(double[] a) {
        double max = a[0];
        int result = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] > max) {
                max = a[i];
                result = i;
            }
        }
        return result;
    }

    // Returns the index of the minimum value in the given array
    public static int argMin(double[] a) {
        double min = a[0];
        int result = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] < min) {
                min = a[i];
                result = i;
            }
        }
        return result;
    }

    // Counts the number of occurrences of the given target value in the array
    public static int count(double[] a, double target) {
        int result = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] == target) {
                result++;
            }
        }
        return result;
    }

    // Returns the index of the first occurrence of the given target value in the array, or -1 if not found
    public static int findFirst(double[] a, double target) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Returns the second largest value in the given array
    public static double findSecondLargest(double[] a) {
        double biggest = a[0];
        double secondBiggest = a[0];
        for(int i = 0; i < a.length; i++) {
            if(a[i] > biggest) {
                secondBiggest = biggest;
                biggest = a[i];
            } else if(a[i] > secondBiggest && a[i] != biggest) {
                secondBiggest = a[i];
            }
        }
        return secondBiggest;
    }

    // Returns the element in the array that is closest to the target value
    public static double findClosest(double[] a, double target) {
        double closest = a[0];
        double diff = Math.abs(a[0] - target);
        for(int i = 0; i < a.length; i++) {
            if(Math.abs(a[i] - target) < diff) {
                closest = a[i];
                diff = Math.abs(a[i] - target);
            }
        }
        return closest;

    }

    // Returns the values of the two elements in the array that are closest in value
    public static double[] findClosestPair(double[] a) {
        double[] result = new double[2];
        double diff = Math.abs(a[0] - a[1]);
        result[0] = a[0];
        result[1] = a[1];
        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                if(Math.abs(a[i] - a[j]) < diff) {
                    result[0] = a[i];
                    result[1] = a[j];
                    diff = Math.abs(a[i] - a[j]);
                }
            }
        }
        return result;
    }

    // Swaps the elements at the given indices in the array
    public static void swap(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // returns a string contatining each element in the array
    public static String arrayToString(double[] a) {
        String result = "";
        for(int i = 0; i < a.length; i++) {
            result += a[i] + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        double[] nums = {5.2, -3.1, 8.7, -1.9, 6.4, 4.3, 5.2, -2.0};

        System.out.println("findMax: " + findMax(nums)); // Output: 8.7
        System.out.println("findMin: " + findMin(nums)); // Output: -3.1
        System.out.println("argMax: " + argMax(nums)); // Output: 2
        System.out.println("argMin: " + argMin(nums)); // Output: 1
        System.out.println("count(5.2): " + count(nums, 5.2)); // Output: 2
        System.out.println("count(-2.0): " + count(nums, -2.0)); // Output: 1
        System.out.println("findFirst(6.4): " + findFirst(nums, 6.4)); // Output: 4
        System.out.println("findFirst(-2.0): " + findFirst(nums, -2.0)); // Output: 7
        System.out.println("findSecondLargest: " + findSecondLargest(nums)); // Output: 6.4
        System.out.println("findClosest(3.0): " + findClosest(nums, 3.0)); // Output: 4.3
        System.out.println("findClosestPair: " + arrayToString(findClosestPair(nums))); // Output:
        swap(nums, 0, 6);
        System.out.println("After swap: " + arrayToString(nums));
    }
}
