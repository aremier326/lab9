package com.lab9.manager;

import com.lab9.employee.Employee;
import com.lab9.exceptions.FieldLengthLimitException;
import com.lab9.exceptions.IncorrectSalaryException;

public class Manager extends Employee {
    /**
     * Contains bonus.
     */
    private double bonus;

    /**
     * Default constructor.
     */
    public Manager() throws IncorrectSalaryException {
        super();
    }

    /**
     * Custom constructor.
     *
     * @param employee employee object.
     */
    public Manager(Employee employee)
            throws IncorrectSalaryException, FieldLengthLimitException {
        super(employee.getID(),
                employee.getName(),
                employee.getSurname(),
                employee.getSalary(),
                employee.getManager());
    }

    /**
     * Custom constructor.
     *
     * @param ID      id.
     * @param name    name.
     * @param surname surname.
     */
    public Manager(int ID, String name, String surname)
            throws IncorrectSalaryException, FieldLengthLimitException {
        super(ID, name, surname);
    }

    /**
     * Custom constructor.
     *
     * @param ID      id.
     * @param name    name.
     * @param surname surname.
     * @param salary  salary.
     */
    public Manager(int ID, String name,
                   String surname, double salary)
            throws IncorrectSalaryException, FieldLengthLimitException {
        super(ID, name, surname, salary);
    }

    /**
     * Custom constructor.
     *
     * @param ID      id.
     * @param name    name.
     * @param surname surname.
     * @param salary  salary.
     * @param bonus   bonus.
     */
    public Manager(int ID, String name,
                   String surname, double salary,
                   double bonus)
            throws IncorrectSalaryException, FieldLengthLimitException {
        super(ID, name, surname, salary);
        setBonus(bonus);
    }

    /**
     * Custom constructor
     *
     * @param ID      id.
     * @param name    name.
     * @param surname surname.
     * @param salary  salary.
     * @param manager manager.
     */
    public Manager(int ID, String name,
                   String surname, double salary,
                   Manager manager)
            throws IncorrectSalaryException, FieldLengthLimitException {
        super(ID, name, surname, salary, manager);
    }

    /**
     * Custom constructor.
     *
     * @param ID      id.
     * @param name    name.
     * @param surname surname.
     * @param salary  salary.
     * @param manager manager.
     * @param bonus   bonus.
     */
    public Manager(int ID, String name,
                   String surname, double salary,
                   Manager manager, double bonus)
            throws IncorrectSalaryException, FieldLengthLimitException {
        super(ID, name, surname, salary, manager);
        setBonus(bonus);
    }

    /**
     * Method for getting bonus.
     *
     * @return bonus of the manager.
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * Method for setting bonus.
     *
     * @param bonus bonus.
     */
    public final void setBonus(double bonus) throws IncorrectSalaryException {
        if (bonus < 0) {
            throw new IncorrectSalaryException("bonus < 0");
        } else {
            this.bonus = bonus;
        }
    }

    /**
     * Override of the getSalary method.
     *
     * @return salary of the manager.
     */
    @Override
    public double getSalary() {
        return super.getSalary() + getBonus();
    }

    /**
     * Overriding of the toString().
     *
     * @return string value of the manager.
     */
    @Override
    public String toString() {
        return "Manager ID: " + getID() + "\n" +
                "Name: " + getName() + "\n" +
                "Surname: " + getSurname() + "\n" +
                "Salary: " + getSalary() + "\n" +
                "Bonus: " + getBonus() + "\n" +
                "Manager: " + getManagerName() + "\n";
    }
}
