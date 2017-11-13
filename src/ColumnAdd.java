import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by chang on 2017-11-10.
 */
public class ColumnAdd {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + args[0]);
            Statement stmt = conn.createStatement();
            stmt.executeQuery("pragma journal_mode = DEFAULT");
            stmt.close();
            stmt = null;


            PreparedStatement pstmt1 = conn.prepareStatement("vacuum");
            pstmt1.setQueryTimeout(30);
            pstmt1.executeUpdate();
            //conn.commit();
            pstmt1.close();
            pstmt1 = null;

            StringBuilder sql = null;
            for(int i=1; i <= 16; i++){
                sql = new StringBuilder();
                sql.append("alter table file_info");
                sql.append(i);
                sql.append(" add sendfailcount integer");

                pstmt1 = conn.prepareStatement(sql.toString());
                pstmt1.executeUpdate();
                //conn.commit();
                pstmt1.close();
                pstmt1 = null;

                sql = new StringBuilder();
                sql.append("alter table file_info");
                sql.append(i);
                sql.append(" add insertdate text");

                pstmt1 = conn.prepareStatement(sql.toString());
                pstmt1.executeUpdate();
                //conn.commit();
                pstmt1.close();
                pstmt1 = null;

                sql = new StringBuilder();
                sql.append("update file_info");
                sql.append(i);
                sql.append(" set sendfailcount =0");

                pstmt1 = conn.prepareStatement(sql.toString());
                pstmt1.executeUpdate();
                //conn.commit();
                pstmt1.close();
                pstmt1 = null;
            }

            sql = new StringBuilder();
            sql.append("alter table server_policy");
            sql.append(" add insertdate text");

            pstmt1 = conn.prepareStatement(sql.toString());
            pstmt1.executeUpdate();
            //conn.commit();
            pstmt1.close();
            pstmt1 = null;

            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}