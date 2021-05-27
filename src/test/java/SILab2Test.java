import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private SILab2 test = new SILab2();

    @Test
    void MultipleConditionTest() {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> test.function((List<Time>) new Time(-1,0,2)));
        assertFalse(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> test.function((List<Time>) new Time(25,0,2)));
        assertFalse(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> test.function((List<Time>) new Time(23,60,2)));
        assertFalse(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> test.function((List<Time>) new Time(23,-5,2)));
        assertFalse(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> test.function((List<Time>) new Time(23,50,60)));
        assertFalse(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> test.function((List<Time>) new Time(23,50,-5)));
        assertFalse(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> test.function((List<Time>) new Time(23,33,27)));
        assertFalse(ex.getMessage().contains("The time is greater than the maximum"));
    }

}