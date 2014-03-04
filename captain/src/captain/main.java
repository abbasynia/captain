package captain;

import java.sql.*;

public class main {
	static Connection conn;
	public static void main(String [] args){
		String[] S = {"a","b","c","d","e","f","g","h","i","j","k","l","m", "n", "o", "p"};
		String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/";
        String dbName = "sql331497";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "sql331497";
        String password =  "sI2*yG2*";
        try {
        Class.forName(driver).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            }
        try{
        Connection conn = DriverManager.getConnection(url+dbName,userName,password);
        Statement st = conn.createStatement();
        try{
		st.executeUpdate(hospital(S[0],S[1])); } catch (Exception e) {
        	System.out.println("HOSPITAL RECORD DUPLICATE");
        }
		 try{
		st.executeUpdate(doctors(S[2],S[3],S[4])); } catch (Exception e) {
        	System.out.println("DOCTOR RECORD DUPLICATE");
        }
		try{
		st.executeUpdate(patient(S[5],S[6],S[7],"1",S[15],S[15])); } catch (Exception e) {
        	System.out.println("PATIENT RECORD DUPLICATE");
        }
		st.executeUpdate(sensors(S[8],S[9],S[10],S[11],S[12],"1"));
        conn.close();
        } catch (Exception e) {
        	System.out.println("Empty set.");
        }
	}
	
	public static String hospital(String trustCode, String name){
		return ("INSERT INTO  `sql331497`.`1-Hospital` (`NHS Trust Code` ,`Hospital Name`) VALUES ('"+trustCode+"','"+name+"');");
	}
	
	public static String doctors(String id, String name, String trustCode){
		return ("INSERT INTO  `sql331497`.`2-Doctors` (`Doctor ID` ,`Doctor Name`,`Hospital Trust Code`) VALUES ('"+id+"','"+name+"','"+trustCode+"');");
	}
	
	public static String patient(String id, String Pname, String Dname, String age, String cond, String date){
		return ("INSERT INTO  `sql331497`.`3-Patient` (`Patient ID` ,`Patient Name`,`Doctor's Name`,`Age`,`Medical Condition`,`Date Admitted`) VALUES ('"+id+"','"+Pname+"','"+Dname+"','"+age+"','"+cond+"','"+date+"');");
	}
	
	public static String sensors(String cNo, String Pid, String device, String reading, String time, String warn){
		return ("INSERT INTO  `sql331497`.`4-Sensors` (`Captain Number`, `Patient ID`, `Device Name`, `Reading`, `Time Stamp`,`Warning`) VALUES ('"+cNo+"','"+Pid+"','"+device+"','"+reading+"','"+time+"','"+warn+"');");
	}
	
}
