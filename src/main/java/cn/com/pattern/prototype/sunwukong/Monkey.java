package cn.com.pattern.prototype.sunwukong;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 猢狲变形术分身
 * 
 * @author xuekun
 *
 */
public class Monkey implements Cloneable,Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 身高
	private int height;
	// 体重
	private int weight;
	// 生日
	private Date birthDate;
	// 金箍棒
	private GoldRingedStaff staff;

	/**
	 * 构造函数
	 */
	public Monkey() {
		this.birthDate = new Date();
		this.staff = new GoldRingedStaff();
	}

	/**
	 * 克隆方法
	 */
	public Object clone() {
		Monkey temp = null;
		try {
			temp = (Monkey) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;

	}

	/**
	 * 深度克隆 xuekun add in 2016年10月10日 上午11:29:41
	 * 
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object deepClone() throws IOException, ClassNotFoundException {
		// 将对象写到流里
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		// 从流里读回来
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public GoldRingedStaff getStaff() {
		return staff;
	}

	public void setStaff(GoldRingedStaff staff) {
		this.staff = staff;
	}
}
