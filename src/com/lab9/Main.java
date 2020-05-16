package com.lab9;

import com.lab9.employee.Employee;
import com.lab9.exceptions.FieldLengthLimitException;
import com.lab9.exceptions.IncorrectSalaryException;
import com.lab9.manager.Manager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[][] name = new String[5][2];
        for (int i = 0; i < name.length; i++) {
            System.out.print("Name: ");
            name[i][0] = in.nextLine();
            System.out.print("Surname: ");
            name[i][1] = in.nextLine();
            System.out.print("\n");
        }

        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < name[i].length; j++) {
                System.out.print(name[i][j]);
            }
            System.out.println();
        }

        Manager manager1 = null;
        Manager manager2 = null;
        Manager manager3 = null;
        Employee employee1 = null;
        Employee employee2 = null;

        ArrayList<Employee> company = new ArrayList<>();

        try {
            manager1 = new Manager(1, name[0][0], name[0][1], 10000);
            manager2 = new Manager(2, name[1][0], name[1][1], 8000, manager1);
            manager3 = new Manager(3, name[2][0], name[2][1], 7000);
            employee1 = new Employee(1, name[3][0], name[3][1], 4000, manager2);
            employee2 = new Employee(2, name[4][0], name[4][1], 5000, manager2);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            System.exit(42);
        } catch (IncorrectSalaryException | FieldLengthLimitException ex) {
            ex.getMessage();
            ex.printStackTrace();
            System.exit(42);
        }

        company.add(manager1);
        company.add(manager2);
        company.add(employee1);
        company.add(employee2);
        company.add(manager3);




        for (Employee human : company) {
            System.out.println(human.toString());
        }
    }
}
