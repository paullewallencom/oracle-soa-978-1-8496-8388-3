package soa.cookbook;

import soa.cookbook.model.Employee;

public interface EmployeeEJBBean {
  public Employee getEmployeeByNumber(long num);

  public Employee addEmployee(Employee emp);
  
  public Employee[] getEmployees();
}
