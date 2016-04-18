package net.keshen.fishgame.enumration;

/**
 * 鱼的种类
 * @author shenke
 *
 */
public enum FishType {
	/**
	 * 燕鱼
	 */
	MACKEREL("fish01"),
	/** 红鱼*/
	SNAPPER("fish02"),
	/** 绿鱼*/
	GREENFISH("fish03"),
	/** 乌贼*/
	SQUID("fish04"),
	/** 小丑鱼*/
	CLOWNFISH("fish05"),
	/** 红绿灯鱼*/
	TRAFFICLIGHTSFISH("fish06"),
	/** 蓝鱼*/
	BLUEFISH("fish07"),
	/** 乌龟*/
	TORTOISE("fish08"),
	/** 灯笼鱼*/
	LANTERNFISH("fish09"),
	/** 鳐鱼*/
	SKATE("fish10"),
	/** 美人鱼1*/
	MERMAID1("fish11"),
	/** 美人鱼2*/
	MERMAID2("fish12"),
	/** 鲨鱼*/
	SHARK("fish13"),
	/** 海姆*/
	HEIM("fish14"),
	/** 剑鱼*/
	SWORDFISH("fish15"),
	/** 鲸鱼*/
	WHALE("fish16"),
	/** 青蛙*/
	FROG("fish17");
	
	private String name;

	
	private FishType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static FishType getType(String name){
		switch (name) {
		case "fish01":
			return MACKEREL;
		case "fish02":
			return SNAPPER;
		case "fish03":
			return GREENFISH;
		case "fish04":
			return SQUID;
		case "fish05":
			return CLOWNFISH;
		case "fish06":
			return TRAFFICLIGHTSFISH;
		case "fish07":
			return BLUEFISH;
		case "fish08":
			return TORTOISE;
		case "fish09":
			return LANTERNFISH;
		case "fish10":
			return SKATE;
		case "fish11":
			return MERMAID1;
		case "fish12":
			return MERMAID2;
		case "fish13":
			return SHARK;
		case "fish14":
			return HEIM;
		case "fish15":
			return SWORDFISH;
		case "fish16":
			return WHALE;
		case "fish17":
			return FROG;
		default:
			return null;
		}
	}

}
