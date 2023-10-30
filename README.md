# crowdar
Requisitos java 8 kit develoment algun IDE

Las tecnologías utilizadas en este proyecto incluyen el lenguaje de programación Java, la arquitectura POM (Project Object Model) para mantener un orden en el código, y la sintaxis Gherkin para tener una visión clara del flujo desde la perspectiva del cliente. Además, se utiliza Selenium, una herramienta de código abierto que se utiliza para automatizar aplicaciones web.

Es importante destacar que el uso de Java como lenguaje de programación proporciona una base sólida y ampliamente utilizada en el desarrollo de software. La arquitectura POM, por su parte, ayuda a organizar y gestionar las dependencias del proyecto de manera eficiente. La sintaxis Gherkin, basada en un lenguaje natural estructurado, permite describir el comportamiento del software de una manera legible y comprensible para todas las partes interesadas

¿que se hizo? Resumen:

Se crea un archivo <nombre>.feature (cucumber), en el cual se plantea el escenario de la preba, el cual también se le entregan los datos de esta misma
![image](https://github.com/OliverABV/crowdar/assets/45653045/e575f5ae-9c9d-413f-ab6b-87c1a26bad14)

![image](https://github.com/OliverABV/crowdar/assets/45653045/41a47260-efc7-40b6-9ef8-c7cf0ffb28dd)

una vez visto el paso a paso de la prueba creamos el <Difinition>.java en el cual llamamos los métodos que se encuentran por detrás y este mismo definition lo usamos para validar, dar confirmación y veracidad a las pruebas

Para capturar e interactuar con elementos de la página, se crea un archivo <Page>.java en el cual se implementan métodos para realizar acciones como capturar valores de pantalla, guardarlos en el contexto del escenario y utilizar esos datos en otras iteraciones de las pruebas definidas en Gherkin. También se crean las clases de ScenarioContext para validar y verificar la veracidad de las pruebas.

Este enfoque permite una interacción efectiva con los elementos de la página web y facilita la reutilización de datos en diferentes flujos de automatización  
![image](https://github.com/OliverABV/crowdar/assets/45653045/5c868f51-7246-43b6-83ac-190fd097aebc)
![image](https://github.com/OliverABV/crowdar/assets/45653045/9b8843b2-bab7-45d9-b0ed-89f041976fa2)

Para no crear el código una y otra vez creo una Base.java con el motivo de usarla como base de código repetitivo pongo estándares de tiempo, visualización entre otros
![image](https://github.com/OliverABV/crowdar/assets/45653045/b4f1bdcf-69ae-452c-b59b-590c33427ca7)

COMO EJECUTAR:  

Si deceamos ejecutar con otro navegador que no sea Chrome devemos indicarlo mediante Enviroment de solo querer usar chrome simplemente no es necesario agregar el BROWSER en Enviroment ya que viene por defecto chrome, 
tampoco necesitamos descargar algun tipo de wendriver ya que el proyecto lo hace por su cuenta de lo contrario haga lo siguente.

Enviroment : debemos crear una variable con el nombre de BROWSER y darle el nombre del navegador por ejemplo firefox
de esta manera se nos ejecutara con el BROWSER seleccionado  

![image](https://github.com/OliverABV/crowdar/assets/45653045/0c69fbab-9dcc-40e5-8cfe-c395b6306237)

ngresamos la versión de Junit 4, proyecto y la clase una vez configurado, esto podremos correr el proyecto y ejecutar las pruebas

![image](https://github.com/OliverABV/crowdar/assets/45653045/1dbe0777-7baf-4df5-9fa8-e76cc0bbbd0e)

Las dependencias se descargarán de forma automatica, ya que este trabaja con maven dependiendo de su IDE sera diferente la interfaz de configuracion de los enviroment

Una ves ejecutado podemos ver el step step cave resaltar que unos de esos casos es intensionalmente el erro para poder ver en el informe esta informacion 

![image](https://github.com/OliverABV/crowdar/assets/45653045/6045c18d-3174-4f25-bfdf-e16ff894c9b0)

El reporte HTML quedara dentro de \target\report_html

En la siguente img podemos ver la imagen cuando este da error guardara una imagen y sera visible dentro del reporte HTML

![image](https://github.com/OliverABV/crowdar/assets/45653045/b1bf618a-d677-4f3a-a37a-15ff1a05827e)

![image](https://github.com/OliverABV/crowdar/assets/45653045/7fa877a5-7b75-49e9-ade1-fd62aca22c1e)


