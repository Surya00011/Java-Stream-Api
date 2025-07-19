import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
class FlatMap {
	public static <T, R> List<R> flatList(
	    List<List<T>> listOfT,
	    Function<T, ? extends Collection<R>> transformer
	) {
		List<R> flattened = new ArrayList<>();
		for (List<T> outer : listOfT) {
			for (T element : outer) {
				flattened.addAll(transformer.apply(element));
			}
		}
		return flattened;
	}
}
public class CustomFlatMap
{
	public static void main(String[] args) {
		System.out.println(
		    FlatMap.flatList(List.of(List.of(1,2,3,4,5),List.of(6,7,8,9,10)), Collections::singletonList)
		);
		System.out.println(FlatMap.flatList(List.of(List.of("kai","ksi"),List.of("ishowspeed")),s->Arrays.asList(s.split(""))));
	}
}
