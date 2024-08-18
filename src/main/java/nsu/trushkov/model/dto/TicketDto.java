package nsu.trushkov.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class contains ticket information.
 * @param origin            alias for origin city name
 * @param originName        origin city name
 * @param destination       alias for destination city name
 * @param destinationName   destination city name
 * @param departureDate     departure date
 * @param departureTime     departure time
 * @param arrivalDate       arrival date
 * @param arrivalTime       arrival time
 * @param carrier           carrier
 * @param stops             stops
 * @param price             price
 */

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record TicketDto(String origin, String originName, String destination, String destinationName,
                        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy") LocalDate departureDate,
                        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "H:mm") LocalTime departureTime,
                        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy") LocalDate arrivalDate,
                        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "H:mm") LocalTime arrivalTime,
                        String carrier, Integer stops, Integer price) {
}
