package net.keshen.fishgame.enumration;
/**
 * 高分 40-90
 * @author shenke
 * @date 2016年4月24日下午1:21:20
 * @version 1.0
 */
public enum HighPoint implements Type{

	SCORE40("40"),
	SCORE50("50"),
	SCORE60("60"),
	SCORE70("70"),
	SCORE80("80"),
	SCORE90("90");
	
	
	private String version;
	
	private HighPoint(String version){
		this.version = version;
	}

	@Override
	public String getVersion() {
		return this.version;
	}

	@Override
	public String setVersion(String version) {
		return this.version = version;
	}
}
