FROM eclipse-temurin:21

COPY . /usr/src/elkdemo
WORKDIR /usr/src/elkdemo

RUN apt-get update && apt-get install -y maven
RUN mkdir -p /var/log/application

# Download docdb SSL certificate
RUN wget https://truststore.pki.rds.amazonaws.com/global/global-bundle.pem
# Import the certificate into the JVM truststore
# RUN keytool -import -trustcacerts -alias aws-documentdb-ca -file ./global-bundle.pem -keystore $JAVA_HOME/lib/security/cacerts -storepass changeit -noprompt
RUN keytool -import -trustcacerts -alias aws-documentdb-ca -file ./global-bundle.pem -keystore ./truststore.jks -storepass changeit -noprompt

# RUN curl -L -O https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-7.16.0-amd64.deb \
# && dpkg -i filebeat-7.16.0-amd64.deb

CMD ["mvn", "spring-boot:run", "-Djavax.net.ssl.trustStore=./truststore.jks", "-Djavax.net.ssl.trustStorePassword=changeit"]
