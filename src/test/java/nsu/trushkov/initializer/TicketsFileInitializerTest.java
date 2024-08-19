package nsu.trushkov.initializer;

import nsu.trushkov.model.dto.TicketDto;
import nsu.trushkov.model.dto.TicketsDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketsFileInitializerTest {

    @Test
    void init() {
        //given
        TicketsDto expect = getExpectTicketsDto();
        TicketsInitializer initializer = new TicketsFileInitializer();

        //when
        TicketsDto actual = initializer.init();

        //then
        assertEquals(expect, actual);
    }

    private TicketsDto getExpectTicketsDto() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:mm");
        TicketDto ticketDto1 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("16:20", timeFormatter), LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("22:10", timeFormatter), "TK", 3, 12400);

        TicketDto ticketDto2 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("17:20", timeFormatter), LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("23:50", timeFormatter), "S7", 1, 13100);

        TicketDto ticketDto3 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("12:10", timeFormatter), LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("18:10", timeFormatter), "SU", 0, 15300);

        TicketDto ticketDto4 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("17:00", timeFormatter), LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("23:30", timeFormatter), "TK", 2, 11000);

        TicketDto ticketDto5 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("12:10", timeFormatter), LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("20:15", timeFormatter), "BA", 3, 13400);

        TicketDto ticketDto6 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("9:40", timeFormatter), LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("19:25", timeFormatter), "SU", 3, 12450);

        TicketDto ticketDto7 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("17:10", timeFormatter), LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("23:45", timeFormatter), "TK", 1, 13600);

        TicketDto ticketDto8 = new TicketDto("VVO", "Владивосток", "UFA",
                "Уфа", LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("15:15", timeFormatter), LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("17:45", timeFormatter), "TK", 1, 33400);

        TicketDto ticketDto9 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("6:10", timeFormatter), LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("15:25", timeFormatter), "TK", 0, 14250);

        TicketDto ticketDto10 = new TicketDto("LRN", "Ларнака", "TLV",
                "Тель-Авив", LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("12:50", timeFormatter), LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("14:30", timeFormatter), "SU", 1, 7000);

        TicketDto ticketDto11 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("16:50", timeFormatter), LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("23:35", timeFormatter), "SU", 1, 16700);

        TicketDto ticketDto12 = new TicketDto("VVO", "Владивосток", "TLV",
                "Тель-Авив", LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("6:10", timeFormatter), LocalDate.parse("12.05.18", dateFormatter),
                LocalTime.parse("16:15", timeFormatter), "S7", 0, 17400);

        List<TicketDto> tickets = new ArrayList<>();
        tickets.add(ticketDto1);
        tickets.add(ticketDto2);
        tickets.add(ticketDto3);
        tickets.add(ticketDto4);
        tickets.add(ticketDto5);
        tickets.add(ticketDto6);
        tickets.add(ticketDto7);
        tickets.add(ticketDto8);
        tickets.add(ticketDto9);
        tickets.add(ticketDto10);
        tickets.add(ticketDto11);
        tickets.add(ticketDto12);
        return new TicketsDto(tickets);
    }
}