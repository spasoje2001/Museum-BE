<h1 align="center">Museum Information System Backend</h1>

<div>
    <img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot"/>
    <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
    <img src="https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/>
    <img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white"/>
    <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white"/>
</div>

# Overview:
This is a backend part of a project for course Information systems engineering.
Project documentation, for better understanding its intentions, can be found in the [documentation](https://github.com/dokma11/Museum-Information-System-Backend/tree/main/documentation) directory.

Frontend project can be found [here](https://github.com/dokma11/Museum-Information-System-Frontend).

Microservices integrated with this project can be found [here](https://github.com/dokma11/NAIS-Project).

# Subdomains:
- <b>Artifact and item collections:</b> This subdomain represents a necessary strategy for the effective management of museum resources. 
It involves adding items, managing their locations and enabling loans of collection items to other institutions. Additionally, 
it enables item restoration.
- <b>Exhibitions:</b> This subdomain aims to enable curators and exhibition organizers to efficiently plan, organize and monitor exhibitions within the museum.
Exhibition management includes enabling curators and organizers to create new exhibitions, edit them or remove them.
- <b>Tours:</b> The tour subdomain includes the tour creation process by the organizer, tour edition and removal. 
After a tour is created, it is publicly available to all museum visitors and they have the opportunity to reserve their seats on that tour.
Additionally, visitors can request their own personal tours, which an organizer can accept or decline.
- <b>Events:</b> The responsibility of this subdomain is to enable and to the greatest extent automate the organization of events in the museum.
By organizing different types of events, the museum can attract a wider audience, even those that have little contact with historical cultural heritage.

# Technologies:
- <b>Java:</b> Programming language used in the project.
- <b>Spring boot:</b> Framework used to build and run the backend application.
- <b>PostgreSQL:</b> Database system used for data storage and retrieval.
- <b>Maven:</b> Build automation and dependency management tool.
- <b>JWT:</b> JSON Web Tokens used for securing API authentication.
- <b>Swagger:</b> Tool for API documentation and testing.

# Getting started:

<h3>Prerequisites</h3>

- <b>Git:</b> Ensure you have Git installed. You can download it from [here](https://git-scm.com/downloads).
- <b>JDK:</b> Ensure you have JDK 22 installed. You can download it from [here](https://maven.apache.org/download.cgi).
- <b>PostgreSQL:</b> Ensure you have PostgreSQL installed. You can download it from [here](https://www.postgresql.org/download/).
- <b>Apache Maven:</b> Ensure you have Apache Maven installed. You can download it from [here](https://maven.apache.org/download.cgi).

<h3>Steps</h3>

1. <b>Clone the repository:</b> <br>
git clone https://github.com/dokma11/Museum-Information-System-Backend.git
2. <b>Set up database:</b> <br>
Create a new database for the project. Update the database configuration in the application.properties file.
3. <b>Build an run the application:</b> <br>
mvn clean install <br>
mvn spring-boot:run

# Authors:
- [Nina Kuzminac RA 119/2020](https://github.com/kuzminacc)
- [Veljko Nikolić RA 121/2020](https://github.com/veljko121)
- [Spasoje Brborić RA 107/2020](https://github.com/spasoje2001)
- [Vukašin Dokmanović RA 89/2020](https://github.com/dokma11)
