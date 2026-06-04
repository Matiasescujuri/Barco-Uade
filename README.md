# Barco-Uade
# 🚢 Barco UADE - Juego de Submarino

Proyecto desarrollado en Java aplicando conceptos de Programación Orientada a Objetos (POO).

## 📋 Descripción

El jugador controla un submarino que debe sobrevivir a los ataques de barcos enemigos.

Los barcos enemigos navegan en la superficie y lanzan cargas de profundidad que explotan a distintas profundidades. Dependiendo de la distancia entre la explosión y el submarino, este recibirá distintos niveles de daño.

El objetivo es sobrevivir, acumular puntos y avanzar de nivel.

---

## 🎮 Mecánicas del Juego

### Submarino

El submarino puede:

- Moverse hacia la izquierda.
- Moverse hacia la derecha.
- Subir profundidad.
- Bajar profundidad.

Restricciones:

- Profundidad mínima: 300 metros.
- Profundidad máxima: 800 metros.

---

### Barcos Enemigos

Los barcos enemigos:

- Se generan automáticamente.
- Poseen dirección aleatoria.
- Se desplazan horizontalmente.
- Lanzan cargas de profundidad.
- Puede haber hasta 3 barcos activos simultáneamente.

Cada nivel contiene una serie de 12 barcos enemigos.

---

### Cargas de Profundidad

Cada barco posee su propia carga de profundidad.

Las cargas:

- Caen desde la superficie.
- Explotan a una profundidad aleatoria.
- Calculan la distancia respecto al submarino.
- Generan daño según la cercanía de la explosión.

---

### Sistema de Daño

| Distancia | Resultado |
|------------|------------|
| Mayor a 100 | +30 puntos |
| Entre 50 y 100 | +10 puntos y 30% de daño |
| Entre 10 y 49 | 50% de daño |
| Menor a 10 | Pérdida de una vida |

---

### Sistema de Puntos

- Explosión lejana: +30 puntos.
- Explosión media: +10 puntos.
- Cada 500 puntos se obtiene una vida extra.
- Al superar un nivel se otorgan 200 puntos adicionales.

---

### Sistema de Niveles

Al destruir los 12 barcos de un nivel:

- Se incrementa el nivel.
- Aumenta la velocidad de los barcos.
- Aumenta la velocidad de las cargas.
- Se inicia una nueva serie de barcos enemigos.

---

## 🏗️ Arquitectura

El proyecto fue desarrollado siguiendo una estructura basada en POO.

### Clases principales

### Juego

Controla toda la lógica principal:

- Inicio del juego.
- Actualización de estados.
- Generación de barcos.
- Procesamiento de explosiones.
- Control de niveles.
- Control de puntaje.
- Fin del juego.

### Submarino

Representa al jugador:

- Movimiento.
- Profundidad.
- Vida.
- Vidas restantes.

### BarcoEnemigo

Representa los barcos enemigos:

- Movimiento.
- Dirección.
- Lanzamiento de cargas.

### CargaProfundidad

Representa las cargas lanzadas por los barcos:

- Caída.
- Explosión.
- Cálculo de distancia.

### Nivel

Controla el nivel actual del juego.

### ControladorJuego

Intermedia entre la interfaz y la lógica del juego.

### VentanaJuego

Interfaz gráfica desarrollada con Java Swing.

### TestControladorJuego

Permite probar el funcionamiento del sistema sin interfaz gráfica.

---

## 🛠️ Tecnologías Utilizadas

- Java
- Maven
- Java Swing
- IntelliJ IDEA

---

## ▶️ Ejecución

### Desde IntelliJ IDEA

Ejecutar:

```java
Main.java
```

### Desde Maven

```bash
mvn clean compile
mvn exec:java
```

---

## 👨‍💻 Autor

Matías Escujuri

Proyecto realizado para la materia Programación Orientada a Objetos - UADE.
