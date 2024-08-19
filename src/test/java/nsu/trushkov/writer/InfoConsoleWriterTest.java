package nsu.trushkov.writer;

import nsu.trushkov.model.InfoForReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InfoConsoleWriterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void write_withoutDays() {
        //given
        InfoForReport infoForReport = testDataInfoForReportWithoutDays();
        InfoConsoleWriter writer = new InfoConsoleWriter();
        String expect = getExpectReportWithoutDays();

        //when
        writer.write(infoForReport);

        //then
        assertEquals(expect, outContent.toString());
    }

    @Test
    void write_withDays() {
        //given
        InfoForReport infoForReport = testDataInfoForReportWithDays();
        InfoConsoleWriter writer = new InfoConsoleWriter();
        String expect = getExpectReportWithDays();

        //when
        writer.write(infoForReport);

        //then
        assertEquals(expect, outContent.toString());
    }

    private String getExpectReportWithoutDays() {
        StringBuilder sb = new StringBuilder();
        sb.append("Минимальное время полета между городами Владивосток и Тель-Авив для каждого авиаперевозчика:\n\n");
        sb.append("S7").append(" - ").append("2 ч., 10 мин.").append("\n");
        sb.append("TK").append(" - ").append("4 ч., 0 мин.").append("\n");
        sb.append("\nРазница между средней ценой  и медианой для полета между городами Владивосток и Тель-Авив : ")
                .append("250.0");
        sb.append("\n\nСсылка на исходный код - https://github.com/Saveliy11092003/flight_data_processor/tree/develop\n");
        return sb.toString();
    }

    private String getExpectReportWithDays() {
        StringBuilder sb = new StringBuilder();
        sb.append("Минимальное время полета между городами Владивосток и Тель-Авив для каждого авиаперевозчика:\n\n");
        sb.append("S7").append(" - ").append("1 д., ").append("4 ч., ").append("30 мин.").append("\n");
        sb.append("\nРазница между средней ценой  и медианой для полета между городами Владивосток и Тель-Авив : ")
                .append("250.0");
        sb.append("\n\nСсылка на исходный код - https://github.com/Saveliy11092003/flight_data_processor/tree/develop\n");
        return sb.toString();
    }

    private InfoForReport testDataInfoForReportWithDays() {
        Map<String, Duration> expectMinTimes = new HashMap<>();
        expectMinTimes.put("S7", Duration.parse("PT28H30M"));
        return new InfoForReport(expectMinTimes, 250d);
    }

    private InfoForReport testDataInfoForReportWithoutDays() {
        Map<String, Duration> expectMinTimes = new HashMap<>();
        expectMinTimes.put("TK", Duration.ofHours(4));
        expectMinTimes.put("S7", Duration.parse("PT2H10M"));
        return new InfoForReport(expectMinTimes, 250d);
    }
}