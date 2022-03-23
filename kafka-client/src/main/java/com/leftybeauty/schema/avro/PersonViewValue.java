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
public class PersonViewValue extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5711077056253766075L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PersonViewValue\",\"namespace\":\"com.leftybeauty.schema.avro\",\"fields\":[{\"name\":\"leftyUserId\",\"type\":\"string\"},{\"name\":\"firstName\",\"type\":\"string\"},{\"name\":\"lastName\",\"type\":\"string\"},{\"name\":\"avatarUrl\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"MessageActorEnum\",\"symbols\":[\"Client\",\"Provider\",\"System\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<PersonViewValue> ENCODER =
      new BinaryMessageEncoder<PersonViewValue>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PersonViewValue> DECODER =
      new BinaryMessageDecoder<PersonViewValue>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PersonViewValue> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PersonViewValue> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PersonViewValue> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<PersonViewValue>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PersonViewValue to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PersonViewValue from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PersonViewValue instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static PersonViewValue fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence leftyUserId;
   private java.lang.CharSequence firstName;
   private java.lang.CharSequence lastName;
   private java.lang.CharSequence avatarUrl;
   private com.leftybeauty.schema.avro.MessageActorEnum type;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PersonViewValue() {}

  /**
   * All-args constructor.
   * @param leftyUserId The new value for leftyUserId
   * @param firstName The new value for firstName
   * @param lastName The new value for lastName
   * @param avatarUrl The new value for avatarUrl
   * @param type The new value for type
   */
  public PersonViewValue(java.lang.CharSequence leftyUserId, java.lang.CharSequence firstName, java.lang.CharSequence lastName, java.lang.CharSequence avatarUrl, com.leftybeauty.schema.avro.MessageActorEnum type) {
    this.leftyUserId = leftyUserId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.avatarUrl = avatarUrl;
    this.type = type;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return leftyUserId;
    case 1: return firstName;
    case 2: return lastName;
    case 3: return avatarUrl;
    case 4: return type;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: leftyUserId = (java.lang.CharSequence)value$; break;
    case 1: firstName = (java.lang.CharSequence)value$; break;
    case 2: lastName = (java.lang.CharSequence)value$; break;
    case 3: avatarUrl = (java.lang.CharSequence)value$; break;
    case 4: type = (com.leftybeauty.schema.avro.MessageActorEnum)value$; break;
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
   * Gets the value of the 'firstName' field.
   * @return The value of the 'firstName' field.
   */
  public java.lang.CharSequence getFirstName() {
    return firstName;
  }


  /**
   * Sets the value of the 'firstName' field.
   * @param value the value to set.
   */
  public void setFirstName(java.lang.CharSequence value) {
    this.firstName = value;
  }

  /**
   * Gets the value of the 'lastName' field.
   * @return The value of the 'lastName' field.
   */
  public java.lang.CharSequence getLastName() {
    return lastName;
  }


  /**
   * Sets the value of the 'lastName' field.
   * @param value the value to set.
   */
  public void setLastName(java.lang.CharSequence value) {
    this.lastName = value;
  }

  /**
   * Gets the value of the 'avatarUrl' field.
   * @return The value of the 'avatarUrl' field.
   */
  public java.lang.CharSequence getAvatarUrl() {
    return avatarUrl;
  }


  /**
   * Sets the value of the 'avatarUrl' field.
   * @param value the value to set.
   */
  public void setAvatarUrl(java.lang.CharSequence value) {
    this.avatarUrl = value;
  }

  /**
   * Gets the value of the 'type' field.
   * @return The value of the 'type' field.
   */
  public com.leftybeauty.schema.avro.MessageActorEnum getType() {
    return type;
  }


  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(com.leftybeauty.schema.avro.MessageActorEnum value) {
    this.type = value;
  }

  /**
   * Creates a new PersonViewValue RecordBuilder.
   * @return A new PersonViewValue RecordBuilder
   */
  public static com.leftybeauty.schema.avro.PersonViewValue.Builder newBuilder() {
    return new com.leftybeauty.schema.avro.PersonViewValue.Builder();
  }

  /**
   * Creates a new PersonViewValue RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PersonViewValue RecordBuilder
   */
  public static com.leftybeauty.schema.avro.PersonViewValue.Builder newBuilder(com.leftybeauty.schema.avro.PersonViewValue.Builder other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.PersonViewValue.Builder();
    } else {
      return new com.leftybeauty.schema.avro.PersonViewValue.Builder(other);
    }
  }

  /**
   * Creates a new PersonViewValue RecordBuilder by copying an existing PersonViewValue instance.
   * @param other The existing instance to copy.
   * @return A new PersonViewValue RecordBuilder
   */
  public static com.leftybeauty.schema.avro.PersonViewValue.Builder newBuilder(com.leftybeauty.schema.avro.PersonViewValue other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.PersonViewValue.Builder();
    } else {
      return new com.leftybeauty.schema.avro.PersonViewValue.Builder(other);
    }
  }

  /**
   * RecordBuilder for PersonViewValue instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PersonViewValue>
    implements org.apache.avro.data.RecordBuilder<PersonViewValue> {

    private java.lang.CharSequence leftyUserId;
    private java.lang.CharSequence firstName;
    private java.lang.CharSequence lastName;
    private java.lang.CharSequence avatarUrl;
    private com.leftybeauty.schema.avro.MessageActorEnum type;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.leftybeauty.schema.avro.PersonViewValue.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.leftyUserId)) {
        this.leftyUserId = data().deepCopy(fields()[0].schema(), other.leftyUserId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.firstName)) {
        this.firstName = data().deepCopy(fields()[1].schema(), other.firstName);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.lastName)) {
        this.lastName = data().deepCopy(fields()[2].schema(), other.lastName);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.avatarUrl)) {
        this.avatarUrl = data().deepCopy(fields()[3].schema(), other.avatarUrl);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.type)) {
        this.type = data().deepCopy(fields()[4].schema(), other.type);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing PersonViewValue instance
     * @param other The existing instance to copy.
     */
    private Builder(com.leftybeauty.schema.avro.PersonViewValue other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.leftyUserId)) {
        this.leftyUserId = data().deepCopy(fields()[0].schema(), other.leftyUserId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.firstName)) {
        this.firstName = data().deepCopy(fields()[1].schema(), other.firstName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.lastName)) {
        this.lastName = data().deepCopy(fields()[2].schema(), other.lastName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.avatarUrl)) {
        this.avatarUrl = data().deepCopy(fields()[3].schema(), other.avatarUrl);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.type)) {
        this.type = data().deepCopy(fields()[4].schema(), other.type);
        fieldSetFlags()[4] = true;
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
    public com.leftybeauty.schema.avro.PersonViewValue.Builder setLeftyUserId(java.lang.CharSequence value) {
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
    public com.leftybeauty.schema.avro.PersonViewValue.Builder clearLeftyUserId() {
      leftyUserId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'firstName' field.
      * @return The value.
      */
    public java.lang.CharSequence getFirstName() {
      return firstName;
    }


    /**
      * Sets the value of the 'firstName' field.
      * @param value The value of 'firstName'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.PersonViewValue.Builder setFirstName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.firstName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'firstName' field has been set.
      * @return True if the 'firstName' field has been set, false otherwise.
      */
    public boolean hasFirstName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'firstName' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.PersonViewValue.Builder clearFirstName() {
      firstName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'lastName' field.
      * @return The value.
      */
    public java.lang.CharSequence getLastName() {
      return lastName;
    }


    /**
      * Sets the value of the 'lastName' field.
      * @param value The value of 'lastName'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.PersonViewValue.Builder setLastName(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.lastName = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'lastName' field has been set.
      * @return True if the 'lastName' field has been set, false otherwise.
      */
    public boolean hasLastName() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'lastName' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.PersonViewValue.Builder clearLastName() {
      lastName = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'avatarUrl' field.
      * @return The value.
      */
    public java.lang.CharSequence getAvatarUrl() {
      return avatarUrl;
    }


    /**
      * Sets the value of the 'avatarUrl' field.
      * @param value The value of 'avatarUrl'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.PersonViewValue.Builder setAvatarUrl(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.avatarUrl = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'avatarUrl' field has been set.
      * @return True if the 'avatarUrl' field has been set, false otherwise.
      */
    public boolean hasAvatarUrl() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'avatarUrl' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.PersonViewValue.Builder clearAvatarUrl() {
      avatarUrl = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'type' field.
      * @return The value.
      */
    public com.leftybeauty.schema.avro.MessageActorEnum getType() {
      return type;
    }


    /**
      * Sets the value of the 'type' field.
      * @param value The value of 'type'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.PersonViewValue.Builder setType(com.leftybeauty.schema.avro.MessageActorEnum value) {
      validate(fields()[4], value);
      this.type = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'type' field has been set.
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'type' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.PersonViewValue.Builder clearType() {
      type = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PersonViewValue build() {
      try {
        PersonViewValue record = new PersonViewValue();
        record.leftyUserId = fieldSetFlags()[0] ? this.leftyUserId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.firstName = fieldSetFlags()[1] ? this.firstName : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.lastName = fieldSetFlags()[2] ? this.lastName : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.avatarUrl = fieldSetFlags()[3] ? this.avatarUrl : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.type = fieldSetFlags()[4] ? this.type : (com.leftybeauty.schema.avro.MessageActorEnum) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PersonViewValue>
    WRITER$ = (org.apache.avro.io.DatumWriter<PersonViewValue>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PersonViewValue>
    READER$ = (org.apache.avro.io.DatumReader<PersonViewValue>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.leftyUserId);

    out.writeString(this.firstName);

    out.writeString(this.lastName);

    if (this.avatarUrl == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.avatarUrl);
    }

    out.writeEnum(this.type.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.leftyUserId = in.readString(this.leftyUserId instanceof Utf8 ? (Utf8)this.leftyUserId : null);

      this.firstName = in.readString(this.firstName instanceof Utf8 ? (Utf8)this.firstName : null);

      this.lastName = in.readString(this.lastName instanceof Utf8 ? (Utf8)this.lastName : null);

      if (in.readIndex() != 1) {
        in.readNull();
        this.avatarUrl = null;
      } else {
        this.avatarUrl = in.readString(this.avatarUrl instanceof Utf8 ? (Utf8)this.avatarUrl : null);
      }

      this.type = com.leftybeauty.schema.avro.MessageActorEnum.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.leftyUserId = in.readString(this.leftyUserId instanceof Utf8 ? (Utf8)this.leftyUserId : null);
          break;

        case 1:
          this.firstName = in.readString(this.firstName instanceof Utf8 ? (Utf8)this.firstName : null);
          break;

        case 2:
          this.lastName = in.readString(this.lastName instanceof Utf8 ? (Utf8)this.lastName : null);
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.avatarUrl = null;
          } else {
            this.avatarUrl = in.readString(this.avatarUrl instanceof Utf8 ? (Utf8)this.avatarUrl : null);
          }
          break;

        case 4:
          this.type = com.leftybeauty.schema.avro.MessageActorEnum.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









