package ac.uk.nottingham.design

//import ac.uk.nottingham.design.library.theme.AppTheme
import ac.uk.nottingham.design.library.icon.DefaultIcons
import ac.uk.nottingham.design.library.theme.AppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TestMethod("Android")
                }
            }
        }
    }
}

@Composable
fun TestMethod(name: String) {
    Column() {
        Text(text = "Hello $name!")
        Image(painter = painterResource(id = DefaultIcons.Map), contentDescription = "Map Icon")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme() {
        TestMethod("Android")
    }
}