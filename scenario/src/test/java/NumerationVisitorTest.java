import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import scenario.NumerationVisitor;
import scenario.Step;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    void numerate3() {
        Step mockStep3221 = mock(Step.class);
        when(mockStep3221.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep3221.getContent()).thenReturn("Usun zawartosc linijki");
        Step mockStep3222 = mock(Step.class);
        when(mockStep3222.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep3222.getContent()).thenReturn("Jako nowa zawartosc wpisz slowo HACKED");

        ArrayList<Step> mockList322 = new ArrayList<>();
        mockList322.add(mockStep3221);
        mockList322.add(mockStep3222);

        Step mockStep321 = mock(Step.class);
        when(mockStep321.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep321.getContent()).thenReturn("Otworz plik txt");
        Step mockStep322 = mock(Step.class);
        when(mockStep322.getSteps()).thenReturn(mockList322);
        when(mockStep322.getContent()).thenReturn("FOR EACH wiersz pliku");

        ArrayList<Step> mockList32 = new ArrayList<>();
        mockList32.add(mockStep321);
        mockList32.add(mockStep322);

        Step mockStep31 = mock(Step.class);
        when(mockStep31.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep31.getContent()).thenReturn("Posortuj pliki alfabetycznie");
        Step mockStep32 = mock(Step.class);
        when(mockStep32.getSteps()).thenReturn(mockList32);
        when(mockStep32.getContent()).thenReturn("FOR EACH plik txt");

        ArrayList<Step> mockList3 = new ArrayList<>();
        mockList3.add(mockStep31);
        mockList3.add(mockStep32);

        Step mockStep3 = mock(Step.class);
        when(mockStep3.getSteps()).thenReturn(mockList3);
        when(mockStep3.getContent()).thenReturn("Otworz katalog");

        String expected = "1.Otworz katalog\n" +
                "1.1.Posortuj pliki alfabetycznie\n" +
                "1.2.FOR EACH plik txt\n" +
                "1.2.1.Otworz plik txt\n" +
                "1.2.2.FOR EACH wiersz pliku\n" +
                "1.2.2.1.Usun zawartosc linijki\n" +
                "1.2.2.2.Jako nowa zawartosc wpisz slowo HACKED\n";
        String result = test.numerate(mockStep3, "1.");

        assertEquals(expected, result);
    }

    @Test
    void numerate4() {
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

        String expected = "1.FOR EACH kromka chleba\n" +
                "1.1.IF splesniala kromka\n" +
                "1.1.1.Otworz szafke pod zlewem\n" +
                "1.1.2.Wyrzuc kromke do kosza\n" +
                "1.2.ELSE zrob kanapke\n" +
                "1.2.1.Posmaruj kromke\n" +
                "1.2.1.1.Posmaruj maslem\n" +
                "1.2.1.2.Posmaruj twarozkiem\n" +
                "1.2.2.Poloz pomidora\n" +
                "1.3.Umyj rece\n" +
                "1.3.1.Odkrec kran\n" +
                "1.3.2.Oplucz dlonie\n" +
                "1.3.3.Zakrec kran\n";
        String result = test.numerate(mockStep4, "1.");

        assertEquals(expected, result);
    }

    @Test
    void numerate5() {
        Step mockStep21 = mock(Step.class);
        when(mockStep21.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep21.getContent()).thenReturn("Przeciwnik wykonuje ruch");
        Step mockStep22 = mock(Step.class);
        when(mockStep22.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep22.getContent()).thenReturn("Uzytkownik wykonuje ruch");

        ArrayList<Step> mockList2 = new ArrayList<>();
        mockList2.add(mockStep21);
        mockList2.add(mockStep22);

        Step mockStep11 = mock(Step.class);
        when(mockStep11.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep11.getContent()).thenReturn("Uzytkownik klika na odpowiednia bierke");
        Step mockStep12 = mock(Step.class);
        when(mockStep12.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep12.getContent()).thenReturn("Uzytkownik klika na odpowiednie pole");

        ArrayList<Step> mockList1 = new ArrayList<>();
        mockList1.add(mockStep11);
        mockList1.add(mockStep12);

        Step mockStep1 = mock(Step.class);
        when(mockStep1.getSteps()).thenReturn(mockList1);
        when(mockStep1.getContent()).thenReturn("IF uzytkownik wybiera biale bierki");
        Step mockStep2 = mock(Step.class);
        when(mockStep2.getSteps()).thenReturn(mockList2);
        when(mockStep2.getContent()).thenReturn("ELSE uzytkownik wybiera czarne bierki");

        ArrayList<Step> mockList = new ArrayList<>();
        mockList.add(mockStep1);
        mockList.add(mockStep2);

        Step mockStep = mock(Step.class);
        when(mockStep.getSteps()).thenReturn(mockList);
        when(mockStep.getContent()).thenReturn("Uzytkownik gra w szachy");

        String expected = "1.Uzytkownik gra w szachy\n" +
                "1.1.IF uzytkownik wybiera biale bierki\n" +
                "1.1.1.Uzytkownik klika na odpowiednia bierke\n" +
                "1.1.2.Uzytkownik klika na odpowiednie pole\n" +
                "1.2.ELSE uzytkownik wybiera czarne bierki\n" +
                "1.2.1.Przeciwnik wykonuje ruch\n" +
                "1.2.2.Uzytkownik wykonuje ruch\n";
        String result = test.numerate(mockStep, "1.");

        assertEquals(expected, result);
    }

    @Test
    void numerate6() {

        Step mockStep21 = mock(Step.class);
        when(mockStep21.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep21.getContent()).thenReturn("Dziecko zdejmuje papierek");
        Step mockStep22 = mock(Step.class);
        when(mockStep22.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep22.getContent()).thenReturn("Dziecko zjada cukierek");

        ArrayList<Step> mockList2 = new ArrayList<>();
        mockList2.add(mockStep21);
        mockList2.add(mockStep22);

        Step mockStep1 = mock(Step.class);
        when(mockStep1.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep1.getContent()).thenReturn("Dziecko otwiera pudełko");
        Step mockStep2 = mock(Step.class);
        when(mockStep2.getSteps()).thenReturn(mockList2);
        when(mockStep2.getContent()).thenReturn("FOR EACH cukierek");
        Step mockStep3 = mock(Step.class);
        when(mockStep3.getSteps()).thenReturn(new ArrayList<>());
        when(mockStep3.getContent()).thenReturn("Dziecko wyrzuca pudelko do kosza");

        ArrayList<Step> mockList = new ArrayList<>();
        mockList.add(mockStep1);
        mockList.add(mockStep2);
        mockList.add(mockStep3);

        Step mockStep = mock(Step.class);
        when(mockStep.getSteps()).thenReturn(mockList);
        when(mockStep.getContent()).thenReturn("Dziecko chce zjesc pudelko cukierkow");

        String expected = "1.Dziecko chce zjesc pudelko cukierkow\n" +
                "1.1.Dziecko otwiera pudełko\n" +
                "1.2.FOR EACH cukierek\n" +
                "1.2.1.Dziecko zdejmuje papierek\n" +
                "1.2.2.Dziecko zjada cukierek\n" +
                "1.3.Dziecko wyrzuca pudelko do kosza\n";
        String result = test.numerate(mockStep, "1.");

        assertEquals(expected, result);
    }
}
