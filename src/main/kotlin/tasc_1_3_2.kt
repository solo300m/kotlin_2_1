
fun main(){
    val cardType:String = "MasterCard";
    val action:Boolean = false;
    var sumLastTransaction:Double = 15000.0;
    var sumTransaction:Double = 150001.0;

    println(runTransaction(cardType,action,sumLastTransaction,sumTransaction));

}

fun runTransaction(cardType: String = "VK",
                   action: Boolean = false,
                   sumLastTransaction: Double = 0.0,
                   sumTransaction: Double):String {
    if(cardType == "VK"){
        if(sumTransaction > 15000)
            return "Сумма транзакции ${sumTransaction}руб. превышает установленный лимит 15 000 руб. за один платеж.";
        else{
            if(sumLastTransaction+sumTransaction <= 40000){
               return "Комиссия за перевод с карты \"${getCardType(cardType)}\": " +
                    "${calcComision(cardType,action,sumLastTransaction,sumTransaction)} руб.";
            }
            else{
                return "Превышен месячный лимит оплат в 40 000 руб. Транзакция не проведена.";
            }
        }

    }
    else{
        if(sumTransaction < 150000){
            if(sumLastTransaction + sumTransaction <= 600000){
                return "Комиссия за перевод с карты \"${getCardType(cardType)}\": " +
                        "${calcComision(cardType,action,sumLastTransaction,sumTransaction)} руб.";
            }
            else{
               return "Превышен месячный лимит оплат в 600 000 руб. Транзакция не проведена.";
            }
        }
        else{
            return "Сумма транзакции ${sumTransaction}руб. превышает установленный лимит 150 000 руб. за один платеж.";
        }
    }
}

fun getCardType(cardType: String): String {
    when(cardType){
        "VK"-> return "В Контакте";
        "Maestro"-> return "Maestro";
        "MasterCard"-> return "Master Card";
        "Visa"-> return "VISA";
        "Mir"-> return "МИР";
        else -> return "no type";
    }
}

fun calcComision(cardType: String = "VK",
                 action: Boolean = false,
                 sumLastTransaction: Double = 0.0,
                 sumTransaction: Double): Double {
    var rezult:Double = 0.0;
    if(cardType == "Maestro" || cardType == "MasterCard"){
        if(action){
            when{
                sumLastTransaction + sumTransaction > 75000 -> rezult = sumTransaction * 0.006 + 20;
                else -> rezult = 0.0;
            }
        }
        else{
            rezult = sumTransaction * 0.006 + 20;
        }
        return rezult;
    }
    else if(cardType == "Visa" || cardType == "Mir"){
        when{
            sumTransaction * 0.075 > 35 -> rezult = sumTransaction * 0.075;
            else -> rezult = 35.0;
        }
        return rezult;
    }
    else{
        return rezult;
    }
}

