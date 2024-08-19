package nsu.trushkov.handler;

import nsu.trushkov.model.InfoForReport;
import nsu.trushkov.model.dto.TicketDto;
import nsu.trushkov.model.dto.TicketsDto;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TicketHandlerTest {

    @Test
    void handle_withEvenAppropriateTickets() {
        //given
        TicketsDto ticketsDto = testDataTicketsDtoEven();
        InfoForReport expectInfo = getExpectInfoForReportEven();
        InfoForReport actualInfo = new InfoForReport(new HashMap<>(), Double.valueOf("0d"));
        TicketHandler ticketHandler = new TicketHandler();

        //when
        ticketHandler.handle(actualInfo, ticketsDto);

        //then;
        assertEquals(expectInfo, actualInfo);
    }

    @Test
    void handle_withOddAppropriateTickets() {
        //given
        TicketsDto ticketsDto = testDataTicketsDtoOdd();
        InfoForReport expectInfo = getExpectInfoForReportOdd();
        InfoForReport actualInfo = new InfoForReport(new HashMap<>(), Double.valueOf("0d"));
        TicketHandler ticketHandler = new TicketHandler();

        //when
        ticketHandler.handle(actualInfo, ticketsDto);

        //then;
        assertEquals(expectInfo, actualInfo);
    }

    private InfoForReport getExpectInfoForReportEven() {
        Map<String, Duration> expectMinTimes = new HashMap<>();
        expectMinTimes.put("TK", Duration.ofHours(4));
        expectMinTimes.put("S7", Duration.parse("PT2H10M"));
        return new InfoForReport(expectMinTimes, 250d);
    }

    private InfoForReport getExpectInfoForReportOdd() {
        Map<String, Duration> expectMinTimes = new HashMap<>();
        expectMinTimes.put("TK", Duration.ofHours(6));
        expectMinTimes.put("S7", Duration.parse("PT2H10M"));
        return new InfoForReport(expectMinTimes, 0d);
    }

    private TicketsDto testDataTicketsDtoEven() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");
        TicketDto ticketDto1 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("16:20", timeFormatter), LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("22:10", timeFormatter), "TK", 3, 10000);

        TicketDto ticketDto2 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("16:20", timeFormatter), LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("23:10", timeFormatter), "TK", 3, 11000);

        TicketDto ticketDto3 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("16:20", timeFormatter), LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("18:30", timeFormatter), "S7", 3, 12000);

        TicketDto ticketDto4 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("16:20", timeFormatter), LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("20:20", timeFormatter), "TK", 3, 14000);

        TicketDto ticketDto5 = new TicketDto("TLV", "Тель-Авив", "TLV",
                "Тель-Авив", LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("16:20", timeFormatter), LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("20:20", timeFormatter), "TK", 3, 14000);

        List<TicketDto> tickets = new ArrayList<>();
        tickets.add(ticketDto1);
        tickets.add(ticketDto2);
        tickets.add(ticketDto3);
        tickets.add(ticketDto4);
        tickets.add(ticketDto5);

        return new TicketsDto(tickets);
    }

    private TicketsDto testDataTicketsDtoOdd() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");
        TicketDto ticketDto1 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("16:10", timeFormatter), LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("22:10", timeFormatter), "TK", 3, 10000);

        TicketDto ticketDto2 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("16:20", timeFormatter), LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("23:10", timeFormatter), "TK", 3, 11000);

        TicketDto ticketDto3 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("16:20", timeFormatter), LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("18:30", timeFormatter), "S7", 3, 12000);

        TicketDto ticketDto4 = new TicketDto("VVO", "Владивосток", "UFA",
                "Уфа", LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("16:20", timeFormatter), LocalDate.parse ("12.05.18", dateFormatter),
                LocalTime.parse ("20:20", timeFormatter), "TK", 3, 14000);

        List<TicketDto> tickets = new ArrayList<>();
        tickets.add(ticketDto1);
        tickets.add(ticketDto2);
        tickets.add(ticketDto3);
        tickets.add(ticketDto4);

        return new TicketsDto(tickets);
    }

}