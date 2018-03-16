package it.contactlab.hub.sdk.java.models;

import org.immutables.value.Value;

import java.time.OffsetDateTime;

/**
 * Customer SourceInfo.
 */
@Value.Immutable
@Value.Style(typeImmutable = "*")
public abstract class AbstractSourceInfo {

  /**
  * The Registered By information.
  */
  public abstract String registeredBy();

  /**
  * The Updated By information.
  */
  public abstract String updatedBy();
}
