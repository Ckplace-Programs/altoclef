package adris.altoclef.tasks;

import adris.altoclef.tasksystem.Task;

import java.util.Optional;

public abstract class UnstickStrategy {
    //TODO Define a strategy class which manages a sequence of tasks to complete.
    Task[] escapeSequence;
    boolean escapeParam;
    /*
        Idea is to have the escape sequence be just a list of tasks in order. Escape will do
         those tasks without relativity to each other
     */
    public UnstickStrategy(Task[] escapeSequence, boolean escapeParameter) {
        this.escapeSequence = escapeSequence;
        this.escapeParam = escapeParameter;
    }
    public UnstickStrategy(Task[] escapeSequence) {
        this.escapeSequence = escapeSequence;
        this.escapeParam = false;
    }

    /**
     * determiens if we should use the default escape sequence
     * @return true if you use the default sequence
     */

    public abstract Task userDefinedEscape();

    public Task escape(){
        if(escapeParam){
            return defaultEscapeSequence();
        }else{
            return userDefinedEscape();
        }
    }

    private Task defaultEscapeSequence() {
        //execute first task of escape sequence
        int taskIndex=0;
        while(escapeSequence[taskIndex]==null){
            if(taskIndex > escapeSequence.length)
                return null;
            else
                taskIndex++;
        }
        return escapeSequence[taskIndex];
        /* TODO This will never work consistenly. we need to write this in a way that will
            actually iterate through the tasks as they complete. Unstick chain should help
            with this.
         */
    }
}
