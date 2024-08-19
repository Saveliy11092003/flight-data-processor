package nsu.trushkov.model;

import lombok.*;

import java.time.Duration;
import java.util.Map;
import java.util.Objects;

/**
 * This class contains answers to questions.
 * <p>
 * This class is needed to contain minimal times for every carrier and difference between average sum and median.
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InfoForReport {
    private Map<String, Duration> minTimes;
    private Double differenceAverageMedian;

}
