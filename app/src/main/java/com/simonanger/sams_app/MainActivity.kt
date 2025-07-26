package com.simonanger.sams_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simonanger.sams_app.ui.theme.Sams_appTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sams_appTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DadJokeApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

val dadJokes = listOf(
    "Why don't scientists trust atoms? Because they make up everything!",
    "Did you hear about the mathematician who's afraid of negative numbers? He'll stop at nothing to avoid them!",
    "Why don't eggs tell jokes? They'd crack each other up!",
    "I invented a new word: Plagiarism!",
    "Why did the scarecrow win an award? He was outstanding in his field!",
    "What do you call a fake noodle? An impasta!",
    "Why don't skeletons fight each other? They don't have the guts!",
    "What's the best thing about Switzerland? I don't know, but the flag is a big plus!",
    "Why did the coffee file a police report? It got mugged!",
    "How does a penguin build its house? Igloos it together!",
    "Why don't scientists trust stairs? Because they're always up to something!",
    "What do you call a dinosaur that crashes his car? Tyrannosaurus Wrecks!",
    "Why did the math book look so sad? Because it had too many problems!",
    "What do you call a sleeping bull? A bulldozer!",
    "Why don't programmers like nature? It has too many bugs!"
)

@Composable
fun DadJokeApp(modifier: Modifier = Modifier) {
    var currentJokeIndex by remember { mutableIntStateOf(0) }
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                currentJokeIndex = Random.nextInt(dadJokes.size)
            }
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Dad Jokes",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        Text(
            text = dadJokes[currentJokeIndex],
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        Text(
            text = "Tap anywhere for another joke!",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DadJokeAppPreview() {
    Sams_appTheme {
        DadJokeApp()
    }
}