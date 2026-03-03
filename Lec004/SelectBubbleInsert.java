package Lec004;

public class SelectBubbleInsert {

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void selectionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    int minIndex = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        int current = arr[j];
        if (current < arr[minIndex]) {
          minIndex = j;
        }
      }
      swap(arr, i, minIndex);
    }
  }

  public static void bubbleSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    for (int end = arr.length - 1; end > 0; end--) {
      for (int i = 0; i < end; i++) {
        if (arr[i] > arr[i + 1]) {
          swap(arr, i, i + 1);
        }
      }
    }
  }

  public static void insertionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    for (int i = 1; i < arr.length; i++) {
      for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
        swap(arr, j, j + 1);
      }
    }
  }
}
