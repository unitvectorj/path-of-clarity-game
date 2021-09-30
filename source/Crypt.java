// Path of Clarity: Crypt

import java.math.BigInteger;
import java.util.Random;

public class Crypt {
	public BigInteger n;
	public BigInteger e;
	public BigInteger d;
	
	public Crypt(String p, String q) {
		BigInteger pee = new BigInteger(p);
		BigInteger que = new BigInteger(q);
		this.n = pee.multiply(que);
		this.e = generateE(pee,que);
		this.d = generateD(this.e, totient(pee,que));
	}
	public BigInteger totient(BigInteger p, BigInteger q) {
		BigInteger totient = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
		return totient;
	}
	public BigInteger generateE(BigInteger p, BigInteger q) {
		Random r = new Random();
		BigInteger guess = new BigInteger("" + r.nextInt(totient(p,q).intValue()));
		BigInteger eg = guess.nextProbablePrime();
		while (eg.intValue() >= totient(p,q).intValue())
			generateE(p,q);
		return eg;
	}
	public BigInteger generateD(BigInteger e, BigInteger totient) {
		BigInteger gen = new BigInteger("0");
		for (int d = 1; d<=totient.intValue(); d++) {
			if ((this.e.intValue()*d)%totient.intValue() == 1) {
				
				gen = new BigInteger("" + d);
				break;
			}
		}
		return gen;
	}
	public String encrypt(String message) {
		char[] chars = message.toCharArray();
		for (int i = 0;i<chars.length;i++) {
			int c = (int)chars[i];
			BigInteger cee = new BigInteger("" + c);
			cee = cee.modPow(this.e, this.n);
			chars[i] = (char)cee.intValue();
		}
		String output = new String(chars);
		return output;
	}
	
}