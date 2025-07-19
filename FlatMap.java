import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

    public static void main(String[] args) {
     
        List<List<Integer>> intLists = List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(6, 7, 8, 9, 10)
        );

        List<Integer> flatInts = intLists.stream()      // Stream<List<Integer>>
                .flatMap(List::stream)                  // Stream<Integer>
                .collect(Collectors.toList());

        System.out.println("Flattened integers : " + flatInts);


      
        List<List<String>> wordLists = List.of(
                List.of("kai", "ksi"),
                List.of("ishowspeed")
        );

        List<String> chars = wordLists.stream()                     // Stream<List<String>>
                .flatMap(List::stream)                              // Stream<String>
                .flatMap(s -> Arrays.stream(s.split("")))           // Stream<String> (chars)
                .collect(Collectors.toList());

        System.out.println("Flattened characters: " + chars);
    }
}
