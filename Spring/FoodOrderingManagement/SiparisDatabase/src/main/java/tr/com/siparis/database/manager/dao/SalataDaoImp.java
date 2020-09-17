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

import tr.com.siparis.database.model.salata;

public class SalataDaoImp  implements IDao<salata, Integer>{

	private final Optional<Connection> connection;
	
	public SalataDaoImp() {
		super();
		System.out.println("salataDaoImp.salataDaoImp()");
		this.connection = JdbcConnection.getConnection();
	}
	@Override
	public Optional<salata> get(int id) {
		// TODO Auto-generated method stub
		return connection.flatMap(conn -> {
	        Optional<salata> salata = Optional.empty();
	        String sql = "SELECT * FROM \"salata\" WHERE \"salataid\" = " + id;

	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            if (resultSet.next()) {
	                String salataadi = resultSet.getString("salataadi");
	                salata = Optional.of(
	                    new salata(id, salataadi));

	                System.out.println("salataDaoImp.get() ... Found  in database : " + salata.get());
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }

	        return salata;
	    });
	}

	@Override
	public Collection<salata> getAll() {
		Collection<salata> salatalist = new ArrayList<>();
	    String sql = "SELECT * FROM \"salata\" ORDER BY \"salataadi\"";

	    connection.ifPresent(conn -> {
	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            while (resultSet.next()) {
	                int salataid = resultSet.getInt("salataid");
	                String salataadi = resultSet.getString("salataadi");

	                salata salata = new salata(salataid, salataadi);

	                salatalist.add(salata);
	                System.out.println("salataDaoImp.getAll().... Found in database : " + salataadi);
	            }

	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    });

	    return salatalist;
	}

	@Override
	public Optional<Integer> save(salata t) {
		String message = "The salata to be added should not be null";
        salata nonNullsalata= Objects.requireNonNull(t, message);
        String sql = "INSERT INTO "
                + "\"salata\"(\"salataadi\""
                + "VALUES(?)";//1-2-3-4

        return connection.flatMap(conn -> {
            Optional<Integer> generatedId = Optional.empty();

            try (PreparedStatement statement =
                 conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, nonNullsalata.getSalataadi());
                int numberOfInsertedRows = statement.executeUpdate();

                // Retrieve the auto-generated id
                if (numberOfInsertedRows > 0) {
                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            generatedId = Optional.of(resultSet.getInt(1));
                        }
                    }
                }
                System.out.println("salataDaoImp.save()... created successfully? ");

            } catch (SQLException ex) {
            	ex.printStackTrace();
            }

            return generatedId;
        });
	}

	@Override
	public boolean update(salata t) {
		 String message = "The kullanici to be updated should not be null";
		 salata nonNullsalata = Objects.requireNonNull(t, message);
		    String sql = "UPDATE \"salata\" "
		            + "SET "
		            + "\"salataadi\" = ?"
		            + "WHERE "
		            + "\"salataid\" = ?";

		    if(connection.isPresent()) {

		        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

		        	statement.setString(1, nonNullsalata.getSalataadi());

		            int numberOfUpdatedRows = statement.executeUpdate();

		            System.out.println("salataDaoImp.update()...Was the Kullanici updated successfully  numberOfUpdatedRows :  " + numberOfUpdatedRows);


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
	public boolean delete(salata t) {
		String message = "The salata to be deleted should not be null";
		salata nonNullsalata = Objects.requireNonNull(t, message);
	    String sql = "DELETE FROM \"salata\" WHERE \"salataid\" = ?";

	    if(connection.isPresent()) {

	        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

	            statement.setInt(1, nonNullsalata.getSalataid());

	            int numberOfDeletedRows = statement.executeUpdate();
	            
	            System.out.println("salataDaoImp.delete()....Was the salata deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);

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
//	            System.out.println("salataDaoImp.delete()....Was the salata deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
//
//	        } catch (SQLException ex) {
//	        	ex.printStackTrace();
//	        }
//	    });
	}

}
