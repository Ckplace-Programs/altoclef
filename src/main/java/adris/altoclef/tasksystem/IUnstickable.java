package adris.altoclef.tasksystem;


import adris.altoclef.tasks.UnstickStrategy;

/**
 * This interface is designed to inform the Universal Unstick chain that the current running task
 * is albe to be unstuck. If a task does not implement this interface, Universal Unstick will
 * not unstick it if it gets stuck.
 */
public interface IUnstickable {
    /*
    TODO: Make every class which implements this require a timer that defines how long before
          that task requires unstick assistance.
     */
    public UnstickStrategy getUnstickStrategy();

}
