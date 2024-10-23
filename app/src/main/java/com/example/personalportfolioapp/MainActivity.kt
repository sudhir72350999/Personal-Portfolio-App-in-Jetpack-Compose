package com.example.personalportfolioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.personalportfolioapp.ui.theme.PersonalPortfolioAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            PersonalPortfolioAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }



                Surface(color = MaterialTheme.colorScheme.background) {
                    PortfolioScreen()
                }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PersonalPortfolioAppTheme {
        Greeting("Android")
        PortfolioScreen()
    }
}







@Composable
fun PortfolioScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Section
        ProfileSection()

        // Divider
        Divider(modifier = Modifier.padding(vertical = 16.dp))

        // Skills Section
        SkillsSection()

        // Divider
        Divider(modifier = Modifier.padding(vertical = 16.dp))

        // Projects Section
        ProjectsSection()
    }
}

@Composable
fun ProfileSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        // Profile Image
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your image
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        // Name
        Text(
            text = "John Doe",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 8.dp)
        )

        // Bio
        Text(
            text = "Android Developer | Kotlin Enthusiast | Open Source Contributor",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun SkillsSection() {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Skills",
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        SkillItem(skill = "Kotlin", proficiency = 0.9f)
        SkillItem(skill = "Jetpack Compose", proficiency = 0.8f)
        SkillItem(skill = "Android Development", proficiency = 0.85f)
    }
}

@Composable
fun SkillItem(skill: String, proficiency: Float) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = skill)
        LinearProgressIndicator(
            progress = proficiency,
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        )
    }
}

@Composable
fun ProjectsSection() {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Projects",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Project 1
        ProjectItem(
            projectName = "Weather App",
            description = "A weather forecasting app built using Jetpack Compose and Retrofit."
        )

        // Project 2
        ProjectItem(
            projectName = "Chat Application",
            description = "A real-time chat app using WebSockets and Firebase for messaging."
        )
    }
}

@Composable
fun ProjectItem(projectName: String, description: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = projectName, style = MaterialTheme.typography.bodyLarge)
        Text(text = description, style = MaterialTheme.typography.bodySmall)
    }
}
