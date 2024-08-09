# Instrucciones de Ejecución del Proyecto

Este documento proporciona una guía paso a paso para ejecutar las pruebas automatizadas en el proyecto Demoblaze utilizando Selenium y Cucumber.

## Requisitos Previos

1. **Eclipse IDE**:
   - Asegúrate de tener instalado y configurado Eclipse en tu máquina.
   - Este proyecto fue desarrollado y probado en Eclipse, por lo que se recomienda utilizar esta plataforma para garantizar la compatibilidad.

2. **Java Development Kit (JDK)**:
   - Es necesario tener instalado el JDK 8 o superior.
   - Puedes verificar tu versión de Java ejecutando `java -version` en la terminal.

3. **Gradle**:
   - Asegúrate de que el proyecto esté configurado con Gradle.
   - Si Gradle no está instalado, puedes descargarlo desde [https://gradle.org/install/](https://gradle.org/install/).

4. **WebDriver**:
   - Asegúrate de que `chromedriver` esté disponible en tu sistema.
   - El path configurado en el proyecto es `C:/WebDriver/chromedriver.exe`. Si usas otro navegador, ajusta el path y el driver en consecuencia.
   - La configuración del WebDriver se encuentra en `src/main/java/demoblaze/utils/BaseTest.java`, donde puedes cambiar el tipo de navegador según tus necesidades.
   
5. Configuración del Proyecto
   - Clona este repositorio en tu máquina local usando el siguiente comando:
     git clone https://github.com/eperez7666/SofkaSelenium.git
   - Abre Eclipse y selecciona 'Import > Gradle > Existing Gradle Project'.
   - Navega hasta el directorio clonado y selecciona 'Finish' para importar el proyecto.
6. **Dependencias del Proyecto**:
   - Antes de ejecutar las pruebas, asegúrate de que todas las dependencias del proyecto están correctamente instaladas.
   - Puedes instalar las dependencias ejecutando `gradle build` en la raíz del proyecto.

## Estructura del Proyecto

- **`src/main/java/demoblaze/pages/`**:
  - Contiene las clases que representan las páginas del sitio web:
    - `HomePage.java`: Lógica para la página principal de Demoblaze.
    - `CartPage.java`: Lógica para la página del carrito de compras.
    - `CheckoutPage.java`: Lógica para la página de checkout.
  
- **`src/main/java/demoblaze/utils/BaseTest.java`**:
  - Contiene métodos y configuraciones comunes utilizados en las pruebas, como la inicialización del WebDriver, métodos de interacción con la página y captura de pantallas.

- **`src/test/resources/demoblaze/features/compra.feature`**:
  - Archivo `.feature` que contiene los escenarios de prueba para el flujo de compra en Demoblaze.

- **`src/test/java/demoblaze/stepDefinitions/CompraSteps.java`**:
  - Contiene las definiciones de los pasos (`step definitions`) que implementan la lógica de los escenarios de prueba definidos en el archivo `.feature`.

- **`src/test/java/demoblaze/runners/TestRunner.java`**:
  - Configuración del `TestRunner` para ejecutar las pruebas de Cucumber.

- **`build/reports/Reporte y captura/`**:
  - Directorio donde se guardarán los reportes de Extent Reports y las capturas de pantalla de las pruebas.

## Instrucciones de Ejecución

1. **Importar el Proyecto**:
   - Abre Eclipse.
   - Importa el proyecto como un proyecto Gradle existente.

2. **Verificar Dependencias**:
   - En Eclipse, verifica que todas las dependencias están descargadas y disponibles.
   - Si hay algún problema con las dependencias, ejecuta `gradle build` desde la raíz del proyecto para descargarlas e instalarlas.

3. **Ejecutar Pruebas**:
   - Navega a `src/test/resources/demoblaze/features/`.
   - Haz clic derecho sobre el archivo `compra.feature`.
   - Selecciona `Run As` > `Cucumber Feature`.
   - Esta acción ejecutará el escenario de prueba definido en el archivo `compra.feature`.

4. **Ver Resultados**:
   - Una vez finalizada la ejecución, los resultados y las capturas de pantalla estarán disponibles en `build/reports/Reporte y captura/`.
   - El informe HTML generado por Extent Report se encuentra en `ExtentReport.html` dentro del mismo directorio.

5. **Limpieza del Proyecto**:
   - Para limpiar el proyecto y eliminar los archivos generados, puedes ejecutar `gradle clean` desde la terminal de Eclipse o desde la línea de comandos.

## Consideraciones Finales

- **Configuración del WebDriver**: Si decides ejecutar las pruebas en un navegador diferente a Chrome, asegúrate de cambiar el driver correspondiente en la clase `BaseTest.java`.
- **Ejecución de Pruebas**: Aunque las pruebas están configuradas para ejecutarse desde Eclipse, también puedes configurarlas para ejecutarse desde la línea de comandos utilizando Gradle.

Este documento cubre los aspectos esenciales para ejecutar las pruebas automatizadas en el proyecto Demoblaze. Para cualquier duda o problema, revisa la configuración del entorno y las dependencias del proyecto.
