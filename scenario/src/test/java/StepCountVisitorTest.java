import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import scenario.Step;
import scenario.StepCountVisitor;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StepCountVisitorTest {
    private static StepCountVisitor test;

    @BeforeAll
    static void setUp() {
        test = new StepCountVisitor();
    }

    @Test
    void stepCount1() {
        Step mockStep1221 = mock(Step.class);
        when(mockStep1221.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep1222 = mock(Step.class);
        when(mockStep1222.getSteps()).thenReturn(new ArrayList<>());

        ArrayList<Step> mockList122 = new ArrayList<>();
        mockList122.add(mockStep1221);
        mockList122.add(mockStep1222);

        Step mockStep121 = mock(Step.class);
        when(mockStep121.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep122 = mock(Step.class);
        when(mockStep122.getSteps()).thenReturn(mockList122);

        ArrayList<Step> mockList12 = new ArrayList<>();
        mockList12.add(mockStep121);
        mockList12.add(mockStep122);

        Step mockStep11 = mock(Step.class);
        when(mockStep11.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep12 = mock(Step.class);
        when(mockStep12.getSteps()).thenReturn(mockList12);

        ArrayList<Step> mockList1 = new ArrayList<>();
        mockList1.add(mockStep11);
        mockList1.add(mockStep12);

        Step mockStep1 = mock(Step.class);
        when(mockStep1.getSteps()).thenReturn(mockList1);

        int result = test.stepCount(mockStep1);

        assertEquals(6, result);
    }

    @Test
    void stepCount2() {
        Step mockStep21 = mock(Step.class);
        when(mockStep21.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep22 = mock(Step.class);
        when(mockStep22.getSteps()).thenReturn(new ArrayList<>());

        Step mockStep231 = mock(Step.class);
        when(mockStep231.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep232 = mock(Step.class);
        when(mockStep232.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep233 = mock(Step.class);
        when(mockStep233.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep234 = mock(Step.class);
        when(mockStep234.getSteps()).thenReturn(new ArrayList<>());

        ArrayList<Step> mockList23 = new ArrayList<>();
        mockList23.add(mockStep231);
        mockList23.add(mockStep232);
        mockList23.add(mockStep233);
        mockList23.add(mockStep234);

        Step mockStep23 = mock(Step.class);
        when(mockStep23.getSteps()).thenReturn(mockList23);

        ArrayList<Step> mockList2 = new ArrayList<>();
        mockList2.add(mockStep21);
        mockList2.add(mockStep22);
        mockList2.add(mockStep23);

        Step mockStep2 = mock(Step.class);
        when(mockStep2.getSteps()).thenReturn(mockList2);

        int result = test.stepCount(mockStep2);

        assertEquals(7, result);
    }

    @Test
    void stepCount3() {
        Step mockStep31 = mock(Step.class);
        when(mockStep31.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep32 = mock(Step.class);
        when(mockStep32.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep33 = mock(Step.class);
        when(mockStep33.getSteps()).thenReturn(new ArrayList<>());

        ArrayList<Step> mockList3 = new ArrayList<>();
        mockList3.add(mockStep31);
        mockList3.add(mockStep32);
        mockList3.add(mockStep33);

        Step mockStep3 = mock(Step.class);
        when(mockStep3.getSteps()).thenReturn(mockList3);

        int result = test.stepCount(mockStep3);

        assertEquals(3, result);
    }

    @Test
    void stepCount4() {
        Step mockStep411 = mock(Step.class);
        when(mockStep411.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep412 = mock(Step.class);
        when(mockStep412.getSteps()).thenReturn(new ArrayList<>());

        ArrayList<Step> mockList41 = new ArrayList<>();
        mockList41.add(mockStep411);
        mockList41.add(mockStep412);

        Step mockStep41 = mock(Step.class);
        when(mockStep41.getSteps()).thenReturn(mockList41);

        Step mockStep4211 = mock(Step.class);
        when(mockStep4211.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep4212 = mock(Step.class);
        when(mockStep4212.getSteps()).thenReturn(new ArrayList<>());

        ArrayList<Step> mockList421 = new ArrayList<>();
        mockList421.add(mockStep4211);
        mockList421.add(mockStep4212);

        Step mockStep421 = mock(Step.class);
        when(mockStep421.getSteps()).thenReturn(mockList421);
        Step mockStep422 = mock(Step.class);
        when(mockStep422.getSteps()).thenReturn(new ArrayList<>());

        ArrayList<Step> mockList42 = new ArrayList<>();
        mockList42.add(mockStep421);
        mockList42.add(mockStep422);

        Step mockStep42 = mock(Step.class);
        when(mockStep42.getSteps()).thenReturn(mockList42);

        Step mockStep431 = mock(Step.class);
        when(mockStep431.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep432 = mock(Step.class);
        when(mockStep432.getSteps()).thenReturn(new ArrayList<>());
        Step mockStep433 = mock(Step.class);
        when(mockStep433.getSteps()).thenReturn(new ArrayList<>());

        ArrayList<Step> mockList43 = new ArrayList<>();
        mockList43.add(mockStep431);
        mockList43.add(mockStep432);
        mockList43.add(mockStep433);

        Step mockStep43 = mock(Step.class);
        when(mockStep43.getSteps()).thenReturn(mockList43);

        ArrayList<Step> mockList4 = new ArrayList<>();
        mockList4.add(mockStep41);
        mockList4.add(mockStep42);
        mockList4.add(mockStep43);

        Step mockStep4 = mock(Step.class);
        when(mockStep4.getSteps()).thenReturn(mockList4);

        int result = test.stepCount(mockStep4);

        assertEquals(12, result);
    }
}
