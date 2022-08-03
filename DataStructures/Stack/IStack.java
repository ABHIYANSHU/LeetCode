package LeetCode.DataStructures.Stack;

public interface IStack<E> {
    public boolean push(E item);
    public E pop();
    public E peek();
    public int size();
}