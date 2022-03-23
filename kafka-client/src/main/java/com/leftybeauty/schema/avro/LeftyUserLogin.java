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
public class LeftyUserLogin extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8096910640423473165L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"LeftyUserLogin\",\"namespace\":\"com.leftybeauty.schema.avro\",\"fields\":[{\"name\":\"sessionId\",\"type\":\"string\"},{\"name\":\"leftyUserId\",\"type\":\"string\"},{\"name\":\"deviceId\",\"type\":\"string\"},{\"name\":\"loginTimestamp\",\"type\":\"long\"},{\"name\":\"ipAddress\",\"type\":\"string\"},{\"name\":\"userAgent\",\"type\":\"string\"},{\"name\":\"userTypes\",\"type\":{\"type\":\"enum\",\"name\":\"LeftyPaymentTypeEnum\",\"symbols\":[\"Payment\",\"Refund\"]}},{\"name\":\"email\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<LeftyUserLogin> ENCODER =
      new BinaryMessageEncoder<LeftyUserLogin>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<LeftyUserLogin> DECODER =
      new BinaryMessageDecoder<LeftyUserLogin>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<LeftyUserLogin> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<LeftyUserLogin> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<LeftyUserLogin> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<LeftyUserLogin>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this LeftyUserLogin to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a LeftyUserLogin from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a LeftyUserLogin instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static LeftyUserLogin fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence sessionId;
   private java.lang.CharSequence leftyUserId;
   private java.lang.CharSequence deviceId;
   private long loginTimestamp;
   private java.lang.CharSequence ipAddress;
   private java.lang.CharSequence userAgent;
   private com.leftybeauty.schema.avro.LeftyPaymentTypeEnum userTypes;
   private java.lang.CharSequence email;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public LeftyUserLogin() {}

  /**
   * All-args constructor.
   * @param sessionId The new value for sessionId
   * @param leftyUserId The new value for leftyUserId
   * @param deviceId The new value for deviceId
   * @param loginTimestamp The new value for loginTimestamp
   * @param ipAddress The new value for ipAddress
   * @param userAgent The new value for userAgent
   * @param userTypes The new value for userTypes
   * @param email The new value for email
   */
  public LeftyUserLogin(java.lang.CharSequence sessionId, java.lang.CharSequence leftyUserId, java.lang.CharSequence deviceId, java.lang.Long loginTimestamp, java.lang.CharSequence ipAddress, java.lang.CharSequence userAgent, com.leftybeauty.schema.avro.LeftyPaymentTypeEnum userTypes, java.lang.CharSequence email) {
    this.sessionId = sessionId;
    this.leftyUserId = leftyUserId;
    this.deviceId = deviceId;
    this.loginTimestamp = loginTimestamp;
    this.ipAddress = ipAddress;
    this.userAgent = userAgent;
    this.userTypes = userTypes;
    this.email = email;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return sessionId;
    case 1: return leftyUserId;
    case 2: return deviceId;
    case 3: return loginTimestamp;
    case 4: return ipAddress;
    case 5: return userAgent;
    case 6: return userTypes;
    case 7: return email;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: sessionId = (java.lang.CharSequence)value$; break;
    case 1: leftyUserId = (java.lang.CharSequence)value$; break;
    case 2: deviceId = (java.lang.CharSequence)value$; break;
    case 3: loginTimestamp = (java.lang.Long)value$; break;
    case 4: ipAddress = (java.lang.CharSequence)value$; break;
    case 5: userAgent = (java.lang.CharSequence)value$; break;
    case 6: userTypes = (com.leftybeauty.schema.avro.LeftyPaymentTypeEnum)value$; break;
    case 7: email = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'sessionId' field.
   * @return The value of the 'sessionId' field.
   */
  public java.lang.CharSequence getSessionId() {
    return sessionId;
  }


  /**
   * Sets the value of the 'sessionId' field.
   * @param value the value to set.
   */
  public void setSessionId(java.lang.CharSequence value) {
    this.sessionId = value;
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
   * Gets the value of the 'deviceId' field.
   * @return The value of the 'deviceId' field.
   */
  public java.lang.CharSequence getDeviceId() {
    return deviceId;
  }


  /**
   * Sets the value of the 'deviceId' field.
   * @param value the value to set.
   */
  public void setDeviceId(java.lang.CharSequence value) {
    this.deviceId = value;
  }

  /**
   * Gets the value of the 'loginTimestamp' field.
   * @return The value of the 'loginTimestamp' field.
   */
  public long getLoginTimestamp() {
    return loginTimestamp;
  }


  /**
   * Sets the value of the 'loginTimestamp' field.
   * @param value the value to set.
   */
  public void setLoginTimestamp(long value) {
    this.loginTimestamp = value;
  }

  /**
   * Gets the value of the 'ipAddress' field.
   * @return The value of the 'ipAddress' field.
   */
  public java.lang.CharSequence getIpAddress() {
    return ipAddress;
  }


  /**
   * Sets the value of the 'ipAddress' field.
   * @param value the value to set.
   */
  public void setIpAddress(java.lang.CharSequence value) {
    this.ipAddress = value;
  }

  /**
   * Gets the value of the 'userAgent' field.
   * @return The value of the 'userAgent' field.
   */
  public java.lang.CharSequence getUserAgent() {
    return userAgent;
  }


  /**
   * Sets the value of the 'userAgent' field.
   * @param value the value to set.
   */
  public void setUserAgent(java.lang.CharSequence value) {
    this.userAgent = value;
  }

  /**
   * Gets the value of the 'userTypes' field.
   * @return The value of the 'userTypes' field.
   */
  public com.leftybeauty.schema.avro.LeftyPaymentTypeEnum getUserTypes() {
    return userTypes;
  }


  /**
   * Sets the value of the 'userTypes' field.
   * @param value the value to set.
   */
  public void setUserTypes(com.leftybeauty.schema.avro.LeftyPaymentTypeEnum value) {
    this.userTypes = value;
  }

  /**
   * Gets the value of the 'email' field.
   * @return The value of the 'email' field.
   */
  public java.lang.CharSequence getEmail() {
    return email;
  }


  /**
   * Sets the value of the 'email' field.
   * @param value the value to set.
   */
  public void setEmail(java.lang.CharSequence value) {
    this.email = value;
  }

  /**
   * Creates a new LeftyUserLogin RecordBuilder.
   * @return A new LeftyUserLogin RecordBuilder
   */
  public static com.leftybeauty.schema.avro.LeftyUserLogin.Builder newBuilder() {
    return new com.leftybeauty.schema.avro.LeftyUserLogin.Builder();
  }

  /**
   * Creates a new LeftyUserLogin RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new LeftyUserLogin RecordBuilder
   */
  public static com.leftybeauty.schema.avro.LeftyUserLogin.Builder newBuilder(com.leftybeauty.schema.avro.LeftyUserLogin.Builder other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.LeftyUserLogin.Builder();
    } else {
      return new com.leftybeauty.schema.avro.LeftyUserLogin.Builder(other);
    }
  }

  /**
   * Creates a new LeftyUserLogin RecordBuilder by copying an existing LeftyUserLogin instance.
   * @param other The existing instance to copy.
   * @return A new LeftyUserLogin RecordBuilder
   */
  public static com.leftybeauty.schema.avro.LeftyUserLogin.Builder newBuilder(com.leftybeauty.schema.avro.LeftyUserLogin other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.LeftyUserLogin.Builder();
    } else {
      return new com.leftybeauty.schema.avro.LeftyUserLogin.Builder(other);
    }
  }

  /**
   * RecordBuilder for LeftyUserLogin instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<LeftyUserLogin>
    implements org.apache.avro.data.RecordBuilder<LeftyUserLogin> {

    private java.lang.CharSequence sessionId;
    private java.lang.CharSequence leftyUserId;
    private java.lang.CharSequence deviceId;
    private long loginTimestamp;
    private java.lang.CharSequence ipAddress;
    private java.lang.CharSequence userAgent;
    private com.leftybeauty.schema.avro.LeftyPaymentTypeEnum userTypes;
    private java.lang.CharSequence email;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.leftybeauty.schema.avro.LeftyUserLogin.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.sessionId)) {
        this.sessionId = data().deepCopy(fields()[0].schema(), other.sessionId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.leftyUserId)) {
        this.leftyUserId = data().deepCopy(fields()[1].schema(), other.leftyUserId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.deviceId)) {
        this.deviceId = data().deepCopy(fields()[2].schema(), other.deviceId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.loginTimestamp)) {
        this.loginTimestamp = data().deepCopy(fields()[3].schema(), other.loginTimestamp);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.ipAddress)) {
        this.ipAddress = data().deepCopy(fields()[4].schema(), other.ipAddress);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.userAgent)) {
        this.userAgent = data().deepCopy(fields()[5].schema(), other.userAgent);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.userTypes)) {
        this.userTypes = data().deepCopy(fields()[6].schema(), other.userTypes);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.email)) {
        this.email = data().deepCopy(fields()[7].schema(), other.email);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
    }

    /**
     * Creates a Builder by copying an existing LeftyUserLogin instance
     * @param other The existing instance to copy.
     */
    private Builder(com.leftybeauty.schema.avro.LeftyUserLogin other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.sessionId)) {
        this.sessionId = data().deepCopy(fields()[0].schema(), other.sessionId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.leftyUserId)) {
        this.leftyUserId = data().deepCopy(fields()[1].schema(), other.leftyUserId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.deviceId)) {
        this.deviceId = data().deepCopy(fields()[2].schema(), other.deviceId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.loginTimestamp)) {
        this.loginTimestamp = data().deepCopy(fields()[3].schema(), other.loginTimestamp);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ipAddress)) {
        this.ipAddress = data().deepCopy(fields()[4].schema(), other.ipAddress);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.userAgent)) {
        this.userAgent = data().deepCopy(fields()[5].schema(), other.userAgent);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.userTypes)) {
        this.userTypes = data().deepCopy(fields()[6].schema(), other.userTypes);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.email)) {
        this.email = data().deepCopy(fields()[7].schema(), other.email);
        fieldSetFlags()[7] = true;
      }
    }

    /**
      * Gets the value of the 'sessionId' field.
      * @return The value.
      */
    public java.lang.CharSequence getSessionId() {
      return sessionId;
    }


    /**
      * Sets the value of the 'sessionId' field.
      * @param value The value of 'sessionId'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder setSessionId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.sessionId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'sessionId' field has been set.
      * @return True if the 'sessionId' field has been set, false otherwise.
      */
    public boolean hasSessionId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'sessionId' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder clearSessionId() {
      sessionId = null;
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
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder setLeftyUserId(java.lang.CharSequence value) {
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
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder clearLeftyUserId() {
      leftyUserId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'deviceId' field.
      * @return The value.
      */
    public java.lang.CharSequence getDeviceId() {
      return deviceId;
    }


    /**
      * Sets the value of the 'deviceId' field.
      * @param value The value of 'deviceId'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder setDeviceId(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.deviceId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'deviceId' field has been set.
      * @return True if the 'deviceId' field has been set, false otherwise.
      */
    public boolean hasDeviceId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'deviceId' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder clearDeviceId() {
      deviceId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'loginTimestamp' field.
      * @return The value.
      */
    public long getLoginTimestamp() {
      return loginTimestamp;
    }


    /**
      * Sets the value of the 'loginTimestamp' field.
      * @param value The value of 'loginTimestamp'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder setLoginTimestamp(long value) {
      validate(fields()[3], value);
      this.loginTimestamp = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'loginTimestamp' field has been set.
      * @return True if the 'loginTimestamp' field has been set, false otherwise.
      */
    public boolean hasLoginTimestamp() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'loginTimestamp' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder clearLoginTimestamp() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'ipAddress' field.
      * @return The value.
      */
    public java.lang.CharSequence getIpAddress() {
      return ipAddress;
    }


    /**
      * Sets the value of the 'ipAddress' field.
      * @param value The value of 'ipAddress'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder setIpAddress(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.ipAddress = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'ipAddress' field has been set.
      * @return True if the 'ipAddress' field has been set, false otherwise.
      */
    public boolean hasIpAddress() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'ipAddress' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder clearIpAddress() {
      ipAddress = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'userAgent' field.
      * @return The value.
      */
    public java.lang.CharSequence getUserAgent() {
      return userAgent;
    }


    /**
      * Sets the value of the 'userAgent' field.
      * @param value The value of 'userAgent'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder setUserAgent(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.userAgent = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'userAgent' field has been set.
      * @return True if the 'userAgent' field has been set, false otherwise.
      */
    public boolean hasUserAgent() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'userAgent' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder clearUserAgent() {
      userAgent = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'userTypes' field.
      * @return The value.
      */
    public com.leftybeauty.schema.avro.LeftyPaymentTypeEnum getUserTypes() {
      return userTypes;
    }


    /**
      * Sets the value of the 'userTypes' field.
      * @param value The value of 'userTypes'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder setUserTypes(com.leftybeauty.schema.avro.LeftyPaymentTypeEnum value) {
      validate(fields()[6], value);
      this.userTypes = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'userTypes' field has been set.
      * @return True if the 'userTypes' field has been set, false otherwise.
      */
    public boolean hasUserTypes() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'userTypes' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder clearUserTypes() {
      userTypes = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * @return The value.
      */
    public java.lang.CharSequence getEmail() {
      return email;
    }


    /**
      * Sets the value of the 'email' field.
      * @param value The value of 'email'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder setEmail(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.email = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'email' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.LeftyUserLogin.Builder clearEmail() {
      email = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public LeftyUserLogin build() {
      try {
        LeftyUserLogin record = new LeftyUserLogin();
        record.sessionId = fieldSetFlags()[0] ? this.sessionId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.leftyUserId = fieldSetFlags()[1] ? this.leftyUserId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.deviceId = fieldSetFlags()[2] ? this.deviceId : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.loginTimestamp = fieldSetFlags()[3] ? this.loginTimestamp : (java.lang.Long) defaultValue(fields()[3]);
        record.ipAddress = fieldSetFlags()[4] ? this.ipAddress : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.userAgent = fieldSetFlags()[5] ? this.userAgent : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.userTypes = fieldSetFlags()[6] ? this.userTypes : (com.leftybeauty.schema.avro.LeftyPaymentTypeEnum) defaultValue(fields()[6]);
        record.email = fieldSetFlags()[7] ? this.email : (java.lang.CharSequence) defaultValue(fields()[7]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<LeftyUserLogin>
    WRITER$ = (org.apache.avro.io.DatumWriter<LeftyUserLogin>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<LeftyUserLogin>
    READER$ = (org.apache.avro.io.DatumReader<LeftyUserLogin>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.sessionId);

    out.writeString(this.leftyUserId);

    out.writeString(this.deviceId);

    out.writeLong(this.loginTimestamp);

    out.writeString(this.ipAddress);

    out.writeString(this.userAgent);

    out.writeEnum(this.userTypes.ordinal());

    out.writeString(this.email);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.sessionId = in.readString(this.sessionId instanceof Utf8 ? (Utf8)this.sessionId : null);

      this.leftyUserId = in.readString(this.leftyUserId instanceof Utf8 ? (Utf8)this.leftyUserId : null);

      this.deviceId = in.readString(this.deviceId instanceof Utf8 ? (Utf8)this.deviceId : null);

      this.loginTimestamp = in.readLong();

      this.ipAddress = in.readString(this.ipAddress instanceof Utf8 ? (Utf8)this.ipAddress : null);

      this.userAgent = in.readString(this.userAgent instanceof Utf8 ? (Utf8)this.userAgent : null);

      this.userTypes = com.leftybeauty.schema.avro.LeftyPaymentTypeEnum.values()[in.readEnum()];

      this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);

    } else {
      for (int i = 0; i < 8; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.sessionId = in.readString(this.sessionId instanceof Utf8 ? (Utf8)this.sessionId : null);
          break;

        case 1:
          this.leftyUserId = in.readString(this.leftyUserId instanceof Utf8 ? (Utf8)this.leftyUserId : null);
          break;

        case 2:
          this.deviceId = in.readString(this.deviceId instanceof Utf8 ? (Utf8)this.deviceId : null);
          break;

        case 3:
          this.loginTimestamp = in.readLong();
          break;

        case 4:
          this.ipAddress = in.readString(this.ipAddress instanceof Utf8 ? (Utf8)this.ipAddress : null);
          break;

        case 5:
          this.userAgent = in.readString(this.userAgent instanceof Utf8 ? (Utf8)this.userAgent : null);
          break;

        case 6:
          this.userTypes = com.leftybeauty.schema.avro.LeftyPaymentTypeEnum.values()[in.readEnum()];
          break;

        case 7:
          this.email = in.readString(this.email instanceof Utf8 ? (Utf8)this.email : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










