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

import tr.com.siparis.database.model.SiparisAllContent;
import tr.com.siparis.database.model.siparis;

public class SiparisDaoImp  implements IDao<siparis, Integer>,IAllContentDao<SiparisAllContent>{

	private final Optional<Connection> connection;
	
	public SiparisDaoImp() {
		super();
		System.out.println("siparisDaoImp.siparisDaoImp()");
		this.connection = JdbcConnection.getConnection();
	}
	@Override
	public Optional<siparis> get(int id) {
		// TODO Auto-generated method stub
		return connection.flatMap(conn -> {
	        Optional<siparis> siparis = Optional.empty();
	        String sql = "SELECT * FROM \"siparis\" WHERE \"siparisid\" = " + id;

	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            if (resultSet.next()) {
	                int masaid = resultSet.getInt("masaid");
	                int kullaniciid = resultSet.getInt("kullaniciid");
	                String siparisDurumu = resultSet.getString("siparisDurumu");

	                siparis = Optional.of(
	                    new siparis(id,masaid,kullaniciid,siparisDurumu));
	                
	                System.out.println("siparisDaoImp.get() ... Found  in database : " + siparis.get());
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }

	        return siparis;
	    });
	}

	@Override
	public Collection<siparis> getAll() {
		Collection<siparis> siparislist = new ArrayList<>();
	    String sql = "SELECT * FROM \"siparis\"";

	    connection.ifPresent(conn -> {
	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            while (resultSet.next()) {
	                int siparisid = resultSet.getInt("siparisid");
	                int masaid = resultSet.getInt("masaid");
	                int kullaniciid = resultSet.getInt("kullaniciid");
	                String siparisDurumu = resultSet.getString("siparisDurumu");
	                
	                siparis siparis = new siparis(siparisid,masaid,kullaniciid,siparisDurumu);

	                siparislist.add(siparis);
	                System.out.println("siparisDaoImp.getAll().... Found in database siparisid : " + siparisid);
	            }

	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    });

	    return siparislist;
	}

	@Override
	public Optional<Integer> save(siparis t) {
		String message = "The siparis to be added should not be null";
        siparis nonNullsiparis= Objects.requireNonNull(t, message);
        String sql = "INSERT INTO "
                + "\"siparis\"(\"masaid\",\"kullaniciid\",\"siparisDurumu\") "
                + "VALUES(?,?,?)";//1,2,3

        return connection.flatMap(conn -> {
            Optional<Integer> generatedId = Optional.empty();

            try (PreparedStatement statement =
                 conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS)) {

            	statement.setInt(1, nonNullsiparis.getMasaid());
            	statement.setInt(2, nonNullsiparis.getKullaniciid());
                statement.setString(3, nonNullsiparis.getSiparisDurumu());
                int numberOfInsertedRows = statement.executeUpdate();

                // Retrieve the auto-generated id
                if (numberOfInsertedRows > 0) {
                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            generatedId = Optional.of(resultSet.getInt(1));
                        }
                    }
                }
                System.out.println("siparisDaoImp.save()... created successfully? ");

            } catch (SQLException ex) {
            	ex.printStackTrace();
            }

            return generatedId;
        });
	}

	@Override
	public boolean update(siparis t) {
		 String message = "The kullanici to be updated should not be null";
		 siparis nonNullsiparis = Objects.requireNonNull(t, message);
		    String sql = "UPDATE \"siparis\" "
		            + "SET "
		            + "\"siparisDurumu\" = ?"
		            + "WHERE "
		            + "\"siparisid\" = ?";

		    if(connection.isPresent()) {

		        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

		        	statement.setString(1, nonNullsiparis.getSiparisDurumu());
		        	statement.setInt(2, nonNullsiparis.getSiparisid());

		            int numberOfUpdatedRows = statement.executeUpdate();

		            System.out.println("siparisDaoImp.update()...Was the Kullanici updated successfully  numberOfUpdatedRows :  " + numberOfUpdatedRows);


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
	public boolean delete(siparis t) {
		String message = "The siparis to be deleted should not be null";
		siparis nonNullsiparis = Objects.requireNonNull(t, message);
	    String sql = "DELETE FROM \"siparis\" WHERE \"siparisid\" = ?";

	    if(connection.isPresent()) {

	        try (PreparedStatement statement = connection.get().prepareStatement(sql)) {

	            statement.setInt(1, nonNullsiparis.getSiparisid());

	            int numberOfDeletedRows = statement.executeUpdate();
	            
	            System.out.println("siparisDaoImp.delete()....Was the siparis deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);

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
//	            System.out.println("siparisDaoImp.delete()....Was the siparis deleted successfully numberOfDeletedRows : " + numberOfDeletedRows);
//
//	        } catch (SQLException ex) {
//	        	ex.printStackTrace();
//	        }
//	    });
	}
	
	@Override
	public Collection<SiparisAllContent> getAllContent() {
		String sql = "SELECT * FROM \"siparis\" " + 
				"INNER JOIN (SELECT * FROM \"anayemek\" INNER JOIN \"anayemeksiparis\" ON \"anayemeksiparis\".\"anayemekid\" = \"anayemek\".\"anayemekid\" ) AS \"anayemekAll\" ON \"siparis\".\"siparisid\" = \"anayemekAll\".\"siparisid\" " + 
				"INNER JOIN (SELECT * FROM \"corba\" INNER JOIN \"corbasiparis\" ON \"corbasiparis\".\"corbaid\" = \"corba\".\"corbaid\" ) AS \"corbaAll\" ON \"siparis\".\"siparisid\" = \"corbaAll\".\"siparisid\" " + 
				"INNER JOIN (SELECT * FROM \"salata\" INNER JOIN \"salatasiparis\" ON \"salatasiparis\".\"salataid\" = \"salata\".\"salataid\" ) AS \"salataAll\" ON \"siparis\".\"siparisid\" = \"salataAll\".\"siparisid\" " + 
				"INNER JOIN (SELECT * FROM \"tatli\" INNER JOIN \"tatlisiparis\" ON \"tatlisiparis\".\"tatliid\" = \"tatli\".\"tatliid\" ) AS \"tatliAll\" ON \"siparis\".\"siparisid\" = \"tatliAll\".\"siparisid\"\r\n" + 
				"INNER JOIN \"masa\" ON \"siparis\".\"masaid\" = \"masa\".\"masaid\"\r\n" + 
				"INNER JOIN (SELECT * FROM \"kullanici\" INNER JOIN \"kullanicitur\" ON \"kullanici\".\"kullaniciturid\" =\"kullanicitur\".\"kullaniciturid\" ) AS \"kullaniciAll\" ON \"siparis\".\"kullaniciid\" = \"kullaniciAll\".\"kullaniciid\"";

	    Collection<SiparisAllContent> siparisAllContentList = new ArrayList<>();

	    connection.ifPresent(conn->{
	        try (Statement statement = conn.createStatement();
	                ResultSet resultSet = statement.executeQuery(sql)) {

	            while (resultSet.next()) {
	                int siparisId = resultSet.getInt("siparisid");
	                int anayemekId = resultSet.getInt("anayemekid");
	                String anayemekAdi = resultSet.getString("anayemekadi");
	                int corbaId = resultSet.getInt("corbaid");
	                String corbaAdi = resultSet.getString("corbaadi");
	                int salataId = resultSet.getInt("salataid");
	                String salataAdi = resultSet.getString("salataadi");
	                int tatliId = resultSet.getInt("tatliid");
	                String tatliAdi = resultSet.getString("tatliadi");
	                int masaId = resultSet.getInt("masaid");
	                String masaAdi = resultSet.getString("masaadi");
	                int kullaniciId = resultSet.getInt("kullaniciid");
	                String kullaniciAdi = resultSet.getString("kullaniciadi");
	                String kullaniciSoyadi = resultSet.getString("kullanicisoyadi");
	                int kullaniciTurId = resultSet.getInt("kullaniciturid");
	                String kullaniciTurAdi = resultSet.getString("kullaniciTuradi");
	                String siparisDurumu = resultSet.getString("siparisdurumu");


	                SiparisAllContent siparisAllContent = new SiparisAllContent(siparisId, anayemekId, anayemekAdi, corbaId, corbaAdi, salataId, salataAdi, tatliId, tatliAdi, masaId, masaAdi, kullaniciId, kullaniciAdi, kullaniciSoyadi, kullaniciTurId, kullaniciTurAdi, siparisDurumu);

	                siparisAllContentList.add(siparisAllContent);
	                System.out.println("siparisDaoImp.getAllContent().... Found in database : " + siparisId);
	            }

	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	    });
		return siparisAllContentList;
	}

}
