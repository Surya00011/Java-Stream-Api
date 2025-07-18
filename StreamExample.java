import java.util.*;
import java.util.stream.*;
class Orders {
	int id;
	String status;
	public Orders(int id,String status) {
		this.id = id;
		this.status =status;
	}
	public int getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public String toString() {
		return "id: "+id+"| " + "sts "+status+", ";
	}
}
public class Main
{
	public static void main(String[] args) {
		List<Orders> orders = Arrays.asList(
		                          new Orders(1,"pending"),
		                          new Orders(2,"delivered"),
		                          new Orders(3,"cancelled"),
		                          new Orders(5,"delivered")
		                      );

		List<Orders> deliveredOrders = new ArrayList<>();
		System.out.println("Without stream");
		for(Orders sts : orders) {
			if(sts.getStatus().equals("delivered")) {
				deliveredOrders.add(sts);
			}
		}
		System.out.println(deliveredOrders);
		System.out.println("With stream");
		deliveredOrders = orders.stream()
		                  .filter(order -> order.getStatus().equals("delivered"))  // Filter delivered orders
		                  .collect(Collectors.toList());  // Collect into a list

		System.out.println(deliveredOrders);
	}
}
