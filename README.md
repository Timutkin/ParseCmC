# ParseCmC
This app parses information about the 10 cryptocurrencies with the largest market capitalization every 30 seconds, then sends this information to the RabbitMQ message broker.
This app parses information about the 10 cryptocurrencies with the largest market capitalization every 30 seconds, then sends this information to the RabbitMQ message broker. The application parses coinmarketcap.com because the free version of the api from coinmarketcap has a limit of 300 requests per day.

Application Architecture:

![Architecture](https://github.com/Timutkin/ParseCmC/blob/main/Arc.jpg)
