/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package tr.com.sakarya.uni.tez.kafka.models;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class UKProductCRUD extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UKProductCRUD\",\"namespace\":\"tr.com.sakarya.uni.tez.kafka.models\",\"fields\":[{\"name\":\"crudType\",\"type\":[\"null\",{\"type\":\"enum\",\"name\":\"CRUDType\",\"symbols\":[\"CREATE\",\"READ\",\"DELETE\",\"UPDATE\"]}]},{\"name\":\"depoAdi\",\"type\":[\"null\",\"string\"]},{\"name\":\"depoId\",\"type\":\"int\"},{\"name\":\"markaAdi\",\"type\":[\"null\",\"string\"]},{\"name\":\"markaId\",\"type\":\"int\"},{\"name\":\"urunAdi\",\"type\":[\"null\",\"string\"]},{\"name\":\"urunId\",\"type\":\"int\"},{\"name\":\"urunTurAdi\",\"type\":[\"null\",\"string\"]},{\"name\":\"urunTurId\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public tr.com.sakarya.uni.tez.kafka.models.CRUDType crudType;
  @Deprecated public java.lang.CharSequence depoAdi;
  @Deprecated public int depoId;
  @Deprecated public java.lang.CharSequence markaAdi;
  @Deprecated public int markaId;
  @Deprecated public java.lang.CharSequence urunAdi;
  @Deprecated public int urunId;
  @Deprecated public java.lang.CharSequence urunTurAdi;
  @Deprecated public int urunTurId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public UKProductCRUD() {}

  /**
   * All-args constructor.
   */
  public UKProductCRUD(tr.com.sakarya.uni.tez.kafka.models.CRUDType crudType, java.lang.CharSequence depoAdi, java.lang.Integer depoId, java.lang.CharSequence markaAdi, java.lang.Integer markaId, java.lang.CharSequence urunAdi, java.lang.Integer urunId, java.lang.CharSequence urunTurAdi, java.lang.Integer urunTurId) {
    this.crudType = crudType;
    this.depoAdi = depoAdi;
    this.depoId = depoId;
    this.markaAdi = markaAdi;
    this.markaId = markaId;
    this.urunAdi = urunAdi;
    this.urunId = urunId;
    this.urunTurAdi = urunTurAdi;
    this.urunTurId = urunTurId;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return crudType;
    case 1: return depoAdi;
    case 2: return depoId;
    case 3: return markaAdi;
    case 4: return markaId;
    case 5: return urunAdi;
    case 6: return urunId;
    case 7: return urunTurAdi;
    case 8: return urunTurId;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: crudType = (tr.com.sakarya.uni.tez.kafka.models.CRUDType)value$; break;
    case 1: depoAdi = (java.lang.CharSequence)value$; break;
    case 2: depoId = (java.lang.Integer)value$; break;
    case 3: markaAdi = (java.lang.CharSequence)value$; break;
    case 4: markaId = (java.lang.Integer)value$; break;
    case 5: urunAdi = (java.lang.CharSequence)value$; break;
    case 6: urunId = (java.lang.Integer)value$; break;
    case 7: urunTurAdi = (java.lang.CharSequence)value$; break;
    case 8: urunTurId = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'crudType' field.
   */
  public tr.com.sakarya.uni.tez.kafka.models.CRUDType getCrudType() {
    return crudType;
  }

  /**
   * Sets the value of the 'crudType' field.
   * @param value the value to set.
   */
  public void setCrudType(tr.com.sakarya.uni.tez.kafka.models.CRUDType value) {
    this.crudType = value;
  }

  /**
   * Gets the value of the 'depoAdi' field.
   */
  public java.lang.CharSequence getDepoAdi() {
    return depoAdi;
  }

  /**
   * Sets the value of the 'depoAdi' field.
   * @param value the value to set.
   */
  public void setDepoAdi(java.lang.CharSequence value) {
    this.depoAdi = value;
  }

  /**
   * Gets the value of the 'depoId' field.
   */
  public java.lang.Integer getDepoId() {
    return depoId;
  }

  /**
   * Sets the value of the 'depoId' field.
   * @param value the value to set.
   */
  public void setDepoId(java.lang.Integer value) {
    this.depoId = value;
  }

  /**
   * Gets the value of the 'markaAdi' field.
   */
  public java.lang.CharSequence getMarkaAdi() {
    return markaAdi;
  }

  /**
   * Sets the value of the 'markaAdi' field.
   * @param value the value to set.
   */
  public void setMarkaAdi(java.lang.CharSequence value) {
    this.markaAdi = value;
  }

  /**
   * Gets the value of the 'markaId' field.
   */
  public java.lang.Integer getMarkaId() {
    return markaId;
  }

  /**
   * Sets the value of the 'markaId' field.
   * @param value the value to set.
   */
  public void setMarkaId(java.lang.Integer value) {
    this.markaId = value;
  }

  /**
   * Gets the value of the 'urunAdi' field.
   */
  public java.lang.CharSequence getUrunAdi() {
    return urunAdi;
  }

  /**
   * Sets the value of the 'urunAdi' field.
   * @param value the value to set.
   */
  public void setUrunAdi(java.lang.CharSequence value) {
    this.urunAdi = value;
  }

  /**
   * Gets the value of the 'urunId' field.
   */
  public java.lang.Integer getUrunId() {
    return urunId;
  }

  /**
   * Sets the value of the 'urunId' field.
   * @param value the value to set.
   */
  public void setUrunId(java.lang.Integer value) {
    this.urunId = value;
  }

  /**
   * Gets the value of the 'urunTurAdi' field.
   */
  public java.lang.CharSequence getUrunTurAdi() {
    return urunTurAdi;
  }

  /**
   * Sets the value of the 'urunTurAdi' field.
   * @param value the value to set.
   */
  public void setUrunTurAdi(java.lang.CharSequence value) {
    this.urunTurAdi = value;
  }

  /**
   * Gets the value of the 'urunTurId' field.
   */
  public java.lang.Integer getUrunTurId() {
    return urunTurId;
  }

  /**
   * Sets the value of the 'urunTurId' field.
   * @param value the value to set.
   */
  public void setUrunTurId(java.lang.Integer value) {
    this.urunTurId = value;
  }

  /** Creates a new UKProductCRUD RecordBuilder */
  public static tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder newBuilder() {
    return new tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder();
  }
  
  /** Creates a new UKProductCRUD RecordBuilder by copying an existing Builder */
  public static tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder newBuilder(tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder other) {
    return new tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder(other);
  }
  
  /** Creates a new UKProductCRUD RecordBuilder by copying an existing UKProductCRUD instance */
  public static tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder newBuilder(tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD other) {
    return new tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder(other);
  }
  
  /**
   * RecordBuilder for UKProductCRUD instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UKProductCRUD>
    implements org.apache.avro.data.RecordBuilder<UKProductCRUD> {

    private tr.com.sakarya.uni.tez.kafka.models.CRUDType crudType;
    private java.lang.CharSequence depoAdi;
    private int depoId;
    private java.lang.CharSequence markaAdi;
    private int markaId;
    private java.lang.CharSequence urunAdi;
    private int urunId;
    private java.lang.CharSequence urunTurAdi;
    private int urunTurId;

    /** Creates a new Builder */
    private Builder() {
      super(tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.crudType)) {
        this.crudType = data().deepCopy(fields()[0].schema(), other.crudType);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.depoAdi)) {
        this.depoAdi = data().deepCopy(fields()[1].schema(), other.depoAdi);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.depoId)) {
        this.depoId = data().deepCopy(fields()[2].schema(), other.depoId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.markaAdi)) {
        this.markaAdi = data().deepCopy(fields()[3].schema(), other.markaAdi);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.markaId)) {
        this.markaId = data().deepCopy(fields()[4].schema(), other.markaId);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.urunAdi)) {
        this.urunAdi = data().deepCopy(fields()[5].schema(), other.urunAdi);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.urunId)) {
        this.urunId = data().deepCopy(fields()[6].schema(), other.urunId);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.urunTurAdi)) {
        this.urunTurAdi = data().deepCopy(fields()[7].schema(), other.urunTurAdi);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.urunTurId)) {
        this.urunTurId = data().deepCopy(fields()[8].schema(), other.urunTurId);
        fieldSetFlags()[8] = true;
      }
    }
    
    /** Creates a Builder by copying an existing UKProductCRUD instance */
    private Builder(tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD other) {
            super(tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.SCHEMA$);
      if (isValidValue(fields()[0], other.crudType)) {
        this.crudType = data().deepCopy(fields()[0].schema(), other.crudType);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.depoAdi)) {
        this.depoAdi = data().deepCopy(fields()[1].schema(), other.depoAdi);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.depoId)) {
        this.depoId = data().deepCopy(fields()[2].schema(), other.depoId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.markaAdi)) {
        this.markaAdi = data().deepCopy(fields()[3].schema(), other.markaAdi);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.markaId)) {
        this.markaId = data().deepCopy(fields()[4].schema(), other.markaId);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.urunAdi)) {
        this.urunAdi = data().deepCopy(fields()[5].schema(), other.urunAdi);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.urunId)) {
        this.urunId = data().deepCopy(fields()[6].schema(), other.urunId);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.urunTurAdi)) {
        this.urunTurAdi = data().deepCopy(fields()[7].schema(), other.urunTurAdi);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.urunTurId)) {
        this.urunTurId = data().deepCopy(fields()[8].schema(), other.urunTurId);
        fieldSetFlags()[8] = true;
      }
    }

    /** Gets the value of the 'crudType' field */
    public tr.com.sakarya.uni.tez.kafka.models.CRUDType getCrudType() {
      return crudType;
    }
    
    /** Sets the value of the 'crudType' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder setCrudType(tr.com.sakarya.uni.tez.kafka.models.CRUDType value) {
      validate(fields()[0], value);
      this.crudType = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'crudType' field has been set */
    public boolean hasCrudType() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'crudType' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder clearCrudType() {
      crudType = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'depoAdi' field */
    public java.lang.CharSequence getDepoAdi() {
      return depoAdi;
    }
    
    /** Sets the value of the 'depoAdi' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder setDepoAdi(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.depoAdi = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'depoAdi' field has been set */
    public boolean hasDepoAdi() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'depoAdi' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder clearDepoAdi() {
      depoAdi = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'depoId' field */
    public java.lang.Integer getDepoId() {
      return depoId;
    }
    
    /** Sets the value of the 'depoId' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder setDepoId(int value) {
      validate(fields()[2], value);
      this.depoId = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'depoId' field has been set */
    public boolean hasDepoId() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'depoId' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder clearDepoId() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'markaAdi' field */
    public java.lang.CharSequence getMarkaAdi() {
      return markaAdi;
    }
    
    /** Sets the value of the 'markaAdi' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder setMarkaAdi(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.markaAdi = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'markaAdi' field has been set */
    public boolean hasMarkaAdi() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'markaAdi' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder clearMarkaAdi() {
      markaAdi = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'markaId' field */
    public java.lang.Integer getMarkaId() {
      return markaId;
    }
    
    /** Sets the value of the 'markaId' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder setMarkaId(int value) {
      validate(fields()[4], value);
      this.markaId = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'markaId' field has been set */
    public boolean hasMarkaId() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'markaId' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder clearMarkaId() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'urunAdi' field */
    public java.lang.CharSequence getUrunAdi() {
      return urunAdi;
    }
    
    /** Sets the value of the 'urunAdi' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder setUrunAdi(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.urunAdi = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'urunAdi' field has been set */
    public boolean hasUrunAdi() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'urunAdi' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder clearUrunAdi() {
      urunAdi = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /** Gets the value of the 'urunId' field */
    public java.lang.Integer getUrunId() {
      return urunId;
    }
    
    /** Sets the value of the 'urunId' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder setUrunId(int value) {
      validate(fields()[6], value);
      this.urunId = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the 'urunId' field has been set */
    public boolean hasUrunId() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the 'urunId' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder clearUrunId() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /** Gets the value of the 'urunTurAdi' field */
    public java.lang.CharSequence getUrunTurAdi() {
      return urunTurAdi;
    }
    
    /** Sets the value of the 'urunTurAdi' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder setUrunTurAdi(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.urunTurAdi = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the 'urunTurAdi' field has been set */
    public boolean hasUrunTurAdi() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the 'urunTurAdi' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder clearUrunTurAdi() {
      urunTurAdi = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /** Gets the value of the 'urunTurId' field */
    public java.lang.Integer getUrunTurId() {
      return urunTurId;
    }
    
    /** Sets the value of the 'urunTurId' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder setUrunTurId(int value) {
      validate(fields()[8], value);
      this.urunTurId = value;
      fieldSetFlags()[8] = true;
      return this; 
    }
    
    /** Checks whether the 'urunTurId' field has been set */
    public boolean hasUrunTurId() {
      return fieldSetFlags()[8];
    }
    
    /** Clears the value of the 'urunTurId' field */
    public tr.com.sakarya.uni.tez.kafka.models.UKProductCRUD.Builder clearUrunTurId() {
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    public UKProductCRUD build() {
      try {
        UKProductCRUD record = new UKProductCRUD();
        record.crudType = fieldSetFlags()[0] ? this.crudType : (tr.com.sakarya.uni.tez.kafka.models.CRUDType) defaultValue(fields()[0]);
        record.depoAdi = fieldSetFlags()[1] ? this.depoAdi : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.depoId = fieldSetFlags()[2] ? this.depoId : (java.lang.Integer) defaultValue(fields()[2]);
        record.markaAdi = fieldSetFlags()[3] ? this.markaAdi : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.markaId = fieldSetFlags()[4] ? this.markaId : (java.lang.Integer) defaultValue(fields()[4]);
        record.urunAdi = fieldSetFlags()[5] ? this.urunAdi : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.urunId = fieldSetFlags()[6] ? this.urunId : (java.lang.Integer) defaultValue(fields()[6]);
        record.urunTurAdi = fieldSetFlags()[7] ? this.urunTurAdi : (java.lang.CharSequence) defaultValue(fields()[7]);
        record.urunTurId = fieldSetFlags()[8] ? this.urunTurId : (java.lang.Integer) defaultValue(fields()[8]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}