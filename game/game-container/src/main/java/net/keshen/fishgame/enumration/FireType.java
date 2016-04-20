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
}
