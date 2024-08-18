package nsu.trushkov.model.dto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.Map;

/**
 * This class contains answers to questions.
 * <p>
 * This class is needed to contain minimal times for every carrier and difference between average sum and median.
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InfoForReport {
    private Map<String, Duration> minTimes;
    private Double differenceAverageMedian;
}
