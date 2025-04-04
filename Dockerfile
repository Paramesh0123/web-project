FROM rojaparamesh/tomcat:v1
COPY target/hello-world-webapp.war /opt/tomcat/webapps
