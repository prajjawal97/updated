package Com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;


public class SubmitForm {
    void utSetUp() throws Exception {
    }

    void setUp() throws Exception {

    }

    @Test
    void runTest() throws Exception {
        boolean testFailed = false;
        DriverUtility driverUtility = DriverUtility.getInstance();
        Content fileUtil = new Content();
        List<String> emailFile = fileUtil.readFile();
        for (int i = 0; i < emailFile.size(); i++) {
            try {
                driverUtility.performTest(emailFile.get(i));
            } catch (RuntimeException e) {
                testFailed = true;
                System.out.println("Test case " +(i + 1) +" = "+ emailFile.get(i)+"  failed with error :" + e);
            }
            if (!testFailed) {
                System.out.println("Test case " + (i + 1) +" = "+ emailFile.get(i)+ "  executed successfully");
            }
        }
        driverUtility.shutdownDriver();
    }

    @AfterMethod
    void tearDown() {
        system.out.println("After Test method");
        system.out.println("To check if After method is calling");
    }

}
