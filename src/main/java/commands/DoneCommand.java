package commands;

import storage.Storage;
import tasks.TaskList;
import ui.Ui;

public class DoneCommand extends Command {

    private int taskIndex;

    public DoneCommand(int taskIndex) {
        super();
        this.taskIndex = taskIndex;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.markAsDone(taskIndex);
        storage.uploadTasksToFile(taskList.getTasks());
        return ui.doneMessage(taskList.getTasks().get(taskIndex));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
