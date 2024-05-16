package co.com.flamingo.canopus.test;

import co.com.flamingo.canopus.principal.Core;

public class Test {
	public static void main(String[] args) {
		Core core = new Core("172.16.8.205");
		String response = core.getCustomer("71746198|123|00004|0005|0001|20190830|143000|null|null|");
		String responseRewards = core.getRewards("71682911|hcastaneda|00024|0099|0001|20190904|074200|770158112116,24990,1,0061,0~770211301270,11200,1,0094,0|11,10000~MFIA,10000|null|");

		System.out.println("Respueta Cliente: " + response);
		System.out.println("Respueta Rewards: " + responseRewards);

	}
}
