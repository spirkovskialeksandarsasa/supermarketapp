import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperMarket {

    public static int countListItems(List<Product> products) {
        int counter = 0;
        for (Product product : products) {
            counter++;
        }
        return counter;
    }

    public static double countPrices(List<Product> products) {
        double priceCounter = 0.0;
        for (Product product : products) {
            priceCounter += product.getPrice();
        }
        return priceCounter;
    }

    public static void main(String[] args) throws IOException {
        String apiLink = "https://interview-task-api.mca.dev/qr-scanner-codes/alpha-qr-gFpwhsQ8fkY1";


        BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(apiLink).openStream()));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();

        Gson gson = new Gson();
        Product[] productsArray = gson.fromJson(builder.toString(), Product[].class);

        List<Product> productList = new ArrayList<>();
        for (Product product : productsArray) {
            productList.add(product);
        }

        Collections.sort(productList);
        List<Product> domesticProducts = new ArrayList<>();
        List<Product> importedProducts = new ArrayList<>();
        for (Product product : productList) {
            if (product.isDomestic()) {
                domesticProducts.add(product);
            } else importedProducts.add(product);
        }

        System.out.println(". Domestic");
        for (Product product : domesticProducts) {
            System.out.println("..." + product.getName());
            System.out.println("\tPrice: $" + product.getPrice());
            System.out.println("\t" + product.getDescription());
            if (product.getWeight() == 0) {
                System.out.println("\tWeight: N/A");
            } else System.out.println("\tWeight:" + product.getWeight());
        }

        System.out.println(". Imported");
        for (Product product : importedProducts) {
            System.out.println("..." + product.getName());
            System.out.println("\tPrice: $" + product.getPrice());
            System.out.println("\t" + product.getDescription());
            if (product.getWeight() == 0) {
                System.out.println("\tWeight: N/A");
            } else System.out.println("\tWeight: " + product.getWeight());
        }

        System.out.println("Domestic cost: $" + countPrices(domesticProducts));
        System.out.println("Imported cost: $" + countPrices(importedProducts));

        System.out.println("Domestic count: " + countListItems(domesticProducts));
        System.out.println("Imported count: " + countListItems(importedProducts));
    }
}
