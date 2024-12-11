package com.plcoding.jetpackcomposemasterclass.performance.homework

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val FILE_NAME = "kermit.jpg"

val initialItems = (1..100).map {
    ListItem(
        id = it,
        title = "List item $it",
        description = "Description $it",
        isContextMenuVisible = false,
        photo = null
    )
}

data class ListItem(
    val id: Int,
    val title: String,
    val description: String,
    val isContextMenuVisible: Boolean,
    val photo: ImageBitmap?
)

sealed interface ListAction {
    data class OnContextVisibilityChange(val id: Int, val isVisible: Boolean): ListAction
    data class OnCreatePhoto(val id: Int, val photo: ImageBitmap): ListAction
}

class ListViewModel: ViewModel() {

    private val _items = MutableStateFlow(initialItems)
    val items = _items.asStateFlow()

    fun onAction(action: ListAction) {
        when(action) {
            is ListAction.OnContextVisibilityChange -> {
                _items.update { currentItems ->
                    currentItems.map {
                        if(it.id == action.id) {
                            it.copy(isContextMenuVisible = action.isVisible)
                        } else it
                    }
                }
            }
            is ListAction.OnCreatePhoto -> {
                _items.update { currentItems ->
                    currentItems.map {
                        if(it.id == action.id) {
                            it.copy(photo = action.photo)
                        } else it
                    }
                }
            }
        }
    }
}

@Composable
fun ListItemScreenRoot(modifier: Modifier = Modifier) {
    val viewModel = viewModel<ListViewModel>()
    val items by viewModel.items.collectAsStateWithLifecycle()
    Homework1(
        items = items,
        onAction = viewModel::onAction,
        modifier = modifier
    )
}

@Composable
fun Homework1(
    items: List<ListItem>,
    onAction: (ListAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
    ) {
        items(items) { item ->
            LaunchedEffect(item.photo) {
                context.assets.open(FILE_NAME).use {
                    it.readBytes()
                }.also {
                    val bmp = BitmapFactory.decodeByteArray(it, 0, it.size).asImageBitmap()
                    onAction(ListAction.OnCreatePhoto(item.id, bmp))
                }
            }
            ContextualListItem(
                item = item,
                modifier = Modifier
                    .fillMaxWidth(),
                onContextVisibilityChange = { isVisible ->
                    onAction(ListAction.OnContextVisibilityChange(item.id, isVisible))
                },
                actions = {
                    listOf(
                        Icons.Default.Star,
                        Icons.Default.Phone,
                        Icons.Default.Edit,
                    ).forEach { icon ->
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null
                            )
                        }
                    }
                }
            )
        }
    }
}

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
private fun ContextualListItem(
    item: ListItem,
    actions: @Composable RowScope.() -> Unit,
    onContextVisibilityChange: (isVisible: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var contextMenuWidth by remember {
        mutableFloatStateOf(0f)
    }
    val offset = remember {
        Animatable(initialValue = 0f)
    }
    val scope = rememberCoroutineScope()

    LaunchedEffect(item.isContextMenuVisible, contextMenuWidth) {
        if (item.isContextMenuVisible) {
            offset.animateTo(contextMenuWidth)
        } else {
            offset.animateTo(0f)
        }
    }

    Box(
        modifier = modifier
            .height(IntrinsicSize.Min),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.Green)
                .onSizeChanged { contextMenuWidth = it.width.toFloat() }
        ) {
            actions()
        }
        ListItem(
            headlineContent = { Text(item.title) },
            supportingContent = { Text(item.description) },
            leadingContent = {
                item.photo?.let {
                    Image(
                        bitmap = item.photo,
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            },
            modifier = Modifier
                .offset(x = with(LocalDensity.current) {
                    offset.value.toDp()
                })
                .background(Color.Green)
                .pointerInput(true) {
                    detectHorizontalDragGestures(
                        onHorizontalDrag = { _, dragAmount ->
                            scope.launch {
                                val newOffset = (offset.value + dragAmount)
                                    .coerceIn(0f, contextMenuWidth)
                                offset.snapTo(newOffset)
                            }
                        },
                        onDragEnd = {
                            when {
                                offset.value >= contextMenuWidth / 2f -> {
                                    scope.launch {
                                        offset.animateTo(contextMenuWidth)
                                        onContextVisibilityChange(true)
                                    }
                                }

                                else -> {
                                    scope.launch {
                                        offset.animateTo(0f)
                                        onContextVisibilityChange(false)
                                    }
                                }
                            }
                        }
                    )
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Homework1Preview() {
    ListItemScreenRoot()
}