# PaLaAsada — tienda en línea

Backend y sitio web de una tienda en línea de productos cárnicos. El proyecto busca que los clientes puedan consultar productos y que el negocio tenga herramientas para administrar el catálogo y la información relacionada con pedidos, inventario y entregas.

Este README está escrito como guía de incorporación para el equipo. También distingue las funciones que ya están representadas en el código de las que todavía necesitan completarse.

## Contenido

- [PaLaAsada — tienda en línea](#palaasada--tienda-en-línea)
  - [Contenido](#contenido)
  - [Qué incluye el proyecto](#qué-incluye-el-proyecto)
  - [Estado y alcance actual](#estado-y-alcance-actual)
    - [Implementado en el código](#implementado-en-el-código)
    - [Pendiente o no debe asumirse como terminado](#pendiente-o-no-debe-asumirse-como-terminado)
  - [Tecnologías](#tecnologías)
  - [Cómo está organizado](#cómo-está-organizado)
  - [Requisitos previos](#requisitos-previos)
  - [Preparar la base de datos](#preparar-la-base-de-datos)
  - [Configurar y ejecutar](#configurar-y-ejecutar)
    - [Windows PowerShell](#windows-powershell)
    - [Linux o macOS](#linux-o-macos)
  - [Probar el proyecto](#probar-el-proyecto)
  - [Cómo se organiza el backend](#cómo-se-organiza-el-backend)
  - [API disponible](#api-disponible)
    - [Ejemplos de autenticación](#ejemplos-de-autenticación)
  - [Autenticación y permisos](#autenticación-y-permisos)
  - [Modelo de datos, explicado](#modelo-de-datos-explicado)
  - [Documentación adicional](#documentación-adicional)
  - [Guía rápida para colaborar (solo colaboradores autorizados)](#guía-rápida-para-colaborar-solo-colaboradores-autorizados)
  - [Glosario](#glosario)

## Qué incluye el proyecto

El repositorio contiene dos partes que se ejecutan juntas:

1. **Backend/API:** una aplicación Java con Spring Boot. Expone rutas HTTP para consultar y administrar información y se conecta a MySQL.
2. **Sitio web:** páginas, estilos, scripts e imágenes guardados en `src/main/resources/static`. Spring Boot puede servir esos archivos desde la misma aplicación; por ejemplo, la página inicial se abre en `/`.

La API tiene rutas para usuarios y acceso, productos, categorías, tags, carritos, pedidos, precios, inventario, pagos, direcciones y entregas.

## Estado y alcance actual

Es importante diferenciar entre la idea del producto y lo que el backend implementa actualmente:

### Implementado en el código

- Catálogo de productos con lectura pública.
- Administración CRUD (crear, consultar, actualizar y eliminar) para varios recursos.
- Registro público de clientes y acceso con correo y contraseña.
- Contraseñas guardadas con BCrypt.
- Emisión y validación de tokens JWT para identificar usuarios y roles.
- Persistencia con Spring Data JPA y MySQL.
- Sitio web estático incluido en la aplicación.
- Modelos para pedidos, detalles de pedido, pagos, entregas, inventario, direcciones, precios, imágenes y otros datos de catálogo.

### Pendiente o no debe asumirse como terminado

- El proyecto **no integra una pasarela de pago**. El recurso de pagos permite manejar registros; no procesa tarjetas ni transferencias.
- Hay modelos y rutas para pedidos, carritos, pagos y entregas, pero eso **no significa que exista un checkout completo** que valide disponibilidad, calcule totales, cobre y coordine la entrega de principio a fin.
- La configuración actual requiere rol `ADMIN` para los endpoints que no están explícitamente marcados como públicos. Por lo tanto, las rutas de carrito y pedidos no están habilitadas para el flujo normal de un cliente autenticado.
- No se encontró una implementación de suscripciones/pedidos recurrentes ni de notificaciones por correo, SMS o push.
- La ruta `/admin/` sirve archivos del panel; el HTML público no significa que todas las acciones del panel funcionen sin autenticación. La API sí aplica permisos.
- La conexión de producción, el correo de acceso, el pago, los despliegues y otros detalles operativos deben configurarse y validarse antes de ofrecer el sistema a clientes reales.

Las funciones de negocio previstas se describen en los documentos de `src/main/resources/static/docs`; son referencia funcional y no necesariamente una prueba de que cada flujo ya esté programado.

## Tecnologías

| Parte | Tecnología |
|---|---|
| Lenguaje | Java 17 |
| Framework | Spring Boot 4.1.1 |
| Construcción y dependencias | Gradle, con Gradle Wrapper incluido |
| API web | Spring MVC |
| Persistencia | Spring Data JPA / Hibernate |
| Base de datos | MySQL |
| Seguridad | Spring Security, BCrypt y JWT (JJWT) |
| Pruebas | JUnit Platform y dependencias de pruebas de Spring |
| Interfaz incluida | HTML, CSS, JavaScript y recursos estáticos |

Las versiones y dependencias del backend están declaradas en `build.gradle`.

## Cómo está organizado

```text
.
├── build.gradle
├── gradlew
├── gradlew.bat
├── src/
│   ├── main/
│   │   ├── java/org/palaasada/backend/
│   │   │   ├── config/       # Configuración de Spring Security y CORS
│   │   │   ├── controller/   # Rutas HTTP de la API
│   │   │   ├── exception/    # Excepciones propias
│   │   │   ├── model/        # Entidades JPA y objetos de entrada
│   │   │   ├── repository/   # Consultas y acceso a MySQL
│   │   │   ├── security/     # Filtro JWT y servicio de tokens
│   │   │   └── service/      # Lógica de aplicación
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/       # Sitio web, imágenes, datos y documentos
│   └── test/                 # Pruebas automatizadas
└── gradle/wrapper/           # Versión de Gradle usada por el wrapper
```

`build/`, `bin/` y `.gradle/` son carpetas generadas al compilar o ejecutar el proyecto. Normalmente no se editan a mano.

## Requisitos previos

- Java Development Kit (JDK) 17.
- MySQL accesible desde el equipo.
- Git para clonar y compartir cambios.

No hace falta instalar Gradle globalmente: el repositorio incluye `gradlew` para Linux/macOS y `gradlew.bat` para Windows.

## Preparar la base de datos

1. Inicia MySQL y crea una base de datos vacía, por ejemplo `palaasada`.
2. Si el equipo necesita cargar la estructura o datos iniciales, revisa los scripts SQL bajo:

   `src/main/resources/static/docs/Database_Doc/`

   Hay más de una versión de documentación y scripts; confirma con el equipo cuál corresponde a la versión de código que estás ejecutando antes de importar uno.
3. Configura las variables de conexión descritas en la sección siguiente.

La aplicación configura Hibernate con `PROD_DDL` y, si no se indica otra cosa, usa `update`. En desarrollo esto puede ayudar a mantener el esquema alineado con las entidades, pero **no sustituye un respaldo ni una estrategia de migraciones** y no es una configuración recomendada sin revisión para producción.

## Configurar y ejecutar

### Windows PowerShell

Desde la carpeta raíz del repositorio, configura los datos de tu base local en la terminal actual. Sustituye los valores de ejemplo; no guardes contraseñas reales en el código ni en Git:

```powershell
$env:DB_URL = "jdbc:mysql://localhost:3306/palaasada?sslMode=DISABLED"
$env:DB_USER = "tu_usuario_mysql"
$env:DB_PASSWORD = "tu_contraseña_mysql"
.\gradlew.bat bootRun
```

### Linux o macOS

```bash
export DB_URL="jdbc:mysql://localhost:3306/palaasada?sslMode=DISABLED"
export DB_USER="tu_usuario_mysql"
export DB_PASSWORD="tu_contraseña_mysql"
./gradlew bootRun
```

`DB_URL` debe ser una URL JDBC completa. Para conexiones administradas o de producción, usa la URL y las opciones TLS que indique el proveedor de MySQL; el ejemplo local desactiva SSL y **no se debe copiar como configuración de producción**.

También se puede configurar la conexión mediante las variables `PROD_DB_HOST`, `PROD_DB_NAME`, `PROD_DB_USERNAME` y `PROD_DB_PASSWORD`, que permiten formar la URL de conexión alternativa. Si se establece `DB_URL`, ese valor tiene prioridad. No publiques valores de conexión en issues, capturas ni archivos versionados.

Cuando Gradle termine de iniciar, la aplicación queda disponible normalmente en:

- Sitio: `http://localhost:8080/`
- Panel estático: `http://localhost:8080/admin/`
- API: `http://localhost:8080/<recurso>`

No hay un prefijo general `/api` definido en los controladores actuales. Si la base de datos no está disponible o faltan variables de conexión, la aplicación puede fallar durante el inicio.

## Probar el proyecto

En Windows:

```powershell
.\gradlew.bat test
.\gradlew.bat build
```

En Linux/macOS:

```bash
./gradlew test
./gradlew build
```

`test` ejecuta las pruebas automatizadas y `build` compila, prueba y empaqueta la aplicación. Si una prueba necesita MySQL, asegúrate de que la base esté configurada y disponible. Agrega pruebas junto con nuevas reglas de negocio, especialmente para permisos, datos inválidos y operaciones que cambian varios registros.

## Cómo se organiza el backend

Una petición atraviesa varias capas:

1. **Controller:** recibe la petición HTTP y define la ruta, el método y el formato de entrada/salida.
2. **Service:** aplica las reglas de la aplicación. Por ejemplo, `ProductoService` también administra las categorías y tags asociados al producto.
3. **Repository:** usa Spring Data JPA para leer o guardar entidades en la base.
4. **Model:** representa entidades y objetos de datos. Las clases anotadas con `@Entity` se relacionan con tablas.

Ejemplo sencillo: `GET /productos` llega a `ProductoController`, que llama a `ProductoService`; el servicio obtiene los productos mediante `ProductoRepository` y la respuesta se serializa como JSON.

## API disponible

Todas las rutas usan JSON cuando reciben o devuelven datos, salvo respuestas simples de texto. Los identificadores se escriben como parte de la URL, por ejemplo `/productos/corte-01`.

| Recurso | Rutas | Uso |
|---|---|---|
| Autenticación | `POST /auth/register`, `POST /auth/login` | Crear una cuenta cliente e iniciar sesión |
| Productos | `GET /productos`, `GET /productos/{id}` | Consultar el catálogo; son rutas públicas |
| Productos | `POST /productos`, `PUT /productos/{id}`, `DELETE /productos/{id}` | Administración de productos |
| Categorías | `GET /categorias`, `GET /categorias/{id}`, `POST /categorias`, `PUT /categorias/{id}`, `DELETE /categorias/{id}` | Consultar y administrar categorías |
| Tags | `GET /tags`, `GET /tags/{id}`, `POST /tags`, `PUT /tags/{id}`, `DELETE /tags/{id}` | Consultar y administrar etiquetas |
| Carritos | `GET /carritos`, `GET /carritos/{id}`, `POST /carritos`, `PUT /carritos/{id}`, `DELETE /carritos/{id}` | Administrar registros de carrito |
| Pedidos | `GET /pedidos`, `GET /pedidos/{id}`, `POST /pedidos`, `PUT /pedidos/{id}`, `DELETE /pedidos/{id}` | Administrar pedidos |
| Direcciones | `GET /direcciones`, `GET /direcciones/{id}`, `POST /direcciones`, `PUT /direcciones/{id}`, `DELETE /direcciones/{id}` | Administrar direcciones |
| Entregas | `GET /entregas`, `GET /entregas/{id}`, `POST /entregas`, `PUT /entregas/{id}`, `DELETE /entregas/{id}` | Administrar entregas |
| Inventario | `GET /inventarios`, `GET /inventarios/{id}`, `POST /inventarios`, `PUT /inventarios/{id}`, `DELETE /inventarios/{id}` | Administrar registros de inventario |
| Pagos | `GET /pagos`, `GET /pagos/{id}`, `POST /pagos`, `PUT /pagos/{id}`, `DELETE /pagos/{id}` | Administrar registros de pago |
| Precios | `GET /precios`, `GET /precios/{id}`, `POST /precios`, `PUT /precios/{id}`, `DELETE /precios/{id}` | Administrar precios |
| Usuarios | `GET /usuarios`, `GET /usuarios/{id}`, `POST /usuarios`, `PUT /usuarios/{id}`, `DELETE /usuarios/{id}` | Administración de usuarios |

Las rutas CRUD reciben el modelo correspondiente como JSON. La implementación puede devolver `200 OK` para crear y actualizar, `404 Not Found` cuando no existe un recurso consultado y `204 No Content` al eliminar. Hay comportamientos particulares por recurso; por ejemplo, eliminar un producto que aparece en pedidos responde `409 Conflict`.

### Ejemplos de autenticación

Registro:

```http
POST /auth/register
Content-Type: application/json
```

```json
{
  "nombre": "Alex Json",
  "correo": "alex.j@example.com",
  "telefono": "5551234567",
  "password": "ejemplo123"
}
```

El registro público asigna el rol `CLIENTE` y, si tiene éxito, devuelve una respuesta equivalente a iniciar sesión con un token. La contraseña se guarda codificada con BCrypt, no como texto legible.

Inicio de sesión:

```http
POST /auth/login
Content-Type: application/json
```

```json
{
  "correo": "alex.j@example.com",
  "password": "ejemplo123"
}
```

La respuesta incluye el token JWT y datos básicos del usuario. En las rutas protegidas, el token se envía así:

```http
Authorization: Bearer <token>
```

No uses las contraseñas de ejemplo para cuentas reales ni compartas tokens: quien tiene un token válido puede actuar con los permisos asociados hasta que expire.

## Autenticación y permisos

- `POST /auth/**` es público.
- `GET /productos/**`, `GET /categorias/**` y `GET /tags/**` son públicos.
- Las páginas estáticas y los archivos del sitio (incluido `/admin/**`) pueden consultarse sin iniciar sesión.
- Las demás peticiones requieren un usuario con rol `ADMIN`, según la configuración de Spring Security.
- El login genera un token JWT con vencimiento aproximado de una hora.
- CORS permite orígenes locales (`localhost` y `127.0.0.1` con cualquier puerto), útil durante el desarrollo del frontend.

 

## Modelo de datos, explicado

Las entidades JPA principales representan conceptos del negocio:

- **Producto:** identificador, SKU, nombre, descripción, precio, inventario, imagen, información adicional y categoría principal. También puede traer listas de nombres de categorías y tags.
- **Precio:** monto, moneda y textos descriptivos.
- **Inventario:** identificador, estado y cantidad.
- **Categoría y Tag:** ayudan a ordenar y describir productos. Un producto puede tener más de una categoría o etiqueta.
- **Usuario y Rol:** identifican a la persona registrada y el nivel de acceso.
- **Carrito y CarritoProducto:** representan el carrito y los productos que contiene.
- **Pedido y DetallePedido:** representan una compra y sus renglones.
- **Pago:** datos y estado asociados a un pago.
- **Dirección y Entrega:** información de destino y seguimiento de entrega.
- **HistorialPrecio e HistorialInventario:** guardan cambios relacionados con precios e inventario.

Varias entidades usan relaciones JPA como `@ManyToOne`. Esto significa, por ejemplo, que varios productos pueden referirse a una misma categoría o registro relacionado. Las clases de `model/` son la mejor referencia para conocer los nombres y tipos exactos de los campos que acepta cada endpoint.

Los estados del pedido definidos en el código son `pendiente`, `confirmado`, `en_proceso`, `enviado`, `entregado` y `cancelado`.

## Documentación adicional

El sitio incluye documentos funcionales y técnicos bajo `src/main/resources/static/docs/`, entre ellos:

- Reglas comerciales y operación.
- Catálogo de productos y proceso de compra del cliente.
- Pedidos y entregas.
- Aviso de privacidad y términos y condiciones.
- Diagramas, documentación y scripts SQL de la base de datos.

Parte de esa documentación describe objetivos y decisiones de diseño. Ante diferencias, consulta el código para confirmar el comportamiento actual.

## Guía rápida para colaborar (solo colaboradores autorizados)

1. Actualiza tu rama antes de comenzar y revisa qué archivos cambiará tu tarea.
2. Mantén los cambios pequeños y enfocados; evita editar carpetas generadas como `build/` y `bin/`.
3. Para una nueva ruta, sigue el flujo existente: controller → service → repository → model.
4. Si cambias un modelo o una regla de negocio, revisa el impacto en sus servicios, rutas y scripts/documentación de base de datos.
5. No guardes credenciales, tokens ni datos personales reales en el repositorio.
6. Ejecuta `.\gradlew.bat test` antes de compartir cambios en Windows, o `./gradlew test` en Linux/macOS.
7. Describe en el cambio qué se modificó, cómo probarlo y cualquier limitación que siga pendiente.
8. Como el trabajo se distribuyó entre varias personas, es normal que algunas áreas tengan distinto nivel de detalle. Antes de extender una funcionalidad, revisa la implementación actual y acuerda con el equipo la regla de negocio que debe prevalecer.

## Glosario

| Término | Explicación sencilla |
|---|---|
| API | Conjunto de rutas que permite que el sitio web y otros clientes pidan o cambien datos del backend. |
| Endpoint o ruta | Dirección y método HTTP de una operación, como `GET /productos`. |
| CRUD | Crear, leer/consultar, actualizar y eliminar información. |
| JSON | Formato de texto usado para intercambiar datos entre el navegador y la API. |
| JPA | Herramienta que permite relacionar clases Java con tablas de la base de datos. |
| Repository | Componente que consulta y guarda información en la base de datos. |
| Service | Componente donde se agrupa la lógica de una operación. |
| JWT | Token firmado que identifica una sesión y se envía con las peticiones protegidas. |
| CORS | Regla del navegador que controla desde qué sitios puede llamarse a una API. |
| BCrypt | Algoritmo que transforma contraseñas en valores difíciles de recuperar; se compara la contraseña ingresada sin guardar la original. |
