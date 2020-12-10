package product;

import com.fiuni.sd.api_muebleria.dtos.product.ProductDTO;
import com.fiuni.sd.api_muebleria.dtos.product.ProductResult;
import base.AbstractBaseManager;


public class ProductManager extends AbstractBaseManager {
	public ProductManager() {
		super();
	}
	/* crear */
	public void addProduct(String name,String description,Integer price, Integer quantity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName(name);
		productDTO.setDescription(description);
		productDTO.setPrice(price);
		productDTO.setQuantity(quantity);
		
		
		getJerseyClient().resource(getBaseUrl() + "/product").entity(productDTO).post(ProductDTO.class);
	}
	
	/* obtener todo */
	public void getAllproduct() {
		ProductResult productResult = getJerseyClient().resource(getBaseUrl() + "/product").get(ProductResult.class);
		for (ProductDTO c : productResult.getProducts()) {
			System.out.println("Nombre: "+c.getName());
			System.out.println("Descripcion: "+c.getDescription());
			System.out.println("Precio: "+c.getPrice());
			System.out.println("Cantidad: "+c.getQuantity());
			System.out.println("++++++++++++++++++++");
		
		}
	}
	
	/* obtener por id */
	public void getByIdproduct(int id){
		ProductDTO product = getJerseyClient().resource(getBaseUrl() + "/product/"+id).get(ProductDTO.class);
		System.out.println("Nombre: "+product.getName());
		System.out.println("Descripcion: "+product.getDescription());
		System.out.println("Precio: "+product.getPrice());
		System.out.println("Cantidad: "+product.getQuantity());
	}
	/* encontrar por alguna propiedad */
	public void getByPropertyproduct(String textToFind){
		// ejemplo buscar por propiedad direccion
		ProductResult productResult = getJerseyClient().resource(getBaseUrl() + "/product/search/"+textToFind).get(ProductResult.class);
		for (ProductDTO c : productResult.getProducts()) {
			System.out.println("Nombre: "+c.getName());
			System.out.println("Descripcion: "+c.getDescription());
			System.out.println("Precio: "+c.getPrice());
			System.out.println("Cantidad: "+c.getQuantity());
		}
		
	}
	
}
