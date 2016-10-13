package command.department;

import command.AbstractCommand;
import controller.DepartmentController;

/**
 * Created by marius on 10/13/16.
 */
abstract public class AbstractDepartmentCommand extends AbstractCommand{
    protected DepartmentController departmentController;

    /**
     *
     * @param key                  The key which identifies the command
     * @param text                 Short description for the command
     * @param departmentController The controller which handles departments
     */
    public AbstractDepartmentCommand(String key, String text, DepartmentController departmentController) {
        super(key, text);
        this.departmentController = departmentController;
    }

    /**
     * Executes the current command
     */
    abstract public void execute();
}