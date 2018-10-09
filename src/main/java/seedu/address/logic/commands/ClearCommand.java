package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.CommandHistory;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.budget.Budget;
import seedu.address.model.exceptions.NoUserSelectedException;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String COMMAND_ALIAS = "c";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";


    @Override
    public CommandResult execute(Model model, CommandHistory history) throws NoUserSelectedException {
        requireNonNull(model);
        AddressBook newAddressBook = new AddressBook(model.getAddressBook().getUsername());
        Budget clearedSpendingBudget = model.getMaximumBudget();
        model.resetData(newAddressBook);
        clearedSpendingBudget.clearSpending();
        model.modifyMaximumBudget(clearedSpendingBudget);
        model.commitAddressBook();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
