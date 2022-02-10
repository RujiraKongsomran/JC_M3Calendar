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
import com.himanshoe.kalendar.ui.Kalendar
import com.himanshoe.kalendar.ui.KalendarType
import com.rujirakongsomran.jc_m3calendar.repository.CalendarEventsRepository
import com.rujirakongsomran.jc_m3calendar.ui.theme.JC_M3CalendarTheme

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
    val calendarEventsRepository = CalendarEventsRepository()
    val getAllEvent = calendarEventsRepository.getAllEvent()
    Kalendar(
        kalendarType = KalendarType.Firey(),
        kalendarStyle = KalendarStyle(
            kalendarSelector = KalendarSelector.Circle()
        ),
        kalendarEvents = getAllEvent,
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