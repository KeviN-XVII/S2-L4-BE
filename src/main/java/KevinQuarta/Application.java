package KevinQuarta;

import KevinQuarta.entities.Customer;
import KevinQuarta.entities.Order;
import KevinQuarta.entities.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        customers.add(new Customer("Kevin"));
        customers.add(new Customer("Umberto"));
        customers.add(new Customer("Daniele"));
        customers.add(new Customer("Marco"));
        customers.add(new Customer("Gianni"));
        customers.add(new Customer("Fabio"));


        products.add(new Product("Ps5","Boys"));
        products.add(new Product("Ciuccio","Baby"));
        products.add(new Product("Il vaggio di nessuno","Books"));
        products.add(new Product("Come perdere al Fantacalcio","Books"));
        products.add(new Product("Culla","Baby"));
        products.add(new Product("Televisione","Boys"));
        products.add(new Product("Lego Star Wars", "Boys"));
        products.add(new Product("Libro delle fiabe", "Books"));
        products.add(new Product("Passeggino Chicco", "Baby"));
        products.add(new Product("Harry Potter", "Books"));

//        ORDINE N1
        ArrayList<Product> carrelloKevin = new ArrayList();
        carrelloKevin.add(products.get(1));
        carrelloKevin.add(products.get(3));
        carrelloKevin.add(products.get(5));

        orders.add(new Order("Pagato",LocalDate.of(2021, 3, 5),carrelloKevin,customers.get(0)));

        //        ORDINE 2
        ArrayList<Product> carrelloUmberto = new ArrayList();
        carrelloUmberto.add(products.get(2));
        carrelloUmberto.add(products.get(4));
        carrelloUmberto.add(products.get(6));
        carrelloUmberto.add(products.get(8));

        orders.add(new Order("Pagato",LocalDate.of(2023, 7, 17),carrelloUmberto,customers.get(1)));


        System.out.println("---------Customers");
        System.out.println(customers);
        System.out.println("---------Products");
        System.out.println(products);
        System.out.println("---------Orders");
        System.out.println(orders);


//        Esercizio1
        System.out.println("--------------ESERCIZIO 1 ");

        Map<String,List<Order>> ordersByCustomer = orders.stream().collect(Collectors.groupingBy((order -> order.getCustomer().getName())));
        ordersByCustomer.forEach((nome,ordineDi)-> System.out.println("Nome utente:  " + nome +"Ordini effetuati: "+ ordineDi));

//        Esercizio 2
        System.out.println("--------------ESERCIZIO 2 ");;
        Map<String,Double> sumOrderCustomer = orders.stream().collect(Collectors.groupingBy((order->order.getCustomer())));



//        Esercizio 3
        System.out.println("--------------ESERCIZIO 3 ");
        List<Product> ExpensiveProducts = products.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).toList();
        ExpensiveProducts.forEach(product-> System.out.println(product));

//       Esercizio 4
        System.out.println("--------------ESERCIZIO 4 ");
        OptionalDouble averageOrder = orders.stream().mapToDouble(order->order.getProducts().stream().mapToDouble(Product::getPrice).sum()).average();
        System.out.println("La media degli ordini è di : " + averageOrder.getAsDouble());

//        Esercizio 5
        System.out.println("--------------ESERCIZIO 5 ");
        Map<String,Double> totalCategory = products.stream().collect(Collectors.groupingBy(product->product.getCategory(),Collectors.summingDouble(p->p.getPrice())));
        totalCategory.forEach((category,value)-> System.out.println("La categoria " + category + " ha il valore totale di : " + value));



    }
}
