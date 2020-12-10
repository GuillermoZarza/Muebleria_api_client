package muebleriaManager;

import product.ProductManager;
import supplier.SupplierManager;

public class MuebleriaManager {

	public static void main(String[] args) {
		System.out.println("Prueba Muebleria");
		SupplierManager supplier = new SupplierManager();
		//supplier.addSupplier("Guillermo","Zarza","3484011", "Kaaguy rory, Encarnacion", "0975642894",20);
		
		//supplier.getAllsupplier();
		
		//supplier.getByIdsupplier(8);
		
		ProductManager product = new ProductManager();
		product.addProduct("Silla LC2", "3 cuerpos, color negro", 5000000, 5);
		product.getAllproduct();
		product.getByIdproduct(2);
	}
}
