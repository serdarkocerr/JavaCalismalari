package avro.generator;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.avro.AvroFactory;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;
import com.fasterxml.jackson.dataformat.avro.schema.AvroSchemaGenerator;


public class Main {

	public static void main(String[] args) {
		 System.out.println( "Hello World!" );
	        
	        try {
				ObjectMapper mapper = new ObjectMapper(new AvroFactory());
				AvroSchemaGenerator gen = new AvroSchemaGenerator();
				mapper.acceptJsonFormatVisitor(SiparisCRUD.class, gen);
				AvroSchema schemaWrapper = gen.getGeneratedSchema();
				org.apache.avro.Schema avroSchema = schemaWrapper.getAvroSchema();
				String asJson = avroSchema.toString(true);
				System.out.println("asJson : " + asJson);
				System.out.println("------------------------------------------");
				System.out.println("avroSchema :  " +avroSchema);
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
