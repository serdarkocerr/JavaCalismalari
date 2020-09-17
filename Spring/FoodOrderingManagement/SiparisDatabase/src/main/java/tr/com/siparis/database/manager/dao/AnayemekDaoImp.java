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

import tr.com.siparis.database.model.anayemek;

public class AnayemekDaoImp  implements IDao<anayemek, Integer>{

	private final Optional<Connection> connection;
	
	public AnayemekDaoImp() {
		super();
		System.out.println("AnayemekDaoImp.AnayemekDaoImp()");
		this.connection = JdbcConnection.getConnection();
	}
	@Override
	public Optional<anayemek> get(int id) {
		// TODO Auto-generated method stub
		return connection.flatMap(conn -> {
	        Optional<anayemek> anayemek = Optional.empty();
	        String sql = "SELECT * FROM \"anayemek\" WHERE \"anayemekid\" = " + id;

	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            if (resultSet.next()) {
	                String anayemekadi = resultSet.getString("anayemekadi");
	                anayemek = Optional.of(
	                    new anayemek(id, anayemekadi));

	                System.out.println("AnayemekDaoImp.get() ... Found  in database : " + anayemek.get());
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }

	        return anayemek;
	    });
	}

	@Override
	public Collection<anayemek> getAll() {
		Collection<anayemek> anayemeklist = new ArrayList<>();
	    String sql = "SELECT * FROM \"anayemek\" ORDER BY \"anayemekadi\"";

	    connection.ifPresent(conn -> {
	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            while (resultSet.next()) {
	                int anayemekid = resultSet.getInt("anayemekid");
	                String anayemekadi = resultSet.getString("anayemekadi");

	                anayemek anayemek = new anayemek(anayemekid, anayemekadi);

	                anayemeklist.add(anayemek);
	                System.out.println("AnayemekDaoImp.getAll().... Found in database : " + anayemekadi);
	            }

	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    });

	    return anayemeklist;
	}

	@Override
	public Optional<Integer> save(anayemek t) {
		String message = "The anayemek to be added should not be null";
        anayemek nonNullAnayemek= Objects.requireNonNull(t, message);
        String sql = "INSERT INTO "
                + "\"anayemek\"(\"anayemekadi\""
                + "VALUES(?)";//1-2-3-4

        return connection.flatMap(conn -> {
            Optional<Integer> generatedId = Optional.empty();

            try (PreparedStatement statement =
                 conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, nonNullAnayemek.getAnayemekadi());
                int numberOfInsertedRows = statement.executeUpdate();

                // Retrieve the auto-generated id
                if (numberOfInsertedRows > 0) {
                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            generatedId = Optional.of(resultSet.getInt(1));
                        }
                    }
                }
                System.out.println("AnayemekDaoImp.save()... created successfully? ");

            } catch (SQLException ex) {
            	ex.printStackTrace();
            }

            return generatedId;
        });
	}

	@Override
	public boolean update(anayemek t) {
		 String message = "The kullanici to be updated should not be null";
		 anayemek nonNullanayemek = Objects.requireNonNull(t, message);
		    String sql = "UPDATE \"anayemek\" "
		            + "SET "
		            + "\"anayemekadi\" = ?"
		            + "WHERE "
		            + "\"anayemekid\" = ?";

		    if(connection.isPresent()) {

		        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

		        	statement.setString(1, nonNullanayemek.getAnayemekadi());

		            int numberOfUpdatedRows = statement.executeUpdate();

		            System.out.println("AnayemekDaoImp.update()...Was the Kullanici updated successfully  numberOfUpdatedRows :  " + numberOfUpdatedRows);


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
	public boolean delete(anayemek t) {
		String message = "The anayemek to be deleted should not be null";
		anayemek nonNullAnayemek = Objects.requireNonNull(t, message);
	    String sql = "DELETE FROM \"anayemek\" WHERE \"anayemekid\" = ?";

	    if(connection.isPresent()) {

	        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

	            statement.setInt(1, nonNullAnayemek.getAnayemekid());

	            int numberOfDeletedRows = statement.executeUpdate();
	            
	            System.out.println("AnayemekDaoImp.delete()....Was the anayemek deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);

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
//	            System.out.println("AnayemekDaoImp.delete()....Was the anayemek deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
//
//	        } catch (SQLException ex) {
//	        	ex.printStackTrace();
//	        }
//	    });
	}

}
