package com.rubiconred.ckbk.creditcardsvc.builder;

import static org.junit.Assert.*;

import org.apache.xmlbeans.XmlObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rubiconred.ckbk.ebm.creditCard.DebitCreditCardDocument;
import com.rubiconred.ckbk.ebm.creditCard.DebitCreditCardResponseDocument;
import com.rubiconred.ckbk.ebm.creditCard.TDebitCreditCard;
import com.rubiconred.ckbk.ebm.creditCard.TDebitCreditCardResponse;
import com.rubiconred.ckbk.xsd.common.TCreditCard;

public class TestDebitCreditCardConverter {

	private static final String DEBIT_CREDIT_CARD_XML = "<cred:debitCreditCard"
			+ " xmlns:cred=\"http://rubiconred.com/ckbk/ebm/CreditCard\""
			+ " xmlns:acc=\"http://rubiconred.com/ckbk/xsd/account\""
			+ " xmlns:com=\"http://rubiconred.com/ckbk/xsd/common\">"
			+ "  <acc:trnAmount>1000.0</acc:trnAmount>"
			+ "  <acc:trnDesc>POS W/D</acc:trnDesc>"
			+ "  <com:creditCard>"
			+ "    <com:cardType>VISA</com:cardType>"
			+ "    <com:cardHolderName>JOHN Q. CITIZEN</com:cardHolderName>"
			+ "    <com:cardNumber>4000000000000000</com:cardNumber>"
			+ "    <com:expiryMonth>12</com:expiryMonth>"
			+ "    <com:expiryYear>2015</com:expiryYear>"
			+ "    <com:securityNo>000</com:securityNo>"
			+ "  </com:creditCard>" + "</cred:debitCreditCard>";

	private static final String DEBIT_CREDIT_CARD_RESPONSE_XML = "<cred:debitCreditCardResponse"
			+ "	xmlns:cred=\"http://rubiconred.com/ckbk/ebm/CreditCard\""
			+ "	xmlns:com=\"http://rubiconred.com/ckbk/xsd/common\">"
			+ "  <com:cardNumber>4000000000000000</com:cardNumber>"
			+ "  <com:cardAuthCode>1234</com:cardAuthCode>"
			+ "</cred:debitCreditCardResponse>";

	private static final String DEBIT_CREDIT_CARD_JSON = "{\"trnAmount\":1000.0,\"trnDesc\":\"POS W/D\",\"creditCard\":{\"cardType\":\"VISA\",\"cardHolderName\":\"JOHN Q. CITIZEN\",\"cardNumber\":\"4000000000000000\",\"expiryMonth\":12,\"expiryYear\":2015,\"securityNumber\":null}}";

	private static final String DEBIT_CREDIT_CARD_RESPONSE_JSON = "{\"cardNumber\":\"4000000000000000\",\"cardAuthCode\":\"1234\"}";

	private static XmlObject debitCreditCardXmlObject;
	private static XmlObject debitCreditCardResponseXmlObject;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		debitCreditCardXmlObject = XmlObject.Factory
				.parse(DEBIT_CREDIT_CARD_XML);
		debitCreditCardResponseXmlObject = XmlObject.Factory
				.parse(DEBIT_CREDIT_CARD_RESPONSE_XML);
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDebitCreditCardJsonToXml() {
		DebitCreditCardDocument doc = (DebitCreditCardDocument) DebitCreditCardConverter
				.debitCreditCardJsonToXml(DEBIT_CREDIT_CARD_JSON);

		TDebitCreditCard debitCreditCard = doc.getDebitCreditCard();
		assertEquals(1000.0, debitCreditCard.getTrnAmount().doubleValue(),
				0.001);
		assertEquals("POS W/D", debitCreditCard.getTrnDesc());
		TCreditCard creditCard = debitCreditCard.getCreditCard();
		assertEquals("4000000000000000", creditCard.getCardNumber());
	}

	@Test
	public void testDebitCreditCardResponseJsonToXml() {
		DebitCreditCardResponseDocument doc = (DebitCreditCardResponseDocument) DebitCreditCardConverter
				.debitCreditCardResponseJsonToXml(DEBIT_CREDIT_CARD_RESPONSE_JSON);

		TDebitCreditCardResponse response = doc.getDebitCreditCardResponse();
		assertEquals("4000000000000000", response.getCardNumber());
		assertEquals("1234", response.getCardAuthCode());
	}

	@Test
	public void testDebitCreditCardXmlToJson() {
		String json = DebitCreditCardConverter
				.debitCreditCardXmlToJson(debitCreditCardXmlObject);
		assertEquals(DEBIT_CREDIT_CARD_JSON, json);
	}

	@Test
	public void testDebitCreditCardResponseXmlToJson() {
		String json = DebitCreditCardConverter
				.debitCreditCardResponseXmlToJson(debitCreditCardResponseXmlObject);
		assertEquals(DEBIT_CREDIT_CARD_RESPONSE_JSON, json);
	}

}
