package nsu.trushkov.writer;

import nsu.trushkov.model.InfoForReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Map;

/**
 * This class writes a report to the console.
 */
public class InfoConsoleWriter implements InfoWriter{
    private static final Logger log = LoggerFactory.getLogger(InfoConsoleWriter.class);

    /**
     * This method writes a report to the console.
     * @param infoForReport is object that contains answers
     */
    @Override
    public void write(InfoForReport infoForReport) {
        StringBuilder sb = new StringBuilder();
        sb.append("Минимальное время полета между городами Владивосток и Тель-Авив для каждого авиаперевозчика:\n\n");
        for (Map.Entry<String, Duration> entry : infoForReport.getMinTimes().entrySet()) {
            sb.append(entry.getKey()).append(" - ").append(getDuration(entry.getValue())).append("\n");
        }
        sb.append("\nРазница между средней ценой  и медианой для полета между городами Владивосток и Тель-Авив : ")
                .append(infoForReport.getDifferenceAverageMedian());

        sb.append("\n\nСсылка на исходный код - https://github.com/Saveliy11092003/flight_data_processor/tree/develop");

        log.info("Message - {}", sb);
        System.out.println(sb);
    }

    private String getDuration(Duration duration) {
        if (duration.toDays() == 0) {
            return duration.toHoursPart() + " ч., " + duration.toMinutesPart() + " мин.";
        }

        return duration.toDaysPart() + " д., " + duration.toHoursPart() + " ч., " + duration.toMinutesPart() + " мин.";
    }

}
