package com.rujirakongsomran.jc_m3calendar.repository

import com.himanshoe.kalendar.common.data.KalendarEvent
import java.time.LocalDate

class CalendarEventsRepository {
    fun getAllEvent() =
        listOf(
            KalendarEvent(
                date = LocalDate.of(2022, 2, 28),
                eventName = "Laura's Birthday \uD83C\uDF82",
                eventDescription = "join the party"
            ),
            KalendarEvent(
                date = LocalDate.of(2022, 2, 14),
                eventName = "Go on a date \uD83D\uDC96",
                eventDescription = "with Hardin"
            ),
            KalendarEvent(
                date = LocalDate.of(2022, 3, 2),
                eventName = "Get Vaccinated \uD83D\uDC89",
                eventDescription = "09:00 - 10:00 Auth Hospital"
            ),
        )
}