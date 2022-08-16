# Student Management System
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
