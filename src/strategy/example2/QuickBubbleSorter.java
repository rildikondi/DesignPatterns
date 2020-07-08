package strategy.example2;

public class QuickBubbleSorter {
    private int operations = 0;
    private int length = 0;
    private SortHandler itsSortHandler = null;

    public QuickBubbleSorter(SortHandler handler) {
        itsSortHandler = handler;
    }

    public int sort(Object array) {
        itsSortHandler.setArray(array);
        length = itsSortHandler.length();
        operations = 0;
        if (length <= 1)
            return operations;
        boolean thisPassInOrder = false;
        for (int nextToLast = length - 2;
             nextToLast >= 0 && !thisPassInOrder; nextToLast--) {
            thisPassInOrder = true; //potenially.
            for (int index = 0; index <= nextToLast; index++) {
                if (itsSortHandler.outOfOrder(index)) {
                    itsSortHandler.swap(index);
                    thisPassInOrder = false;
                }
                operations++;
            }
        }
        return operations;
    }
}