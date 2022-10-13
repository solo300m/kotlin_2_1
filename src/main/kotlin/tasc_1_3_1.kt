fun main(){
    val countSecond = 172801;

    println("был(а) ${agoToText(countSecond)}");
}

fun agoToText(countSecond: Int): String {
    var rezStr:String = "";
    when {
        countSecond <= 60 -> rezStr = "только что";
        countSecond > 60 && countSecond <= 60*60 -> rezStr = minutAgo(countSecond);
        countSecond >= 60*60+1 && countSecond < 24*60*60 -> rezStr = hourAgo(countSecond);
        countSecond >= 24*60*60 && countSecond <=24*60*60+1 -> rezStr = "вчера";
        countSecond > 24*60*60+1 && countSecond <=24*60*60*2 -> rezStr = "позавчера";
        countSecond > 24*60*60*2 -> rezStr = "давно";
    }
    return rezStr;
}

fun hourAgo(countSecond: Int): String {
    val hourCount = countSecond / (60*60);

    var rezStr:String = "не определено";
    when{
        hourCount % 10 == 1 && hourCount != 11 -> rezStr = "${hourCount} час назад";
        hourCount % 10 >= 2 && hourCount <= 4 -> rezStr = "${hourCount} часа назад";
        hourCount % 10 >= 5 && hourCount % 10 == 0 -> rezStr = "${hourCount} часов назад";
        else -> rezStr = "${hourCount} часов назад";
    }
    return rezStr;
}

fun minutAgo(countSecond: Int): String {
    var minuteCount = countSecond / 60;
    if(minuteCount == 0) minuteCount = 1;
    var rezStr:String = "не определено";
    when{
        minuteCount % 10 == 1 && minuteCount != 11 -> rezStr = "${minuteCount} минуту назад";
        minuteCount % 10 >= 2 && minuteCount <= 4 -> rezStr = "${minuteCount} минуты назад";
        minuteCount % 10 >= 5 && minuteCount % 10 == 0 -> rezStr = "${minuteCount} минут назад";
        else -> rezStr = "${minuteCount} минут назад";
    }
    return rezStr;
}
