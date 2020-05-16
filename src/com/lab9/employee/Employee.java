package com.lab9.employee;

import com.lab9.exceptions.FieldLengthLimitException;
import com.lab9.exceptions.IncorrectSalaryException;
import com.lab9.manager.Manager;

public class Employee {

    /**
     * Contains ID of the employee.
     */
    private int ID;

    /**
     * Contains name of the employee.
     */
    private String name;

    /**
     * Contains surname of the employee.
     */
    private String surname;

    /**
     * Contains salary of the employee.
     */
    private double salary;

    /**
     * Contains manager of the employee.
     */
    private Manager manager;

    /**
     * Default constructor.
     */
    public Employee() throws IncorrectSalaryException {
        setSalary(1000);
    }

    /**
     * Custom constructor.
     *
     * @param ID      ID.
     * @param name    name.
     * @param surname surname.
     */
    public Employee(int ID, String name, String surname)
            throws IncorrectSalaryException, FieldLengthLimitException {
        this();
        setID(ID);
        setName(name);
        setSurname(surname);
    }

    /**
     * Custom constructor.
     *
     * @param ID      ID.
     * @param name    name.
     * @param surname surname.
     * @param salary  salary.
     */
    public Employee(int ID, String name, String surname, double salary)
            throws IncorrectSalaryException, FieldLengthLimitException{
        this(ID, name, surname);
        setSalary(salary);
    }

    /**
     * Custom constructor.
     *
     * @param ID      ID.
     * @param name    name.
     * @param surname surname.
     * @param salary  salary.
     * @param manager manager.
     */
    public Employee(int ID, String name, String surname, double salary, Manager manager)
            throws IncorrectSalaryException, FieldLengthLimitException {
        this(ID, name, surname, salary);
        setManager(manager);
    }

    /**
     * ID getter.
     *
     * @return ID.
     */
    public final int getID() {
        return this.ID;
    }

    /**
     * Name getter.
     *
     * @return name.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Surname getter.
     *
     * @return name.
     */
    public final String getSurname() {
        return this.surname;
    }

    /**
     * Salary getter.
     *
     * @return salary.
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * Manager getter.
     *
     * @return manager.
     */
    public final Manager getManager() {
        return this.manager;
    }

    /**
     * ID setter.
     *
     * @param ID
     */
    public final void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Name setter.
     *
     * @param name
     */
    public final void setName(String name) throws FieldLengthLimitException {
        if (name == null) {
            throw new NullPointerException();
        } else if (name.length() < 2 || name.length() > 20) {
            throw new FieldLengthLimitException("Wrong name length!");
        }
        this.name = name;
    }

    /**
     * surname setter.
     *
     * @param surname
     */
    public final void setSurname(String surname) throws FieldLengthLimitException {
        if (surname == null) {
            throw new NullPointerException();
        } else if (surname.length() < 2 || surname.length() > 20) {
            throw new FieldLengthLimitException("Wrong name length!");
        }
        this.surname = surname;
    }

    /**
     * salary setter.
     *
     * @param salary
     */
    public void setSalary(double salary) throws IncorrectSalaryException {
        if (salary <= 0) {
            throw new IncorrectSalaryException("Salary can't be lower 0");
        } else {
            this.salary = salary;
        }
    }

    /**
     * Manager setter.
     *
     * @param manager
     */
    public final void setManager(Manager manager) {
        if (manager == null) {
            throw new NullPointerException("Manager is null!");
        }
        this.manager = manager;
    }

    /**
     * Method for raising of salary.
     *
     * @param p percents.
     */
    public final void raiseSalary(double p) throws IncorrectSalaryException {
        if (p < 0) {
            throw new IncorrectSalaryException("You can't raise salary!");
        } else {
            setSalary((getSalary() * p / 100) + getSalary());
        }
    }

    /**
     * Gets manager name.
     *
     * @return if manager is not null, returns string with
     * his name and surname.
     */
    public final String getManagerName() {
        if (getManager() != null) {
            return getManager().getName() + " " + getManager().getSurname();
        } else {
            return "Nomanager";
        }
    }

    /**
     * Method for getting top manager of current hierarchy.
     *
     * @return employee object.
     */
    public final Employee getTopManager() {
        if (getManager() != null) {
            return getManager().getTopManager();
        } else {
            return this;
        }
    }

    /**
     * toString overriding.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Employee ID: " + getID() + "\n" +
                "Name: " + getName() + "\n" +
                "Surname: " + getSurname() + "\n" +
                "Salary: " + getSalary() + "\n" +
                "Manager: " + getManagerName() + "\n";
    }
}
