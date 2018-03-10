package com.veera.hibernate.testing;

import com.veera.hibernate.entity.Department;
import com.veera.hibernate.entity.Employee;
import com.veera.hibernate.util.JPAUtil;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ManyToOneExample {

    public static void main(String[] args) {
        EntityManager entityManager = null;

        try {
            entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();

            Department department = new Department();
            department.setName("Income Tax");

            entityManager.persist(department);

            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();
            Employee employee = new Employee();
            employee.setFirstName("Kanumilli");
            employee.setMiddleName("Veera");
            employee.setLastName("Babu");
            employee.setSalary(1_00_00_000);
            Calendar dob  = Calendar.getInstance();
            dob.set(Calendar.YEAR, 1981);
            dob.set(Calendar.MONTH, Calendar.DECEMBER);
            dob.set(Calendar.DATE, 23);
            dob.set(Calendar.HOUR, 0);
            dob.set(Calendar.MINUTE, 0);
            dob.set(Calendar.SECOND, 0);
            dob.set(Calendar.MILLISECOND, 0);
            employee.setDob(dob.getTime());
            employee.setDepartment(department);

            entityManager.persist(employee);
            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();

            Department department1 = entityManager.find(Department.class, department.getOid());
            System.out.println("Department Name: " + department1.getName());
            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();
            Employee employee1 = entityManager.find(Employee.class, employee.getOid());
            System.out.println("Employee Name " + employee1.getFirstName() + " " + employee1.getMiddleName() + " " + employee1.getLastName()
            + ", Salary " + employee1.getSalary() + ", DOB " + new SimpleDateFormat("dd-MM-yyyy").format(employee1.getDob()));

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
