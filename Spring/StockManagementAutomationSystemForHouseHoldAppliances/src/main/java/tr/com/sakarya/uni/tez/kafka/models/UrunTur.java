/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package tr.com.sakarya.uni.tez.kafka.models;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class UrunTur extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UrunTur\",\"namespace\":\"tr.com.sakarya.uni.tez.kafka.models\",\"fields\":[{\"name\":\"tur_adi\",\"type\":[\"null\",\"string\"]},{\"name\":\"tur_id\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence tur_adi;
  @Deprecated public int tur_id;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public UrunTur() {}

  /**
   * All-args constructor.
   */
  public UrunTur(java.lang.CharSequence tur_adi, java.lang.Integer tur_id) {
    this.tur_adi = tur_adi;
    this.tur_id = tur_id;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return tur_adi;
    case 1: return tur_id;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: tur_adi = (java.lang.CharSequence)value$; break;
    case 1: tur_id = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'tur_adi' field.
   */
  public java.lang.CharSequence getTurAdi() {
    return tur_adi;
  }

  /**
   * Sets the value of the 'tur_adi' field.
   * @param value the value to set.
   */
  public void setTurAdi(java.lang.CharSequence value) {
    this.tur_adi = value;
  }

  /**
   * Gets the value of the 'tur_id' field.
   */
  public java.lang.Integer getTurId() {
    return tur_id;
  }

  /**
   * Sets the value of the 'tur_id' field.
   * @param value the value to set.
   */
  public void setTurId(java.lang.Integer value) {
    this.tur_id = value;
  }

  /** Creates a new UrunTur RecordBuilder */
  public static tr.com.sakarya.uni.tez.kafka.models.UrunTur.Builder newBuilder() {
    return new tr.com.sakarya.uni.tez.kafka.models.UrunTur.Builder();
  }
  
  /** Creates a new UrunTur RecordBuilder by copying an existing Builder */
  public static tr.com.sakarya.uni.tez.kafka.models.UrunTur.Builder newBuilder(tr.com.sakarya.uni.tez.kafka.models.UrunTur.Builder other) {
    return new tr.com.sakarya.uni.tez.kafka.models.UrunTur.Builder(other);
  }
  
  /** Creates a new UrunTur RecordBuilder by copying an existing UrunTur instance */
  public static tr.com.sakarya.uni.tez.kafka.models.UrunTur.Builder newBuilder(tr.com.sakarya.uni.tez.kafka.models.UrunTur other) {
    return new tr.com.sakarya.uni.tez.kafka.models.UrunTur.Builder(other);
  }
  
  /**
   * RecordBuilder for UrunTur instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UrunTur>
    implements org.apache.avro.data.RecordBuilder<UrunTur> {

    private java.lang.CharSequence tur_adi;
    private int tur_id;

    /** Creates a new Builder */
    private Builder() {
      super(tr.com.sakarya.uni.tez.kafka.models.UrunTur.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(tr.com.sakarya.uni.tez.kafka.models.UrunTur.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.tur_adi)) {
        this.tur_adi = data().deepCopy(fields()[0].schema(), other.tur_adi);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tur_id)) {
        this.tur_id = data().deepCopy(fields()[1].schema(), other.tur_id);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing UrunTur instance */
    private Builder(tr.com.sakarya.uni.tez.kafka.models.UrunTur other) {
            super(tr.com.sakarya.uni.tez.kafka.models.UrunTur.SCHEMA$);
      if (isValidValue(fields()[0], other.tur_adi)) {
        this.tur_adi = data().deepCopy(fields()[0].schema(), other.tur_adi);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.tur_id)) {
        this.tur_id = data().deepCopy(fields()[1].schema(), other.tur_id);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'tur_adi' field */
    public java.lang.CharSequence getTurAdi() {
      return tur_adi;
    }
    
    /** Sets the value of the 'tur_adi' field */
    public tr.com.sakarya.uni.tez.kafka.models.UrunTur.Builder setTurAdi(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.tur_adi = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'tur_adi' field has been set */
    public boolean hasTurAdi() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'tur_adi' field */
    public tr.com.sakarya.uni.tez.kafka.models.UrunTur.Builder clearTurAdi() {
      tur_adi = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'tur_id' field */
    public java.lang.Integer getTurId() {
      return tur_id;
    }
    
    /** Sets the value of the 'tur_id' field */
    public tr.com.sakarya.uni.tez.kafka.models.UrunTur.Builder setTurId(int value) {
      validate(fields()[1], value);
      this.tur_id = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'tur_id' field has been set */
    public boolean hasTurId() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'tur_id' field */
    public tr.com.sakarya.uni.tez.kafka.models.UrunTur.Builder clearTurId() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public UrunTur build() {
      try {
        UrunTur record = new UrunTur();
        record.tur_adi = fieldSetFlags()[0] ? this.tur_adi : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.tur_id = fieldSetFlags()[1] ? this.tur_id : (java.lang.Integer) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
