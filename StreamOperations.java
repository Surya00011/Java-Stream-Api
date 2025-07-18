/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.util.stream.*;
import java.util.OptionalDouble;
public class Main
{
	public static void main(String[] args) {
	  List<Integer> list = Arrays.asList(2,3,3,4,4,5,5,9);
	  List<Integer> bglist = Arrays.asList(234,456,236,238,897,250,251);
	  //sum
	  int sum= list.stream().reduce(0,(s,i)->s+i);
	  System.out.println("Sum: "+sum); 
	  //product 
	  int product = list.stream().reduce(1,(p,i)->p*i);
	  System.out.println("Product: "+product);
	  //max 
	  int max = list.stream().reduce(list.get(0),(a,b)-> a>b?a:b);
	  System.out.println("Product: "+max);
	  //avg
	  OptionalDouble average = list.stream().mapToInt(Integer::intValue).average();
	  System.out.println("Average: " + (average.isPresent() ? average.getAsDouble() : "N/A"));
	  //square
	  System.out.print("Square: ");
	  list.stream().map(n->n*n).forEach(n-> System.out.print(n+" "));
	  //print list of even nums that starts with "2"\
	  List<Integer> numsSWith2=bglist.stream().map(n-> String.valueOf(n))
	                     .filter(n-> n.startsWith("2"))
	                     .map(n-> Integer.valueOf(n))
	                     .collect(Collectors.toList());
	  System.out.print("\nEven number startsWith '2': ");                   
	  numsSWith2.stream()
	             .filter(n->n%2==0).forEach(n->System.out.print(n+" "));
	  
	}
}
