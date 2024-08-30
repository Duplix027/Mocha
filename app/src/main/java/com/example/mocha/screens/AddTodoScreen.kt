package com.example.mocha.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.primaryLight
import com.example.compose.tertiaryDark
import com.example.compose.tertiaryLight
import com.example.mocha.BottomBar
import com.example.mocha.BottomBarScreen
import np.com.bimalkafle.todoapp.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTodoScreen(viewModel: TodoViewModel, navController: NavController) {
    var textFieldInput by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(top = 22.dp)
            .background(Color.White)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 100.dp),
                value = textFieldInput,
                shape = RoundedCornerShape(40.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = tertiaryDark),
                onValueChange = { textFieldInput = it },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                placeholder = { Text(text = "Add Todo Item", textAlign = TextAlign.Center) })
        }

        Button(
            modifier = Modifier.padding(top = 16.dp),
            onClick = {
                viewModel.addTodo(textFieldInput)
                textFieldInput = ""
                navController.navigate(BottomBarScreen.home.route)
            },
            colors = buttonColors(containerColor = primaryLight)
        ) {
            Text(text = "Done")
        }

    }

}