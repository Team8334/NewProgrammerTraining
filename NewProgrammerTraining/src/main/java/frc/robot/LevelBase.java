// LevelBase.java
package frc.robot;

// This abstract class defines the contract for all training levels.
public abstract class LevelBase {
    // Defines how the level's run() method should be called by Robot.java
    public enum Mode { 
        LOOP,  // run() is called every 20ms
        ONCE,  // run() is called one time after level load or reset
        WAIT   // run() is called repeatedly until it returns true
    }

    // Each level MUST specify its execution mode
    public abstract Mode getMode();

    // The main logic for the level. 
    // For WAIT mode, this should return true when the condition is met.
    // For LOOP/ONCE mode, the return value is ignored.
    public void run() {}

    // Optional: A version of run() that returns a boolean for the WAIT mode.
    // This is a bit of a workaround for Java's method signatures. The Robot.java
    // code is smart enough to call the right one.
    public boolean runWithReturn() { run(); return false; }

    // Optional: Called when the level is first loaded or when "ResetLevel" is pressed.
    public void reset() {}

    // Optional: A test to see if the trainee has completed the level's objective.
    // Returns true if the level's success condition is met.
    public boolean checkSuccess() { return false; }
}