import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class CollectionDisjoint {

    public static void main(String[] args)
    {
        // Let us create array list of strings
        List<String>  mylist1 = new ArrayList<String>();
        mylist1.add("practice");
        mylist1.add("code");
        mylist1.add("quiz");
        mylist1.add("geeksforgeeks");

        // Let us create vector of strings
        List<String>  mylist2 = new Vector<>();
        mylist2.add("geeks");
        mylist2.add("geek");
        mylist2.add("for");
        mylist2.add("coder");

        // Let us create a vector
        List mylist3 = new Vector();

        mylist3.add(1);
        mylist3.add("practice");

        // Let us create a Set of strings
        Set<String> mylist4 = new HashSet<>();
        mylist4.add("practice");
        mylist4.add("code");
        mylist4.add("quiz");
        mylist4.add("geeksforgeeks");


        // Here we are using disjoint() method to check
        // whether two collections are disjoint or not
        System.out.println("is mylist1 disjoint to mylist2 : " +
                Collections.disjoint(mylist1, mylist2));

        System.out.println("is mylist1 disjoint to mylist3 : " +
                Collections.disjoint(mylist1, mylist3));

        System.out.println("is mylist1 disjoint to mylist4 : " +
                Collections.disjoint(mylist1, mylist4));

    }
}
