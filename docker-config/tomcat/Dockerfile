FROM tomcat:8
MAINTAINER "Gory Alexandre <agory.contact@gmail.com>"

ADD /docker-config/tomcat/settings.xml /usr/local/tomcat/conf/
ADD /docker-config/tomcat/tomcat-users.xml /usr/local/tomcat/conf/

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY classes/artifacts/permis_piste_backend/permis-piste-backend.war /usr/local/tomcat/webapps/ROOT.war
