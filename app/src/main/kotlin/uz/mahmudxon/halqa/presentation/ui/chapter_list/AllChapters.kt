package uz.mahmudxon.halqa.presentation.ui.chapter_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.insets.statusBarsHeight
import uz.mahmudxon.halqa.R
import uz.mahmudxon.halqa.business.domain.model.Chapter
import uz.mahmudxon.halqa.presentation.theme.OwlTheme
import uz.mahmudxon.halqa.util.Roman

@Composable
fun ChapterListItem(
    number: Int,
    title: String,
    description: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = OwlTheme.elevations.card,
    titleStyle: TextStyle = MaterialTheme.typography.subtitle1,
) {
    Surface(
        elevation = elevation,
        shape = shape,
        modifier = modifier
    ) {
        Row(modifier = Modifier.clickable(onClick = onClick)) {

            Box(
                modifier = Modifier.aspectRatio(1f)
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.opened_book),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillHeight
                )
                if (number in 1..32) {
                    Text(
                        text = Roman.intToRoman(number),
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 16.dp),
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    Card(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .width(26.dp)
                            .height(30.dp),
                        shape = shape,
                        backgroundColor = MaterialTheme.colors.primary
                    ) {
                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = number.toString(),
                                fontSize = 12.sp,
                                color = Color.White,
                                modifier = Modifier.padding(),
                                textAlign = TextAlign.End
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = titleStyle,
                    // maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                )
                if (description.isNotEmpty())
                    Text(
                        text = description,
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.caption,
                    )
            }
        }
    }
}


@Composable
fun Chapter(
    chapter: Chapter,
    index: Int,
    selectChapter: (Int) -> Unit
) {
    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        val stagger = if (index % 2 == 0) 48.dp else 16.dp
        Spacer(modifier = Modifier.width(stagger))
        ChapterListItem(
            number = chapter.chapterNumber,
            title = chapter.title,
            description = chapter.description,
            onClick = { selectChapter(chapter.chapterNumber) },
            shape = RoundedCornerShape(topStart = 24.dp),
            modifier = Modifier.height(96.dp)
        )
    }
}

@Composable
fun AllChapters(
    chapters: List<Chapter>,
    modifier: Modifier = Modifier,
    selectChapter: (Int) -> Unit
) {
    LazyColumn(modifier) {
        item {
            Spacer(Modifier.statusBarsHeight())
        }
        item {
            CoursesAppBar()
        }
        item { Spacer(Modifier.height(16.dp)) }
        itemsIndexed(chapters) { index, chapter ->
            Chapter(
                chapter = chapter,
                index = index,
                selectChapter = selectChapter
            )
        }
    }
}