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
    private String selectedLevelName = "Level 1"; 
    private boolean hasRunOnce = false;
    private SendableChooser<String> levelChooser = new SendableChooser<>();

    @Override public void robotInit() {
      
        // Setup level chooser dropdown
        levelChooser.setDefaultOption("Level 1: Deploy", "Level 1");
        levelChooser.addOption("Level 2: Data Types",    "Level 2");
        levelChooser.addOption("Level 3: Inputs",        "Level 3");
        levelChooser.addOption("Level 4: Conditionals",  "Level 4");
        levelChooser.addOption("Level 5: Else-If",       "Level 5");

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
                case LOOP:
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

    private void loadLevel(String name) {
        ShuffleboardTab levelTab = Shuffleboard.getTab(name);
        Shuffleboard.selectTab(name);
        
        hasRunOnce = false;
        
        String className = name.replace(" ", "").replace(":", "");
        if (name.equals("Level 1: Deploy")) className = "Level1";
        if (name.equals("Level 2: Data Types")) className = "Level2";
        if (name.equals("Level 3: Inputs")) className = "Level3";
        if (name.equals("Level 4: Conditionals")) className = "Level4";
        if (name.equals("Level 5: Else-If")) className = "Level5";
        
        try {
            currentLevel = (LevelBase) Class.forName("frc.robot.Levels." + className)
                             .getConstructor(ShuffleboardTab.class).newInstance(levelTab);
            
            // The level's constructor will now create the widgets.
            // Then we call reset to set their initial values.
            currentLevel.reset(); 

            System.out.println(name + " loaded successfully.");
        } catch (Exception e) { 
            System.err.println("LOAD FAILED for class " + className + ": " + e); 
            e.printStackTrace();
        }
    }
}