package seedu.address.logic.commands;

import seedu.address.model.Model;

public class ShowAllDeadlineCommand implements Command {

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": List all deadline task on the user interface.\n"
            + "Example: " + COMMAND_WORD + " d"; // TODO replace " d" after IndexPrefix.java added

    public static final String MESSAGE_EDIT_TASK_SUCCESS = "All Deadlines have been listed.";

    @Override
    public CommandResult execute(Model model) {
        // clear the filter/predicate of the filtered deadline list.
        model.setDeadlineTaskPredicate(null);
        return new CommandResult(MESSAGE_EDIT_TASK_SUCCESS);
    }
}