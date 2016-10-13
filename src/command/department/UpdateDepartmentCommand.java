package command.department;

import controller.DepartmentController;
import domain.Department;
import exception.DepartmentException;

/**
 * Created by marius on 10/13/16.
 */
public class UpdateDepartmentCommand extends AbstractDepartmentCommand {
    /**
     * @param key                  The key which identifies the command
     * @param text                 Short description for the command
     * @param departmentController The controller which handles departments
     */
    public UpdateDepartmentCommand(String key, String text, DepartmentController departmentController) {
        super(key, text, departmentController);
    }

    /**
     * Executes the current command
     */
    @Override
    public void execute() {
        Integer id;
        String name;
        Integer numberOfSeats;

        this.out.print("Enter the id of the department you with to modify: ");
        id = this.scanner.nextInt();
        this.scanner.nextLine();
        this.out.print("Enter the new phone of the department or leave id blank to not change it: ");
        name = this.scanner.nextLine();
        this.out.print("Enter the number of seats of the department or leave id blank to not change it: ");
        numberOfSeats = this.scanner.nextInt();

        try {
            Department department = this.departmentController.update(id, name, numberOfSeats);
            this.out.println("Updated " + department);
        } catch (DepartmentException ex) {
            this.out.println(ex.getMessage());
        }
    }
}