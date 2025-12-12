package test.assignment.Inspius;

/*
 * Question 2.1: Database Query - Stored Procedure
 * 
 * This file contains a MySQL stored procedure to filter and summarize user data
 * from a users table based on age range and country.
 */

public class SqlTest {

    /*
     * Stored Procedure: filter_users_summary
     * 
     * Parameters:
     * - min_age: minimum age of users to include
     * - max_age: maximum age of users to include (optional)
     * - country: country of users to include
     * 
     * Output:
     * - total_user_count: number of users matching criteria
     * - average_user_age: average age of matching users
     * 
     * SQL Code:
     */

    public static final String STORED_PROCEDURE = """
            DELIMITER $$

            CREATE PROCEDURE filter_users_summary(
                IN min_age INT,
                IN max_age INT,
                IN country VARCHAR(100)
            )
            BEGIN
                -- Declare variables for output
                DECLARE total_user_count INT DEFAULT 0;
                DECLARE average_user_age FLOAT DEFAULT NULL;
                DECLARE max_age_default INT;

                -- Handle missing max_age parameter
                -- If max_age is NULL or not provided, use the highest age in users table
                IF max_age IS NULL THEN
                    SELECT MAX(age) INTO max_age_default FROM users;
                    SET max_age = max_age_default;
                END IF;

                -- Calculate total user count and average age
                SELECT
                    COUNT(*) AS total_user_count,
                    AVG(age) AS average_user_age
                INTO
                    total_user_count,
                    average_user_age
                FROM
                    users
                WHERE
                    age >= min_age
                    AND age <= max_age
                    AND country = country;  -- Bug: should be countryParam or different variable name

                -- Handle case when no users meet criteria
                IF total_user_count = 0 THEN
                    SET average_user_age = NULL;
                END IF;

                -- Return summary report
                SELECT
                    total_user_count AS total_user_count,
                    average_user_age AS average_user_age;

            END$$

            DELIMITER ;
            """;

    /*
     * Sample usage:
     * 
     * -- Call with all parameters
     * CALL filter_users_summary(24, 32, 'USA');
     * -- Expected output: total_user_count=2, average_user_age=26.0 (Alice: 28,
     * Bob: 24)
     * 
     * -- Call with missing max_age (will use highest age in table)
     * CALL filter_users_summary(25, NULL, 'Canada');
     * -- Expected output: total_user_count=2, average_user_age=30.5 (Charlie: 32,
     * Eva: 29)
     * 
     * -- Call with no matching users
     * CALL filter_users_summary(40, 50, 'USA');
     * -- Expected output: total_user_count=0, average_user_age=NULL
     */

    /*
     * Sample data for testing:
     * 
     * CREATE TABLE users (
     * id INT PRIMARY KEY,
     * name VARCHAR(100),
     * age INT,
     * email VARCHAR(200),
     * country VARCHAR(100)
     * );
     * 
     * INSERT INTO users VALUES
     * (1, 'Alice', 28, 'alice@example.com', 'USA'),
     * (2, 'Bob', 24, 'bob@example.com', 'USA'),
     * (3, 'Charlie', 32, 'charlie@example.com', 'Canada'),
     * (4, 'Diana', 35, 'diana@example.com', 'USA'),
     * (5, 'Eva', 29, 'eva@example.com', 'Canada');
     */

    public static void main(String[] args) {
        System.out.println("Stored Procedure SQL:");
        System.out.println(STORED_PROCEDURE);
    }
}
