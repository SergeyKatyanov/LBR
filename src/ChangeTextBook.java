import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChangeTextBook {

    public void createTextBook(String sql, Connection con){
        try{sql = "INSERT INTO public.Library(\n" +
                "\tid, name, code)\n" +
                "\tVALUES (?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, 8);
            statement.setString(2, "sasha");
            statement.setString(3,"a");
            int i = statement.executeUpdate();
            System.out.println("Добавлено строк" + i);}
        catch(Exception e){}
    }
    public void updateTextBook(String sql, Connection con){
        try{String sqlUpdate="UPDATE public.Library\n" +
                "\tSET  name='Jon' \n"+
                "\tWHERE code='c';";

            Statement stmt = con.createStatement();// выполни запрос
            int i = stmt.executeUpdate(sqlUpdate);
            System.out.println("Обновлено строк" + i);}
        catch(Exception e){}
    }
    public void deleteTextBook(String sql, Connection con){
        try{ String sqlDelete="DELETE FROM public.Library\n" +
                "\tWHERE code='a';";
            Statement stmt = con.createStatement();
            int i = stmt.executeUpdate(sqlDelete);
            System.out.println("Удалено строк" + i);}
        catch(Exception e){}
    }

    public List<Students> getTextBook(){return new ArrayList<>();}
}


