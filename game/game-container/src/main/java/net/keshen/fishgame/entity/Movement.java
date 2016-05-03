package net.keshen.fishgame.entity;

import java.io.Serializable;

/**
 * 这里定义 Left或者Right为空则方向为Down或者Up,反之亦然</br>
 * 若Left或者Right and Down、Up 都不为空则为左上。。。
 * 
 * @author shenke
 *
 */
public interface Movement extends Serializable{

	/**
	 * 
	 */
	static final long serialVersionUID = -935145279645105774L;
	/**运动方向 上*/
	public static final String MOVE_DIRECTION_UP = "U";
	/**运动方向 下*/
	public static final String MOVE_DIRECTION_DOWN = "D";
	/**运动方向 左*/
	public static final String MOVE_DIRECTION_LEFT = "L" ;
	/**运动方向 右*/
	public static final String MOVE_DIRECTION_RIGHT = "R" ;
	
}
