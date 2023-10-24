# Manual de Instalación - Matricula_Proccess 

Dentro de este apartado mostraremos los pasos necesarios para poder realizar la instalación del proyecto ``"Matricula Proccess"`` localmente.

## Instalación de Software

1. JDK 17 -> [Sitio Oficial](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) | [Descargar](https://download.oracle.com/java/17/archive/jdk-17.0.9_windows-x64_bin.exe)

2. Oracle 21c Express Edition -> [Sitio Oficial](https://www.oracle.com/database/technologies/oracle21c-windows-downloads.html) | [Descargar](https://www.oracle.com/webapps/redirect/signon?nexturl=https://download.oracle.com/otn/nt/oracle21c/213000/WINDOWS.X64_213000_db_home.zip)

3. Oracle SQL Developer -> [Sitio Oficial](https://www.oracle.com/database/sqldeveloper/) | [Descargar](https://www.oracle.com/webapps/redirect/signon?nexturl=https://download.oracle.com/otn/java/sqldeveloper/sqldeveloper-23.1.0.097.1607-x64.zip)

4. VisualStudio Code -> [Sitio Oficial](https://code.visualstudio.com/) | [Descargar](https://code.visualstudio.com/docs?dv=win)

5. Spring Boot Extension Pack -> [Sitio Oficial](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack) | [Descargar](vscode:extension/vmware.vscode-boot-dev-pack)

## Proceso de Instalación del Software

1. JDK 17

    * Ingresamoa al link de descarga.
    * Damos `"siguiente"` en todos los pasos hasta llegar al punto en donde el instalador nos pedirá la ubicación en donde almacenará el software. 
    * Escogemos la ruta por defecto y **`copiaremos la ruta`**  para posteriormente utilizarla en nuestras `Variables de entorno del sistema`.
    * Ingresamos a las Variables de entorno, luego nos dirigimos a las `Variables del sistema`, ubicamos el apartado de `Path`, pulsamos editar y se nos abrira otra ventana, seleccionamos `Nuevo` y alli colocamos la ruta en donde instalamos el JDK 17 añadiendo la apertura a la carpeta `bin`.
        ```
        C:\Program Files\Java\jdk-17\bin
        ```
    * Por último, regresamos a las `Variables del sistema` y selecconamos el boton `Nueva`, alli crearemos una nueva variable denominada `JAVA HOME` la cual unicamente tendrá como valor la ruta de nuestro JDK 17 sin añadir acceso al archivo `bin`
        ```
        C:\Program Files\Java\jdk-17
        ```

2. Oracle 21c Express Edition

    * La instalación inicia con la ejecución del instalador `setup.exe` de `Oracle 21c Express Edition`, durante esta instalación procederemos a solamente dar `siguiente` en todos los procesos.

    * Un punto clave y que amerita prestar bastante atención es cuando el instalador pedira que: `Especifique la contraseña de la base de datos`, es importante saber la constraseña ya que esta será unica para poder crear más adelante nuevos usuarios y bases de datos.

3. Oracle SQL Developer

    * Oracle SQL Developer es un `entorno` de desarrollo integrado y gratuito que `simplifica el desarrollo` y la gestión de Oracle Database.

    * Este tipo de sotfware **`no requiere instalación`**, es un archivo ejecutable de facil uso e implementación. El único punto a tener en cuenta es donde alojarlo, siendo recomendado hacerlo dentro del `Disco C:`.

4. VisualStudio Code

    * El proceso de instalación de Visual Studio Code es simple y no creemos que tenga problemas en su intalación, es solo dar `siguiente` hasta poder terminar.

5. Spring Boot Extension Pack

    * Como pre requisito será necesario tener VS code instalado para poder acceder de esta forma a sus `extensiones`, la que buscaremos será un paquete de las 3 principales extensiones de uso de `Spring Boot` las cuales son:
        * Spring Initializr Java Support
        * Spring Boot Dashboard
        * Spring Boot Tools

    * Con la instalación de `Spring Boot Extension Pack` automaticamente instalaremos todo lo necesario para poder trabajar con proyecto de `Spring` dentro del entorno de Visual Studio Code.

## Proceso de Instalación del Proyecto: Matricula_Proccess 

1. Clonación del Repositorio Matricula_Proccess

    * Ingresamos al repositorio oficial en Github del proyecto `Matricula_Proccess` y clonamos el proyecto dentro del apartado `Code`, una vez hayamos descargado la copia del proyecto y según las credenciales obtenidas podremos ser parte del equipo de desarrollo, para realizar este efecto dentro de nuestra terminarl llenamos los siguientes datos:
    ```bash
    git config --global user.email "you@example.com"
    git config --global user.name "Your Name"
    ```

2. Creación de la Base de Datos

    * Ingresamos al aplicativo de `Oracle SQL Developer`, esperamos a que cergue y una vez hecho nos dirigimos al apartado de conexiones, dentro encontraremos una base de datos creada por defecto, ingresamos a la misma utilizando la contraseña generada pasos anteriores en la instalación de `Oracle 21c Express Edition` y luego nos dara acceso.

    * Dentro de la base de datos principal, nos iremos al último apartado denominado `Otros Usiarios` y daremos click derecho, seleccionamos `Crear Usuario` y una vez dentro se nos abrira una nueva ventana y por defecto estaremos dentro de la opción `Usario`, los datos a llenar son:
        * Usuario: `MATRICULA_DB`
        * Contraseña Nueva: `MATRICULA_DB`
        * Confirmar Contraseña: `MATRICULA_DB`
        * *`No damos check a ninguna de las 4 opciones siguientes`*
        * Tablespace por defecto: `USERS`
        * Tablespace Temporal: `TEMP`

    * Por último nos dirigimos al apartado denominado `SQL` y pegamos el siguiente `script` y pulsamos el botón `Aplicar`.
        ```sql
        -- SESSION
        ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;

        -- USER SQL
        CREATE USER "MATRICULA_DB" IDENTIFIED BY "MATRICULA_DB"  
        DEFAULT TABLESPACE "USERS"
        TEMPORARY TABLESPACE "TEMP";

        -- ROLES
        GRANT "CONNECT" TO "MATRICULA_DB" ;
        GRANT "RESOURCE" TO "MATRICULA_DB" ;
        ALTER USER "MATRICULA_DB" DEFAULT ROLE "CONNECT","RESOURCE";

        -- SYSTEM PRIVILEGES
        GRANT SELECT ANY DICTIONARY TO "MATRICULA_DB" WITH ADMIN OPTION;
        GRANT CREATE ANY VIEW TO "MATRICULA_DB" WITH ADMIN OPTION;
        GRANT UNLIMITED TABLESPACE TO "MATRICULA_DB" WITH ADMIN OPTION;
        ```
    
    * Despues de crear correctamente el usuario con nombre `MATRICULA_DB`, crearemos una nueva base de datos con el mismo nombre. Para ello nos dirigimos dentro de las `Conexiones` a `Oracle conexiones` y damos click derecho en `Nueva Conexión` ó simplemente damos click en el `ícono verde en forma de un "+"`, luego se nos abrirá una ventana para crear la base de datos, los datos a llenar son los siguientes:
        * Name: `MATRICULA_DB`
        * Usuario: `MATRICULA_DB`
        * Contraseña: `MATRICULA_DB`

    * Luego de llenar los campos para crear una nueva base de datos presionamos el botón `Probar`, una opción mas arriba del campo de los botones inferiores aparecerá el `Estado:` en donde en caso todo este correcto saldrá `Estado: Correcto`, si es el caso, luego presionamos el botón `Guardar` y por último `Conectar` en donde saldra una ventana emergente exigiendo la contraseña del usuario creador, colocamos `MATRICULA_DB` para finalizar con el proceso.

    * Una vez cloando el repositorio de `Github` correctamente, dentro del source principal nos encontraremos con el archivo `DDL_Matricula.txt` el cual contiene el `script` necesario para poder crear toda la base mediante sentencias SQL. Copiamos todo su contenido y nos dirigimos a `Oracle SQL Developer` donde pegaremos el DDL por completo y paso siguiente presionamos la tecla `F5` para ejecutar el script.

3. Desplegar el Proyecto Matricula_Proccess Localmente

    * Nos dirigimos a VS Code dentro de nuestro proyecto y nos dirigimos a la barra lateral izquiera en donde se encuentran nuestras extensiones, dentro de los iconos se encontrará la extensión de `Spring Boot Dashboard`, ingresamos y se nos presentarán 3 apartados, escogemos el apartado `APPS` y dentro de el encontraremos nuestro `software` el cual poseerá la opción `Run` dado por un ícono de `play`.

    * Por último, ingresamos a nuestro browser favorito y accesamos a nuestro sitio web bajo la dirección de `http://localhost:8080`
