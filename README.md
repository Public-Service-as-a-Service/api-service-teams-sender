# API-Service-Teams-Sender

_Sending messages from the messaging service to teams users._

## Getting Started

### Prerequisites

- **Java 25 or higher**
- **Maven**
- **MariaDB**(if applicable)
- **Git**
- **[Dependent Microservices](#dependencies)** (if applicable)

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Public-Service-as-a-Service/api-service-teams-sender.git
   cd api-service-teams-sender
   ```
2. **Configure the application:**

   Before running the application, you need to set up configuration settings.
   See [Configuration](#Configuration)

   **Note:** Ensure all required configurations are set; otherwise, the application may fail to start.

3. **Ensure dependent services are running:**

   If this microservice depends on other services, make sure they are up and accessible. See [Dependencies](#dependencies) for more details.

4. **Build and run the application:**

   ```bash
   mvn spring-boot:run
   ```

## Dependencies

This microservice depends on the following services:

- **Microsoft Graph**
  - **Purpose:** To send messages over teams.
  - **Repository:** [Link to the repository](https://learn.microsoft.com/sv-se/graph/overview)
  - **Setup Instructions:** Refer to its documentation for installation and configuration steps.

Ensure that these services are running and properly configured before starting this microservice.

## API Documentation

Access the API documentation via Swagger UI:

- **Swagger UI:** [http://localhost:8080/api-docs](http://localhost:8080/api-docs)

Alternatively, refer to the `openapi.yml` file located in the project's root directory for the OpenAPI specification.

## Usage

### API Endpoints

Refer to the [API Documentation](#api-documentation) for detailed information on available endpoints.

### Example Request

```bash
curl -X GET http://localhost:8080/api/resource
```

## Configuration

Configuration is crucial for the application to run successfully. Ensure all necessary settings are configured in `application.yml`.

### Key Configuration Parameters

- **Server Port:**

  ```yaml
  server:
    port: 8080
  ```
- **Database Settings:**

  ```yaml
  spring:
    datasource:
      url: jdbc:mysql://localhost:3306/your_database
      username: your_db_username
      password: your_db_password
  ```
- **Azure Setup**

```yaml
azure:
  ad:
    "2281":
      user: user
      clientId: client-id
      tenantId: tenant-id
      clientSecret: client-secret
      authorityUrl: https://login.microsoftonline.com
      redirectUri: http://localhost:8080/callback
      loginUrl: https://login.microsoftonline.com/login 
```

### Database Initialization

- **No additional setup is required** for database initialization, as long as the database connection settings are correctly configured.

### Additional Notes

- **Application Profiles:**

  Use Spring profiles (`dev`, `prod`, etc.) to manage different configurations for different environments.

- **Logging Configuration:**

  Adjust logging levels if necessary.

## Contributing

Contributions are welcome! Please see [CONTRIBUTING.md](https://github.com/Sundsvallskommun/.github/blob/main/.github/CONTRIBUTING.md) for guidelines.

## License

This project is licensed under the [MIT License](LICENSE).

## Code status

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=YOUR-PROJECT-ID&metric=alert_status)](https://sonarcloud.io/summary/overall?id=YOUR-PROJECT-ID)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=YOUR-PROJECT-ID&metric=alert_status)](https://sonarcloud.io/summary/overall?id=YOUR-PROJECT-ID)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=YOUR-PROJECT-ID&metric=alert_status)](https://sonarcloud.io/summary/overall?id=YOUR-PROJECT-ID)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=YOUR-PROJECT-ID&metric=alert_status)](https://sonarcloud.io/summary/overall?id=YOUR-PROJECT-ID)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=YOUR-PROJECT-ID&metric=alert_status)](https://sonarcloud.io/summary/overall?id=YOUR-PROJECT-ID)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=YOUR-PROJECT-ID&metric=alert_status)](https://sonarcloud.io/summary/overall?id=YOUR-PROJECT-ID)

---

© 2024 Sundsvalls kommun
