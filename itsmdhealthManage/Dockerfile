FROM tomcat
COPY ./itsmdhealthManage.war  /usr/local/tomcat/webapps.dist/
ENV CATALINA_HOME  /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
WORKDIR /usr/local/tomcat/conf/
RUN sed -i 's|"8080"|"9092"|' server.xml
WORKDIR /usr/local/tomcat/
RUN mv webapps webapps2
RUN mv webapps.dist webapps
EXPOSE 8087