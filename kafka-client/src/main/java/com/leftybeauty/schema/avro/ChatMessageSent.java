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
public class ChatMessageSent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7816251904873107050L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ChatMessageSent\",\"namespace\":\"com.leftybeauty.schema.avro\",\"fields\":[{\"name\":\"appointmentId\",\"type\":\"string\"},{\"name\":\"message\",\"type\":\"string\"},{\"name\":\"timestamp\",\"type\":{\"type\":\"long\",\"logicalType\":\"Timestamp\"}},{\"name\":\"actor\",\"type\":{\"type\":\"enum\",\"name\":\"MessageActorEnum\",\"symbols\":[\"Client\",\"Provider\",\"System\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ChatMessageSent> ENCODER =
      new BinaryMessageEncoder<ChatMessageSent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ChatMessageSent> DECODER =
      new BinaryMessageDecoder<ChatMessageSent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ChatMessageSent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ChatMessageSent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ChatMessageSent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ChatMessageSent>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ChatMessageSent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ChatMessageSent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ChatMessageSent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ChatMessageSent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence appointmentId;
   private java.lang.CharSequence message;
   private long timestamp;
   private com.leftybeauty.schema.avro.MessageActorEnum actor;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ChatMessageSent() {}

  /**
   * All-args constructor.
   * @param appointmentId The new value for appointmentId
   * @param message The new value for message
   * @param timestamp The new value for timestamp
   * @param actor The new value for actor
   */
  public ChatMessageSent(java.lang.CharSequence appointmentId, java.lang.CharSequence message, java.lang.Long timestamp, com.leftybeauty.schema.avro.MessageActorEnum actor) {
    this.appointmentId = appointmentId;
    this.message = message;
    this.timestamp = timestamp;
    this.actor = actor;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return appointmentId;
    case 1: return message;
    case 2: return timestamp;
    case 3: return actor;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: appointmentId = (java.lang.CharSequence)value$; break;
    case 1: message = (java.lang.CharSequence)value$; break;
    case 2: timestamp = (java.lang.Long)value$; break;
    case 3: actor = (com.leftybeauty.schema.avro.MessageActorEnum)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'appointmentId' field.
   * @return The value of the 'appointmentId' field.
   */
  public java.lang.CharSequence getAppointmentId() {
    return appointmentId;
  }


  /**
   * Sets the value of the 'appointmentId' field.
   * @param value the value to set.
   */
  public void setAppointmentId(java.lang.CharSequence value) {
    this.appointmentId = value;
  }

  /**
   * Gets the value of the 'message' field.
   * @return The value of the 'message' field.
   */
  public java.lang.CharSequence getMessage() {
    return message;
  }


  /**
   * Sets the value of the 'message' field.
   * @param value the value to set.
   */
  public void setMessage(java.lang.CharSequence value) {
    this.message = value;
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
   * Gets the value of the 'actor' field.
   * @return The value of the 'actor' field.
   */
  public com.leftybeauty.schema.avro.MessageActorEnum getActor() {
    return actor;
  }


  /**
   * Sets the value of the 'actor' field.
   * @param value the value to set.
   */
  public void setActor(com.leftybeauty.schema.avro.MessageActorEnum value) {
    this.actor = value;
  }

  /**
   * Creates a new ChatMessageSent RecordBuilder.
   * @return A new ChatMessageSent RecordBuilder
   */
  public static com.leftybeauty.schema.avro.ChatMessageSent.Builder newBuilder() {
    return new com.leftybeauty.schema.avro.ChatMessageSent.Builder();
  }

  /**
   * Creates a new ChatMessageSent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ChatMessageSent RecordBuilder
   */
  public static com.leftybeauty.schema.avro.ChatMessageSent.Builder newBuilder(com.leftybeauty.schema.avro.ChatMessageSent.Builder other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.ChatMessageSent.Builder();
    } else {
      return new com.leftybeauty.schema.avro.ChatMessageSent.Builder(other);
    }
  }

  /**
   * Creates a new ChatMessageSent RecordBuilder by copying an existing ChatMessageSent instance.
   * @param other The existing instance to copy.
   * @return A new ChatMessageSent RecordBuilder
   */
  public static com.leftybeauty.schema.avro.ChatMessageSent.Builder newBuilder(com.leftybeauty.schema.avro.ChatMessageSent other) {
    if (other == null) {
      return new com.leftybeauty.schema.avro.ChatMessageSent.Builder();
    } else {
      return new com.leftybeauty.schema.avro.ChatMessageSent.Builder(other);
    }
  }

  /**
   * RecordBuilder for ChatMessageSent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ChatMessageSent>
    implements org.apache.avro.data.RecordBuilder<ChatMessageSent> {

    private java.lang.CharSequence appointmentId;
    private java.lang.CharSequence message;
    private long timestamp;
    private com.leftybeauty.schema.avro.MessageActorEnum actor;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.leftybeauty.schema.avro.ChatMessageSent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.appointmentId)) {
        this.appointmentId = data().deepCopy(fields()[0].schema(), other.appointmentId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.message)) {
        this.message = data().deepCopy(fields()[1].schema(), other.message);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[2].schema(), other.timestamp);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.actor)) {
        this.actor = data().deepCopy(fields()[3].schema(), other.actor);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing ChatMessageSent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.leftybeauty.schema.avro.ChatMessageSent other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.appointmentId)) {
        this.appointmentId = data().deepCopy(fields()[0].schema(), other.appointmentId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.message)) {
        this.message = data().deepCopy(fields()[1].schema(), other.message);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[2].schema(), other.timestamp);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.actor)) {
        this.actor = data().deepCopy(fields()[3].schema(), other.actor);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'appointmentId' field.
      * @return The value.
      */
    public java.lang.CharSequence getAppointmentId() {
      return appointmentId;
    }


    /**
      * Sets the value of the 'appointmentId' field.
      * @param value The value of 'appointmentId'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ChatMessageSent.Builder setAppointmentId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.appointmentId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'appointmentId' field has been set.
      * @return True if the 'appointmentId' field has been set, false otherwise.
      */
    public boolean hasAppointmentId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'appointmentId' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ChatMessageSent.Builder clearAppointmentId() {
      appointmentId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'message' field.
      * @return The value.
      */
    public java.lang.CharSequence getMessage() {
      return message;
    }


    /**
      * Sets the value of the 'message' field.
      * @param value The value of 'message'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ChatMessageSent.Builder setMessage(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.message = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'message' field has been set.
      * @return True if the 'message' field has been set, false otherwise.
      */
    public boolean hasMessage() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'message' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ChatMessageSent.Builder clearMessage() {
      message = null;
      fieldSetFlags()[1] = false;
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
    public com.leftybeauty.schema.avro.ChatMessageSent.Builder setTimestamp(long value) {
      validate(fields()[2], value);
      this.timestamp = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ChatMessageSent.Builder clearTimestamp() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'actor' field.
      * @return The value.
      */
    public com.leftybeauty.schema.avro.MessageActorEnum getActor() {
      return actor;
    }


    /**
      * Sets the value of the 'actor' field.
      * @param value The value of 'actor'.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ChatMessageSent.Builder setActor(com.leftybeauty.schema.avro.MessageActorEnum value) {
      validate(fields()[3], value);
      this.actor = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'actor' field has been set.
      * @return True if the 'actor' field has been set, false otherwise.
      */
    public boolean hasActor() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'actor' field.
      * @return This builder.
      */
    public com.leftybeauty.schema.avro.ChatMessageSent.Builder clearActor() {
      actor = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ChatMessageSent build() {
      try {
        ChatMessageSent record = new ChatMessageSent();
        record.appointmentId = fieldSetFlags()[0] ? this.appointmentId : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.message = fieldSetFlags()[1] ? this.message : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.timestamp = fieldSetFlags()[2] ? this.timestamp : (java.lang.Long) defaultValue(fields()[2]);
        record.actor = fieldSetFlags()[3] ? this.actor : (com.leftybeauty.schema.avro.MessageActorEnum) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ChatMessageSent>
    WRITER$ = (org.apache.avro.io.DatumWriter<ChatMessageSent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ChatMessageSent>
    READER$ = (org.apache.avro.io.DatumReader<ChatMessageSent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.appointmentId);

    out.writeString(this.message);

    out.writeLong(this.timestamp);

    out.writeEnum(this.actor.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.appointmentId = in.readString(this.appointmentId instanceof Utf8 ? (Utf8)this.appointmentId : null);

      this.message = in.readString(this.message instanceof Utf8 ? (Utf8)this.message : null);

      this.timestamp = in.readLong();

      this.actor = com.leftybeauty.schema.avro.MessageActorEnum.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.appointmentId = in.readString(this.appointmentId instanceof Utf8 ? (Utf8)this.appointmentId : null);
          break;

        case 1:
          this.message = in.readString(this.message instanceof Utf8 ? (Utf8)this.message : null);
          break;

        case 2:
          this.timestamp = in.readLong();
          break;

        case 3:
          this.actor = com.leftybeauty.schema.avro.MessageActorEnum.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










