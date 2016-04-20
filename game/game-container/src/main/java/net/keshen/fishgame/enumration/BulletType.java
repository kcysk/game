package net.keshen.fishgame.enumration;
/**
 * @author shenke
 * @date 2016-4-19 下午2:30:47
 */
public enum BulletType implements Type{

	BULLET1 ("01"),
	BULLET2 ("02"),
	BULLET3 ("03"),
	BULLET4 ("04"),
	BULLET5 ("05"),
	BULLET6 ("06"),
	BULLET7 ("07"),
	BULLET8 ("08"),
	BULLET9 ("09"),
	BULLET10("010"),
	BULLET11("011"),
	BULLETSUPER("su");
	
	private String version;
	
	private BulletType(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public String setVersion(String version) {
		return this.version = version;
	}
	
}
