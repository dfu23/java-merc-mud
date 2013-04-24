package merc.types;

public class LiquidType {

	String liq_name;
	String liq_color;
	short[] liq_affect;
	
	public LiquidType(String name, String color, short[] affect) {
		this.liq_name = name;
		this.liq_color = color;
		this.liq_affect = affect;
	}
	
}
