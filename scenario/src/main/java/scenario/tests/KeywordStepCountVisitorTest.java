package scenario.tests;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import scenario.KeywordStepCountVisitor;
import scenario.Step;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KeywordStepCountVisitorTest {
    private static KeywordStepCountVisitor test;

    @BeforeAll
    static void setUp(){
        test = new KeywordStepCountVisitor();
    }

    @Test
    public void StepCount1(){
        Step mockStep1221 = mock(Step.class);
        when(mockStep1221.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep1221.getContent()).thenReturn("Usun zawartosc linijki");
        Step mockStep1222 = mock(Step.class);
        when(mockStep1222.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep1222.getContent()).thenReturn("Jako nowa zawartosc wpisz slowo HACKED");

        ArrayList<Step> mockList122 = new ArrayList<>();
        mockList122.add(mockStep1221);
        mockList122.add(mockStep1222);

        Step mockStep121 = mock(Step.class);
        when(mockStep121.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep121.getContent()).thenReturn("Otworz plik txt");
        Step mockStep122 = mock(Step.class);
        when(mockStep122.getSteps()).thenReturn(mockList122);
        when(mockStep122.getContent()).thenReturn("FOR EACH wiersz pliku");

        ArrayList<Step> mockList12 = new ArrayList<>();
        mockList12.add(mockStep121);
        mockList12.add(mockStep122);

        Step mockStep11 = mock(Step.class);
        when(mockStep11.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep11.getContent()).thenReturn("Posortuj pliki alfabetycznie");
        Step mockStep12 = mock(Step.class);
        when(mockStep12.getSteps()).thenReturn(mockList12);
        when(mockStep12.getContent()).thenReturn("FOR EACH plik txt");

        ArrayList<Step> mockList1 = new ArrayList<>();
        mockList1.add(mockStep11);
        mockList1.add(mockStep12);

        Step mockStep1 = mock(Step.class);
        when(mockStep1.getSteps()).thenReturn(mockList1);
        when(mockStep1.getContent()).thenReturn("Otworz katalog");

        int result = test.stepCount(mockStep1);
        assertEquals(2, result);
    }

    @Test
    void stepCount2() {
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

        int result = test.stepCount(mockStep2);

        assertEquals(1, result);
    }

    @Test
    void stepCount3() {
        Step mockStep31 = mock(Step.class);
        when(mockStep31.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep31.getContent()).thenReturn("Kalkulator podaje wynik");
        Step mockStep32 = mock(Step.class);
        when(mockStep32.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep32.getContent()).thenReturn("Uzytkownik wybiera operacje i klika znak rownosci");
        Step mockStep33 = mock(Step.class);
        when(mockStep33.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep33.getContent()).thenReturn("Uzytkownik podaje argumenty");

        ArrayList<Step> mockList3 = new ArrayList<>();
        mockList3.add(mockStep31);
        mockList3.add(mockStep32);
        mockList3.add(mockStep33);

        Step mockStep3 = mock(Step.class);
        when(mockStep3.getSteps()).thenReturn(mockList3);
        when(mockStep3.getContent()).thenReturn("Użytkownik chce obliczyc wynik dzialania");

        int result = test.stepCount(mockStep3);
        assertEquals(0, result);
    }

    @Test
    void stepCount4() {
        Step mockStep411 = mock(Step.class);
        when(mockStep411.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep411.getContent()).thenReturn("Otworz szafke pod zlewem");
        Step mockStep412 = mock(Step.class);
        when(mockStep412.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep412.getContent()).thenReturn("Wyrzuc kromke do kosza");

        ArrayList<Step> mockList41 = new ArrayList<>();
        mockList41.add(mockStep411);
        mockList41.add(mockStep412);

        Step mockStep41 = mock(Step.class);
        when(mockStep41.getSteps()).thenReturn(mockList41);
        when(mockStep41.getContent()).thenReturn("IF splesniala kromka");

        Step mockStep4211 = mock(Step.class);
        when(mockStep4211.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep4211.getContent()).thenReturn("Posmaruj maslem");
        Step mockStep4212 = mock(Step.class);
        when(mockStep4212.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep4212.getContent()).thenReturn("Posmaruj twarozkiem");

        ArrayList<Step> mockList421 = new ArrayList<>();
        mockList421.add(mockStep4211);
        mockList421.add(mockStep4212);

        Step mockStep421 = mock(Step.class);
        when(mockStep421.getSteps()).thenReturn(mockList421);
        when(mockStep421.getContent()).thenReturn("Posmaruj kromke");
        Step mockStep422 = mock(Step.class);
        when(mockStep422.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep422.getContent()).thenReturn("Poloz pomidora");

        ArrayList<Step> mockList42 = new ArrayList<>();
        mockList42.add(mockStep421);
        mockList42.add(mockStep422);

        Step mockStep42 = mock(Step.class);
        when(mockStep42.getSteps()).thenReturn(mockList42);
        when(mockStep42.getContent()).thenReturn("ELSE zrob kanapke");

        Step mockStep431 = mock(Step.class);
        when(mockStep431.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep431.getContent()).thenReturn("Odkrec kran");
        Step mockStep432 = mock(Step.class);
        when(mockStep432.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep432.getContent()).thenReturn("Oplucz dlonie");
        Step mockStep433 = mock(Step.class);
        when(mockStep433.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep433.getContent()).thenReturn("Zakrec kran");

        ArrayList<Step> mockList43 = new ArrayList<>();
        mockList43.add(mockStep431);
        mockList43.add(mockStep432);
        mockList43.add(mockStep433);

        Step mockStep43 = mock(Step.class);
        when(mockStep43.getSteps()).thenReturn(mockList43);
        when(mockStep43.getContent()).thenReturn("Umyj rece");

        ArrayList<Step> mockList4 = new ArrayList<>();
        mockList4.add(mockStep41);
        mockList4.add(mockStep42);
        mockList4.add(mockStep43);

        Step mockStep4 = mock(Step.class);
        when(mockStep4.getSteps()).thenReturn(mockList4);
        when(mockStep4.getContent()).thenReturn("FOR EACH kromka chleba");

        int result = test.stepCount(mockStep4);

        assertEquals(2, result);
    }
}
