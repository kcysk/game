package net.keshen.fishgame.enumration;
/**
 * @author shenke
 * @date 2016年4月24日下午1:28:32
 * @version 1.0
 */
public enum Hundred implements Type{
	
	Score100("100"),
	Score120("120"),
	Score150("150");

	private String version;
	
	private Hundred(String version) {
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
