package soa.cookbook.model;

import javax.ejb.Remote;

@Remote
public interface EmployeeEJB {
  public Employee getEmployeeByNumber(long number);
  public Employee addEmployee(String name, Address addr, String phone);
  public Employee[] getEmployees();
}
