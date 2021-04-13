package ca.skip.app.enums;

public enum WaitTime{
	QUARTER_SECOND(250),
	HALF_SECOND(500),
    ONE_SECOND(1000),
    TWO_SECONDS(2000),
    THREE_SECONDS(3000),
    FOUR_SECONDS(4000),
    FIVE_SECONDS(5000),
    SIX_SECONDS(6000),
    SEVEN_SECONDS(7000),
    EIGHT_SECONDS(8000),
    NINE_SECONDS(9000),
    TEN_SECONDS(10000),
    FIFTEEN_SECONDS(15000),
    TWENTY_SECONDS(20000),
    THIRTY_SECONDS(30000);
 
    public long tempoEspera;
    
    WaitTime(long valor) {
    	tempoEspera = valor;
    }
    
    public long getTime() {
    	return tempoEspera;
    }
}
