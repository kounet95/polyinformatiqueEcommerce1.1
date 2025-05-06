package org.example.ecpolycommand;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.example.polyinformatiquecoreapi.commandEcommerce.*;
import org.example.polyinformatiquecoreapi.dtoEcommerce.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@SpringBootApplication
public class EcPolyCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcPolyCommandApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CommandGateway commandGateway) {
        return args -> {
            System.out.println("Starting to create sample data for ecPolyCommand...");

            // Create customers
            String customerId1 = UUID.randomUUID().toString();
            String customerId2 = UUID.randomUUID().toString();

            // Create suppliers
            String supplierId1 = UUID.randomUUID().toString();
            String supplierId2 = UUID.randomUUID().toString();

            // Create product sizes
            String productSizeId1 = UUID.randomUUID().toString();
            String productSizeId2 = UUID.randomUUID().toString();
            String productSizeId3 = UUID.randomUUID().toString();

            // Create stock
            String stockId1 = UUID.randomUUID().toString();
            String stockId2 = UUID.randomUUID().toString();
            String stockId3 = UUID.randomUUID().toString();

            commandGateway.send(new AddStockCommand(stockId1, new StockDTO(
                    stockId1,
                    productSizeId1,
                    supplierId1,
                    100.0,
                    90.0,
                    120.0,
                    50,
                    50.0
            )));

            commandGateway.send(new AddStockCommand(stockId2, new StockDTO(
                    stockId2,
                    productSizeId2,
                    supplierId1,
                    150.0,
                    140.0,
                    180.0,
                    30,
                    30.0
            )));

            commandGateway.send(new AddStockCommand(stockId3, new StockDTO(
                    stockId3,
                    productSizeId3,
                    supplierId2,
                    200.0,
                    190.0,
                    240.0,
                    20,
                    20.0
            )));

            System.out.println("Stock created successfully");

            // Create purchases
            String purchaseId1 = UUID.randomUUID().toString();
            String purchaseId2 = UUID.randomUUID().toString();

            commandGateway.send(new ReceivePurchaseCommand(purchaseId1, new PurchaseDTO(
                    purchaseId1,
                    supplierId1,
                    LocalDate.now().format(DateTimeFormatter.ISO_DATE),
                    "RECEIVED",
                    5000.0
            )));

            commandGateway.send(new ReceivePurchaseCommand(purchaseId2, new PurchaseDTO(
                    purchaseId2,
                    supplierId2,
                    LocalDate.now().minusDays(7).format(DateTimeFormatter.ISO_DATE),
                    "RECEIVED",
                    7500.0
            )));

            System.out.println("Purchases created successfully");

            // Create orders
            String orderId1 = UUID.randomUUID().toString();
            String orderId2 = UUID.randomUUID().toString();

            commandGateway.send(new CreateOrderCommand(orderId1, new OrderDTO(
                    orderId1,
                    customerId1,
                    LocalDate.now().format(DateTimeFormatter.ISO_DATE),
                    "CREATED",
                    "CREDIT_CARD",
                    240.0
            )));

            commandGateway.send(new CreateOrderCommand(orderId2, new OrderDTO(
                    orderId2,
                    customerId2,
                    LocalDate.now().minusDays(3).format(DateTimeFormatter.ISO_DATE),
                    "CREATED",
                    "PAYPAL",
                    360.0
            )));

            System.out.println("Orders created successfully");

            // Add products to orders
            String orderLineId1 = UUID.randomUUID().toString();
            String orderLineId2 = UUID.randomUUID().toString();
            String orderLineId3 = UUID.randomUUID().toString();

            commandGateway.send(new AddProductToOrderCommand(orderId1, new OrderLineDTO(
                    orderLineId1,
                    orderId1,
                    productSizeId1,
                    2
            )));

            commandGateway.send(new AddProductToOrderCommand(orderId2, new OrderLineDTO(
                    orderLineId2,
                    orderId2,
                    productSizeId2,
                    1
            )));

            commandGateway.send(new AddProductToOrderCommand(orderId2, new OrderLineDTO(
                    orderLineId3,
                    orderId2,
                    productSizeId3,
                    1
            )));

            System.out.println("Order lines created successfully");

            // Confirm orders
            commandGateway.send(new ConfirmOrderCommand(orderId1));
            commandGateway.send(new ConfirmOrderCommand(orderId2));

            System.out.println("Orders confirmed successfully");

            // Generate invoices
            String invoiceId1 = UUID.randomUUID().toString();
            String invoiceId2 = UUID.randomUUID().toString();

            commandGateway.send(new GenerateInvoiceCommand(orderId1, new InvoiceDTO(
                    invoiceId1,
                    orderId1,
                    240.0,
                    "PENDING"
            )));

            commandGateway.send(new GenerateInvoiceCommand(orderId2, new InvoiceDTO(
                    invoiceId2,
                    orderId2,
                    360.0,
                    "PENDING"
            )));

            System.out.println("Invoices generated successfully");

            // Pay invoices
            commandGateway.send(new PayInvoiceCommand(invoiceId1));
            commandGateway.send(new PayInvoiceCommand(invoiceId2));

            System.out.println("Invoices paid successfully");

            // Start shipping
            commandGateway.send(new StartShippingCommand(orderId1));
            commandGateway.send(new StartShippingCommand(orderId2));

            System.out.println("Shipping started successfully");

            // Deliver orders
            commandGateway.send(new DeliverOrderCommand(orderId1));

            System.out.println("Order 1 delivered successfully");
            System.out.println("All sample data created successfully for ecPolyCommand!");
        };
    }
}
