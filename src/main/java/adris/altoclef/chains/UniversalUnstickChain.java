package adris.altoclef.chains;

import adris.altoclef.AltoClef;
import adris.altoclef.tasks.UnstickStrategy;
import adris.altoclef.tasksystem.IUnstickable;
import adris.altoclef.tasksystem.Task;
import adris.altoclef.tasksystem.TaskChain;
import adris.altoclef.tasksystem.TaskRunner;

import java.util.Optional;

/**
 * May need to extend Single Task Chain
 */
public class UniversalUnstickChain extends SingleTaskChain {


    private boolean _stuck = false;
    private UnstickStrategy _unstickStrats;

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
        if(_stuck){
            runUnstickManuvers(mod,_unstickStrats);
        }
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
        Optional<IUnstickable> _curTask = Optional.ofNullable(getStickyClass(mod));
        if(_stuck){
            return Float.POSITIVE_INFINITY;
        }
        if(_curTask.isPresent()){
            IUnstickable running = _curTask.get();
            _unstickStrats = running.getUnstickStrategy();
            if(running.getStickyTimer().elapsed()) {
                _stuck = true;
                return Float.POSITIVE_INFINITY;
            }
        }else{
            return Float.NEGATIVE_INFINITY;
        }
        return Float.NEGATIVE_INFINITY;
    }

    private IUnstickable getStickyClass(AltoClef mod) {
        return (mod.getUserTaskChain().getCurrentTask() instanceof IUnstickable) ?
                (IUnstickable) mod.getUserTaskChain().getCurrentTask() : null;
    }

    public void runUnstickManuvers(AltoClef mod, UnstickStrategy unstick){
       // mod.getTaskRunner().enable();
        if(unstick.escape()==null){
            _stuck = false;
        //mod.getTaskRunner().disable();
        }else {
            setTask(unstick.escape()); //TODO should get stuck in a loop here. That's ok for now
        }
    }
    @Override
    public boolean isActive() {
        //we always want to determine if we are stuck
        return true;
    }

    @Override
    protected void onTaskFinish(AltoClef mod) {

    }

    @Override
    public String getName() {
        return "UnstuckUniversal";
    }

}

