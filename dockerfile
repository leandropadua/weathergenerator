FROM maven

RUN wget https://github.com/leandropadua/weathergenerator/archive/master.zip
RUN unzip master
RUN mvn clean install -f weathergenerator-master/pom.xml
RUN mvn exec:java -f weathergenerator-master/pom.xml 

CMD cd weathergenerator-master && mvn exec:java -q