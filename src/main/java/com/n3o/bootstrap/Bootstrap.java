package com.n3o.bootstrap;

import com.n3o.domain.Category;
import com.n3o.domain.Customer;
import com.n3o.repositories.CategoryRepository;
import com.n3o.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Categories");
        loadCategories();
        System.out.println("Loading Customers");
        loadCustomers();
    }

    private void loadCategories() {
        //Init Data
        Category fruits = new Category();
        fruits.setName("Fruits");
        Category dried = new Category();
        dried.setName("Dried");
        Category fresh = new Category();
        fresh.setName("Fresh");
        Category exotic = new Category();
        exotic.setName("Exotic");
        Category nuts = new Category();
        nuts.setName("nuts");
        //saving data
        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);
        //printing data
        System.out.println("Categories Data Loaded = " + categoryRepository.count());
    }

    private void loadCustomers() {
        //Init Data
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("N3O");
        customer1.setLastName("Choudhary");
        Customer customer2 = new Customer();
        customer1.setId(2L);
        customer1.setFirstName("eluelu");
        customer1.setLastName("blabla");
        //Saving Data
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        //printing data
        System.out.println("Customer Data Loaded = "+customerRepository.count());
    }
}
