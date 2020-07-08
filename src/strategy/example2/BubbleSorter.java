package strategy.example2;

public class BubbleSorter {
    private int operations = 0;
    private int length = 0;
    private SortHandler itsSortHandler = null;

    public BubbleSorter(SortHandler handler) {
        itsSortHandler = handler;
    }

    public int sort(Object array) {
        itsSortHandler.setArray(array);
        length = itsSortHandler.length();
        operations = 0;
        if (length <= 1)
            return operations;
        for (int nextToLast = length - 2;
             nextToLast >= 0; nextToLast--)
            for (int index = 0; index <= nextToLast; index++) {
                if (itsSortHandler.outOfOrder(index))
                    itsSortHandler.swap(index);
                operations++;
            }
        return operations;
    }
}
