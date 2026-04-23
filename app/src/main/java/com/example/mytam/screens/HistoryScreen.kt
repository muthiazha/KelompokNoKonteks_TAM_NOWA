package com.example.kelompok_nokonteks_tam_nowa.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.BarChart
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kelompok_nokonteks_tam_nowa.component.SectionHeader
import com.example.kelompok_nokonteks_tam_nowa.component.Transaction
import com.example.kelompok_nokonteks_tam_nowa.component.TransactionItem
import com.example.kelompok_nokonteks_tam_nowa.ui.theme.*

@Composable
fun HistoryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        Column(modifier = Modifier.padding(24.dp).padding(top = 24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Riwayat Transaksi", color = White, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.AutoMirrored.Filled.BarChart, contentDescription = null, tint = White, modifier = Modifier.size(32.dp))
            }
            Text("Semua catatan pemasukan & pengeluaran", color = White.copy(alpha = 0.7f), fontSize = 14.sp)
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = BackgroundGray,
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
        ) {
            LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
                item { SectionHeader("HARI INI · 23 APRIL 2026") }
                item { TransactionItem(Transaction("Gaji Bulan April", "Pemasukan · Gaji", "Rp3.200.000", GreenIncome, "💰", "09:00")) }
                item { SectionHeader("KEMARIN · 22 APRIL") }
                item { TransactionItem(Transaction("Makan Siang", "Pengeluaran · Makanan", "-Rp45.000", RedExpense, "🍔", "12:30")) }
                item { TransactionItem(Transaction("Transportasi", "Pengeluaran · Transport", "-Rp25.000", RedExpense, "🚌", "07:15")) }
                item { TransactionItem(Transaction("Pulsa & Data", "Pengeluaran · Utilities", "-Rp80.000", RedExpense, "📱", "19:00")) }
                item { SectionHeader("21 APRIL 2026") }
                item { TransactionItem(Transaction("Kopi & Snack", "Pengeluaran · Makanan", "-Rp38.000", RedExpense, "☕", "10:20")) }
                item { TransactionItem(Transaction("Freelance Design", "Pemasukan · Sampingan", "+Rp350.000", GreenIncome, "🎓", "15:00")) }
            }
        }
    }
}