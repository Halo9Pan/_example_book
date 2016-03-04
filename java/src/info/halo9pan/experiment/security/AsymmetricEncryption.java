package info.halo9pan.experiment.security;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

public class AsymmetricEncryption {
	
	private static final String ALGORITHM = "RSA"; 

	public static void main(String[] args) throws Exception {
		PublicEnrypt();
		privateDecrypt();
	}

	/*
	 * 公钥加密
	 */
	private static void PublicEnrypt() throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		// 实例化Key
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
		// 获取一对钥匙
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		// 获得公钥
		Key publicKey = keyPair.getPublic();
		// 获得私钥
		Key privateKey = keyPair.getPrivate();
		// 用公钥加密
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] result = cipher.doFinal("爱奇艺视频".getBytes("UTF-8"));
		// 将Key写入到文件
		saveKey(privateKey, "qiyi_private.key");
		// 加密后的数据写入到文件
		saveData(result, "public_encryt.dat");
	}

	/*
	 * 私钥解密
	 */
	private static void privateDecrypt() throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		// 得到Key
		Key privateKey = readKey("qiyi_private.key");
		// 用私钥去解密
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		// 读数据源
		byte[] src = readData("public_encryt.dat");
		// 得到解密后的结果
		byte[] result = cipher.doFinal(src);
		// 二进制数据要变成字符串需解码
		System.out.println(new String(result, "UTF-8"));
	}

	private static void saveData(byte[] result, String fileName) throws Exception {
		FileOutputStream fosData = new FileOutputStream(fileName);
		fosData.write(result);
		fosData.close();
	}

	public static void saveKey(Key key, String fileName) throws Exception {
		FileOutputStream fosKey = new FileOutputStream(fileName);
		ObjectOutputStream oosSecretKey = new ObjectOutputStream(fosKey);
		oosSecretKey.writeObject(key);
		oosSecretKey.close();
		fosKey.close();
	}

	private static Key readKey(String fileName) throws Exception {
		FileInputStream fisKey = new FileInputStream(fileName);
		ObjectInputStream oisKey = new ObjectInputStream(fisKey);
		Key key = (Key) oisKey.readObject();
		oisKey.close();
		fisKey.close();
		return key;
	}

	private static byte[] readData(String filename) throws Exception {
		FileInputStream fisDat = new FileInputStream(filename);
		byte[] src = new byte[fisDat.available()];
		int len = fisDat.read(src);
		int total = 0;
		while (total < src.length) {
			total += len;
			len = fisDat.read(src, total, src.length - total);
		}
		fisDat.close();
		return src;
	}
}
