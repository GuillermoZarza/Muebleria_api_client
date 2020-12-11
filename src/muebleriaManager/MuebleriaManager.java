package muebleriaManager;


import java.util.ArrayList;
import java.util.Date;

import com.fiuni.sd.api_muebleria.dtos.sale_invoice_detail.SaleInvoiceDetailsDTO;

import sale_invoice.SaleInvoiceManager;


public class MuebleriaManager {

	public static void main(String[] args) {
		System.out.println("Prueba Muebleria");
		
		
	/*	SupplierManager supplier = new SupplierManager();
		supplier.addSupplier("Guillermo","Zarza","3484011", "Kaaguy rory, Encarnacion", "0975642894",20);
		
		supplier.getAllsupplier();
		
		supplier.getByIdsupplier(8);
	*/
	/*	
		ProductManager product = new ProductManager();
		product.addProduct("Silla LC2", "3 cuerpos, color negro", 5000000, 5);
		product.getAllproduct();
		product.getByIdproduct(2);
	*/
	// Prueba factura de venta	
		@SuppressWarnings("deprecation")
		Date date = new Date(2019, 12, 20);
		SaleInvoiceManager invoice = new SaleInvoiceManager();
		ArrayList<SaleInvoiceDetailsDTO> detalles = new ArrayList<SaleInvoiceDetailsDTO>();
		SaleInvoiceDetailsDTO detalle1 = new SaleInvoiceDetailsDTO();
		detalle1.setProductId(3);
		detalle1.setQuantity(1);
		detalle1.setSaleInvoiceId(3);
		
		SaleInvoiceDetailsDTO detalle2 = new SaleInvoiceDetailsDTO();
		detalle2.setProductId(2);
		detalle2.setQuantity(1);
		detalle2.setSaleInvoiceId(3);
		
		detalles.add(detalle1);
		detalles.add(detalle2);
		
		invoice.addSaleInvoice(4,101014,  date, 2, 500000, detalles);
		invoice.getAllsaleInvoice();
		invoice.getByIdsaleInvoice(2);
		
	}
}
