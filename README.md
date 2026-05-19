# POSTbook

Inspired by Meta Facebook. you can post multiple times without
limit but this is full backend without client UI

## Features

- Register User
- Login User
- Generate token
- Authentication
- List content

## Tech Stack
- Java
- Spring Boot
- Postgres
- Maven

## Installation

### Clone the repository

````
git clone https://github.com/jeremiskie/springboot-postbook.git
````

### Open Project

`cd project`

### Configure application.properties
```
spring.datasource.url=jdbc:postgresql://localhost:5432/postbook
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
```

## API Endpoints

### Register

POST `/api/auth/register`

Request Body:

``` 
{
  "username": "johndoe",
  "password": "123456"
}
```

Response:

``` 
{
  "message": "User registered successfully"
}
```

### Login

POST `/api/auth/login`

Request Body:

``` 
{
  "username": "johndoe",
  "password": "123456"
}
```

Response:

``` 
{
  "token": "sample-token"
}
```

## Folder Structure

```
src
 ┣ controller
 ┣ service
 ┣ repository
 ┣ entity
 ┣ dto
 ┗ config
```

