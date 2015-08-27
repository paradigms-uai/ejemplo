package exercise2;

import java.util.List;

/**
 * Created by federicodonnarumma on 8/26/15.
 */
public class EvenCounter {

    public int getHighestEvenCount(List<Integer> numbers) {
        int maxEvenCount = 0;
        int maxEven = 0;
        for(Integer number: numbers) {
            int evenCount = this.getEvenCount(number);
            if(evenCount > maxEvenCount) {
                maxEven = number;
                maxEvenCount = evenCount;
            }
        }
        return maxEven;
    }

    private int getEvenCount(Integer number) {
        int copy = number;
        int totalEven = 0;
        while (copy != 0) {
            if(copy % 10 % 2 == 0) {
                totalEven ++;
            }
            copy /= 10;
        }
        return totalEven;
    }
}
