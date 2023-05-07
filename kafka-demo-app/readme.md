Steps to Run this Project

1. Run Zookeeper Server
   .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
   
2. Run Kafka Server
   .\bin\windows\kafka-server-start.bat .\config\server.properties
   
3. Now Run Producer and Consumer Apps and send messages

4. To check Topics available in Kafka Server
   .\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

Reference Link: https://www.geeksforgeeks.org/how-to-install-and-run-apache-kafka-on-windows/
