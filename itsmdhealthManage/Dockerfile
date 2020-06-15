FROM tomcat
COPY ./itsmdhealthManage.war  /usr/local/tomcat/webapps.dist/
WORKDIR /usr/local/tomcat/conf/
RUN sed -i 's|"8080"|"9092"|' server.xml
WORKDIR /usr/local/tomcat/
mv webapps webapps2
mv webapps.dist webapps
EXPOSE 8087