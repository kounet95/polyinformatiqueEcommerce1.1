package org.example.ecpolyquery;

import org.example.ecpolyquery.entity.*;
import org.example.ecpolyquery.repos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EcPolyQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcPolyQueryApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            CustomerRepository customerRepository,
            SupplierRepository supplierRepository,
            ProductSizeRepository productSizeRepository,
            StockRepository stockRepository,
            PurchaseRepository purchaseRepository,
            OrderRepository orderRepository,
            OrderLineRepository orderLineRepository,
            InvoiceRepository invoiceRepository,
            ShippingRepository shippingRepository
    ) {
        return args -> {
            System.out.println("Initializing query-side database for ecPolyQuery...");

            // Create customers
            String customerId1 = "customer-1";
            String customerId2 = "customer-2";

            if (!customerRepository.existsById(customerId1)) {
                Customer customer1 = Customer.builder()
                        .id(customerId1)
                        .firstname("John")
                        .lastname("Doe")
                        .email("john.doe@example.com")
                        .phone("+1234567890")
                        .shippingAddress("123 Main St, City")
                        .billingAddress("123 Main St, City")
                        .orders(new ArrayList<>())
                        .build();
                customerRepository.save(customer1);
            }

            if (!customerRepository.existsById(customerId2)) {
                Customer customer2 = Customer.builder()
                        .id(customerId2)
                        .firstname("Jane")
                        .lastname("Doe")
                        .email("jane.doe@example.com")
                        .phone("+0987654321")
                        .shippingAddress("456 Oak St, Town")
                        .billingAddress("456 Oak St, Town")
                        .orders(new ArrayList<>())
                        .build();
                customerRepository.save(customer2);
            }

            System.out.println("Customers created successfully");

            // Create suppliers
            String supplierId1 = "supplier-1";
            String supplierId2 = "supplier-2";

            if (!supplierRepository.existsById(supplierId1)) {
                Supplier supplier1 = Supplier.builder()
                        .id(supplierId1)
                        .fullname("Supplier A")
                        .city("New York")
                        .email("contact@suppliera.com")
                        .personToContact("Alice Johnson")
                        .stocks(new ArrayList<>())
                        .purchases(new ArrayList<>())
                        .build();
                supplierRepository.save(supplier1);
            }

            if (!supplierRepository.existsById(supplierId2)) {
                Supplier supplier2 = Supplier.builder()
                        .id(supplierId2)
                        .fullname("Supplier B")
                        .city("Los Angeles")
                        .email("contact@supplierb.com")
                        .personToContact("Bob Smith")
                        .stocks(new ArrayList<>())
                        .purchases(new ArrayList<>())
                        .build();
                supplierRepository.save(supplier2);
            }

            System.out.println("Suppliers created successfully");

            // Create product sizes
            String productSizeId1 = "product-size-1";
            String productSizeId2 = "product-size-2";
            String productSizeId3 = "product-size-3";

            if (!productSizeRepository.existsById(productSizeId1)) {
                ProductSize productSize1 = ProductSize.builder()
                        .id(productSizeId1)
                        .size("S")
                        .build();
                productSizeRepository.save(productSize1);
            }

            if (!productSizeRepository.existsById(productSizeId2)) {
                ProductSize productSize2 = ProductSize.builder()
                        .id(productSizeId2)
                        .size("M")
                        .build();
                productSizeRepository.save(productSize2);
            }

            if (!productSizeRepository.existsById(productSizeId3)) {
                ProductSize productSize3 = ProductSize.builder()
                        .id(productSizeId3)
                        .size("L")
                        .build();
                productSizeRepository.save(productSize3);
            }

            System.out.println("Product sizes created successfully");

            // Create stock
            String stockId1 = "stock-1";
            String stockId2 = "stock-2";
            String stockId3 = "stock-3";

            if (!stockRepository.existsById(stockId1)) {
                Stock stock1 = Stock.builder()
                        .id(stockId1)
                        .purchasePrice(100.0)
                        .promoPrice(90.0)
                        .salePrice(120.0)
                        .stockAvailable(50)
                        .build();
                stockRepository.save(stock1);
            }

            if (!stockRepository.existsById(stockId2)) {
                Stock stock2 = Stock.builder()
                        .id(stockId2)
                        .purchasePrice(150.0)
                        .promoPrice(140.0)
                        .salePrice(180.0)
                        .stockAvailable(30)
                        .build();
                stockRepository.save(stock2);
            }

            if (!stockRepository.existsById(stockId3)) {
                Stock stock3 = Stock.builder()
                        .id(stockId3)
                        .purchasePrice(200.0)
                        .promoPrice(190.0)
                        .salePrice(240.0)
                        .stockAvailable(20)
                        .build();
                stockRepository.save(stock3);
            }

            System.out.println("Stock created successfully");

            // Create purchases
            String purchaseId1 = "purchase-1";
            String purchaseId2 = "purchase-2";

            if (!purchaseRepository.existsById(purchaseId1)) {
                Purchase purchase1 = Purchase.builder()
                        .id(purchaseId1)
                        .createdAt(LocalDateTime.now())
                        .status("RECEIVED")
                        .total(5000.0)
                        .build();
                purchaseRepository.save(purchase1);
            }

            if (!purchaseRepository.existsById(purchaseId2)) {
                Purchase purchase2 = Purchase.builder()
                        .id(purchaseId2)
                        .createdAt(LocalDateTime.now().minusDays(7))
                        .status("RECEIVED")
                        .total(7500.0)
                        .build();
                purchaseRepository.save(purchase2);
            }

            System.out.println("Purchases created successfully");

            // Create orders
            String orderId1 = "order-1";
            String orderId2 = "order-2";

            if (!orderRepository.existsById(orderId1)) {
                Order order1 = Order.builder()
                        .id(orderId1)
                        .createdAt(LocalDateTime.now())
                        .orderStatus("CREATED")
                        .paymentMethod("CREDIT_CARD")
                        .total(240.0)
                        .lines(new ArrayList<>())
                        .build();
                orderRepository.save(order1);
            }

            if (!orderRepository.existsById(orderId2)) {
                Order order2 = Order.builder()
                        .id(orderId2)
                        .createdAt(LocalDateTime.now().minusDays(3))
                        .orderStatus("CREATED")
                        .paymentMethod("PAYPAL")
                        .total(360.0)
                        .lines(new ArrayList<>())
                        .build();
                orderRepository.save(order2);
            }

            System.out.println("Orders created successfully");

            // Create order lines
            String orderLineId1 = "order-line-1";
            String orderLineId2 = "order-line-2";
            String orderLineId3 = "order-line-3";

            if (!orderLineRepository.existsById(orderLineId1)) {
                OrderLine orderLine1 = OrderLine.builder()
                        .id(orderLineId1)
                        .qty(2)
                        .build();
                orderLineRepository.save(orderLine1);
            }

            if (!orderLineRepository.existsById(orderLineId2)) {
                OrderLine orderLine2 = OrderLine.builder()
                        .id(orderLineId2)
                        .qty(1)
                        .build();
                orderLineRepository.save(orderLine2);
            }

            if (!orderLineRepository.existsById(orderLineId3)) {
                OrderLine orderLine3 = OrderLine.builder()
                        .id(orderLineId3)
                        .qty(1)
                        .build();
                orderLineRepository.save(orderLine3);
            }

            System.out.println("Order lines created successfully");

            // Create invoices
            String invoiceId1 = "invoice-1";
            String invoiceId2 = "invoice-2";

            if (!invoiceRepository.existsById(invoiceId1)) {
                Invoice invoice1 = Invoice.builder()
                        .id(invoiceId1)
                        .amount(240.0)
                        .paymentStatus("PENDING")
                        .build();
                invoiceRepository.save(invoice1);
            }

            if (!invoiceRepository.existsById(invoiceId2)) {
                Invoice invoice2 = Invoice.builder()
                        .id(invoiceId2)
                        .amount(360.0)
                        .paymentStatus("PENDING")
                        .build();
                invoiceRepository.save(invoice2);
            }

            System.out.println("Invoices created successfully");

            // Create shipping
            String shippingId1 = "shipping-1";
            String shippingId2 = "shipping-2";

            if (!shippingRepository.existsById(shippingId1)) {
                Shipping shipping1 = Shipping.builder()
                        .id(shippingId1)
                        .deliveryStatus("SHIPPED")
                        .estimatedDeliveryDate(LocalDateTime.now().plusDays(3))
                        .shippingDate(LocalDateTime.now())
                        .shippingAddress("123 Main St, City")
                        .build();
                shippingRepository.save(shipping1);
            }

            if (!shippingRepository.existsById(shippingId2)) {
                Shipping shipping2 = Shipping.builder()
                        .id(shippingId2)
                        .deliveryStatus("SHIPPED")
                        .estimatedDeliveryDate(LocalDateTime.now().plusDays(5))
                        .shippingDate(LocalDateTime.now())
                        .shippingAddress("456 Oak St, Town")
                        .build();
                shippingRepository.save(shipping2);
            }

            System.out.println("Shipping created successfully");
            System.out.println("Query-side database initialization completed for ecPolyQuery!");
        };
    }
}
