// Level1.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * LEVEL 1: YOUR FIRST CODE - COMPILE & DEPLOY
 *
 * This level teaches you the core FRC programming workflow:
 *   1. Write Code → 2. Build → 3. Deploy → 4. Verify
 *
 * You will learn how to:
 *   - Use VS Code to write Java code.
 *   - Compile your code using WPILib's build system.
 *   - Deploy it to the RoboRIO or run in simulation.
 *   - View output on Shuffleboard.
 *
 * THIS IS THE FOUNDATION OF EVERYTHING YOU DO IN FRC.
 * Master this cycle, and you’re ready for anything!
 *
 * How to Complete This Level:
 *   1. Open Shuffleboard 2025 on your laptop.
 *   2. Open FRC Driver Station on your laptop and say yes to the pop up question.
 *   2. In VS Code:
 *        ➤ Press Ctrl+Shift+P → Type/Select "WPILib: Build Robot Code"
 *        ➤ Wait for "BUILD SUCCESSFUL"
 *   3. In VS Code:
 *        ➤ Press Ctrl+Shift+P → Type "WPILib: Simulate Robot Code"
 *        ➤ Click the check box for  "Use real DriverStation".
 *        ➤ Wait for "RUNNING IN SIMULATOR"
 *   4. Go back to Shuffleboard → you should see 3 tabs | SmartDashboard | LiveWindow | Level 1 |
 *        ➤ In the SmartDashboard tab you should see "/SmartDashboard/Level Select" field →  You should see "Level 1 Deploy." 
 *        ➤ In the Level 1 tab Look for the "Greeting" field →  You should see "Waiting..." 
 *        ➤ Feel free to resize the UI Boxes
 *   5. Go to FRC Driver Station → Click "Enable Robot"
 *   6. Go back to Shuffleboard → Look for the "Greeting" field.
 *        ➤ If you see "Hello, FRC!" → Status changes to "PASSED" → YOU WIN!
 *
 * Important Notes:
 *   - DO NOT edit Robot.java. It’s the engine that runs your levels.
 *   - This level uses Mode.ONCE – The code in the run() method will execute only one time right after you deploy it.
 *   - Shuffleboard methods like 'levelTab.add()' and 'widget.getEntry().setString()' send data to the dashboard.
 *   - System.out.println() prints to the console (Simulator or RioLog).
 *   - reset() clears state when "ResetLevel" is pressed.
 *
 * What You're Learning:
 *   - Compile code using WPILib's build system.
 *   - Deploy code to the RoboRIO or run in simulation.
 *   - SmartDashboard: Visualize data from robot.
 *
 * Success Condition: "Greeting" shows "Hello, FRC!" and Status says "PASSED".
 */
public class Level1 extends LevelBase {
    /** 
     * A boolean "flag" to track if the level's goal has been met.
     * It starts as 'false' and we'll set it to 'true' in the run() method.
     */
    private boolean completed = false;

    /**
     * A variable to hold our text box widget from Shuffleboard.
     * Think of this as an empty box that we will put our widget into
     * once we create it.
     */
    private SimpleWidget greetingWidget;


    // ===============================================================
    // ===============================================================
    //
    //          ===>  WRITE YOUR CODE IN THE run() METHOD  <===
    //
    // ===============================================================
    // ===============================================================
    
    public void run() {
        // Print to RoboRIO console (visible in VS Code terminal)
        System.out.println("Level 1: Code deployed successfully!");
        
        /*
         * This line updates the text of the widget we created earlier.
         * It looks complex, but it's a chain of commands. Read it left-to-right:
         *
         * 1. greetingWidget: Start with our variable that holds the widget.
         * 2. .getEntry():   From that widget, get its underlying data "entry".
         * 3. .setString():  On that entry, set its String (text) value.
         *
         * Analogy: Find our specific mailbox (greetingWidget), open the mail slot
         * (.getEntry()), and put in a new letter that says "Hello, FRC!" (.setString(...)).
         * 
         * Try changing the text "Hello, FRC!"
         */
        greetingWidget.getEntry().setString("Hello, FRC!");
        
        // Mark level as complete
        completed = true;
    }

    // ===============================================================
    // ===============================================================
    //
    //          ===>  DO NOT EDIT THE CODE BELOW THIS LINE  <===
    //          (This is the framework that makes the level work)
    //
    // ===============================================================
    // ===============================================================


    public Level1(ShuffleboardTab tab) {
        super(tab); // Pass the tab to the parent class
        
        /*
         * CREATE the widget ONCE and store it in our variable.
         * The 'levelTab.add(...)' method does two things:
         *   1. It creates a new text box on Shuffleboard.
         *   2. It returns an object representing that widget.
         * We save that object in our 'greetingWidget' variable so we can update it later.
         */
        greetingWidget = levelTab.add("Greeting", "Waiting...");
    }

    @Override
    public Mode getMode() { return Mode.ONCE; }

    @Override
    public void reset() {
        completed = false;
        // UPDATE the value of the existing widget back to "Waiting...".
        // This is safe because the widget is guaranteed to exist.
        greetingWidget.getEntry().setString("Waiting...");
    }

    @Override
    public boolean checkSuccess() {
        return completed;
    }
}