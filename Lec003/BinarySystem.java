public class BinarySystem {

  public static void printBinary(int num) {
    for (int i = 31; i >= 0; i--) {
      System.out.print((num & (1 << i)) == 0 ? "0" : "1");
    }
    System.out.println();
  }

  // Notice: the largest negative number -2^3 -> -212147483648 will not work
  // due to its ~ + 1 -> himself
  public static int getNegative(int a) {
    return ~a + 1;
  }
}
