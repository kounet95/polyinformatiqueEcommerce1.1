package org.example.polyinformatiquecoreapi.dtoEcommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvoiceDTO {
    public String invoiceId;
    public String orderId;
    public double amount;
    private String paymentStatus;
}
