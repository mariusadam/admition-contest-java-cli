package menu.command.department;

import controller.DepartmentController;
import domain.Department;
import exception.DuplicateEntryException;
import exception.InvalidObjectException;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by marius on 10/13/16.
 */
public class AddDepartmentCommand extends BaseDepartmentCommand {

    /**
     * @param key                  The key which identifies the menu.command
     * @param text                 Short description for the menu.command
     * @param departmentController The controller which handles departments
     */
    public AddDepartmentCommand(String key, String text, DepartmentController departmentController) {
        super(key, text, departmentController);
    }

    /**
     * Executes the current menu.command
     * @param scanner
     * @param out
     */
    @Override
    public void execute(Scanner scanner, PrintStream out) {
        String name;
        Integer numberOfSeats;

        out.print("Enter the nae of the department: ");
        name = scanner.nextLine();
        out.print("Enter the number of seats of the department: ");
        numberOfSeats = scanner.nextInt();
        scanner.nextLine();

        try {
            Department department = this.departmentController.create(name, numberOfSeats);
            out.println("Updated " + department);
        } catch (InvalidObjectException | DuplicateEntryException e) {
            out.println(e.getMessage());;
        }
    }
}
