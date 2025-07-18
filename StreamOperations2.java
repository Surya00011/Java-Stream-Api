import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
class Product {
	private int id;
	private String name;
	private String category;
	private double price;
	private int stock;

	// Constructor
	public Product(int id, String name, String category, double price, int stock) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}
	@Override
	public String toString() {
		return "Product{id=" + id + ", name='" + name + "', category='" + category + "', price=" + price + ", stock=" + stock + "}";
	}
}

class StreamOperations {

	// Method to perform various Stream API operations
	public static void performStreamOperations(List<Product> products) {
		//price >50 1.filter
		System.out.println("Product prize lesser than 50 ");
		products.stream()
		.filter(p -> p.getPrice() < 50)
		.forEach(p ->System.out.println("ProductId: "+p.getId()+" ProductName: "+ p.getName()));


		//List of products products ->String 2.map
		System.out.println("\nProductList..");
		products.stream().map(product -> product.getName()).forEach(p->System.out.println(p));

		//sort 3.Sorted
		System.out.println("\nSorted by Name");
		products.stream()
		.sorted((p1,p2)->p1.getName().compareTo(p2.getName()))
		.forEach(p->System.out.println(p.getName()));

		//Sort
		System.out.println("\nSorted by Stock Availability High to low");
		products.stream()
		.sorted((p1,p2)->Integer.compare(p2.getStock(),p1.getStock()))
		.forEach(p->System.out.println(p.getName()));

		//unique catogeory 4.distinct
		System.out.println("\nDistinct product categories:");
		products.stream()
		.map(Product::getCategory) //or p->p.getCategory();
		.distinct()
		.forEach(System.out::println);

		//Limit elements in stream 5.limit
		System.out.println("\nLimit By 3");
		products.stream()
		.limit(3)
		.forEach(System.out:: println);

		// skip elements in stream 6.skip
		System.out.println("\nSkip 5 elements in list stream");
		products.stream().skip(5).forEach(System.out::println);

		// **7. Collect groupedByCategory
		System.out.println("\nProducts grouped by category:");
		Map<String, List<Product>> groupedByCategory = products.stream()
		        .collect(Collectors.groupingBy(p-> p.getCategory()));

		groupedByCategory.forEach((category, itemList) -> {
			System.out.println(category + ":");
			itemList.forEach(item -> System.out.println("  " + item.getName()));
		});

		// 8.count (count by category)
		System.out.println("\nCount Clothing");
		long count =products.stream().filter(p-> p.getCategory().equals("Clothing")).count();
		System.out.println("Clothing category count: "+count);

		//9.reduce
		System.out.println("\nTotal stock count");
		int totalStock = products.stream()
		                 .map(p -> p.getStock())  // Using lambda expression instead of method reference
		                 .reduce(0, (a, b) -> a + b);  // Using lambda expression for Integer::sum
		System.out.println("Total products stoct Count: "+totalStock);
		// **11. Any Match**
		System.out.println("\nIs there any product with price > 200?");
		boolean anyExpensiveProduct = products.stream()
		                              .anyMatch(p -> p.getPrice() > 200);
		System.out.println(anyExpensiveProduct);

		// **12. All Match**
		System.out.println("\nAre all products in stock?");
		boolean allInStock = products.stream()
		                     .allMatch(p -> p.getStock() > 0);
		System.out.println(allInStock);

		// **13. None Match**
		System.out.println("\nIs no product under $10?");
		boolean noCheapProduct = products.stream()
		                         .noneMatch(p -> p.getPrice() < 10);
		System.out.println(noCheapProduct);
	}
}

public class Main {
	public static void main(String[] args) {
		// products List
		List<Product> products = List.of(
		                             new Product(1, "Laptop", "Electronics", 1000.0, 50),
		                             new Product(2, "Phone", "Electronics", 500.0, 150),
		                             new Product(3, "Shirt", "Clothing", 30.0, 200),
		                             new Product(4, "Shoes", "Footwear", 70.0, 80),
		                             new Product(5, "Bag", "Accessories", 50.0, 120),
		                             new Product(6, "Tablet", "Electronics", 300.0, 80),
		                             new Product(7, "Socks", "Clothing", 10.0, 300),
		                             new Product(8, "Jacket", "Clothing", 90.0, 50),
		                             new Product(9, "Gloves", "Accessories", 15.0, 100),
		                             new Product(10, "Smartwatch", "Electronics", 150.0, 200)
		                         );
		StreamOperations.performStreamOperations(products);
	}
}


