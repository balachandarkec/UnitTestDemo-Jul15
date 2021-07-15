import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator cal=null;
    int a=0;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All Called....");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("after All Called....");
    }
    @BeforeEach
    public void preSetup(){
        System.out.println("Setting up....");
        cal=new Calculator();
       a=30+1;
    }

    @AfterEach
    public void postCleanUp(){
        System.out.println("Cleaning  up....");
        cal=null;
    }


    //@Test
    @RepeatedTest(5)
    @DisplayName("Addition method Test Case..")
    //@Disabled("Temporary its disabled")
    public void addTest(){
     Assumptions.assumeTrue(System.getProperty("os.name").contains("Linux"));

        System.out.println("Add test case running...");
        assertEquals(30,Calculator.add(20,10),"Add Method failed");
//        Assertions.assertEquals(-10,cal.add(-20,10),"Add Method failed");
//        Assertions.assertEquals(-30,cal.add(-20,-10),"Add Method failed");
//        Assertions.assertEquals(10,cal.add(20,-10),"Add Method failed");
    }


    @Test
    public void divisionTest(){
     // assertEquals(6,cal.div(30,5),"Division failed");
      Throwable exception=assertThrows(ArithmeticException.class,()-> cal.div(1d,0d));
      //assertEquals("java.lang.ArithmeticException",exception.getClass());

       // assertTrue(exception.getClass().toString().contains("java.lang.ArithmeticException"));


        assertThrows(ArithmeticException.class,
                () -> {
                    cal.div(30,5);}, "Exception Thrown");
    }



}
