/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package tr.com.siparis.sistemi.kafka.model;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DKUserInfoTable extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DKUserInfoTable\",\"namespace\":\"tr.com.siparis.sistemi.kafka.model\",\"fields\":[{\"name\":\"userInfoTable\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"DKUserInfo\",\"fields\":[{\"name\":\"kullaniciAdi\",\"type\":[\"null\",\"string\"]},{\"name\":\"kullaniciID\",\"type\":\"int\"},{\"name\":\"kullaniciSifre\",\"type\":[\"null\",\"string\"]},{\"name\":\"kullaniciSoyadi\",\"type\":[\"null\",\"string\"]},{\"name\":\"kullaniciTurAdi\",\"type\":[\"null\",\"string\"]},{\"name\":\"kullaniciTurId\",\"type\":\"int\"}]}}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.util.List<tr.com.siparis.sistemi.kafka.model.DKUserInfo> userInfoTable;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public DKUserInfoTable() {}

  /**
   * All-args constructor.
   */
  public DKUserInfoTable(java.util.List<tr.com.siparis.sistemi.kafka.model.DKUserInfo> userInfoTable) {
    this.userInfoTable = userInfoTable;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return userInfoTable;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: userInfoTable = (java.util.List<tr.com.siparis.sistemi.kafka.model.DKUserInfo>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'userInfoTable' field.
   */
  public java.util.List<tr.com.siparis.sistemi.kafka.model.DKUserInfo> getUserInfoTable() {
    return userInfoTable;
  }

  /**
   * Sets the value of the 'userInfoTable' field.
   * @param value the value to set.
   */
  public void setUserInfoTable(java.util.List<tr.com.siparis.sistemi.kafka.model.DKUserInfo> value) {
    this.userInfoTable = value;
  }

  /** Creates a new DKUserInfoTable RecordBuilder */
  public static tr.com.siparis.sistemi.kafka.model.DKUserInfoTable.Builder newBuilder() {
    return new tr.com.siparis.sistemi.kafka.model.DKUserInfoTable.Builder();
  }
  
  /** Creates a new DKUserInfoTable RecordBuilder by copying an existing Builder */
  public static tr.com.siparis.sistemi.kafka.model.DKUserInfoTable.Builder newBuilder(tr.com.siparis.sistemi.kafka.model.DKUserInfoTable.Builder other) {
    return new tr.com.siparis.sistemi.kafka.model.DKUserInfoTable.Builder(other);
  }
  
  /** Creates a new DKUserInfoTable RecordBuilder by copying an existing DKUserInfoTable instance */
  public static tr.com.siparis.sistemi.kafka.model.DKUserInfoTable.Builder newBuilder(tr.com.siparis.sistemi.kafka.model.DKUserInfoTable other) {
    return new tr.com.siparis.sistemi.kafka.model.DKUserInfoTable.Builder(other);
  }
  
  /**
   * RecordBuilder for DKUserInfoTable instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DKUserInfoTable>
    implements org.apache.avro.data.RecordBuilder<DKUserInfoTable> {

    private java.util.List<tr.com.siparis.sistemi.kafka.model.DKUserInfo> userInfoTable;

    /** Creates a new Builder */
    private Builder() {
      super(tr.com.siparis.sistemi.kafka.model.DKUserInfoTable.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(tr.com.siparis.sistemi.kafka.model.DKUserInfoTable.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.userInfoTable)) {
        this.userInfoTable = data().deepCopy(fields()[0].schema(), other.userInfoTable);
        fieldSetFlags()[0] = true;
      }
    }
    
    /** Creates a Builder by copying an existing DKUserInfoTable instance */
    private Builder(tr.com.siparis.sistemi.kafka.model.DKUserInfoTable other) {
            super(tr.com.siparis.sistemi.kafka.model.DKUserInfoTable.SCHEMA$);
      if (isValidValue(fields()[0], other.userInfoTable)) {
        this.userInfoTable = data().deepCopy(fields()[0].schema(), other.userInfoTable);
        fieldSetFlags()[0] = true;
      }
    }

    /** Gets the value of the 'userInfoTable' field */
    public java.util.List<tr.com.siparis.sistemi.kafka.model.DKUserInfo> getUserInfoTable() {
      return userInfoTable;
    }
    
    /** Sets the value of the 'userInfoTable' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfoTable.Builder setUserInfoTable(java.util.List<tr.com.siparis.sistemi.kafka.model.DKUserInfo> value) {
      validate(fields()[0], value);
      this.userInfoTable = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'userInfoTable' field has been set */
    public boolean hasUserInfoTable() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'userInfoTable' field */
    public tr.com.siparis.sistemi.kafka.model.DKUserInfoTable.Builder clearUserInfoTable() {
      userInfoTable = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public DKUserInfoTable build() {
      try {
        DKUserInfoTable record = new DKUserInfoTable();
        record.userInfoTable = fieldSetFlags()[0] ? this.userInfoTable : (java.util.List<tr.com.siparis.sistemi.kafka.model.DKUserInfo>) defaultValue(fields()[0]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}