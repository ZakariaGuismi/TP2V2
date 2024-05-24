package com.example.product;


import com.example.product.Repos.ProductRepos;
import com.example.product.entites.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner {

    @Autowired
    ProductRepos repos;
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
       /*repos.save(new Product(Long.valueOf(1),3000.0,"Laptop"));
       repos.save(new Product(Long.valueOf(2),4500.0,"Desktop"));
       repos.save(new Product(Long.valueOf(3),2500.0,"Phone"));*/
       List<Product> Products =repos.findAll();
       Products.forEach(product -> {
           System.out.println(product);

       });

        System.out.println("--------------------------");
        List<Product> Products2 =repos.findProductByPrixGreaterThan(2900.0);
        Products2.forEach(product -> {
            System.out.println(product.getId());
            System.out.println(product.getPrix());
            System.out.println(product.getName());


        });
        Product productid=repos.findById(2L).orElse(null);

        System.out.println("--------------------------");
        Product startwithl = repos.search("L%");
        System.out.println(startwithl);
        System.out.println("--------------------------");
        List<Product> productContainsE=repos.findProductByNameContains("e");
        productContainsE.forEach(p->{
            System.out.println(p.getName());
        });

        repos.delete(productid);
    }
}
