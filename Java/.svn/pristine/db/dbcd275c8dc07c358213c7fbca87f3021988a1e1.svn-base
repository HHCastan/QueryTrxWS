package com.linea.sig.util;

import java.util.StringTokenizer;
import java.util.Vector;

public class Tokens {

	public Tokens() {
	}

	public static Vector createTokens(String cad, String delmit, boolean returnDelmit) throws Exception {
		Vector tokens = new Vector();
		StringTokenizer token = new StringTokenizer(cad, delmit, returnDelmit);
		int a = 1;
		for (int tok = token.countTokens(); a <= tok; a++)
			tokens.addElement(token.nextToken());

		return tokens;
	}
}