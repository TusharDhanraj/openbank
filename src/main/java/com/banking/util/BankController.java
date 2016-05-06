package com.banking.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.banking.request.LoginRequest;
import com.banking.response.AccountResponse;
import com.banking.util.thread.ThreadLocalContainer;

@Path("banks")
public class BankController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listBanks(@Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));

		return new OBPRestClient().getBanksJson("/banks");
	}

	@GET
	@Path("accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public String listAccounts(@Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().getBanksJson("/accounts");
	}

	@GET
	@Path("/accounts/public")
	@Produces(MediaType.APPLICATION_JSON)
	public String listPublicAccounts(@Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().getBanksJson("/accounts/public");
	}

	@GET
	@Path("/supported")
	@Produces(MediaType.APPLICATION_JSON)
	public String listSupportedBanks(@Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().getBanksJson("/banks");
	}

	@GET
	@Path("{bankId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBank(@PathParam("bankId") String bankId,
			@Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().getBanksJson("/banks/" + bankId);
	}

	@GET
	@Path("{bankId}/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public String getBankAccounts(@PathParam("bankId") String bankId,
			@Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().getBanksJson("/banks/" + bankId
				+ "/accounts");
	}

	@GET
	@Path("{bankId}/accounts/{accountId}/views")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAccountByAccountId(@PathParam("bankId") String bankId,
			@PathParam("accountId") String accountId,
			@Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().getBanksJson("/banks/" + bankId
				+ "/accounts/" + accountId + "/views");
	}

	@POST
	@Path("/{bankId}/accounts/{accountId}/views")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createViewOnBank(@PathParam("bankId") String bankId,
			@PathParam("accountId") String accountId, String jsonRequest,
			@Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().postBanksJson("/banks/" + bankId
				+ "/accounts/" + accountId + "/views", jsonRequest);
	}

	@GET
	@Path("{bankId}/accounts/{accountId}/{viewId}/account")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAccountByAccountId(@PathParam("bankId") String bankId,
			@PathParam("accountId") String accountId,
			@PathParam("viewId") String viewId, @Context HttpHeaders httpHeaders)
			throws JsonParseException, JsonMappingException, IOException {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));

		String jsonResponse = new OBPRestClient()
				.getBanksJson("/banks/" + bankId + "/accounts/" + accountId
						+ "/" + viewId + "/account");
		if (null == jsonResponse)
			return null;

		ObjectMapper mapper = new ObjectMapper();
		AccountResponse accountResponse = mapper.readValue(jsonResponse,
				AccountResponse.class);
		return mapper.writeValueAsString(accountResponse);

	}

	@GET
	@Path("initiate/{consumerKey}")
	@Produces(MediaType.APPLICATION_JSON)
	public String initiate(@PathParam("consumerKey") String consumerKey,
			@Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().initiateJson("oauth/initiate", consumerKey);
	}

	@POST
	@Path("/{bankId}/accounts/{accountId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String deposit(@PathParam("bankId") String bankId,
			@PathParam("accountId") String accountId, String jsonRequest,
			@Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().postBanksJson("/banks/" + bankId
				+ "/accounts/" + accountId + "", jsonRequest);
	}

	/**
	 * Get counterparties of one account
	 * 
	 * @param bankId
	 * @param accountId
	 * @param viewId
	 * @return
	 */
	@GET
	@Path("{bankId}/accounts/{accountId}/{viewId}/other_accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCounterParties(@PathParam("bankId") String bankId,
			@PathParam("accountId") String accountId,
			@PathParam("viewId") String viewId, @Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().getBanksJson("/banks/" + bankId
				+ "/accounts/" + accountId + "/" + viewId + "/other_accounts");
	}

	/**
	 * Get Transaction request types
	 * 
	 * @param bankId
	 * @param accountId
	 * @param viewId
	 * @return
	 */
	@GET
	@Path("{bankId}/accounts/{accountId}/{viewId}/transaction-request-types")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTransactionRequestTypes(
			@PathParam("bankId") String bankId,
			@PathParam("accountId") String accountId,
			@PathParam("viewId") String viewId, @Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().getBanksJson("/banks/" + bankId
				+ "/accounts/" + accountId + "/" + viewId
				+ "/transaction-request-types");
	}

	/**
	 * Get all transaction requests
	 * 
	 * @param bankId
	 * @param accountId
	 * @param viewId
	 * @return
	 */
	@GET
	@Path("{bankId}/accounts/{accountId}/{viewId}/transaction-requests")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllTransactionRequests(@PathParam("bankId") String bankId,
			@PathParam("accountId") String accountId,
			@PathParam("viewId") String viewId, @Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().getBanksJson("/banks/" + bankId
				+ "/accounts/" + accountId + "/" + viewId
				+ "/transaction-requests");
	}

	/**
	 * Create Transaction
	 * 
	 * @param bankId
	 * @param accountId
	 * @param viewId
	 * @param transactionRequestType
	 * @param jsonRequest
	 * @return
	 */
	@POST
	@Path("/{bankId}/accounts/{accountId}/{viewId}/transaction-request-types/{transactionRequestType}/transaction-requests")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createTransactionRequest(@PathParam("bankId") String bankId,
			@PathParam("accountId") String accountId,
			@PathParam("viewId") String viewId,
			@PathParam("transactionRequestType") String transactionRequestType,
			String jsonRequest, @Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().postBanksJson("/banks/" + bankId
				+ "/accounts/" + accountId + "/" + viewId
				+ "/transaction-request-types/" + transactionRequestType
				+ "/transaction-requests", jsonRequest);
	}

	/**
	 * Acknowledge Transaction
	 * 
	 * @param bankId
	 * @param accountId
	 * @param viewId
	 * @return
	 */
	@POST
	@Path("{bankId}/accounts/{accountId}/{viewId}/transaction-request-types/{transactionRequestType}/transaction-requests/{transactionRequestId}/challenge")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String acknowledgeTransaction(@PathParam("bankId") String bankId,
			@PathParam("accountId") String accountId,
			@PathParam("viewId") String viewId,
			@PathParam("transactionRequestType") String transactionRequestType,
			@PathParam("transactionRequestId") String transactionRequestId,
			String jsonRequest, @Context HttpHeaders httpHeaders) {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		return new OBPRestClient().postBanksJson("/banks/" + bankId
				+ "/accounts/" + accountId + "/" + viewId
				+ "/transaction-request-types/" + transactionRequestType
				+ "/transaction-requests/" + transactionRequestId
				+ "/challenge", jsonRequest);
	}

	/**
	 * Get last n transaction requests
	 * 
	 * @param bankId
	 * @param accountId
	 * @param viewId
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@GET
	@Path("{bankId}/accounts/{accountId}/{viewId}/transaction-requests/{count}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getLastNTransactionRequests(
			@PathParam("bankId") String bankId,
			@PathParam("accountId") String accountId,
			@PathParam("viewId") String viewId,
			@PathParam("count") String count, @Context HttpHeaders httpHeaders)
			throws JsonParseException, JsonMappingException, IOException {

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		ThreadLocalContainer.setObject("ACCESS_TOKEN",
				httpHeaders.getHeaderString("ACCESS_TOKEN"));
		String jsonResponse = new OBPRestClient().getBanksJson("/banks/"
				+ bankId + "/accounts/" + accountId + "/" + viewId
				+ "/transaction-requests");
		if (jsonResponse != null) {
			return Utils.getTransactionData(jsonResponse, count);
		} else {
			return null;
		}
	}

	/**
	 * Get Access Token and set it to Thread locale
	 * 
	 * @param jsonRequest
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@POST
	@Path("/my/logins/direct")
	@Consumes(MediaType.APPLICATION_JSON)
	public String directLogin(@Context HttpServletRequest req,
			String jsonRequest, @Context HttpHeaders httpHeaders)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		LoginRequest loginRequest = mapper.readValue(jsonRequest,
				LoginRequest.class);

		ThreadLocalContainer.setObject("app_id",
				httpHeaders.getHeaderString("app_id"));
		String token = new OBPRestClient().getDirectAccessToken(loginRequest);
		return token;
	}

}
