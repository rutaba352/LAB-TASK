package Week4_B.Product0;
import java.util.scanner;

public class Person {
    String name;
    String email;
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

public class Product {
    private String id;
    private String name;
    private double price;;
    private int quantity;
    private static int counter=0;
    public Product( String name, double price, int quantity) {
        this.id = String.format("%03d", ++counter);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public Product(String name, double price) {
        this(name, price, 0);
    }
    public Product(String name) {
        this(name,0);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public static int getCounter() {
        return counter;
    }
    public static void setCounter(int counter) {
        Product.counter = counter;
    }
    public String getId() {
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return  Objects.equals(id, product.id) ;
    }
    @Override
    public String toString() {
        return String.format("%s %s %f %d",id,name, price, quantity);
    }
}

 public class shop{

    private Product[] productList;
    private int maxCapacity;
    private person owner;
    private String address;
    private static int productCount = 0;
    private static double revenue;
    

public shop(Person owner, String address, int maxCapacity){
    this.owner = owner;
    this.address= address;
    this.maxCapacity  maxCapacity;
    this.productList = new Product[maxCapacity];

}
public void addProduct() {
    Scanner input = new Scanner(System.in);
    System.out.printIn("Enter product details");
      
       if (productCount == maxCapacity) {
         System.out.printIn("shop is at full capacity.cant add products");
         return;

       }

 System.out.print("name");
 String name = input.nextLine();
 System.out.print("price");
 double price = input.nextDouble();
 System.out.print("quantity");
 int quantity = input.nextInt();


 Product product = new Product(name, price, quantity);
 productList[productCount++] = product;
 System.out.printIn("product added");
    }
    

 public void sell(){

    System.out.printIn("Sale Menu");
    Scanner scanner = new Scanner(System.in);
      
    System.out.print("enter product id");
    String id = scanner.nextline();
     for(int i = 0; i<productCount; i++){
        if(productList[i].getId().equals(id)){
            if(product[i].getQuantity() > 0){
                productList[i].setQuantity(productList[i].getQuantity() - 1);
                revenue += productList[i].getPrice();
                System.out.printIn("sale successfully");
                return;
            } 
            else{ 
                System.out.printIn("Product out of stock");
                return;
            }
            
        }
     }
     System.out.printIn("Product not found");
            
 }


 public void deleteProduct() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter product ID: ");
    String id = scanner.nextLine();

    int indexToDelete = -1;
    for (int i = 0; i < productCount; i++) {
        if (productList[i].getId().equals(id)) {
            indexToDelete = i;
            break;
        }
    }

    if (indexToDelete != -1) {
        // Shift elements to the left to fill the gap
        for (int i = indexToDelete; i < productCount - 1; i++) {
            productList[i] = productList[i + 1];
        }
        productList[productCount - 1] = null;  // Set the last element to null
        productCount--;
        System.out.println("Product deleted successfully");
    } else {
        System.out.println("Product not found");
    }
}

public void displayProducts() {
    System.out.println("Products in the shop:");
    if (productCount == 0) {
        System.out.println("The shop is currently empty.");
        return;
    }

    for (int i = 0; i < productCount; i++) {
        System.out.println(productList[i]);
    }
}

public void modifyProduct() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter product ID: ");
    String id = scanner.nextLine();

    int indexToModify = -1;
    for (int i = 0; i < productCount; i++) {
        if (productList[i].getId().equals(id)) {
            indexToModify = i;
            break;
        }
    }

    if (indexToModify != -1) {
        System.out.println("Enter new details (leave blank if unchanged):");
        System.out.print("Name: ");
        String newName = scanner.nextLine();
        System.out.print("Price: ");
        double newPrice = scanner.nextDouble();
        System.out.print("Quantity: ");
        int newQuantity = scanner.nextInt();

        if (!newName.isEmpty()) {
            productList[indexToModify].setName(newName);
        }
        if (newPrice >= 0) {
            productList[indexToModify].setPrice(newPrice);
        }
        if (newQuantity >= 0) {
            productList[indexToModify].setQuantity(newQuantity);
        }

        System.out.println("Product modified successfully");
    } else {
        System.out.println("Product not found");
    }
}
}

public class Test {
    public static void main(String[] args) {
        Shop shop= new Shop(new Person("John", "email"),"Lahore");
        Scanner sc = new Scanner(System.in);
        while(true) {
            int choice= sc.nextInt();
            switch (choice) {
                case 1:
                shop.addProduct();
                break;
                case 2:
                    shop.sale();
                    break;
                case 0:
                   System.exit(0);
                   break;
                default:
            }
        }
    }
}