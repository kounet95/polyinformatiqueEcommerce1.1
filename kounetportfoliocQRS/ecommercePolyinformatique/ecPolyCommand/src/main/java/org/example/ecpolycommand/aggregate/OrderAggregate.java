package org.example.ecpolycommand.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.polyinformatiquecoreapi.commandEcommerce.*;
import org.example.polyinformatiquecoreapi.dtoEcommerce.*;
import org.example.polyinformatiquecoreapi.eventEcommerce.*;

import java.util.ArrayList;
import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 *  Scénario 1 : Création de commande client
 * Commande : CreateOrder(customerId)
 *   => Événement : OrderCreated(orderId)
 * Commande : AddProductToOrder(orderId, productId, qty, size)
 *   => Événement : ProductAddedToOrder(orderId, productId, qty)
 * Commande : ConfirmOrder(orderId)
 *   => Événement : OrderConfirmed
 * Projection mise à jour : OrderView, StockView (réservation)
 *
 * Scénario 2 : Paiement de la commande
 * Commande : GenerateInvoice(orderId)
 *   => Événement : InvoiceGenerated(invoiceId, orderId)
 * Commande : PayInvoice(invoiceId)
 *   => Événement : InvoicePaid
 * Projection : InvoiceSummaryView, CustomerOrderHistory
 *
 * Scénario 3 : Livraison de la commande
 * Commande : StartShipping(orderId, address)
 *   => Événement : ShippingStarted
 * Commande : DeliverOrder(orderId)
 *   => Événement : OrderDelivered
 * Projection : ShippingStatusView, OrderView
 */

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;

    private boolean confirmed;
    private boolean paid;
    private boolean shipped;
    private boolean delivered;

    private List<OrderLineDTO> orderLines = new ArrayList<>();

    public OrderAggregate() {}

    @CommandHandler
    public OrderAggregate(CreateOrderCommand cmd) {
        apply(new OrderCreatedEvent(cmd.getId(), cmd.getOrderDTO()));
    }

    @CommandHandler
    public void handle(AddProductToOrderCommand cmd) {
        apply(new ProductAddedToOrderEvent(cmd.getId(), cmd.getOrderLineDTO()));
    }

    @CommandHandler
    public void handle(ConfirmOrderCommand cmd) {
        apply(new OrderConfirmedEvent(cmd.getId()));
    }

    @CommandHandler
    public void handle(GenerateInvoiceCommand cmd) {
        apply(new InvoiceGeneratedEvent(cmd.getId(), cmd.getInvoiceDTO()));
    }

    @CommandHandler
    public void handle(PayInvoiceCommand cmd) {
        apply(new InvoicePaidEvent(cmd.getId()));
    }

    @CommandHandler
    public void handle(StartShippingCommand cmd) {
        apply(new ShippingStartedEvent(cmd.getId()));
    }

    @CommandHandler
    public void handle(DeliverOrderCommand cmd) {
        apply(new OrderDeliveredEvent(cmd.getId()));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId = event.getId();
    }

    @EventSourcingHandler
    public void on(ProductAddedToOrderEvent event) {
        this.orderLines.add(event.getOrderLineDTO());
    }

    @EventSourcingHandler
    public void on(OrderConfirmedEvent event) {
        this.confirmed = true;
    }

    @EventSourcingHandler
    public void on(InvoiceGeneratedEvent event) {}

    @EventSourcingHandler
    public void on(InvoicePaidEvent event) {
        this.paid = true;
    }

    @EventSourcingHandler
    public void on(ShippingStartedEvent event) {
        this.shipped = true;
    }

    @EventSourcingHandler
    public void on(OrderDeliveredEvent event) {
        this.delivered = true;
    }
}
