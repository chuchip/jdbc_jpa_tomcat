En este ejemplo veremos como conecta a Postgresql usando JPA + Hibernate y Spring JDBC. Para ello uso como servidor de aplicaciones Tomcat. La configuración esta realizada con anotaciones y XML y utilizo el pool de conexiones de Tomcat recogido a través de JNDI, para que la aplicación no deba saber realmente ni donde se conecta.

Se puede levantar facilmente la base de datos mysql con docker con esta sentencia:

docker run -p3306:3306 --name mysql-liferay -e MYSQL_ROOT_PASSWORD=liferay -e MYSQL_DATABASE=liferay -eMYSQL_USER=liferay -e MYSQL_PASSWORD=pass -d mysql:5.7.37

Tener en cuenta que la aplicación responderá en la URL:  http://localhost:8080/jdbc-ejemplo/ ya que así está puesto en el fichero "/jdbc_jpa_tomcat/src/main/webapp/META-INF/context.xml"

Mas informacion y explicacion del programa en:

http://www.profesor-p.com/2018/08/21/conectando-con-postgresql-usando-jndi-y-spring-en-tomcat-parte-1/

