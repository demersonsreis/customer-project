.
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── customerapp/
│   │   │               ├── application/
│   │   │               │   ├── port/
│   │   │               │   │   ├── in/
│   │   │               │   │   └── out/
│   │   │               │   └── service/
│   │   │               ├── domain/
│   │   │               │   ├── exception/
│   │   │               │   ├── model/
│   │   │               │   └── service/
│   │   │               ├── infrastructure/
│   │   │               │   ├── adapter/
│   │   │               │   │   ├── persistence/
│   │   │               │   │   └── controller/
│   │   │               │   ├── config/
│   │   │               │   └── logging/
│   │   │               ├── interfaces/
│   │   │               │   ├── rest/
│   │   │               │   │   ├── dto/
│   │   │               │   │   │   ├── request/
│   │   │               │   │   │   └── response/
│   │   │               │   │   ├── exception/
│   │   │               │   │   └── mapper/
│   │   │               │   └── swagger/
│   │   │               └── CustomerAppApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── db/
│   │           └── migration/
│   │               ├── V1__create_customer_tables.sql
│   │               └── V2__insert_test_data.sql
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── customerapp/
├── pom.xml
└── README.md
