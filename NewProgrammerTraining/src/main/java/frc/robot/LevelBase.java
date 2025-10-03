// LevelBase.java
package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

/**
 * The base for all educational levels.
 * This class provides the structure that the main Robot.java class uses
 * to run, reset, and check each level for success.
 *
 * FRAMEWORK CODE: DO NOT EDIT.
 */
public abstract class LevelBase {
      /**
     * Defines how the run() method should be called.
     * ONCE: run() is called only one time when the level loads.
     * LOOP: run() is called every 20ms in a loop.
     */
    public enum Mode { 
        LOOP,  // run() is called every 20ms
        ONCE;  // run() is called one time after level load or reset
    }

    /**
     * The Shuffleboard tab dedicated to this level.
     * All UI components should be added to this tab to keep the dashboard clean.
     */
    protected ShuffleboardTab levelTab;

    /**
     * This is the main logic for the level.
     * Students will write their code inside this method in each Level file.
     */
    public abstract void run();

    /**
     * Specifies whether the run() method should be called once or continuously.
     */
    public abstract Mode getMode();

    /**
     * Resets the level's state. Called when the "ResetLevel" button is pressed
     * or when a new level is loaded.
     */
    public abstract void reset();

    /**
     * Checks if the student has successfully completed the level's objectives.
     * @return true if the level is passed, false otherwise.
     */
    public abstract boolean checkSuccess();

    /**
     * Default constructor for compatibility.
     */
    public LevelBase() {}

    /**
     * Constructor used by the framework to provide a dedicated Shuffleboard tab.
     * @param tab The Shuffleboard tab for this level's UI.
     */
    public LevelBase(ShuffleboardTab tab) {
        this.levelTab = tab;
    }

    // This method was in the original Robot.java but is not used in the refactor.
    // It can be removed or kept for future use if needed.
    public boolean runWithReturn() {
        return true;
    }
}