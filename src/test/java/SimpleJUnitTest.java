import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    int result;

@BeforeAll
static void beforeAll() {
    System.out.println("\n###    beforeAll()\n");
}

    @BeforeEach
    void beforeEach() {
        System.out.println("###       beforeEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###       afterEach()\n");
        result = 0;
    }


    @Test
    void firstTest () {
        int result = getResult();
        System.out.println("###       first test");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void SecondTest() {
        int result = getResult();
        System.out.println("###       second test");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void ThirdTest() {
        int result = getResult();
        System.out.println("###       third test");
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;


        }
    @AfterAll
    static void afterAll() {
        System.out.println("\n###    afterAll()\n");
    }
}