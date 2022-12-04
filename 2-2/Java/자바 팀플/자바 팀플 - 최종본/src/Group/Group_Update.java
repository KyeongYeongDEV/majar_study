package Group;

import java.sql.SQLException;

import static main.CalendarSwing.*;
import static main.CalendarSwing.stmt;

public class Group_Update {
    public String group_update() throws SQLException {



        String sql2 = "UPDATE member SET member_group= " +"'"+update_name.getText()+"', "+
                "member_group_code = "+Integer.parseInt(update_code.getText())+
                " WHERE member_group = "+"'"+group_name.getText()+"'";

        String sql3 = "UPDATE member SET member_group_check = "+"'"+update_name.getText()+"', "+
                "member_group_code = "+Integer.parseInt(update_code.getText())+
                " WHERE member_group_check = "+"'"+group_name.getText()+"'";
        stmt.executeUpdate(sql2);
        stmt.executeUpdate(sql3);
        return "성공!";

    }
}
