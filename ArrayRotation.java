import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        if (args.length < 1) {
            System.out.println("Please provide the rotation count as a command line argument.");
            return;
        }

        int rotationCount = Integer.parseInt(args[0]);

        int[] rotatedArray = rotateArray(arr, rotationCount);

        System.out.println("Rotated Array: " + Arrays.toString(rotatedArray));
    }

    public static int[] rotateArray(int[] arr, int rotationCount) {
        int n = arr.length;
        rotationCount %= n;  // Adjust rotation count if it's greater than the array length

        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, rotationCount - 1);
        reverseArray(arr, rotationCount, n - 1);

        return arr;
    }

    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
