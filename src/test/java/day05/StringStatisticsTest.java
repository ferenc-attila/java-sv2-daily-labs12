package day05;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringStatisticsTest {

    @Test
    void stringStatistics() {
        StringStatistics stringStatistics = new StringStatistics();

        Map<Character, Integer> statistics = stringStatistics.createStringStatistics("You can enter a string here");
        assertEquals(14, statistics.size());
        assertEquals(1, statistics.get('Y'));
        assertEquals(3, statistics.get('n'));
    }
}