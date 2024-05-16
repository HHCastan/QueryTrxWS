package com.lds.tests;

import java.util.StringTokenizer;

public class Test {
	
	public Test(String replace) {
		String[] rows = getTokens(replace, "~");
		StringBuffer regs = new StringBuffer();
		String regLine = "Line = #PlanPagos";
		String idParam = "#PlanPagos";
		String resultado = "";

		for (int j = 0; j < rows.length; j++) {
			System.out.println(rows[j]);
			System.out.println(regLine);
			String[] values = getTokens(rows[j], ";");

			for (int k = 0; k < values.length; k++) {
				System.out.println(values[k]);
				resultado = resultado.concat(values[k] + "\t");
				//regLine = regLine.replaceFirst(idParam, values[k]);
			}
			resultado = resultado.concat("|\r\nLine = ");
		}
		regLine = regLine.replaceFirst(idParam, resultado);
		regs.append(regLine);
		regs.append("|\r\n");
		replace = regs.toString();
		System.out.println(replace);
	}
	
	private String[] getTokens(String str, String delim) {

		StringTokenizer tokenizer = new StringTokenizer(str, delim);

		String tokens[] = new String[tokenizer.countTokens()];
		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = tokenizer.nextToken();
		}
		return tokens;
	}

	public static void main(String[] args) {
		
		Test prueba = new Test("1;1;1140;1000;11400;11400~2;2;221400;2000;21400;21400~3;3;331400;300;31400;3331400");
		System.out.println(prueba);
		
	}
}
