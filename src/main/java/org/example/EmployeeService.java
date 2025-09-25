
package org.example;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.example.Connections.Hibernatecon;
import org.example.Employee;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeService {
public SessionFactory sessionFactory= Hibernatecon.getSession();
    public void SaveEmp(Employee e){
        try(Session session=sessionFactory.openSession()){
            Transaction t=session.beginTransaction();
            session.persist(e);
            System.out.println("save ");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public Employee GetbyId(int id){
        try(Session session=sessionFactory.openSession()){
            //cannot use get refrence beacuse of lazy intializer
            Employee e=session.byId(Employee.class).getReference(id);
            Hibernate.initialize(e);
            return e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Employee update(int id,Employee emp){
        try(Session session=sessionFactory.openSession()){
           Transaction t=session.beginTransaction();
           Employee e=session.find(Employee.class,id);
           if(e!=null){
               e.setName(emp.getName());
               e.setSalary(emp.getSalary());
               e=session.merge(e);
               t.commit();
           }
            return e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getAllemployee(){
try(Session session=sessionFactory.openSession()){
    String getHql="From Employee";
    Query<Employee> query=session.createQuery(getHql,Employee.class);
    return query.list();
}
    }
}
