# Copilot Instructions for libreria_dao_1

## Project Overview
- This is a Java 17 project using Maven, organized under the `com.generation.synclesson` package.
- The main entry point is `src/main/java/com/generation/synclesson/Main.java`.
- Database connectivity is handled by `Database.java` in `src/main/java/com/generation/synclesson/database.java/`.
- The project is structured for future expansion, but currently has minimal business logic and no test or resource files.

## Architecture & Patterns
- **Database Access:**
  - All database connections use the `Database` class, which manages MySQL connections via JDBC.
  - Credentials and connection details are hardcoded (username: `root`, password: `root`, URL: `jdbc:mysql://localhost:3306/`).
  - The schema name is passed to the `Database` constructor.
  - Example usage:
    ```java
    Database db = new Database("your_schema");
    Connection conn = db.gConnection();
    db.closeConnection();
    ```
- **Main Application:**
  - The `Main` class is the entry point for running the application.

## Build & Run
- **Build:**
  - Use Maven to build: `mvn clean package`
- **Run:**
  - Run the main class: `mvn exec:java -Dexec.mainClass="com.generation.synclesson.Main"`
- **Dependencies:**
  - Add JDBC/MySQL dependencies to `pom.xml` as needed (currently not present by default).

## Conventions & Notes
- **Directory Naming:**
  - The `database.java` directory is unconventional; it contains only `Database.java`.
- **Credentials:**
  - Database credentials are not externalized; consider using environment variables or config files for production.
- **Testing:**
  - No tests are present. Place tests under `src/test/java/` following Maven conventions.
- **Resources:**
  - Place resource files in `src/main/resources/` if needed.

## Key Files
- `src/main/java/com/generation/synclesson/Main.java` — Application entry point
- `src/main/java/com/generation/synclesson/database.java/Database.java` — MySQL connection logic
- `pom.xml` — Maven project configuration

## Example: Adding a DAO
- Place new DAO classes in `src/main/java/com/generation/synclesson/` or a subpackage.
- Use the `Database` class for all DB connections.

---
For more details, inspect the `Database` class for connection patterns and the `pom.xml` for build configuration.
