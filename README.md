# Kode Kata

- The code for the StringCalculator can be found within the kodekata folder

# csvloader

- This little App is in charge of reading the csv file within the resources folder and send all the data on a POST request
- It can't be executed un the API is running

# demo
- this is the API. It needs to be started using gradle or from your favourite IDE.
- the data will be saved on a database in memory (H2)

## Useful commands for the API project
- ./gradlew clean build
- ./gradlew bootRun (to start it)

## Endpoints
 - POST: http://127.0.0.1:8080/csv/add (the request payload is a list of csv rows)
 - GET: http://localhost:8080/csv/data?customerRef=5 (every row can be fetched using the customerRef field)
