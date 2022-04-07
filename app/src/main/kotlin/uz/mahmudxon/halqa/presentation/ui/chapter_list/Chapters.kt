package uz.mahmudxon.halqa.presentation.ui.chapter_list

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import uz.mahmudxon.halqa.R

fun NavGraphBuilder.courses(
    onCourseSelected: (Long, NavBackStackEntry) -> Unit,
    onboardingComplete: State<Boolean>, // https://issuetracker.google.com/174783110
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

}

@Composable
fun CoursesAppBar() {
    TopAppBar(
        elevation = 0.dp,
        modifier = Modifier.height(80.dp)
    ) {
        Image(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterVertically),
            painter = painterResource(id = R.drawable.ic_lockup_white),
            contentDescription = null
        )
    }
}


enum class CourseTabs(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
) {
    ALL_CHAPTERS(
        R.string.all_chapters,
        R.drawable.ic_list_24,
        ChaptersDestinations.ALL_CHAPTERS_ROUTE
    ),
    FAVORITES(R.string.favorites, R.drawable.ic_favorite_24, ChaptersDestinations.FAVORITES_ROUTE),
    SEARCH(R.string.search, R.drawable.ic_search_24, ChaptersDestinations.SEARCH_CHAPTER_ROUTE)
}

private object ChaptersDestinations {
    const val FAVORITES_ROUTE = "chapters/favorites"
    const val ALL_CHAPTERS_ROUTE = "chapters/all"
    const val SEARCH_CHAPTER_ROUTE = "chapters/search"
}
