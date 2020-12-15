package purchase_order;

import java.util.Date;
import com.fiuni.sd.api_muebleria.dtos.purchase_order.PurchaseOrderDTO;
import com.fiuni.sd.api_muebleria.dtos.purchase_order.PurchaseOrderResult;
import com.fiuni.sd.api_muebleria.dtos.purchase_order_detail.PurchaseOrderDetailsDTO;

import java.util.ArrayList;
import base.AbstractBaseManager;

public class PurchaseOrderManager extends AbstractBaseManager {
	public PurchaseOrderManager() {
		super();
	}
	/* guardar */
	public void addPurchaseOrder(Integer id,Integer numero, Date fecha, Integer proveedorId, Integer total, ArrayList<PurchaseOrderDetailsDTO> detalles) {
		PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
		purchaseOrderDTO.setId(id);
		purchaseOrderDTO.setNumber(numero);
		purchaseOrderDTO.setDate(fecha);
		purchaseOrderDTO.setSupplierId(proveedorId);
		purchaseOrderDTO.setTotal(total);
		purchaseOrderDTO.setPurchaseOrderDetails(detalles);
		
		
		getJerseyClient().resource(getBaseUrl() + "/purchaseOrder").entity(purchaseOrderDTO).post(PurchaseOrderDTO.class);
	}
	
	/* obtener todo */
	public void getAllpurchaseOrder() {
		PurchaseOrderResult purchaseOrderResult = getJerseyClient().resource(getBaseUrl() + "/purchaseOrder").get(PurchaseOrderResult.class);
		for (PurchaseOrderDTO c : purchaseOrderResult.getPurchaseOrders()) {
			System.out.println("Numero de Pedido: "+c.getNumber());
			System.out.println("Fecha: "+c.getDate());
			System.out.println("Proveedor: "+c.getSupplierId());
			System.out.println("Total: "+c.getTotal());
			System.out.println("Items:"+c.getPurchaseOrderDetails().toString());
		
		}
	}
	
	/* obtener por id */
	public void getByIdpurchaseOrder(int id){
		PurchaseOrderDTO purchaseOrder = getJerseyClient().resource(getBaseUrl() + "/purchaseOrder/"+id).get(PurchaseOrderDTO.class);
		
		System.out.println("Numero de Pedido: "+purchaseOrder.getNumber());
		System.out.println("Fecha: "+purchaseOrder.getDate());
		System.out.println("Proveedor: "+purchaseOrder.getSupplierId());
		System.out.println("Total: "+purchaseOrder.getTotal());
		System.out.println("Items:"+purchaseOrder.getPurchaseOrderDetails().toString());
		if(purchaseOrder.getPurchaseOrderDetails()==null) {
			System.out.println("============    sin detalles    ===============");
		}
		for (PurchaseOrderDetailsDTO item : purchaseOrder.getPurchaseOrderDetails()) {
			System.out.println("Item id: "+item.getId());
			System.out.println("Producto id: "+item.getProductId());
			System.out.println("Cantidad: "+item.getQuantity());
			System.out.println("Precio: "+item.getPrice());
		}
	}
	/* encontrar por alguna propiedad */
	public void getByPropertypurchaseOrder(String textToFind){
		PurchaseOrderResult purchaseOrderResult = getJerseyClient().resource(getBaseUrl() + "/purchaseOrder/search/"+textToFind).get(PurchaseOrderResult.class);
		for (PurchaseOrderDTO c : purchaseOrderResult.getPurchaseOrders()) {
			System.out.println("Numero de Pedido: "+c.getNumber());
			System.out.println("Fecha: "+c.getDate());
			System.out.println("Proveedor: "+c.getSupplier().getName());
			System.out.println("Total: "+c.getTotal());
			System.out.println("Items:"+c.getPurchaseOrderDetails().toString());
		}
		
	}
	
}
