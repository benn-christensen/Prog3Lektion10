package examples.template;

import examples.template.payments.Employee;
import examples.template.payments.PublicEmployee;
import examples.template.payments.WoltEmployee;

import java.util.List;

public class Main {
    static void main() {
       List<Employee> employees = List.of(new PublicEmployee(60_000), new PublicEmployee(120_000), new WoltEmployee(40_000));

       employees
               .stream()
               .map(em -> em.calculateNetSalary())
               .forEach(IO::println);

    }
}
