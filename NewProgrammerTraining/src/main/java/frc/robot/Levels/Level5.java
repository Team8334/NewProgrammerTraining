// Level5.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * LEVEL 5: MULTIPLE CONDITIONS (ELSE-IF CHAINS)
 *
 * This level teaches you how to:
 *   - Handle multiple conditions using else-if statements
 *   - Create decision trees for complex robot behaviors
 *   - Work with discrete states (common in FRC subsystems)
 *
 * ELSE-IF CHAINS ARE ESSENTIAL FOR ROBOT STATE MACHINES!
 * Real robots have arms, elevators, and shooters with multiple positions.
 *
 * How to Complete This Level:
 *   1. You're programming an arm position controller
 *   2. The arm has 4 positions based on angle:
 *      - STOWED: angle < 10 degrees (safe travel position)
 *      - LOW: angle >= 10 and < 45 degrees (ground pickup)
 *      - MID: angle >= 45 and < 80 degrees (mid scoring)
 *      - HIGH: angle >= 80 degrees (high scoring)
 *   3. Complete the TODO sections below
 *   4. Build and run your code
 *   5. The system will automatically test your code with different angles
 *   6. Watch the "Test Progress" on Shuffleboard
 *   7. When all tests pass, you win!
 *
 * Important Notes:
 *   - else-if allows you to check multiple conditions in order
 *   - Only ONE block executes (the first true condition)
 *   - Order matters! Check most specific conditions first
 *   - This level automatically runs 9 different test cases
 *   - Structure:
 *       if (condition1) {
 *           // executes if condition1 is true
 *       } else if (condition2) {
 *           // executes if condition1 is false AND condition2 is true
 *       } else if (condition3) {
 *           // executes if condition1 and condition2 are false AND condition3 is true
 *       } else {
 *           // executes if all conditions are false
 *       }
 *
 * What You're Learning:
 *   - else-if chains for multiple conditions
 *   - Decision trees
 *   - Robot state management
 *   - Automated testing (very important in real FRC!)
 *
 * Success Condition: Pass all 9 automated test cases
 */
public class Level5 extends LevelBase {
    private boolean initialized = false;
    
    // Test case data
    private static class TestCase {
        double angle;
        String expectedPosition;
        boolean expectedSafeToDrive;
        String description;
        
        TestCase(double angle, String pos, boolean safe, String desc) {
            this.angle = angle;
            this.expectedPosition = pos;
            this.expectedSafeToDrive = safe;
            this.description = desc;
        }
    }
    
    private final TestCase[] testCases = {
        new TestCase(0, "STOWED", true, "Zero degrees"),
        new TestCase(5, "STOWED", true, "Mid-stowed range"),
        new TestCase(9.9, "STOWED", true, "Upper boundary of stowed"),
        new TestCase(10, "LOW", false, "Lower boundary of low"),
        new TestCase(30, "LOW", false, "Mid-low range"),
        new TestCase(44.9, "LOW", false, "Upper boundary of low"),
        new TestCase(45, "MID", false, "Lower boundary of mid"),
        new TestCase(65, "MID", false, "Mid-mid range"),
        new TestCase(80, "HIGH", false, "Lower boundary of high"),
        new TestCase(100, "HIGH", false, "High range"),
    };
    
    private int currentTest = 0;
    private int testsPassed = 0;
    private int testsFailed = 0;
    private boolean testingComplete = false;
    
    @Override
    public void run() {
        // Initialize default values if first run
        if (!initialized) {
            SmartDashboard.putNumber("Arm Angle", 0.0);
            SmartDashboard.putString("Arm Position", "UNKNOWN");
            SmartDashboard.putBoolean("Safe to Drive", false);
            SmartDashboard.putString("Position Info", "");
            SmartDashboard.putString("Test Progress", "0/10 tests");
            SmartDashboard.putString("Test Status", "Waiting...");
            initialized = true;
        }
        
        // TODO: Read the arm angle from Shuffleboard
        // double armAngle = SmartDashboard.getNumber("Arm Angle", 0.0);
        
        
        // TODO: Determine arm position using else-if chain
        // Remember the positions:
        //   STOWED: < 10 degrees
        //   LOW: >= 10 and < 45 degrees  
        //   MID: >= 45 and < 80 degrees
        //   HIGH: >= 80 degrees
        
        // if (armAngle < 10) {
        //     SmartDashboard.putString("Arm Position", "STOWED");
        //     SmartDashboard.putBoolean("Safe to Drive", true);
        //     SmartDashboard.putString("Position Info", "Safe travel position");
        // } else if (armAngle >= 10 && armAngle < 45) {
        //     SmartDashboard.putString("Arm Position", "LOW");
        //     SmartDashboard.putBoolean("Safe to Drive", false);
        //     SmartDashboard.putString("Position Info", "Ground pickup position");
        // } else if (armAngle >= 45 && armAngle < 80) {
        //     SmartDashboard.putString("Arm Position", "MID");
        //     SmartDashboard.putBoolean("Safe to Drive", false);
        //     SmartDashboard.putString("Position Info", "Mid-level scoring");
        // } else {
        //     SmartDashboard.putString("Arm Position", "HIGH");
        //     SmartDashboard.putBoolean("Safe to Drive", false);
        //     SmartDashboard.putString("Position Info", "High-level scoring");
        // }
        
        
        // TODO: Display the current angle for debugging
        // SmartDashboard.putNumber("Current Angle", armAngle);
        
        
        // Display test progress
        SmartDashboard.putString("Test Progress", 
            testsPassed + "/" + testCases.length + " passed, " + 
            testsFailed + " failed");
    }
    
    @Override
    public Mode getMode() { 
        return Mode.LOOP; 
    }
    
    @Override
    public void reset() {
        initialized = false;
        currentTest = 0;
        testsPassed = 0;
        testsFailed = 0;
        testingComplete = false;
        
        SmartDashboard.putNumber("Arm Angle", 0.0);
        SmartDashboard.putString("Arm Position", "UNKNOWN");
        SmartDashboard.putBoolean("Safe to Drive", false);
        SmartDashboard.putString("Position Info", "");
        SmartDashboard.putNumber("Current Angle", 0.0);
        SmartDashboard.putString("Test Progress", "0/" + testCases.length + " tests");
        SmartDashboard.putString("Test Status", "Reset - Ready to test");
        SmartDashboard.putString("Last Test", "");
    }
    
    @Override
    public boolean checkSuccess() {
        // If testing is already complete, return the result
        if (testingComplete) {
            return testsPassed == testCases.length && testsFailed == 0;
        }
        
        // Run through all test cases
        testsPassed = 0;
        testsFailed = 0;
        
        System.out.println("\n=== Starting Level 5 Automated Tests ===");
        
        for (int i = 0; i < testCases.length; i++) {
            TestCase test = testCases[i];
            
            // Set the test angle
            SmartDashboard.putNumber("Arm Angle", test.angle);
            
            // Give the student's code a moment to process (simulate one loop cycle)
            try {
                Thread.sleep(50); // 50ms delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // Read the results
            String actualPosition = SmartDashboard.getString("Arm Position", "UNKNOWN");
            boolean actualSafeToDrive = SmartDashboard.getBoolean("Safe to Drive", false);
            
            // Check if correct
            boolean positionCorrect = actualPosition.equals(test.expectedPosition);
            boolean safetyCorrect = actualSafeToDrive == test.expectedSafeToDrive;
            boolean testPassed = positionCorrect && safetyCorrect;
            
            if (testPassed) {
                testsPassed++;
                System.out.println(" Test " + (i+1) + " PASSED: " + test.description + 
                                 " (" + test.angle + "° → " + actualPosition + ")");
                SmartDashboard.putString("Test Status", "✓ Test " + (i+1) + " PASSED");
            } else {
                testsFailed++;
                System.out.println(" Test " + (i+1) + " FAILED: " + test.description);
                System.out.println("  Angle: " + test.angle + "°");
                if (!positionCorrect) {
                    System.out.println("  Expected Position: " + test.expectedPosition + 
                                     ", Got: " + actualPosition);
                }
                if (!safetyCorrect) {
                    System.out.println("  Expected Safe to Drive: " + test.expectedSafeToDrive + 
                                     ", Got: " + actualSafeToDrive);
                }
                SmartDashboard.putString("Test Status", " Test " + (i+1) + " FAILED");
                SmartDashboard.putString("Last Test", 
                    "Failed at " + test.angle + "° - Expected: " + test.expectedPosition + 
                    ", Got: " + actualPosition);
            }
        }
        
        testingComplete = true;
        
        // Display final results
        System.out.println("\n=== Test Results ===");
        System.out.println("Passed: " + testsPassed + "/" + testCases.length);
        System.out.println("Failed: " + testsFailed);
        
        if (testsPassed == testCases.length) {
            System.out.println("ALL TESTS PASSED! Level 5 Complete!");
            SmartDashboard.putString("Test Status", "🎉 ALL TESTS PASSED!");
        } else {
            System.out.println("Some tests failed. Check your else-if logic!");
            SmartDashboard.putString("Test Status", 
                "Failed " + testsFailed + " tests - check console");
        }
        
        SmartDashboard.putString("Test Progress", 
            testsPassed + "/" + testCases.length + " passed, " + testsFailed + " failed");
        
        return testsPassed == testCases.length && testsFailed == 0;
    }
}