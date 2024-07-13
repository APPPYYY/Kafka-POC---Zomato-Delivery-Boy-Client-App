# Kafka POC - Zomato Delivery Boy & Client App
This repository contains the Kafka Proof of Concept (POC) project, which includes two integrated applications: the Zomato Delivery Boy App and the Zomato Client App. These applications demonstrate the use of Apache Kafka for live location updates and continuous tracking of orders using Spring Boot and Spring Kafka.

Key Features:

Live Location Updates: Real-time tracking of the delivery boy’s location.
Continuous Order Tracking: Seamless updates on the order status.
Producer and Consumer Services: Kafka producer services in the Delivery Boy App send location updates, while consumer services in the Client App receive and process these updates in real time.
Spring Boot Integration: Robust and scalable backend services.
Spring Kafka Implementation: Efficient real-time data streaming and processing.
Technologies Used:

Backend: Spring Boot, Spring Kafka
Messaging: Apache Kafka

Outcome:

This project showcases the capabilities of Kafka for real-time data streaming and processing, providing a reliable and efficient solution for live tracking and order management in a food delivery context.

#DataStreaming #ApacheKafka #RealTimeStreaming #KafkaPOC #RealTimeData #StreamProcessing #SpringKafka #EventDrivenArchitecture #RealTimeAnalytics #MessagingQueue #StreamData #DistributedStreaming #EventStreaming #DataPipeline #RealTimeUpdates #KafkaStreams #StreamingData

Steps to Test Kafka on Windows:

1.Start Zookeeper:

bin\windows\zookeeper-server-start.bat config\zookeeper.properties

2.Start Kafka Server:

bin\windows\kafka-server-start.bat config\server.properties

3.Create a Kafka Topic:

bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092

4.Send Messages to the Topic:

bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic

After running the above command, you can type your messages and press Enter to send each message. Example messages:

Hello, Kafka!
This is a test message.
Kafka is working fine.
Sending another message.
Final test message.

5.Consume Messages from the Topic:

bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --from-beginning

You should see the messages you sent earlier displayed in the consumer terminal.

Description of Steps:

1.Start Zookeeper:

Zookeeper is a centralized service for maintaining configuration information, naming, providing distributed synchronization, and providing group services. It is essential for running Kafka.

2.Start Kafka Server:

The Kafka server is the main component that runs the Kafka broker. It handles the production and consumption of messages, manages the storage, and ensures fault tolerance.

3.Create a Kafka Topic:

A topic in Kafka is a category or feed name to which records are stored and published. Creating a topic is necessary to send and receive messages.

4.Send Messages to the Topic:

Use the Kafka console producer to send messages to the topic. This is useful for testing and debugging.

5.Consume Messages from the Topic:

Use the Kafka console consumer to read messages from the topic. This helps verify that the messages are being correctly produced and consumed.
