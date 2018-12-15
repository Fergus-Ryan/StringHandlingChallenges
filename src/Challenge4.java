
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Challenge4 {
	public static int solution(String S) {
        // write your code in Java SE 8
		
		ArrayList<String> lines = new ArrayList<String>();
		Scanner sc = new Scanner(S);
		
		while (sc.hasNextLine()) {
			lines.add(sc.nextLine());
		}
		
		sc.close();
		
		ArrayList<String> numbers = new ArrayList<String>();
		int[] lengths = new int[lines.size()];
		int[] costs = new int[lines.size()];
		
		for(String line : lines) {
			String number = line.split(",")[1];
			String[] time = line.split(",")[0].split(":");
			int numSeconds = Integer.parseInt(time[0])*60*60 + Integer.parseInt(time[1])*60 + Integer.parseInt(time[2]);
			int cost = 0;
			
			if(numSeconds < 300) {
				cost = numSeconds * 3;			
			}else {
				if (numSeconds%60 == 0) {
					cost = numSeconds/60*150;
				}else {
					cost = (numSeconds/60*150) + 150;
				}
			}
			
			if(numbers.contains(number)) {
				int index = numbers.indexOf(number);
				lengths[index] += numSeconds;
				costs[index] += cost;
			}else {
				numbers.add(number);
				int index = numbers.indexOf(number);
				lengths[index] = numSeconds;
				costs[index] = cost;
			}
		}
		int maxIndex = 0;
		int maxLen = 0;
		for(String num : numbers) {
			int index = numbers.indexOf(num);
			if(lengths[index] > maxLen) {
				maxIndex = index;
				maxLen = lengths[index];
			}
		}
		System.out.println(numbers.get(maxIndex));
		System.out.println(Arrays.toString(costs));
		System.out.println(Arrays.toString(lengths));
		System.out.println(numbers);
		
		return IntStream.of(costs).sum() - costs[maxIndex];
    }
}
