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

import tr.com.siparis.database.model.anayemeksiparis;
import tr.com.siparis.database.model.salatasiparis;

public class SalataSiparisRelationDaoImp  implements IDao<salatasiparis, Integer>{

	private final Optional<Connection> connection;
	public SalataSiparisRelationDaoImp() {
		super();
		System.out.println("SalataSiparisDaoImp.SalataSiparisDaoImp()");
		this.connection = JdbcConnection.getConnection();
	}
	
	
	@Override
	public Optional<salatasiparis> get(int siparisid) {
		// TODO Auto-generated method stub
		return connection.flatMap(conn -> {
	        Optional<salatasiparis> salatasiparis = Optional.empty();
	        String sql = "SELECT * FROM \"salatasiparis\" WHERE \"siparisid\" = " + siparisid;
	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {
	            if (resultSet.next()) {
	                int salataid = resultSet.getInt("salataid");
	                salatasiparis = Optional.of(
	                    new salatasiparis(salataid, siparisid));
	                System.out.println("SalataSiparisDaoImp.get() ... Found  in database : " + salatasiparis.get());
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	        return salatasiparis;
	    });
	}

	@Override
	public Collection<salatasiparis> getAll() {
		Collection<salatasiparis> salatasiparisList = new ArrayList<>();
	    String sql = "SELECT * FROM \"salatasiparis\" ORDER BY \"siparisid\"";

	    connection.ifPresent(conn -> {
	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            while (resultSet.next()) {
	                int salataid = resultSet.getInt("salataid");
	                int siparisid = resultSet.getInt("siparisid");

	                salatasiparis ay = new salatasiparis(salataid, siparisid);

	                salatasiparisList.add(ay);
	                System.out.println("SalataSiparisDaoImp.getAll().... Found in database : " + siparisid);
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    });
	    return salatasiparisList;
	}

	@Override
	public Optional<Integer> save(salatasiparis t) {
		String message = "The anayemek to be added should not be null";
		salatasiparis nonNullSalataSiparis= Objects.requireNonNull(t, message);
        String sql = "INSERT INTO "
                + "\"salatasiparis\"(\"siparisid\",\"salataid\")"
                + "VALUES(?,?)";//1-2

        return connection.flatMap(conn -> {
            Optional<Integer> generatedId = Optional.empty();

            try (PreparedStatement statement =
                 conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS)) {

                statement.setInt(1, nonNullSalataSiparis.getSiparisid());
                statement.setInt(2, nonNullSalataSiparis.getSalataid());

                int numberOfInsertedRows = statement.executeUpdate();

                // Retrieve the auto-generated id
                if (numberOfInsertedRows > 0) {
                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            generatedId = Optional.of(resultSet.getInt(1));
                        }
                    }
                }
                System.out.println("SalataSiparisDaoImp.save()... created successfully? ");

            } catch (SQLException ex) {
            	ex.printStackTrace();
            }
            return generatedId;
        });
	}

	@Override
	public boolean update(salatasiparis t) {
		 String message = "The kullanici to be updated should not be null";
		 salatasiparis nonNullsalatasiparis = Objects.requireNonNull(t, message);
		    String sql = "UPDATE \"salatasiparis\" "
		            + "SET "
		            + "\"salataid\" = ?"
		            + "WHERE "
		            + "\"siparisid\" = ?";

		    if(connection.isPresent()) {

		        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

		        	statement.setInt(1, nonNullsalatasiparis.getSalataid());
		        	statement.setInt(2, nonNullsalatasiparis.getSiparisid());

		            int numberOfUpdatedRows = statement.executeUpdate();

		            System.out.println("SalataSiparisDaoImp.update()...Was the salatasiparis updated successfully  numberOfUpdatedRows :  " + numberOfUpdatedRows);


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
	public boolean delete(salatasiparis t) {
		String message = "The anayemek to be deleted should not be null";
		salatasiparis nonNullsalatasiparis = Objects.requireNonNull(t, message);
	    String sql = "DELETE FROM \"salatasiparis\" WHERE \"siparisid\" = ?";

	    if(connection.isPresent()) {

	        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {
	            statement.setInt(1, nonNullsalatasiparis.getSiparisid());

	            int numberOfDeletedRows = statement.executeUpdate();
	            System.out.println("SalataSiparisDaoImp.delete()....Was the salatasiparis deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
	       
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
//	            System.out.println("AnayemekDaoImp.delete()....Was the salatasiparis deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
//
//	        } catch (SQLException ex) {
//	        	ex.printStackTrace();
//	        }
//	    });
	}
	
	
	
}
