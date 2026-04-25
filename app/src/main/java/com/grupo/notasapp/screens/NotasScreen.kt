package com.grupo.notasapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotasScreen(
    correo: String,
    onCalcular: (Float) -> Unit
) {

    var nota1 by remember { mutableStateOf("") }
    var nota2 by remember { mutableStateOf("") }
    var nota3 by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF1E3A8A),
                        Color(0xFF3B82F6)
                    )
                )
            )
            .statusBarsPadding()
            .imePadding()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .shadow(10.dp, RoundedCornerShape(24.dp))
                    .background(Color.White, RoundedCornerShape(24.dp))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Ingreso de notas",
                    fontSize = 24.sp,
                    color = Color(0xFF1E3A8A),
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = correo,
                    fontSize = 13.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

            // Nota 1
                OutlinedTextField(
                    value = nota1,
                    onValueChange = { input ->
                        val numero = input.toFloatOrNull()
                        if (numero == null || (numero in 0.0..10.0)) {
                            nota1 = input
                        }
                        if (input.isEmpty()) nota1 = input
                    },
                    label = { Text("Nota 1 (0-10)") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(),
                    colors = textFieldColors()
                )

                Spacer(modifier = Modifier.height(12.dp))

            // Nota 2
                OutlinedTextField(
                    value = nota2,
                    onValueChange = { input ->
                        val numero = input.toFloatOrNull()
                        if (numero == null || (numero in 0.0..10.0)) {
                            nota2 = input
                        }
                        if (input.isEmpty()) nota2 = input
                    },
                    label = { Text("Nota 2 (0-10)") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(),
                    colors = textFieldColors()
                )

                Spacer(modifier = Modifier.height(12.dp))

            // Nota 3    
                OutlinedTextField(
                    value = nota3,
                    onValueChange = { input ->
                        val numero = input.toFloatOrNull()
                        if (numero == null || (numero in 0.0..10.0)) {
                            nota3 = input
                        }
                        if (input.isEmpty()) nota3 = input
                    },
                    label = { Text("Nota 3 (0-10)") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(),
                    colors = textFieldColors()
                )

                Spacer(modifier = Modifier.height(16.dp))

                if (error.isNotEmpty()) {
                    Text(
                        text = error,
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 13.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        if (
                            nota1.isBlank() ||
                            nota2.isBlank() ||
                            nota3.isBlank()
                        ) {
                            error = "Todos los campos son obligatorios"
                            return@Button
                        }

                        val promedio = (
                                nota1.toFloat() +
                                        nota2.toFloat() +
                                        nota3.toFloat()
                                ) / 3

                        onCalcular(promedio)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2563EB)
                    )
                ) {
                    Text("Calcular promedio", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun textFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = Color.Black,
    unfocusedTextColor = Color.Black,
    focusedLabelColor = Color(0xFF2563EB),
    unfocusedLabelColor = Color.Gray,
    cursorColor = Color(0xFF2563EB),
    focusedBorderColor = Color(0xFF2563EB),
    unfocusedBorderColor = Color.Gray
)