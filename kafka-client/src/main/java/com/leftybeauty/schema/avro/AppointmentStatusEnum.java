/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.leftybeauty.schema.avro;
@org.apache.avro.specific.AvroGenerated
public enum AppointmentStatusEnum implements org.apache.avro.generic.GenericEnumSymbol<AppointmentStatusEnum> {
  Proposed, Scheduled, InProgress, Cancelled, Rejected, TimedOut, Completed  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"AppointmentStatusEnum\",\"namespace\":\"com.leftybeauty.schema.avro\",\"symbols\":[\"Proposed\",\"Scheduled\",\"InProgress\",\"Cancelled\",\"Rejected\",\"TimedOut\",\"Completed\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
