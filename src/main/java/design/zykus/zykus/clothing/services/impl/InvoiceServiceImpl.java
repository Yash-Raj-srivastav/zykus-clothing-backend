package design.zykus.zykus.clothing.services.impl;

import design.zykus.zykus.clothing.repository.InvoiceRepository;
import design.zykus.zykus.clothing.entities.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Iterable<Invoice> getAllInvoices(){
        return invoiceRepository.findAll();
    }

    public ResponseEntity<Invoice> getSingleInvoice(Long invoiceNumber){
        return invoiceRepository.findById(invoiceNumber)
                .map(existingInvoice -> ResponseEntity.ok(existingInvoice))
                .orElse(ResponseEntity.notFound().build());
    }

    public Invoice addNewInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }

    public Iterable<Invoice> addMultipleNewInvoices(Iterable<Invoice> invoices){
        return invoiceRepository.saveAll(invoices);
    }

    public ResponseEntity<Invoice> updateExistingInvoice(Invoice invoice,Long invoiceNumber){
        return invoiceRepository.findById(invoiceNumber)
                .map(existingInvoice -> {
                    if(invoice.getInvoiceStatusCode() != null){
                        existingInvoice.setInvoiceStatusCode(invoice.getInvoiceStatusCode());
                    }
                    if(invoice.getInvoiceDetails() != null){
                        existingInvoice.setInvoiceDetails(invoice.getInvoiceDetails());
                    }
                    Invoice savedInvoice = invoiceRepository.save(existingInvoice);
                    return ResponseEntity.ok(savedInvoice);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Invoice> deleteExistingInvoice(Long invoiceNumber){
        return invoiceRepository.findById(invoiceNumber)
                .map(existingInvoice -> {
                    Invoice deletedInvoice = null;
                    if(existingInvoice.getInvoiceNumber() == invoiceNumber){
                        deletedInvoice = existingInvoice;
                        invoiceRepository.deleteById(invoiceNumber);
                    }
                    return ResponseEntity.ok(deletedInvoice);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
