@Echo Off
REM This compiles the code
javac --module-path "C:\Program Files\Java\mysql-connector-java-5.1.48;C:\Program Files\Java\javafx-sdk-14.0.1\lib" --add-modules javafx.controls,javafx.fxml -classpath "C:\Program Files\Java\mysql-connector-java-5.1.48\*.jar;C:\Program Files\Java\javafx-sdk-14.0.1\lib\*.jar" Genres.java
REM This runs the code
java --module-path "C:\Program Files\Java\mysql-connector-java-5.1.48;C:\Program Files\Java\javafx-sdk-14.0.1\lib" --add-modules javafx.controls,javafx.fxml -classpath "C:\Program Files\Java\javafx-sdk-12.0.2\lib\*.jar;C:\Program Files\Java\javafx-sdk-14.0.1\lib\*.jar;." Genres
Exit
