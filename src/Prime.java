import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Prime {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        int upperBound = Integer.parseInt(args[0]);
        long start = System.currentTimeMillis();

        System.out.println( IntStream.range(0, upperBound)
                .filter(i ->isPrime(i)).boxed()
                .collect(Collectors.toList())
                .size() );
        long timeOne = System.currentTimeMillis();
        System.out.println(timeOne-start);

        System.out.println( IntStream.range(0,upperBound)
                .parallel()
                .filter(i->isPrime(i)).boxed()
                .collect(Collectors.toList())
                .size() );
        long timeTwo = System.currentTimeMillis();
        System.out.println(timeTwo-timeOne);

        var seqList = new LinkedList<Integer>();
        IntStream.range(0, upperBound)
                .filter(i-> isPrime(i)).boxed()
                .forEach(i -> seqList.add(i));
                System.out.println(seqList.size() );
        long timeThree = System.currentTimeMillis();
        System.out.println(timeThree-timeTwo);


        var list = new LinkedList<Integer>();
                IntStream.range(0, upperBound)
                .parallel()
                .filter(i-> isPrime(i)).boxed()
                .forEach(i -> list.add(i));
                System.out.println(list.size());
        long timeFour = System.currentTimeMillis();
        System.out.println(timeFour-timeThree);

        var set = new HashSet<Integer>();
        IntStream.range(0, upperBound)
                .parallel()
                .filter(i-> isPrime(i)).boxed()
                .forEach(i -> set.add(i));
        System.out.println(set.size());
        ///this is a space to test git on my mac
        //another space to see commit push

    }

    private static boolean isPrime(final int pNumber) {
        int counter = 0;
        for (int divisor = 1; divisor <= pNumber; ++divisor) {
            if (((pNumber % divisor) == 0) && (++counter > 2)) {
                return false;
            }
        }
        return true;
    }
}
