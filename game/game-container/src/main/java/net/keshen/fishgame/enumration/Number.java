package net.keshen.fishgame.enumration;
/**
 * @author shenke
 * @date 2016-4-22 下午2:33:05
 */
public enum Number implements Type{

	NUMBER0("0"),
	NUMBER1("1"),
	NUMBER2("2"),
	NUMBER3("3"),
	NUMBER4("4"),
	NUMBER5("5"),
	NUMBER6("6"),
	NUMBER7("7"),
	NUMBER8("8"),
	NUMBER9("9"),
	NUMBERX("X");
	
	private String version;
	
	private Number(String version){
		this.version = version;
	}

	public Number valuesOfNumber(int num){
		switch (num) {
			case 0 :   return NUMBER0;   
		    case 1 :   return NUMBER1;   
		    case 2 :   return NUMBER2;   
		    case 3 :   return NUMBER3;   
		    case 4 :   return NUMBER4;   
		    case 5 :   return NUMBER5;   
		    case 6 :   return NUMBER6;   
		    case 7 :   return NUMBER7;   
		    case 8 :   return NUMBER8;   
		    case 9 :   return NUMBER9;   
		    default:   return NUMBERX;   
		}
	}
	
	public String getVersion() {
		return this.version;
	}

	public String setVersion(String version) {
		return this.version;
	} 
}
