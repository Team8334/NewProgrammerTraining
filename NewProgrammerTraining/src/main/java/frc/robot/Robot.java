// Robot.java
package frc.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Levels.*;

public class Robot extends TimedRobot {
    private LevelBase currentLevel;
    private String selected = "Level1";
    private boolean hasRunOnce = false;
    private SendableChooser<String> levelChooser = new SendableChooser<>();

    @Override public void robotInit() {
      
        // Setup level chooser dropdown
        levelChooser.setDefaultOption("Level 1", "Level1");
        levelChooser.addOption("Level 2", "Level2");
        levelChooser.addOption("Level 3", "Level3");
        levelChooser.addOption("Level 4", "Level4");
        levelChooser.addOption("Level 5", "Level5");
        // Add more levels here as you create them

        SmartDashboard.putData("Level Select", levelChooser);
        SmartDashboard.putBoolean("ResetLevel", false);
        loadLevel("Level1");
    }

    @Override public void teleopPeriodic() {
        // 1. Handle level selection
        String newLevel = levelChooser.getSelected();
        if (!newLevel.equals(selected)) {
            loadLevel(newLevel);
            selected = newLevel;
            hasRunOnce = false;
        }

        // 2. Handle reset
        if (SmartDashboard.getBoolean("ResetLevel", false)) {
            currentLevel.reset();
            hasRunOnce = false;
            SmartDashboard.putBoolean("ResetLevel", false);
        }

        // 3. Execute based on mode
        switch (currentLevel.getMode()) {
            case ONCE:
                if (!hasRunOnce) {
                    currentLevel.run();
                    hasRunOnce = true;
                }
                break;
            case WAIT:
                if (currentLevel.runWithReturn()) hasRunOnce = true; // Block until run() returns true
                break;
            case LOOP:
                currentLevel.run();
                break;
        }

        // 4. Check success
        if (currentLevel.checkSuccess()) {
            SmartDashboard.putString("Status", "PASSED");
            SmartDashboard.putBoolean("LevelPassed", true);
        } else {
            SmartDashboard.putString("Status", "Running...");
            SmartDashboard.putBoolean("LevelPassed", false);
        }
    }

    private void loadLevel(String name) {
        try {
            currentLevel = (LevelBase) Class.forName("frc.robot.Levels." + name)
                             .getConstructor().newInstance();
            currentLevel.reset();
        } catch (Exception e) { System.err.println("LOAD FAILED: " + e); }
    }
}