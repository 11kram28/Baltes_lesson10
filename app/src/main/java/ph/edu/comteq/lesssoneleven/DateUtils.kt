package ph.edu.comteq.lesssoneleven

import java.text.SimpleDateFormat
import java.util.Locale

object DateUtils {
    private val dateFormat =
        SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

    private val timeFormat =
        SimpleDateFormat("h:mm a", Locale.getDefault())

    private val dateTimeFormat =
        SimpleDateFormat("MMM dd, yyyy h:mm a", Locale.getDefault())

    fun formatDate(timestamp: Long): String {
        return dateFormat.format(timestamp)
    }

    fun formatTime(timestamp: Long): String {
        return timeFormat.format(timestamp)
    }

    fun formatDateTime(timestamp: Long): String {
        return dateTimeFormat.format(timestamp)
    }


}