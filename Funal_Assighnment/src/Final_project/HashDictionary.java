package Final_project;

import java.util.Objects;

public class HashDictionary<K extends Comparable,V>implements IDictionary<K,V>
{
    int size=0;
    private static Single_Linked_List[] arr = new Single_Linked_List[1001];
   public HashDictionary(){
       for (int i=0;i<arr.length;i++){
           arr[i]=new Single_Linked_List();
       }
   }
    public V set(K  key , V value){
       String Skey;
       Skey=key.toString();
       int Asci=0;
       for (int i=0;i<Skey.length();i++){
           Asci+=(int)Skey.charAt(i);
       }
       if(key==null||value==null){
           throw new RuntimeException("Key or Value is null");
       }
       int new_key=Asci%1001;
      for(int i=0;i<arr[new_key].size();i++){
          if(key.compareTo((K)arr[new_key].get_key(i))==0){
              return (V) arr[new_key].get_value(i);
          }
      }
      size++;
      arr[new_key].add(key,value);
      return null;
    }
    public V get(K key){
        String Skey;
        Skey=key.toString();
        int Asci=0;
        for (int i=0;i<Skey.length();i++){
            Asci+=(int)Skey.charAt(i);
        }
       if(key==null) {
           throw new RuntimeException("Key is null");
       }
       int new_key=Asci%1001;
        for(int i=0;i<arr[new_key].size();i++){
            if(key.compareTo((K)(arr[new_key].get_key(i)))==0){
                return (V) arr[new_key].get_value(i);
            }
        }
        return null;

    }
    public V remove(K key){
        String Skey;
        Skey=key.toString();
        int Asci=0;
        for (int i=0;i<Skey.length();i++){
            Asci+=(int)Skey.charAt(i);
        }
       if(key==null){throw new RuntimeException("Key is null");}
       int new_key=Asci%1001;
        for(int i=0;i<arr[new_key].size();i++){
            if(arr[new_key].get_key(i)==key){
            }
            V val=(V)arr[new_key].get_value(i);
            size--;
                arr[new_key].remove(i);
                return val;
            }
       return null;
    }
    public boolean isEmpty(){
       if (this.size==0){
           return true;
       }
       else {return false;}
    }



}


