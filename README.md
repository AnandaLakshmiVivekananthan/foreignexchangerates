Description:
Web services to convert EUR to USD, GBP, JPY, CZK.
Consumes external api to obtain the latest values and stores it in the DB.
If the lates values are present in the DB, no external api call is necessary.

Unit Testing:
For Controller and Service layer using JUnit5.

Database:
Postgresql

Migration Tool:
Flyway
