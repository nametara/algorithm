import java.util.Arrays;

/*
 The Gini coefficient measures wealth inequality in a society.
 It ranges from 0 to 1.

 0  -> Everyone has equal wealth
 1  -> One person owns all wealth

 Lower values mean more equal distribution.
 Higher values mean greater inequality.

 In 2022, the global average Gini coefficient was about 0.44.
 When it reaches 0.5, inequality is considered severe,
 often leading to social issues such as crime or unrest.
*/
public class GiniCoefficient {
  public static void main(String[] args) {
    System.out.println("=== Gini Coefficient Simulation ===");

    int population = 100;
    int rounds = 1_000_000;

    System.out.println("Population: " + population);
    System.out.println("Rounds: " + rounds);

    System.out.println("\nStarting simulation...");
    experiment(population, rounds);
    System.out.println("Simulation complete.");
  }

  /*
  Experiment Description:

  We start with 100 people, each holding 100 units of wealth.

  In every round:
  - Each person randomly gives 1 unit to another person (self excluded).
  - If a person’s wealth reaches 0, they stop giving.
  - Instead, they are allowed to receive wealth from others.

  This process repeats for many rounds.

  Goal:
  Observe the long-term distribution of wealth.
  */
  public static void experiment(int population, int rounds) {
    // initialize 100 people with 100 in hands
    double[] wealth = new double[population];
    Arrays.fill(wealth, 100);
    boolean[] hasMoney = new boolean[population];

    for (int i = 0; i < rounds; i++) {
      // check for current wealth
      Arrays.fill(hasMoney, false);
      for (int j = 0; j < population; j++) {
        if (wealth[j] > 0) {
          hasMoney[j] = true;
        }
      }
      // give away randomly if has money in hands
      for (int j = 0; j < population; j++) {
        if (hasMoney[j]) {
          int other = j;
          do {
            // (int) (Math.random() * population) -> [0 ~ population)
            other = (int) (Math.random() * population);
          } while (other == j);
          wealth[j]--;
          wealth[other]++;
        }
      }
    }

    Arrays.sort(wealth);
    System.out.println("List in order of current wealth: ");
    for (int i = 0; i < population; i++) {
      System.out.print((int) wealth[i] + "\t");
      if (i % 10 == 9) {
        System.out.println();
      }
    }
    System.out.println();
    System.out.println("The Gini Coefficient after experiment: " + calculateGini(wealth));
  }

  public static double calculateGini(double[] wealth) {
    double totalWealth = 0;
    double totalWealthDifference = 0;
    int n = wealth.length;
    for (int i = 0; i < n; i++) {
      totalWealth += wealth[i];
      for (int j = 0; j < n; j++) {
        totalWealthDifference += Math.abs(wealth[i] - wealth[j]);
      }
    }
    return totalWealthDifference / (2 * n * totalWealth);
  }
}
