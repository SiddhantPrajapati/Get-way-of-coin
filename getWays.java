/* We have input values of N and an array Coins  that holds all of the coins. We use data type
of long because we want to be able to test large values without integer overflow*/
import java.util.*;
class getWays {
 
    static long getNumberOfWays(long N, long[] Coins)
    {
        // Create the ways array to 1 plus the amount
        // to stop overflow
        long[] ways = new long[(int)N + 1];
 
        // Set the first way to 1 because its 0 and
        // there is 1 way to make 0 with 0 coins
        ways[0] = 1;
 
         // Go through all of the coins
        for (int i = 0; i < Coins.length; i++) {
 
            // Make a comparison to each index value
            // of ways with the coin value.
            for (int j = 0; j < ways.length; j++) {
                if (Coins[i] <= j) {
      
                    // Update the ways array
                    ways[j] += ways[(int)(j - Coins[i])];
                }
            }
        }
 
        // return the value at the Nth position
        // of the ways array.   
        return ways[(int)N];
    }
 
    static void printArray(long[] coins)
    {
        for (long i : coins)
            System.out.println(i);
    }
 
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		System.out.println("No of Coins:");
		int no = sc.nextInt();
		long Coins[] = new long[no];
		for(int i = 0 ; i < no ; i++) {
			System.out.print("Enter " + (i+1) + "coin:");
			Coins[i] = sc.nextLong();
		}
        System.out.println("Which currency you want to make:");
		long cur = sc.nextLong();
        System.out.println("The Coins Array:");
        printArray(Coins);
 
        System.out.println("Solution:");
        System.out.println(getNumberOfWays(cur, Coins));
    }
}