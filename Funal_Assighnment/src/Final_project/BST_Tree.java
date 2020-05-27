package Final_project;

public class BST_Tree implements IMiscUtils{
 int sum=0;
    public Binary_TreeNode insert(Binary_TreeNode root, int element){
        if(root.element==null){
            root.element=element;
            return root;
        }
        else if(element>(int)root.element){
            if(root.right==null){
                root.right=new Binary_TreeNode(null);
            }
            root.right=insert(root.right,element);
        }
        else if (element<(int)root.element){
            if (root.left==null){
            root.left=new Binary_TreeNode(null);}

            root.left=insert(root.left,element);
        }

        return root;
    }

    public int sumRange(Binary_TreeNode root, int low, int high){
        if(low>high){
            throw new RuntimeException("low value is bigger than high value");
        }
    if(root!=null&&((int)root.element>=low)&&((int)root.element<=high) ){
        return (int)root.element+sumRange(root.left,low,high)+sumRange(root.right,low,high);
    }
    else if(root!=null){
        return sumRange(root.left,low,high)+sumRange(root.right,low,high);
    }
    return 0;
    }
    public boolean isValidBST(Binary_TreeNode root){
        if(root!=null){
            if(root.left!=null&&root.right!=null){
                if((int)root.left.element<(int)root.element&&(int)root.right.element>(int)root.element){
                    return true&&isValidBST(root.left)&&isValidBST(root.right);
                }
                else {return false;}
            }
            else if(root.right!=null&&(int)root.right.element>(int)root.element){
                return true&&isValidBST(root.left)&&isValidBST(root.right);
            }
            else if(root.left!=null&&(int)root.left.element<(int)root.element){
                return true&&isValidBST(root.left)&&isValidBST(root.right);
            }
            else if(root.right==null&&root.left==null){return true;}
            else {return false;}
        }
        return true;
    }
    public int[] nextSmallerNumber(int[] array){
        int[] array2=new int[array.length];
    Binary_TreeNode root;
    Binary_TreeNode new_node1=new Binary_TreeNode(array[0]);
    Binary_TreeNode index=new Binary_TreeNode(0);
    new_node1.left=index;
    root=new_node1;
    int y;
    for(int i=1;i<array.length;i++){
        if(array[i]>(int)root.element){
            Binary_TreeNode new_node2=new Binary_TreeNode(array[i]);
            Binary_TreeNode index2=new Binary_TreeNode(i);
            new_node2.left=index2;
            new_node2.right=root;
            root=new_node2;
        }
        else { array2[(int)root.left.element]=i;
        if(root.right!=null){
            if(array[i]>(int)root.right.element){
                Binary_TreeNode new_node2=new Binary_TreeNode(array[i]);
                Binary_TreeNode index2=new Binary_TreeNode(i);
                new_node2.right=root.right;
                new_node2.left=index2;
                root=new_node2;
            }
            else {
                Binary_TreeNode temp=root.right;
            while (array[i]<=(int)temp.element){
                if(array[i]<(int)temp.element){
                array2[(int)temp.left.element]=i;}
                 if(array[i]==(int)temp.element){
                    Binary_TreeNode new_node2=new Binary_TreeNode(array[i]);
                    Binary_TreeNode index2=new Binary_TreeNode(i);;
                    new_node2.left=index2;
                    new_node2.right=temp;
                    root=new_node2;
                    break;
                }
                else if(temp.right!=null){
                temp=temp.right;}

                else { Binary_TreeNode new_node2=new Binary_TreeNode(array[i]);
                    Binary_TreeNode index2=new Binary_TreeNode(i);;
                    new_node2.left=index2;
                    root=new_node2;
                break;}
            }
            if(temp.right!=null&&(temp.element!=root.element)){
            Binary_TreeNode new_node2=new Binary_TreeNode(array[i]);
            Binary_TreeNode index2=new Binary_TreeNode(i);
            new_node2.left=index2;
            new_node2.right=temp;
            root=new_node2;}
            }
        }
        else {
            Binary_TreeNode new_node2=new Binary_TreeNode(array[i]);
                Binary_TreeNode index2=new Binary_TreeNode(i);
        new_node2.left=index2;
        root=new_node2;}
        }

    }
        while (root.right != null) {
            array2[(int)root.left.element]=-1;
            root=root.right;
        }
        array2[(int)root.left.element]=-1;

        return array2;
    }

}