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
fun ResultadosScreen(
    promedio: Float,
    onVolverANotas: () -> Unit,
    onCerrarSesion: () -> Unit
) {


    val colorResultado = when {
        promedio >= 7 -> Color(0xFF16A34A)
        promedio >= 5 -> Color(0xFFF59E0B)
        else -> Color(0xFFDC2626)
    }

    val textoEstado = when {
        promedio >= 6 -> "Aprobado"
        promedio >= 5 -> "Regular ️"
        else -> "Reprobado"
    }

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
                text = "Resultado final",
                fontSize = 24.sp,
                color = Color(0xFF1E3A8A),
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = "%.2f".format(promedio),
                fontSize = 42.sp,
                color = colorResultado
            )

            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = textoEstado,
                fontSize = 16.sp,
                color = colorResultado
            )

            Spacer(modifier = Modifier.height(32.dp))


            OutlinedButton(
                onClick = onVolverANotas,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Volver a notas")
            }

            Spacer(modifier = Modifier.height(12.dp))


            Button(
                onClick = onCerrarSesion,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2563EB)
                )
            ) {
                Text("Cerrar sesión", color = Color.White)
            }
        }
    }
}