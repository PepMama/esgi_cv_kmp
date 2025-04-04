package com.example.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import org.jetbrains.compose.resources.painterResource
import quiz.composeapp.generated.resources.Res
import quiz.composeapp.generated.resources.photo_cv

import com.example.quiz.skillsList
import com.example.quiz.experiencesList
import com.example.quiz.formationsList
import com.example.quiz.descriptionText
import com.example.quiz.header
import com.example.quiz.interests
import com.example.quiz.languages
import com.example.quiz.strengths


// avoir des dataclass avec les données du CV (contienennt le header, description, etc)
@Composable
fun Image(){
    Image(
        painter = painterResource(Res.drawable.photo_cv), contentDescription = "Photo de profil",
        modifier = Modifier
            .size(140.dp)
            .padding(end = 8.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun LigneDesign(color: Color){
    Divider(
        thickness = 1.dp,
        modifier = Modifier.fillMaxWidth(),
        color = color
    )
}

@Composable
fun Header(data: HeaderData) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD89E00))
            .padding(16.dp)
    ) {
        Column {
            Text(data.name, style = MaterialTheme.typography.h1, color = Color.White)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                data.subtitle,
                style = MaterialTheme.typography.subtitle1.copy(color = Color.White)
            )
        }
    }
}


@Composable
fun Description(paragraphs: List<String>) {
    Column {
        paragraphs.forEach {
            Text(it)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun Skills() {
    BoxWithConstraints {
        val isMobile = maxWidth < 600.dp

        Box(
            modifier = Modifier
                .padding(end = 16.dp)
                .background(Color(0xFF425365), shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            CompositionLocalProvider(LocalContentColor provides Color.White) {
                Column {
                    Image()
                    Text("Compétences", style = MaterialTheme.typography.h6)
                    Spacer(Modifier.height(8.dp))

                    if (isMobile) {
                        // Répartition en 2 colonnes sur mobile
                        Row(modifier = Modifier.fillMaxWidth()) {
                            val half = skillsList.size / 2 + skillsList.size % 2
                            val left = skillsList.take(half)
                            val right = skillsList.drop(half)

                            Column(modifier = Modifier.weight(1f)) {
                                left.forEach { category ->
                                    Text(category.title, style = MaterialTheme.typography.subtitle1)
                                    category.items.forEach { item -> Text("• $item") }
                                    Spacer(Modifier.height(8.dp))
                                }
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                right.forEach { category ->
                                    Text(category.title, style = MaterialTheme.typography.subtitle1)
                                    category.items.forEach { item -> Text("• $item") }
                                    Spacer(Modifier.height(8.dp))
                                }
                            }
                        }
                    } else {
                        // Affichage en 1 colonne sur desktop
                        skillsList.forEach { category ->
                            Text(category.title, style = MaterialTheme.typography.subtitle1)
                            category.items.forEach { item -> Text("• $item") }
                            Spacer(Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun Experiences() {
    Box(
        modifier = Modifier
            .padding(start = 16.dp)
            .background(Color(0xFFEFEFEF), shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Column {
            Description(paragraphs = descriptionText)
            Spacer(Modifier.height(8.dp))
            LigneDesign(color = Color(0xFF425365))
            Spacer(Modifier.height(8.dp))
            Text("Expériences", style = MaterialTheme.typography.h6)
            Spacer(Modifier.height(8.dp))
            experiencesList.forEach {
                Text(it.title, style = MaterialTheme.typography.subtitle1)
                Text(it.description)
                Spacer(Modifier.height(16.dp))
            }

            Spacer(Modifier.height(16.dp))
            Text("Formations", style = MaterialTheme.typography.h6)
            Spacer(Modifier.height(8.dp))
            formationsList.forEach {
                Text(it.title)
            }
        }
    }
}

@Composable
fun FooterInfos(title: String, items: List<String>) {
    Column {
        Text(title, style = MaterialTheme.typography.h6)
        items.forEach {
            Text(it)
        }
    }
}

@Composable
fun App() {
    MaterialTheme {
        BoxWithConstraints {
            val isMobile = maxWidth < 600.dp

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Header(data = header)
                Spacer(Modifier.height(24.dp))
                LigneDesign(color = Color(0xFF425365))
                Spacer(Modifier.height(24.dp))

                if (isMobile) {
                    Column {
                        Skills()
                        Spacer(Modifier.height(16.dp))
                        Experiences()
                    }
                } else {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Skills()
                        Experiences()
                    }
                }

                Spacer(Modifier.height(24.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFD89E00))
                        .padding(16.dp)
                ) {
                    CompositionLocalProvider(LocalContentColor provides Color.White) {
                        if (isMobile) {
                            Column {
                                FooterInfos("Centres d'intérêt", interests)
                                Spacer(Modifier.height(8.dp))
                                FooterInfos("Langues", languages)
                                Spacer(Modifier.height(8.dp))
                                FooterInfos("Atouts", strengths)
                            }
                        } else {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                FooterInfos("Centres d'intérêt", interests)
                                FooterInfos("Langues", languages)
                                FooterInfos("Atouts", strengths)
                            }
                        }
                    }
                }
            }
        }
    }
}
