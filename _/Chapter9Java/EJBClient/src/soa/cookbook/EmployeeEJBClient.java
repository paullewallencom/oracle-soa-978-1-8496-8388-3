package soa.cookbook;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import soa.cookbook.model.Address;
import soa.cookbook.model.Employee;
import soa.cookbook.model.EmployeeEJB;

public class EmployeeEJBClient implements EmployeeEJBBean {
    private static final String PROVIDER_URL = "t3://soavbox.oracle.com:8001";
  public static void main(String [] args) {
    try {
      final Context context = getInitialContext();
      EmployeeEJBClient empClient = new EmployeeEJBClient((EmployeeEJB)context.lookup("EmployeeSessionEJB#soa.cookbook.model.EmployeeEJB"));
      for (int i = 1; i < 4; i++) {
        Employee emp = empClient.getEmployeeByNumber(i);
        System.out.println(emp.getName());
      }
      Employee emp = new Employee();
      emp.setName("Christopher Robin");
      emp.setAddress(new Address("Big House", "Hundred Acre Wood"));
      emp.setPhone("123-456-7891");
      Employee newEmp = empClient.addEmployee(emp);
      System.out.println(newEmp.getENum());
      Employee[] emps = empClient.getEmployees();
      for (Employee e : emps) {
        System.out.println(e.getENum()+","+e.getName()+","+e.getAddress().getAddr()+" "+e.getAddress().getCity()+","+e.getPhone());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static Context getInitialContext() throws NamingException {
    Hashtable env = new Hashtable();
    // WebLogic Server 10.x connection details
    env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
    env.put(Context.PROVIDER_URL, PROVIDER_URL);
    return new InitialContext( env );
  }
  
  private EmployeeEJB employeeEJB = null;
  
  public EmployeeEJBClient(EmployeeEJB employeeEJB) {
    this.employeeEJB = employeeEJB;
  }
  
  public Employee getEmployeeByNumber(long num) {
    return employeeEJB.getEmployeeByNumber(num);
  }
  
  public Employee addEmployee(Employee emp) {
    return employeeEJB.addEmployee(emp.getName(), emp.getAddress(), emp.getPhone());
  }
  
  public Employee[] getEmployees() {
    return employeeEJB.getEmployees();
  }
  
}
