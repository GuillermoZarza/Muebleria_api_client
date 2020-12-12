package client;

import com.fiuni.sd.api_muebleria.dtos.client.ClientDTO;
import com.fiuni.sd.api_muebleria.dtos.client.ClientResult;
import base.AbstractBaseManager;


public class ClientManager extends AbstractBaseManager {
	public ClientManager() {
		super();
	}
	/* crear */
	public void addClient(String name,String surname,String ruc, String address,  String phone, Integer id) {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setName(name);
		clientDTO.setSurname(surname);
		clientDTO.setRUC(ruc);
		clientDTO.setAddress(address);
		clientDTO.setCellphone(phone);
		clientDTO.setType("ClientBean");
		clientDTO.setId(id);
		
		
		getJerseyClient().resource(getBaseUrl() + "/client").entity(clientDTO).post(ClientDTO.class);
	}
	
	/* obtener todo */
	public void getAllclient() {
		ClientResult clientResult = getJerseyClient().resource(getBaseUrl() + "/client").get(ClientResult.class);
		for (ClientDTO c : clientResult.getClients()) {
			System.out.println("Nombre: "+c.getName());
			System.out.println("Apellido: "+c.getSurname());
			System.out.println("Direccion: "+c.getAddress());
			System.out.println("RUC: "+c.getRUC());
			System.out.println("Telefono: "+c.getCellphone());
		}
	}
	
	/* obtener por id */
	public void getByIdclient(int id){
		ClientDTO client = getJerseyClient().resource(getBaseUrl() + "/client/"+id).get(ClientDTO.class);
		System.out.println("Nombre: "+client.getName());
		System.out.println("Apellido: "+client.getSurname());
		System.out.println("Direccion: "+client.getAddress());
		System.out.println("RUC: "+client.getRUC());
		System.out.println("Telefono: "+client.getCellphone());
	}
	/* encontrar por alguna propiedad */
	public void getByPropertyclient(String textToFind){
		// ejemplo buscar por propiedad direccion
		ClientResult clientResult = getJerseyClient().resource(getBaseUrl() + "/client/search/"+textToFind).get(ClientResult.class);
		for (ClientDTO c : clientResult.getClients()) {
			System.out.println("Nombre: "+c.getName());
			System.out.println("Apellido: "+c.getSurname());
			System.out.println("Direccion: "+c.getAddress());
			System.out.println("RUC: "+c.getRUC());
			System.out.println("Telefono: "+c.getCellphone());
		}
		
	}
	
}
