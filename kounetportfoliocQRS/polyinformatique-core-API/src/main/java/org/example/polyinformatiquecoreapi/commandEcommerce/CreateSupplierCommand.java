package org.example.polyinformatiquecoreapi.commandEcommerce;

import org.example.polyinformatiquecoreapi.dtoEcommerce.SupplierDTO;

public class CreateSupplierCommand extends BaseCommand<String> {
    private final SupplierDTO supplierDTO;

    public CreateSupplierCommand(String id, SupplierDTO supplierDTO) {
        super(id);
        this.supplierDTO = supplierDTO;
    }

    public SupplierDTO getSupplierDTO() {
        return supplierDTO;
    }
}