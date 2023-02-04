public class Main {

    private final static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Иван", "Андреевич", "Донченко", 1, 45_000);
        employees[1] = new Employee("Евгений", "Евгеньевич", "Бирюков", 1, 48_000);
        employees[2] = new Employee("Виктор", "Михайлович", "Угаров", 2, 54_000);
        employees[3] = new Employee("Галина", "Васильевна", "Логинова", 3, 63_000);
        employees[4] = new Employee("Ольга", "Викторовна", "Владимирова", 4, 38_000);
        employees[5] = new Employee("Роман", "Владиславович", "Рыбас", 5, 71_000);

        printEmployees();
        printSumSalaryEmployees();
        printMinSalaryEmployees();
        printMaxSalaryEmployees();
        printAverageSalaryEmployees();
        printFioEmployees();
        salaryIndexationEmployees(101);
        printEmployees();
        departmentMinSalaryEmployees(1);
        departmentMaxSalaryEmployees(1);
        departmentSumSalaryEmployees(1);
        departmentAverageSalaryEmployees(1);
        departmentIndexationSalaryEmployees(1, -50);
        printEmployees();
        printDepartmentEmployees(5);
        minSalaryEmployees(50000);
        maxSalaryEmployees(500000);

    }

    private static void printEmployees() {

        for (int i = 0; i < 10; i++) {

            if (employees[i] != null) {
                System.out.println(employees[i]);
            }

        }

    }

    private static void printSumSalaryEmployees() {

        double sum = 0;

        for (Employee employee : employees) {

            if (employee != null) {
                sum += employee.getSalary();
            }
        }

        System.out.println("Общая сумма зарплат равна: " + sum);

    }

    private static void printMinSalaryEmployees() {

        double min = Double.MAX_VALUE;

        for (Employee employee : employees) {

            if (employee != null && employee.getSalary() < min) {
                min = employee.getSalary();
            }

        }

        for (Employee employee : employees) {

            if (employee != null && employee.getSalary() == min) {

                System.out.println("Сотрудник с минимальной зарплатой - " + employee);
                return;

            }

        }

    }

    private static void printMaxSalaryEmployees() {

        double max = Double.MIN_VALUE;

        for (Employee employee : employees) {

            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
            }

        }

        for (Employee employee : employees) {

            if (employee != null && employee.getSalary() == max) {

                System.out.println("Сотрудник с максимальной зарплатой - " + employee);
                return;

            }

        }

    }

    private static void printAverageSalaryEmployees() {

        double sum = 0;
        int count = 0;

        for (Employee employee : employees) {

            if (employee != null) {
                sum += employee.getSalary();
                count++;
            }

        }

        System.out.println("Средняя сумма зарплат равна: " + String.format("%.2f", sum / count));

    }

    private static void printFioEmployees() {

        System.out.println("Список сотрудников по Ф.И.О: ");

        for (Employee employee : employees) {

            if (employee != null) {
                System.out.println(employee.getLastName() + " " + employee.getFirstName() + " "
                        + employee.getMiddleName());
            }

        }

    }

    private static void salaryIndexationEmployees(int percent) {

        if (percent < -100) throw new IllegalArgumentException("Индексация меньше -100% не может быть произведена");

        for (int i = 0; i < 10; i++) {

            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() * percent / 100);
            }

        }

    }

    private static void departmentMinSalaryEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        double min = Double.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < 10; i++) {

            if (employees[i] != null) {

                if (employees[i].getDepartment() == department && employees[i].getSalary() < min) {

                    min = employees[i].getSalary();
                    index = i;

                }

            }

        }

        System.out.println("В отделе номер: " + department + " сотрудник с минимальной зарплатой "
                + employees[index].getLastName() + " " + employees[index].getFirstName() +
                " " + employees[index].getMiddleName() + " " + "с зарплатой: " + employees[index].getSalary());

    }

    private static void departmentMaxSalaryEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        double max = -1;
        int index = 0;

        for (int i = 0; i < 10; i++) {

            if (employees[i] != null) {

                if (employees[i].getDepartment() == department && employees[i].getSalary() > max) {

                    max = employees[i].getSalary();
                    index = i;

                }

            }

        }

        System.out.println("В отделе номер: " + department + " сотрудник с максимальной зарплатой "
                + employees[index].getLastName() + " " + employees[index].getFirstName() +
                " " + employees[index].getMiddleName() + " " + "с зарплатой: " + employees[index].getSalary());

    }

    private static void departmentSumSalaryEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        double sum = 0;

        for (Employee employee : employees) {

            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }

        System.out.println("Общая сумма зарплат отдела номер: " + department + " равна: " + sum);

    }

    private static void departmentAverageSalaryEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        int count = 0;
        double sum = 0;

        for (Employee employee : employees) {

            if (employee != null && employee.getDepartment() == department) {

                sum += employee.getSalary();
                count++;

            }

        }

        System.out.println("Средняя сумма зарплат отдела номер: " + department + " равна: "
                + String.format("%.2f", sum / count));

    }

    private static void departmentIndexationSalaryEmployees(int department, int percent) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");
        if (percent < -100) throw new IllegalArgumentException("Индексация меньше -100% не может быть произведена");

        for (int i = 0; i < 10; i++) {

            if (employees[i] != null && employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() * percent / 100);
            }

        }

    }

    private static void printDepartmentEmployees(int department) {

        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");

        int count = 0;

        System.out.println("Сотруднки отдела номер: " + department);

        for (int i = 0; i < 10; i++) {

            if (employees[i] != null && employees[i].getDepartment() == department) {

                System.out.println("Ф.И.О: " + employees[i].getLastName() + " " + employees[i].getFirstName() + " "
                        + employees[i].getMiddleName() + ", ID: " + employees[i].getId() +
                        ", зарплата: " + employees[i].getSalary());
                count++;

            }

        }

        if (count == 0) {
            System.out.println("Сотрудники в отделе отсуствуют");
        }

    }

    private static void minSalaryEmployees(int salary) {

        if (salary < 0) throw new IllegalArgumentException("Значение зарплаты должна быть не меньше нуля!");

        int count = 0;

        System.out.println("Сотрудники с зарплатой меньше " + salary + ":");

        for (Employee employee : employees) {

            if (employee != null && employee.getSalary() < salary) {

                System.out.println("ID: " + employee.getId() + ", Ф.И.О: " + employee.getLastName() +
                        " " + employee.getFirstName() + " " + employee.getMiddleName() + ", зарплата: " + employee.getSalary());
                count++;

            }

        }

        if (count == 0) {
            System.out.println("Такие сотрудники отсуствуют");
        }

    }

    private static void maxSalaryEmployees(int salary) {

        if (salary < 0) throw new IllegalArgumentException("Значение зарплаты должна быть не меньше нуля!");

        int count = 0;

        System.out.println("Сотрудники с зарплатой больше либо равной " + salary + ":");

        for (Employee employee : employees) {

            if (employee != null && employee.getSalary() >= salary) {

                System.out.println("ID: " + employee.getId() + ", Ф.И.О: " + employee.getLastName() +
                        " " + employee.getFirstName() + " " + employee.getMiddleName() + ", зарплата: " + employee.getSalary());
                count++;

            }

        }

        if (count == 0) {
            System.out.println("Такие сотрудники отсуствуют");
        }

    }

}

