FROM tomcat
COPY ./itsmdhealthManage.war  /usr/local/tomcat/webapps/
WORKDIR /usr/local/tomcat/conf/
RUN sed -i 's|"8080"|"9092"|' server.xml