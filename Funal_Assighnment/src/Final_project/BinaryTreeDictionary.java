package Final_project;

public class BinaryTreeDictionary<K extends Comparable,V> implements IDictionary<K,V> {
    class d_node {
        K key;
        V value;
        d_node left;
        d_node right;
        boolean indicator;
        V last_value;

        d_node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public d_node set(d_node root, K key, V value) {
            if (root.key == null) {
                root.key = key;
                root.value = value;
                indicator = true;
                return root;
            } else if ( key.compareTo(root.key)>0) {
                if (root.right == null) {
                    root.right = new d_node(null, null);
                }
                root.right = set(root.right, key, value);
                root.right.indicator = set(root.right, key, value).indicator;
                root.right.last_value = set(root.right, key, value).last_value;
            } else if (key.compareTo(root.key)<0) {
                if (root.left == null) {
                    root.left = new d_node(null, null);
                }

                root.left = set(root.left, key, value);
                root.left.indicator = set(root.left, key, value).indicator;
                root.left.last_value = set(root.left, key, value).last_value;

            } else {
                if (root.value == null) {
                    root.value = value;
                    root.indicator = true;
                    return root;
                } else {
                    indicator = false;
                    last_value = root.value;
                    return root;
                }
            }
            return root;
        }

        public V get_value(d_node root, K key) {

            if ( root.key.compareTo(key) ==0) {
                return root.value;
            } else if (root.key.compareTo(key) > 0) {
                if (root.left == null) {
                    return null;
                }
                return get_value(root.left, key);
            } else if (root.key.compareTo(key)< 0) {
                if (root.right == null) {
                    return null;
                }
                return get_value(root.right, key);
            }
            return value;
        }

        public V delete(d_node root, K key) {
            if (root.key.compareTo(key)==0) {
                V x = root.value;
                root.value = null;
                return x;
            } else if (root.key.compareTo(key) >0) {
                if (root.left == null) {
                    throw new NullPointerException("Not found");
                }
                return get_value(root.left, key);
            } else if (  root.key.compareTo(key) <0 ) {
                if (root.right == null) {
                    throw new NullPointerException("Not found");
                }
                return get_value(root.right, key);
            }
            return value;
        }
    }

    d_node root = new d_node(null, null);

    public V set(K key, V value) {
        if(key==null||value==null){
            throw new RuntimeException("Key or Value is null");
        }
        root = root.set(root, key, value);
        if (root.indicator == true) {
            return null;
        } else {
            return root.last_value;
        }
    }

    public V get(K key) {
        if(key==null) {
            throw new RuntimeException("Key is null");
        }
        return root.get_value(root, key);
    }

    public V remove(K key) {
        if(key==null){throw new RuntimeException("Key is null");}
        return root.delete(root,key);
    }
    public boolean isEmpty(){
        if (root.value==null){
        return true;}
        else {return false;}
    }
}




