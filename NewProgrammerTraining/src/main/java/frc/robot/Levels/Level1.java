// Level1.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * =================================================================================================
 * LEVEL 1: YOUR FIRST PROGRAM - GETTING CODE ONTO THE ROBOT
 * =================================================================================================
 *
 * Welcome to FRC programming! This first level will teach you the most important skill:
 * the basic workflow for writing and running robot code.
 *
 * This cycle is what you will do every time you program the robot:
 *   1. Write Code (like you're doing now)
 *   2. Build Code (check for errors)
 *   3. Deploy Code (send it to a real or simulated robot)
 *   4. Test & Verify (check that it works as expected)
 *
 * ---
 *
 * WHAT YOU WILL LEARN IN THIS LEVEL:
 *  - How to "Build" your code to check for typos and other basic errors.
 *  - How to run your code on a "simulated" robot on your computer.
 *  - How to use the dashboard (Elastic) to see data from your robot code.
 *
 * ---
 *
 * YOUR GOAL:
 *  - Make the message "Hello, FRC!" appear on the dashboard.
 *
 * =================================================================================================
 *
 * BEFORE YOU START - CHECK YOUR SETUP:
 * You will need these three programs running on your computer.
 *
 *  1. WPILib VS Code: This is where you are reading and writing code.
 *     (You can tell it's the right version if you see a red and gray </> icon in the top-right corner).
 *
 *  2. FRC Driver Station: This is the program you use to control the robot.
 *     (It looks like a control panel with lots of buttons and indicators).
 *
*  3. Elastic: This is your robot's "dashboard." It's a separate app where you can see data,
 *     like sensor readings or messages you send from the code.
 *
 * =================================================================================================
 *
 * STEP-BY-STEP INSTRUCTIONS TO COMPLETE THE LEVEL:
 *
 * === PART 1: GET THE SIMULATOR RUNNING ===
 *
 *   1. Open the FRC Driver Station software. If a pop-up asks about usage reporting, you can choose either option.
 *   2. Open the Elastic dashboard software.
 *
 *   3. In VS Code (this window), press `Ctrl+Shift+P` to open the command palette.
 *        ➤ A search bar will appear at the top of the screen.
 *        ➤ Type `WPILib: Build Robot Code` and press Enter.
 *        ➤ Wait for the "BUILD SUCCESSFUL" message in the terminal at the bottom. This means your code has no errors!
 *
 *   4. Now, press `Ctrl+Shift+P` again.
 *        ➤ This time, type `WPILib: Simulate Robot Code` and press Enter.
 *        ➤ A small pop-up will appear. Check the box for "Use real DriverStation" and click OK.
 *        ➤ Wait for the terminal to show that the code is running in the simulator.
 *
 * === PART 2: CONNECT THE DASHBOARD AND ENABLE THE ROBOT ===
 *
 *   5. Go to the Elastic window.
 *        ➤ In the top-left, click the "+ Add Widget" button to open the menu.
 *        ➤ Find the "SmartDashboard" section and expand it.
 *        ➤ Drag these three widgets onto your dashboard screen:
 *             - "Level Select"
 *             - "Current level"
 *             - "Reset Level"
 
 *        ➤ In the "Level Select" widget you just added, you should see "Level 1 Deploy."
 *
 *   6. Go to the FRC Driver Station window.
 *        ➤ Find the big "Enable" button. Click it to turn the (simulated) robot on.
 *        ➤ It's a good habit to shout "ENABLING!" so people around you know the robot is live.
 *
 * === PART 3: CHECK YOUR WORK AND COMPLETE THE LEVEL ===
 *
 *   7. Go back to Elastic one last time.
 *        ➤ Open the "+ Add Widget" menu again.
 *        ➤ A new widget called "Level 1" should now be in the "SmartDashboard" list. Drag it onto your screen.
 *
 *   8. Look at the "Level 1" widget you just added.
 *        ➤ Find the "Greeting" field.
 *        ➤ If it says "Hello, FRC!" and the "level status" widget says "PASSED" ... YOU DID IT!
 *
 * ---
 *
 * Important Note: Do not edit the Robot.java file. That file is the engine that runs these levels.
 * Your work for this level is only to run the code as-is.
 *
 * =================================================================================================
 */
public class Level1 extends LevelBase {
    /** 
     * A boolean "flag" to track if the level's goal has been met.
     * It starts as 'false' and we'll set it to 'true' in the run() method.
     */
    private boolean completed = false;

    // ===============================================================
    // ===============================================================
    //
    //          ===>  WRITE YOUR CODE IN THE run() METHOD  <===
    //
    // ===============================================================
    // ===============================================================
    
    public void run() {
        // This line prints a message to the VS Code terminal. It's a good way
        // to confirm that your code is actually running.
        System.out.println("Level 1: Code deployed successfully!");

        /*
         * This next line is the most important one!
         * It sends a piece of data from the robot code to the Elastic dashboard.
         *
         *   SmartDashboard.putString(KEY, VALUE);
         *
         *   - The KEY is the name of the data, like a label. Here, we're calling it "Level 1/Greeting".
         *   - The VALUE is the actual information you want to send. Here, it's the text "Hello, FRC!".
         *
         * You can try changing the text inside the quotes to see it update on the dashboard!
         */
        SmartDashboard.putString(levelName + "/Greeting", "Hello, FRC!");

        // This tells the level framework that we have successfully run our code.
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


    public Level1(String name) {
        super(name); // Assumes LevelBase constructor is updated to take a String
        this.levelName = name;
        
        // Initialize the "Greeting" value on the dashboard under our level's name
        reset();
    }

    @Override
    public Mode getMode() { return Mode.ONCE; }

    @Override
    public void reset() {
        completed = false;
    }

    @Override
    public boolean checkSuccess() {
        return completed;
    }
}