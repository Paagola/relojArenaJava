# ⏳ Reloj de Arena Animado

Simulación visual de un reloj de arena en la terminal con animación en tiempo real del flujo de arena.

## 📋 Descripción

Aplicación Java que muestra un reloj de arena ASCII animado en la consola. La arena cae gradualmente desde la parte superior hacia la inferior con colores diferenciados y animación fluida.

## ✨ Características

- Animación en tiempo real del flujo de arena
- Altura configurable del reloj (valores impares)
- Velocidad de animación ajustable
- Colores diferenciados: púrpura (arena superior) y verde (arena inferior)
- Compatible con Windows, Linux y macOS
- Limpieza automática de pantalla entre frames

## 🚀 Requisitos

- Java 8 o superior
- Terminal con soporte para códigos ANSI (colores)

## 💻 Uso

```bash
javac reloj_movimiento.java
java reloj_movimiento
```

Al ejecutar, el programa solicitará:

1. **Altura del reloj**: Número impar (ej: 15, 21, 25)
2. **Velocidad de animación**: Milisegundos entre frames
   - Normal: 500-100 ms
   - Rápida: 99-10 ms

## 📊 Ejemplo

```
Introduzca la altura del reloj de arena (impar): 15
Milisegundos de recarga (normal: 500-100 | epilepsia: 99-10): 200
```

## ⚙️ Funcionamiento

El programa simula la física de un reloj de arena:
- La arena púrpura cae desde la parte superior
- Se acumula como arena verde en la parte inferior
- La animación continúa hasta que toda la arena ha caído
- Mensaje final: "RELOJ DE ARENA COMPLETADO!!!"

## 🎨 Personalización

Puedes modificar los colores editando las constantes:
- `GREEN`: Color de la arena inferior
- `PURPLE`: Color de la arena superior
- `RESET`: Reseteo de color

## ⚠️ Notas

- Usar valores impares para la altura para mejor visualización
- Velocidades muy rápidas pueden causar parpadeo
- La terminal debe soportar códigos de escape ANSI para visualizar colores

---

**Autor**: Proyecto educativo de simulación en consola  
**Licencia**: Uso libre para fines educativos
