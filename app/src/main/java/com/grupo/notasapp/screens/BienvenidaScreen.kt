package com.grupo.notasapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BienvenidaScreen(
    correo: String,
    onContinuar: () -> Unit
) {


    val nombre = correo
        .substringBefore("@")
        .replaceFirstChar { it.uppercase() }


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
    ) {


        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(24.dp)
                .shadow(10.dp, RoundedCornerShape(24.dp))
                .background(Color.White, RoundedCornerShape(24.dp))
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                text = "¡Bienvenido!",
                fontSize = 28.sp,
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF1E3A8A)
            )

            Spacer(modifier = Modifier.height(12.dp))


            Text(
                text = nombre,
                fontSize = 22.sp,
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF2563EB)
            )

            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "Has iniciado sesión correctamente.",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(32.dp))


            Button(
                onClick = onContinuar,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2563EB)
                )
            ) {
                Text(
                    text = "Ingresar notas",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}