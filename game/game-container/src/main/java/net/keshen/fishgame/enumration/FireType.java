package net.keshen.fishgame.enumration;
/**
 * 大炮种类枚举
 * @author shenke
 * @date 2016-4-19 下午1:27:19
 */
public enum FireType {

	FIRE1("1"),
	FIRE2("2"),
	FIRE3("3"),
	FIRE4("4"),
	FIRE5("5"),
	FIRE6("6"),
	FIRE7("7"),
	FIRE8("8"),
	FIRE9("9"),
	FIRE10("10"),
	FIRE11("11"),
	/**
	 * 超级大炮
	 */
	FIRESUPER("jg_pao");
	
	private String version;

	FireType(String version){
		this.version = version;
	}
	
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * valueOfVersion("1")-->return FIRE1</br>
	 * the max version is 11</br>
	 * others return FIRE1
	 * @param version
	 * @return
	 */
	public FireType valueOfVersion(String version){
		switch(version){
			case "1": return FireType.FIRE1;
			case "2": return FireType.FIRE2;
			case "3": return FireType.FIRE3;
			case "4": return FireType.FIRE4;
			case "5": return FireType.FIRE5;
			case "6": return FireType.FIRE6;
			case "7": return FireType.FIRE7;
			case "8": return FireType.FIRE8;
			case "9": return FireType.FIRE9;
			case "10": return FireType.FIRE10;
			case "11": return FireType.FIRE11;
			default: return FireType.FIRE1;
		}        
	}

}
