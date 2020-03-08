<h1>Userbook</h1>

<p>A web application for registering people and their informations</p>

<h3>Steps to run:</h3>

<ol>
  <li>
    <p>Create a database in MySQL named 'userbookdb'</p>
  </li>

  <li>
    <p>Import project to Eclipse as 'existing Maven project'
      <br>
      Add Wildfly server to Eclipse and use it to run project on server
      <br>
      <strong>or</strong>
      <br>
      Use <code>./standalone.sh</code> in wildfly/bin to start Wildfly process
      <br>
      Build project with <code>mvn clean org.wildfly.plugins:wildfly-maven-plugin:deploy</code>
    </p>
  </li>

  <li>
    <p>Configuration of the 'standalone.xml' file in the Wildfly folder:</p>
    <p>Add this in 'undertow' subsystem to grant access to css and js files:

        <subsystem xmlns="urn:jboss:domain:undertow:10.0" default-server="default-server" default-virtual-host="default-host" default-servlet-container="default" default-security-domain="other" statistics-enabled="${wildfly.undertow.statistics-enabled:${wildfly.statistics-enabled:false}}">
            <server name="default-server">
                <host name="default-host" alias="localhost" default-web-module="userbook.war">
                    <location name="/" handler="welcome-content"/>
                    <location name="/resources" handler="resources"/>
                    <http-invoker security-realm="ApplicationRealm"/>
                </host>
            </server>
            <handlers>
                <file name="resources" path="[your_relative_path]\userbook\src\main\webapp\resources\" directory-listing="false"/>
            </handlers>
        </subsystem> 
  </p>
  </li>

  <li>
    <p>Add this in 'datasources' to connect to database:

        <datasource jndi-name="java:jboss/datasources/userbookdb" pool-name="userbookdb" enabled="true" use-java-context="true">
            <connection-url>jdbc:mysql://localhost:3306/userbookdb?serverTimezone=America/Sao_Paulo</connection-url>
            <driver>mysql</driver>
            <security>
                <user-name>root</user-name>
                <password>root</password>
            </security>
        </datasource>
  </p>
  </li>

  <li>
    <p>Add this in 'drivers':

        <driver name="mysql" module="com.mysql">
          <xa-datasource-class>com.mysql.cj.jdbc.MysqlXADataSource</xa-datasource-class>
        </driver>
      </code>  
  </p>
  </li>
</ol>
