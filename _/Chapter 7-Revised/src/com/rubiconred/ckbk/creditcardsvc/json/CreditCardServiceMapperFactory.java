package com.rubiconred.ckbk.creditcardsvc.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.rubiconred.ckbk.creditcardsvc.pojo.DebitCreditCard;
import com.rubiconred.ckbk.creditcardsvc.pojo.DebitCreditCardResponse;

public class CreditCardServiceMapperFactory {

	private static ObjectMapper mapper;
	private static ObjectReader debitCreditCardReader;
	private static ObjectWriter debitCreditCardWriter;
	private static ObjectReader debitCreditCardResponseReader;
	private static ObjectWriter debitCreditCardResponseWriter;

	static {
		mapper = new ObjectMapper();

		// Include null values in generated JSON
		mapper.setSerializationConfig(mapper.getSerializationConfig()
				.withSerializationInclusion(Inclusion.ALWAYS));

		debitCreditCardReader = mapper.reader(DebitCreditCard.class);
		debitCreditCardWriter = mapper.writerWithType(DebitCreditCard.class);
		debitCreditCardResponseReader = mapper.reader(DebitCreditCardResponse.class);
		debitCreditCardResponseWriter = mapper.writerWithType(DebitCreditCardResponse.class);
	}

	public static ObjectReader getDebitCreditCardReader() {
		return debitCreditCardReader;
	}

	public static ObjectWriter getDebitCreditCardWriter() {
		return debitCreditCardWriter;
	}

	public static ObjectReader getDebitCreditCardResponseReader() {
		return debitCreditCardResponseReader;
	}

	public static ObjectWriter getDebitCreditCardResponseWriter() {
		return debitCreditCardResponseWriter;
	}

}
