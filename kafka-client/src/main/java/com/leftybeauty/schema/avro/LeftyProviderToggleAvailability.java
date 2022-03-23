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
public class LeftyProviderToggleAvailability extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3977306273717908744L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"LeftyProviderToggleAvailability\",\"namespace\":\"com.leftybeauty.schema.avro\",\"fields\":[{\"name\":\"leftyUserId\",\"type\":\"string\"},{\"name\":\"available\",\"type\":\"boolean\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<LeftyProviderToggleAvailability> ENCODER =
      new BinaryMessageEncoder<LeftyProviderToggleAvailability>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<LeftyProviderToggleAvailability> DECODER =
      new BinaryMessageDecoder<LeftyProviderToggleAvailability>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<LeftyProviderToggleAvailability> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<LeftyProviderToggleAvailability> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<LeftyProviderToggleAvailability> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<LeftyProviderToggleAvailability>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this LeftyProviderToggleAvailability to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a LeftyProviderToggleAvailability from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a LeftyProviderToggleAvailability instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static LeftyProviderToggleAvailability fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence leftyUserId;
   private boolean available;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public LeftyProviderToggleAvailability() {}

  /**
   * All-args constructor.
   * @param leftyUserId The new value for leftyUserId
   * @param available The new value for available
   */
  public LeftyProviderToggleAvailability(java.lang.CharSequence leftyUserId, java.lang.Boolean available) {
    this.leftyUserId = leftyUserId;
    this.available = available;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return leftyUserId;
    case 1: return available;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: leftyUserId = (java.lang.CharSequence)value$; break;
    case 1: available = (java.lang.Boolean)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'leftyUserId' field.
   * @return The value of the 'leftyUserId' field.
   */
  public java.lang.CharSequence getLeftyUserId() {
    return leftyUserId;
  }


  /**
   * Sets the value of the 'leftyUserId' field.
   * @param value the value to set.
   */
  public void setLeftyUserId(java.lang.CharSequence value) {
    this.leftyUserId = value;
  }

  /**
   * Gets the value of the 'available' field.
   * @return The value of the 'available' field.
   */
  public boolean getAvailable() {
    return available;
  }


  /**
   * Sets the value of the 'available' field.
   * @param value the value to set.
   */
  public void setAvailable(boolean value) {
    this.available = value;
  }

  /**
   * Creates a new LeftyProviderToggleAvailability RecordBuilder.
   * @return A new LeftyProviderToggleAvailability RecordBuilder
   */
  public static com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder newBuilder() {
    return new com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder();
  }

  /**
   * Creates a new LeftyProviderToggleAvailability RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new LeftyProviderToggleAvailability RecordBuilder
   */
  public static com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder newBuilder(com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder();
    } else {
      return new com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder(other);
    }
  }

  /**
   * Creates a new LeftyProviderToggleAvailability RecordBuilder by copying an existing LeftyProviderToggleAvailability instance.
   * @param other The existing instance to copy.
   * @return A new LeftyProviderToggleAvailability RecordBuilder
   */
  public static com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder newBuilder(com.leftybeauty.schema.avro.LeftyProviderToggleAvailability other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder();
    } else {
      return new com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder(other);
    }
  }

  /**
   * RecordBuilder for LeftyProviderToggleAvailability instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<LeftyProviderToggleAvailability>
    implements org.apache.avro.data.RecordBuilder<LeftyProviderToggleAvailability> {

    private java.lang.CharSequence leftyUserId;
    private boolean available;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.leftyUserId)) {
        this.leftyUserId = data().deepCopy(fields()[0].schema(), other.leftyUserId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.available)) {
        this.available = data().deepCopy(fields()[1].schema(), other.available);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing LeftyProviderToggleAvailability instance
     * @param other The existing instance to copy.
     */
    private Builder(com.leftybeauty.schema.avro.LeftyProviderToggleAvailability other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.leftyUserId)) {
        this.leftyUserId = data().deepCopy(fields()[0].schema(), other.leftyUserId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.available)) {
        this.available = data().deepCopy(fields()[1].schema(), other.available);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'leftyUserId' field.
      * @return The value.
      */
    public java.lang.CharSequence getLeftyUserId() {
      return leftyUserId;
    }


    /**
      * Sets the value of the 'leftyUserId' field.
      * @param value The value of 'leftyUserId'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder setLeftyUserId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.leftyUserId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'leftyUserId' field has been set.
      * @return True if the 'leftyUserId' field has been set, false otherwise.
      */
    public boolean hasLeftyUserId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'leftyUserId' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder clearLeftyUserId() {
      leftyUserId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'available' field.
      * @return The value.
      */
    public boolean getAvailable() {
      return available;
    }


    /**
      * Sets the value of the 'available' field.
      * @param value The value of 'available'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder setAvailable(boolean value) {
      validate(fields()[1], value);
      this.available = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'available' field has been set.
      * @return True if the 'available' field has been set, false otherwise.
      */
    public boolean hasAvailable() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'available' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderToggleAvailability.Builder clearAvailable() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public LeftyProviderToggleAvailability build() {
      try {
        LeftyProviderToggleAvailability record = new LeftyProviderToggleAvailability();
        record.leftyUserId = fieldSetFlags()[0] ? this.leftyUserId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.available = fieldSetFlags()[1] ? this.available : (java.lang.Boolean) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<LeftyProviderToggleAvailability>
    WRITER$ = (org.apache.avro.io.DatumWriter<LeftyProviderToggleAvailability>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<LeftyProviderToggleAvailability>
    READER$ = (org.apache.avro.io.DatumReader<LeftyProviderToggleAvailability>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.leftyUserId);

    out.writeBoolean(this.available);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.leftyUserId = in.readString(this.leftyUserId instanceof Utf8 ? (Utf8)this.leftyUserId : null);

      this.available = in.readBoolean();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.leftyUserId = in.readString(this.leftyUserId instanceof Utf8 ? (Utf8)this.leftyUserId : null);
          break;

        case 1:
          this.available = in.readBoolean();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









