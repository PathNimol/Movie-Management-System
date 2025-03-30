package BasicJava;
import java.util.ArrayList;

public class MyArraysList {
    public static void main(String[] args) {
        //ArrayList: a resizable array.
                    //Element can be added and removed after compilation phase store reference data type
        ArrayList<String> foods = new ArrayList<String>();
        foods.add("apple");
        foods.add("banana");
        foods.add("orange");
        foods.add("grapes");
        foods.set(1, "kiwi");
        foods.remove(2);
       // foods.clear();  --Clear all index of arrayList
        for(int i = 0; i < foods.size(); i++){
            System.out.println(foods.get(i));
        }

        ArrayList<String> skincare = new ArrayList<>();
        skincare.add("Shampoo");
        skincare.add("Conditioner");
        skincare.add("Body scrub");

        //2D ArrayList: a dynamic list of list, you can the size of list during runtime
        System.out.println("\n This is 2D ArrayList\n");
        ArrayList<ArrayList<String>> myProduct = new ArrayList<>();

        myProduct.add(foods);
        myProduct.add(skincare);

        System.out.println(myProduct);
        System.out.println(myProduct.get(0).get(1));
    }

}
