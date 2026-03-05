package Lec005;

import Lec004.SelectBubbleInsert;

public class Validator {
  public static void main(String[] args) {
    int N = 100;
    int V = 1000;
    int testTimes = 5000;
    System.out.println("Test Start.");
    for (int i = 0; i < testTimes; i++) {
      int n = (int) (Math.random() * N);
      int[] arr = randomArray(n, V);
      int[] arr1 = copyArray(arr);
      int[] arr2 = copyArray(arr);
      int[] arr3 = copyArray(arr);
      SelectBubbleInsert sort = new SelectBubbleInsert();
      sort.selectionSort(arr1);
      sort.bubbleSort(arr2);
      sort.insertionSort(arr3);
      if (!sameArray(arr1, arr2) || !sameArray(arr1, arr3)) {
        System.out.println("Errors in Algorithm...");
        // -----------------------------------
        // You can do print some info here to
        //          debugging!!!
        // -----------------------------------
      }
    }
    System.out.println("Test Over.");
    System.out.println("Your algorithm is correct!");
  }

  // get a random array with length n
  public static int[] randomArray(int n, int v) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = (int) (Math.random() * v) + 1;
    }
    return arr;
  }

  public static int[] copyArray(int[] arr) {
    int n = arr.length;
    int[] copy = new int[n];
    for (int i = 0; i < n; i++) {
      copy[i] = arr[i];
    }
    return copy;
  }

  public static boolean sameArray(int[] arr1, int[] arr2) {
    int n = arr1.length;
    for (int i = 0; i < n; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }
}
