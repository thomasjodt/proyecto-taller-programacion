# Proyecto Final de Taller de Programación
## Grupo 1
### Integrantes:

- Javier Orlando Díaz Torrealva
- Juan Arce Morales
- Integrante 3
- Integrante 4
- Integrante 5
---
## Introducción

En este proyecto final de Taller de Programación, nuestro equipo se ha enfocado en desarrollar una aplicación que permita a una empresa de hotelería gestionar sus habitaciones, reservas y clientes de manera eficiente y sencilla. Nuestra aplicación está diseñada para ser accesible y fácil de usar, lo que la convierte en una herramienta valiosa para aquellos que desean llevar un control preciso de su hotel.

---
## Especificaciones

- Gestión de habitaciones: Crear, actualizar y eliminar habitaciones.
- Gestión de reservas: Crear, actualizar y eliminar reservas.
- Gestión de clientes: Crear, actualizar y eliminar clientes.
- Reportes: Generar reportes de ingresos y gastos.
- Seguridad: Implementar medidas de seguridad para proteger la información de los clientes.
- Escalabilidad: Diseñar la aplicación para que pueda manejar un número creciente de habitaciones y reservas.
- Interfaz de usuario: Diseñar una interfaz de usuario intuitiva y fácil de usar.

## 1. Arquitectura y Patrón de Diseño
La aplicación utiliza una versión simplificada del patrón **MVC** (Modelo/Vista/controlador), separando estrictamente la representación de los datos, la lógica del negocio y la interacción con el usuario. Esto evita el acoplamiento de código y facilita el mantenimiento.

**Capas del Sistema:**
1. **Capa de Modelo(`model`):** Contiene las clases que representan las entidades del mundo real y sus reglas de negocio internas.
2. **Capa de Servicio (`service`):** Centraliza la lógica operativa del hotel, coordinando las búsquedas, registros y cálculos sobre las colecciones de datos.
3. **Capa de Vista (`view`):** Maneja exclusivamente la entrada y salida de datos por consola (`Scanner` y `System.out`). No conoce cómo se procesan internamente los datos.

## 2. Estructura de Archivos y Paquetes
A nivel de directorio en el entorno de desarrollo, el proyecto se organiza de la siguiente manera dentro de la carpeta raíz de código fuente (`src`):
```text
src/
└─ com/
   └─ hotel/
      ├─ model/
      │  ├─ Cliente.java
      │  ├─ Habitacion.java           (Clase abstracta)
      │  ├─ HabitacionEstandar.java   (Hereda de habitación)
      │  ├─ Suite.java                (Hereda de habitación)
      │  └─ Reserva.java
      ├─ service/
      │  └─ HotelService.java         (Lógica de negocio)
      ├─ utils/
      │  ├─ ConsoleCleaner.java
      │  ├─ ConsoleWriter.java
      │  └─ Prompt.java
      ├─ view/
      │    └─ MenuPrincipal.java      (Menú principal de la aplicación)
      └─ Main.java                    (Punto de entrada principal)
```

## 3. Diseño de Clases y Relaciones de POO

**Capa de Modelo (`com.hotel.model`)**

- `Cliente`
  - Propósito: Almacenar la información del huésped.
  - Atributos: Identificación, nombre completo, correo electrónico.
  - Concepto POO: **Encapsulamiento** mediante atributos privados métodos de acceso públicos (getters y setters).
  

- `Habitación` **(Clase abstracta)**
  - Propósito: Servir de plantilla base para cualquier tipo de habitación del hotel.
  - Atributos: Número de habitación, precio base por noche, estado de disponibilidad (booleano).
  - Métodos: Definición de firmas estándar y un método abstracto para el cálculo del precio.
  - Concepto POO: **Abstracción** pura al no permitir instancias directas de esta clase.


- `HabitacionEstandar` y `Suite` **(Clases hijas)**
  - Propósito: Especializar los tipos de habitaciones disponibles.
  - Atributos específicos (`suite`): Cargo fijo por servicios VIP, atributos de comodidades extra (ej.: Jacuzzi).
  - Concepto POO: **Herencia** para reutilizar los atributos de `Habitacion` y **Polimorfismo** al implementar de forma distinta el método de cálculo de precio total según sus propias reglas.


- `Reserva`
  - Propósito: Registrar la transacción de alquiler de una habitación por parte de un cliente.
  - Atributos: Código único de reserva, cliente asignado, habitación asignada, cantidad de noches, costo total calculado.
  - Concepto POO: **Composición** y **Asociación**, ya que una reserva tiene un Cliente y tiene una Habitación. Al crearse, invoca el método polimórfico de la habitación para fijar su costo final.

**Capa de Servicio (`com.hotel.servie`)**

- `HotelService`
  - Propósito: Funcionar como el núcleo operativo y almacén en memoria del sistema.
  - Atributos: Un `ArrayList` de habitaciones y un `ArrayList` de reservas.
  - Responsabilidades: 
    - Registrar nuevas habitaciones (poblar el sistema al inicio).
    - Filtrar y retornar colecciones de habitaciones cuyo estado de disponibilidad sea verdadero.
    - Vincular un cliente y una habitación libre para generar un objeto `Reserva`.
    - Cambiar los estados de disponibilidad de las habitaciones durante los procesos de _check-in_ y _check-out_.
    - Calcular métricas globales (ganancias totales acumuladas).

**Capa de Vista (`com.hotel.view`)**

- `MenuPrincipal`
  - Propósito: Primera ventana de la aplicación, es la que se muestra al iniciar la aplicación.
  - Responsabilidades: 
    - Inicializar una instancia única de `HotelService`.
    - Ejecutar un bucle de control (`while`) con opciones numéricas en pantalla (`switch`).
    - Capturar datos del teclado e invocar inmediatamente las funciones de la capa de servicio.
    - Mostrar mensajes de éxito o error al usuario según las respuestas de la lógica del negocio.

## 4. Flujo de Trabajo Operativo

1. **Inicialización:** El sistema arranca, `MenuPrincipal` se ejecuta, instancia a `HotelService` y este crea automáticamente en su constructor un listado predefinido de habitaciones estándar y suites disponibles en memoria.
2. **Consulta:** El usuario solicita ver habitaciones disponibles; la vista le pide los datos al servicio y este filtra su `ArrayList` para devolver solo los objetos libres.
3. **Reservación:** El usuario elige una habitación y digita sus datos. La vista envía la información al servicio, este busca la habitación por número, cambia su estado  a ocupada (`false`), calcula el costo polimórficamente y añade el nuevo objeto `Reserva` a su lista interna.
4. **Liberación:** Al realizar el _check-out_, el servicio localiza la habitaciaón por su número y restablece su disponibilidad a libre (`true`).