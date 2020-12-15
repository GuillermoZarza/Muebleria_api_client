package employee;

import com.fiuni.sd.api_muebleria.dtos.employee.EmployeeDTO;
import com.fiuni.sd.api_muebleria.dtos.employee.EmployeeResult;
import base.AbstractBaseManager;


public class EmployeeManager extends AbstractBaseManager {
	public EmployeeManager() {
		super();
	}
	/* crear */
	public void addEmployee(String name,String surname,String ruc, String address,  String phone, Integer id) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setName(name);
		employeeDTO.setSurname(surname);
		employeeDTO.setRUC(ruc);
		employeeDTO.setAddress(address);
		employeeDTO.setCellphone(phone);
		employeeDTO.setType("EmployeeBean");
		employeeDTO.setId(id);
		
		
		getJerseyClient().resource(getBaseUrl() + "/employee").entity(employeeDTO).post(EmployeeDTO.class);
	}
	
	/* obtener todo */
	public void getAllemployee() {
		EmployeeResult employeeResult = getJerseyClient().resource(getBaseUrl() + "/employee").get(EmployeeResult.class);
		for (EmployeeDTO c : employeeResult.getEmployees()) {
			System.out.println("Nombre: "+c.getName());
			System.out.println("Apellido: "+c.getSurname());
			System.out.println("Direccion: "+c.getAddress());
			System.out.println("RUC: "+c.getRUC());
			System.out.println("Telefono: "+c.getCellphone());
		}
	}
	
	/* obtener por id */
	public void getByIdemployee(int id){
		EmployeeDTO employee = getJerseyClient().resource(getBaseUrl() + "/employee/"+id).get(EmployeeDTO.class);
		System.out.println("Nombre: "+employee.getName());
		System.out.println("Apellido: "+employee.getSurname());
		System.out.println("Direccion: "+employee.getAddress());
		System.out.println("RUC: "+employee.getRUC());
		System.out.println("Telefono: "+employee.getCellphone());
	}
	/* encontrar por alguna propiedad */
	public void getByPropertyemployee(String textToFind){
		// ejemplo buscar por propiedad direccion
		EmployeeResult employeeResult = getJerseyClient().resource(getBaseUrl() + "/employee/search/"+textToFind).get(EmployeeResult.class);
		for (EmployeeDTO c : employeeResult.getEmployees()) {
			System.out.println("Nombre: "+c.getName());
			System.out.println("Apellido: "+c.getSurname());
			System.out.println("Direccion: "+c.getAddress());
			System.out.println("RUC: "+c.getRUC());
			System.out.println("Telefono: "+c.getCellphone());
		}
		
	}
	
}
