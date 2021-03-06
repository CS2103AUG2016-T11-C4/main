package seedu.address.logic.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.task.FloatingTask;
import seedu.address.model.task.FloatingTaskBuilder;
import seedu.address.model.task.TypicalFloatingTasks;

public class MarkFloatingTaskUnfinishedCommandTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private final TypicalFloatingTasks tft = new TypicalFloatingTasks();
    private final Model model = new ModelManager();

    @Test
    public void execute_withValidTargetIndex_marksUnfinished() throws Exception {
        final FloatingTask readABook = new FloatingTaskBuilder(tft.readABook)
                                            .setFinished(true).build();
        final FloatingTask eatAnApple = new FloatingTaskBuilder(tft.eatAnApple)
                                            .setFinished(true).build();
        assertEquals(1, model.addFloatingTask(readABook));
        assertEquals(2, model.addFloatingTask(eatAnApple));
        final CommandResult result = new MarkFloatingTaskUnfinishedCommand(1).execute(model);
        assertEquals("Floating task f1 unfinished.", result.feedbackToUser);
        assertEquals(tft.readABook, model.getFloatingTask(1));
        assertEquals(eatAnApple, model.getFloatingTask(2));
    }

    @Test
    public void execute_invalidTargetIndex_throwsCommandException() throws Exception {
        thrown.expect(CommandException.class);
        thrown.expectMessage("index does not exist");
        new MarkFloatingTaskUnfinishedCommand(1).execute(model);
    }

    @Test
    public void execute_nullModel_throwsAssertionError() throws Exception {
        thrown.expect(AssertionError.class);
        new MarkFloatingTaskUnfinishedCommand(1).execute(null);
    }

}
