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

import tr.com.siparis.database.model.tatli;

public class TatliDaoImp  implements IDao<tatli, Integer>{

	private final Optional<Connection> connection;
	
	public TatliDaoImp() {
		super();
		System.out.println("tatliDaoImp.tatliDaoImp()");
		this.connection = JdbcConnection.getConnection();
	}
	@Override
	public Optional<tatli> get(int id) {
		// TODO Auto-generated method stub
		return connection.flatMap(conn -> {
	        Optional<tatli> tatli = Optional.empty();
	        String sql = "SELECT * FROM \"tatli\" WHERE \"tatliid\" = " + id;

	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            if (resultSet.next()) {
	                String tatliadi = resultSet.getString("tatliadi");
	                tatli = Optional.of(
	                    new tatli(id, tatliadi));

	                System.out.println("tatliDaoImp.get() ... Found  in database : " + tatli.get());
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }

	        return tatli;
	    });
	}

	@Override
	public Collection<tatli> getAll() {
		Collection<tatli> tatlilist = new ArrayList<>();
	    String sql = "SELECT * FROM \"tatli\" ORDER BY \"tatliadi\"";

	    connection.ifPresent(conn -> {
	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            while (resultSet.next()) {
	                int tatliid = resultSet.getInt("tatliid");
	                String tatliadi = resultSet.getString("tatliadi");

	                tatli tatli = new tatli(tatliid, tatliadi);

	                tatlilist.add(tatli);
	                System.out.println("tatliDaoImp.getAll().... Found in database : " + tatliadi);
	            }

	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    });

	    return tatlilist;
	}

	@Override
	public Optional<Integer> save(tatli t) {
		String message = "The tatli to be added should not be null";
        tatli nonNulltatli= Objects.requireNonNull(t, message);
        String sql = "INSERT INTO "
                + "\"tatli\"(\"tatliadi\""
                + "VALUES(?)";//1-2-3-4

        return connection.flatMap(conn -> {
            Optional<Integer> generatedId = Optional.empty();

            try (PreparedStatement statement =
                 conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, nonNulltatli.getTatliadi());
                int numberOfInsertedRows = statement.executeUpdate();

                // Retrieve the auto-generated id
                if (numberOfInsertedRows > 0) {
                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            generatedId = Optional.of(resultSet.getInt(1));
                        }
                    }
                }
                System.out.println("tatliDaoImp.save()... created successfully? ");

            } catch (SQLException ex) {
            	ex.printStackTrace();
            }

            return generatedId;
        });
	}

	@Override
	public boolean update(tatli t) {
		 String message = "The kullanici to be updated should not be null";
		 tatli nonNulltatli = Objects.requireNonNull(t, message);
		    String sql = "UPDATE \"tatli\" "
		            + "SET "
		            + "\"tatliadi\" = ?"
		            + "WHERE "
		            + "\"tatliid\" = ?";

		    if(connection.isPresent()) {

		        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

		        	statement.setString(1, nonNulltatli.getTatliadi());

		            int numberOfUpdatedRows = statement.executeUpdate();

		            System.out.println("tatliDaoImp.update()...Was the Kullanici updated successfully  numberOfUpdatedRows :  " + numberOfUpdatedRows);


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
	public boolean delete(tatli t) {
		String message = "The tatli to be deleted should not be null";
		tatli nonNulltatli = Objects.requireNonNull(t, message);
	    String sql = "DELETE FROM \"tatli\" WHERE \"tatliid\" = ?";

	    if(connection.isPresent()) {

	        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

	            statement.setInt(1, nonNulltatli.getTatliid());

	            int numberOfDeletedRows = statement.executeUpdate();
	            
	            System.out.println("tatliDaoImp.delete()....Was the tatli deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);

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
//	            System.out.println("tatliDaoImp.delete()....Was the tatli deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
//
//	        } catch (SQLException ex) {
//	        	ex.printStackTrace();
//	        }
//	    });
	}

}
