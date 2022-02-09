package com.rujirakongsomran.jc_m3calendar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.himanshoe.kalendar.common.KalendarSelector
import com.himanshoe.kalendar.common.KalendarStyle
import com.himanshoe.kalendar.common.data.KalendarEvent
import com.himanshoe.kalendar.ui.Kalendar
import com.himanshoe.kalendar.ui.KalendarType
import com.rujirakongsomran.jc_m3calendar.ui.theme.JC_M3CalendarTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_M3CalendarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateCalendar()
                }
            }
        }
    }
}

@Composable
fun CreateCalendar() {
    val context = LocalContext.current
    Kalendar(
        kalendarType = KalendarType.Firey(),
        kalendarStyle = KalendarStyle(
            kalendarSelector = KalendarSelector.Circle()
        ),
        kalendarEvents = listOf(
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
        ),
        onCurrentDayClick = { day, event ->
            if (event != null) {
                Toast.makeText(
                    context,
                    """
                        ${event.eventName}
                        ${event.eventDescription}
                    """.trimIndent(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }, errorMessage = { })
}

@Preview(showBackground = true)
@Composable
fun CreateCalendarPreview() {
    JC_M3CalendarTheme {
        CreateCalendar()
    }
}