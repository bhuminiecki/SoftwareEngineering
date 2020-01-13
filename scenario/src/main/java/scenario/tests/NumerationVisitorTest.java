package scenario.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import scenario.NumerationVisitor;
import scenario.Step;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NumerationVisitorTest {
    private static NumerationVisitor test;

    @BeforeAll
    static void setUp() {
        test = new NumerationVisitor();
    }

    @Test
    void numerate1() {
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

        String expected = "1.Uzytkownik chce obliczyc wynik dzialania" +
                "\n1.1.Uzytkownik podaje argumenty" +
                "\n1.2.Uzytkownik wybiera operacje i klika znak rownosci" +
                "\n1.3.Kalkulator podaje wynik\n";
        String result = test.numerate(mockStep1, "1.");

        assertEquals(expected, result);

    }

    @Test
    void numerate2(){
        Step mockStep21 = mock(Step.class);
        when(mockStep21.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep21.getContent()).thenReturn("Bibliotekarz wybiera opcje definiowania egzemplarzy");
        Step mockStep22 = mock(Step.class);
        when(mockStep22.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep22.getContent()).thenReturn("System prezentuje zdefiniowane egzemplarze");

        Step mockStep231 = mock(Step.class);
        when(mockStep231.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep231.getContent()).thenReturn("Bibliotekarz wybiera opcje dodania egzemplarza");
        Step mockStep232 = mock(Step.class);
        when(mockStep232.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep232.getContent()).thenReturn("System prosi o podanie danych egzemplarza");
        Step mockStep233 = mock(Step.class);
        when(mockStep233.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep233.getContent()).thenReturn("Bibliotekarz podaje dane egzemplarza i zatwierdza");
        Step mockStep234 = mock(Step.class);
        when(mockStep234.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep234.getContent()).thenReturn("System informuje o poprawnym dodaniu egzemplarza i prezentuje zaktualizowana liste egzemplarzy");

        ArrayList<Step> mockList23 = new ArrayList<>();
        mockList23.add(mockStep231);
        mockList23.add(mockStep232);
        mockList23.add(mockStep233);
        mockList23.add(mockStep234);

        Step mockStep23 = mock(Step.class);
        when(mockStep23.getSteps()).thenReturn(mockList23);
        when(mockStep23.getContent()).thenReturn("FOR EACH egzemplarz:");

        ArrayList<Step> mockList2 = new ArrayList<>();
        mockList2.add(mockStep21);
        mockList2.add(mockStep22);
        mockList2.add(mockStep23);

        Step mockStep2 = mock(Step.class);
        when(mockStep2.getSteps()).thenReturn(mockList2);
        when(mockStep2.getContent()).thenReturn("IF Bibliotekarz pragnie dodac egzemplarze ksiazki");

        String expected = "1.IF Bibliotekarz pragnie dodac egzemplarze ksiazki" +
                "\n1.1.Bibliotekarz wybiera opcje definiowania egzemplarzy" +
                "\n1.2.System prezentuje zdefiniowane egzemplarze" +
                "\n1.3.FOR EACH egzemplarz:" +
                "\n1.3.1.Bibliotekarz wybiera opcje dodania egzemplarza" +
                "\n1.3.2.System prosi o podanie danych egzemplarza" +
                "\n1.3.3.Bibliotekarz podaje dane egzemplarza i zatwierdza" +
                "\n1.3.4.System informuje o poprawnym dodaniu egzemplarza i prezentuje zaktualizowana liste egzemplarzy\n";
        String result = test.numerate(mockStep2, "1.");

        assertEquals(expected, result);
    }
}
