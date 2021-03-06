/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package tr.com.siparis.sistemi.kafka.model;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class CorbaKafkaModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CorbaKafkaModel\",\"namespace\":\"tr.com.siparis.sistemi.kafka.model\",\"fields\":[{\"name\":\"corbaListesi\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Corba\",\"fields\":[{\"name\":\"corbaAdi\",\"type\":[\"null\",\"string\"]},{\"name\":\"corbaId\",\"type\":\"int\"}]}}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.util.List<tr.com.siparis.sistemi.kafka.model.Corba> corbaListesi;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public CorbaKafkaModel() {}

  /**
   * All-args constructor.
   */
  public CorbaKafkaModel(java.util.List<tr.com.siparis.sistemi.kafka.model.Corba> corbaListesi) {
    this.corbaListesi = corbaListesi;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return corbaListesi;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: corbaListesi = (java.util.List<tr.com.siparis.sistemi.kafka.model.Corba>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'corbaListesi' field.
   */
  public java.util.List<tr.com.siparis.sistemi.kafka.model.Corba> getCorbaListesi() {
    return corbaListesi;
  }

  /**
   * Sets the value of the 'corbaListesi' field.
   * @param value the value to set.
   */
  public void setCorbaListesi(java.util.List<tr.com.siparis.sistemi.kafka.model.Corba> value) {
    this.corbaListesi = value;
  }

  /** Creates a new CorbaKafkaModel RecordBuilder */
  public static tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel.Builder newBuilder() {
    return new tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel.Builder();
  }
  
  /** Creates a new CorbaKafkaModel RecordBuilder by copying an existing Builder */
  public static tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel.Builder newBuilder(tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel.Builder other) {
    return new tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel.Builder(other);
  }
  
  /** Creates a new CorbaKafkaModel RecordBuilder by copying an existing CorbaKafkaModel instance */
  public static tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel.Builder newBuilder(tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel other) {
    return new tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel.Builder(other);
  }
  
  /**
   * RecordBuilder for CorbaKafkaModel instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CorbaKafkaModel>
    implements org.apache.avro.data.RecordBuilder<CorbaKafkaModel> {

    private java.util.List<tr.com.siparis.sistemi.kafka.model.Corba> corbaListesi;

    /** Creates a new Builder */
    private Builder() {
      super(tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.corbaListesi)) {
        this.corbaListesi = data().deepCopy(fields()[0].schema(), other.corbaListesi);
        fieldSetFlags()[0] = true;
      }
    }
    
    /** Creates a Builder by copying an existing CorbaKafkaModel instance */
    private Builder(tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel other) {
            super(tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel.SCHEMA$);
      if (isValidValue(fields()[0], other.corbaListesi)) {
        this.corbaListesi = data().deepCopy(fields()[0].schema(), other.corbaListesi);
        fieldSetFlags()[0] = true;
      }
    }

    /** Gets the value of the 'corbaListesi' field */
    public java.util.List<tr.com.siparis.sistemi.kafka.model.Corba> getCorbaListesi() {
      return corbaListesi;
    }
    
    /** Sets the value of the 'corbaListesi' field */
    public tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel.Builder setCorbaListesi(java.util.List<tr.com.siparis.sistemi.kafka.model.Corba> value) {
      validate(fields()[0], value);
      this.corbaListesi = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'corbaListesi' field has been set */
    public boolean hasCorbaListesi() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'corbaListesi' field */
    public tr.com.siparis.sistemi.kafka.model.CorbaKafkaModel.Builder clearCorbaListesi() {
      corbaListesi = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public CorbaKafkaModel build() {
      try {
        CorbaKafkaModel record = new CorbaKafkaModel();
        record.corbaListesi = fieldSetFlags()[0] ? this.corbaListesi : (java.util.List<tr.com.siparis.sistemi.kafka.model.Corba>) defaultValue(fields()[0]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
