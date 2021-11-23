package com.example.spotr

data class guide(val title:String, val desc: String, val image: Int)

object list {
    val list = arrayListOf(
        guide
            (
            "",
            "Пархай как\n" +
                    "бабочка\n" +
                    "Жаль как пчела",
            R.drawable.boxing
        ),
        guide
            (
            "",
            "Борись до конца\n" +
                    "боль временна \n" +
                    "триумф вечен",
            R.drawable.boxing
        ),
        guide
            (
            "",
            "Боксером можешь\n" +
                    "ты не быть,\n" +
                    "но человеком\n" +
                    "быть обязан",
            R.drawable.boxing
        )
    )
}