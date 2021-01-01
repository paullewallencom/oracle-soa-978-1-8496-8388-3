package com.rubiconred.ckbk.creditcardsvc.builder;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectReader;
import org.codehaus.jackson.map.ObjectWriter;

import com.rubiconred.ckbk.creditcardsvc.json.CreditCardServiceMapperFactory;
import com.rubiconred.ckbk.creditcardsvc.pojo.CreditCard;
import com.rubiconred.ckbk.creditcardsvc.pojo.DebitCreditCard;
import com.rubiconred.ckbk.creditcardsvc.pojo.DebitCreditCardResponse;
import com.rubiconred.ckbk.ebm.creditCard.DebitCreditCardDocument;
import com.rubiconred.ckbk.ebm.creditCard.DebitCreditCardResponseDocument;
import com.rubiconred.ckbk.ebm.creditCard.TDebitCreditCard;
import com.rubiconred.ckbk.ebm.creditCard.TDebitCreditCardResponse;
import com.rubiconred.ckbk.xsd.common.TCreditCard;

public class DebitCreditCardConverter {

	public static XmlObject debitCreditCardJsonToXml(String json) {
		ObjectReader reader = CreditCardServiceMapperFactory
				.getDebitCreditCardReader();
		DebitCreditCardDocument debitDoc = DebitCreditCardDocument.Factory
				.newInstance();
		DebitCreditCard jsonDebitCreditCard;
		try {
			jsonDebitCreditCard = reader.readValue(json);
			CreditCard jsonCreditCard = jsonDebitCreditCard.getCreditCard();
			TDebitCreditCard xmlDebitCreditCard = TDebitCreditCard.Factory
					.newInstance();
			TCreditCard xmlCreditCard = TCreditCard.Factory.newInstance();
			xmlCreditCard.setCardHolderName(jsonCreditCard.getCardHolderName());
			xmlCreditCard.setCardNumber(jsonCreditCard.getCardNumber());
			xmlCreditCard.setCardType(jsonCreditCard.getCardType());
			xmlCreditCard.setExpiryMonth(jsonCreditCard.getExpiryMonth());
			xmlCreditCard.setExpiryYear(jsonCreditCard.getExpiryYear());
			xmlCreditCard.setSecurityNo(jsonCreditCard.getSecurityNo());
			xmlDebitCreditCard.setCreditCard(xmlCreditCard);
			Double trnAmount = jsonDebitCreditCard.getTrnAmount();
			if (trnAmount != null) {
				xmlDebitCreditCard.setTrnAmount(BigDecimal.valueOf(trnAmount));
			}
			xmlDebitCreditCard.setTrnDesc(jsonDebitCreditCard.getTrnDesc());
			debitDoc.setDebitCreditCard(xmlDebitCreditCard);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return debitDoc;
	}

	public static XmlObject debitCreditCardResponseJsonToXml(String json) {
		ObjectReader reader = CreditCardServiceMapperFactory
				.getDebitCreditCardResponseReader();
		DebitCreditCardResponseDocument responseDoc = DebitCreditCardResponseDocument.Factory
				.newInstance();
		DebitCreditCardResponse jsonDebitCreditCardResponse;
		try {
			jsonDebitCreditCardResponse = reader.readValue(json);
			TDebitCreditCardResponse xmlResponse = TDebitCreditCardResponse.Factory
					.newInstance();
			xmlResponse.setCardNumber(jsonDebitCreditCardResponse
					.getCardNumber());
			xmlResponse.setCardAuthCode(jsonDebitCreditCardResponse
					.getCardAuthCode());
			responseDoc.setDebitCreditCardResponse(xmlResponse);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseDoc;
	}

	public static String debitCreditCardXmlToJson(XmlObject xml) {
		System.out.println("debitCreditCardXmlToJson() called with: " + xml.toString());
		ObjectWriter writer = CreditCardServiceMapperFactory
				.getDebitCreditCardWriter();
		DebitCreditCard debitCreditCard = new DebitCreditCard();
		String json = null;
		try {
			XmlObject doc = XmlObject.Factory.parse(xml.newXMLStreamReader());
			if (doc instanceof DebitCreditCardDocument) {
				DebitCreditCardDocument debitCreditCardDoc = (DebitCreditCardDocument) doc;
				TDebitCreditCard source = debitCreditCardDoc
						.getDebitCreditCard();
				TCreditCard sourceCC = source.getCreditCard();
				BigDecimal trnAmount = source.getTrnAmount();
				if (trnAmount != null) {
					debitCreditCard.setTrnAmount(trnAmount.doubleValue());
				}
				debitCreditCard.setTrnDesc(source.getTrnDesc());
				CreditCard creditCard = new CreditCard();
				creditCard.setCardHolderName(sourceCC.getCardHolderName());
				creditCard.setCardNumber(sourceCC.getCardNumber());
				creditCard.setCardType(sourceCC.getCardType());
				creditCard.setExpiryMonth(sourceCC.getExpiryMonth());
				creditCard.setExpiryYear(sourceCC.getExpiryYear());
				creditCard.setSecurityNo(sourceCC.getSecurityNo());
				debitCreditCard.setCreditCard(creditCard);
				json = writer.writeValueAsString(debitCreditCard);
			} else {
				System.out.println("debitCreditCardXmlToJson(): PARSE FAILED!!!");
			}
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("debitCreditCardXmlToJson() ==> " + json);
		return json;
	}

	public static String debitCreditCardResponseXmlToJson(XmlObject xml) {
		ObjectWriter writer = CreditCardServiceMapperFactory
				.getDebitCreditCardResponseWriter();
		DebitCreditCardResponse debitCreditCardResponse = new DebitCreditCardResponse();
		String json = null;
		try {
			XmlObject doc = XmlObject.Factory.parse(xml.newXMLStreamReader());
			if (doc instanceof DebitCreditCardResponseDocument) {
				DebitCreditCardResponseDocument debitCreditCardResponseDoc = (DebitCreditCardResponseDocument) doc;
				TDebitCreditCardResponse source = debitCreditCardResponseDoc
						.getDebitCreditCardResponse();
				debitCreditCardResponse.setCardAuthCode(source
						.getCardAuthCode());
				debitCreditCardResponse.setCardNumber(source.getCardNumber());
				json = writer.writeValueAsString(debitCreditCardResponse);
			}
		} catch (XmlException e) {
			e.printStackTrace();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
}
