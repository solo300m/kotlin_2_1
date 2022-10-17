import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Tasc_1_3_2KtTest {

    @Test
    fun runTransactionMir() {
        val cardType:String = "Mir";
        val action:Boolean = false;
        var sumLastTransaction:Double = 75000.0;
        var sumTransaction:Double = 100.0;

        val rez:String = runTransaction(cardType,action,sumLastTransaction,sumTransaction);
        assertEquals("Комиссия за перевод с карты \"МИР\": 35.0 руб.",rez);
    }
    @Test
    fun runTransactionVK() {
        val cardType:String = "VK";
        val action:Boolean = false;
        var sumLastTransaction:Double = 0.0;
        var sumTransaction:Double = 100.0;

        val rez:String = runTransaction(cardType,action,sumLastTransaction,sumTransaction);
        assertEquals("Комиссия за перевод с карты \"В Контакте\": 0.0 руб.",rez);
    }
    @Test
    fun runTransactionVKMaxTR() {
        val cardType:String = "VK";
        val action:Boolean = false;
        var sumLastTransaction:Double = 0.0;
        var sumTransaction:Double = 15001.0;

        val rez:String = runTransaction(cardType,action,sumLastTransaction,sumTransaction);
        assertEquals("Сумма транзакции 15001.0руб. превышает установленный лимит 15 000 руб. за один платеж.",rez);
    }

    @Test
    fun runTransactionVKDef() {
        var sumTransaction:Double = 100.0;

        val rez:String = runTransaction(cardType = "VK",action = false,sumLastTransaction=0.0,sumTransaction);
        assertEquals("Комиссия за перевод с карты \"В Контакте\": 0.0 руб.",rez);
    }
    @Test
    fun runTransactionMaestro() {
        val cardType:String = "Maestro";
        val action:Boolean = true;
        var sumLastTransaction:Double = 20000.0;
        var sumTransaction:Double = 10000.0;

        val rez:String = runTransaction(cardType,action,sumLastTransaction,sumTransaction);
        assertEquals("Комиссия за перевод с карты \"Maestro\": 0.0 руб.",rez);
    }
    @Test
    fun runTransactionMasterCard() {
        val cardType:String = "MasterCard";
        val action:Boolean = false;
        var sumLastTransaction:Double = 20000.0;
        var sumTransaction:Double = 10000.0;

        val rez:String = runTransaction(cardType,action,sumLastTransaction,sumTransaction);
        assertEquals("Комиссия за перевод с карты \"Master Card\": 80.0 руб.",rez);
    }
    @Test
    fun runTransactionMasterCardMaxTR() {
        val cardType:String = "MasterCard";
        val action:Boolean = false;
        var sumLastTransaction:Double = 20000.0;
        var sumTransaction:Double = 150001.0;

        val rez:String = runTransaction(cardType,action,sumLastTransaction,sumTransaction);
        assertEquals("Сумма транзакции 150001.0руб. превышает установленный лимит 150 000 руб. за один платеж.",rez);
    }
    @Test
    fun runTransactionMasterCardMax() {
        val cardType:String = "MasterCard";
        val action:Boolean = false;
        var sumLastTransaction:Double = 700000.0;
        var sumTransaction:Double = 100000.0;

        val rez:String = runTransaction(cardType,action,sumLastTransaction,sumTransaction);
        assertEquals("Превышен месячный лимит оплат в 600 000 руб. Транзакция не проведена.",rez);
    }
    @Test
    fun runTransactionVisaMax() {
        val cardType:String = "Visa";
        val action:Boolean = false;
        var sumLastTransaction:Double = 700000.0;
        var sumTransaction:Double = 100000.0;

        val rez:String = runTransaction(cardType,action,sumLastTransaction,sumTransaction);
        assertEquals("Превышен месячный лимит оплат в 600 000 руб. Транзакция не проведена.",rez);
    }
    @Test
    fun runTransactionVisa() {
        val cardType:String = "Visa";
        val action:Boolean = false;
        var sumLastTransaction:Double = 40000.0;
        var sumTransaction:Double = 10000.0;

        val rez:String = runTransaction(cardType,action,sumLastTransaction,sumTransaction);
        assertEquals("Комиссия за перевод с карты \"VISA\": 750.0 руб.",rez);
    }
    @Test
    fun runTransactionVKMax() {
        val cardType:String = "VK";
        val action:Boolean = false;
        var sumLastTransaction:Double = 40000.0;
        var sumTransaction:Double = 10000.0;

        val rez:String = runTransaction(cardType,action,sumLastTransaction,sumTransaction);
        assertEquals("Превышен месячный лимит оплат в 40 000 руб. Транзакция не проведена.",rez);
    }

    @Test
    fun getCardTypeVK() {
        val cardType:String = "VK";
        val rez = getCardType(cardType);
        assertEquals("В Контакте",rez);
    }
    @Test
    fun getCardTypeMir() {
        val cardType:String = "Mir";
        val rez = getCardType(cardType);
        assertEquals("МИР",rez);
    }
    @Test
    fun getCardTypeMasterCart() {
        val cardType:String = "MasterCard";
        val rez = getCardType(cardType);
        assertEquals("Master Card",rez);
    }
    @Test
    fun getCardTypeMaestro() {
        val cardType:String = "Maestro";
        val rez = getCardType(cardType);
        assertEquals("Maestro",rez);
    }
    @Test
    fun getCardTypeVisa() {
        val cardType:String = "Visa";
        val rez = getCardType(cardType);
        assertEquals("VISA",rez);
    }
    @Test
    fun getCardTypeAny() {
        val cardType:String = "Any";
        val rez = getCardType(cardType);
        assertEquals("no type",rez);
    }

    @Test
    fun calcComisionMaestro() {
        val cartTypeMaestro:String = "Maestro";
        val actionTrue:Boolean = true;
        var sumLastTransaction:Double = 20000.0;
        var sumTransaction:Double = 13000.0;
        val rezultMaestro:Double = calcComision(cartTypeMaestro,actionTrue,sumLastTransaction,sumTransaction);
        assertEquals(0.0, rezultMaestro);
    }

    @Test
    fun calcComisionMaestroFalse() {
        val cartTypeMaestro:String = "Maestro";
        val action:Boolean = false;
        var sumLastTransactionMax:Double = 75000.0;
        var sumTransaction:Double = 13000.0;
        val rezMaestrTrue:Double = calcComision(cartTypeMaestro,action,sumLastTransactionMax,sumTransaction);
        assertEquals(98.0,rezMaestrTrue);
    }

    @Test
    fun calcComisionVK() {
        val cartTypeVK:String = "VK";
        val action:Boolean = false;
        var sumLastTransaction:Double = 20000.0;
        var sumTransaction:Double = 13000.0;
        val rezVK:Double = calcComision(cartTypeVK,action,sumLastTransaction,sumTransaction);
        assertEquals(0.0,rezVK);
    }

    @Test
    fun calcComisionVisa() {
        val cartTypeVisa = "Visa";
        val action:Boolean = false;
        var sumLastTransactionMax:Double = 75000.0;
        var sumTransaction:Double = 13000.0;
        val rezVisa:Double = calcComision(cartTypeVisa,action,sumLastTransactionMax,sumTransaction);
        assertEquals(975.0,rezVisa);
    }
    @Test
    fun calcComisionMir() {
        val cartTypeMir = "Mir"
        val action:Boolean = false;
        var sumLastTransactionMax:Double = 75000.0;
        var sumTransaction:Double = 13000.0;
        val rezMIr:Double = calcComision(cartTypeMir,action,sumLastTransactionMax,sumTransaction);
        assertEquals(975.0,rezMIr);
    }
    @Test
    fun calcComisionMir35() {
        val cartTypeMir = "Mir"
        val action:Boolean = false;
        var sumLastTransactionMax:Double = 75000.0;
        var sumTransaction:Double = 100.0;
        val rezMIr:Double = calcComision(cartTypeMir,action,sumLastTransactionMax,sumTransaction);
        assertEquals(35.0,rezMIr);
    }
    @Test
    fun calcComisionVisa35() {
        val cartTypeMir = "Visa"
        val action:Boolean = false;
        var sumLastTransactionMax:Double = 75000.0;
        var sumTransaction:Double = 100.0;
        val rezMIr:Double = calcComision(cartTypeMir,action,sumLastTransactionMax,sumTransaction);
        assertEquals(35.0,rezMIr);
    }
    @Test
    fun calcComision() {
        val cardType:String = "MasterCard";
        val action:Boolean = false;
        var sumLastTransaction:Double = 20000.0;
        var sumTransaction:Double = 13000.0;
        val rezult:Double = calcComision(cardType,action,sumLastTransaction,sumTransaction);
        assertEquals(98.0, rezult,0.00);
    }
}