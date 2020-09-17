/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package tr.com.siparis.sistemi.kafka.model;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class SalataKafkaModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SalataKafkaModel\",\"namespace\":\"tr.com.siparis.sistemi.kafka.model\",\"fields\":[{\"name\":\"salataListesi\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Salata\",\"fields\":[{\"name\":\"salataAdi\",\"type\":[\"null\",\"string\"]},{\"name\":\"salataId\",\"type\":\"int\"}]}}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.util.List<tr.com.siparis.sistemi.kafka.model.Salata> salataListesi;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public SalataKafkaModel() {}

  /**
   * All-args constructor.
   */
  public SalataKafkaModel(java.util.List<tr.com.siparis.sistemi.kafka.model.Salata> salataListesi) {
    this.salataListesi = salataListesi;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return salataListesi;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: salataListesi = (java.util.List<tr.com.siparis.sistemi.kafka.model.Salata>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'salataListesi' field.
   */
  public java.util.List<tr.com.siparis.sistemi.kafka.model.Salata> getSalataListesi() {
    return salataListesi;
  }

  /**
   * Sets the value of the 'salataListesi' field.
   * @param value the value to set.
   */
  public void setSalataListesi(java.util.List<tr.com.siparis.sistemi.kafka.model.Salata> value) {
    this.salataListesi = value;
  }

  /** Creates a new SalataKafkaModel RecordBuilder */
  public static tr.com.siparis.sistemi.kafka.model.SalataKafkaModel.Builder newBuilder() {
    return new tr.com.siparis.sistemi.kafka.model.SalataKafkaModel.Builder();
  }
  
  /** Creates a new SalataKafkaModel RecordBuilder by copying an existing Builder */
  public static tr.com.siparis.sistemi.kafka.model.SalataKafkaModel.Builder newBuilder(tr.com.siparis.sistemi.kafka.model.SalataKafkaModel.Builder other) {
    return new tr.com.siparis.sistemi.kafka.model.SalataKafkaModel.Builder(other);
  }
  
  /** Creates a new SalataKafkaModel RecordBuilder by copying an existing SalataKafkaModel instance */
  public static tr.com.siparis.sistemi.kafka.model.SalataKafkaModel.Builder newBuilder(tr.com.siparis.sistemi.kafka.model.SalataKafkaModel other) {
    return new tr.com.siparis.sistemi.kafka.model.SalataKafkaModel.Builder(other);
  }
  
  /**
   * RecordBuilder for SalataKafkaModel instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SalataKafkaModel>
    implements org.apache.avro.data.RecordBuilder<SalataKafkaModel> {

    private java.util.List<tr.com.siparis.sistemi.kafka.model.Salata> salataListesi;

    /** Creates a new Builder */
    private Builder() {
      super(tr.com.siparis.sistemi.kafka.model.SalataKafkaModel.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(tr.com.siparis.sistemi.kafka.model.SalataKafkaModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.salataListesi)) {
        this.salataListesi = data().deepCopy(fields()[0].schema(), other.salataListesi);
        fieldSetFlags()[0] = true;
      }
    }
    
    /** Creates a Builder by copying an existing SalataKafkaModel instance */
    private Builder(tr.com.siparis.sistemi.kafka.model.SalataKafkaModel other) {
            super(tr.com.siparis.sistemi.kafka.model.SalataKafkaModel.SCHEMA$);
      if (isValidValue(fields()[0], other.salataListesi)) {
        this.salataListesi = data().deepCopy(fields()[0].schema(), other.salataListesi);
        fieldSetFlags()[0] = true;
      }
    }

    /** Gets the value of the 'salataListesi' field */
    public java.util.List<tr.com.siparis.sistemi.kafka.model.Salata> getSalataListesi() {
      return salataListesi;
    }
    
    /** Sets the value of the 'salataListesi' field */
    public tr.com.siparis.sistemi.kafka.model.SalataKafkaModel.Builder setSalataListesi(java.util.List<tr.com.siparis.sistemi.kafka.model.Salata> value) {
      validate(fields()[0], value);
      this.salataListesi = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'salataListesi' field has been set */
    public boolean hasSalataListesi() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'salataListesi' field */
    public tr.com.siparis.sistemi.kafka.model.SalataKafkaModel.Builder clearSalataListesi() {
      salataListesi = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public SalataKafkaModel build() {
      try {
        SalataKafkaModel record = new SalataKafkaModel();
        record.salataListesi = fieldSetFlags()[0] ? this.salataListesi : (java.util.List<tr.com.siparis.sistemi.kafka.model.Salata>) defaultValue(fields()[0]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
