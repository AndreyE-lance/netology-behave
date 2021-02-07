package task1;

import java.util.Iterator;
import java.util.Random;


public class Randoms implements Iterable<Integer> {
    protected Random random;
    int min, max;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return true;
            }

            public Integer next() {
                int diff = max - min;
                random = new Random();
                int i = random.nextInt(diff + 1);
                i += min;
                return i;
            }

            public void remove() {

            }
        };
    }

}