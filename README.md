# transfer-service
Transfer amount between two accounts using REST API

## Endpoints

* /api/transfer
  * Responsible for transferring money from source account to destination account
  * Request Method: POST
  * Request 
    * Type: Json object
    ``{
      "sourceAccountNo": "A10000",
      "destinationAccountNo": "B20000",
      "amount": 100.00
      }``
    * Response
      * Http Status
        * 200 OK
          * Transfer object with transfer details
          * Type: Json object
          ``{
            "transactionId": "88112ef2-f3d7-4f82-b805-ffe0141e22a7",
            "sourceAccountNo": "A10000",
            "destinationAccountNo": "B20000",
            "amount": 100.00,
            "transactionTime": "2021-10-28 05:02:10",
            "transactionStatus": "SUCCESS"
            }``
        * 400 Bad Request
          * Request validation failed or insufficient balance 
          * Type Json object
          ``{
          "errorCode": "BAD_REQUEST",
          "errorMessage": "",
          "status": "FAILED"
          }``
        * 500 Internal Server Error
          * Server Errors
          * Type Json object
            ``{
            "errorCode": "INTERBAL_SERVER_ERROR",
            "errorMessage": "",
            "status": "FAILED"
            }``
        * 409 Conflict
          * Concurrent transactions has changed concerned account balance
          * Type Json object
            ``{
            "errorCode": "INTERBAL_SERVER_ERROR",
            "errorMessage": "",
            "status": "CONFLICT"
            }``

## How to run

* Download pre-requisite
  * JDK 1.8
  * Maven
* Clone repository
  * git clone https://github.com/ghoshtanmay87/transfer-service.git
* Go to root directory
  * cd transfer-service
* Perform maven clean and install
  * mvn clean install
* Go to target directory
  * cd target
* Run SpringBoot application
  * java -jar transfer-service-0.0.1-SNAPSHOT.jar
* By default, the application starts on port 8080. Invoke the API using following endpoint as mentioned in Endpoints section
  ``http://localhost:8080/api/transfer``
* H2 console is available at following endpoint to check the data
  ``http://localhost:8080/h2``

## Note

* Data runs in-memory using H2 database
* Following Account data is populated during startup using sql scripts
  * Account Number: A10000
    * Balance: 1000.00
  * Account Number: B20000
    * Balance: 1000.00
  * Account Number: C30000
    * Balance: 1000.00

## Language and Frameworks

* Java 8
* SpringBoot 2.5.6
* H2 in-memory DB
* Maven
