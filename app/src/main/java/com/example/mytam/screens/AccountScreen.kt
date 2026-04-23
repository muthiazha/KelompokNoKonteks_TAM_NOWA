package com.example.kelompok_nokonteks_tam_nowa.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kelompok_nokonteks_tam_nowa.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsScreen(navController: NavHostController) {
    var showAddAccount by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        Column(modifier = Modifier.padding(24.dp).padding(top = 24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { navController.popBackStack() }, modifier = Modifier.background(White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = White)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text("Daftar Akun", color = White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text("Total saldo: Rp3.650.000", color = White.copy(alpha = 0.7f), fontSize = 14.sp)
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = BackgroundGray,
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
        ) {
            LazyColumn(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                item {
                    AccountListItem("Kas / Tunai", "Cash", "Rp550.000", "💵", White) {
                        navController.navigate("account_detail")
                    }
                }
                item {
                    AccountListItem("BRI Tabungan", "Bank Account", "Rp2.900.000", "🏦", White) {}
                }
                item {
                    AccountListItem("GoPay", "E-Wallet", "Rp200.000", "💳", Color(0xFFFFF9C4)) {}
                }
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .border(1.dp, DarkBlue.copy(alpha = 0.3f), RoundedCornerShape(24.dp))
                            .background(DarkBlue.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
                            .clickable { showAddAccount = true },
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Add, contentDescription = null, tint = DarkBlue, modifier = Modifier.background(DarkBlue.copy(alpha = 0.1f), CircleShape).padding(4.dp))
                            Spacer(modifier = Modifier.width(12.dp))
                            Text("Tambah Akun Baru", color = DarkBlue, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
        if (showAddAccount) {
            ModalBottomSheet(onDismissRequest = { showAddAccount = false }) {
                AddAccountBottomSheet(onDismiss = { showAddAccount = false })
            }
        }
    }
}

@Composable
fun AccountListItem(name: String, type: String, balance: String, emoji: String, bgColor: Color, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = White),
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.size(48.dp).background(BackgroundGray, RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center) {
                Text(emoji, fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(name, fontWeight = FontWeight.Bold, color = TextBlack)
                Text(type, fontSize = 10.sp, color = TextGray)
            }
            Text(balance, fontWeight = FontWeight.ExtraBold, color = DarkBlue, fontSize = 16.sp)
        }
    }
}