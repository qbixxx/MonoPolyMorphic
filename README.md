# MonoPolyMorphic

**MonoPolyMorphic** is a fully-featured, object-oriented implementation of the classic **Monopoly®** board game.  
It is written in **Java 21** and uses **JavaFX 15** for its graphical user interface. The codebase follows an MVC-inspired structure (`model`, `vista`, `controlador`) and ships as a single executable JAR produced by the Maven Shade plugin.

---

## Table of contents
1. [Features](#features)  
2. [Quick start](#quick-start)  
3. [Project layout](#project-layout)  
4. [Build & run details](#build--run-details)  
5. [Testing](#testing)  
6. [UML diagrams](#uml-diagrams)  
7. [Configuration](#configuration)  
8. [Contributing](#contributing)  
9. [License](#license)

---

## Features
| Category | Highlights |
|----------|------------|
| **Gameplay** | Complete Monopoly rule-set (properties, chance/multa/lotería, jail, hotel/house construction, bankruptcy). |
| **Architecture** | Clear separation between *Model* (game logic), *View* (JavaFX scenes), and *Controller* (event handlers). |
| **Configurable board** | `Configuracion.java` lets you tweak board layout, prices, fines, and rewards without touching core logic. |
| **Cross-platform GUI** | JavaFX fat-JAR bundled with platform-specific `javafx-graphics` classifiers for Linux, macOS and Windows. |
| **Logging** | Lightweight custom logger (`model/Logger.java`) for in-game events. |
| **Unit & integration tests** | JUnit 5 + Mockito; current suite covers model interactions end-to-end (`JuegoIntegracionTest`). |

---

## Quick start

```bash
# clone the project
git clone https://github.com/qbixxx/MonoPolyMorphic.git
cd MonoPolyMorphic

# build (creates a self-contained fat JAR)
mvn clean package

# run
java -jar target/MonopolyPersonal-1.0-SNAPSHOT.jar

[UML](https://github.com/qbixxx/Monopoly-morphic/files/15135817/exported_from_idea.drawio.pdf)
