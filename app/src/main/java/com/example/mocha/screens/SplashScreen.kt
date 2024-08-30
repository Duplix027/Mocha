package com.example.mocha.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mocha.BottomBarScreen
import com.example.mocha.R
import com.example.ui.theme.bodyFontFamily
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController, onSplashFinished: () -> Unit) {



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        AniLoader(modifier = Modifier.size(400.dp), animation = R.raw.test)

        Spacer(modifier = Modifier.height(25.dp))
        Text(text = "Welcome!", fontFamily = bodyFontFamily, fontSize = 30.sp)

    }


    LaunchedEffect(key1 = true) {
        delay(7000)
        navController.navigate(BottomBarScreen.home.route) {
            popUpTo("splashScreen") {inclusive = true }
        }
        onSplashFinished()
    }
}



@Composable
fun AniLoader(modifier: Modifier, animation: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(animation))
    
    LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever, modifier = modifier)
}
