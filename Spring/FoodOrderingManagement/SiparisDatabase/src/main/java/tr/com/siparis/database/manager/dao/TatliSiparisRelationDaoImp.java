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
import tr.com.siparis.database.model.tatlisiparis;

public class TatliSiparisRelationDaoImp  implements IDao<tatlisiparis, Integer>{

	private final Optional<Connection> connection;
	public TatliSiparisRelationDaoImp() {
		super();
		System.out.println("TatliSiparisDaoImp.TatliSiparisDaoImp()");
		this.connection = JdbcConnection.getConnection();
	}

	@Override
	public Optional<tatlisiparis> get(int siparisid) {
		// TODO Auto-generated method stub
		return connection.flatMap(conn -> {
	        Optional<tatlisiparis> tatlisiparis = Optional.empty();
	        String sql = "SELECT * FROM \"tatlisiparis\" WHERE \"siparisid\" = " + siparisid;

	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            if (resultSet.next()) {
	                int tatliid = resultSet.getInt("tatliid");
	                tatlisiparis = Optional.of(
	                    new tatlisiparis(siparisid, tatliid));

	                System.out.println("TatliSiparisDaoImp.get() ... Found  in database : " + tatlisiparis.get());
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }

	        return tatlisiparis;
	    });
	}

	@Override
	public Collection<tatlisiparis> getAll() {
		Collection<tatlisiparis> tatlisiparissList = new ArrayList<>();
	    String sql = "SELECT * FROM \"tatlisiparis\" ORDER BY \"siparisid\"";

	    connection.ifPresent(conn -> {
	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            while (resultSet.next()) {
	                int tatliid = resultSet.getInt("tatliid");
	                int siparisid = resultSet.getInt("siparisid");

	                tatlisiparis ay = new tatlisiparis(siparisid, tatliid);

	                tatlisiparissList.add(ay);
	                System.out.println("TatliSiparisDaoImp.getAll().... Found in database : " + siparisid);
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    });
	    return tatlisiparissList;
	}

	@Override
	public Optional<Integer> save(tatlisiparis t) {
		String message = "The anayemek to be added should not be null";
		tatlisiparis nonNulltatlisiparis= Objects.requireNonNull(t, message);
        String sql = "INSERT INTO "
                + "\"tatlisiparis\"(\"siparisid\",\"tatliid\")"
                + "VALUES(?,?)";//1-2

        return connection.flatMap(conn -> {
            Optional<Integer> generatedId = Optional.empty();

            try (PreparedStatement statement =
                 conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS)) {

                statement.setInt(1, nonNulltatlisiparis.getSiparisid());
                statement.setInt(2, nonNulltatlisiparis.getTatliid());

                int numberOfInsertedRows = statement.executeUpdate();

                // Retrieve the auto-generated id
                if (numberOfInsertedRows > 0) {
                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            generatedId = Optional.of(resultSet.getInt(1));
                        }
                    }
                }
                System.out.println("TatliSiparisDaoImp.save()... created successfully? ");

            } catch (SQLException ex) {
            	ex.printStackTrace();
            }
            return generatedId;
        });
	}

	@Override
	public boolean update(tatlisiparis t) {
		 String message = "The kullanici to be updated should not be null";
		 tatlisiparis nonNulltatlisiparis = Objects.requireNonNull(t, message);
		    String sql = "UPDATE \"tatlisiparis\" "
		            + "SET "
		            + "\"tatliid\" = ?"
		            + "WHERE "
		            + "\"siparisid\" = ?";

		    if(connection.isPresent()) {

		        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

		        	statement.setInt(1, nonNulltatlisiparis.getTatliid());
		        	statement.setInt(2, nonNulltatlisiparis.getSiparisid());

		            int numberOfUpdatedRows = statement.executeUpdate();

		            System.out.println("TatliSiparisDaoImp.update()...Was the anayemeksiparis updated successfully  numberOfUpdatedRows :  " + numberOfUpdatedRows);


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
	public boolean delete(tatlisiparis t) {
		String message = "The anayemek to be deleted should not be null";
		tatlisiparis nonNulltatlisiparis = Objects.requireNonNull(t, message);
	    String sql = "DELETE FROM \"tatlisiparis\" WHERE \"siparisid\" = ?";

	    if(connection.isPresent()) {

	        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {
	            statement.setInt(1, nonNulltatlisiparis.getSiparisid());

	            int numberOfDeletedRows = statement.executeUpdate();
	            System.out.println("TatliSiparisDaoImp.delete()....Was the tatlisiparis deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
	       
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
//	            System.out.println("AnayemekDaoImp.delete()....Was the tatlisiparis deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
//
//	        } catch (SQLException ex) {
//	        	ex.printStackTrace();
//	        }
//	    });
	}
	

	
}
