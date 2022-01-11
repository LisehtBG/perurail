# perurail

Desafío II:

AUTOMATIZACIÓN DE PRUEBAS FUNCIONALES
PERURAIL – BOOKING DE VIAJES

Actividades a desarrollar
1. Proponga usted el plan o listado de actividades a desarrollar para realizar la automatización de
pruebas según la funcionalidad indicada en el Anexo 2.
2. Implemente el código necesario para la creación del script de pruebas automatizadas según la
funcionalidad indicada en el Anexo 2 e indique la cobertura de pruebas obtenida por el script.
3. Indique las herramientas y técnicas utilizadas para realizar la automatización de la funcionalidad
descrita en el Anexo 2.

Para este desafío nos centraremos en las siguientes rutas y servicios de trenes.
1. Para el servicio de tren BELMOND ANDEAN EXPLORER se utilizará el destino CUSCO y la ruta
PUNO > CUSCO y la ruta AREQUIPA > PUNO > CUSCO

DESARROLLO:

Se automatizó el flujoPara el servicio de tren BELMOND ANDEAN EXPLORER se utilizará el destino CUSCO y la ruta
PUNO > CUSCO y la ruta AREQUIPA > PUNO > CUSCO
Se implemnto con POM, seleniumwebdriver 

La ejecución se realizó con Java 8 y en una mac (ver configuración de cromedriver en mac)



CONFIGURACIÓN DE CROMEDRIVER EN MAC:
- Identificar la version del navegador (en mi caso: Versión 97.0.4692.71)
- Descargar el chromedriver.zip con la misma version del navegador - > https://chromedriver.storage.googleapis.com/index.html?path=97.0.4692.71/
- Descomprimir el archivo .zip
- Ubicarse en la ruta /usr/local/bin
- Copiar el archivo descomprimido en la ruta

- Abrir el proyecto con intellIJ
- Actualizar el proyecto maven
- Ejecutar el @test de la clase BelmondTest


