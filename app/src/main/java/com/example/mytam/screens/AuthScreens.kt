package com.example.kelompok_nokonteks_tam_nowa.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kelompok_nokonteks_tam_nowa.ui.theme.*
import com.example.kelompok_nokonteks_tam_nowa.component.AuthTextField

@Composable
fun SplashScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(NowaSecondary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "N",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = DarkBlue
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "NOWA",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            color = White,
            letterSpacing = 4.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Notes Walet · Financial Health Check",
            fontSize = 14.sp,
            color = White.copy(alpha = 0.7f)
        )
        Spacer(modifier = Modifier.height(60.dp))
        Button(
            onClick = { navController.navigate("login") },
            colors = ButtonDefaults.buttonColors(containerColor = NowaSecondary),
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier
                .height(56.dp)
                .width(200.dp)
        ) {
            Text(
                text = "Mulai →",
                color = DarkBlue,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .clip(RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp))
                .background(Brush.verticalGradient(listOf(DarkBlue, Color(0xFF3F3D8F))))
                .padding(24.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                Text(
                    text = "Selamat\nDatang 👋",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = White,
                    lineHeight = 48.sp
                )
                Text(
                    text = "Masuk ke akun NOWA kamu",
                    color = White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White, RoundedCornerShape(16.dp))
                    .padding(4.dp)
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Masuk")
                }
                TextButton(
                    onClick = { navController.navigate("register") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Daftar", color = TextGray)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            AuthTextField(label = "EMAIL", value = email, placeholder = "nama@email.com", onValueChange = { email = it })
            Spacer(modifier = Modifier.height(16.dp))
            AuthTextField(label = "PASSWORD", value = password, placeholder = "********", onValueChange = { password = it }, isPassword = true)

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5C6BC0)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Masuk Sekarang", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Belum punya akun? Daftar di sini",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate("register") },
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = TextGray
            )
        }
    }
}

@Composable
fun RegisterScreen(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp))
                .background(Brush.verticalGradient(listOf(DarkBlue, Color(0xFF3F3D8F))))
                .padding(24.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                Text(
                    text = "Buat Akun 🚀",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = White
                )
                Text(
                    text = "Mulai perjalanan finansial sehatmu",
                    color = White.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White, RoundedCornerShape(16.dp))
                    .padding(4.dp)
            ) {
                TextButton(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Masuk", color = TextGray)
                }
                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Daftar")
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            AuthTextField(label = "NAMA LENGKAP", value = name, placeholder = "Nama kamu", onValueChange = { name = it })
            Spacer(modifier = Modifier.height(16.dp))
            AuthTextField(label = "EMAIL", value = email, placeholder = "nama@email.com", onValueChange = { email = it })
            Spacer(modifier = Modifier.height(16.dp))
            AuthTextField(label = "PASSWORD", value = password, placeholder = "Min. 8 karakter", onValueChange = { password = it }, isPassword = true)

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5C6BC0)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Buat Akun", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Sudah punya akun? Masuk di sini",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate("login") },
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = TextGray
            )
        }
    }
}