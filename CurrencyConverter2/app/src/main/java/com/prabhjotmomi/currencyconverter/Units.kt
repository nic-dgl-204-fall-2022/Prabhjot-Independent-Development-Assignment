package currencyConverter

enum class Units(val type: TypesOfUnits, val simpleUnitsName: String, val factor: Double) {
    METER(TypesOfUnits.LENGTH, "meter", 1.0),
    KILOMETER(TypesOfUnits.LENGTH, "kilometer", 1_000.0),
    CENTIMETER(TypesOfUnits.LENGTH, "centimeter", 0.01),
    MILLIMETER(TypesOfUnits.LENGTH, "millimeter", 0.001),
    MILE(TypesOfUnits.LENGTH, "mile", 1_609.35),
    YARD(TypesOfUnits.LENGTH, "yard", 0.9144),
    FOOT(TypesOfUnits.LENGTH, "foot", 0.3048),
    INCH(TypesOfUnits.LENGTH, "inch", 0.0254),

    GRAM(TypesOfUnits.WEIGHT, "gram", 1.0),
    KILOGRAM(TypesOfUnits.WEIGHT, "kilogram", 1_000.0),
    MILLIGRAM(TypesOfUnits.WEIGHT, "milligram", 0.001),
    POUND(TypesOfUnits.WEIGHT, "pound", 453.592),
    OUNCE(TypesOfUnits.WEIGHT, "ounce", 28.3495),

    CELSIUS(TypesOfUnits.TEMPERATURE, "degree Celsius", 0.0),
    KELVIN(TypesOfUnits.TEMPERATURE, "kelvin", 0.0),
    FAHRENHEIT(TypesOfUnits.TEMPERATURE, "degree Fahrenheit", 0.0),

    USDOLLARS(TypesOfUnits.CURRENCY, "us dollars", 1.0),
    BRITISHPOUND(TypesOfUnits.CURRENCY,"british pound",1.21),
    SWISSFRANC(TypesOfUnits.CURRENCY,"swiss franc",1.07),
    EURO(TypesOfUnits.CURRENCY,"euro",1.05),
    CANADIANDOLLAR(TypesOfUnits.CURRENCY,"cad dollars",0.13),
    AUSTRALIANDOLLAR(TypesOfUnits.CURRENCY,"aus dollars",0.149),
    ISRAELISHEKEL(TypesOfUnits.CURRENCY,"israeli shekel",0.346),
    CHINESEYUAN(TypesOfUnits.CURRENCY,"chinese yuan",0.697),
    RUSSIANRUBLE(TypesOfUnits.CURRENCY,"russian ruble",0.640),
    INDIANRUPEE(TypesOfUnits.CURRENCY,"indian rupee",0.827),
    JAPANESEYEN(TypesOfUnits.CURRENCY,"jpn yen",0.136),
    SOUTHKOREAWON(TypesOfUnits.CURRENCY,"south korea won",0.1310),
    VENEZUELAINBOLIVAR(TypesOfUnits.CURRENCY,"venezuelain bolivar",0.1553795),

    UNKNOWN(TypesOfUnits.UNKNOWN, "???", 0.0);
}
