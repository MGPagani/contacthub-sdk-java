package it.contactlab.hub.sdk.java.models;

import it.contactlab.hub.sdk.java.queries.QueryContainer;

import org.immutables.value.Value;

import java.util.Optional;
import java.util.Set;

@Value.Immutable
@Value.Style(typeImmutable = "*")
public abstract class AbstractGetCustomersOptions {

  public abstract Optional<String> externalId();

  public abstract Set<String> fields();

  public abstract Optional<QueryContainer> query();

  public abstract Optional<String> sort();

  public abstract Optional<String> direction();

  public abstract Optional<Integer> page();

  public abstract Optional<Integer> pageSize();
}
