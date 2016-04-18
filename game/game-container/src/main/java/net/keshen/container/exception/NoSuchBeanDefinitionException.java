package net.keshen.container.exception;
/**
 * @author shenke
 * @date 2016-4-15 下午6:26:15
 */
public class NoSuchBeanDefinitionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1878207110553372584L;

	public NoSuchBeanDefinitionException() {
		super();
	}

	public NoSuchBeanDefinitionException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchBeanDefinitionException(String message) {
		super(message);
	}

	public NoSuchBeanDefinitionException(Throwable cause) {
		super(cause);
	}
	
}
