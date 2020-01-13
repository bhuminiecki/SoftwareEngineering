import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StepsDepthVisitorTest {
    static StepsDepthVisitor test;

    @BeforeAll
    static void setUp() {
        test = new StepsDepthVisitor();
    }

    @Test
    void stepsWithDepthRecursive1() {
        Step mockStep11 = mock(Step.class);
        when(mockStep11.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep11.getContent()).thenReturn("Uzytkownik podaje argumenty");
        Step mockStep12 = mock(Step.class);
        when(mockStep12.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep12.getContent()).thenReturn("Uzytkownik wybiera operacje i klika znak rownosci");
        Step mockStep13 = mock(Step.class);
        when(mockStep13.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep13.getContent()).thenReturn("Kalkulator podaje wynik");

        ArrayList<Step> mockList1 = new ArrayList<>();
        mockList1.add(mockStep11);
        mockList1.add(mockStep12);
        mockList1.add(mockStep13);

        Step mockStep1 = mock(Step.class);
        when(mockStep1.getSteps()).thenReturn(mockList1);
        when(mockStep1.getContent()).thenReturn("Uzytkownik chce obliczyc wynik dzialania");

        Step expected = new Step("Uzytkownik chce obliczyc wynik dzialania", new ArrayList<Step>());
        Step result = test.stepsWithDepthRecursive(mockStep1, 0);

        assertEquals(expected.getContent(), result.getContent());
        assertEquals(expected.getSteps(), result.getSteps());
    }
}