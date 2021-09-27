/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.AccountDao;
import model.AccountDaoImplementation;
import model.Customer;
import model.CustomerDao;
import model.CustomerDaoImplementation;
import model.Movement;
import model.MovementDao;
import model.MovementDaoImplementation;
import model.Type;
import utilities.Util;

/**
 *
 * @author Miguel Sanchez, Zeeshan Yaqoob, Aitor Ruiz de Gauna
 */
public class Menu {
    
    private AccountDao accountDao=new AccountDaoImplementation();
    private CustomerDao customerDao=new CustomerDaoImplementation();
    private MovementDao movementDao= new MovementDaoImplementation();

    public void mostrarMenu() {
         System.out.println(
                  "1. Create customer.\n"
                + "2. Consult customer.\n"
                + "3. Consult accounts of a client.\n"
                + "4. Create customer acount.\n"
                + "5. Add customer to account.\n"
                + "6. Consult details of an account.\n"
                + "7. Make movement on an account.\n"
                + "8. Consult movement of an account.\n"
                + "9. Salir\n");
         
        
    }

    public void ejecutarOpcion() {
        int opcion=0;
        boolean salir=false;
        
        do{
            mostrarMenu();
            opcion=Util.leerInt("Introduce la opcion.");
            switch (opcion) {
            case 1:
                createCustomer();
                break;
            case 2:
                findCustomer();
                break;
            case 3:
                consultAccounts();
                break;
            case 4:
                createCustomerAccount();
                break;
            case 5:
                addCustomerToAccount();
                break;
            case 6:
                consultDetailsAccount();
                break;
            case 7:
                makeMovement();
                break;
            case 8:
                listAccountMovements();
                break;
            case 9:
                salir=true;
                System.out.println("Hasta luego");
                break;
            default:
                break;
        }
          }while(!salir);
            
        
        
    }
    
    public void createCustomer(){
        
        Customer customer=new Customer();
        customer.setId(Util.leerInt("Introduce id"));
        customer.setFirstName(Util.introducirCadena("Introduce el nombre"));
        customer.setLastName(Util.introducirCadena("Introduce el apellido"));
        customer.setMiddleInitial(Util.introducirCadena("Introduce iniciales"));
        customer.setStreet(Util.introducirCadena("Introduce la calle"));
        customer.setCity(Util.introducirCadena("Introduce ciudad"));
        customer.setState(Util.introducirCadena("Introduce provincia"));
        customer.setZip(Util.leerInt("Introduce el zip"));
        customer.setPhone(Util.leerInt("Introduce el telefono"));
        customer.setEmail(Util.introducirCadena("Introduce el email"));
        try {
            customerDao.createCustomer(customer);
        } catch (Exception ex) {
            System.out.println("Error al crear customer.");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void findCustomer() {
        
        
        mostrarClientes();
        int idBuscar=Util.leerInt("Introduce el id para buscar el customer.");
        try {
            Customer customer=customerDao.checkCustomer(idBuscar);
            System.out.println(customer.toString());
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            System.out.println("Id repetido.");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void consultAccounts() {
        
        mostrarClientes();
        long idBuscar=Util.leerLong("Introduce el id para buscar el customer.");
        try {
            customerDao.checkCustomerAccounts(idBuscar);
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            System.out.println("Id no encontrado.");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void createCustomerAccount() {
        
        Account account=new Account();
        account.setId(Util.leerInt("Introduce el id"));
        account.setBalance(Util.leerDouble("Introduce el saldo"));
        account.setBeginBalance(Util.leerDouble("Introduce el saldo de inicio"));
        account.setBeginBalanceTimestamp(Util.leerFechaHora("Introduce la fecha del primer saldo"));
        account.setDescription(Util.introducirCadena("Introduce la descripcion"));
        account.setCreditLine(Util.leerDouble("Introduce la linea de credito"));
        account.setType(Util.leerInt("Introduce el tipo.(0=credito/1=standart)",0,1));
        try {
            accountDao.createAccount(account);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            System.out.println("Error al crear cuenta.");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void addCustomerToAccount() {
        mostrarCuentas();
        int accountId=Util.leerInt("Introduce el id de la cuenta para añadirla al cliente");
        mostrarClientes();
        int customerId=Util.leerInt("Introduce el id del cliente para añadirle la cuenta");
        try {
            accountDao.addCustomerToAccount(customerId,accountId);
        } catch (Exception ex) {
            System.out.println("Error al añadir cliente a cuenta");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void consultDetailsAccount() {
        
        
        mostrarCuentas();
        int accountId=Util.leerInt("Introduce el id de la cuenta para añadirla al cliente");
        try {
            Account cuenta=accountDao.consultAccountDetails(accountId);
            System.out.println("Id: "+cuenta.getId()
                                +"Balance: "+cuenta.getBalance()
                                +"Begin Balance: "+cuenta.getBeginBalance()
                                +"Begin balance date: "+cuenta.getBeginBalanceTimestamp()
                                +"Description: "+cuenta.getDescription()
                                +"Credit line"+cuenta.getCreditLine()
                                +"Type"+Type.values()[cuenta.getType()]);
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            System.out.println("Error al encontrar la cuenta.");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void makeMovement() {
        
        mostrarCuentas();
        Movement movement=new Movement();
        movement.setAccountID(Util.leerInt("Introduce el id de la cuenta para hacer el movimiento"));
        movement.setAmount(Util.leerDouble("Introduce la cantidad"));
        movement.setBalance(Util.leerDouble("introduce el saldo"));
        movement.setDescription(Util.introducirCadena("Introduce la descripcion"));
        movement.setTimestamp(Util.leerFechaHora("Introduce la fecha del movimiento."));
        try {
            movementDao.addMovement(movement);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void listAccountMovements() {
        
        ArrayList<Movement> movimientos=new ArrayList<>();
        mostrarCuentas();
        try {
            movimientos=movementDao.listMovements(Util.leerInt("Introduce el id de la cuenta para mostrar los movimientos."));
            for(Movement m : movimientos){
                System.out.println("Id: "+ m.getId());
                System.out.println("Cantidad: "+ m.getAmount());
                System.out.println("Saldo: "+ m.getBalance());
                System.out.println("Descripcion: "+ m.getDescription());
                System.out.println("Fecha: "+ m.getTimestamp());
            }
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void mostrarClientes (){
        try {
            ArrayList<Customer> customers=customerDao.getCustomers();
            for(int i=0;i<customers.size();i++){
                System.out.println("****Cliente numero "+(i+1)+"****");
                System.out.println("Nombre: "+customers.get(i).getFirstName()
                                    +"\tId: "+customers.get(i).getId());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarCuentas(){
        int numero=0;
        try {
            Set<Integer> accounts=accountDao.listAccountsId();
            for(Integer i : accounts){
                
                System.out.println("****Cuenta numero "+(numero+1)+"****");
                System.out.println("Id: "+i);
                numero++;
                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    

    

    

    

    

}
