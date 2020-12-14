package supplier;

import com.fiuni.sd.api_muebleria.dtos.supplier.SupplierDTO;
import com.fiuni.sd.api_muebleria.dtos.supplier.SupplierResult;
import base.AbstractBaseManager;


public class SupplierManager extends AbstractBaseManager {
	public SupplierManager() {
		super();
	}
	/* crear */
	public void addSupplier(String name,String surname,String ruc, String address,  String phone) {
		SupplierDTO supplierDTO = new SupplierDTO();
		supplierDTO.setName(name);
		supplierDTO.setSurname(surname);
		supplierDTO.setRUC(ruc);
		supplierDTO.setAddress(address);
		supplierDTO.setCellphone(phone);
		supplierDTO.setType("SupplierBean");
		//supplierDTO.setId(id);
		
		
		getJerseyClient().resource(getBaseUrl() + "/supplier").entity(supplierDTO).post(SupplierDTO.class);
	}
	
	/* obtener todo */
	public void getAllsupplier() {
		SupplierResult supplierResult = getJerseyClient().resource(getBaseUrl() + "/supplier").get(SupplierResult.class);
		for (SupplierDTO c : supplierResult.getSuppliers()) {
			System.out.println("Nombre: "+c.getName());
			System.out.println("Apellido: "+c.getSurname());
			System.out.println("Direccion: "+c.getAddress());
			System.out.println("RUC: "+c.getRUC());
			System.out.println("Telefono: "+c.getCellphone());
		}
	}
	
	/* obtener por id */
	public void getByIdsupplier(int id){
		SupplierDTO supplier = getJerseyClient().resource(getBaseUrl() + "/supplier/"+id).get(SupplierDTO.class);
		System.out.println("Nombre: "+supplier.getName());
		System.out.println("Apellido: "+supplier.getSurname());
		System.out.println("Direccion: "+supplier.getAddress());
		System.out.println("RUC: "+supplier.getRUC());
		System.out.println("Telefono: "+supplier.getCellphone());
	}
	/* encontrar por alguna propiedad */
	public void getByPropertysupplier(String textToFind){
		// ejemplo buscar por propiedad direccion
		SupplierResult supplierResult = getJerseyClient().resource(getBaseUrl() + "/supplier/search/"+textToFind).get(SupplierResult.class);
		for (SupplierDTO c : supplierResult.getSuppliers()) {
			System.out.println("Nombre: "+c.getName());
			System.out.println("Apellido: "+c.getSurname());
			System.out.println("Direccion: "+c.getAddress());
			System.out.println("RUC: "+c.getRUC());
			System.out.println("Telefono: "+c.getCellphone());
		}
		
	}
	
}
