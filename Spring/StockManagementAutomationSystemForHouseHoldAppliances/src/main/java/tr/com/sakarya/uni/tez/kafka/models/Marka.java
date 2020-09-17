/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package tr.com.sakarya.uni.tez.kafka.models;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Marka extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Marka\",\"namespace\":\"tr.com.sakarya.uni.tez.kafka.models\",\"fields\":[{\"name\":\"marka_adi\",\"type\":[\"null\",\"string\"]},{\"name\":\"marka_id\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence marka_adi;
  @Deprecated public int marka_id;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Marka() {}

  /**
   * All-args constructor.
   */
  public Marka(java.lang.CharSequence marka_adi, java.lang.Integer marka_id) {
    this.marka_adi = marka_adi;
    this.marka_id = marka_id;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return marka_adi;
    case 1: return marka_id;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: marka_adi = (java.lang.CharSequence)value$; break;
    case 1: marka_id = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'marka_adi' field.
   */
  public java.lang.CharSequence getMarkaAdi() {
    return marka_adi;
  }

  /**
   * Sets the value of the 'marka_adi' field.
   * @param value the value to set.
   */
  public void setMarkaAdi(java.lang.CharSequence value) {
    this.marka_adi = value;
  }

  /**
   * Gets the value of the 'marka_id' field.
   */
  public java.lang.Integer getMarkaId() {
    return marka_id;
  }

  /**
   * Sets the value of the 'marka_id' field.
   * @param value the value to set.
   */
  public void setMarkaId(java.lang.Integer value) {
    this.marka_id = value;
  }

  /** Creates a new Marka RecordBuilder */
  public static tr.com.sakarya.uni.tez.kafka.models.Marka.Builder newBuilder() {
    return new tr.com.sakarya.uni.tez.kafka.models.Marka.Builder();
  }
  
  /** Creates a new Marka RecordBuilder by copying an existing Builder */
  public static tr.com.sakarya.uni.tez.kafka.models.Marka.Builder newBuilder(tr.com.sakarya.uni.tez.kafka.models.Marka.Builder other) {
    return new tr.com.sakarya.uni.tez.kafka.models.Marka.Builder(other);
  }
  
  /** Creates a new Marka RecordBuilder by copying an existing Marka instance */
  public static tr.com.sakarya.uni.tez.kafka.models.Marka.Builder newBuilder(tr.com.sakarya.uni.tez.kafka.models.Marka other) {
    return new tr.com.sakarya.uni.tez.kafka.models.Marka.Builder(other);
  }
  
  /**
   * RecordBuilder for Marka instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Marka>
    implements org.apache.avro.data.RecordBuilder<Marka> {

    private java.lang.CharSequence marka_adi;
    private int marka_id;

    /** Creates a new Builder */
    private Builder() {
      super(tr.com.sakarya.uni.tez.kafka.models.Marka.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(tr.com.sakarya.uni.tez.kafka.models.Marka.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.marka_adi)) {
        this.marka_adi = data().deepCopy(fields()[0].schema(), other.marka_adi);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.marka_id)) {
        this.marka_id = data().deepCopy(fields()[1].schema(), other.marka_id);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Marka instance */
    private Builder(tr.com.sakarya.uni.tez.kafka.models.Marka other) {
            super(tr.com.sakarya.uni.tez.kafka.models.Marka.SCHEMA$);
      if (isValidValue(fields()[0], other.marka_adi)) {
        this.marka_adi = data().deepCopy(fields()[0].schema(), other.marka_adi);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.marka_id)) {
        this.marka_id = data().deepCopy(fields()[1].schema(), other.marka_id);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'marka_adi' field */
    public java.lang.CharSequence getMarkaAdi() {
      return marka_adi;
    }
    
    /** Sets the value of the 'marka_adi' field */
    public tr.com.sakarya.uni.tez.kafka.models.Marka.Builder setMarkaAdi(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.marka_adi = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'marka_adi' field has been set */
    public boolean hasMarkaAdi() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'marka_adi' field */
    public tr.com.sakarya.uni.tez.kafka.models.Marka.Builder clearMarkaAdi() {
      marka_adi = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'marka_id' field */
    public java.lang.Integer getMarkaId() {
      return marka_id;
    }
    
    /** Sets the value of the 'marka_id' field */
    public tr.com.sakarya.uni.tez.kafka.models.Marka.Builder setMarkaId(int value) {
      validate(fields()[1], value);
      this.marka_id = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'marka_id' field has been set */
    public boolean hasMarkaId() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'marka_id' field */
    public tr.com.sakarya.uni.tez.kafka.models.Marka.Builder clearMarkaId() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public Marka build() {
      try {
        Marka record = new Marka();
        record.marka_adi = fieldSetFlags()[0] ? this.marka_adi : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.marka_id = fieldSetFlags()[1] ? this.marka_id : (java.lang.Integer) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}