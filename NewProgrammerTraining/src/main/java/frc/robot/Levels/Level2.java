// Level2.java
package frc.robot.Levels;

import frc.robot.LevelBase;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * =================================================================================================
 * LEVEL 2: STORING INFORMATION (VARIABLES & DATA TYPES)
 * =================================================================================================
 *
 * In this level, you'll learn how to store information in your code using "variables."
 *
 * Think of variables like labeled storage boxes. Each box is designed to hold a specific
 * "type" of information. You can't put liquid in a cardboard box, and in programming, you
 * can't put text into a number variable. Choosing the right "data type" is essential.
 *
 * ---
 *
 * WHAT YOU WILL LEARN IN THIS LEVEL:
 *  - What a "variable" is in programming.
 *  - How to create variables for the 4 most common data types.
 *  - How to send all four types of data to the dashboard to be displayed.
 *
 * ---
 *
 * YOUR GOAL:
 *  - Activate the pre-written code to create four different variables.
 *  - Display the value of each variable on the Elastic dashboard.
 *
 * =================================================================================================
 *
 * HOW TO COMPLETE THIS LEVEL:
 *
 * Your task is simple: "uncomment" the code that is already written for you.
 *
 * What is "Uncommenting"?
 * In Java, any line starting with `//` is a "comment." The computer completely ignores it.
 * Comments are for humans to read. The code for this level is currently commented out.
 *
 * To "uncomment" a line, just delete the `//` from the beginning. The line will
 * change color, showing that it is now "active" code that the computer will run.
 *
 * === STEP-BY-STEP INSTRUCTIONS ===
 *
 *   1. Scroll down to the `run()` method.
 *   2. You will see several lines of code starting with `//`.
 *   3. **Delete the `//`** from the beginning of the four lines that create variables (`String`, `int`, `double`, `boolean`).
 *   4. **Delete the `//`** from the beginning of the four lines that start with `SmartDashboard...`
 *   5. **Delete the `//`** from the final line: `completed = true;`
 *
 *   6. Build and Simulate your code (just like in Level 1).
 *        ➤ `Ctrl+Shift+P` → "WPILib: Build Robot Code"
 *        ➤ `Ctrl+Shift+P` → "WPILib: Simulate Robot Code"
 *
 *   7. In Elastic, use the "Level Select" widget to choose "Level 2".
 *   8. In the FRC Driver Station, click "Enable".
 *   9. Go back to Elastic. You should see a new "Level 2" widget showing all four of your
 *      values. If they appear correctly, the status will change to "PASSED". YOU WIN!
 *
 * =================================================================================================
 */
public class Level2 extends LevelBase {
    private boolean completed = false;

    // ===============================================================
    // ===============================================================
    //
    //          ===>  WRITE YOUR CODE IN THE run() METHOD  <===
    //
    // ===============================================================
    // ===============================================================

    @Override
    public void run() {
        System.out.println("Level 2: Working with data types");

         //TODO 1: Create a String variable to hold a message.
        //A String holds text. Perfect for names, messages, or labels.
         //It must always be surrounded by double quotes "".
        String teamName = "Titan Robotics";
        
        // TODO 2: Create an int variable to hold a whole number.
        // An 'int' (short for integer) holds whole numbers.
        // Great for counting things, like game pieces scored or your team number.
        int teamNumber = 8334;
        
        // TODO 3: Create a double variable to hold a decimal number.
        // A 'double' holds numbers with decimals. Use this for precise measurements,
        // like distance from a sensor (e.g., 10.5 inches) or motor power (e.g., 0.75).
        double sensorValue = 3.14159;
        
        // TODO 4: Create a boolean variable to hold a true/false state.
        // A 'boolean' is the simplest type. It can only be `true` or `false`.
        // It's like a digital light switch, perfect for checking if a sensor is
        // triggered or if a task is finished.
        boolean robotReady = true;

        // TODO 5: UNCOMMENT the four lines below to display your variables on the dashboard.
         SmartDashboard.putString( levelName +"/Team Name", teamName);
        SmartDashboard.putNumber( levelName +"/Team Number", teamNumber);
         SmartDashboard.putNumber( levelName +"/Sensor Reading", sensorValue);
         SmartDashboard.putBoolean(levelName +"/Robot Ready", robotReady);

        // Finally, uncomment this line to tell the program you're done!
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

    // The constructor runs ONCE to set up the level.
    public Level2(String name) {
        this.levelName = name;
    }

    @Override
    public Mode getMode() {
        // We only need to declare our variables once.
        return Mode.ONCE;
    }

    @Override
    public void reset() {
        completed = false;
    }

    @Override
    public boolean checkSuccess() {
        // This returns 'true' once you uncomment 'completed = true;' in the run()
        // method.
        return completed;
    }
}