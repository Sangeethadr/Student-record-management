import java.sql.*;
import java.util.ArrayList;
class DataAcess
{
	Connection con;
	Statement st;
    DataAcess(String path,String url,String un,String pw)
	{
		try{
			Class.forName(path);
			con=DriverManager.getConnection(url,un,pw);
			st=con.createStatement();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
public int getUserType(String un,String pw)
	{
	int typ=0;
	try
	{
         System.out.println("inside try of getUserType");
		String sql="select utype from user where uname = '" + un + "' and pword = '" + pw + "'";
     System.out.println(sql);
	  ResultSet rs=st.executeQuery(sql);
	  System.out.println("resultset obj got");
	  if(rs.next())
		{
		  typ=rs.getInt(1);
		}
		
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
    return(typ);
	}
   public boolean createuser(int uidno,String un,String pw,int utyp)
	{
	   boolean flag=false;
	   try
	   {
		 String sql="insert into user values(" + uidno + ",'" + un + "','" + pw + "'," + utyp +")";
		 System.out.println(sql);
		 st.executeUpdate(sql);
		 flag=true;
	   }
	   catch (Exception e)
	   {
		   System.out.println(e);
	   }
      return(flag);
	}

     public boolean insertMarks(int sidno,String sname,int s1,int s2,int s3,int s4,int s5,int s6)
	{
   boolean fl=false;
   try
   {
	 int tmarks=s1+s2+s3+s4+s5+s6;
	 String sql="insert into marks values("+ sidno + ",'" + sname + "'," + s1 +"," + s2 + "," + s3 + "," + s4 + "," + s5 + "," + s6 + "," + tmarks +")";
	 System.out.println(sql);
	 st.executeUpdate(sql);
	 fl=true;
   }
   catch (Exception e)
   {
	   System.out.println(e);
   }
   return(fl);
	}
   
	public boolean insertAttendence(int sidno,String sname,int att)
	{
   boolean fl=false;
   try
   {
	 String sql="insert into attendence values(" + sidno + ",'" + sname + "'," + att + ")";
	 System.out.println(sql);
	 st.executeUpdate(sql);
	 fl=true;
   }
   catch (Exception e)
   {
	   System.out.println(e);
   }
   return(fl);
	}
  public int[] getStudentMarks(int sidno)
	{
      int[] marks=new int[7];
	  try
	  {
		String sql="select * from marks where sidno=" + sidno ;
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		  {
			marks[0]=rs.getInt(3);
			marks[1]=rs.getInt(4);
  			marks[2]=rs.getInt(5);
            marks[3]=rs.getInt(6);
            marks[4]=rs.getInt(7);
			marks[5]=rs.getInt(8);
			marks[6]=rs.getInt(9);
		  }
	  }
	  catch (Exception e)
	  {
		  System.out.println(e);
	  }
      return(marks);
    }

   public int getUserId(String un,String pw)
	{
      int id=0;
	  try
	  {
		String sql="select uidno from user where uname= '" + un + "' and pword= '" + pw +"'";
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		  {
			id=rs.getInt(1);
		  }
	  }
	  catch (Exception e)
	  {
		  System.out.println(e);
	  }
	  return(id);
	}

   public ArrayList<Tmarks> getAllMarks()
	{
	   ArrayList<Tmarks> a1=new ArrayList<Tmarks>();
	   try
	   {
		String sql="select sidno,sname,tmarks from marks";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		   {
			int sid=rs.getInt(1);
			String sn=rs.getString(2);
			int mk=rs.getInt(3);
            
			Tmarks t1=new Tmarks();
			t1.setSidno(sid);
			t1.setSname(sn);
            t1.setTmks(mk);

			a1.add(t1);
		   }

	   }
	   catch (Exception e)
	   {
		   System.out.println(e);
	   }
       return(a1);
	}
       
   public void close()
	{
		try
		{
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}