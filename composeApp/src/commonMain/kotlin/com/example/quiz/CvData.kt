package com.example.quiz

data class HeaderData(val name: String, val subtitle: String)

val header = HeaderData(
    name = "Pépin Maëlic",
    subtitle = "Alternant en développement web"
)

data class SkillCategory(
    val title: String,
    val items: List<String>
)

val skillsList = listOf(
    SkillCategory("Intégration Web", listOf("HTML/CSS/JS")),
    SkillCategory("Framework Front", listOf("Angular", "React", "VueJS")),
    SkillCategory("Framework Back", listOf("Symfony", "NodeJs / Express")),
    SkillCategory("Bases de données", listOf("SQL / MariaDb", "MongoDb")),
    SkillCategory("Gestion de Projet", listOf("Git", "GitHub", "GitLab"))
)

data class Experience(
    val title: String,
    val description: String
)

val experiencesList = listOf(
    Experience(
        "2024-2026 — Alternance développeur web fullstack à l'UPHF",
        "J'assure le développement, le déploiement, l’intégration et la maintenance d’applications informatiques dans le respect des normes et standards en vigueur.\nJe travaille avec une équipe d’ingénieurs en place."
    ),
    Experience(
        "2023 - Aujourd’hui — Freelance développeur web",
        "J'ai réalisé des sites vitrines pour plusieurs entreprises."
    ),
    Experience(
        "2022-2023 — Alternance développeur fullstack chez Ainoudo",
        "Je suis en charge du développement front-end des applications web de dataScience."
    ),
    Experience(
        "2022 — Stage Développeur Front chez RCE",
        "Refonte de la partie front office d’une application web de contrôle d’accès en accord avec la charge graphique du produit"
    )
)

data class Formation(
    val title: String
)

val formationsList = listOf(
    Formation("2024-2026 — Master ingénierie du web - ESGI"),
    Formation("2022-2023 — Formation Développeur web - Openclassrooms"),
    Formation("2018-2022 — Licence Informatique - UPHF")
)

val descriptionText = listOf(
    "Diplômé d'un Master en Ingénierie du web, fort d'une expérience de 3 ans en développement web, je suis à la recherche d'un avenir dans le développement web.",
    "Passionné par l'informatique et le design, j'aimerais mettre à profit mon expérience dans les technologies du développement web telles que React.js, HTML, CSS et JavaScript pour créer des interfaces utilisateur modernes, intuitives et responsive."
)


val interests = listOf("Jeux Vidéos", "Desgin", "Lecture", "Volley ball niveau National")
val languages = listOf("Anglais Niveau B2", "Espagnol Niveau Lycée")
val strengths = listOf("Déterminé", "Curieux", "Motivé", "Patient")
