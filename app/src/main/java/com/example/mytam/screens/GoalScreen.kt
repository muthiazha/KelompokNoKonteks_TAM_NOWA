package com.example.kelompok_nokonteks_tam_nowa.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kelompok_nokonteks_tam_nowa.component.BudgetCard
import com.example.kelompok_nokonteks_tam_nowa.component.GoalCard
import com.example.kelompok_nokonteks_tam_nowa.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalsScreen() {
    var showAddGoalSheet by remember { mutableStateOf(false) }
    var showAddBudgetSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        Column(modifier = Modifier.padding(24.dp).padding(top = 24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Goals & Budget", color = White, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Default.TrackChanges, contentDescription = null, tint = Pink40, modifier = Modifier.size(32.dp))
            }
            Text("Rencanakan masa depan finansialmu", color = White.copy(alpha = 0.7f), fontSize = 14.sp)
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = BackgroundGray,
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
        ) {
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                item {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("Target Tabungan", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(
                            "+ Tambah",
                            color = DarkBlue,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable { showAddGoalSheet = true }
                        )
                    }
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }
                item {
                    GoalCard("Dana Darurat", "Rp6.000.000", "Rp3.480.000", "Rp2.520.000", 0.58f, "58%", "🏠")
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }
                item {
                    GoalCard("Liburan Bali", "Rp2.000.000", "Rp660.000", "Des 2026", 0.33f, "33%", "✈️")
                }
                item { Spacer(modifier = Modifier.height(24.dp)) }
                item {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("Budget Bulanan", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(
                            "+ Tambah",
                            color = DarkBlue,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable { showAddBudgetSheet = true }
                        )
                    }
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }
                item {
                    BudgetCard("Makanan & Minum", "Rp420.000", "Rp600.000", 0.7f, "70% terpakai", "Sisa Rp180.000", DarkBlue, "🍔")
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }
                item {
                    BudgetCard("Transportasi", "Rp120.000", "Rp300.000", 0.4f, "40% terpakai", "Sisa Rp180.000", GreenIncome, "🚌")
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }
                item {
                    BudgetCard("Hiburan", "Rp195.000", "Rp150.000", 1.0f, "⚠️ Melebihi batas!", "+Rp45.000", RedExpense, "🎮")
                }
            }
        }
    }

    if (showAddGoalSheet) {
        ModalBottomSheet(onDismissRequest = { showAddGoalSheet = false }) {
            AddGoalBottomSheet(onDismiss = { showAddGoalSheet = false })
        }
    }

    if (showAddBudgetSheet) {
        ModalBottomSheet(onDismissRequest = { showAddBudgetSheet = false }) {
            AddBudgetBottomSheet(onDismiss = { showAddBudgetSheet = false })
        }
    }
}