# kotlin-springboot-phone-book-sysytem
## Installation

RUN git clone https://github.com/rasheedalt/kotlin-springboot-phone-book-sysytem.git

RUN cd kotlin-springboot-phone-book-sysytem

RUN docker run -p 8080:8080 phonebooksystem


API ENDPOINTS

Create Contact
- POST /api/v1/phone-book/create body { name: "John", phoneNumber: "098999776655", address: "London"}

Fetch All Contacts
- GET /api/v1/phone-book

Fet A Contact
- GET /api/v1/phone-book/{id}

Delete A Contact
- DELETE /api/v1/phone-book/delete/{id}
