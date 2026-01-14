package test.assignment.SourceCode;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Interview Question: KYC Process Implementation (Java)
//Design and implement a simple KYC (Know Your Customer) process in Java with the following sequential steps:

//Information Entry
//Upload Document
//Verify Document
//Review & Submit → Approve or Reject
//Requirements:
//Code should be clean, readable, and maintainable.
//The  design should be scalable so new steps can be added later without major code changes.
//	• Steps should also be scalable inside themselves. Example:
//The "Verify Document" step should be able to handle multiple document types (ID Card, Passport, Driver License, etc.) with different validation rules..
public class SourceCode {

    // Context to hold data across steps
    static class KYCContext {
        String customerName;
        String customerEmail;
        Document uploadedDocument;
        boolean documentVerified;
        boolean approved;
    }

    // Step interface
    interface KYCStep {
        void execute(KYCContext context);
    }

    // Step 1: Information Entry
    static class InformationEntryStep implements KYCStep {
        @Override
        public void execute(KYCContext context) {
            // Simulate user input
            context.customerName = "Alice";
            context.customerEmail = "alice@example.com";
            System.out.println("Information entered: " + context.customerName);
        }
    }

    // Step 2: Upload Document
    static class UploadDocumentStep implements KYCStep {
        @Override
        public void execute(KYCContext context) {
            // Simulate document upload
            context.uploadedDocument = new Document("Passport", "P123456");
            System.out.println("Document uploaded: " + context.uploadedDocument.getType());
        }
    }

    // Document abstraction
    @Getter
    static class Document {
        private String type;
        private String id;

        public Document(String type, String id) {
            this.type = type;
            this.id = id;
        }
    }

    // Strategy interface for document validation
    interface DocumentValidator {
        boolean validate(Document doc);
    }

    // Concrete validators
    static class PassportValidator implements DocumentValidator {
        @Override
        public boolean validate(Document doc) {
            return doc.getId().startsWith("P"); // simple rule
        }
    }

    static class IDCardValidator implements DocumentValidator {
        @Override
        public boolean validate(Document doc) {
            return doc.getId().length() == 9; // simple rule
        }
    }

    // Step 3: Verify Document
    static class VerifyDocumentStep implements KYCStep {
        private final Map<String, DocumentValidator> validators = new HashMap<>();

        public VerifyDocumentStep() {
            validators.put("Passport", new PassportValidator());
            validators.put("IDCard", new IDCardValidator());
        }

        @Override
        public void execute(KYCContext context) {
            Document doc = context.uploadedDocument;
            DocumentValidator validator = validators.get(doc.getType());
            if (validator != null) {
                context.documentVerified = validator.validate(doc);
                System.out.println("Document verification: " + context.documentVerified);
            } else {
                System.out.println("No validator found for type: " + doc.getType());
                context.documentVerified = false;
            }
        }
    }

    // Step 4: Review & Submit
    static class ReviewAndSubmitStep implements KYCStep {
        @Override
        public void execute(KYCContext context) {
            if (context.documentVerified) {
                context.approved = true;
                System.out.println("KYC Approved for " + context.customerName);
            } else {
                context.approved = false;
                System.out.println("KYC Rejected for " + context.customerName);
            }
        }
    }

    // Orchestrator
    static class KYCProcess {
        private final List<KYCStep> steps = new ArrayList<>();

        public void addStep(KYCStep step) {
            steps.add(step);
        }

        public void execute() {
            KYCContext context = new KYCContext();
            for (KYCStep step : steps) {
                step.execute(context);
            }
        }
    }

    // Demo
    public static class KYCMain {
        public static void main(String[] args) {
            KYCProcess process = new KYCProcess();
            process.addStep(new InformationEntryStep());
            process.addStep(new UploadDocumentStep());
            process.addStep(new VerifyDocumentStep());
            process.addStep(new ReviewAndSubmitStep());

            process.execute();
        }
    }
}

