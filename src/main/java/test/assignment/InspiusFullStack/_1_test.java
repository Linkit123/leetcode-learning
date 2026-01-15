package test.assignment.InspiusFullStack;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class _1_test {

    public static void main(String[] args) {
        SpringApplication.run(_1_test.class, args);
    }

    @RestController
    @RequestMapping("/api/v1")
    static class TransactionController {

        private final TransactionService transactionService;

        TransactionController(TransactionService transactionService) {
            this.transactionService = transactionService;
        }

        @GetMapping("/transactions/entire")
        public List<Transaction> getAllTransactions() {
            return transactionService.getAllTransactions();
        }

        @PostMapping("/transactions")
        public Transaction createTransaction(@RequestBody TransactionRequest transactionReq) {
            if (transactionReq.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Amount must be greater than zero");
            }

            if (StringUtils.isEmpty(transactionReq.getDescription())) {
                throw new IllegalArgumentException("Description cannot be empty");
            }

            var transaction = convertToTransaction(transactionReq);
            return transactionService.createTransaction(transaction);
        }

        Transaction convertToTransaction(TransactionRequest transactionRequest) {
            Transaction transaction = new Transaction();
            transaction.setAmount(transactionRequest.getAmount());
            transaction.setDescription(transactionRequest.getDescription());
            return transaction;
        }

    }

    interface TransactionService {
        List<Transaction> getAllTransactions();

        Transaction createTransaction(Transaction transaction);
    }

    @Service
    static class TransactionServiceImpl implements TransactionService {

        List<Transaction> transactions = new ArrayList<>();

        @Override
        public List<Transaction> getAllTransactions() {
            return transactions;
        }

        @Override
        public Transaction createTransaction(Transaction transaction) {
            transaction.setId(UUID.randomUUID().toString());
            transaction.setTimestamp(Instant.now());
            transactions.add(transaction);
            return transaction;
        }
    }

    @Getter
    @Setter
    static class TransactionRequest {
        private BigDecimal amount;
        private String description;
    }

    @Getter
    @Setter
    static class Transaction {
        private String id;
        private BigDecimal amount;
        private String description;
        private Instant timestamp;
    }


}
