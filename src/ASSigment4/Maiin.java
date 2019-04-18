package ASSigment4;

import javafx.scene.Scene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Maiin {
    public static void main(String[] args) {

        try {
        Class.forName("com.mysql.jdbc.Driver");
        String URL ="jdbc:mysql://localhost:3306/t1808m";
        Connection conn= DriverManager.getConnection(URL,"NGuyenTruongadmin","anhtruong01");
            System.out.println("Co ton tai nguoi dung nay ! ");
        Statement statement =conn.createStatement();
            String insert_sql="INSERT INTO user (id,username,email,password,status)"+ "VALUES('3305895','Thao mai','badao14@yahoo.com','galam',0)";

            statement.executeUpdate(insert_sql);


            String sql="SELECT* FROM user";
            ResultSet rs=statement.executeQuery(sql);

            while (rs.next()){

                System.out.println("id : "+rs.getString("id"));
                System.out.println("username : "+rs.getString("username"));
                System.out.println("email : "+rs.getString("email"));
                System.out.println("password"+rs.getString("password"));
                System.out.println("status"+rs.getInt("status"));
            }
            System.out.println("Chọn 1 id để xóa .");
            String idd;
            Scanner nhap=new Scanner(System.in);
            idd=nhap.nextLine();
            if (idd==rs.getString("id")){
                int number;
                System.out.println("XÓa luôn nhập 1 còn chuyển status dạng 0 nhập 2");
                do {

                number=nhap.nextInt();
                if (number!=1||number!=0){
                    System.out.println("lua chon khong phu hop yeu cau nhap lai.");
                }
                else if (number==1){
                    String xoa="DELETE from user where idd=id";
                   statement.executeUpdate(xoa);
                }
                else if (number==0){
                    String capnhat="UPDATE user set status=0 where idd=id";
                    statement.executeUpdate(capnhat);
                }

                }while (number!=1||number!=0);
                 ;
            }
            else {
                System.out.println("Id không khớp");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
