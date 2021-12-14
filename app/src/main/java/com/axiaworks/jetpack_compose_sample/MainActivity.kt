package com.axiaworks.jetpack_compose_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.axiaworks.jetpack_compose_sample.qiita.QiitaInfo

class MainActivity : ComponentActivity() {
    val qiitaViewModel by viewModels<QiitaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                InfoList(items = qiitaViewModel.qiitaInfoList)
                qiitaViewModel.fetchItemList("Android")
            }
        }
    }
}

@Composable
fun InfoList(items: List<QiitaInfo>) {
    LazyColumn {
        itemsIndexed(items = items) { index, item ->
            QiitaItem(item = item, index)
        }
    }
}

@ExperimentalCoilApi
@Composable
fun QiitaItem(item: QiitaInfo, index: Int) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp
    ) {
        Row(
            Modifier
                .padding(4.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = rememberImagePainter(
                    data = item.qiitaUser.profile_image_url,
                    builder = {
                        scale(Scale.FILL)
                        placeholder(R.drawable.logo_axiaworks)
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = item.url,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(80.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = item.title,
                style = MaterialTheme.typography.body1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Left
            )
        }
    }
}
