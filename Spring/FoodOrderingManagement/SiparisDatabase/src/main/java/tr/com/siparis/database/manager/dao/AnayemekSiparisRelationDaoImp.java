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

public class AnayemekSiparisRelationDaoImp  implements IDao<anayemeksiparis, Integer>{
	private final Optional<Connection> connection;
	public AnayemekSiparisRelationDaoImp() {
		super();
		System.out.println("AnayemekSiparisRelationDaoImp.AnayemekSiparisRelationDaoImp()");
		this.connection = JdbcConnection.getConnection();
	}
	@Override
	public Optional<anayemeksiparis> get(int siparisid) {
		// TODO Auto-generated method stub
		return connection.flatMap(conn -> {
	        Optional<anayemeksiparis> anayemeksiparis = Optional.empty();
	        String sql = "SELECT * FROM \"anayemeksiparis\" WHERE \"siparisid\" = " + siparisid;

	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            if (resultSet.next()) {
	                int anayemekid = resultSet.getInt("anayemekid");
	                anayemeksiparis = Optional.of(
	                    new anayemeksiparis(siparisid, anayemekid));

	                System.out.println("AnayemekSiparisRelationDaoImp.get() ... Found  in database : " + anayemeksiparis.get());
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }

	        return anayemeksiparis;
	    });
	}

	@Override
	public Collection<anayemeksiparis> getAll() {
		Collection<anayemeksiparis> anayemeksiparisList = new ArrayList<>();
	    String sql = "SELECT * FROM \"anayemeksiparis\" ORDER BY \"siparisid\"";

	    connection.ifPresent(conn -> {
	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            while (resultSet.next()) {
	                int anayemekid = resultSet.getInt("anayemekid");
	                int siparisid = resultSet.getInt("siparisid");

	                anayemeksiparis ay = new anayemeksiparis(siparisid, anayemekid);

	                anayemeksiparisList.add(ay);
	                System.out.println("AnayemekSiparisRelationDaoImp.getAll().... Found in database : " + siparisid);
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    });
	    return anayemeksiparisList;
	}

	@Override
	public Optional<Integer> save(anayemeksiparis t) {
		String message = "The anayemek to be added should not be null";
		anayemeksiparis nonNullAnayemek= Objects.requireNonNull(t, message);
        String sql = "INSERT INTO "
                + "\"anayemeksiparis\"(\"siparisid\",\"anayemekid\")"
                + "VALUES(?,?)";//1-2

        return connection.flatMap(conn -> {
            Optional<Integer> generatedId = Optional.empty();

            try (PreparedStatement statement =
                 conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS)) {

                statement.setInt(1, nonNullAnayemek.getSiparisid());
                statement.setInt(2, nonNullAnayemek.getAnayemekid());

                int numberOfInsertedRows = statement.executeUpdate();

                // Retrieve the auto-generated id
                if (numberOfInsertedRows > 0) {
                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            generatedId = Optional.of(resultSet.getInt(1));
                        }
                    }
                }
                System.out.println("AnayemekSiparisRelationDaoImp.save()... created successfully? ");

            } catch (SQLException ex) {
            	ex.printStackTrace();
            }
            return generatedId;
        });
	}

	@Override
	public boolean update(anayemeksiparis t) {
		 String message = "The kullanici to be updated should not be null";
		 anayemeksiparis nonNullanayemek = Objects.requireNonNull(t, message);
		    String sql = "UPDATE \"anayemeksiparis\" "
		            + "SET "
		            + "\"anayemekid\" = ?"
		            + "WHERE "
		            + "\"siparisid\" = ?";

		    if(connection.isPresent()) {

		        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

		        	statement.setInt(1, nonNullanayemek.getAnayemekid());
		        	statement.setInt(2, nonNullanayemek.getSiparisid());

		            int numberOfUpdatedRows = statement.executeUpdate();

		            System.out.println("AnayemekSiparisRelationDaoImp.update()...Was the anayemeksiparis updated successfully  numberOfUpdatedRows :  " + numberOfUpdatedRows);


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
	public boolean delete(anayemeksiparis t) {
		String message = "The anayemek to be deleted should not be null";
		anayemeksiparis nonNullAnayemek = Objects.requireNonNull(t, message);
	    String sql = "DELETE FROM \"anayemeksiparis\" WHERE \"siparisid\" = ?";

	    if(connection.isPresent()) {

	        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {
	            statement.setInt(1, nonNullAnayemek.getSiparisid());

	            int numberOfDeletedRows = statement.executeUpdate();
	            System.out.println("AnayemekSiparisRelationDaoImp.delete()....Was the anayemeksiparis deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
	       
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
//	            System.out.println("AnayemekDaoImp.delete()....Was the anayemeksiparis deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
//
//	        } catch (SQLException ex) {
//	        	ex.printStackTrace();
//	        }
//	    });
	}
	
	
}
