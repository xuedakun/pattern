/**
 * 
 */
package cn.com.pattern.prototype;

/**
 * @author xuekun
 *
 */
public interface Prototype {
	public Prototype clone();

	public String getName();

	public void setName(String name);
}
