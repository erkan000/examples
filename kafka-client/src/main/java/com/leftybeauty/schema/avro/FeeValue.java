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
public class FeeValue extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6014432613615029260L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FeeValue\",\"namespace\":\"com.leftybeauty.schema.avro\",\"fields\":[{\"name\":\"amount\",\"type\":\"double\"},{\"name\":\"feeType\",\"type\":{\"type\":\"enum\",\"name\":\"FeeTypeEnum\",\"symbols\":[\"Percentage\",\"FlatAmount\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<FeeValue> ENCODER =
      new BinaryMessageEncoder<FeeValue>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<FeeValue> DECODER =
      new BinaryMessageDecoder<FeeValue>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<FeeValue> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<FeeValue> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<FeeValue> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<FeeValue>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this FeeValue to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a FeeValue from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a FeeValue instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static FeeValue fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private double amount;
   private com.leftybeauty.schema.avro.FeeTypeEnum feeType;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public FeeValue() {}

  /**
   * All-args constructor.
   * @param amount The new value for amount
   * @param feeType The new value for feeType
   */
  public FeeValue(java.lang.Double amount, com.leftybeauty.schema.avro.FeeTypeEnum feeType) {
    this.amount = amount;
    this.feeType = feeType;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return amount;
    case 1: return feeType;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: amount = (java.lang.Double)value$; break;
    case 1: feeType = (com.leftybeauty.schema.avro.FeeTypeEnum)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'amount' field.
   * @return The value of the 'amount' field.
   */
  public double getAmount() {
    return amount;
  }


  /**
   * Sets the value of the 'amount' field.
   * @param value the value to set.
   */
  public void setAmount(double value) {
    this.amount = value;
  }

  /**
   * Gets the value of the 'feeType' field.
   * @return The value of the 'feeType' field.
   */
  public com.leftybeauty.schema.avro.FeeTypeEnum getFeeType() {
    return feeType;
  }


  /**
   * Sets the value of the 'feeType' field.
   * @param value the value to set.
   */
  public void setFeeType(com.leftybeauty.schema.avro.FeeTypeEnum value) {
    this.feeType = value;
  }

  /**
   * Creates a new FeeValue RecordBuilder.
   * @return A new FeeValue RecordBuilder
   */
  public static com.leftybeauty.schema.avro.FeeValue.Builder newBuilder() {
    return new com.leftybeauty.schema.avro.FeeValue.Builder();
  }

  /**
   * Creates a new FeeValue RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new FeeValue RecordBuilder
   */
  public static com.leftybeauty.schema.avro.FeeValue.Builder newBuilder(com.leftybeauty.schema.avro.FeeValue.Builder other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.FeeValue.Builder();
    } else {
      return new com.leftybeauty.schema.avro.FeeValue.Builder(other);
    }
  }

  /**
   * Creates a new FeeValue RecordBuilder by copying an existing FeeValue instance.
   * @param other The existing instance to copy.
   * @return A new FeeValue RecordBuilder
   */
  public static com.leftybeauty.schema.avro.FeeValue.Builder newBuilder(com.leftybeauty.schema.avro.FeeValue other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.FeeValue.Builder();
    } else {
      return new com.leftybeauty.schema.avro.FeeValue.Builder(other);
    }
  }

  /**
   * RecordBuilder for FeeValue instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FeeValue>
    implements org.apache.avro.data.RecordBuilder<FeeValue> {

    private double amount;
    private com.leftybeauty.schema.avro.FeeTypeEnum feeType;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.leftybeauty.schema.avro.FeeValue.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.amount)) {
        this.amount = data().deepCopy(fields()[0].schema(), other.amount);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.feeType)) {
        this.feeType = data().deepCopy(fields()[1].schema(), other.feeType);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing FeeValue instance
     * @param other The existing instance to copy.
     */
    private Builder(com.leftybeauty.schema.avro.FeeValue other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.amount)) {
        this.amount = data().deepCopy(fields()[0].schema(), other.amount);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.feeType)) {
        this.feeType = data().deepCopy(fields()[1].schema(), other.feeType);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'amount' field.
      * @return The value.
      */
    public double getAmount() {
      return amount;
    }


    /**
      * Sets the value of the 'amount' field.
      * @param value The value of 'amount'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.FeeValue.Builder setAmount(double value) {
      validate(fields()[0], value);
      this.amount = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'amount' field has been set.
      * @return True if the 'amount' field has been set, false otherwise.
      */
    public boolean hasAmount() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'amount' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.FeeValue.Builder clearAmount() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'feeType' field.
      * @return The value.
      */
    public com.leftybeauty.schema.avro.FeeTypeEnum getFeeType() {
      return feeType;
    }


    /**
      * Sets the value of the 'feeType' field.
      * @param value The value of 'feeType'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.FeeValue.Builder setFeeType(com.leftybeauty.schema.avro.FeeTypeEnum value) {
      validate(fields()[1], value);
      this.feeType = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'feeType' field has been set.
      * @return True if the 'feeType' field has been set, false otherwise.
      */
    public boolean hasFeeType() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'feeType' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.FeeValue.Builder clearFeeType() {
      feeType = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public FeeValue build() {
      try {
        FeeValue record = new FeeValue();
        record.amount = fieldSetFlags()[0] ? this.amount : (java.lang.Double) defaultValue(fields()[0]);
        record.feeType = fieldSetFlags()[1] ? this.feeType : (com.leftybeauty.schema.avro.FeeTypeEnum) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<FeeValue>
    WRITER$ = (org.apache.avro.io.DatumWriter<FeeValue>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<FeeValue>
    READER$ = (org.apache.avro.io.DatumReader<FeeValue>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeDouble(this.amount);

    out.writeEnum(this.feeType.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.amount = in.readDouble();

      this.feeType = com.leftybeauty.schema.avro.FeeTypeEnum.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.amount = in.readDouble();
          break;

        case 1:
          this.feeType = com.leftybeauty.schema.avro.FeeTypeEnum.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










