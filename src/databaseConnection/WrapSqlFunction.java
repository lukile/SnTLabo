package databaseConnection;

import java.sql.SQLException;

@FunctionalInterface
public interface WrapSqlFunction {
    void run() throws SQLException;
}