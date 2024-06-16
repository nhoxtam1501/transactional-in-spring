package dev.ducku.main.service;

import dev.ducku.main.model.Product;
import dev.ducku.main.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED) // default of transactional
    /* Spring checks if there is an active transaction,
     and if nothing exists, it creates a new one.
     Otherwise, the business logic appends to the currently active transaction:*/
    /*do not try catch here because it will not propagate the unchecked exception to roll back*/
    public void save() {
        String[] productNames = {"beer", "syrup", "chair", "table", "fan", "keyboard", "mouse", "monitor", "laptop", "mousepad"};
        for (String productName : productNames) {
            Product product = new Product(null, productName);
            productRepository.save(product);

            if (productName.equals("monitor")) {
                throw new RuntimeException("Something occurred");
            }
        }
    }
}
