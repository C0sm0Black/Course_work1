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

}