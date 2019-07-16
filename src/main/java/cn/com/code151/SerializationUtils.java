package cn.com.code151;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationUtils {
	private static String FILE_NAME = "D:/object.bin";

	public static void writeObject(Serializable s) {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File(FILE_NAME)));
			outputStream.writeObject(s);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Object readObject() {
		Object object = null;
		try {
			ObjectInput objectInput = new ObjectInputStream(new FileInputStream(new File(FILE_NAME)));
			object = objectInput.readObject();
			objectInput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;

	}
}
