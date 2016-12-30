package it.contactlab.hub.sdk.java.models.base;

import org.immutables.value.Value;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Value.Immutable
@Value.Style(typeImmutable = "*")
public abstract class AbstractSubscription {

  public abstract Optional<String> id();

  public abstract Optional<String> name();

  public abstract Optional<String> type();

  public abstract Optional<SubscriptionKind> kind();

  public abstract Optional<Boolean> subscribed();

  public abstract Optional<OffsetDateTime> startDate();

  public abstract Optional<OffsetDateTime> endDate();

  public abstract Optional<String> subscriberId();

  public abstract Optional<OffsetDateTime> registeredAt();

  public abstract Optional<OffsetDateTime> updatedAt();

  public abstract Optional<List<Preference>> preferences();

}