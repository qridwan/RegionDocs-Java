import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DB_UTIL {
	private Connection dbConnection;

	public DB_UTIL() {
		dbConnection = DBConnector.getDBConnection();
	}

	public void closeDB() {
		try {
			dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int checkUser(String uname, String pass) {
		Connection dbConnection = null;
		Statement statement = null;
		int count = 0;
		try {

			dbConnection = DBConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "SELECT username from users " + "where username = '" + uname + "' and password = '" + pass
					+ "'";
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				count++;
			}
			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return count;
	}

	public void insertDistrict(String divName, String distName) {
		Connection dbConnection = null;
		Statement statement = null;
		try {

			dbConnection = DBConnector.getDBConnection();

		    ResultSet resultSet = null;
		    
			if (dbConnection == null)
				System.exit(1);

			statement = dbConnection.createStatement();
			
			// Find the division ID based on the division name
	        String findDivisionIdSql = "SELECT id FROM divisions WHERE name = '" + divName + "'";
	        resultSet = statement.executeQuery(findDivisionIdSql);

	        String divId = ""; // Initialize divId to an empty string

	        if (resultSet.next()) {
	            divId = resultSet.getString("id"); // Retrieve the division ID
	        }

			String sql = "insert into districts (name, division_id) values " + "('" + distName + "' , '" + divId
					+ "')";
			
			statement.executeUpdate(sql);

			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public String[] getDistrictList() {
	    Connection dbConnection = null;
	    Statement statement = null;
	    ArrayList<String> resultList = new ArrayList<>(); // Use an ArrayList to store district names

	    try {
	        dbConnection = DBConnector.getDBConnection();
	        if (dbConnection == null)
	            System.exit(1);
	        String sql = "SELECT d.name AS district_name FROM districts d";

	        statement = dbConnection.createStatement();
	        ResultSet rs = statement.executeQuery(sql);
	        while (rs.next()) {
	            String tempDist = rs.getString("district_name");
	            resultList.add(tempDist); // Add district name to the ArrayList
	        }
	        if (statement != null)
	            statement.close();

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }

	    // Convert the ArrayList to an array before returning it
	    String[] result = resultList.toArray(new String[resultList.size()]);
	    
	    return result;
	}
	
	public String[] getDivisionList() {
	    Connection dbConnection = null;
	    Statement statement = null;
	    ArrayList<String> resultList = new ArrayList<>(); // Use an ArrayList to store district names

	    try {
	        dbConnection = DBConnector.getDBConnection();
	        if (dbConnection == null)
	            System.exit(1);
	        String sql = "SELECT d.name AS division_name FROM divisions d";

	        statement = dbConnection.createStatement();
	        ResultSet rs = statement.executeQuery(sql);
	        while (rs.next()) {
	            String tempDist = rs.getString("division_name");
	            resultList.add(tempDist); // Add district name to the ArrayList
	        }
	        if (statement != null)
	            statement.close();

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }

	    // Convert the ArrayList to an array before returning it
	    String[] result = resultList.toArray(new String[resultList.size()]);
	    
	    return result;
	}

	public DefaultTableModel getDistrict() {
		Connection dbConnection = null;
		Statement statement = null;

		DefaultTableModel model = new DefaultTableModel();
		String tempDiv;
		String tempDist;
		int count = 0;
		model.addColumn("ID");
		model.addColumn("District");
		model.addColumn("Division");
		try {

			dbConnection = DBConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "SELECT d.id AS district_id, d.name AS district_name, d.division_id, dv.name AS division_name "
					+ "FROM districts d " + "JOIN divisions dv ON d.division_id = dv.id";

			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				tempDiv = rs.getString("division_name");
				tempDist = rs.getString("district_name");
				String tempId = rs.getString("district_id");
				model.addRow(new Object[] { tempId, tempDist, tempDiv });
				count++;
			}
			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		System.out.println(count);
		return model;
	}
	
	
	public DefaultTableModel getUpazilla() {
		Connection dbConnection = null;
		Statement statement = null;

		DefaultTableModel model = new DefaultTableModel();
		String tempDiv;
		String tempDist;
		int count = 0;
		model.addColumn("ID");
        model.addColumn("Division");
        model.addColumn("District");
        model.addColumn("Upazilla");
		try {

			dbConnection = DBConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "SELECT u.id AS upazilla_id, u.name AS upazilla_name, dis.name AS district_name, dv.name AS division_name "
					+ "FROM upazillas u " + "JOIN divisions dv ON u.division_id = dv.id "+ "JOIN districts dis ON dis.id = u.district_id ";

			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				tempDiv = rs.getString("division_name");
				tempDist = rs.getString("district_name");
				String tempId = rs.getString("upazilla_id");
				String tempUp = rs.getString("upazilla_name");
				model.addRow(new Object[] { tempId, tempDist, tempDiv,tempUp });
				count++;
			}
			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		System.out.println(count);
		return model;
	}
	
	
	public DefaultTableModel getEmployees() {
		Connection dbConnection = null;
		Statement statement = null;

		DefaultTableModel model = new DefaultTableModel();
		String tempDiv;
		String tempDist;
		int count = 0;
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("NID");
		model.addColumn("dob");
		model.addColumn("gender");
		model.addColumn("phone");
		model.addColumn("Email");
		model.addColumn("Division");
		model.addColumn("District");
		model.addColumn("Upazilla");
		model.addColumn("Photo");
		try {

			dbConnection = DBConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "SELECT e.id AS emp_id, fName AS fullname, e.DoB AS DoB, e.gender, e.NID, e.phone, e.email, e.photo, dv.name AS division_name, dis.name AS district_name, u.name AS upazilla_name "
				    + "FROM employees e "
				    + "JOIN divisions dv ON e.division_id = dv.id "
				    + "JOIN districts dis ON dis.id = e.district_id "
				    + "JOIN upazillas u ON u.id = e.upazilla_id";

			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				tempDiv = rs.getString("division_name");
				tempDist = rs.getString("district_name");
				String tempUp = rs.getString("upazilla_name");
				String tempId = rs.getString("emp_id");
				String fullName = rs.getString("fullname");
				String dob = rs.getString("DoB");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String photo = rs.getString("photo");
				String NID = rs.getString("NID");
				
				model.addRow(new Object[] { tempId,fullName,NID,dob,gender,phone,email, tempDiv, tempDist, tempUp, photo });
				count++;
			}
			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		System.out.println(count);
		return model;
	}
}
