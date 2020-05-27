package Final_project;

public interface IDictionary <K,V > {
    public V get(K key);
    public V set(K key, V value);
    public V remove(K key);
    public boolean isEmpty();

}
