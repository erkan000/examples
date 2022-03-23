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
public class FinancialAccountSourceReferenceAt extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4312124621149652699L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FinancialAccountSourceReferenceAt\",\"namespace\":\"com.leftybeauty.schema.avro\",\"fields\":[{\"name\":\"financialAccountId\",\"type\":\"string\"},{\"name\":\"timestamp\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<FinancialAccountSourceReferenceAt> ENCODER =
      new BinaryMessageEncoder<FinancialAccountSourceReferenceAt>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<FinancialAccountSourceReferenceAt> DECODER =
      new BinaryMessageDecoder<FinancialAccountSourceReferenceAt>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<FinancialAccountSourceReferenceAt> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<FinancialAccountSourceReferenceAt> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<FinancialAccountSourceReferenceAt> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<FinancialAccountSourceReferenceAt>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this FinancialAccountSourceReferenceAt to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a FinancialAccountSourceReferenceAt from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a FinancialAccountSourceReferenceAt instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static FinancialAccountSourceReferenceAt fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence financialAccountId;
   private long timestamp;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public FinancialAccountSourceReferenceAt() {}

  /**
   * All-args constructor.
   * @param financialAccountId The new value for financialAccountId
   * @param timestamp The new value for timestamp
   */
  public FinancialAccountSourceReferenceAt(java.lang.CharSequence financialAccountId, java.lang.Long timestamp) {
    this.financialAccountId = financialAccountId;
    this.timestamp = timestamp;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return financialAccountId;
    case 1: return timestamp;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: financialAccountId = (java.lang.CharSequence)value$; break;
    case 1: timestamp = (java.lang.Long)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'financialAccountId' field.
   * @return The value of the 'financialAccountId' field.
   */
  public java.lang.CharSequence getFinancialAccountId() {
    return financialAccountId;
  }


  /**
   * Sets the value of the 'financialAccountId' field.
   * @param value the value to set.
   */
  public void setFinancialAccountId(java.lang.CharSequence value) {
    this.financialAccountId = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return The value of the 'timestamp' field.
   */
  public long getTimestamp() {
    return timestamp;
  }


  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(long value) {
    this.timestamp = value;
  }

  /**
   * Creates a new FinancialAccountSourceReferenceAt RecordBuilder.
   * @return A new FinancialAccountSourceReferenceAt RecordBuilder
   */
  public static com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder newBuilder() {
    return new com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder();
  }

  /**
   * Creates a new FinancialAccountSourceReferenceAt RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new FinancialAccountSourceReferenceAt RecordBuilder
   */
  public static com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder newBuilder(com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder();
    } else {
      return new com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder(other);
    }
  }

  /**
   * Creates a new FinancialAccountSourceReferenceAt RecordBuilder by copying an existing FinancialAccountSourceReferenceAt instance.
   * @param other The existing instance to copy.
   * @return A new FinancialAccountSourceReferenceAt RecordBuilder
   */
  public static com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder newBuilder(com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder();
    } else {
      return new com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder(other);
    }
  }

  /**
   * RecordBuilder for FinancialAccountSourceReferenceAt instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FinancialAccountSourceReferenceAt>
    implements org.apache.avro.data.RecordBuilder<FinancialAccountSourceReferenceAt> {

    private java.lang.CharSequence financialAccountId;
    private long timestamp;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.financialAccountId)) {
        this.financialAccountId = data().deepCopy(fields()[0].schema(), other.financialAccountId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing FinancialAccountSourceReferenceAt instance
     * @param other The existing instance to copy.
     */
    private Builder(com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.financialAccountId)) {
        this.financialAccountId = data().deepCopy(fields()[0].schema(), other.financialAccountId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'financialAccountId' field.
      * @return The value.
      */
    public java.lang.CharSequence getFinancialAccountId() {
      return financialAccountId;
    }


    /**
      * Sets the value of the 'financialAccountId' field.
      * @param value The value of 'financialAccountId'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder setFinancialAccountId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.financialAccountId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'financialAccountId' field has been set.
      * @return True if the 'financialAccountId' field has been set, false otherwise.
      */
    public boolean hasFinancialAccountId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'financialAccountId' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder clearFinancialAccountId() {
      financialAccountId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * @return The value.
      */
    public long getTimestamp() {
      return timestamp;
    }


    /**
      * Sets the value of the 'timestamp' field.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder setTimestamp(long value) {
      validate(fields()[1], value);
      this.timestamp = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.FinancialAccountSourceReferenceAt.Builder clearTimestamp() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public FinancialAccountSourceReferenceAt build() {
      try {
        FinancialAccountSourceReferenceAt record = new FinancialAccountSourceReferenceAt();
        record.financialAccountId = fieldSetFlags()[0] ? this.financialAccountId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.timestamp = fieldSetFlags()[1] ? this.timestamp : (java.lang.Long) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<FinancialAccountSourceReferenceAt>
    WRITER$ = (org.apache.avro.io.DatumWriter<FinancialAccountSourceReferenceAt>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<FinancialAccountSourceReferenceAt>
    READER$ = (org.apache.avro.io.DatumReader<FinancialAccountSourceReferenceAt>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.financialAccountId);

    out.writeLong(this.timestamp);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.financialAccountId = in.readString(this.financialAccountId instanceof Utf8 ? (Utf8)this.financialAccountId : null);

      this.timestamp = in.readLong();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.financialAccountId = in.readString(this.financialAccountId instanceof Utf8 ? (Utf8)this.financialAccountId : null);
          break;

        case 1:
          this.timestamp = in.readLong();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










