import java.util.Arrays;

// Product class with attributes for searching
class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
    }
}

// Search implementation class
class EcommerceSearch {
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search: Search by productId (assumes array is sorted by productId)
    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == productId) {
                return products[mid];
            } else if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        // Create sample products
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Smartphone", "Electronics"),
            new Product(103, "Headphones", "Accessories"),
            new Product(104, "T-Shirt", "Clothing"),
            new Product(105, "Backpack", "Accessories")
        };


        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        // Test Linear Search
        System.out.println("Linear Search Results:");
        String searchName = "Smartphone";
        Product result1 = linearSearch(products, searchName);
        System.out.println("Searching for: " + searchName);
        System.out.println(result1 != null ? result1 : "Product not found");

        // Test Binary Search
        System.out.println("\nBinary Search Results:");
        int searchId = 103;
        Product result2 = binarySearch(sortedProducts, searchId);
        System.out.println("Searching for product ID: " + searchId);
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}