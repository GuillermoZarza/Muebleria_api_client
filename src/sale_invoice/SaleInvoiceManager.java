package sale_invoice;

import java.util.Date;
import java.util.ArrayList;

import com.fiuni.sd.api_muebleria.dtos.sale_invoice.SaleInvoiceDTO;
import com.fiuni.sd.api_muebleria.dtos.sale_invoice.SaleInvoiceResult;
import com.fiuni.sd.api_muebleria.dtos.sale_invoice_detail.SaleInvoiceDetailsDTO;

import base.AbstractBaseManager;


public class SaleInvoiceManager extends AbstractBaseManager {
	public SaleInvoiceManager() {
		super();
	}
	/* guardar */
	public void addSaleInvoice(Integer id,Integer numero, Date fecha, Integer clienteId, Integer total, ArrayList<SaleInvoiceDetailsDTO> detalles) {
		SaleInvoiceDTO saleInvoiceDTO = new SaleInvoiceDTO();
		saleInvoiceDTO.setId(id);
		saleInvoiceDTO.setNumber(numero);
		saleInvoiceDTO.setDate(fecha);
		saleInvoiceDTO.setClientId(clienteId);
		saleInvoiceDTO.setTotal(total);
		saleInvoiceDTO.setSaleInvoiceDetails(detalles);
		
		
		getJerseyClient().resource(getBaseUrl() + "/saleInvoice").entity(saleInvoiceDTO).post(SaleInvoiceDTO.class);
	}
	
	/* obtener todo */
	public void getAllsaleInvoice() {
		SaleInvoiceResult saleInvoiceResult = getJerseyClient().resource(getBaseUrl() + "/saleInvoice").get(SaleInvoiceResult.class);
		for (SaleInvoiceDTO c : saleInvoiceResult.getSaleInvoices()) {
			System.out.println("Numero de factura: "+c.getNumber());
			System.out.println("Fecha: "+c.getDate());
			System.out.println("Cliente: "+c.getClientId());
			System.out.println("Total: "+c.getTotal());
			System.out.println("Items:"+c.getSaleInvoiceDetails().toString());
		
		}
	}
	
	/* obtener por id */
	public void getByIdsaleInvoice(int id){
		SaleInvoiceDTO saleInvoice = getJerseyClient().resource(getBaseUrl() + "/saleInvoice/"+id).get(SaleInvoiceDTO.class);
		
		System.out.println("Numero de factura: "+saleInvoice.getNumber());
		System.out.println("Fecha: "+saleInvoice.getDate());
		System.out.println("Cliente: "+saleInvoice.getClientId());
		System.out.println("Total: "+saleInvoice.getTotal());
		System.out.println("Items:"+saleInvoice.getSaleInvoiceDetails().toString());
		if(saleInvoice.getSaleInvoiceDetails()==null) {
			System.out.println("============    sin detalles    ===============");
		}
		for (SaleInvoiceDetailsDTO item : saleInvoice.getSaleInvoiceDetails()) {
			System.out.println("Item id: "+item.getId());
			System.out.println("Producto id: "+item.getProductId());
			System.out.println("Cantidad: "+item.getQuantity());
			System.out.println("Precio: "+item.getPrice());
		}
	}
	/* encontrar por alguna propiedad */
	public void getByPropertysaleInvoice(String textToFind){
		SaleInvoiceResult saleInvoiceResult = getJerseyClient().resource(getBaseUrl() + "/saleInvoice/search/"+textToFind).get(SaleInvoiceResult.class);
		for (SaleInvoiceDTO c : saleInvoiceResult.getSaleInvoices()) {
			System.out.println("Numero de factura: "+c.getNumber());
			System.out.println("Fecha: "+c.getDate());
			System.out.println("Cliente: "+c.getClient().getName());
			System.out.println("Total: "+c.getTotal());
			System.out.println("Items:"+c.getSaleInvoiceDetails().toString());
		}
		
	}
	
}
