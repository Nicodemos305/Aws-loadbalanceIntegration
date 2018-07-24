package br.com.desafio.loadbalance.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * @author felipe.nicodemos
 * 
 * Classe utilitária responsável por 
 * gerar assinatura criptografada
 *
 */
public class AmazonSignature {
	
	
	private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();

	public static String recoveryAWSassignatureV4(String key, String dateStamp, String regionName, String serviceName) throws Exception {
		String result = null;
		try {
			byte[] byteResult = getSignatureKey(key, dateStamp, regionName, serviceName);
			result = toHex(byteResult);
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro ao recuperar assinatura",e);
		}

		return result;
	}

	
	/**
	 * Método responsável criptografar uma String
	 * 
	 * @param String data,
	 * @param byte[] key
	 *@return byte[] byte[]
	 */
	static byte[] HmacSHA256(String data, byte[] key) throws Exception {
		String algorithm = "HmacSHA256";
		Mac mac = Mac.getInstance(algorithm);
		mac.init(new SecretKeySpec(key, algorithm));
		return mac.doFinal(data.getBytes("UTF8"));
	}

	
	/**
	 * Método responsável assinar uma chave válida
	 * @param String key,
	 * @param String dateStamp
	 * @param String regionName,
	 * @param String serviceName
	 *@return byte[] kSigning
	 */
	static byte[] getSignatureKey(String key, String dateStamp, String regionName, String serviceName)
			throws Exception {
		byte[] kSecret = ("AWS4" + key).getBytes("UTF8");
		byte[] kDate = HmacSHA256(dateStamp, kSecret);
		byte[] kRegion = HmacSHA256(regionName, kDate);
		byte[] kService = HmacSHA256(serviceName, kRegion);
		byte[] kSigning = HmacSHA256("aws4_request", kService);
		return kSigning;
	}

	
	/**
	 * Método responsável por receber um byte array e converter 
	 * em String hexadecimal
	 * 
	 * @param byte[] bytes
	 *@return String string
	 */
	public static String toHex(byte[] bytes) {
		char[] c = new char[bytes.length * 2];
		int index = 0;
		for (byte b : bytes) {
			c[index++] = HEX_DIGITS[(b >> 4) & 0xf];
			c[index++] = HEX_DIGITS[b & 0xf];
		}
		return new String(c);
	}

}
