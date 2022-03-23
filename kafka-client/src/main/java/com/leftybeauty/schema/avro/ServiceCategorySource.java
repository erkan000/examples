/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.leftybeauty.schema.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ServiceCategorySource extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -683254045801737721L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ServiceCategorySource\",\"namespace\":\"com.leftybeauty.schema.avro\",\"fields\":[{\"name\":\"serviceCategoryId\",\"type\":\"string\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"parentId\",\"type\":[\"null\",\"string\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ServiceCategorySource> ENCODER =
      new BinaryMessageEncoder<ServiceCategorySource>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ServiceCategorySource> DECODER =
      new BinaryMessageDecoder<ServiceCategorySource>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ServiceCategorySource> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ServiceCategorySource> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ServiceCategorySource> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ServiceCategorySource>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ServiceCategorySource to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ServiceCategorySource from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ServiceCategorySource instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ServiceCategorySource fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence serviceCategoryId;
   private java.lang.CharSequence name;
   private java.lang.CharSequence parentId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ServiceCategorySource() {}

  /**
   * All-args constructor.
   * @param serviceCategoryId The new value for serviceCategoryId
   * @param name The new value for name
   * @param parentId The new value for parentId
   */
  public ServiceCategorySource(java.lang.CharSequence serviceCategoryId, java.lang.CharSequence name, java.lang.CharSequence parentId) {
    this.serviceCategoryId = serviceCategoryId;
    this.name = name;
    this.parentId = parentId;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return serviceCategoryId;
    case 1: return name;
    case 2: return parentId;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: serviceCategoryId = (java.lang.CharSequence)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: parentId = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'serviceCategoryId' field.
   * @return The value of the 'serviceCategoryId' field.
   */
  public java.lang.CharSequence getServiceCategoryId() {
    return serviceCategoryId;
  }


  /**
   * Sets the value of the 'serviceCategoryId' field.
   * @param value the value to set.
   */
  public void setServiceCategoryId(java.lang.CharSequence value) {
    this.serviceCategoryId = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'parentId' field.
   * @return The value of the 'parentId' field.
   */
  public java.lang.CharSequence getParentId() {
    return parentId;
  }


  /**
   * Sets the value of the 'parentId' field.
   * @param value the value to set.
   */
  public void setParentId(java.lang.CharSequence value) {
    this.parentId = value;
  }

  /**
   * Creates a new ServiceCategorySource RecordBuilder.
   * @return A new ServiceCategorySource RecordBuilder
   */
  public static com.leftybeauty.schema.avro.ServiceCategorySource.Builder newBuilder() {
    return new com.leftybeauty.schema.avro.ServiceCategorySource.Builder();
  }

  /**
   * Creates a new ServiceCategorySource RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ServiceCategorySource RecordBuilder
   */
  public static com.leftybeauty.schema.avro.ServiceCategorySource.Builder newBuilder(com.leftybeauty.schema.avro.ServiceCategorySource.Builder other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.ServiceCategorySource.Builder();
    } else {
      return new com.leftybeauty.schema.avro.ServiceCategorySource.Builder(other);
    }
  }

  /**
   * Creates a new ServiceCategorySource RecordBuilder by copying an existing ServiceCategorySource instance.
   * @param other The existing instance to copy.
   * @return A new ServiceCategorySource RecordBuilder
   */
  public static com.leftybeauty.schema.avro.ServiceCategorySource.Builder newBuilder(com.leftybeauty.schema.avro.ServiceCategorySource other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.ServiceCategorySource.Builder();
    } else {
      return new com.leftybeauty.schema.avro.ServiceCategorySource.Builder(other);
    }
  }

  /**
   * RecordBuilder for ServiceCategorySource instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ServiceCategorySource>
    implements org.apache.avro.data.RecordBuilder<ServiceCategorySource> {

    private java.lang.CharSequence serviceCategoryId;
    private java.lang.CharSequence name;
    private java.lang.CharSequence parentId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.leftybeauty.schema.avro.ServiceCategorySource.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.serviceCategoryId)) {
        this.serviceCategoryId = data().deepCopy(fields()[0].schema(), other.serviceCategoryId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.parentId)) {
        this.parentId = data().deepCopy(fields()[2].schema(), other.parentId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing ServiceCategorySource instance
     * @param other The existing instance to copy.
     */
    private Builder(com.leftybeauty.schema.avro.ServiceCategorySource other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.serviceCategoryId)) {
        this.serviceCategoryId = data().deepCopy(fields()[0].schema(), other.serviceCategoryId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.parentId)) {
        this.parentId = data().deepCopy(fields()[2].schema(), other.parentId);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'serviceCategoryId' field.
      * @return The value.
      */
    public java.lang.CharSequence getServiceCategoryId() {
      return serviceCategoryId;
    }


    /**
      * Sets the value of the 'serviceCategoryId' field.
      * @param value The value of 'serviceCategoryId'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ServiceCategorySource.Builder setServiceCategoryId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.serviceCategoryId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'serviceCategoryId' field has been set.
      * @return True if the 'serviceCategoryId' field has been set, false otherwise.
      */
    public boolean hasServiceCategoryId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'serviceCategoryId' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ServiceCategorySource.Builder clearServiceCategoryId() {
      serviceCategoryId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ServiceCategorySource.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ServiceCategorySource.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'parentId' field.
      * @return The value.
      */
    public java.lang.CharSequence getParentId() {
      return parentId;
    }


    /**
      * Sets the value of the 'parentId' field.
      * @param value The value of 'parentId'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ServiceCategorySource.Builder setParentId(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.parentId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'parentId' field has been set.
      * @return True if the 'parentId' field has been set, false otherwise.
      */
    public boolean hasParentId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'parentId' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ServiceCategorySource.Builder clearParentId() {
      parentId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ServiceCategorySource build() {
      try {
        ServiceCategorySource record = new ServiceCategorySource();
        record.serviceCategoryId = fieldSetFlags()[0] ? this.serviceCategoryId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.parentId = fieldSetFlags()[2] ? this.parentId : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ServiceCategorySource>
    WRITER$ = (org.apache.avro.io.DatumWriter<ServiceCategorySource>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ServiceCategorySource>
    READER$ = (org.apache.avro.io.DatumReader<ServiceCategorySource>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.serviceCategoryId);

    out.writeString(this.name);

    if (this.parentId == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.parentId);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.serviceCategoryId = in.readString(this.serviceCategoryId instanceof Utf8 ? (Utf8)this.serviceCategoryId : null);

      this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);

      if (in.readIndex() != 1) {
        in.readNull();
        this.parentId = null;
      } else {
        this.parentId = in.readString(this.parentId instanceof Utf8 ? (Utf8)this.parentId : null);
      }

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.serviceCategoryId = in.readString(this.serviceCategoryId instanceof Utf8 ? (Utf8)this.serviceCategoryId : null);
          break;

        case 1:
          this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.parentId = null;
          } else {
            this.parentId = in.readString(this.parentId instanceof Utf8 ? (Utf8)this.parentId : null);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










