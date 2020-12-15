package purchase_invoice;

import java.util.Date;
import com.fiuni.sd.api_muebleria.dtos.purchase_invoice.PurchaseInvoiceDTO;
import com.fiuni.sd.api_muebleria.dtos.purchase_invoice.PurchaseInvoiceResult;
import com.fiuni.sd.api_muebleria.dtos.purchase_invoice_detail.PurchaseInvoiceDetailsDTO;

import java.util.ArrayList;
import base.AbstractBaseManager;

public class PurchaseInvoiceManager extends AbstractBaseManager {
	public PurchaseInvoiceManager() {
		super();
	}
	/* guardar */
	public void addpurchaseInvoice(Integer id,Integer numero, Date fecha, Integer proveedorId, Integer total, ArrayList<PurchaseInvoiceDetailsDTO> detalles) {
		PurchaseInvoiceDTO purchaseInvoiceDTO = new PurchaseInvoiceDTO();
		purchaseInvoiceDTO.setId(id);
		purchaseInvoiceDTO.setNumber(numero);
		purchaseInvoiceDTO.setDate(fecha);
		purchaseInvoiceDTO.setSupplierId(proveedorId);
		purchaseInvoiceDTO.setTotal(total);
		purchaseInvoiceDTO.setPurchaseInvoiceDetails(detalles);
		
		
		getJerseyClient().resource(getBaseUrl() + "/purchaseInvoice").entity(purchaseInvoiceDTO).post(PurchaseInvoiceDTO.class);
	}
	
	/* obtener todo */
	public void getAllpurchaseInvoice() {
		PurchaseInvoiceResult purchaseInvoiceResult = getJerseyClient().resource(getBaseUrl() + "/purchaseInvoice").get(PurchaseInvoiceResult.class);
		for (PurchaseInvoiceDTO c : purchaseInvoiceResult.getPurchaseInvoices()) {
			System.out.println("Numero de Factura: "+c.getNumber());
			System.out.println("Fecha: "+c.getDate());
			System.out.println("Proveedor: "+c.getSupplierId());
			System.out.println("Total: "+c.getTotal());
			System.out.println("Items:"+c.getPurchaseInvoiceDetails().toString());
		
		}
	}
	
	/* obtener por id */
	public void getByIdpurchaseInvoice(int id){
		PurchaseInvoiceDTO purchaseInvoice = getJerseyClient().resource(getBaseUrl() + "/purchaseInvoice/"+id).get(PurchaseInvoiceDTO.class);
		
		System.out.println("Numero de Factura: "+purchaseInvoice.getNumber());
		System.out.println("Fecha: "+purchaseInvoice.getDate());
		System.out.println("Proveedor: "+purchaseInvoice.getSupplierId());
		System.out.println("Total: "+purchaseInvoice.getTotal());
		System.out.println("Items:"+purchaseInvoice.getPurchaseInvoiceDetails().toString());
		if(purchaseInvoice.getPurchaseInvoiceDetails()==null) {
			System.out.println("============    sin detalles    ===============");
		}
		for (PurchaseInvoiceDetailsDTO item : purchaseInvoice.getPurchaseInvoiceDetails()) {
			System.out.println("Item id: "+item.getId());
			System.out.println("Producto id: "+item.getProductId());
			System.out.println("Cantidad: "+item.getQuantity());
			System.out.println("Precio: "+item.getPrice());
		}
	}
	/* encontrar por alguna propiedad */
	public void getByPropertypurchaseInvoice(String textToFind){
		PurchaseInvoiceResult purchaseInvoiceResult = getJerseyClient().resource(getBaseUrl() + "/purchaseInvoice/search/"+textToFind).get(PurchaseInvoiceResult.class);
		for (PurchaseInvoiceDTO c : purchaseInvoiceResult.getPurchaseInvoices()) {
			System.out.println("Numero de Factura: "+c.getNumber());
			System.out.println("Fecha: "+c.getDate());
			System.out.println("Proveedor: "+c.getSupplier().getName());
			System.out.println("Total: "+c.getTotal());
			System.out.println("Items:"+c.getPurchaseInvoiceDetails().toString());
		}
		
	}
	
}
