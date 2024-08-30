package com.example.mocha

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
) {
    object calender: BottomBarScreen("calender", "Calender",R.drawable.baseline_date_range_24)
    object home: BottomBarScreen("home", "Home", R.drawable.home_filled)
    object goals: BottomBarScreen("goals", "Goals", R.drawable.rocket_filled)
}