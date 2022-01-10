package day01;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SummarizeRunningTest {

    @Test
    void summarizeTest() {
        SummarizeRunning summarizeRunning = new SummarizeRunning();
        Path path = Path.of("src/test/resources/running.csv");

        assertEquals(25.9, summarizeRunning.summarize(path, 2022, 1), 1);
    }
}