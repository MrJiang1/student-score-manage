import java.sql.*;

public class AdminSQL {
	Connection con;
	Statement sta;
	ResultSet rs;
	String SQL;
//	String ident;
//	int stu_rows,tea_rows,dep_rows,cla_rows,sco_rows,les_rows;
	public AdminSQL(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[][] selectAll(String ident){
		String Sdata[][];
		String s[][]=new String[0][0];
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="select * from "+ident;
			rs=sta.executeQuery(SQL);
			ResultSetMetaData rs1=rs.getMetaData();
			int Scol=rs1.getColumnCount();     //��ȡ���ݵ�����
			rs.last();
			int Srows=rs.getRow();
			Sdata=new String[Srows][Scol];
			rs.beforeFirst();
			int j=0;
			while(rs.next()){
				for(int i=0;i<Scol;i++){
					Sdata[j][i]=rs.getString(i+1);
				}
				j++;
			}
			con.close();
			return Sdata;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String[] selectOneLine(String ident,String name,String id){
		String Sone[];
		String s[]=new String[0];
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="select * from "+ident+" where "+name+"="+id;
			rs=sta.executeQuery(SQL);
			ResultSetMetaData rs1=rs.getMetaData();
			int Sonecol=rs1.getColumnCount();
			Sone=new String[Sonecol];
			while(rs.next()){
				for(int i=0;i<Sonecol;i++){
					Sone[i]=rs.getString(i+1);
				}
			}
			con.close();
			return Sone;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String[] selectDepOneLine(String id,String las){
		String Sone[];
		String s[]=new String[0];
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="select * from department where Ժϵ��='"+id+"' and �༶��='"+las+"'";
			rs=sta.executeQuery(SQL);
			ResultSetMetaData rs1=rs.getMetaData();
			int Sonecol=rs1.getColumnCount();
			Sone=new String[Sonecol];
			while(rs.next()){
				for(int i=0;i<Sonecol;i++){
					Sone[i]=rs.getString(i+1);
				}
			}
			con.close();
			return Sone;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String[] selectClaOneLine(String id,String las){
		String Sone[];
		String s[]=new String[0];
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="select * from class where �༶��='"+id+"' and �γ̺�='"+las+"'";
			rs=sta.executeQuery(SQL);
			ResultSetMetaData rs1=rs.getMetaData();
			int Sonecol=rs1.getColumnCount();
			Sone=new String[Sonecol];
			while(rs.next()){
				for(int i=0;i<Sonecol;i++){
					Sone[i]=rs.getString(i+1);
				}
			}
			con.close();
			return Sone;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public String[] selectScoOneLine(String id,String las){
		String Sone[];
		String s[]=new String[0];
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="select * from score where ѧ��='"+id+"' and �γ̺�='"+las+"'";
			rs=sta.executeQuery(SQL);
			ResultSetMetaData rs1=rs.getMetaData();
			int Sonecol=rs1.getColumnCount();
			Sone=new String[Sonecol];
			while(rs.next()){
				for(int i=0;i<Sonecol;i++){
					Sone[i]=rs.getString(i+1);
				}
			}
			con.close();
			return Sone;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public void studentUpdate(String id1,String id,String name,String password,String sex,String dep,String cla,String tel,String QQ){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update student set ѧ��='"+id+"',����='"+name+"',����='"+password+"',�Ա�='"+sex+"',Ժϵ��='"+dep+"',�༶��='"+cla+"',�绰='"+tel+"',QQ='"+QQ+"' where ѧ��='"+id1+"'";
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public void teacherUpdate(String id1,String id,String name,String password,String sex,String dep,String tel,String QQ){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update teacher set ��ʦ��='"+id+"',����='"+name+"',����='"+password+"',�Ա�='"+sex+"',Ժϵ��='"+dep+"',�绰='"+tel+"',QQ='"+QQ+"' where ��ʦ��='"+id1+"'";
			
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void departmentUpdate(String id1,String cla1,String id,String name,String cla,String claname){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update department set Ժϵ��='"+id+"',Ժϵ��='"+name+"',�༶��='"+cla+"',�༶��='"+claname+"' where Ժϵ��='"+id1+"' and �༶��='"+cla1+"'";
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void classUpdate(String id1,String les1,String id,String name,String les,String tea){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update class set �༶��='"+id+"',�༶��='"+name+"',�γ̺�='"+les+"',��ʦ��='"+tea+"' where �༶��='"+id1+"' and �γ̺�='"+les1+"'";
			
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public void scoreUpdate(String id1,String les1,String id,String les,String tea,String sco){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update score set ѧ��='"+id+"',�γ̺�='"+les+"',��ʦ��='"+tea+"',����='"+sco+"' where ѧ��='"+id1+"' and �γ̺�='"+les1+"'";
			
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void lessonUpdate(String id1,String id,String name){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update lesson set �γ̺�='"+id+"',�γ���='"+name+"' where �γ̺�='"+id1+"'";
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void adminUpdate(String id,String name,String password,String sex,String tel,String QQ){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="update admin set ϵ����='"+name+"',����='"+password+"',�Ա�='"+sex+"',�绰='"+tel+"',QQ='"+QQ+"' where ϵ�ܺ�='"+id+"'";
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

	public void departmentInsert(String id,String name,String cla,String claname){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="insert into department values('"+id+"','"+name+"','"+cla+"','"+claname+"')";
			
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public void lessonInsert(String id,String name){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="insert into lesson values('"+id+"','"+name+"')";
			
			sta.executeUpdate(SQL);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void deletedOne(String ident,String z,String id){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="delete from "+ident+" where "+z+"='"+id+"'";
			sta.executeUpdate(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteDepOne(String z,String id){
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","1234");
			sta=con.createStatement();
			SQL="delete from department where Ժϵ��='"+z+"' and �༶��='"+id+"'";
			sta.executeUpdate(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
