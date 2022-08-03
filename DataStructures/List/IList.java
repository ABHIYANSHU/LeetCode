package LeetCode.DataStructures.List;

public interface IList<E> {
    public boolean add(E val);
    public boolean add(E val, int index);
    public boolean remove(E val);
    public boolean remove(int index);
    public int size();
}
