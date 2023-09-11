# AnimeApp

FARMATODO - ANIME

**DESCRIPCIÓN:**

Esta aplicación móvil es el resultado de una prueba técnica que permite explorar y descubrir los animes más populares y los animes con las temporadas más recientes. Utiliza la arquitectura limpia (Clean Architecture) con el patrón de arquitectura MVVM en combinación Lifedata y Dagger Hilt para la inyección de dependencias buscando garantizar una organización sólida del código y una separación de preocupaciones. Los llamados a la API se realizan a través de Retrofit y Coroutines para garantizar una experiencia de usuario fluida y eficiente.

**CARACTERÍSTICAS PRINCIPALES:**

- Listado de animes populares filtrados por popularidad.
- Listado de animes con las temporadas más recientes.
- Pantalla de búsqueda para encontrar tus animes favoritos.
- Detalles de anime con información completa al presionar la imagen del anime en cualquier pantalla.

**ARQUITECTURA Y PATRONES**

La aplicación sigue los siguientes principios y patrones de arquitectura:

- Clean Architecture: La arquitectura está dividida en capas: Presentación, Dominio e Infraestructura, para garantizar una separación clara de las responsabilidades y facilitar el mantenimiento y las pruebas.

- MVVM (Model-View-ViewModel): Se utiliza el patrón MVVM para organizar la lógica de la interfaz de usuario y las operaciones de la vista de manera eficiente.

**TECNOLOGÍAS UTILIZADAS:**

- Retrofit: Se utiliza Retrofit para realizar llamadas a la API de animes de forma sencilla y eficiente.

- Coroutines:Empleadas para gestionar tareas asincrónicas de manera concisa y legible.

- Glide: Para la carga eficiente de imágenes y su visualización en la aplicación.

- LiveData: Para mantener los datos actualizados en la interfaz de usuario de forma reactiva.

- Dagger Hilt: Para la inyección de dependencias y garantizar una gestión eficiente de las mismas.



**INSTALACIÓN:**

1. Clona el repositorio en tu máquina local.
2. Abre el proyecto en Android Studio.
3. Sincroniza las dependencias.
4. Ejecuta la aplicación en un emulador o dispositivo Android.
