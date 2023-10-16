package com.example.mytask.presentation.main_screen.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytask.domain.models.other.AssociatedDrug


@Composable
fun MedicineItem(
    associatedDrug: AssociatedDrug,
    onItemClick:()->Unit={}
) {
    Box(
        modifier = Modifier
            .clickable { onItemClick() }
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(size = 10.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "name : ${associatedDrug.name}",
                style = TextStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 20.sp
                )
            )
            Divider(Modifier.padding(5.dp))
            Text(
                text = "strength : ${associatedDrug.strength}",
                style = TextStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 20.sp
                )
            )
            Divider(Modifier.padding(5.dp))
            Text(
                text = "dose : ${associatedDrug.dose}",
                style = TextStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 20.sp
                )
            )

        }
    }
}