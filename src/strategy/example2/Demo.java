package strategy.example2;

public class Demo {

    public static void main(String[] args) {
        int[] a = {4, 2, 3, 6};
        BubbleSorter bubbleSorter = new BubbleSorter(new IntSortHandler());
        int b = bubbleSorter.sort(a);
        System.out.println(b);

        QuickBubbleSorter quickBubbleSorter = new QuickBubbleSorter(new IntSortHandler());
        b = quickBubbleSorter.sort(a);
        System.out.println(b);

        double[] doublesArray = {1.25, 1.27, 2.31, 0.96, 2, 3};
        QuickBubbleSorter quickBubbleSorterForDoubles = new QuickBubbleSorter(new DoubleSortHandler());
        int numberOfActions = quickBubbleSorterForDoubles.sort(doublesArray);

        System.out.println(numberOfActions);
        for (Double d:doublesArray) {
            System.out.println(d);
        }
    }
}
