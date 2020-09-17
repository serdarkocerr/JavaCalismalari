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

import tr.com.siparis.database.model.KullaniciAllContent;
import tr.com.siparis.database.model.kullanici;

public class KullaniciDaoImp  implements IDao<kullanici, Integer>,IAllContentDao<KullaniciAllContent>{

	private final Optional<Connection> connection;
	
	public KullaniciDaoImp() {
		super();
		System.out.println("kullaniciDaoImp.kullaniciDaoImp()");
		this.connection = JdbcConnection.getConnection();
	}
	/*
	 * 	 * "kullanicino" SERIAL,
		    "kullaniciadi" VARCHAR(40) ,
		    "kullanicisoyadi" VARCHAR(40) ,
			"kullaniciTurid" INT,
			kullaniciSifre VARCHAR 40
		*/
		/* 
		 * @param id
		 */
		public Optional<kullanici> get(int id) {
		    return connection.flatMap(conn -> {
		        Optional<kullanici> kullanici = Optional.empty();
		        String sql = "SELECT * FROM \"Kullanici\" WHERE \"kullaniciid\" = " + id;

		        try (Statement statement = conn.createStatement();
		                ResultSet resultSet = statement.executeQuery(sql)) {

		            if (resultSet.next()) {
		                String kullaniciadi = resultSet.getString("kullaniciadi");
		                String kullanicisoyadi = resultSet.getString("kullanicisoyadi");
		                int  kullaniciTurid = resultSet.getInt("kullaniciTurid");
		                String kullanicisifre = resultSet.getString("kullaniciSifre");
//		                int kullaniciid, String kullaniciadi, String kullanicisoyadi, int kullaniciTurid
		                
		                kullanici = Optional.of(
		                    new kullanici(id, kullaniciadi, kullanicisoyadi, kullaniciTurid,kullanicisifre));

		                System.out.println("KullaniciDaoImp.get() ... Found  in database : " + kullanici.get());
		            }
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }

		        return kullanici;
		    });
		}

		/*
		 * 	 * "kullanicino" SERIAL,
		    "kullaniciadi" VARCHAR(40) ,
		    "kullanicisoyadi" VARCHAR(40) ,
			"kullaniciTurid" INT,
			kullaniciSifre VARCHAR 40
			*/
		
		public Collection<kullanici> getAll() {
		    Collection<kullanici> kullanicilist = new ArrayList<>();
		    String sql = "SELECT * FROM \"Kullanici\"";

		    connection.ifPresent(conn -> {
		        try (Statement statement = conn.createStatement();
		                ResultSet resultSet = statement.executeQuery(sql)) {

		            while (resultSet.next()) {
		                int kullaniciid = resultSet.getInt("kullaniciid");
		                String kullaniciadi = resultSet.getString("kullaniciadi");
		                String kullanicisoyadi = resultSet.getString("kullanicisoyadi");
		                int kullaniciTurid = resultSet.getInt("kullaniciTurid");
		                String kullanicisifre = resultSet.getString("kullaniciSifre");

//		                int kullaniciid, String kullaniciadi, String kullanicisoyadi, int kullaniciTurid

		                kullanici kullanici = new kullanici(kullaniciid, kullaniciadi, kullanicisoyadi, kullaniciTurid,kullanicisifre);

		                kullanicilist.add(kullanici);
		                System.out.println("KullaniciDaoImp.getAll().... Found in database : " + kullaniciadi);
		            }

		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		    });

		    return kullanicilist;
		}
		/*
		 * "kullanicino" SERIAL,
		    "kullaniciadi" VARCHAR(40) ,
		    "kullanicisoyadi" VARCHAR(40) ,
			"kullaniciTurid" INT,
			kullaniciSifre VARCHAR 40
			*/
		
		/* 
		 * @param kullanici
		 */
		@Override
	    public Optional<Integer> save(kullanici kullanici) {
	        String message = "The kullanici to be added should not be null";
	        kullanici nonNullKullanici= Objects.requireNonNull(kullanici, message);
	        String sql = "INSERT INTO "
	                + "\"Kullanici\"(\"kullaniciadi\", \"kullanicisoyadi\", \"kullaniciTurid\",\"kullaniciSifre\""
	                + "VALUES(?, ?, ?,?)";//1-2-3-4

	        return connection.flatMap(conn -> {
	            Optional<Integer> generatedId = Optional.empty();

	            try (PreparedStatement statement =
	                 conn.prepareStatement(
	                    sql,
	                    Statement.RETURN_GENERATED_KEYS)) {

	                statement.setString(1, nonNullKullanici.getKullaniciadi());
	                statement.setString(2, nonNullKullanici.getKullanicisoyadi());
	                statement.setInt(3, nonNullKullanici.getKullaniciturid());
	                statement.setString(4, nonNullKullanici.getSifre());

	                int numberOfInsertedRows = statement.executeUpdate();

	                // Retrieve the auto-generated id
	                if (numberOfInsertedRows > 0) {
	                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
	                        if (resultSet.next()) {
	                            generatedId = Optional.of(resultSet.getInt(1));
	                        }
	                    }
	                }
	                System.out.println("KullaniciDaoImp.save()... created successfully? ");

	            } catch (SQLException ex) {
	            	ex.printStackTrace();
	            }

	            return generatedId;
	        });
	    }
		/*
		 * 	 * "kullanicino" SERIAL,
		    "kullaniciadi" VARCHAR(40) ,
		    "kullanicisoyadi" VARCHAR(40) ,
			"kullaniciTurid" INT,
			kullaniciSifre VARCHAR 40
			*/
		/* 
		 * @param kullanici
		 */
		@Override
		public boolean update(kullanici kullanici) {
		    String message = "The kullanici to be updated should not be null";
		    kullanici nonNullKullanici = Objects.requireNonNull(kullanici, message);
		    String sql = "UPDATE \"Kullanici\" "
		            + "SET "
		            + "\"kullaniciadi\" = ?, "
		            + "\"kullanicisoyadi\" = ?, "
		            + "\"kullaniciTurid\" = ? "
		            + "\"kullaniciSifre\" = ? "
		            + "WHERE "
		            + "\"kullaniciid\" = ?";

		    if(connection.isPresent()) {

		        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

		        	statement.setString(1, nonNullKullanici.getKullaniciadi());
		            statement.setString(2, nonNullKullanici.getKullanicisoyadi());
		            statement.setInt(3, nonNullKullanici.getKullaniciturid());
		            statement.setString(4, nonNullKullanici.getSifre());
		            statement.setInt(5, nonNullKullanici.getKullaniciid());


		            int numberOfUpdatedRows = statement.executeUpdate();

		            System.out.println("KullaniciDaoImp.update()...Was the Kullanici updated successfully  numberOfUpdatedRows :  " + numberOfUpdatedRows);


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
//		    connection.ifPresent(conn -> {
//		        try (PreparedStatement statement = conn.prepareStatement(sql)) {
	//
//		        	statement.setString(1, nonNullKullanici.getKullaniciadi());
//		            statement.setString(2, nonNullKullanici.getKullanicisoyadi());
//		            statement.setInt(3, nonNullKullanici.getKullaniciTurid());
//		            statement.setString(4, nonNullKullanici.getKullanicisifre());
//		            statement.setInt(5, nonNullKullanici.getKullaniciid());
	//
	//
//		            int numberOfUpdatedRows = statement.executeUpdate();
	//
//		            System.out.println("KullaniciDaoImp.update()...Was the Kullanici updated successfully  numberOfUpdatedRows :  " + numberOfUpdatedRows);
	//
	//
//		        } catch (SQLException ex) {
//		            ex.printStackTrace();
//		        }
//		    });
		}
		/*
		 * 	 * "kullanicino" SERIAL,
		    "kullaniciadi" VARCHAR(40) ,
		    "kullanicisoyadi" VARCHAR(40) ,
			"kullaniciTurid" INT,
			kullaniciSifre VARCHAR 40
			*/
		/* 
		 * @param kullanici
		 */
		public boolean delete(kullanici kullanici) {
		    String message = "The kullanici to be deleted should not be null";
		    kullanici nonNullKullanici = Objects.requireNonNull(kullanici, message);
		    String sql = "DELETE FROM \"Kullanici\" WHERE \"kullaniciid\" = ?";

		    if(connection.isPresent()) {

		        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

		            statement.setInt(1, nonNullKullanici.getKullaniciid());

		            int numberOfDeletedRows = statement.executeUpdate();
		            
		            System.out.println("KullaniciDaoImp.delete()....Was the kullanici deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);

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
//		    connection.ifPresent(conn -> {
//		        try (PreparedStatement statement = conn.prepareStatement(sql)) {
	//
//		            statement.setInt(1, nonNullKullanici.getKullaniciid());
	//
//		            int numberOfDeletedRows = statement.executeUpdate();
//		            
//		            System.out.println("KullaniciDaoImp.delete()....Was the kullanici deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
	//
//		        } catch (SQLException ex) {
//		        	ex.printStackTrace();
//		        }
//		    });
		}
		@Override
		public Collection<KullaniciAllContent> getAllContent() {

			String sql = "SELECT * FROM \"kullanici\" INNER JOIN \"kullanicitur\" ON \"kullanici\".\"kullaniciturid\" = \"kullanicitur\".\"kullaniciturid\"";
		    Collection<KullaniciAllContent> kullaniciAllContentList = new ArrayList<>();

		    connection.ifPresent(conn->{
		        try (Statement statement = conn.createStatement();
		                ResultSet resultSet = statement.executeQuery(sql)) {

		            while (resultSet.next()) {
		                int kullanici_id = resultSet.getInt("kullaniciid");
		                String kullanici_adi = resultSet.getString("kullaniciadi");
		                String kullanici_soyadi = resultSet.getString("kullanicisoyadi");
		                int kullaniciTur_id = resultSet.getInt("kullaniciturid");
		                String kullanici_sifre = resultSet.getString("sifre");
		                String kullaniciTur_adi = resultSet.getString("kullanicituradi");


		                KullaniciAllContent kullaniciAllContent = new KullaniciAllContent(kullanici_id, kullanici_adi, kullanici_soyadi, kullaniciTur_id, kullaniciTur_adi, kullanici_sifre);

		                kullaniciAllContentList.add(kullaniciAllContent);
		                System.out.println("KullaniciDaoImp.getAllContent().... Found in database : " + kullanici_adi);
		            }

		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		    });
			return kullaniciAllContentList;
		}


}
