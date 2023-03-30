package adris.altoclef.chains;

import adris.altoclef.AltoClef;
import adris.altoclef.tasksystem.Task;
import adris.altoclef.tasksystem.TaskChain;
import adris.altoclef.tasksystem.TaskRunner;

/**
 * May need to extend Single Task Chain
 */
public class UniversalUnstickChain extends TaskChain {


    public UniversalUnstickChain(TaskRunner runner) {
        super(runner);
    }

    @Override
    protected void onStop(AltoClef mod) {

    }

    @Override
    public void onInterrupt(AltoClef mod, TaskChain other) {

    }

    @Override
    protected void onTick(AltoClef mod) {
        /*
        UNSTICK STRATEGIES

        different situations call for different ways to unstick.

        Let `SA` be a situation we are stuck in and let `SSA` be a strategy that can unstick
        us from `SA`.

        IF player is in SA
            implementStrategy(SSA)
         */

        //TODO this may not be the place for this.
    }

    @Override
    public float getPriority(AltoClef mod) {
        return 0;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

}

