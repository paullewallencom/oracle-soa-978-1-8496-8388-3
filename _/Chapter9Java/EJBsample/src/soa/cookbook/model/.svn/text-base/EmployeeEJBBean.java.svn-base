package soa.cookbook.model;

import java.util.HashMap;

import java.util.Map;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless(name="EmployeeEJB", mappedName = "EmployeeSessionEJB")
public class EmployeeEJBBean implements EmployeeEJB, EmployeeEJBLocal {
  private static Map<Long, Employee> map = new HashMap<Long, Employee>();
  private static long empNo = 1;
  static {
    Employee emp =
      new Employee("Pooh", empNo++, new Address("Pooh Corner", "Hundred Acre Wood"),
                   "123-123-1234");
    map.put(emp.getENum(), emp);
    emp =
        new Employee("Eeyore", empNo++, new Address("Gloomy Spot", "Hundred Acre Wood"),
                     "123-123-1235");
    map.put(emp.getENum(), emp);
    emp =
        new Employee("Owl", empNo++, new Address("Big Oak", "Hundred Acre Wood"),
                     "123-123-1236");
    map.put(emp.getENum(), emp);
  }

  public EmployeeEJBBean() {
  }

  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public Employee getEmployeeByNumber(long number) {
    return map.get(number);
  }

  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public Employee addEmployee(String name, Address addr, String phone) {
    Employee emp = new Employee(name, empNo++, addr, phone);
    map.put(emp.getENum(), emp);
    return emp;
  }
  
  @TransactionAttribute(TransactionAttributeType.REQUIRED)
  public Employee[] getEmployees() {
    Employee[] a = new Employee[map.size()];
    map.values().toArray(a);
    return a;
  }
}
