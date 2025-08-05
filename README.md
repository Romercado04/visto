🎬 visto – "Lo viste. Lo recordás."
Aplicación móvil desarrollada para practicar e implementar servicios de Firebase, con arquitectura modular usando Koin, red con Ktor, y UI declarativa con Jetpack Compose.
Permite registrar películas y series vistas, calificarlas, subir imágenes de portada, marcarlas como favoritas, y mucho más.
________________________________________
✅ Requisitos
•	Android Studio Giraffe o superior
•	Java 17
•	Kotlin 2.0+
•	Conexión a Internet
•	Git instalado
•	Emulador o dispositivo físico (API 24+)
•	Proyecto de Firebase configurado
________________________________________
📥 Clonar el repositorio
bash
CopiarEditar
git clone https://github.com/TU_USUARIO/cinelog-app.git
cd cinelog-app
________________________________________
🗂️ Estructura general del proyecto
scss
CopiarEditar
📁 core         → lógica común (modelos, Firebase, utils, red)
📁 features     → módulos por funcionalidad (auth, catalog, profile, etc.)
📁 di           → inyección de dependencias con Koin
________________________________________
🔥 Configuración de Firebase
1.	Crear un proyecto en Firebase Console
2.	Agregar una app Android al proyecto
3.	Descargar google-services.json y colocarlo en:
📁 app/google-services.json
4.	Activar estos servicios:
o	✅ Authentication (Email/Password o Google)
o	✅ Firestore Database
o	✅ Firebase Storage
o	✅ Firebase Cloud Messaging (FCM)
o	✅ Firebase Analytics
________________________________________
🛠 Configuración en build.gradle
build.gradle (project):
kotlin
CopiarEditar
classpath("com.google.gms:google-services:4.4.1")
build.gradle (app):
kotlin
CopiarEditar
plugins {
    id("com.google.gms.google-services")
}

dependencies {
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-storage-ktx")
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")
}
________________________________________
▶️ Ejecutar la app
1.	Abrí el proyecto en Android Studio
2.	Sincronizá las dependencias (Gradle sync)
3.	Seleccioná un emulador o dispositivo físico
4.	Hacé clic en ▶️ para compilar y ejecutar
________________________________________
🐛 Problemas comunes
•	No conecta con Firebase: Verificá google-services.json y que los servicios estén activos
•	No carga la imagen: Revisar permisos y reglas de Firebase Storage
•	Notificaciones no llegan: Comprobar que FCM esté bien configurado
________________________________________
📦 Generar APK
bash
CopiarEditar
./gradlew assembleDebug
APK generado en:
app/build/outputs/apk/debug/app-debug.apk
________________________________________
🧰 Stack de tecnologías y librerías
Categoría	Herramienta / Librería
Lenguaje	Kotlin
UI	Jetpack Compose
Arquitectura	Clean Architecture modular
Inyección de dependencias	Koin
Manejo de estados	Kotlin Flow / StateFlow
Backend	Firebase (Auth, Firestore, Storage)
Notificaciones	Firebase Cloud Messaging (FCM)
Estadísticas	Firebase Analytics
Persistencia local	DataStore (opcional)

