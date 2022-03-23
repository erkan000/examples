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
public class LeftyProviderServiceUpsert extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7572753632868995937L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"LeftyProviderServiceUpsert\",\"namespace\":\"com.leftybeauty.schema.avro\",\"fields\":[{\"name\":\"leftyProviderServiceId\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"leftyUserId\",\"type\":\"string\"},{\"name\":\"serviceCategoryId\",\"type\":\"string\"},{\"name\":\"price\",\"type\":\"double\"},{\"name\":\"duration\",\"type\":\"int\"},{\"name\":\"description\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"status\",\"type\":{\"type\":\"enum\",\"name\":\"LeftyProviderServiceStatusEnum\",\"symbols\":[\"Active\",\"Paused\",\"Deleted\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<LeftyProviderServiceUpsert> ENCODER =
      new BinaryMessageEncoder<LeftyProviderServiceUpsert>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<LeftyProviderServiceUpsert> DECODER =
      new BinaryMessageDecoder<LeftyProviderServiceUpsert>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<LeftyProviderServiceUpsert> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<LeftyProviderServiceUpsert> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<LeftyProviderServiceUpsert> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<LeftyProviderServiceUpsert>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this LeftyProviderServiceUpsert to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a LeftyProviderServiceUpsert from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a LeftyProviderServiceUpsert instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static LeftyProviderServiceUpsert fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence leftyProviderServiceId;
   private java.lang.CharSequence leftyUserId;
   private java.lang.CharSequence serviceCategoryId;
   private double price;
   private int duration;
   private java.lang.CharSequence description;
   private com.leftybeauty.schema.avro.LeftyProviderServiceStatusEnum status;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public LeftyProviderServiceUpsert() {}

  /**
   * All-args constructor.
   * @param leftyProviderServiceId The new value for leftyProviderServiceId
   * @param leftyUserId The new value for leftyUserId
   * @param serviceCategoryId The new value for serviceCategoryId
   * @param price The new value for price
   * @param duration The new value for duration
   * @param description The new value for description
   * @param status The new value for status
   */
  public LeftyProviderServiceUpsert(java.lang.CharSequence leftyProviderServiceId, java.lang.CharSequence leftyUserId, java.lang.CharSequence serviceCategoryId, java.lang.Double price, java.lang.Integer duration, java.lang.CharSequence description, com.leftybeauty.schema.avro.LeftyProviderServiceStatusEnum status) {
    this.leftyProviderServiceId = leftyProviderServiceId;
    this.leftyUserId = leftyUserId;
    this.serviceCategoryId = serviceCategoryId;
    this.price = price;
    this.duration = duration;
    this.description = description;
    this.status = status;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return leftyProviderServiceId;
    case 1: return leftyUserId;
    case 2: return serviceCategoryId;
    case 3: return price;
    case 4: return duration;
    case 5: return description;
    case 6: return status;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: leftyProviderServiceId = (java.lang.CharSequence)value$; break;
    case 1: leftyUserId = (java.lang.CharSequence)value$; break;
    case 2: serviceCategoryId = (java.lang.CharSequence)value$; break;
    case 3: price = (java.lang.Double)value$; break;
    case 4: duration = (java.lang.Integer)value$; break;
    case 5: description = (java.lang.CharSequence)value$; break;
    case 6: status = (com.leftybeauty.schema.avro.LeftyProviderServiceStatusEnum)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'leftyProviderServiceId' field.
   * @return The value of the 'leftyProviderServiceId' field.
   */
  public java.lang.CharSequence getLeftyProviderServiceId() {
    return leftyProviderServiceId;
  }


  /**
   * Sets the value of the 'leftyProviderServiceId' field.
   * @param value the value to set.
   */
  public void setLeftyProviderServiceId(java.lang.CharSequence value) {
    this.leftyProviderServiceId = value;
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
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public double getPrice() {
    return price;
  }


  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(double value) {
    this.price = value;
  }

  /**
   * Gets the value of the 'duration' field.
   * @return The value of the 'duration' field.
   */
  public int getDuration() {
    return duration;
  }


  /**
   * Sets the value of the 'duration' field.
   * @param value the value to set.
   */
  public void setDuration(int value) {
    this.duration = value;
  }

  /**
   * Gets the value of the 'description' field.
   * @return The value of the 'description' field.
   */
  public java.lang.CharSequence getDescription() {
    return description;
  }


  /**
   * Sets the value of the 'description' field.
   * @param value the value to set.
   */
  public void setDescription(java.lang.CharSequence value) {
    this.description = value;
  }

  /**
   * Gets the value of the 'status' field.
   * @return The value of the 'status' field.
   */
  public com.leftybeauty.schema.avro.LeftyProviderServiceStatusEnum getStatus() {
    return status;
  }


  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(com.leftybeauty.schema.avro.LeftyProviderServiceStatusEnum value) {
    this.status = value;
  }

  /**
   * Creates a new LeftyProviderServiceUpsert RecordBuilder.
   * @return A new LeftyProviderServiceUpsert RecordBuilder
   */
  public static com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder newBuilder() {
    return new com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder();
  }

  /**
   * Creates a new LeftyProviderServiceUpsert RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new LeftyProviderServiceUpsert RecordBuilder
   */
  public static com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder newBuilder(com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder();
    } else {
      return new com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder(other);
    }
  }

  /**
   * Creates a new LeftyProviderServiceUpsert RecordBuilder by copying an existing LeftyProviderServiceUpsert instance.
   * @param other The existing instance to copy.
   * @return A new LeftyProviderServiceUpsert RecordBuilder
   */
  public static com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder newBuilder(com.leftybeauty.schema.avro.LeftyProviderServiceUpsert other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder();
    } else {
      return new com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder(other);
    }
  }

  /**
   * RecordBuilder for LeftyProviderServiceUpsert instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<LeftyProviderServiceUpsert>
    implements org.apache.avro.data.RecordBuilder<LeftyProviderServiceUpsert> {

    private java.lang.CharSequence leftyProviderServiceId;
    private java.lang.CharSequence leftyUserId;
    private java.lang.CharSequence serviceCategoryId;
    private double price;
    private int duration;
    private java.lang.CharSequence description;
    private com.leftybeauty.schema.avro.LeftyProviderServiceStatusEnum status;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.leftyProviderServiceId)) {
        this.leftyProviderServiceId = data().deepCopy(fields()[0].schema(), other.leftyProviderServiceId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.leftyUserId)) {
        this.leftyUserId = data().deepCopy(fields()[1].schema(), other.leftyUserId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.serviceCategoryId)) {
        this.serviceCategoryId = data().deepCopy(fields()[2].schema(), other.serviceCategoryId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.price)) {
        this.price = data().deepCopy(fields()[3].schema(), other.price);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.duration)) {
        this.duration = data().deepCopy(fields()[4].schema(), other.duration);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.description)) {
        this.description = data().deepCopy(fields()[5].schema(), other.description);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.status)) {
        this.status = data().deepCopy(fields()[6].schema(), other.status);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing LeftyProviderServiceUpsert instance
     * @param other The existing instance to copy.
     */
    private Builder(com.leftybeauty.schema.avro.LeftyProviderServiceUpsert other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.leftyProviderServiceId)) {
        this.leftyProviderServiceId = data().deepCopy(fields()[0].schema(), other.leftyProviderServiceId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.leftyUserId)) {
        this.leftyUserId = data().deepCopy(fields()[1].schema(), other.leftyUserId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.serviceCategoryId)) {
        this.serviceCategoryId = data().deepCopy(fields()[2].schema(), other.serviceCategoryId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.price)) {
        this.price = data().deepCopy(fields()[3].schema(), other.price);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.duration)) {
        this.duration = data().deepCopy(fields()[4].schema(), other.duration);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.description)) {
        this.description = data().deepCopy(fields()[5].schema(), other.description);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.status)) {
        this.status = data().deepCopy(fields()[6].schema(), other.status);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'leftyProviderServiceId' field.
      * @return The value.
      */
    public java.lang.CharSequence getLeftyProviderServiceId() {
      return leftyProviderServiceId;
    }


    /**
      * Sets the value of the 'leftyProviderServiceId' field.
      * @param value The value of 'leftyProviderServiceId'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder setLeftyProviderServiceId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.leftyProviderServiceId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'leftyProviderServiceId' field has been set.
      * @return True if the 'leftyProviderServiceId' field has been set, false otherwise.
      */
    public boolean hasLeftyProviderServiceId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'leftyProviderServiceId' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder clearLeftyProviderServiceId() {
      leftyProviderServiceId = null;
      fieldSetFlags()[0] = false;
      return this;
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
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder setLeftyUserId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.leftyUserId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'leftyUserId' field has been set.
      * @return True if the 'leftyUserId' field has been set, false otherwise.
      */
    public boolean hasLeftyUserId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'leftyUserId' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder clearLeftyUserId() {
      leftyUserId = null;
      fieldSetFlags()[1] = false;
      return this;
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
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder setServiceCategoryId(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.serviceCategoryId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'serviceCategoryId' field has been set.
      * @return True if the 'serviceCategoryId' field has been set, false otherwise.
      */
    public boolean hasServiceCategoryId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'serviceCategoryId' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder clearServiceCategoryId() {
      serviceCategoryId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public double getPrice() {
      return price;
    }


    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder setPrice(double value) {
      validate(fields()[3], value);
      this.price = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder clearPrice() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'duration' field.
      * @return The value.
      */
    public int getDuration() {
      return duration;
    }


    /**
      * Sets the value of the 'duration' field.
      * @param value The value of 'duration'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder setDuration(int value) {
      validate(fields()[4], value);
      this.duration = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'duration' field has been set.
      * @return True if the 'duration' field has been set, false otherwise.
      */
    public boolean hasDuration() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'duration' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder clearDuration() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'description' field.
      * @return The value.
      */
    public java.lang.CharSequence getDescription() {
      return description;
    }


    /**
      * Sets the value of the 'description' field.
      * @param value The value of 'description'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder setDescription(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.description = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'description' field has been set.
      * @return True if the 'description' field has been set, false otherwise.
      */
    public boolean hasDescription() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'description' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder clearDescription() {
      description = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'status' field.
      * @return The value.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceStatusEnum getStatus() {
      return status;
    }


    /**
      * Sets the value of the 'status' field.
      * @param value The value of 'status'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder setStatus(com.leftybeauty.schema.avro.LeftyProviderServiceStatusEnum value) {
      validate(fields()[6], value);
      this.status = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'status' field has been set.
      * @return True if the 'status' field has been set, false otherwise.
      */
    public boolean hasStatus() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'status' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderServiceUpsert.Builder clearStatus() {
      status = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public LeftyProviderServiceUpsert build() {
      try {
        LeftyProviderServiceUpsert record = new LeftyProviderServiceUpsert();
        record.leftyProviderServiceId = fieldSetFlags()[0] ? this.leftyProviderServiceId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.leftyUserId = fieldSetFlags()[1] ? this.leftyUserId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.serviceCategoryId = fieldSetFlags()[2] ? this.serviceCategoryId : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.price = fieldSetFlags()[3] ? this.price : (java.lang.Double) defaultValue(fields()[3]);
        record.duration = fieldSetFlags()[4] ? this.duration : (java.lang.Integer) defaultValue(fields()[4]);
        record.description = fieldSetFlags()[5] ? this.description : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.status = fieldSetFlags()[6] ? this.status : (com.leftybeauty.schema.avro.LeftyProviderServiceStatusEnum) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<LeftyProviderServiceUpsert>
    WRITER$ = (org.apache.avro.io.DatumWriter<LeftyProviderServiceUpsert>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<LeftyProviderServiceUpsert>
    READER$ = (org.apache.avro.io.DatumReader<LeftyProviderServiceUpsert>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.leftyProviderServiceId == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.leftyProviderServiceId);
    }

    out.writeString(this.leftyUserId);

    out.writeString(this.serviceCategoryId);

    out.writeDouble(this.price);

    out.writeInt(this.duration);

    if (this.description == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.description);
    }

    out.writeEnum(this.status.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.leftyProviderServiceId = null;
      } else {
        this.leftyProviderServiceId = in.readString(this.leftyProviderServiceId instanceof Utf8 ? (Utf8)this.leftyProviderServiceId : null);
      }

      this.leftyUserId = in.readString(this.leftyUserId instanceof Utf8 ? (Utf8)this.leftyUserId : null);

      this.serviceCategoryId = in.readString(this.serviceCategoryId instanceof Utf8 ? (Utf8)this.serviceCategoryId : null);

      this.price = in.readDouble();

      this.duration = in.readInt();

      if (in.readIndex() != 1) {
        in.readNull();
        this.description = null;
      } else {
        this.description = in.readString(this.description instanceof Utf8 ? (Utf8)this.description : null);
      }

      this.status = com.leftybeauty.schema.avro.LeftyProviderServiceStatusEnum.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 7; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.leftyProviderServiceId = null;
          } else {
            this.leftyProviderServiceId = in.readString(this.leftyProviderServiceId instanceof Utf8 ? (Utf8)this.leftyProviderServiceId : null);
          }
          break;

        case 1:
          this.leftyUserId = in.readString(this.leftyUserId instanceof Utf8 ? (Utf8)this.leftyUserId : null);
          break;

        case 2:
          this.serviceCategoryId = in.readString(this.serviceCategoryId instanceof Utf8 ? (Utf8)this.serviceCategoryId : null);
          break;

        case 3:
          this.price = in.readDouble();
          break;

        case 4:
          this.duration = in.readInt();
          break;

        case 5:
          if (in.readIndex() != 1) {
            in.readNull();
            this.description = null;
          } else {
            this.description = in.readString(this.description instanceof Utf8 ? (Utf8)this.description : null);
          }
          break;

        case 6:
          this.status = com.leftybeauty.schema.avro.LeftyProviderServiceStatusEnum.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










