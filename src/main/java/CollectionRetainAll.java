import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CollectionRetainAll {

    public static void main(String[] args) {
        Collection<Integer> collection = new ConcurrentLinkedQueue<>();
        int i;
        for(i=1;i<=50;++i){
            collection.add(i);
        }
        System.out.println("collection : "+collection);
        List<Integer> list = new ArrayList<>();
        for ( i=1; i<=50;++i){
            if(i%5==0){
                list.add(i);
            }
        }
        //retains only those elements in the collection which are present in list
        collection.retainAll(list);
        System.out.println("Vowels : "+collection);

        List<String> pessoas = new ArrayList<>(Arrays.asList("giovani", "yuri", "gabriel", "flavia", "cleidiane", "joana"));

        List<String> remover = Arrays.asList("cleidiane", "joana");
        pessoas.retainAll(remover);
        System.out.println("pessoas : "+pessoas);


        List<String> lugares = new ArrayList<>(Arrays.asList("brasil", "eua", "italia", "franca", "argentina", "polonia"));

        //List<String> removerLugares = Arrays.asList("eua", "argentina");
        pessoas.removeIf(e -> e.contains("eua") || e.contains("argentina"));
        //pessoas.removeAll(removerLugares);
        System.out.println("lugares : "+lugares);
    }
}
