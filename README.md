# Spring Boot CURD API Example

## Prerequisites:
	- Java1.8
	- MySQL server
## Modify *application.yml* accordingly
	- url [schema name should be available on MySQL server]
	- username
	- password
## Postman APIs
### GET:
- Retrieve list of students
  - http://localhost:9090/sms/api/students/
- Retrieve an student
  - http://localhost:9090/sms/api/students/{studentId}
- Retrieve list of students by Class and pageNumber
  - http://localhost:9090/sms/api/students/{MCA}/{1}
### POST:
- Create student resource 
  - http://localhost:9090/sms/api/students/
  - Request Body
  ```json
   {
    "name": "DDD",
    "course": "MA",
    "addresses": [
        {
        "flatno": "D-441",
        "street": "41",
        "district": "DD",
        "pin": "440011",
        "contact": "4440000111"
        },
        {
        "flatno": "D-442",
        "street": "42",
        "district": "DD",
        "pin": "440022",
        "contact": "4440000222"
        }
      ]
	}
  ```
### PUT:
- Update student resource 
  - http://localhost:9090/sms/api/students/{studentId}
### DELETE:
- Delete student with ID
  - http://localhost:9090/sms/api/students/{studentId}

## MAVEN BUILD INTRUCTIONS
### clean up target
    mvn clean
###  install the package into the local repository and .jar file created inside the target folder
    mnv install
### Run Jar file 
    Open command promp and navigate target folder
    java -jar Assignment-1.0.0.jar (hit the enter key)
