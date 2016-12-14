package it.contactlab.hub.sdk.java.models.base;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Value.Style(typeImmutable = "*")
public abstract class AbstractMobileDevice {

  public abstract Optional<String> identifier();

  public abstract Optional<String> name();

  public abstract Optional<MobileDeviceType> type();

}
