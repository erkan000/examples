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
public class LeftyProviderMetadataSource extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2877168583912026714L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"LeftyProviderMetadataSource\",\"namespace\":\"com.leftybeauty.schema.avro\",\"fields\":[{\"name\":\"leftyUserId\",\"type\":\"string\"},{\"name\":\"licenceMedia\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"LeftyProviderMediaValue\",\"fields\":[{\"name\":\"storageProviderLocation\",\"type\":\"string\"},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"LeftyProviderLicenceTypeEnum\",\"symbols\":[\"Hair\",\"Nails\"]}}]}}},{\"name\":\"available\",\"type\":\"boolean\"},{\"name\":\"licensePlateNumber\",\"type\":\"string\"},{\"name\":\"licensePlateState\",\"type\":\"string\"},{\"name\":\"experience\",\"type\":\"string\"},{\"name\":\"paymentProviderAccountIdentifier\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<LeftyProviderMetadataSource> ENCODER =
      new BinaryMessageEncoder<LeftyProviderMetadataSource>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<LeftyProviderMetadataSource> DECODER =
      new BinaryMessageDecoder<LeftyProviderMetadataSource>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<LeftyProviderMetadataSource> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<LeftyProviderMetadataSource> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<LeftyProviderMetadataSource> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<LeftyProviderMetadataSource>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this LeftyProviderMetadataSource to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a LeftyProviderMetadataSource from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a LeftyProviderMetadataSource instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static LeftyProviderMetadataSource fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence leftyUserId;
   private java.util.List<com.leftybeauty.schema.avro.LeftyProviderMediaValue> licenceMedia;
   private boolean available;
   private java.lang.CharSequence licensePlateNumber;
   private java.lang.CharSequence licensePlateState;
   private java.lang.CharSequence experience;
   private java.lang.CharSequence paymentProviderAccountIdentifier;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public LeftyProviderMetadataSource() {}

  /**
   * All-args constructor.
   * @param leftyUserId The new value for leftyUserId
   * @param licenceMedia The new value for licenceMedia
   * @param available The new value for available
   * @param licensePlateNumber The new value for licensePlateNumber
   * @param licensePlateState The new value for licensePlateState
   * @param experience The new value for experience
   * @param paymentProviderAccountIdentifier The new value for paymentProviderAccountIdentifier
   */
  public LeftyProviderMetadataSource(java.lang.CharSequence leftyUserId, java.util.List<com.leftybeauty.schema.avro.LeftyProviderMediaValue> licenceMedia, java.lang.Boolean available, java.lang.CharSequence licensePlateNumber, java.lang.CharSequence licensePlateState, java.lang.CharSequence experience, java.lang.CharSequence paymentProviderAccountIdentifier) {
    this.leftyUserId = leftyUserId;
    this.licenceMedia = licenceMedia;
    this.available = available;
    this.licensePlateNumber = licensePlateNumber;
    this.licensePlateState = licensePlateState;
    this.experience = experience;
    this.paymentProviderAccountIdentifier = paymentProviderAccountIdentifier;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return leftyUserId;
    case 1: return licenceMedia;
    case 2: return available;
    case 3: return licensePlateNumber;
    case 4: return licensePlateState;
    case 5: return experience;
    case 6: return paymentProviderAccountIdentifier;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: leftyUserId = (java.lang.CharSequence)value$; break;
    case 1: licenceMedia = (java.util.List<com.leftybeauty.schema.avro.LeftyProviderMediaValue>)value$; break;
    case 2: available = (java.lang.Boolean)value$; break;
    case 3: licensePlateNumber = (java.lang.CharSequence)value$; break;
    case 4: licensePlateState = (java.lang.CharSequence)value$; break;
    case 5: experience = (java.lang.CharSequence)value$; break;
    case 6: paymentProviderAccountIdentifier = (java.lang.CharSequence)value$; break;
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
   * Gets the value of the 'licenceMedia' field.
   * @return The value of the 'licenceMedia' field.
   */
  public java.util.List<com.leftybeauty.schema.avro.LeftyProviderMediaValue> getLicenceMedia() {
    return licenceMedia;
  }


  /**
   * Sets the value of the 'licenceMedia' field.
   * @param value the value to set.
   */
  public void setLicenceMedia(java.util.List<com.leftybeauty.schema.avro.LeftyProviderMediaValue> value) {
    this.licenceMedia = value;
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
   * Gets the value of the 'licensePlateNumber' field.
   * @return The value of the 'licensePlateNumber' field.
   */
  public java.lang.CharSequence getLicensePlateNumber() {
    return licensePlateNumber;
  }


  /**
   * Sets the value of the 'licensePlateNumber' field.
   * @param value the value to set.
   */
  public void setLicensePlateNumber(java.lang.CharSequence value) {
    this.licensePlateNumber = value;
  }

  /**
   * Gets the value of the 'licensePlateState' field.
   * @return The value of the 'licensePlateState' field.
   */
  public java.lang.CharSequence getLicensePlateState() {
    return licensePlateState;
  }


  /**
   * Sets the value of the 'licensePlateState' field.
   * @param value the value to set.
   */
  public void setLicensePlateState(java.lang.CharSequence value) {
    this.licensePlateState = value;
  }

  /**
   * Gets the value of the 'experience' field.
   * @return The value of the 'experience' field.
   */
  public java.lang.CharSequence getExperience() {
    return experience;
  }


  /**
   * Sets the value of the 'experience' field.
   * @param value the value to set.
   */
  public void setExperience(java.lang.CharSequence value) {
    this.experience = value;
  }

  /**
   * Gets the value of the 'paymentProviderAccountIdentifier' field.
   * @return The value of the 'paymentProviderAccountIdentifier' field.
   */
  public java.lang.CharSequence getPaymentProviderAccountIdentifier() {
    return paymentProviderAccountIdentifier;
  }


  /**
   * Sets the value of the 'paymentProviderAccountIdentifier' field.
   * @param value the value to set.
   */
  public void setPaymentProviderAccountIdentifier(java.lang.CharSequence value) {
    this.paymentProviderAccountIdentifier = value;
  }

  /**
   * Creates a new LeftyProviderMetadataSource RecordBuilder.
   * @return A new LeftyProviderMetadataSource RecordBuilder
   */
  public static com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder newBuilder() {
    return new com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder();
  }

  /**
   * Creates a new LeftyProviderMetadataSource RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new LeftyProviderMetadataSource RecordBuilder
   */
  public static com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder newBuilder(com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder();
    } else {
      return new com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder(other);
    }
  }

  /**
   * Creates a new LeftyProviderMetadataSource RecordBuilder by copying an existing LeftyProviderMetadataSource instance.
   * @param other The existing instance to copy.
   * @return A new LeftyProviderMetadataSource RecordBuilder
   */
  public static com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder newBuilder(com.leftybeauty.schema.avro.LeftyProviderMetadataSource other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder();
    } else {
      return new com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder(other);
    }
  }

  /**
   * RecordBuilder for LeftyProviderMetadataSource instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<LeftyProviderMetadataSource>
    implements org.apache.avro.data.RecordBuilder<LeftyProviderMetadataSource> {

    private java.lang.CharSequence leftyUserId;
    private java.util.List<com.leftybeauty.schema.avro.LeftyProviderMediaValue> licenceMedia;
    private boolean available;
    private java.lang.CharSequence licensePlateNumber;
    private java.lang.CharSequence licensePlateState;
    private java.lang.CharSequence experience;
    private java.lang.CharSequence paymentProviderAccountIdentifier;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.leftyUserId)) {
        this.leftyUserId = data().deepCopy(fields()[0].schema(), other.leftyUserId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.licenceMedia)) {
        this.licenceMedia = data().deepCopy(fields()[1].schema(), other.licenceMedia);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.available)) {
        this.available = data().deepCopy(fields()[2].schema(), other.available);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.licensePlateNumber)) {
        this.licensePlateNumber = data().deepCopy(fields()[3].schema(), other.licensePlateNumber);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.licensePlateState)) {
        this.licensePlateState = data().deepCopy(fields()[4].schema(), other.licensePlateState);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.experience)) {
        this.experience = data().deepCopy(fields()[5].schema(), other.experience);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.paymentProviderAccountIdentifier)) {
        this.paymentProviderAccountIdentifier = data().deepCopy(fields()[6].schema(), other.paymentProviderAccountIdentifier);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing LeftyProviderMetadataSource instance
     * @param other The existing instance to copy.
     */
    private Builder(com.leftybeauty.schema.avro.LeftyProviderMetadataSource other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.leftyUserId)) {
        this.leftyUserId = data().deepCopy(fields()[0].schema(), other.leftyUserId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.licenceMedia)) {
        this.licenceMedia = data().deepCopy(fields()[1].schema(), other.licenceMedia);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.available)) {
        this.available = data().deepCopy(fields()[2].schema(), other.available);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.licensePlateNumber)) {
        this.licensePlateNumber = data().deepCopy(fields()[3].schema(), other.licensePlateNumber);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.licensePlateState)) {
        this.licensePlateState = data().deepCopy(fields()[4].schema(), other.licensePlateState);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.experience)) {
        this.experience = data().deepCopy(fields()[5].schema(), other.experience);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.paymentProviderAccountIdentifier)) {
        this.paymentProviderAccountIdentifier = data().deepCopy(fields()[6].schema(), other.paymentProviderAccountIdentifier);
        fieldSetFlags()[6] = true;
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
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder setLeftyUserId(java.lang.CharSequence value) {
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
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder clearLeftyUserId() {
      leftyUserId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'licenceMedia' field.
      * @return The value.
      */
    public java.util.List<com.leftybeauty.schema.avro.LeftyProviderMediaValue> getLicenceMedia() {
      return licenceMedia;
    }


    /**
      * Sets the value of the 'licenceMedia' field.
      * @param value The value of 'licenceMedia'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder setLicenceMedia(java.util.List<com.leftybeauty.schema.avro.LeftyProviderMediaValue> value) {
      validate(fields()[1], value);
      this.licenceMedia = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'licenceMedia' field has been set.
      * @return True if the 'licenceMedia' field has been set, false otherwise.
      */
    public boolean hasLicenceMedia() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'licenceMedia' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder clearLicenceMedia() {
      licenceMedia = null;
      fieldSetFlags()[1] = false;
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
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder setAvailable(boolean value) {
      validate(fields()[2], value);
      this.available = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'available' field has been set.
      * @return True if the 'available' field has been set, false otherwise.
      */
    public boolean hasAvailable() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'available' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder clearAvailable() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'licensePlateNumber' field.
      * @return The value.
      */
    public java.lang.CharSequence getLicensePlateNumber() {
      return licensePlateNumber;
    }


    /**
      * Sets the value of the 'licensePlateNumber' field.
      * @param value The value of 'licensePlateNumber'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder setLicensePlateNumber(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.licensePlateNumber = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'licensePlateNumber' field has been set.
      * @return True if the 'licensePlateNumber' field has been set, false otherwise.
      */
    public boolean hasLicensePlateNumber() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'licensePlateNumber' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder clearLicensePlateNumber() {
      licensePlateNumber = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'licensePlateState' field.
      * @return The value.
      */
    public java.lang.CharSequence getLicensePlateState() {
      return licensePlateState;
    }


    /**
      * Sets the value of the 'licensePlateState' field.
      * @param value The value of 'licensePlateState'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder setLicensePlateState(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.licensePlateState = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'licensePlateState' field has been set.
      * @return True if the 'licensePlateState' field has been set, false otherwise.
      */
    public boolean hasLicensePlateState() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'licensePlateState' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder clearLicensePlateState() {
      licensePlateState = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'experience' field.
      * @return The value.
      */
    public java.lang.CharSequence getExperience() {
      return experience;
    }


    /**
      * Sets the value of the 'experience' field.
      * @param value The value of 'experience'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder setExperience(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.experience = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'experience' field has been set.
      * @return True if the 'experience' field has been set, false otherwise.
      */
    public boolean hasExperience() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'experience' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder clearExperience() {
      experience = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'paymentProviderAccountIdentifier' field.
      * @return The value.
      */
    public java.lang.CharSequence getPaymentProviderAccountIdentifier() {
      return paymentProviderAccountIdentifier;
    }


    /**
      * Sets the value of the 'paymentProviderAccountIdentifier' field.
      * @param value The value of 'paymentProviderAccountIdentifier'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder setPaymentProviderAccountIdentifier(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.paymentProviderAccountIdentifier = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'paymentProviderAccountIdentifier' field has been set.
      * @return True if the 'paymentProviderAccountIdentifier' field has been set, false otherwise.
      */
    public boolean hasPaymentProviderAccountIdentifier() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'paymentProviderAccountIdentifier' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyProviderMetadataSource.Builder clearPaymentProviderAccountIdentifier() {
      paymentProviderAccountIdentifier = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public LeftyProviderMetadataSource build() {
      try {
        LeftyProviderMetadataSource record = new LeftyProviderMetadataSource();
        record.leftyUserId = fieldSetFlags()[0] ? this.leftyUserId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.licenceMedia = fieldSetFlags()[1] ? this.licenceMedia : (java.util.List<com.leftybeauty.schema.avro.LeftyProviderMediaValue>) defaultValue(fields()[1]);
        record.available = fieldSetFlags()[2] ? this.available : (java.lang.Boolean) defaultValue(fields()[2]);
        record.licensePlateNumber = fieldSetFlags()[3] ? this.licensePlateNumber : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.licensePlateState = fieldSetFlags()[4] ? this.licensePlateState : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.experience = fieldSetFlags()[5] ? this.experience : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.paymentProviderAccountIdentifier = fieldSetFlags()[6] ? this.paymentProviderAccountIdentifier : (java.lang.CharSequence) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<LeftyProviderMetadataSource>
    WRITER$ = (org.apache.avro.io.DatumWriter<LeftyProviderMetadataSource>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<LeftyProviderMetadataSource>
    READER$ = (org.apache.avro.io.DatumReader<LeftyProviderMetadataSource>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.leftyUserId);

    long size0 = this.licenceMedia.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (com.leftybeauty.schema.avro.LeftyProviderMediaValue e0: this.licenceMedia) {
      actualSize0++;
      out.startItem();
      e0.customEncode(out);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

    out.writeBoolean(this.available);

    out.writeString(this.licensePlateNumber);

    out.writeString(this.licensePlateState);

    out.writeString(this.experience);

    out.writeString(this.paymentProviderAccountIdentifier);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.leftyUserId = in.readString(this.leftyUserId instanceof Utf8 ? (Utf8)this.leftyUserId : null);

      long size0 = in.readArrayStart();
      java.util.List<com.leftybeauty.schema.avro.LeftyProviderMediaValue> a0 = this.licenceMedia;
      if (a0 == null) {
        a0 = new SpecificData.Array<com.leftybeauty.schema.avro.LeftyProviderMediaValue>((int)size0, SCHEMA$.getField("licenceMedia").schema());
        this.licenceMedia = a0;
      } else a0.clear();
      SpecificData.Array<com.leftybeauty.schema.avro.LeftyProviderMediaValue> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<com.leftybeauty.schema.avro.LeftyProviderMediaValue>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          com.leftybeauty.schema.avro.LeftyProviderMediaValue e0 = (ga0 != null ? ga0.peek() : null);
          if (e0 == null) {
            e0 = new com.leftybeauty.schema.avro.LeftyProviderMediaValue();
          }
          e0.customDecode(in);
          a0.add(e0);
        }
      }

      this.available = in.readBoolean();

      this.licensePlateNumber = in.readString(this.licensePlateNumber instanceof Utf8 ? (Utf8)this.licensePlateNumber : null);

      this.licensePlateState = in.readString(this.licensePlateState instanceof Utf8 ? (Utf8)this.licensePlateState : null);

      this.experience = in.readString(this.experience instanceof Utf8 ? (Utf8)this.experience : null);

      this.paymentProviderAccountIdentifier = in.readString(this.paymentProviderAccountIdentifier instanceof Utf8 ? (Utf8)this.paymentProviderAccountIdentifier : null);

    } else {
      for (int i = 0; i < 7; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.leftyUserId = in.readString(this.leftyUserId instanceof Utf8 ? (Utf8)this.leftyUserId : null);
          break;

        case 1:
          long size0 = in.readArrayStart();
          java.util.List<com.leftybeauty.schema.avro.LeftyProviderMediaValue> a0 = this.licenceMedia;
          if (a0 == null) {
            a0 = new SpecificData.Array<com.leftybeauty.schema.avro.LeftyProviderMediaValue>((int)size0, SCHEMA$.getField("licenceMedia").schema());
            this.licenceMedia = a0;
          } else a0.clear();
          SpecificData.Array<com.leftybeauty.schema.avro.LeftyProviderMediaValue> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<com.leftybeauty.schema.avro.LeftyProviderMediaValue>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              com.leftybeauty.schema.avro.LeftyProviderMediaValue e0 = (ga0 != null ? ga0.peek() : null);
              if (e0 == null) {
                e0 = new com.leftybeauty.schema.avro.LeftyProviderMediaValue();
              }
              e0.customDecode(in);
              a0.add(e0);
            }
          }
          break;

        case 2:
          this.available = in.readBoolean();
          break;

        case 3:
          this.licensePlateNumber = in.readString(this.licensePlateNumber instanceof Utf8 ? (Utf8)this.licensePlateNumber : null);
          break;

        case 4:
          this.licensePlateState = in.readString(this.licensePlateState instanceof Utf8 ? (Utf8)this.licensePlateState : null);
          break;

        case 5:
          this.experience = in.readString(this.experience instanceof Utf8 ? (Utf8)this.experience : null);
          break;

        case 6:
          this.paymentProviderAccountIdentifier = in.readString(this.paymentProviderAccountIdentifier instanceof Utf8 ? (Utf8)this.paymentProviderAccountIdentifier : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










