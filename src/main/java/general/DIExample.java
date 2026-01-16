package general;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DIExample {

    public static void main(String[] args) {
        SpringApplication.run(DIExample.class, args);
    }

    @RestController
    @RequestMapping("/api/v1")
    static class TransactionController {

        private final TransactionService transactionService;

        TransactionController(@Lazy TransactionService transactionService) {
            this.transactionService = transactionService;
        }

        @GetMapping("/transactions/entire")
        public List<Transaction> getAllTransactions() {
            return new ArrayList<>();
        }

    }

    @Service
    static class TransactionService {

        private ProductService productService;

        @Autowired
        public void setProductService(ProductService productService) {
            this.productService = productService;
        }

        public List<Transaction> getAllTransactions() {
            return new ArrayList<>();
        }
    }

    @Service
    static class ProductService {

        private TransactionService transactionService;

        @Autowired
        void setTransactionService(TransactionService transactionService) {
            this.transactionService = transactionService;
        }

        public List<Transaction> getProductByTransactionId(String transactionId) {
            return new ArrayList<>();
        }
    }

    @Getter
    @Setter
    static class Transaction {
        private String id;
        private BigDecimal amount;
        private String description;
        private Instant timestamp;
    }

    @Getter
    @Setter
    static class Product {
        private String id;
        private BigDecimal price;
        private String description;
        private String category;
        private String name;
    }
}
