/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package tr.com.sakarya.uni.tez.kafka.models;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Kullanici extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Kullanici\",\"namespace\":\"tr.com.sakarya.uni.tez.kafka.models\",\"fields\":[{\"name\":\"kullaniciTur_id\",\"type\":\"int\"},{\"name\":\"kullanici_adi\",\"type\":[\"null\",\"string\"]},{\"name\":\"kullanici_id\",\"type\":\"int\"},{\"name\":\"kullanici_soyadi\",\"type\":[\"null\",\"string\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int kullaniciTur_id;
  @Deprecated public java.lang.CharSequence kullanici_adi;
  @Deprecated public int kullanici_id;
  @Deprecated public java.lang.CharSequence kullanici_soyadi;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Kullanici() {}

  /**
   * All-args constructor.
   */
  public Kullanici(java.lang.Integer kullaniciTur_id, java.lang.CharSequence kullanici_adi, java.lang.Integer kullanici_id, java.lang.CharSequence kullanici_soyadi) {
    this.kullaniciTur_id = kullaniciTur_id;
    this.kullanici_adi = kullanici_adi;
    this.kullanici_id = kullanici_id;
    this.kullanici_soyadi = kullanici_soyadi;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return kullaniciTur_id;
    case 1: return kullanici_adi;
    case 2: return kullanici_id;
    case 3: return kullanici_soyadi;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: kullaniciTur_id = (java.lang.Integer)value$; break;
    case 1: kullanici_adi = (java.lang.CharSequence)value$; break;
    case 2: kullanici_id = (java.lang.Integer)value$; break;
    case 3: kullanici_soyadi = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'kullaniciTur_id' field.
   */
  public java.lang.Integer getKullaniciTurId() {
    return kullaniciTur_id;
  }

  /**
   * Sets the value of the 'kullaniciTur_id' field.
   * @param value the value to set.
   */
  public void setKullaniciTurId(java.lang.Integer value) {
    this.kullaniciTur_id = value;
  }

  /**
   * Gets the value of the 'kullanici_adi' field.
   */
  public java.lang.CharSequence getKullaniciAdi() {
    return kullanici_adi;
  }

  /**
   * Sets the value of the 'kullanici_adi' field.
   * @param value the value to set.
   */
  public void setKullaniciAdi(java.lang.CharSequence value) {
    this.kullanici_adi = value;
  }

  /**
   * Gets the value of the 'kullanici_id' field.
   */
  public java.lang.Integer getKullaniciId() {
    return kullanici_id;
  }

  /**
   * Sets the value of the 'kullanici_id' field.
   * @param value the value to set.
   */
  public void setKullaniciId(java.lang.Integer value) {
    this.kullanici_id = value;
  }

  /**
   * Gets the value of the 'kullanici_soyadi' field.
   */
  public java.lang.CharSequence getKullaniciSoyadi() {
    return kullanici_soyadi;
  }

  /**
   * Sets the value of the 'kullanici_soyadi' field.
   * @param value the value to set.
   */
  public void setKullaniciSoyadi(java.lang.CharSequence value) {
    this.kullanici_soyadi = value;
  }

  /** Creates a new Kullanici RecordBuilder */
  public static tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder newBuilder() {
    return new tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder();
  }
  
  /** Creates a new Kullanici RecordBuilder by copying an existing Builder */
  public static tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder newBuilder(tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder other) {
    return new tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder(other);
  }
  
  /** Creates a new Kullanici RecordBuilder by copying an existing Kullanici instance */
  public static tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder newBuilder(tr.com.sakarya.uni.tez.kafka.models.Kullanici other) {
    return new tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder(other);
  }
  
  /**
   * RecordBuilder for Kullanici instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Kullanici>
    implements org.apache.avro.data.RecordBuilder<Kullanici> {

    private int kullaniciTur_id;
    private java.lang.CharSequence kullanici_adi;
    private int kullanici_id;
    private java.lang.CharSequence kullanici_soyadi;

    /** Creates a new Builder */
    private Builder() {
      super(tr.com.sakarya.uni.tez.kafka.models.Kullanici.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.kullaniciTur_id)) {
        this.kullaniciTur_id = data().deepCopy(fields()[0].schema(), other.kullaniciTur_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.kullanici_adi)) {
        this.kullanici_adi = data().deepCopy(fields()[1].schema(), other.kullanici_adi);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.kullanici_id)) {
        this.kullanici_id = data().deepCopy(fields()[2].schema(), other.kullanici_id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.kullanici_soyadi)) {
        this.kullanici_soyadi = data().deepCopy(fields()[3].schema(), other.kullanici_soyadi);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Kullanici instance */
    private Builder(tr.com.sakarya.uni.tez.kafka.models.Kullanici other) {
            super(tr.com.sakarya.uni.tez.kafka.models.Kullanici.SCHEMA$);
      if (isValidValue(fields()[0], other.kullaniciTur_id)) {
        this.kullaniciTur_id = data().deepCopy(fields()[0].schema(), other.kullaniciTur_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.kullanici_adi)) {
        this.kullanici_adi = data().deepCopy(fields()[1].schema(), other.kullanici_adi);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.kullanici_id)) {
        this.kullanici_id = data().deepCopy(fields()[2].schema(), other.kullanici_id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.kullanici_soyadi)) {
        this.kullanici_soyadi = data().deepCopy(fields()[3].schema(), other.kullanici_soyadi);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'kullaniciTur_id' field */
    public java.lang.Integer getKullaniciTurId() {
      return kullaniciTur_id;
    }
    
    /** Sets the value of the 'kullaniciTur_id' field */
    public tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder setKullaniciTurId(int value) {
      validate(fields()[0], value);
      this.kullaniciTur_id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'kullaniciTur_id' field has been set */
    public boolean hasKullaniciTurId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'kullaniciTur_id' field */
    public tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder clearKullaniciTurId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'kullanici_adi' field */
    public java.lang.CharSequence getKullaniciAdi() {
      return kullanici_adi;
    }
    
    /** Sets the value of the 'kullanici_adi' field */
    public tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder setKullaniciAdi(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.kullanici_adi = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'kullanici_adi' field has been set */
    public boolean hasKullaniciAdi() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'kullanici_adi' field */
    public tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder clearKullaniciAdi() {
      kullanici_adi = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'kullanici_id' field */
    public java.lang.Integer getKullaniciId() {
      return kullanici_id;
    }
    
    /** Sets the value of the 'kullanici_id' field */
    public tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder setKullaniciId(int value) {
      validate(fields()[2], value);
      this.kullanici_id = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'kullanici_id' field has been set */
    public boolean hasKullaniciId() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'kullanici_id' field */
    public tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder clearKullaniciId() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'kullanici_soyadi' field */
    public java.lang.CharSequence getKullaniciSoyadi() {
      return kullanici_soyadi;
    }
    
    /** Sets the value of the 'kullanici_soyadi' field */
    public tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder setKullaniciSoyadi(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.kullanici_soyadi = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'kullanici_soyadi' field has been set */
    public boolean hasKullaniciSoyadi() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'kullanici_soyadi' field */
    public tr.com.sakarya.uni.tez.kafka.models.Kullanici.Builder clearKullaniciSoyadi() {
      kullanici_soyadi = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public Kullanici build() {
      try {
        Kullanici record = new Kullanici();
        record.kullaniciTur_id = fieldSetFlags()[0] ? this.kullaniciTur_id : (java.lang.Integer) defaultValue(fields()[0]);
        record.kullanici_adi = fieldSetFlags()[1] ? this.kullanici_adi : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.kullanici_id = fieldSetFlags()[2] ? this.kullanici_id : (java.lang.Integer) defaultValue(fields()[2]);
        record.kullanici_soyadi = fieldSetFlags()[3] ? this.kullanici_soyadi : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}