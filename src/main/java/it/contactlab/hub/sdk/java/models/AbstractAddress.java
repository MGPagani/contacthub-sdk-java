package it.contactlab.hub.sdk.java.models;

import org.immutables.value.Value;

import java.util.Optional;

/**
 * Address information.
 */
@Value.Immutable
@Value.Style(typeImmutable = "*")
public abstract class AbstractAddress {

  /**
   * The street.
   */
  public abstract Optional<String> street();

  /**
   * The city.
   */
  public abstract Optional<String> city();

  /**
   * The country.
   */
  public abstract Optional<String> country();

  /**
   * The province.
   */
  public abstract Optional<String> province();
  
   /**
   * The region.
   */
  public abstract Optional<String> region();

  /**
   * The ZIP code.
   */
  public abstract Optional<String> zip();

  /**
   * The geographic information.
   */
  public abstract Optional<Geo> geo();

}
