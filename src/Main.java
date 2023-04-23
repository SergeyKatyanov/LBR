import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        long index = 8;
        try {//блок кода, в котором может произойти исключение
            Class.forName("org.postgresql.Driver");//добавляем драйвер
            //localhost
            //db_name
            String url = "jdbc:postgresql://127.0.0.1:5432/Library";//адрес подключения
            String login = "postgres";
            String password = "1";
            Connection con = DriverManager.getConnection(url,login,password);//подключаем к базе
            System.out.println(con.getCatalog());// вывол на консоль как называется база
            try{////блок кода, в котором может произойти исключение

                String sql = "INSERT INTO public.Library(\n" +
                        "\tid, name, code)\n" +
                        "\tVALUES (?, ?, ?);";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setLong(1, index);
                statement.setString(2, "sasha");
                statement.setString(3,"a");
                int i = statement.executeUpdate();
                System.out.println("Добавлено строк" + i);
                String sqlUpdate="UPDATE public.Library\n" +
                        "\tSET  name='Jon' \n"+
                        "\tWHERE code='c';";

                Statement stmt = con.createStatement();// выполни запрос
                i = stmt.executeUpdate(sqlUpdate);
                System.out.println("Обновлено строк" + i);

                String sqlDelete="DELETE FROM public.Library\n" +
                        "\tWHERE code='a';";

                i = stmt.executeUpdate(sqlDelete);
                System.out.println("Удалено строк" + i);
                ResultSet rs = stmt.executeQuery("SELECT id, name, code\n" +
                        "\tFROM public.Library");//набор строк из таблицы
                //проверка наледующей строки
                while(rs.next()) {
                    //получить из набора строк строку и изненее конкретно значение
                    String str = rs.getLong("id")+ "\t" + rs.getString("name");
                    System.out.println(str);//вывод результата
                }
                rs.close();//зарытие резултсета
                stmt.close();//закрыли выполненя запроса
            }finally {//блок кода, который является необязательным, но при его наличии выполняется в любом случае независимо от результатов выполнения блока try
                con.close();//закрытие соединения с базой
            }
//блок кода, в котором происходит обработка исключения
        } catch (Exception e) {
            e.printStackTrace();}
    }
}

