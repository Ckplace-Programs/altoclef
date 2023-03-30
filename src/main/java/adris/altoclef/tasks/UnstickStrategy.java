package adris.altoclef.tasks;

import adris.altoclef.tasksystem.Task;

import java.util.Optional;

public abstract class UnstickStrategy {
    //TODO Define a strategy class which manages a sequence of tasks to complete.
    Task[] escapeSequence;
    Optional<Boolean> escapeParam;
    /*
        Idea is to have the escape sequence be just a list of tasks in order. Escape will do
         those tasks without relativity to each other
     */
    public UnstickStrategy(Task[] escapeSequence) {
        this.escapeSequence = escapeSequence;
    }

    /**
     * determiens if we should use the default escape sequence
     * @return true if you use the default sequence
     */
    public abstract Optional<Boolean> setEscapeParameter();

    public abstract Task userDefinedEscape();

    public Task escape(){
        if(escapeParam.isEmpty()){
            return defaultEscapeSequence();
        }else{
            return userDefinedEscape();
        }
    }

    private Task defaultEscapeSequence() {
        //execute first task of escape sequence
        return escapeSequence[0];
        /* TODO This will never work consistenly. we need to write this in a way that will
            actually iterate through the tasks as they complete. Unstick chain should help
            with this.
         */
    }
}
