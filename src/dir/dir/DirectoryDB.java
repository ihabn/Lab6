package dir;

import java.sql.*;
import java.util.ArrayList;

public class DirectoryDB {

    private static String url = "jdbc:mysql://localhost/explorer?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "robot12345";

    public static ArrayList<Directory> select() {

        ArrayList<Directory> directorys = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM files");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String src = resultSet.getString(3);
                    Directory directory = new Directory(id, name, src);
                    directorys.add(directory);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return directorys;
    }
    public static Directory selectOne(int id) {

        Directory directory = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM files WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int dirId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String src = resultSet.getString(3);
                        directory = new Directory(dirId, name, src);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return directory;
    }
    public static int insert(Directory directory) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO files (name, src) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, directory.getName());
                    preparedStatement.setString(2, directory.getSrc());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Directory directory) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                String sql = "UPDATE files SET name = ?, src = ? WHERE name = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, directory.getName());
                    preparedStatement.setString(2, directory.getSrc());
                    preparedStatement.setInt(3, directory.getId());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM files WHERE name = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
