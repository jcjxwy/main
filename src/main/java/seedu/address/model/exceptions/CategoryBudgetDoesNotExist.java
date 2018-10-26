package seedu.address.model.exceptions;
//@author winsonhys

import seedu.address.model.budget.CategoryBudget;

/**
 * Exception that is thrown when trying to remove a budget that does not exist
 */
public class CategoryBudgetDoesNotExist extends Exception {
    public CategoryBudgetDoesNotExist (CategoryBudget categoryBudget) {
        super(String.format("The category %s does not have a budget yet",
            categoryBudget.getCategory()));
    }
}
