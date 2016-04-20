package net.keshen.fishgame.enumration;
/**
 * @author shenke
 * @date 2016-4-19 下午2:34:14
 */
public enum NetType implements Type{

	NET1("01"),
	NET2("02"),
	NET3("03"),
	NET4("04"),
	NET5("05"),
	NET6("06"),
	NET7("07"),
	NET8("08"),
	NET9("09"),
	NET10("010"),
	NET11("011");
	
	private String version;
	
	private NetType(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public String setVersion(String version) {
		return this.version = version;
	}
	
}
