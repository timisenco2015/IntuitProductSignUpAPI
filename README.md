# ProductSignUpAPI
Developed this project to display my full knowdlege of API development in spring boot. A product signup experience using a number  that will create the user and process payment, and then return a response of the completed transaction. 

 
Problems:

1) A user creation REST API that will take in user information (name, address, email address), validate it, push it to a datastore, and return a response.

2) A payment processing REST API that will that will take in payment information (credit card number, expiry date, cvv, payment address) as a payload and validate the payload for completeness.  It will not be necessary to send it off to a payment gateway for processing.

3) An orchestration REST API that will orchestrate the calls between the user creation, and the payment processing APIs. The order in which the calls are made will be, create the user first, and then call the payment processing API.

4) All APIs will validate the payload contents.

5) All APIs will ensure that security measures are taken to mask personally identifiable data (name, payment information) that is being logged.

6) Application is fully unit tested.

 

Technology

These RESTful APIs are written in Spring Boot.

Data storage

A H2 (In Memory) Database.
