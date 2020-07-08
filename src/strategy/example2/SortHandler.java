package strategy.example2;

public interface SortHandler
{
    void swap(int index);
    boolean outOfOrder(int index);
    int length();
    void setArray(Object array);
}
