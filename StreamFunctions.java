import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
// Enum for Order Status
enum OrderStatus {
    PENDING,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
class Order {
    private int id;
    private String orderId;
    private OrderStatus status; // Enum type for status
    private String customerName;
    private double amount;

    // Constructor
    public Order(int id, String orderId, OrderStatus status, String customerName, double amount) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.customerName = customerName;
        this.amount = amount;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for orderId
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    // Getter and Setter for status
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    // Getter and Setter for customerName
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Getter and Setter for amount
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Method to print order details
    public void printOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Amount: $" + amount);
        System.out.println("Status: " + status);
        System.out.println("----------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a list of orders with more custom data
        List<Order> orders = Arrays.asList(
            new Order(1, "ORD123", OrderStatus.PENDING, "Alice Johnson", 250.75),
            new Order(2, "ORD124", OrderStatus.SHIPPED, "Bob Smith", 180.50),
            new Order(3, "ORD125", OrderStatus.DELIVERED, "Charlie Brown", 99.99),
            new Order(4, "ORD126", OrderStatus.CANCELLED, "Diana Prince", 120.00),
            new Order(5, "ORD127", OrderStatus.PENDING, "Eve Adams", 350.00),
            new Order(6, "ORD128", OrderStatus.DELIVERED, "Frank Castle", 400.00),
            new Order(7, "ORD129", OrderStatus.SHIPPED, "Grace Hopper", 220.75),
            new Order(8, "ORD130", OrderStatus.PENDING, "Hannah Lee", 540.50)
        );

        // Printing all orders
        System.out.println("All Orders:");
        orders.forEach(Order::printOrderDetails);

        // Using Streams to filter and print orders with status 'PENDING'
        System.out.println("\nPENDING Orders:");
        List<Order> pendingOrders = orders.stream()
                                          .filter(order -> order.getStatus() == OrderStatus.PENDING)
                                          .collect(Collectors.toList());
        pendingOrders.forEach(Order::printOrderDetails);

        // Using Streams to filter and print orders with amount greater than $200
        System.out.println("\nOrders with amount greater than $200:");
        List<Order> highValueOrders = orders.stream()
                                            .filter(order -> order.getAmount() > 200)
                                            .collect(Collectors.toList());
        highValueOrders.forEach(Order::printOrderDetails);

        // Using Streams to count how many orders are DELIVERED
        long deliveredCount = orders.stream()
                                    .filter(order -> order.getStatus().equals( OrderStatus.DELIVERED))
                                    .count();
        System.out.println("\nNumber of DELIVERED Orders: " + deliveredCount);
        
        //lower order values
        System.out.println("\nOrders with amount lesser than $200:");
        List<Order> lowValueOrders = orders.stream()
                                           .filter(order -> order.getAmount()<200)
                                           .collect(Collectors.toList());
        lowValueOrders.forEach(Order :: printOrderDetails);   
        
        //Customer Names
        System.out.println("\n---Customer_Names----");
        List<String> CustNames = orders.stream()
                                       .map(Order:: getCustomerName)
                                       .collect(Collectors.toList());
        CustNames.forEach(System.out:: println);
        System.out.println("----------------------------");
        //Names with ID
        System.out.println("CustomerName with Id");
        List<String> nameId = orders.stream()
                                    .map(order -> {
                                        String name = order.getCustomerName();
                                        String id = String.valueOf(order.getId());
                                        String res = "Name: ".concat(name).concat(" ").concat(" id ").concat(id);
                                        return res;
                                    })
                                    .collect(Collectors.toList());
        nameId.forEach(System.out :: println);
         System.out.println("----------------------------");
        //Map Transform
        Map<Integer, String> custDetails = orders.stream()
            .collect(Collectors.toMap(
                Order::getId,          // Key Mapper: using the order ID as the key
                Order::getCustomerName // Value Mapper: using the customer name as the value
            ));
        System.out.println(custDetails);    
    }
}
