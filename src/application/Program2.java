package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TESTE 1 : DEPARTMENT findById");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n=== TESTE 2 : DEPARTMENT findAll");
        List<Department> list = departmentDao.findAll();
        for (Department dep: list){
            System.out.println(dep);
        }

        System.out.println("\n=== TESTE 3 : DEPARTMENT insert");
        Department newDepartment = new Department(5,"TeleMarketing");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " +  newDepartment.getId());

        System.out.println("\n=== TESTE 4 : DEPARTMENT update");
        System.out.print("Informe o numero Id que deseja modificar o Nome: ");
        newDepartment = departmentDao.findById(sc.nextInt());
        sc.nextLine(); // consome o ENTER pendente
        System.out.print("Informe o nome que deseja colocar: ");
        newDepartment.setName(sc.nextLine());
        departmentDao.update(newDepartment);
        System.out.println("Updated! New id = " +  newDepartment.getId() + " New Name = " +  newDepartment.getName());

        System.out.println("\n=== TESTE 6 : Department deleteById");
        System.out.println("Enter id for delete test: ");
        departmentDao.deleteById(sc.nextInt());
        System.out.println("Deleted completed!");
//
//
//        System.out.println("\n=== TESTE 6 : SELLER delete");
//        System.out.println("Enter id for delete test: ");
//        int id = sc.nextInt();
//        sellerDao.deleteById(id);
//        System.out.println("Deleted completed!");
    }
}

