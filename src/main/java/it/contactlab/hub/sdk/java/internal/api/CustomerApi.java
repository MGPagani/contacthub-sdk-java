package it.contactlab.hub.sdk.java.internal.api;

import it.contactlab.hub.sdk.java.Auth;
import it.contactlab.hub.sdk.java.exceptions.HttpException;
import it.contactlab.hub.sdk.java.gson.ContactHubGson;
import it.contactlab.hub.sdk.java.http.Request;
import it.contactlab.hub.sdk.java.models.Customer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class CustomerApi {

  private static Gson gson = ContactHubGson.getInstance();

  /**
   * Retrieves all the Customers for a Node.
   *
   * @param auth A ContactHub Auth object.
   * @return     A List of Customer objects.
   */
  public static List<Customer> get(Auth auth) throws HttpException {
    String endpoint = "/customers?nodeId=" + auth.nodeId;
    JSONObject response = Request.doGet(auth, endpoint);

    Type collectionType = new TypeToken<List<Customer>>(){}.getType();

    List<Customer> customers = gson.fromJson(response
        .getJSONArray("elements")
        .toString(),
        collectionType);

    return customers;
  }

  /**
   * Retrieves a Customer by id.
   *
   * @param auth A ContactHub Auth object.
   * @param id   The Customer id.
   * @return     A Customer object.
   */
  public static Customer get(Auth auth, String id) throws HttpException {
    String endpoint = "/customers/" + id;
    JSONObject response = Request.doGet(auth, endpoint);

    return gson.fromJson(response.toString(), Customer.class);
  }

  /**
   * Retrieves a Customer by externalId.
   *
   * @param auth       A ContactHub Auth object.
   * @param externalId The Customer externalId.
   * @return           A list of matching Customer objects.
   */
  public static List<Customer> getByExternalId(Auth auth, String externalId) throws HttpException {
    String endpoint = "/customers?nodeId=" + auth.nodeId + "&externalId=" + externalId;
    JSONObject response = Request.doGet(auth, endpoint);

    Type collectionType = new TypeToken<List<Customer>>(){}.getType();

    List<Customer> customers = gson.fromJson(response
        .getJSONArray("elements")
        .toString(),
        collectionType);

    return customers;
  }

  /**
   * Adds a new Customer.
   *
   * @param auth     A ContactHub Auth object.
   * @param customer The Customer object.
   * @return         The stored Customer object, including its id.
   */
  public static Customer add(Auth auth, Customer customer) throws HttpException {
    String endpoint = "/customers";
    Customer expectedCustomer = customer.withNodeId(auth.nodeId);
    String payload = gson.toJson(expectedCustomer);
    JSONObject response = Request.doPost(auth, endpoint, payload);

    return gson.fromJson(response.toString(), Customer.class);
  }

  /**
   * Deletes a Customer.
   *
   * @param auth       A ContactHub Auth object.
   * @param customerId The id of the Customer to delete.
   * @return           True if the deletion was successful
   */
  public static boolean delete(Auth auth, String customerId) throws HttpException {
    String endpoint = "/customers/" + customerId;
    JSONObject response = Request.doDelete(auth, endpoint);

    return true;
  }

  /**
   * Updates a Customer.
   *
   * @param auth     A ContactHub Auth object.
   * @param customer The Customer object.
   * @return         The updated Customer object
   */
  public static Customer update(Auth auth, Customer customer) throws HttpException {
    String endpoint = "/customers/" + customer.id().get();
    Customer expectedCustomer = customer.withNodeId(auth.nodeId);
    String payload = gson.toJson(expectedCustomer);
    JSONObject response = Request.doPut(auth, endpoint, payload);

    return gson.fromJson(response.toString(), Customer.class);
  }

  /**
   * Patches a Customer.
   *
   * @param auth          A ContactHub Auth object.
   * @param customerId    The id of the Customer to patch.
   * @param patchCustomer The CustomerPatch object.
   * @return              The updated Customer object
   */
  public static Customer patch(Auth auth, String customerId, Customer patchCustomer)
      throws HttpException {
    String endpoint = "/customers/" + customerId;
    String payload = gson.toJson(patchCustomer);
    JSONObject response = Request.doPatch(auth, endpoint, payload);

    return gson.fromJson(response.toString(), Customer.class);
  }

}