package tr.com.siparis.database.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import tr.com.siparis.database.model.corba;

public class CorbaDaoImp  implements IDao<corba, Integer>{

	private final Optional<Connection> connection;
	
	public CorbaDaoImp() {
		super();
		System.out.println("corbaDaoImp.corbaDaoImp()");
		this.connection = JdbcConnection.getConnection();
	}
	@Override
	public Optional<corba> get(int id) {
		// TODO Auto-generated method stub
		return connection.flatMap(conn -> {
	        Optional<corba> corba = Optional.empty();
	        String sql = "SELECT * FROM \"corba\" WHERE \"corbaid\" = " + id;

	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            if (resultSet.next()) {
	                String corbaadi = resultSet.getString("corbaadi");
	                corba = Optional.of(
	                    new corba(id, corbaadi));

	                System.out.println("corbaDaoImp.get() ... Found  in database : " + corba.get());
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }

	        return corba;
	    });
	}

	@Override
	public Collection<corba> getAll() {
		Collection<corba> corbalist = new ArrayList<>();
	    String sql = "SELECT * FROM \"corba\" ORDER BY \"corbaadi\"";

	    connection.ifPresent(conn -> {
	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            while (resultSet.next()) {
	                int corbaid = resultSet.getInt("corbaid");
	                String corbaadi = resultSet.getString("corbaadi");

	                corba corba = new corba(corbaid, corbaadi);

	                corbalist.add(corba);
	                System.out.println("corbaDaoImp.getAll().... Found in database : " + corbaadi);
	            }

	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    });

	    return corbalist;
	}

	@Override
	public Optional<Integer> save(corba t) {
		String message = "The corba to be added should not be null";
        corba nonNullcorba= Objects.requireNonNull(t, message);
        String sql = "INSERT INTO "
                + "\"corba\"(\"corbaadi\""
                + "VALUES(?)";//1-2-3-4

        return connection.flatMap(conn -> {
            Optional<Integer> generatedId = Optional.empty();

            try (PreparedStatement statement =
                 conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, nonNullcorba.getCorbaadi());
                int numberOfInsertedRows = statement.executeUpdate();

                // Retrieve the auto-generated id
                if (numberOfInsertedRows > 0) {
                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            generatedId = Optional.of(resultSet.getInt(1));
                        }
                    }
                }
                System.out.println("corbaDaoImp.save()... created successfully? ");

            } catch (SQLException ex) {
            	ex.printStackTrace();
            }

            return generatedId;
        });
	}

	@Override
	public boolean update(corba t) {
		 String message = "The kullanici to be updated should not be null";
		 corba nonNullcorba = Objects.requireNonNull(t, message);
		    String sql = "UPDATE \"corba\" "
		            + "SET "
		            + "\"corbaadi\" = ?"
		            + "WHERE "
		            + "\"corbaid\" = ?";

		    if(connection.isPresent()) {

		        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

		        	statement.setString(1, nonNullcorba.getCorbaadi());

		            int numberOfUpdatedRows = statement.executeUpdate();

		            System.out.println("corbaDaoImp.update()...Was the Kullanici updated successfully  numberOfUpdatedRows :  " + numberOfUpdatedRows);


		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            return false;
		        }
		    
		    }else {
		    	try {
					throw new Exception("connection is null !!!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
		    }
		    return true;
	}

	@Override
	public boolean delete(corba t) {
		String message = "The corba to be deleted should not be null";
		corba nonNullcorba = Objects.requireNonNull(t, message);
	    String sql = "DELETE FROM \"corba\" WHERE \"corbaid\" = ?";

	    if(connection.isPresent()) {

	        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

	            statement.setInt(1, nonNullcorba.getCorbaid());

	            int numberOfDeletedRows = statement.executeUpdate();
	            
	            System.out.println("corbaDaoImp.delete()....Was the corba deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);

	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        	return false;
	        }
	    
	    }else {
	    	try {
				throw new Exception("connection is null!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	    }
	    return true;
//	    connection.ifPresent(conn -> {
//	        try (PreparedStatement statement = conn.prepareStatement(sql)) {
//
//	            statement.setInt(1, nonNullKullanici.getKullanici_id());
//
//	            int numberOfDeletedRows = statement.executeUpdate();
//	            
//	            System.out.println("corbaDaoImp.delete()....Was the corba deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
//
//	        } catch (SQLException ex) {
//	        	ex.printStackTrace();
//	        }
//	    });
	}

}
