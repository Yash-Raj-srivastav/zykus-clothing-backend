package design.zykus.zykus.clothing.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long invoiceNumber;
    private Long orderId;
    private String invoiceStatusCode;
    private LocalDate invoiceDate;
    private String invoiceDetails;

    public Invoice(){}

    public Invoice(Long invoiceNumber, Long orderId, String invoiceStatusCode, LocalDate invoiceDate, String invoiceDetails) {
        this.invoiceNumber = invoiceNumber;
        this.orderId = orderId;
        this.invoiceStatusCode = invoiceStatusCode;
        this.invoiceDate = invoiceDate;
        this.invoiceDetails = invoiceDetails;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getInvoiceStatusCode() {
        return invoiceStatusCode;
    }

    public void setInvoiceStatusCode(String invoiceStatusCode) {
        this.invoiceStatusCode = invoiceStatusCode;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(String invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber=" + invoiceNumber +
                ", orderId=" + orderId +
                ", invoiceStatusCode='" + invoiceStatusCode + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", invoiceDetails='" + invoiceDetails + '\'' +
                '}';
    }
}
