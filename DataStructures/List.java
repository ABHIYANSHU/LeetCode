package LeetCode.DataStructures.List;

import LeetCode.DataStructures.Collection;
import LeetCode.DataStructures.Sort.SortingTechniques;

public interface List<E> extends Collection<E> {
    public boolean add(E val);
    public boolean add(E val, int index);
    public boolean remove(E val);
    public boolean remove(int index);
    public E get(int index);
    public int size();
    public List<E> sort();
    public List<E> sort(SortingTechniques techniques, boolean ascending);
    public List<E> sort(SortingTechniques techniques);
    public List<E> sort(boolean ascending);
}
