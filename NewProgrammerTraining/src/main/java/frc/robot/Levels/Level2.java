// Level2.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * LEVEL 2: UNDERSTANDING DATA TYPES
 *
 * This level teaches you about Java's basic data types, which are the
 * fundamental building blocks of programming.
 *
 * You will learn how to:
 *   - Declare variables for the four most common data types.
 *   - Assign values to those variables.
 *   - Display all four types on Shuffleboard.
 *
 * DATA TYPES ARE THE "NOUNS" OF PROGRAMMING.
 * They represent all the information your robot will ever use, from sensor
 * readings to motor speeds to game objectives.
 *
 * How to Complete This Level:
 *   1. Go to the run() method below. You will see several "// TODO" comments. (look how VScode makes it blue)
 *   2. Follow the instructions to declare and assign a value to each variable.
 *   3. Uncomment the four 'levelTab.add(...)' lines to display your variables.
 *   4. Uncomment the final line: 'completed = true;'
 *   5. Build and Deploy/Simulate your code, just like in Level 1.
 *   6. On Shuffleboard Level Select, select the "Level 2" tab.
 *   7. In the FRC Driver Station, click "Enable Robot".
 *   8. Check the "Level 2" tab. If you see all four of your values displayed
 *      correctly, the Status will change to "PASSED" → YOU WIN!
 *
 * Important Notes:
 *   - String: Used for text, must be in "double quotes".
 *   - int: Used for whole numbers (integers).
 *   - double: Used for numbers with decimals.
 *   - boolean: Can only be 'true' or 'false'.
 *   - The 'levelTab.add()' command is smart and handles all these types automatically.
 *
 * Success Condition: All four variables are declared and their values appear
 *                    correctly on the "Level 2" tab.
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
        
        // TODO 1: Create a String variable to hold a message.
        // A String is used for any text data.
        // Example: String teamName = "Titan Robotics";
        
        
        // TODO 2: Create an int variable to hold a whole number.
        // An int is used for numbers without decimal points, like a team number.
        // Example: int teamNumber = 8334;
        
        
        // TODO 3: Create a double variable to hold a decimal number.
        // A double is used for precise measurements, like from a sensor.
        // Example: double sensorValue = 3.14159;
        
        
        // TODO 4: Create a boolean variable to hold a true/false state.
        // A boolean is like a light switch: it can only be on (true) or off (false).
        // Example: boolean robotReady = true;
        
        
        // TODO 5: UNCOMMENT the four lines below to display your variables.
        // Notice that we use the same 'levelTab.add()' command for every type.
        //levelTab.add("Team Name", teamName);
        //levelTab.add("Team Number", teamNumber);
        //levelTab.add("Sensor Reading", sensorValue);
        //levelTab.add("Robot Ready", robotReady);
        
        // Uncomment this line when you've completed the tasks
        // completed = true;
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
  public Level2(ShuffleboardTab tab) {
    super(tab); // This line passes the tab to the parent class.
    reset();    // This calls our reset() method to set the initial UI.
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
    // This returns 'true' once you uncomment 'completed = true;' in the run() method.
    return completed;
}
}