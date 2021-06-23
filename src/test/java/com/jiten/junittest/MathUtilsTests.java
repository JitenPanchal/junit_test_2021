package com.jiten.junittest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTests {

    MathUtils mathUtils;

    TestInfo testInfo;

    TestReporter testReporter;

    @BeforeEach
    void beforeEach(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        this.testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tag" + testInfo.getTags());
    }

    @AfterEach
    void afterEach() {
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @Test
    @DisplayName("Add method")
    void test() {

        int expected = 3;
        int v1 = 1;
        int v2 = 2;

        int actual = mathUtils.add(v1, v2);

        assertEquals(expected, actual, "addition of number");

        System.out.println(this);
    }

    @Test
    @DisplayName("compute circle method")
    void testComputeCircleRadius() {

        assertEquals(314.159265358979323846, mathUtils.computeCircleArea(10), "should return 314");

        System.out.println(this);
    }

    @Test
    @DisplayName("divide by zero should throw exception")
    void testDivide() {
        int v1 = 10;
        int v2 = 0;

        assertThrows(ArithmeticException.class, () -> mathUtils.divide(v1, v2), "divide by zero should throw");

        System.out.println(this);

    }

    @Test
    @Disabled
    @DisplayName("disabled test should not run")
    void testDisabled() {
        fail();
    }

    @Test
    @DisplayName("test should not run on linux os")
    @EnabledOnOs(OS.LINUX)
    void testOnLinuxOS() {
        fail();
    }

    @Test
    @DisplayName("test should not os with JRE 11")
    @EnabledOnJre(JRE.JAVA_11)
    void testOnJRE11() {
    }

    @Test
    @DisplayName("test should run isEnabled() method returns true")
    @EnabledIf("isEnabled")
    void testOnIf() {
    }

    static boolean isEnabled() {
        return true;
    }

    @Test
    @DisplayName("test EnabledIfSystemProperty")
//    @EnabledIfSystemProperty()
    void testIfEnabledIfSystemProperty() {
    }

    @Test
    @DisplayName("test EnabledIfEnvironmentVariable")
//    @EnabledIfEnvironmentVariable()
    void testEnabledIfEnvironmentVariable() {
    }

    @Test
    void testAssume() {
        boolean isServerUp = false;
        assumeTrue(isServerUp);
        System.out.println("should not run testAssume method");
    }

    @Test
    @DisplayName("multiply methods")
    void testAssertAll() {

        assertEquals(4, mathUtils.multiply(2, 2));
        assertEquals(9, mathUtils.multiply(3, 3));

        assertAll(() -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(9, mathUtils.multiply(3, 3)),
                () -> assertEquals(0, mathUtils.multiply(0, 3)));
    }

    @Nested
    class AddTests {


        @Test
        @DisplayName("Add method positive number")
        void testAddPositive() {

            int expected = 3;
            int v1 = 1;
            int v2 = 2;

            int actual = mathUtils.add(v1, v2);

            assertEquals(expected, actual, "addition of number");

            System.out.println(this);
        }

        @Test
        @DisplayName("Add method positive & negative number")
        void testAddPositiveAndNegativeNumber() {

            int expected = 3;
            int v1 = 1;
            int v2 = 2;

            int actual = mathUtils.add(v1, v2);

            assertEquals(expected, actual, "addition of number");

            System.out.println(this);
        }
    }

    // Lazy assert message
    @Test
    @DisplayName("Add method positive & negative number with lazy assert message")
    void testAddPositiveAndNegativeNumberWithLazy() {

        int expected = 3;
        int v1 = 1;
        int v2 = 2;

        int actual = mathUtils.add(v1, v2);

        assertEquals(expected, actual, () -> "addition of number - Lazy");

        System.out.println(this);
    }

    @RepeatedTest(3)
    @DisplayName("RepeatedTest for addition")
    @Tag("r")
    void testRepeated(RepetitionInfo info){
        System.out.println("Running with tag" + testInfo.getTags());
        testReporter.publishEntry("Published Running with tag" + testInfo.getTags());
        assertEquals(info.getCurrentRepetition()+info.getCurrentRepetition(),mathUtils.add(info.getCurrentRepetition(),info.getCurrentRepetition()) );
    }
}