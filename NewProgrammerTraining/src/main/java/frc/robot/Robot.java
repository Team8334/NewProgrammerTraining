// Robot.java
package frc.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Levels.*;

public class Robot extends TimedRobot {
    private LevelBase currentLevel;
    private String selectedLevelName = "Level1"; 
    private boolean hasRunOnce = false;
    private SendableChooser<String> levelChooser = new SendableChooser<>();

    @Override public void robotInit() {
      
        // Setup level chooser dropdown
        levelChooser.setDefaultOption("Level 1: Deploy", "Level1");
        levelChooser.addOption("Level 2: Data Types",    "Level2");
        levelChooser.addOption("Level 3: Inputs",        "Level3");
        levelChooser.addOption("Level 4: Conditionals",  "Level4");
        levelChooser.addOption("Level 5: Else-If",       "Level5");

        // Add more levels here as you create them

        SmartDashboard.putData("Level Select", levelChooser);
        SmartDashboard.putBoolean("ResetLevel", false);

        // Load the initial level
        loadLevel(selectedLevelName);
    }


    @Override public void teleopPeriodic() {
        // 1. Handle level selection
        String newLevelName = levelChooser.getSelected();
        if (!newLevelName.equals(selectedLevelName)) {
            loadLevel(newLevelName);
            selectedLevelName = newLevelName;
        }

        // 2. Handle reset
        if (SmartDashboard.getBoolean("ResetLevel", false)) {
            currentLevel.reset();
            hasRunOnce = false; // Reset the run flag
            SmartDashboard.putBoolean("ResetLevel", false);
        }

        // 3. Execute based on mode
        if (currentLevel != null) {
            switch (currentLevel.getMode()) {
                case ONCE:
                    if (!hasRunOnce) {
                        currentLevel.run();
                        hasRunOnce = true;
                    }
                    break;
                case PERIODIC:
                    currentLevel.run();
                    break;
                // 'WAIT' mode removed for simplicity unless needed
            }

            // 4. Check success and update a GLOBAL status indicator
            if (currentLevel.checkSuccess()) {
                SmartDashboard.putString("Level Status", "PASSED");
            } else {
                SmartDashboard.putString("Level Status", "Running...");
            }
        }
    }

    private void loadLevel(String name) { // 'name' is now the class name, e.g., "Level1"
    // Create a user-friendly tab name with a space
    String tabName = name.replaceAll("(\\d)", " $1"); // Turns "Level1" into "Level 1"
    ShuffleboardTab levelTab = Shuffleboard.getTab(tabName);
    Shuffleboard.selectTab(tabName);
    
    hasRunOnce = false;
    
    try {
        // No more if-statements needed! 'name' is the className.
        currentLevel = (LevelBase) Class.forName("frc.robot.Levels." + name)
                         .getConstructor(ShuffleboardTab.class).newInstance(levelTab);
        currentLevel.reset();
        System.out.println(tabName + " loaded successfully.");
    } catch (Exception e) { 
        System.err.println("LOAD FAILED for class " + name + ": " + e); 
        e.printStackTrace();
    }
}
}