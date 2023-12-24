package design.zykus.zykus.clothing.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shipment_id;
    private int order_id;
    private int invoice_number;
    private int shipment_tracking_number;
    private LocalDate shipment_date;
    private String other_shipment_details;

    public Shipment(){};
    public Shipment(int shipment_id, int order_id, int invoice_number, int shipment_tracking_number, LocalDate shipment_date, String other_shipment_details) {
        this.shipment_id = shipment_id;
        this.order_id = order_id;
        this.invoice_number = invoice_number;
        this.shipment_tracking_number = shipment_tracking_number;
        this.shipment_date = shipment_date;
        this.other_shipment_details = other_shipment_details;
    }

    public int getShipment_id() {
        return shipment_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(int invoice_number) {
        this.invoice_number = invoice_number;
    }

    public int getShipment_tracking_number() {
        return shipment_tracking_number;
    }

    public void setShipment_tracking_number(int shipment_tracking_number) {
        this.shipment_tracking_number = shipment_tracking_number;
    }

    public LocalDate getShipment_date() {
        return shipment_date;
    }

    public void setShipment_date(LocalDate shipment_date) {
        this.shipment_date = shipment_date;
    }

    public String getOther_shipment_details() {
        return other_shipment_details;
    }

    public void setOther_shipment_details(String other_shipment_details) {
        this.other_shipment_details = other_shipment_details;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipment_id=" + shipment_id +
                ", order_id=" + order_id +
                ", invoice_number=" + invoice_number +
                ", shipment_tracking_number=" + shipment_tracking_number +
                ", shipment_date=" + shipment_date +
                ", other_shipment_details='" + other_shipment_details + '\'' +
                '}';
    }
}
