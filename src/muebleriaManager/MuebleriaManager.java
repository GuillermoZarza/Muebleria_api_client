package muebleriaManager;

import java.util.ArrayList;
import java.util.Date;

import com.fiuni.sd.api_muebleria.dtos.purchase_invoice_detail.PurchaseInvoiceDetailsDTO;
import com.fiuni.sd.api_muebleria.dtos.purchase_order_detail.PurchaseOrderDetailsDTO;
import com.fiuni.sd.api_muebleria.dtos.sale_invoice_detail.SaleInvoiceDetailsDTO;
import client.ClientManager;
import employee.EmployeeManager;
import product.ProductManager;
import purchase_invoice.PurchaseInvoiceManager;
import purchase_order.PurchaseOrderManager;
import sale_invoice.SaleInvoiceManager;
import supplier.SupplierManager;

public class MuebleriaManager {

	public static void main(String[] args) {
		System.out.println("Prueba Muebleria");
		System.out.println("**************************************************");
		//EmployeeManager employee = new EmployeeManager();
		//employee.addEmployee("Mabi","Almeida","1111111", "Encarnacion", "0985126975",20);
		//employee.getAllemployee();
		//employee.getByIdemployee(5);
		
		//ClientManager client = new ClientManager();
		//client.addClient("Lorena","DelPuerto","4763428", "Encarnacion", "0975857129",20);
		//client.getAllclient();
		//client.getByIdclient(3); 
		
		//SupplierManager supplier = new SupplierManager();
		//supplier.addSupplier("Karina","Sanabria","3484011", "Kaaguy rory, Encarnacion", "0975642894");
		//supplier.getAllsupplier();
		//supplier.getByIdsupplier(8);
	
		
		//ProductManager product = new ProductManager();
		//product.addProduct("Silla LC2", "3 cuerpos, color negro", 5000000, 5);
		//product.getAllproduct();
		//product.getByIdproduct(2);
	
	// Prueba factura de venta	
	/*	@SuppressWarnings("deprecation")
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
		invoice.getByIdsaleInvoice(2);*/
		
		// Prueba de pedido	
			/*@SuppressWarnings("deprecation")
			Date date = new Date(2019, 12, 20);
			PurchaseOrderManager order = new PurchaseOrderManager();
			ArrayList<PurchaseOrderDetailsDTO> detalles = new ArrayList<PurchaseOrderDetailsDTO>();
			PurchaseOrderDetailsDTO detalle1 = new PurchaseOrderDetailsDTO();
			detalle1.setProductId(1);
			detalle1.setQuantity(1);
			detalle1.setPurchaseOrderId(3);*/
			
			//PurchaseOrderDetailsDTO detalle2 = new PurchaseOrderDetailsDTO();
			//detalle2.setProductId(2);
			//detalle2.setQuantity(1);
			//detalle2.setPurchaseOrderId(3);
			
			//detalles.add(detalle1);
			//detalles.add(detalle2);
			
			//order.addPurchaseOrder(4,101014,  date,2, 500000, detalles);
			//order.getAllpurchaseOrder();
			//order.getByIdpurchaseOrder(2);
		
		 //Prueba factura de compra	
			@SuppressWarnings("deprecation")
			Date date = new Date(2019, 12, 15);
			PurchaseInvoiceManager invoice = new PurchaseInvoiceManager();
			ArrayList<PurchaseInvoiceDetailsDTO> detalles = new ArrayList<PurchaseInvoiceDetailsDTO>();
			PurchaseInvoiceDetailsDTO detalle1 = new PurchaseInvoiceDetailsDTO();
			detalle1.setProductId(1);
			detalle1.setQuantity(1);
			detalle1.setPurchaseInvoiceId(3);
			
			/*PurchaseInvoiceDetailsDTO detalle2 = new PurchaseInvoiceDetailsDTO();
			detalle2.setProductId(2);
			detalle2.setQuantity(1);
			detalle2.setPurchaseInvoiceId(3);*/
			
			detalles.add(detalle1);
			//detalles.add(detalle2);
			
			invoice.addpurchaseInvoice(4,101014,  date, 2, 500000, detalles);
			//invoice.getAllpurchaseInvoice();
			//invoice.getByIdpurchaseInvoice(2);
	}
  }
