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

import tr.com.siparis.database.model.masa;

public class MasaDaoImp  implements IDao<masa, Integer>{

	private final Optional<Connection> connection;
	
	public MasaDaoImp() {
		super();
		System.out.println("masaDaoImp.masaDaoImp()");
		this.connection = JdbcConnection.getConnection();
	}
	@Override
	public Optional<masa> get(int id) {
		// TODO Auto-generated method stub
		return connection.flatMap(conn -> {
	        Optional<masa> masa = Optional.empty();
	        String sql = "SELECT * FROM \"masa\" WHERE \"masaid\" = " + id;

	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            if (resultSet.next()) {
	                String masaadi = resultSet.getString("masaadi");
	                masa = Optional.of(
	                    new masa(id, masaadi));

	                System.out.println("masaDaoImp.get() ... Found  in database : " + masa.get());
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }

	        return masa;
	    });
	}

	@Override
	public Collection<masa> getAll() {
		Collection<masa> masalist = new ArrayList<>();
	    String sql = "SELECT * FROM \"masa\" ORDER BY \"masaadi\"";

	    connection.ifPresent(conn -> {
	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            while (resultSet.next()) {
	                int masaid = resultSet.getInt("masaid");
	                String masaadi = resultSet.getString("masaadi");

	                masa masa = new masa(masaid, masaadi);

	                masalist.add(masa);
	                System.out.println("masaDaoImp.getAll().... Found in database : " + masaadi);
	            }

	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    });

	    return masalist;
	}

	@Override
	public Optional<Integer> save(masa t) {
		String message = "The masa to be added should not be null";
        masa nonNullmasa= Objects.requireNonNull(t, message);
        String sql = "INSERT INTO "
                + "\"masa\"(\"masaadi\""
                + "VALUES(?)";//1-2-3-4

        return connection.flatMap(conn -> {
            Optional<Integer> generatedId = Optional.empty();

            try (PreparedStatement statement =
                 conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, nonNullmasa.getMasaadi());
                int numberOfInsertedRows = statement.executeUpdate();

                // Retrieve the auto-generated id
                if (numberOfInsertedRows > 0) {
                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            generatedId = Optional.of(resultSet.getInt(1));
                        }
                    }
                }
                System.out.println("masaDaoImp.save()... created successfully? ");

            } catch (SQLException ex) {
            	ex.printStackTrace();
            }

            return generatedId;
        });
	}

	@Override
	public boolean update(masa t) {
		 String message = "The kullanici to be updated should not be null";
		 masa nonNullmasa = Objects.requireNonNull(t, message);
		    String sql = "UPDATE \"masa\" "
		            + "SET "
		            + "\"masaadi\" = ?"
		            + "WHERE "
		            + "\"masaid\" = ?";

		    if(connection.isPresent()) {

		        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

		        	statement.setString(1, nonNullmasa.getMasaadi());

		            int numberOfUpdatedRows = statement.executeUpdate();

		            System.out.println("masaDaoImp.update()...Was the Kullanici updated successfully  numberOfUpdatedRows :  " + numberOfUpdatedRows);


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
	public boolean delete(masa t) {
		String message = "The masa to be deleted should not be null";
		masa nonNullmasa = Objects.requireNonNull(t, message);
	    String sql = "DELETE FROM \"masa\" WHERE \"masaid\" = ?";

	    if(connection.isPresent()) {

	        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

	            statement.setInt(1, nonNullmasa.getMasaid());

	            int numberOfDeletedRows = statement.executeUpdate();
	            
	            System.out.println("masaDaoImp.delete()....Was the masa deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);

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
//	            System.out.println("masaDaoImp.delete()....Was the masa deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
//
//	        } catch (SQLException ex) {
//	        	ex.printStackTrace();
//	        }
//	    });
	}

}
