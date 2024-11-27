package com.plcoding.jetpackcomposemasterclass.measurements

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun BoxWithConstraintsDemo(modifier: Modifier = Modifier) {
    BoxWithConstraints(
        modifier = Modifier
            .width(200.dp)
    ) {
        if(constraints.hasFixedWidth) {
            Text("Fix width!")
        } else {
            Text("Dynamic width!")
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun BoxWithConstraintsPreview() {
    JetpackComposeMasterclassTheme {
        BoxWithConstraintsDemo()
    }
}