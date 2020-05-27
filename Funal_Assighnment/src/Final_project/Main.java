package Final_project;

public class Main
{

    public static void main(String[] args)
    {

     HashDictionary k=new HashDictionary();

        BinaryTreeDictionary D=new BinaryTreeDictionary();
        D.set("Apple","apple");
        D.set("Book","كتاب");
        D.set("tree","شجرة");
        System.out.println(D.get("Book"));

       }
    }


