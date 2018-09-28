package it.contactlab.hub.sdk.java.models;

import org.immutables.value.Value;

import java.util.Optional;

/**
 * Social profile.
 */
@Value.Immutable
@Value.Style(typeImmutable = "*")
public abstract class AbstractSourceInfo {

  public abstract Optional<String> registeredBy();

}
