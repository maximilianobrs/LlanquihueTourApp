# ☕ Evaluacion Final - Desarrollo Orientado a Objetos I

---------------------------------------------
## 👋 Autor del proyecto

- Nombre: Maximiliano Briones
- Seccion: Desarrollo Orientado a Objetos I
- Carrera: Analista programador computacional
- Sede: Campus Virtual DuocUC

------------------------------------------

## 📚 Descripción general del sistema

Este proyecto desarrolla un prototipo en Java para digitalizar la gestión de la agencia de turismo Llanquihue Tour. Mediante una interfaz gráfica (Java Swing), permite administrar clientes, guías, vehículos y tours, almacenando la información en archivos de texto. Además, aplica los principales conceptos de Programación Orientada a Objetos, como encapsulamiento, herencia, polimorfismo, interfaces y manejo de excepciones personalizadas.

## 🧩 Clases principales

| Clase | Qué hace |
|---|---|
| `Persona` | Datos base: nombre, rut, contacto. |
| `Personal` | Hereda de Persona, agrega el cargo. |
| `Cliente` | Datos de un cliente. |
| `GuiaTuristico` | Datos de un guía. |
| `Tour` | Un tour, con su guía, vehículo y clientes. |
| `Vehiculo` | Datos de un vehículo. |
| `Contacto` | Teléfono y correo de una persona. |
| `Registrable` | Define qué debe tener cada clase para poder registrarse. |
| `GestorEntidades` | Guarda todo, busca, filtra y lee/escribe los `.txt`. |
| `AppUtils` | Valida rut, correo, teléfono, etc. |
| `MiVentana` | La interfaz gráfica. |
| `Main` | Inicia el programa. |

---
## 📁 Estructura del proyecto

```bash
LlanquihueTourApp/
├── src/
│   ├── app/
│   │   └── Main.java
│   ├── data/
│   │   └── GestorEntidades.java
│   ├── exception/
│   │   ├── DatoEsInvalidoException.java
│   │   └── RutEsInvalidoException.java
│   ├── interfaces/
│   │   └── Registrable.java
│   ├── model/
│   │   ├── Cliente.java
│   │   ├── Contacto.java
│   │   ├── GuiaTuristico.java
│   │   ├── Persona.java
│   │   ├── Personal.java
│   │   ├── Tour.java
│   │   └── Vehiculo.java
│   ├── ui/
│   │   └── MiVentana.java
│   └── utils/
│       └── AppUtils.java
├── resources/
│   ├── clientes.txt
│   ├── guias.txt
│   ├── vehiculos.txt
│   └── tours.txt
├── .gitignore
└── README.md
```
--------------------------
## 🚀 Cómo ejecutar
1. Clonar o descargar el repositorio.
2. Abrir el proyecto en Intellij IDEA o cualquier IDE compatible con Java.
4. Ejecutar la clase `Main`.
5. Observar los resultados en la consola.
