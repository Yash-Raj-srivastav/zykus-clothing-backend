package design.zykus.zykus.clothing.controller;

import design.zykus.zykus.clothing.entities.Invoice;
import design.zykus.zykus.clothing.services.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceServiceImpl invoiceService;

    @GetMapping("/")
    public Iterable<Invoice> getAllInvoices(){
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{invoiceNumber}")
    public ResponseEntity<Invoice> getSingleInvoice(@PathVariable("invoiceNumber") Long invoiceNumber){
        return invoiceService.getSingleInvoice(invoiceNumber);
    }

    @PostMapping("/")
    public Invoice addNewInvoice(@RequestBody Invoice invoice){
        return invoiceService.addNewInvoice(invoice);
    }

    @PostMapping("/add_multiple")
    public Iterable<Invoice> addMultipleNewInvoices(@RequestBody Iterable<Invoice> invoices){
        return invoiceService.addMultipleNewInvoices(invoices);
    }

    @PutMapping("/{invoiceNumber}")
    public ResponseEntity<Invoice> updateExistingInvoice(@RequestBody Invoice invoice, @PathVariable("invoiceNumber") Long invoiceNumber){
        return invoiceService.updateExistingInvoice(invoice, invoiceNumber);
    }

    @DeleteMapping("/{invoiceNumber}")
    public ResponseEntity<Invoice> deleteExistingInvoice(@PathVariable("invoiceNumber") Long invoiceNumber){
        return invoiceService.deleteExistingInvoice(invoiceNumber);
    }
}
