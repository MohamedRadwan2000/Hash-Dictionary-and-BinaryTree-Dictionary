package Final_project;

public class Single_Linked_List<K,V>
{
    Node head;

    class Node
    {
        K key;
        V value;
        Node next;
        Node(K key,V value){this.key = key;
        this.value=value;}

    }

    public void add(K element,V value)
    {
        Node new_node = new Node(element,value);
        Node temp;
        if (this.head == null) {
            head = new_node;
        } else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next=new_node;
        }
    }




    public void add(int index1, K element,V value){
        int index=index1+1;
        Node new_node=new Node(element,value);
        Node temp=head;
        if(index>0) {
            if (index != 1) {
                for (int i = 0; i < index - 2; i++) {
                    if (temp.next != null) {
                        temp = temp.next;
                    } else {
                        throw new IndexOutOfBoundsException("index not found");
                    }
                }
                new_node.next = temp.next;
                temp.next = new_node;
            }
            else {new_node.next=temp;
                head=new_node;}
        }
        else {throw new IndexOutOfBoundsException("index not found");}
    }


    public K get_key(int index1){
        int index=index1+1;
        if(this.head==null){
            throw new IndexOutOfBoundsException("Index Not found");
        }
        if(index!=0) {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                if (temp.next != null) {
                    temp = temp.next;
                } else {
                    throw new IndexOutOfBoundsException("Index Not found");
                }
            }

            return temp.key;
        }
        else{throw new IndexOutOfBoundsException("Index Not found");}
    }
    public V get_value(int index1){
        int index=index1+1;
        if(this.head==null){
            throw new IndexOutOfBoundsException("Index Not found");
        }
        if(index!=0) {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                if (temp.next != null) {
                    temp = temp.next;
                } else {
                    throw new IndexOutOfBoundsException("Index Not found");
                }
            }

            return temp.value;
        }
        else{throw new IndexOutOfBoundsException("Index Not found");}
    }



    public void set(int index1, K element,V value){
        int index=index1+1;
        Node temp=head;
        if(index>0){
            for(int i=0;i<index-1;i++){
                if(temp.next==null){throw new IndexOutOfBoundsException("Index Not found");}
                temp=temp.next;

            }
            temp.key =element;
        temp.value=value;}
        else {throw new IndexOutOfBoundsException("Index Not found");}
    }

    public void clear(){head=null;}


    public boolean isEmpty(){
        if(head!=null){return false;}
        else {return true;}}


    public void remove(int index1){
        int index=index1+1;
        if(this.size()==1){this.head=null;
            return;}
        Node temp=head;
        if(index>0){
            if(index==1){head=head.next;}
            else{
                for(int i=0;i<index-2;i++){
                    if(temp.next==null){
                        throw new IndexOutOfBoundsException("Index Not found");
                    }
                    else {temp=temp.next;}
                }
                temp.next=temp.next.next;
            }
        }
        else {throw new IndexOutOfBoundsException("Index Not found");}
    }



    public int size(){
        int x=0;
        Node temp=head;
        while(temp!=null){temp=temp.next;
            x++;}
        return x;
    }



    public Single_Linked_List sublist(int fromIndex, int toIndex){
        if((fromIndex>this.size())||(toIndex>this.size())||(fromIndex<0)||(toIndex<0)){throw new NullPointerException("Wrong interval");}
        Single_Linked_List x=new Single_Linked_List();
        if(fromIndex<=toIndex) {
            int y=fromIndex;
            for (int i = 0; i <= (toIndex - fromIndex); i++) {
                x.add(this.get_key(y),this.get_value(y));
                y++;
            }
        }
        if(fromIndex>toIndex){
            int y=fromIndex;
            for(int i=0;i<=fromIndex-toIndex;i++){
                x.add(this.get_key(y),this.get_value(y));
                y--;}
        }
        return x;
    }
    public boolean contains(Object o){
        boolean x=false;
        Node temp=head;
        for(int i=0;i<this.size();i++){
            if(temp.key ==o){
                x=true;
                break;
            }
            else {temp=temp.next;}
        }
        return x;
    }
    public Object[]ConvertToArray(){
        Object[]arr=new Object[this.size()];
        for(int i=0;i<this.size();i++){
            arr[i]=this.get_key(i);
        }
        return arr;
    }
    public void print_LinkedList(){
        Node temp=head;
        if(head==null){System.out.println("empty");}
        while (temp!=null){
            System.out.println(temp.key);
            if(temp.next==null){
                break;
            }
            else { temp=temp.next;}
        }
    }


}

