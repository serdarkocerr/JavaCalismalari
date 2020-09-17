/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package tr.com.siparis.sistemi.kafka.model;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DKUserInfo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DKUserInfo\",\"namespace\":\"tr.com.siparis.sistemi.kafka.models\",\"fields\":[{\"name\":\"kullaniciAdi\",\"type\":[\"null\",\"string\"]},{\"name\":\"kullaniciID\",\"type\":\"int\"},{\"name\":\"kullaniciSifre\",\"type\":[\"null\",\"string\"]},{\"name\":\"kullaniciSoyadi\",\"type\":[\"null\",\"string\"]},{\"name\":\"kullaniciTurAdi\",\"type\":[\"null\",\"string\"]},{\"name\":\"kullaniciTurId\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence kullaniciAdi;
  @Deprecated public int kullaniciID;
  @Deprecated public java.lang.CharSequence kullaniciSifre;
  @Deprecated public java.lang.CharSequence kullaniciSoyadi;
  @Deprecated public java.lang.CharSequence kullaniciTurAdi;
  @Deprecated public int kullaniciTurId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public DKUserInfo() {}

  /**
   * All-args constructor.
   */
  public DKUserInfo(java.lang.CharSequence kullaniciAdi, java.lang.Integer kullaniciID, java.lang.CharSequence kullaniciSifre, java.lang.CharSequence kullaniciSoyadi, java.lang.CharSequence kullaniciTurAdi, java.lang.Integer kullaniciTurId) {
    this.kullaniciAdi = kullaniciAdi;
    this.kullaniciID = kullaniciID;
    this.kullaniciSifre = kullaniciSifre;
    this.kullaniciSoyadi = kullaniciSoyadi;
    this.kullaniciTurAdi = kullaniciTurAdi;
    this.kullaniciTurId = kullaniciTurId;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return kullaniciAdi;
    case 1: return kullaniciID;
    case 2: return kullaniciSifre;
    case 3: return kullaniciSoyadi;
    case 4: return kullaniciTurAdi;
    case 5: return kullaniciTurId;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: kullaniciAdi = (java.lang.CharSequence)value$; break;
    case 1: kullaniciID = (java.lang.Integer)value$; break;
    case 2: kullaniciSifre = (java.lang.CharSequence)value$; break;
    case 3: kullaniciSoyadi = (java.lang.CharSequence)value$; break;
    case 4: kullaniciTurAdi = (java.lang.CharSequence)value$; break;
    case 5: kullaniciTurId = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'kullaniciAdi' field.
   */
  public java.lang.CharSequence getKullaniciAdi() {
    return kullaniciAdi;
  }

  /**
   * Sets the value of the 'kullaniciAdi' field.
   * @param value the value to set.
   */
  public void setKullaniciAdi(java.lang.CharSequence value) {
    this.kullaniciAdi = value;
  }

  /**
   * Gets the value of the 'kullaniciID' field.
   */
  public java.lang.Integer getKullaniciID() {
    return kullaniciID;
  }

  /**
   * Sets the value of the 'kullaniciID' field.
   * @param value the value to set.
   */
  public void setKullaniciID(java.lang.Integer value) {
    this.kullaniciID = value;
  }

  /**
   * Gets the value of the 'kullaniciSifre' field.
   */
  public java.lang.CharSequence getKullaniciSifre() {
    return kullaniciSifre;
  }

  /**
   * Sets the value of the 'kullaniciSifre' field.
   * @param value the value to set.
   */
  public void setKullaniciSifre(java.lang.CharSequence value) {
    this.kullaniciSifre = value;
  }

  /**
   * Gets the value of the 'kullaniciSoyadi' field.
   */
  public java.lang.CharSequence getKullaniciSoyadi() {
    return kullaniciSoyadi;
  }

  /**
   * Sets the value of the 'kullaniciSoyadi' field.
   * @param value the value to set.
   */
  public void setKullaniciSoyadi(java.lang.CharSequence value) {
    this.kullaniciSoyadi = value;
  }

  /**
   * Gets the value of the 'kullaniciTurAdi' field.
   */
  public java.lang.CharSequence getKullaniciTurAdi() {
    return kullaniciTurAdi;
  }

  /**
   * Sets the value of the 'kullaniciTurAdi' field.
   * @param value the value to set.
   */
  public void setKullaniciTurAdi(java.lang.CharSequence value) {
    this.kullaniciTurAdi = value;
  }

  /**
   * Gets the value of the 'kullaniciTurId' field.
   */
  public java.lang.Integer getKullaniciTurId() {
    return kullaniciTurId;
  }

  /**
   * Sets the value of the 'kullaniciTurId' field.
   * @param value the value to set.
   */
  public void setKullaniciTurId(java.lang.Integer value) {
    this.kullaniciTurId = value;
  }

  /** Creates a new DKUserInfo RecordBuilder */
  public static tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder newBuilder() {
    return new tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder();
  }
  
  /** Creates a new DKUserInfo RecordBuilder by copying an existing Builder */
  public static tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder newBuilder(tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder other) {
    return new tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder(other);
  }
  
  /** Creates a new DKUserInfo RecordBuilder by copying an existing DKUserInfo instance */
  public static tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder newBuilder(tr.com.siparis.sistemi.kafka.model.DKUserInfo other) {
    return new tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder(other);
  }
  
  /**
   * RecordBuilder for DKUserInfo instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DKUserInfo>
    implements org.apache.avro.data.RecordBuilder<DKUserInfo> {

    private java.lang.CharSequence kullaniciAdi;
    private int kullaniciID;
    private java.lang.CharSequence kullaniciSifre;
    private java.lang.CharSequence kullaniciSoyadi;
    private java.lang.CharSequence kullaniciTurAdi;
    private int kullaniciTurId;

    /** Creates a new Builder */
    private Builder() {
      super(tr.com.siparis.sistemi.kafka.model.DKUserInfo.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.kullaniciAdi)) {
        this.kullaniciAdi = data().deepCopy(fields()[0].schema(), other.kullaniciAdi);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.kullaniciID)) {
        this.kullaniciID = data().deepCopy(fields()[1].schema(), other.kullaniciID);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.kullaniciSifre)) {
        this.kullaniciSifre = data().deepCopy(fields()[2].schema(), other.kullaniciSifre);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.kullaniciSoyadi)) {
        this.kullaniciSoyadi = data().deepCopy(fields()[3].schema(), other.kullaniciSoyadi);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.kullaniciTurAdi)) {
        this.kullaniciTurAdi = data().deepCopy(fields()[4].schema(), other.kullaniciTurAdi);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.kullaniciTurId)) {
        this.kullaniciTurId = data().deepCopy(fields()[5].schema(), other.kullaniciTurId);
        fieldSetFlags()[5] = true;
      }
    }
    
    /** Creates a Builder by copying an existing DKUserInfo instance */
    private Builder(tr.com.siparis.sistemi.kafka.model.DKUserInfo other) {
            super(tr.com.siparis.sistemi.kafka.model.DKUserInfo.SCHEMA$);
      if (isValidValue(fields()[0], other.kullaniciAdi)) {
        this.kullaniciAdi = data().deepCopy(fields()[0].schema(), other.kullaniciAdi);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.kullaniciID)) {
        this.kullaniciID = data().deepCopy(fields()[1].schema(), other.kullaniciID);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.kullaniciSifre)) {
        this.kullaniciSifre = data().deepCopy(fields()[2].schema(), other.kullaniciSifre);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.kullaniciSoyadi)) {
        this.kullaniciSoyadi = data().deepCopy(fields()[3].schema(), other.kullaniciSoyadi);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.kullaniciTurAdi)) {
        this.kullaniciTurAdi = data().deepCopy(fields()[4].schema(), other.kullaniciTurAdi);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.kullaniciTurId)) {
        this.kullaniciTurId = data().deepCopy(fields()[5].schema(), other.kullaniciTurId);
        fieldSetFlags()[5] = true;
      }
    }

    /** Gets the value of the 'kullaniciAdi' field */
    public java.lang.CharSequence getKullaniciAdi() {
      return kullaniciAdi;
    }
    
    /** Sets the value of the 'kullaniciAdi' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder setKullaniciAdi(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.kullaniciAdi = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'kullaniciAdi' field has been set */
    public boolean hasKullaniciAdi() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'kullaniciAdi' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder clearKullaniciAdi() {
      kullaniciAdi = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'kullaniciID' field */
    public java.lang.Integer getKullaniciID() {
      return kullaniciID;
    }
    
    /** Sets the value of the 'kullaniciID' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder setKullaniciID(int value) {
      validate(fields()[1], value);
      this.kullaniciID = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'kullaniciID' field has been set */
    public boolean hasKullaniciID() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'kullaniciID' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder clearKullaniciID() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'kullaniciSifre' field */
    public java.lang.CharSequence getKullaniciSifre() {
      return kullaniciSifre;
    }
    
    /** Sets the value of the 'kullaniciSifre' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder setKullaniciSifre(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.kullaniciSifre = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'kullaniciSifre' field has been set */
    public boolean hasKullaniciSifre() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'kullaniciSifre' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder clearKullaniciSifre() {
      kullaniciSifre = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'kullaniciSoyadi' field */
    public java.lang.CharSequence getKullaniciSoyadi() {
      return kullaniciSoyadi;
    }
    
    /** Sets the value of the 'kullaniciSoyadi' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder setKullaniciSoyadi(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.kullaniciSoyadi = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'kullaniciSoyadi' field has been set */
    public boolean hasKullaniciSoyadi() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'kullaniciSoyadi' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder clearKullaniciSoyadi() {
      kullaniciSoyadi = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'kullaniciTurAdi' field */
    public java.lang.CharSequence getKullaniciTurAdi() {
      return kullaniciTurAdi;
    }
    
    /** Sets the value of the 'kullaniciTurAdi' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder setKullaniciTurAdi(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.kullaniciTurAdi = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'kullaniciTurAdi' field has been set */
    public boolean hasKullaniciTurAdi() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'kullaniciTurAdi' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder clearKullaniciTurAdi() {
      kullaniciTurAdi = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'kullaniciTurId' field */
    public java.lang.Integer getKullaniciTurId() {
      return kullaniciTurId;
    }
    
    /** Sets the value of the 'kullaniciTurId' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder setKullaniciTurId(int value) {
      validate(fields()[5], value);
      this.kullaniciTurId = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'kullaniciTurId' field has been set */
    public boolean hasKullaniciTurId() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'kullaniciTurId' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfo.Builder clearKullaniciTurId() {
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public DKUserInfo build() {
      try {
        DKUserInfo record = new DKUserInfo();
        record.kullaniciAdi = fieldSetFlags()[0] ? this.kullaniciAdi : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.kullaniciID = fieldSetFlags()[1] ? this.kullaniciID : (java.lang.Integer) defaultValue(fields()[1]);
        record.kullaniciSifre = fieldSetFlags()[2] ? this.kullaniciSifre : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.kullaniciSoyadi = fieldSetFlags()[3] ? this.kullaniciSoyadi : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.kullaniciTurAdi = fieldSetFlags()[4] ? this.kullaniciTurAdi : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.kullaniciTurId = fieldSetFlags()[5] ? this.kullaniciTurId : (java.lang.Integer) defaultValue(fields()[5]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
