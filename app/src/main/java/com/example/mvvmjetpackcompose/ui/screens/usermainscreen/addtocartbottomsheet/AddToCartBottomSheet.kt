package com.example.mvvmjetpackcompose.ui.screens.usermainscreen.addtocartbottomsheet

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.mvvmjetpackcompose.data.models.RelationShipEnableModel

import timber.log.Timber

@Composable
fun RelationShipEnableDialog(
    relationShipEnableModels: List<RelationShipEnableModel>,
    setShowDialog: (Boolean) -> Unit,
    onItemClick: (Boolean, Int) -> Unit, modifier: Modifier = Modifier
) {


    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White,

            ) {
            Column(
                modifier = modifier.padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Serum Vitamin B12",
                    style = TextStyle.Default.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )

                Spacer(modifier = modifier.height(10.dp))
                LazyColumn(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .height(250.dp), state = rememberLazyListState()
                ) {
                    itemsIndexed(relationShipEnableModels) { index, item ->
                        RelationShipEnableDialogItem(
                            relationShipEnableModel = item,
                            setValue = { onItemClick(it, index) }, isSwitchEnabled = item.enabled
                        )
                    }
                }

                Spacer(modifier = modifier.height(10.dp))

                Row(
                    modifier = modifier

                        .height(50.dp)
                ) {
                    TextButton(
                        onClick = { /*TODO*/ },
                        modifier = modifier
                            .weight(1f)
                            .fillMaxHeight()
                    ) {
                        Text(text = "Cancel")
                    }
                    Button(
                        onClick = { /*TODO*/ }, modifier = modifier
                            .weight(1f)
                            .fillMaxHeight(), shape = RoundedCornerShape(topStart = 100.dp)
                    ) {
                        Text(text = "Add To Cart")
                    }
                }
            }

        }
    }
}


@Composable
fun RelationShipEnableDialogItem(
    modifier: Modifier = Modifier,
    relationShipEnableModel: RelationShipEnableModel,
    setValue: (Boolean) -> Unit,
    isSwitchEnabled: Boolean
) {
var isSwitch= remember {
    mutableStateOf(false)
}
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 7.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = relationShipEnableModel.name,
                style = TextStyle.Default.copy(color = Color.Black, fontSize = 17.sp)
            )

            Switch(
                checked = isSwitchEnabled,
                onCheckedChange = {
                    isSwitch.value=it
                })
        }
        Divider()
    }

}