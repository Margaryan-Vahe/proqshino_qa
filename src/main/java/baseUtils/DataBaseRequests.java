package baseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static baseUtils.Data.*;

public class DataBaseRequests {

    public static ArrayList<String> getMasterSystemDBCredentials(boolean isProd) {
        ArrayList<String> databaseCredentials = new ArrayList<>();
        if (isProd) {
            databaseCredentials.add(MS_DB_PROD_URL);
            databaseCredentials.add(MS_DB_PROD_USER);
            databaseCredentials.add(MS_DB_PROD_PASSWORD);
        } else {
            databaseCredentials.add(MS_DB_DEV_URL);
            databaseCredentials.add(MS_DB_DEV_USER);
            databaseCredentials.add(MS_DB_DEV_PASSWORD);
        }
        return databaseCredentials;
    }

    public static String getUserId(String phone, boolean isProd) {
        ArrayList<String> databaseCredentials = getMasterSystemDBCredentials(isProd);
        String idColumn = "";
        try {
            Connection connection = DriverManager.getConnection(databaseCredentials.get(0), databaseCredentials.get(1), databaseCredentials.get(2));
            // Запросы к базе данных
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "select * " +
                                "from public.jhi_user " +
                                "where login like ('%" + phone + "')");
                while (resultSet.next()) {
                    // Получение значений столбцов из текущей строки результата
                    idColumn = resultSet.getString("id");
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idColumn;
    }

    public static List<String> getAuthority(boolean isProd) {
        ArrayList<String> databaseCredentials = getMasterSystemDBCredentials(isProd);
        List<String> authorityName = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(databaseCredentials.get(0), databaseCredentials.get(1), databaseCredentials.get(2));
            // Запросы к базе данных
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "select * " +
                                "from jhi_authority " +
                                "where description is not NULL");
                while (resultSet.next()) {
                    // Получение значений столбцов из текущей строки результата
                    authorityName.add(resultSet.getString("name"));
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorityName;
    }

    public static List<String> getUserTypeAuthority(int userTypeId, boolean isProd) {
        ArrayList<String> databaseCredentials = getMasterSystemDBCredentials(isProd);
        List<String> userTypeAuthority = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(databaseCredentials.get(0), databaseCredentials.get(1), databaseCredentials.get(2));
            // Запросы к базе данных
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "select * " +
                                "from user_type_authority " +
                                "where user_type_id = '" + userTypeId + "'");
                while (resultSet.next()) {
                    // Получение значений столбцов из текущей строки результата
                    userTypeAuthority.add(resultSet.getString("authority_name"));
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userTypeAuthority;
    }

    public static String getUserAuthority(String userId, boolean isProd) {
        ArrayList<String> databaseCredentials = getMasterSystemDBCredentials(isProd);
        String userIdColumn = "";
        try {
            Connection connection = DriverManager.getConnection(databaseCredentials.get(0), databaseCredentials.get(1), databaseCredentials.get(2));
            // Запросы к базе данных
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "select * " +
                                "from public.jhi_user_authority " +
                                "where user_id = '" + userId + "'");
                while (resultSet.next()) {
                    // Получение значений столбцов из текущей строки результата
                    userIdColumn = resultSet.getString("user_id");
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userIdColumn;
    }

    public static void deleteUserAuthority(String userId, boolean isProd) {
        ArrayList<String> databaseCredentials = getMasterSystemDBCredentials(isProd);
        logInfo("Попытка удаления записей из jhi_user_authority для userId: {}", userId);
        // Используем try-with-resources для корректного закрытия ресурсов
        try (Connection connection = DriverManager.getConnection(
                databaseCredentials.get(0),
                databaseCredentials.get(1),
                databaseCredentials.get(2))) {

            try (Statement statement = connection.createStatement()) {
                String sql = "DELETE FROM public.jhi_user_authority WHERE user_id = '" + userId + "'";
                int rowsAffected = statement.executeUpdate(sql);

                if (rowsAffected > 0) {
                    logInfo("Удалено {} записей для userId: {}", rowsAffected, userId);
                } else {
                    logError("Нет записей для удаления с userId: {}", userId);
                    throw new AssertionError("Нет записей для удаления с userId: " + userId);
                }
            } catch (SQLException e) {
                logError("Ошибка выполнения запроса удаления для userId: {}", userId);
                throw new AssertionError("Ошибка удаления данных для userId: " + userId, e);
            }
        } catch (SQLException e) {
            logError("Ошибка подключения к базе данных: {}", e.getMessage());
            throw new AssertionError("Ошибка подключения к базе данных", e);
        } catch (Exception e) {
            logError("Непредвиденная ошибка при удалении записей для userId: {}", userId);
            throw new RuntimeException("Непредвиденная ошибка при удалении записей для userId: " + userId, e);
        }
    }

    public static String getUserPlaces(String userId, boolean isProd) {
        ArrayList<String> databaseCredentials = getMasterSystemDBCredentials(isProd);
        String idColumn = "";
        try {
            Connection connection = DriverManager.getConnection(databaseCredentials.get(0), databaseCredentials.get(1), databaseCredentials.get(2));
            // Запросы к базе данных
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "select * " +
                                "from public.user_place " +
                                "where user_id = '" + userId + "'");
                while (resultSet.next()) {
                    // Получение значений столбцов из текущей строки результата
                    idColumn = resultSet.getString("id");
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idColumn;
    }

    public static void deleteUserPlaces(String userId, boolean isProd) {
        ArrayList<String> databaseCredentials = getMasterSystemDBCredentials(isProd);
        logInfo("Попытка удаления записей из user_place для userId: {}", userId);
        try (Connection connection = DriverManager.getConnection(
                databaseCredentials.get(0),
                databaseCredentials.get(1),
                databaseCredentials.get(2));
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM public.user_place WHERE user_id = '" + userId + "'";
            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                logInfo("Удалено {} записей из таблицы user_place для userId: {}", rowsAffected, userId);
            } else {
                logError("Нет записей для удаления из таблицы user_place для userId: {}", userId);
            }
        } catch (SQLException e) {
            logError("Ошибка удаления записей из таблицы user_place для userId: {}. Ошибка: {}", userId, e.getMessage());
            throw new RuntimeException("Ошибка удаления записей из таблицы user_place", e);
        }
    }

    public static String getUserRequests(String userId, boolean isProd) {
        ArrayList<String> databaseCredentials = getMasterSystemDBCredentials(isProd);
        String idColumn = "";
        try {
            Connection connection = DriverManager.getConnection(databaseCredentials.get(0), databaseCredentials.get(1), databaseCredentials.get(2));
            // Запросы к базе данных
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "select * " +
                                "from public.user_request " +
                                "where user_id = '" + userId + "' " +
                                "order by created_at DESC " +
                                "limit 1");
                while (resultSet.next()) {
                    // Получение значений столбцов из текущей строки результата
                    idColumn = resultSet.getString("id");
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idColumn;
    }

    public static String getUserRequestsOneCNumber(String userId, boolean isProd) {
        ArrayList<String> databaseCredentials = getMasterSystemDBCredentials(isProd);
        String idColumn = "";
        try {
            Connection connection = DriverManager.getConnection(databaseCredentials.get(0), databaseCredentials.get(1), databaseCredentials.get(2));
            // Запросы к базе данных
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(
                        "select * " +
                                "from public.user_request " +
                                "where user_id = '" + userId + "' " +
                                "order by created_at DESC " +
                                "limit 1");
                while (resultSet.next()) {
                    // Получение значений столбцов из текущей строки результата
                    idColumn = resultSet.getString("one_c_number");
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idColumn;
    }

    public static void deleteUserRequest(String userId, boolean isProd) {
        ArrayList<String> databaseCredentials = getMasterSystemDBCredentials(isProd);
        logInfo("Попытка удаления записей из user_request для userId: {}", userId);
        try (Connection connection = DriverManager.getConnection(
                databaseCredentials.get(0),
                databaseCredentials.get(1),
                databaseCredentials.get(2));
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM public.user_request WHERE user_id = '" + userId + "'";
            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                logInfo("Удалено {} записей из таблицы user_request для userId: {}", rowsAffected, userId);
            } else {
                logError("Нет записей для удаления из таблицы user_request для userId: {}", userId);
            }
        } catch (SQLException e) {
            logError("Ошибка удаления записей из таблицы user_request для userId: {}. Ошибка: {}", userId, e.getMessage());
            throw new RuntimeException("Ошибка удаления записей из таблицы user_request", e);
        }
    }

    public static void deleteUser(String userId, boolean isProd) {
        ArrayList<String> databaseCredentials = getMasterSystemDBCredentials(isProd);
        logInfo("Попытка удаления записей из jhi_user для userId: {}", userId);
        try (Connection connection = DriverManager.getConnection(
                databaseCredentials.get(0),
                databaseCredentials.get(1),
                databaseCredentials.get(2));
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM public.jhi_user WHERE id = '" + userId + "'";
            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                logInfo("Пользователь с userId: {} успешно удалён", userId);
            } else {
                logError("Пользователь с userId: {} не найден для удаления", userId);
            }
        } catch (SQLException e) {
            logError("Ошибка удаления пользователя с userId: {}. Ошибка: {}", userId, e.getMessage());
            throw new RuntimeException("Ошибка удаления пользователя", e);
        }
    }

    public static void deleteUserWithData(String phone, boolean isProd) {
        String userId = getUserId(phone, isProd);
        if (userId.isEmpty()) {
            logInfo("Пользователь с phone: {} не найден", phone);
        } else {
            if (!getUserAuthority(userId, isProd).isEmpty()) {
                deleteUserAuthority(userId, isProd);
            }
            if (!getUserPlaces(userId, isProd).isEmpty()) {
                deleteUserPlaces(userId, isProd);
            }
            deleteUser(userId, isProd);
        }
    }

    private static void logInfo(String format, Object... args) {
        // Заменяем фигурные скобки "{}" на "%s" и форматируем строку
        String message = String.format(format.replace("{}", "%s"), args);
        System.out.println("[INFO] " + message);
    }

    private static void logError(String format, Object... args) {
        String message = String.format(format.replace("{}", "%s"), args);
        System.err.println("[ERROR] " + message);
    }

}
