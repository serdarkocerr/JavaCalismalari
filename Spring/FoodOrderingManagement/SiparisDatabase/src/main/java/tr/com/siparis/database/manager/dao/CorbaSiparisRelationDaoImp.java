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

import tr.com.siparis.database.model.corbasiparis;

public class CorbaSiparisRelationDaoImp implements IDao<corbasiparis, Integer>{
	private final Optional<Connection> connection;


	public CorbaSiparisRelationDaoImp() {
		super();
		System.out.println("CorbaSiparisDaoImp.CorbaSiparisDaoImp()");
		this.connection = JdbcConnection.getConnection();

	}

	@Override
	public Optional<corbasiparis> get(int siparisid) {
		// TODO Auto-generated method stub
		return connection.flatMap(conn -> {
	        Optional<corbasiparis> corbasiparis = Optional.empty();
	        String sql = "SELECT * FROM \"corbasiparis\" WHERE \"siparisid\" = " + siparisid;

	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            if (resultSet.next()) {
	                int corbaid = resultSet.getInt("corbaid");
	                corbasiparis = Optional.of(
	                    new corbasiparis(corbaid, siparisid));

	                System.out.println("CorbaSiparisDaoImp.get() ... Found  in database : " + corbasiparis.get());
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }

	        return corbasiparis;
	    });
	}

	@Override
	public Collection<corbasiparis> getAll() {
		Collection<corbasiparis> corbasiparisList = new ArrayList<>();
	    String sql = "SELECT * FROM \"corbasiparis\" ORDER BY \"siparisid\"";

	    connection.ifPresent(conn -> {
	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            while (resultSet.next()) {
	                int corbaid = resultSet.getInt("corbaid");
	                int siparisid = resultSet.getInt("siparisid");

	                corbasiparis cr = new corbasiparis(corbaid, siparisid);

	                corbasiparisList.add(cr);
	                System.out.println("CorbaSiparisDaoImp.getAll().... Found in database : " + siparisid);
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    });
	    return corbasiparisList;
	}

	@Override
	public Optional<Integer> save(corbasiparis t) {
		String message = "The anayemek to be added should not be null";
		corbasiparis nonNullAnayemek= Objects.requireNonNull(t, message);
        String sql = "INSERT INTO "
                + "\"corbasiparis\"(\"corbaid\",\"siparisid\")"
                + "VALUES(?,?)";//1-2

        return connection.flatMap(conn -> {
            Optional<Integer> generatedId = Optional.empty();

            try (PreparedStatement statement =
                 conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS)) {

                statement.setInt(1, nonNullAnayemek.getCorbaid());
                statement.setInt(2, nonNullAnayemek.getSiparisid());

                int numberOfInsertedRows = statement.executeUpdate();

                // Retrieve the auto-generated id
                if (numberOfInsertedRows > 0) {
                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            generatedId = Optional.of(resultSet.getInt(1));
                        }
                    }
                }
                System.out.println("CorbaSiparisDaoImp.save()... created successfully? ");

            } catch (SQLException ex) {
            	ex.printStackTrace();
            }
            return generatedId;
        });
	}

	@Override
	public boolean update(corbasiparis t) {
		 String message = "The kullanici to be updated should not be null";
		 corbasiparis nonNullanayemek = Objects.requireNonNull(t, message);
		    String sql = "UPDATE \"corbasiparis\" "
		            + "SET "
		            + "\"corbaid\" = ?"
		            + "WHERE "
		            + "\"siparisid\" = ?";

		    if(connection.isPresent()) {

		        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

		        	statement.setInt(1, nonNullanayemek.getCorbaid());
		        	statement.setInt(2, nonNullanayemek.getSiparisid());

		            int numberOfUpdatedRows = statement.executeUpdate();
		            System.out.println("CorbaSiparisDaoImp.update()...Was the corbasiparis updated successfully  numberOfUpdatedRows :  " + numberOfUpdatedRows);
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
	public boolean delete(corbasiparis t) {
		String message = "The anayemek to be deleted should not be null";
		corbasiparis nonNullcorbasiparis = Objects.requireNonNull(t, message);
	    String sql = "DELETE FROM \"corbasiparis\" WHERE \"siparisid\" = ?";

	    if(connection.isPresent()) {

	        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {
	            statement.setInt(1, nonNullcorbasiparis.getSiparisid());

	            int numberOfDeletedRows = statement.executeUpdate();
	            System.out.println("CorbaSiparisDaoImp.delete()....Was the corbasiparis deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
	       
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
//	            System.out.println("AnayemekDaoImp.delete()....Was the corbasiparis deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
//
//	        } catch (SQLException ex) {
//	        	ex.printStackTrace();
//	        }
//	    });
	}

}
