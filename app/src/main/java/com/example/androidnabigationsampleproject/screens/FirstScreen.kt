package com.example.androidnabigationsampleproject.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen( modifier: Modifier = Modifier) {

    val name = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        Alignment.CenterHorizontally

    ) {
        Text("This is first screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.padding(16.dp))
        OutlinedTextField(
            value = name.value,
            onValueChange = {
                name.value = it
            }
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {

        }, shape = RoundedCornerShape(12.dp)) {
            Text("Go to Next Screen", fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    _root_ide_package_.com.example.androidnabigationsampleproject.ui.theme.AndroidNabigationSampleProjectTheme {
        FirstScreen()
    }
}