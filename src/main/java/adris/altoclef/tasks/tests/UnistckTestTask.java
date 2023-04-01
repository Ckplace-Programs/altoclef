package adris.altoclef.tasks.tests;

import adris.altoclef.AltoClef;
import adris.altoclef.TaskCatalogue;
import adris.altoclef.tasks.UnstickStrategy;
import adris.altoclef.tasks.movement.GetToBlockTask;
import adris.altoclef.tasks.movement.IdleTask;
import adris.altoclef.tasksystem.IUnstickable;
import adris.altoclef.tasksystem.Task;
import adris.altoclef.util.time.TimerGame;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.system.CallbackI;

public class UnistckTestTask extends Task implements IUnstickable {

    private final double stickytime = 20;
    private boolean init = false;
    private final TimerGame unstickTimer = new TimerGame(stickytime);

    @Override
    protected void onStart(AltoClef mod) {
        unstickTimer.reset();
        init = true;
    }

    @Override
    protected Task onTick(AltoClef mod) {
        return new IdleTask();
    }

    @Override
    protected void onStop(AltoClef mod, Task interruptTask) {
    }

    @Override
    protected boolean isEqual(Task other) {
        return other instanceof UnistckTestTask;
    }

    @Override
    public boolean isFinished(AltoClef mod) {
        return false;
    }

    @Override
    protected String toDebugString() {
        return "this is a test of being stuck " + unstickTimer.getDuration();
    }

    // This task can get stuck. The below methods determine if this task is stuck.

    @Override
    public UnstickStrategy getUnstickStrategy() {
        class getToZeroZero extends UnstickStrategy{
            public getToZeroZero(){
                super(new Task[]{new GetToBlockTask(new BlockPos(0,0,0))});
            }
            @Override
            public Task userDefinedEscape() {
                return null;
            }
        }
        return new getToZeroZero();
    }

    @Override
    public TimerGame getStickyTimer() {
        return unstickTimer;
    }

    @Override
    public boolean initialized() {
        return init;
    }

    public void resetStickyTier(){
        unstickTimer.reset();
    }
}
