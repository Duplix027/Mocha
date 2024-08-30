package com.example.mocha.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.primaryContainerLight
import com.example.mocha.R
import com.example.mocha.TodoData
import com.example.ui.theme.bodyFontFamily
import np.com.bimalkafle.todoapp.TodoViewModel


@Composable
fun TodoListPage(viewModel: TodoViewModel, navController: NavController) {
    val todoList by viewModel.todoList.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {

        todoList?.let {
            LazyColumn( modifier = Modifier.padding(top=20.dp),
                content = {
                    items(it) { item: TodoData ->
                        TodoItem(item = item, onDelete = {
                            viewModel.deleteTodo(item.id)
                        })
                    }
                }
            )
        }

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 200.dp, end = 20.dp)
    ) { // Outer Box filling the space

        Box(modifier = Modifier.align(Alignment.BottomEnd)) { // Inner Box positioned at bottom right
            AddButton(onClick = {
                navController.navigate("addTodo")
            })
        }
    }


}

@Composable
fun AddButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        containerColor = primaryContainerLight,
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}


@Composable
fun TodoItem(item: TodoData, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .padding(10.dp)
            .padding(start = 35.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .border(border = BorderStroke(3.dp, Color.Black), shape = CircleShape)
            )

            HorizontalDivider(
                modifier = Modifier.width(45.dp),
                color = Color.Black,
                thickness = 5.dp
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.9f)
                        .clip(RoundedCornerShape(16.dp))
                        .background(primaryContainerLight)
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        textAlign = TextAlign.Center,
                        text = item.title,
                        fontSize = 20.sp,
                        fontFamily = bodyFontFamily,
                        color = Color.Black,
                    )
                }


                    IconButton(onClick = onDelete) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_delete_24),
                            contentDescription = "Delete",
                            tint = Color.Black
                        )
                    }

                }


            }


        }


    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val viewModel = TodoViewModel()
    TodoListPage(viewModel, navController = rememberNavController())
}
