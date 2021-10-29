# upsDemo

This little app is a REST API containing 2 end points:


GET  http://localhost:8080/person/showAll     -- Displays a list of persons available in the h2 database

POST http://localhost:8080/person/insert      -- Allows you to insert a new person into the Person table

  Sample payload-
  
  {
      "firstName":"Juana","lastName":"Garcia","phoneNumber":"449-999-99-99"
  }
