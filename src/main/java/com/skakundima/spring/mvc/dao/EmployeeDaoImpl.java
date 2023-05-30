package com.skakundima.spring.mvc.dao;



import com.skakundima.spring.mvc.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Queue;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    //@Transactional
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        /*List<Employee> allEmployee = session.createQuery("from Employee", Employee.class)
                .getResultList();*/

        //Вариант с разделение выражения на 2 действия
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {

        Session session = sessionFactory.getCurrentSession();



        session.saveOrUpdate(employee); // метод производящий абдейт если работник уже существует

    }

    @Override
    public Employee getEmployee(int id) {

        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);

        return employee;

    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee"+
                "where id =:employeeId");

        query.setParameter("employeeId",id);
        query.executeUpdate();

    }
}
